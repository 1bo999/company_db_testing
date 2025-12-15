package tests.salaries;

import dao.SalaryDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.Base.BaseTest;

public class TC_04 extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(TC_04.class);
    private SalaryDao salaryDao;

    @BeforeMethod
    public void setUpDao() {
        log.info("Setting up Dao");
        salaryDao = new SalaryDao(connection);
    }

    @Test
    public void test() {
        log.info("Running test");

        double avgSalary = salaryDao.avgSalaryByGender("f");

        log.info("TC_04 test finished successfully");

        Assert.assertTrue(avgSalary > 0,
                "Average salary should be greater than zero");

        log.info("TC_04 test finished successfully");
    }
}
