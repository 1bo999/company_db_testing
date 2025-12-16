package tests.employees;

import dao.EmployeeDao;
import model.EmployDepartSalaryDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.Base.BaseTest;

import java.util.List;

public class TC_07 extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(TC_07.class);
    private EmployeeDao employeeDao;

    @BeforeMethod
    public void setUpDao() {
        log.info("Setting up Dao");
        employeeDao = new EmployeeDao(connection);
    }

    @Test
    public void test() {
        String dept_name = "Sales";
        int minSalary = 50000;
        int maxSalary = 100000;

        log.info("Running test");

        List<EmployDepartSalaryDto> result =
                employeeDao.listEmpByDeptMinMaxSalary(dept_name, minSalary, maxSalary);

        Assert.assertEquals(
                result.getFirst().getDeptName(), dept_name,
                "First employee with department name didn't match");

        Assert.assertNotEquals(
                result.getFirst().getSalary(), 0,
                "First employee's salary is equal to 0");

        Assert.assertFalse(
                result.getFirst().getSalary() < minSalary,
                "First employee's salary is smaller than the min Salary request"
        );

        Assert.assertFalse(
                result.getFirst().getSalary() > maxSalary,
                "First employee's salary is greater than the max Salary request"
        );

        log.info("TC_07 test finished successfully");
    }
}
