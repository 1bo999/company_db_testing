package dao;

import model.DepartmentHighestAvgSalaryDTO;
import model.DepartmentTopSalaryDTO;
import model.EmployeeSalaryDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.SqlLoader;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SalaryDao {

    private static final Logger log = LoggerFactory.getLogger(SalaryDao.class);
    private final Connection connection;

    public SalaryDao(Connection connection) {
        this.connection = connection;
    }

    private final String TC_03 = "sql/TC_03.sql";
    private final String TC_04 = "sql/TC_04_05.sql";

    private final String TC_16 = "sql/TC_16.sql";
    private final String TC_17 = "sql/TC_17.sql";
    private final String TC_31 = "sql/TC_31.sql";


    public double avgSalaryEmployees() {
        String sql = SqlLoader.loadSql(TC_03);

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    log.info("Average salary: {}", rs.getDouble("average_salary"));
                    return rs.getDouble("average_salary");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    public double avgSalaryByGender(String gender) {
        String sql = SqlLoader.loadSql(TC_04);

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            String gen = gender.toUpperCase();
            ps.setString(1,gen);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    log.info("Average salary by gender " + "("+gender+")" + ": {}",
                            rs.getDouble("average_salary"));

                    return rs.getDouble("average_salary");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    public List<DepartmentTopSalaryDTO> findHighestSalaryPerDepartment() {
        String sql = SqlLoader.loadSql(TC_16);
        List<DepartmentTopSalaryDTO> result = new ArrayList<>();

        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                result.add(
                        new DepartmentTopSalaryDTO(
                                rs.getString("dept_name"),
                                rs.getString("first_name"),
                                rs.getString("last_name"),
                                rs.getInt("peak_salary")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public List<DepartmentHighestAvgSalaryDTO> findHighestAvgSalaryPerDepartment() {
        String sql = SqlLoader.loadSql(TC_17);
        List<DepartmentHighestAvgSalaryDTO> list = new ArrayList<>();

        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(new DepartmentHighestAvgSalaryDTO(
                        rs.getString("dept_name"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getDouble("avg_salary")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public EmployeeSalaryDto findHighestPaidEmployeeInD004() {

        String sql = SqlLoader.loadSql(TC_31);

        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                EmployeeSalaryDto dto = new EmployeeSalaryDto();

                dto.setEmp_no(rs.getInt("emp_no"));
                dto.setFirstName(rs.getString("first_name"));
                dto.setLastName(rs.getString("last_name"));
                dto.setSalary(rs.getDouble("salary"));

                return dto;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }
}
