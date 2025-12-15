package tests.salaries;

import dao.SalaryDao;
import model.Salary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.Base.BaseTest;

public class TC_03 extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(TC_03.class);
    private SalaryDao salaryDao;

    @BeforeMethod
    public void setUpDao () {
        log.info("Setting up  DAO");
        salaryDao = new SalaryDao(connection);
    }

    @Test
    public void test() {

        log.info("Running test");

        double salary = salaryDao.avgSalaryEmployees();

        Assert.assertTrue(salary > 0, "Average salary should be greater than 0");

        log.info("TC_03 test finished successfully");
    }
}
