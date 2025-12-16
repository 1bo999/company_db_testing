package tests.employees;

import dao.EmployeeDao;
import model.EmployeeHireSalaryDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.Base.BaseTest;

import java.util.List;

public class TC_20 extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(TC_20.class);
    private EmployeeDao employeeDao;

    @BeforeMethod
    public void setupDao() {
        log.info("Setting up DAO");

        employeeDao = new EmployeeDao(connection);
    }

    @Test
    public void testSalesEmployeesHiredBetween1985And1989() {
        log.info("Running test");

        List<EmployeeHireSalaryDTO> result =
                employeeDao.findSalesEmployeesHiredBetween1985And1989();

        Assert.assertFalse(result.isEmpty(),
                "Sales employees list should not be empty");

        EmployeeHireSalaryDTO first = result.getFirst();
        Assert.assertTrue(first.getSalary() > 0,
                "Salary should be greater than 0");
        log.info("Test finished successfully");
    }
}