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

public class TC_19 extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(TC_19.class);
    private EmployeeDao employeeDao;

    @BeforeMethod
    public void setupDao() {
        log.info("Setting up DAO");

        employeeDao = new EmployeeDao(connection);
    }

    @Test
    public void testEmployeesHiredBetween1985And1989() {
        log.info("Running test");

        List<Employee> list =
                employeeDao.findEmployeesHiredBetween1985And1989();

        Assert.assertFalse(list.isEmpty());
        log.info("TC_19 test finished successfully");
    }
}