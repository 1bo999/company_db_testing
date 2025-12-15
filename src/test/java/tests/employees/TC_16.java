package tests.employees;

import dao.EmployeeDao;
import model.DepartmentTopSalaryDTO;
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
    private EmployeeDao employeeDao;

    @BeforeMethod
    public void setupDao(){
        log.info("Setting up DAO");

        employeeDao= new EmployeeDao(connection);
    }

    @Test
    public void testFindHighestSalaryPerDepartment() throws SQLException {
        log.info("Running test");

        List<DepartmentTopSalaryDTO> result = employeeDao.findHighestSalary();
        Assert.assertFalse(result.isEmpty(),
                "Highest salary per department list should not be empty");

        DepartmentTopSalaryDTO dto = result.getFirst();
        Assert.assertTrue(dto.getPeakSalary() > 0,
                "Peak salary should be greater than 0");

        log.info("TC_16 test finished successfully");
    }
}
