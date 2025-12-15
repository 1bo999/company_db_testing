package tests.employees;

import dao.EmployeeDao;
import model.EmployeeDepartmentDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.Base.BaseTest;

import java.util.List;

//                                                          LOGGER ⚠️⚠️⚠️⚠️
public class TC_02 extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(TC_02.class);
    private EmployeeDao employeeDao;

    @BeforeMethod
    public void setUpDao() {
        log.info("Setting up  DAO");
        employeeDao = new EmployeeDao(connection);
    }

    @Test
    public void test() {
        String deptName = "Human Resources";

        log.info("Running test");

        List<EmployeeDepartmentDto> eddDto = employeeDao.findEmpByDepartName(deptName);

        Assert.assertFalse(eddDto.isEmpty(),
                "No Employee found with dept_name: " + deptName);

        Assert.assertEquals(eddDto.getFirst().getDept_name(), deptName,
                "First employee with dept_name: " + eddDto.getFirst().getDept_name()
                        + "does not match dept_name: " + deptName);

        log.info("TC_02 test finished successfully");
    }
}
