package dao;

import model.DepartmentEmployeeSalaryDto;
import model.DepartmentSalaryDto;
import model.EmployeeSalaryDto;
import utils.SqlLoader;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDao {

    private final Connection connection;

    private final String TC_08_09 = "sql/TC_08_09.sql";
    private final String TC_14 = "sql/TC_14.sql";
    private final String TC_15 = "sql/TC_15.sql";

    private final String TC_23 = "sql/TC_23.sql";

    public DepartmentDao(Connection connection) {
        this.connection = connection;
    }

    public List<DepartmentSalaryDto> avgSalaryEachDept() {
        String sql = SqlLoader.loadSql(TC_08_09);

        List<DepartmentSalaryDto> result = new ArrayList<>();

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                DepartmentSalaryDto dto = new DepartmentSalaryDto();

                dto.setDept_no(rs.getString("dept_no"));
                dto.setDept_name(rs.getString("dept_name"));
                dto.setAverage_salary(rs.getDouble("average_salary"));

                result.add(dto);
            }
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Map<String, Integer> getEmployeeCountPerDepartment() {
        String sql = SqlLoader.loadSql(TC_23);
        Map<String, Integer> result = new HashMap<>();

        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                result.put(
                        rs.getString("dept_name"),
                        rs.getInt("employee_count")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } return result;
    }

    public List<EmployeeSalaryDto> listHighestSalEmpByDeptName(String dept_name) {
        String sql = SqlLoader.loadSql(TC_14);
        List<EmployeeSalaryDto> result = new ArrayList<>();

        try (PreparedStatement ps = connection.prepareStatement(sql)){

            ps.setString(1,dept_name);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                EmployeeSalaryDto dto = new EmployeeSalaryDto();

                dto.setFull_name(rs.getString("full_name"));
                dto.setSalary(rs.getInt("salary"));

                result.add(dto);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    public DepartmentEmployeeSalaryDto findAvgHighSalaryByDeptName(String dept_name) {
        String sql = SqlLoader.loadSql(TC_15);

        try (PreparedStatement ps = connection.prepareStatement(sql)){

            DepartmentEmployeeSalaryDto dto = new DepartmentEmployeeSalaryDto();

            ps.setString(1, dept_name);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                dto.setFull_name(rs.getString("full_name"));
                dto.setAvg_salary(rs.getDouble("avg_salary"));

                return dto;
            }

            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
