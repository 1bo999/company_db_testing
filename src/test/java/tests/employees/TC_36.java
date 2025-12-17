package tests.employees;

import dao.EmployeeDao;
import model.EmployeeDurationDto;
import model.EmployeeSalaryDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.Base.BaseTest;

import java.util.List;

public class TC_36 extends BaseTest {
    private static final Logger log = LoggerFactory.getLogger(TC_36.class);
    private EmployeeDao employeeDao;

    @BeforeMethod
    public void setUpDao() {
        log.info("Setting up Dao");
        employeeDao = new EmployeeDao(connection);
    }

    @Test
    public void test() {

        log.info("Running test");

        List<EmployeeDurationDto> result = employeeDao.findDurationEachEmployee();

        Assert.assertFalse(result.isEmpty());
        Assert.assertFalse(result.getFirst().getFirstName().isEmpty(),
                "First employee first name is empty");
        Assert.assertTrue(result.getFirst().getEmpNo() >= 0,
                "First employee number is 0 or negative");

        log.info("TC_36 test run successful");
    }
}
