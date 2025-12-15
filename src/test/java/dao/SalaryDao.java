package dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.SqlLoader;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SalaryDao {

    private static final Logger log = LoggerFactory.getLogger(SalaryDao.class);
    private final Connection connection;

    public SalaryDao(Connection connection) {
        this.connection = connection;
    }

    private final String TC_03 = "sql/TC_03.sql";

    public double avgSalaryEmployees() {
        String sql = SqlLoader.loadSql(TC_03);

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    log.info("Average salary: " + rs.getDouble("average_salary"));
                    return rs.getDouble("average_salary");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }
}
