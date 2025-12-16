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

public class TC_29 extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(TC_29.class);
    private EmployeeDao employeeDao;

    @BeforeMethod
    public void setupDao() {
        log.info("Setting up DAO");
        employeeDao = new EmployeeDao(connection);
    }

    @Test
    public void testFindSalesManagers() {
        log.info("Running test");

        List<EmployeeRoleDto> result = employeeDao.findSalesManagers();

        Assert.assertFalse(result.isEmpty(),
                "Sales managers list should not be empty");

        EmployeeRoleDto dto = result.get(0);

        Assert.assertEquals(dto.getRole(), "Manager", "Role should be Manager");
        log.info("Test finished successfully");
    }
}
