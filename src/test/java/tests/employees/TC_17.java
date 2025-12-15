package tests.employees;

import dao.EmployeeDao;
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
    private EmployeeDao employeeDao;

    @BeforeMethod
    public void setupDao() {
        log.info("Setting up DAO");

        employeeDao= new EmployeeDao(connection);
    }

    @Test
    public void testHighestAvgSalaryPerDepartment() {
        log.info("Running test");

        List<DepartmentHighestAvgSalaryDTO> result =
                employeeDao.findHighestAvgSalary();

        Assert.assertFalse(result.isEmpty(),
                "Result list should not be empty");

        DepartmentHighestAvgSalaryDTO dto = result.getFirst();
        Assert.assertTrue(dto.getAvgSalary() > 0,
                "Average salary should be greater than 0");
        log.info("TC_17 test finished successfully");
    }
}
