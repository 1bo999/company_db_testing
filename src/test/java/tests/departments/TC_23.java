package tests.departments;

import dao.DepartmentDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.Base.BaseTest;

import java.util.Map;

public class TC_23 extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(TC_23.class);
    private DepartmentDao departmentDao;

    @BeforeMethod
    public void setupDao() {
        log.info("Setting up DAO");

        departmentDao = new DepartmentDao(connection);
    }

    @Test
    public void testEmployeeCountPerDepartment() {
        log.info("Running test");

        Map<String, Integer> result =
                departmentDao.getEmployeeCountPerDepartment();
        Assert.assertFalse(result.isEmpty(), "Department employee count map should not be empty");

        boolean hasEmployee = false;

        for (Integer count : result.values()) {
            if (count > 0) {
                hasEmployee = true;
                break;
            }
        }
        Assert.assertTrue(hasEmployee, "At least one department should have employees");
        log.info("Test finished successfully");
    }
}

