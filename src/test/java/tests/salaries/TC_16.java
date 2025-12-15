package tests.salaries;

import dao.EmployeeDao;
import dao.SalaryDao;
import model.DepartmentTopSalaryDTO;
import model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.Base.BaseTest;

import java.sql.SQLException;
import java.util.List;

public class TC_16 extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(TC_16.class);
    private SalaryDao salaryDao;

    @BeforeMethod
    public void setupDao(){
        log.info("Setting up DAO");

        salaryDao= new SalaryDao(connection);
    }

    @Test
    public void testFindHighestSalaryPerDepartment() {
        log.info("Running test");

            List<DepartmentTopSalaryDTO> list = salaryDao.findHighestSalaryPerDepartment();

            Assert.assertFalse(list.isEmpty());
            Assert.assertTrue(list.getFirst().getPeakSalary() > 0);

        log.info("TC_16 test finished successfully");
    }
}
