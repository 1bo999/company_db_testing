package dao;

import model.Employee;
import model.EmployeeDepartmentDto;
import utils.SqlLoader;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {

    private final Connection connection;

    private final String TC_01 = "sql/TC_01.sql";
    private final String TC_02 = "sql/TC_02.sql";

    public EmployeeDao(Connection connection) {
        this.connection = connection;
    }

    public List<Employee> findEmployeeByDeptNo(String deptNo) throws SQLException {
        String sql = SqlLoader.loadSql(TC_01);
        List<Employee> employees = new ArrayList<>();

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, deptNo);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    employees.add(rowToEmployee(rs));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employees;
    }

    private Employee rowToEmployee(ResultSet rs) throws SQLException {
        Employee employee = new Employee();

        employee.setEmp_no(rs.getInt("emp_no"));
        employee.setBirth_date(rs.getDate("birth_date").toLocalDate());
        employee.setFirstName(rs.getString("first_name"));
        employee.setLastName(rs.getString("last_name"));
        employee.setGender(rs.getString("gender"));
        employee.setHire_date(rs.getDate("hire_date").toLocalDate());
        employee.setDept_no(rs.getString("dept_no"));

        return employee;
    }

    public List<EmployeeDepartmentDto> findEmpByDepartName(String dept_name) {
        String sql = SqlLoader.loadSql(TC_02);
        List<EmployeeDepartmentDto> empDept = new ArrayList<>();

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, dept_name);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    empDept.add(rowToEmployeeDepartment(rs));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return empDept;
    }

    private EmployeeDepartmentDto rowToEmployeeDepartment(ResultSet rs) throws SQLException {

        EmployeeDepartmentDto eddDto = new EmployeeDepartmentDto();

        eddDto.setFirstName(rs.getString("first_name"));
        eddDto.setLastName(rs.getString("last_name"));
        eddDto.setEmp_no(rs.getInt("emp_no"));
        eddDto.setDept_name(rs.getString("dept_name"));
        eddDto.setDept_no(rs.getString("dept_no"));

        return eddDto;
    }
}
