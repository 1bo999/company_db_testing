package tests.employees;

import dao.EmployeeDao;
import model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.Base.BaseTest;

public class TC_12 extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(TC_12.class);
    private EmployeeDao employeeDao;

    @BeforeMethod
    public void setUpDao() {
        log.info("Setting up Dao");
        employeeDao = new EmployeeDao(connection);
    }

    @Test
    public void test() {

        log.info("Running test");

        Employee result = employeeDao.employeeWithHighestSal();

        Assert.assertFalse(result.getFirstName().isEmpty());

        log.info("Test Run successfully");
    }
}
