package tests.employees;

import dao.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.Base.BaseTest;

public class TC_33 extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(TC_33.class);
    private EmployeeDao employeeDao;

    @BeforeMethod
    public void setupDao() {
        log.info("Setting up DAO");
        employeeDao = new EmployeeDao(connection);
    }

    @Test
    public void testAverageEmployeeAge() {
        log.info("Running test");

        double avgAge = employeeDao.findAverageEmployeeAge();

        Assert.assertTrue(avgAge > 0, "Average age should be greater than 0");
        log.info("Average employee age: "+ avgAge);
        log.info("Test finished successfully");
    }
}
