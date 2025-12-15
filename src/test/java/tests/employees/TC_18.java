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

public class TC_18 extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(TC_18.class);
    private EmployeeDao employeeDao;

    @BeforeMethod
    public void setupDao() {
        log.info("Setting up DAO");

        employeeDao= new EmployeeDao(connection);
    }

    @Test
    public void testEmployeesHiredBefore1990() {
        log.info("Running test");

            List<Employee> list = employeeDao.findEmployeesHiredBefore1990();

            Assert.assertFalse(list.isEmpty());

        log.info("TC_18 test finished successfully");
    }
}
