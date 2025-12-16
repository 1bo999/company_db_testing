package dao;

import model.Department;
import model.DepartmentSalaryDto;
import model.EmployDepartSalaryDto;
import utils.SqlLoader;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDao {

    private final Connection connection;

    private final String TC_08 = "sql/TC_08.sql";

    public DepartmentDao(Connection connection) {
        this.connection = connection;
    }

    public List<DepartmentSalaryDto> avgSalaryEachDept() {
        String sql = SqlLoader.loadSql(TC_08);

        List<DepartmentSalaryDto> result = new ArrayList<>();

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                DepartmentSalaryDto dto = new DepartmentSalaryDto();

                dto.setDept_no(rs.getString("dept_no"));
                dto.setAverage_salary(rs.getDouble("average_salary"));

                result.add(dto);
            }
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
