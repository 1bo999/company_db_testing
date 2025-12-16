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

public class TC_32 extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(TC_32.class);
    private EmployeeDao employeeDao;

    @BeforeMethod
    public void setupDao() {
        log.info("Setting up DAO");
        employeeDao = new EmployeeDao(connection);
    }
    @Test
    public void testEmployeeTitleHistory() {
        log.info("Running test");
        int empNo = 10001;

        List<EmployeeRoleDto> result = employeeDao.findEmployeeTitleHistory(empNo);

        Assert.assertFalse(result.isEmpty(), "Employee title history should not be empty");
        Assert.assertEquals(result.getFirst().getEmp_no(), empNo);
        log.info("Test finished successfully");
    }
}
