package tests.employees;

import dao.EmployeeDao;
import model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.Base.BaseTest;

import java.util.List;

public class TC_24 extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(TC_22.class);
    private EmployeeDao employeeDao;

    @BeforeMethod
    public void setupDao() {
        log.info("Setting up DAO");

        employeeDao = new EmployeeDao(connection);
    }

    @Test
    public void testEmployeesHiredInLast5YearsFrom1990() {
        log.info("Running test");
        List<Employee> result =
                employeeDao.findEmployeesHiredInLast5YearsFrom1990();

        Assert.assertFalse(result.isEmpty(),
                "Employee list should not be empty");
        log.info("Test finished successfully");
    }
}
