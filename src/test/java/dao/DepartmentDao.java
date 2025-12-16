package dao;

import model.Department;
import utils.SqlLoader;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class DepartmentDao {

    private final Connection connection;

    private static final String INSERT_DEPARTMENT = "sql/departments/insert.sql";

    private final String TC_23 = "sql/TC_23.sql";

    public DepartmentDao(Connection connection) {
        this.connection = connection;
    }

    public Department insertDepartment(Department department) {
        String sql = SqlLoader.loadSql(INSERT_DEPARTMENT);

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, department.getDept_no());
            ps.setString(2, department.getName());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return department;
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

}
