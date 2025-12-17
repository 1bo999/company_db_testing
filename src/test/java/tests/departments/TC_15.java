package tests.departments;

import dao.DepartmentDao;
import model.DepartmentEmployeeSalaryDto;
import model.EmployeeSalaryDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.Base.BaseTest;

import java.util.List;

public class TC_15 extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(TC_15.class);
    private DepartmentDao departmentDao;

    @BeforeMethod
    public void setUpDao() {
        log.info("Setting up Dao");
        departmentDao = new DepartmentDao(connection);
    }

    @Test
    public void test() {
        String dept_name = "Research";

        log.info("Running test");

        DepartmentEmployeeSalaryDto result = departmentDao.findAvgHighSalaryByDeptName(dept_name);

        Assert.assertFalse(result.getFull_name().isEmpty(), "full_name column is empty");
        Assert.assertFalse(result.getAvg_salary() <= 0, "avg_salary is 0 or neegative");

        log.info("TC_15 test run successfully");
    }
}
