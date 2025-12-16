package tests.employees;

import dao.EmployeeDao;
import model.DepartmentEmployeeCountDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.Base.BaseTest;

import java.util.List;

public class TC_34 extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(TC_34.class);
    private EmployeeDao employeeDao;

    @BeforeMethod
    public void setupDao() {
        log.info("Setting up DAO");
        employeeDao = new EmployeeDao(connection);
    }

    @Test
    public void testEmployeeCountPerDepartment() {
        log.info("Running test");
        List<DepartmentEmployeeCountDTO> result =
                employeeDao.findEmployeeCountPerDepartment();

        Assert.assertFalse(result.isEmpty(), "Result should not be empty");
        Assert.assertTrue(result.getFirst().getEmployeeCount() > 0);
        log.info("Test finished successfully");
    }
}
