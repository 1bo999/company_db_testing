package tests.employees;

import dao.EmployeeDao;
import model.EmployeeHireDateDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.Base.BaseTest;

import java.util.List;

public class TC_19 extends BaseTest {

    private static final Logger log =LoggerFactory.getLogger(TC_19.class);
    private EmployeeDao employeeDao;

    @BeforeMethod
    public void setupDao(){
        log.info("Setting up DAO");

        employeeDao= new EmployeeDao(connection);
    }

    @Test
    public void testEmployeesHiredBetween1985And1989() {
        List<EmployeeHireDateDTO> result =
                employeeDao.findEmployeesHiredBetween1985And1989();

        Assert.assertFalse(result.isEmpty(),
                "Employee list should not be empty");

        Assert.assertFalse(result.isEmpty());
    }
}