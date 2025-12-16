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

public class TC_28 extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(TC_28.class);
    private EmployeeDao employeeDao;

    @BeforeMethod
    public void setupDao() {
        log.info("Setting up DAO");
        employeeDao = new EmployeeDao(connection);
    }

    @Test
    public void testEmployeesHiredAfterAndSalaryGreaterThan() {
        log.info("Running test");

        List<EmployeeSalaryDto> result =
                employeeDao.findEmployeesHiredAfterWithSalary(
                        LocalDate.of(1994, 2, 24),
                        50000);
        Assert.assertFalse(result.isEmpty(),
                "Result list should not be empty");

        EmployeeSalaryDto dto = result.getFirst();

        Assert.assertTrue(dto.getSalary() > 50000,  "Salary should be greater than 50000");
        log.info("Test finished successfully");
    }
}
