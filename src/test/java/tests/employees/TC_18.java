package tests.employees;

import dao.EmployeeDao;
import model.EmployeeHireDateDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.Base.BaseTest;

import java.util.List;

public class TC_18 extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(TC_18.class);
    private EmployeeDao employeeDao;

    @BeforeMethod
    public void setupDao() {
        log.info("Setting up DAO");

        employeeDao= new EmployeeDao(connection);
    }

    @Test
    public void testEmployeesHiredBefore1990() {
        log.info("Running test");

        List<EmployeeHireDateDTO> result =
                employeeDao.findEmployeesHiredBefore1990();

        Assert.assertFalse(result.isEmpty(),
                "Employee list should not be empty");

        Assert.assertTrue(
                result.getFirst().getHireDate().isBefore(
                        java.time.LocalDate.of(1990, 1, 1)
                ));
        log.info("TC_18 test finished successfully");
    }
}
