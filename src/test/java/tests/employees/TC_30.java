package tests.employees;

import dao.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.Base.BaseTest;

public class TC_30 extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(TC_30.class);
    private EmployeeDao employeeDao;

    @BeforeMethod
    public void setupDao() {
        log.info("Setting up DAO");
        employeeDao = new EmployeeDao(connection);
    }

    @Test
    public void testFindLongestWorkedDepartment() {
        log.info("Running test");

        String deptName = employeeDao.findLongestWorkedDepartment(10102);

        Assert.assertNotNull(deptName,  "Department name should not be null");
        log.info("Longest worked department: " + deptName);
        log.info("Test finished successfully");
    }
}
