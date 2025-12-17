package tests.salaries;

import dao.SalaryDao;
import model.EmployeeSalaryDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.Base.BaseTest;

public class TC_31 extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(TC_31.class);
    private SalaryDao salaryDao;

    @BeforeMethod
    public void setupDao() {
        log.info("Setting up DAO");
        salaryDao = new SalaryDao(connection);
    }

    @Test
    public void testHighestPaidEmployeeInD004() {
        log.info("Running test");

        EmployeeSalaryDto result =
                salaryDao.findHighestPaidEmployeeInD004();

        Assert.assertNotNull(result, "Result should not be null");
        Assert.assertTrue(result.getSalary() > 0, "Salary should be greater than 0");

        log.info("Highest salary in D004: {}", result);
        log.info("Test finished successfully");
    }
}
