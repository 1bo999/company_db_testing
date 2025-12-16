package tests.employees;

import dao.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.Base.BaseTest;

import java.util.Map;

public class TC_21 extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(TC_21.class);
    private EmployeeDao employeeDao;

    @BeforeMethod
    public void setupDao() {
        log.info("Setting up DAO");

        employeeDao = new EmployeeDao(connection);
    }

    @Test
    public void testEmployeeCountByGender() {
        log.info("Running test");

        Map<String, Integer> result =
                employeeDao.countEmployeesByGender();

        Assert.assertFalse(result.isEmpty());
        int maleCount = result.get("M");
        int femaleCount = result.get("F");

        Assert.assertTrue(maleCount > 0);
        Assert.assertTrue(femaleCount > 0);

        int total = maleCount + femaleCount;
        Assert.assertTrue(total > 0);
        log.info("Test finished successfully");
    }
}
