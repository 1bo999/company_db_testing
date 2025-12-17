package dao;

import model.Title;
import utils.SqlLoader;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TitleDao {

    private final Connection connection;

    public TitleDao(Connection connection) {
        this.connection = connection;
    }

    private final String TC_37 = "sql/TC_37.sql";

    public List<Title> latestTitlePerEmp(LocalDate to_date) {
        String sql = SqlLoader.loadSql(TC_37);

        List<Title> result = new ArrayList<>();

        try (PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setDate(1, Date.valueOf(to_date));
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Title dao = new Title();

                dao.setEmpNo(rs.getInt("emp_no"));
                dao.setTitle(rs.getString("title"));
                dao.setFromDate(rs.getDate("from_date").toLocalDate());
                dao.setToDate(rs.getDate("to_date").toLocalDate());

                result.add(dao);
            }

            return result;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
