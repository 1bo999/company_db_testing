package tests.employees;

import dao.EmployeeDao;
import model.EmployeeSalaryDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.Base.BaseTest;

import java.util.List;

public class TC_10 extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(TC_10.class);
    private EmployeeDao employeeDao;

    @BeforeMethod
    public void setUpDao() {
        log.info("Setting up Dao");
        employeeDao = new EmployeeDao(connection);
    }

    @Test
    public void test() {
        int emp_no = 10102;

        log.info("Running test");

        List<EmployeeSalaryDto> result = employeeDao.findAllSalaryChangeByEmpNo(emp_no);

        Assert.assertFalse(result.isEmpty(), "Result is empty");
        Assert.assertNotEquals(result.getFirst().getSalary(), 0, "Salary is 0");

        log.info("TC_10 test finished successfully");
    }
}
