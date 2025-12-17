package dao;

import model.*;
import utils.SqlLoader;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeDao {

    private final Connection connection;

    private final String TC_01 = "sql/TC_01.sql";
    private final String TC_02 = "sql/TC_02.sql";
    private final String TC_06 = "sql/TC_06.sql";
    private final String TC_07 = "sql/TC_07.sql";
    private final String TC_10 = "sql/TC_10_11.sql";
    private final String TC_12 = "sql/TC_12.sql";
    private final String TC_13 = "sql/TC_13.sql";

    private final String TC_18 = "sql/TC_18.sql";
    private final String TC_19 = "sql/TC_19.sql";
    private final String TC_20 = "sql/TC_20.sql";
    private final String TC_21 = "sql/TC_21.sql";
    private final String TC_22 = "sql/TC_22.sql";
    private final String TC_24 = "sql/TC_24.sql";
    private final String TC_25 = "sql/TC_25.sql";
    private final String TC_26 = "sql/TC_26.sql";
    private final String TC_27 = "sql/TC_27.sql";
    private final String TC_28 = "sql/TC_28.sql";
    private final String TC_29 = "sql/TC_29.sql";
    private final String TC_30 = "sql/TC_30.sql";
    private final String TC_32 = "sql/TC_32.sql";
    private final String TC_34 = "sql/TC_34.sql";
    private final String TC_35 = "sql/TC_35.sql";


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

    public List<Employee> findEmployeesHiredBefore1990() {
        String sql = SqlLoader.loadSql(TC_18);
        List<Employee> list = new ArrayList<>();

        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(rowToEmployeeWithoutDept(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public List<Employee> findEmployeesHiredBetween1985And1989() {
        String sql = SqlLoader.loadSql(TC_19);
        List<Employee> list = new ArrayList<>();

        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(rowToEmployeeWithoutDept(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    private Employee rowToEmployeeWithoutDept(ResultSet rs) throws SQLException {
        Employee employee = new Employee();

        employee.setEmp_no(rs.getInt("emp_no"));
        employee.setBirth_date(rs.getDate("birth_date").toLocalDate());
        employee.setFirstName(rs.getString("first_name"));
        employee.setLastName(rs.getString("last_name"));
        employee.setGender(rs.getString("gender"));
        employee.setHire_date(rs.getDate("hire_date").toLocalDate());

        return employee;
    }

    public List<EmployeeHireSalaryDTO> findSalesEmployeesHiredBetween1985And1989() {
        String sql = SqlLoader.loadSql(TC_20);
        List<EmployeeHireSalaryDTO> result = new ArrayList<>();

        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                EmployeeHireSalaryDTO dto = new EmployeeHireSalaryDTO();

                dto.setFirstName(rs.getString("first_name"));
                dto.setLastName(rs.getString("last_name"));
                dto.setHireDate(rs.getDate("hire_date").toLocalDate());
                dto.setSalary(rs.getDouble("salary"));
                result.add(dto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public Map<String, Integer> countEmployeesByGender() {
        String sql = SqlLoader.loadSql(TC_21);
        Map<String, Integer> result = new HashMap<>();
        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                result.put(
                        rs.getString("gender"),
                        rs.getInt("total"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public Map<String, Integer> getUniqueNameAndDepartmentCounts() {
        String sql = SqlLoader.loadSql(TC_22);
        Map<String, Integer> result = new HashMap<>();

        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                result.put("uniqueFirstNames",
                        rs.getInt("unique_first_names"));
                result.put("departmentCount",
                        rs.getInt("department_count"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public List<Employee> findEmployeesHiredInLast5YearsFrom1990() {
        String sql = SqlLoader.loadSql(TC_24);
        List<Employee> result = new ArrayList<>();

        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                result.add(rowToEmployeeWithoutDept(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public Employee findEmployeeByFullName(String firstName, String lastName) {
        String sql = SqlLoader.loadSql(TC_25);
        Employee employee = null;

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    employee = rowToEmployeeWithoutDept(rs);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employee;
    }

    public EmployeeFullInfoDTO findEmployeeFullInfoByName(String firstName, String lastName) {
        String sql = SqlLoader.loadSql(TC_26);

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, firstName);
            ps.setString(2, lastName);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new EmployeeFullInfoDTO(
                            rs.getInt("emp_no"),
                            rs.getDate("birth_date").toLocalDate(),
                            rs.getString("first_name"),
                            rs.getString("last_name"),
                            rs.getString("gender"),
                            rs.getDate("hire_date").toLocalDate(),
                            rs.getDouble("salary"),
                            rs.getString("dept_name"),
                            rs.getString("title"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public List<EmployeeRoleDto> findEmployeesAndManagersByDept(String deptNo) {
        String sql = SqlLoader.loadSql(TC_27);
        List<EmployeeRoleDto> result = new ArrayList<>();

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, deptNo);
            ps.setString(2, deptNo);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    result.add(rowToEmployeeRole(rs));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    private EmployeeRoleDto rowToEmployeeRole(ResultSet rs) throws SQLException {

        EmployeeRoleDto dto = new EmployeeRoleDto();

        dto.setEmp_no(rs.getInt("emp_no"));
        dto.setFirstName(rs.getString("first_name"));
        dto.setLastName(rs.getString("last_name"));
        dto.setRole(rs.getString("role"));

        return dto;
    }

    public List<EmployeeSalaryDto> findEmployeesHiredAfterWithSalary(
            LocalDate hireDate, double minSalary) {

        String sql = SqlLoader.loadSql(TC_28);
        List<EmployeeSalaryDto> result = new ArrayList<>();

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setDate(1, Date.valueOf(hireDate));
            ps.setDouble(2, minSalary);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    result.add(rowToEmployeeSalary(rs));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    private EmployeeSalaryDto rowToEmployeeSalary(ResultSet rs) throws SQLException {
        EmployeeSalaryDto dto = new EmployeeSalaryDto();

        dto.setEmp_no(rs.getInt("emp_no"));
        dto.setFull_name(rs.getString("full_name"));
        dto.setSalary(rs.getInt("salary"));
        return dto;
    }

    public List<EmployeeRoleDto> findSalesManagers() {
        String sql = SqlLoader.loadSql(TC_29);
        List<EmployeeRoleDto> result = new ArrayList<>();

        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                EmployeeRoleDto dto = new EmployeeRoleDto();

                dto.setEmp_no(rs.getInt("emp_no"));
                dto.setFirstName(rs.getString("first_name"));
                dto.setLastName(rs.getString("last_name"));
                dto.setRole("Manager");
                result.add(dto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public String findLongestWorkedDepartment(int empNo) {
        String sql = SqlLoader.loadSql(TC_30);

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("dept_name");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public List<EmployeeRoleDto> findEmployeeTitleHistory(int empNo) {
        String sql = SqlLoader.loadSql(TC_32);
        List<EmployeeRoleDto> result = new ArrayList<>();

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, empNo);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    result.add(rowToEmployeeTitle(rs));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    private EmployeeRoleDto rowToEmployeeTitle(ResultSet rs) throws SQLException {
        EmployeeRoleDto dto = new EmployeeRoleDto();

        dto.setEmp_no(rs.getInt("emp_no"));
        dto.setRole(rs.getString("title"));
        return dto;
    }

    public double findAverageEmployeeAge() {
        String sql = SqlLoader.loadSql("sql/TC_33.sql");
        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getDouble("avg_age");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    public List<DepartmentEmployeeCountDTO> findEmployeeCountPerDepartment() {
        String sql = SqlLoader.loadSql(TC_34);
        List<DepartmentEmployeeCountDTO> result = new ArrayList<>();

        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                result.add(
                        new DepartmentEmployeeCountDTO(
                                rs.getString("dept_name"),
                                rs.getInt("employee_count")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public List<Dept_emp> findManagerialHistory(int empNo) {
        String sql = SqlLoader.loadSql(TC_35);
        List<Dept_emp> result = new ArrayList<>();

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, empNo);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Dept_emp dm = new Dept_emp();

                    dm.setEmp_no(rs.getInt("emp_no"));
                    dm.setDept_no(rs.getString("dept_no"));
                    dm.setFrom_date(rs.getDate("from_date").toLocalDate());
                    dm.setTo_date(rs.getDate("to_date").toLocalDate());
                    result.add(dm);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public List<EmployDepartSalaryDto> listEmployeeByDeptName(String dept_name, int minSalary) {
        String sql = SqlLoader.loadSql(TC_06);
        List<EmployDepartSalaryDto> result = new ArrayList<>();

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, dept_name);
            ps.setInt(2, minSalary);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                result.add(rowToEmployeeWithSalary(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    private EmployDepartSalaryDto rowToEmployeeWithSalary(ResultSet rs) throws SQLException {

        EmployDepartSalaryDto dto = new EmployDepartSalaryDto();

        dto.setFirstName(rs.getString("first_name"));
        dto.setLastName(rs.getString("last_name"));
        dto.setDeptName(rs.getString("dept_name"));
        dto.setSalary(rs.getInt("salary"));

        return dto;
    }

    public List<EmployDepartSalaryDto> listEmpByDeptMinMaxSalary(String dept_name, int minSalary, int maxSalary) {
        String sql = SqlLoader.loadSql(TC_07);
        List<EmployDepartSalaryDto> result = new ArrayList<>();

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, dept_name);
            ps.setInt(2, minSalary);
            ps.setInt(3, maxSalary);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                result.add(rowToEmployeeWithSalary(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    public List<EmployeeSalaryDto> findAllSalaryChangeByEmpNo(int emp_no) {
        String sql = SqlLoader.loadSql(TC_10);
        List<EmployeeSalaryDto> result = new ArrayList<>();

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, emp_no);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                result.add(rowToEmployeeSalChange(rs));
            }

            return result;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private EmployeeSalaryDto rowToEmployeeSalChange(ResultSet rs) throws SQLException {
        EmployeeSalaryDto dto = new EmployeeSalaryDto();

        dto.setEmp_no(rs.getInt("emp_no"));
        dto.setFull_name(rs.getString("full_name"));
        dto.setSalary(rs.getInt("salary"));
        dto.setFrom_date(rs.getDate("from_date").toLocalDate());
        dto.setTo_date(rs.getDate("to_date").toLocalDate());

        return dto;
    }

    public Employee employeeWithHighestSal() {
        String sql = SqlLoader.loadSql(TC_12);

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();
            Employee model = new Employee();

            if (rs.next()) {

                model.setEmp_no(rs.getInt("emp_no"));
                model.setBirth_date(rs.getDate("birth_date").toLocalDate());
                model.setFirstName(rs.getString("first_name"));
                model.setLastName(rs.getString("last_name"));
                model.setGender(rs.getString("gender"));
                model.setHire_date(rs.getDate("hire_date").toLocalDate());
                model.setDept_no(rs.getString("dept_no"));
            }

            return model;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<EmployeeSalaryDto> findLatestSalariesEachEmployee(LocalDate date) {
        String sql = SqlLoader.loadSql(TC_13);
        List<EmployeeSalaryDto> result = new ArrayList<>();

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setDate(1, Date.valueOf(date));
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                EmployeeSalaryDto dto = new EmployeeSalaryDto();

                dto.setEmp_no(rs.getInt("emp_no"));
                dto.setFull_name(rs.getString("full_name"));
                dto.setSalary(rs.getInt("salary"));

                result.add(dto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }
}
