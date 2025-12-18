package tests.Base;

import io.qameta.allure.testng.AllureTestNg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
@Listeners({AllureTestNg.class})
public class BaseTest {

    private static final Logger log = LoggerFactory.getLogger(BaseTest.class);
    protected Connection connection;

    @BeforeClass
    public void setupConnection() throws SQLException {
        log.info("Setting up connection with database");

        Properties properties = getProperties();

        String url = properties.getProperty("db.url");
        String username = properties.getProperty("db.username");
        String password = properties.getProperty("db.password");

        connection = DriverManager.getConnection(url, username, password);
    }

    @AfterClass
    public void tearDownConnection() throws SQLException {
        log.info("Tearing down connection");
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    private Properties getProperties() {

        log.debug("Loading db.properties file from classpath");

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
