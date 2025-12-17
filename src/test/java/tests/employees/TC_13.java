package tests.employees;

import dao.EmployeeDao;
import model.EmployeeSalaryDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.Base.BaseTest;

import java.time.LocalDate;
import java.util.List;

public class TC_13 extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(TC_13.class);
    private EmployeeDao employeeDao;

    @BeforeMethod
    public void setUpDao() {
        log.info("Setting up Dao");
        employeeDao = new EmployeeDao(connection);
    }

    @Test
    public void test() {
        String dateSTR = "9999-01-01";
        LocalDate date = LocalDate.parse(dateSTR);

        log.info("Running test");

        List<EmployeeSalaryDto> result = employeeDao.findLatestSalariesEachEmployee(date);

        Assert.assertFalse(result.getFirst().getSalary() <= 0,
                "First employee salary result is zero");

        log.info("Test Run successfully");
    }
}
