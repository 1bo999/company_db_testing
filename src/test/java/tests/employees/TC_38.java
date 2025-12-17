package tests.employees;

import dao.EmployeeDao;
import model.Employee;
import model.EmployeeDurationDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.Base.BaseTest;

import java.util.List;

public class TC_38 extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(TC_38.class);
    private EmployeeDao employeeDao;

    @BeforeMethod
    public void setUpDao() {
        log.info("Setting up Dao");
        employeeDao = new EmployeeDao(connection);
    }

    @Test
    public void test() {
        String dept_no = "d005";

        log.info("Running test");

        List<Employee> result = employeeDao.managerNameByDeptNo(dept_no);

        Assert.assertFalse(result.isEmpty());
        Assert.assertFalse(result.getFirst().getFirstName().isEmpty(),
                "First employee first name is empty");
        Assert.assertFalse(result.getFirst().getLastName().isEmpty(),
                "First employee last name is empty");

        log.info("TC_38 test run successful");
    }
}
