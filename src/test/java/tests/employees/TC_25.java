package tests.employees;

import dao.EmployeeDao;
import model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.Base.BaseTest;

public class TC_25 extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(TC_25.class);
    private EmployeeDao employeeDao;

    @BeforeMethod
    public void setupDao() {
        log.info("Setting up DAO");

        employeeDao = new EmployeeDao(connection);
    }

    @Test
    public void testFindEmployeeByFullName() {
        log.info("Running test");

        Employee employee =
                employeeDao.findEmployeeByFullName("Annemarie", "Redmiles");

        Assert.assertNotNull(employee);
        Assert.assertEquals(employee.getFirstName(), "Annemarie");
        Assert.assertEquals(employee.getLastName(), "Redmiles");
        log.info("Test finished successfully");
    }
}
