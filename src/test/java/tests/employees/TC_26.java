package tests.employees;

import dao.EmployeeDao;
import model.EmployeeFullInfoDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.Base.BaseTest;

public class TC_26 extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(TC_26.class);
    private EmployeeDao employeeDao;

    @BeforeMethod
    public void setupDao() {
        log.info("Setting up DAO");
        employeeDao = new EmployeeDao(connection);
    }

    @Test
    public void testFindEmployeeFullInfo() {
        log.info("Running test");

        EmployeeFullInfoDTO result =
                employeeDao.findEmployeeFullInfoByName("Annemarie", "Redmiles");
        Assert.assertNotNull(result, "Employee should exist");

        Assert.assertEquals(result.getFirstName(), "Annemarie");
        Assert.assertEquals(result.getLastName(), "Redmiles");
        Assert.assertTrue(result.getSalary() > 0);
        Assert.assertNotNull(result.getDeptName());
        Assert.assertNotNull(result.getTitle());

        log.info("Test finished successfully");
    }
}
