package tests.salaries;

import dao.EmployeeDao;
import dao.SalaryDao;
import model.DepartmentHighestAvgSalaryDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.Base.BaseTest;

import java.util.List;

public class TC_17 extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(TC_17.class);
    private SalaryDao salaryDao;

    @BeforeMethod
    public void setupDao() {
        log.info("Setting up DAO");

        salaryDao= new SalaryDao(connection);
    }

    @Test
    public void testHighestAvgSalaryPerDepartment() {
        log.info("Running test");

        List<DepartmentHighestAvgSalaryDTO> list =
                salaryDao.findHighestAvgSalaryPerDepartment();

        Assert.assertFalse(list.isEmpty());
        log.info("TC_17 test finished successfully");
    }
}
