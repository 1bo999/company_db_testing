package tests.employees;

import dao.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.Base.BaseTest;

import java.util.Map;

public class TC_22 extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(TC_22.class);
    private EmployeeDao employeeDao;

    @BeforeMethod
    public void setupDao() {
        log.info("Setting up DAO");

        employeeDao = new EmployeeDao(connection);
    }

    @Test
    public void testUniqueNameAndDepartmentCounts() {
        log.info("Running test");
        Map<String, Integer> result =
                employeeDao.getUniqueNameAndDepartmentCounts();

        Assert.assertFalse(result.isEmpty());
        Assert.assertTrue(result.get("uniqueFirstNames") > 0,
                "Unique first name count should be > 0");
        Assert.assertTrue(result.get("departmentCount") > 0,
                "Department count should be > 0");
        log.info("Test finished successfully");
    }
}
