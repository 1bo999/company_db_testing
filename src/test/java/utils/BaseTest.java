package utils;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class BaseTest {

    protected Connection connection;

    @BeforeClass
    public void setupConnection() throws SQLException {
        Properties properties = getProperties();

        String url = properties.getProperty("db.url");
        String username = properties.getProperty("db.username");
        String password = properties.getProperty("db.password");

        connection = DriverManager.getConnection(url, username, password);
    }

    @AfterClass
    public void tearDownConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    private Properties getProperties() {

        Properties properties = new Properties();
        try {
            InputStream inputStream =
                    getClass().getClassLoader().getResourceAsStream("db.properties");

            if (inputStream == null) {
                throw new RuntimeException("db.properties Not Found !");
            } else {
                properties.load(inputStream);
            }
        } catch (IOException e) {
            throw new RuntimeException("File loading error");
        }
        return properties;
    }
}
