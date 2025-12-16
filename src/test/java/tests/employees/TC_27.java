package tests.employees;

import dao.EmployeeDao;
import model.EmployeeRoleDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.Base.BaseTest;

import java.util.List;

public class TC_27 extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(TC_27.class);
    private EmployeeDao employeeDao;

    @BeforeMethod
    public void setupDao() {
        log.info("Setting up DAO");
        employeeDao = new EmployeeDao(connection);
    }

    @Test
    public void testEmployeesAndManagersInD005() {
        log.info("Running Test");

        List<EmployeeRoleDto> result =
                employeeDao.findEmployeesAndManagersByDept("d005");

        Assert.assertFalse(result.isEmpty(),
                "D005 department should have employees or managers");

        Assert.assertNotNull(result.getFirst().getRole());
        log.info("Test finished successfully");
    }
}
