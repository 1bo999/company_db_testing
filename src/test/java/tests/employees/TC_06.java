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

public class TC_06 extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(TC_06.class);
    private EmployeeDao employeeDao;

    @BeforeMethod
    public void setUpDao() {
        log.info("Setting up  DAO");
        employeeDao = new EmployeeDao(connection);
    }

    @Test
    public void test() {
        String dept_name = "Sales";
        int minSalary = 70000;

        log.info("Running test");

        List<EmployDepartSalaryDto> result =
                employeeDao.listEmployeeByDeptName(dept_name,minSalary);

        Assert.assertEquals(
                result.getFirst().getDeptName(), dept_name,
                "First Employee with department name did not match");
        Assert.assertFalse(result.getFirst().getSalary() < minSalary,
                "First First Employee with salary did not match");

        for (EmployDepartSalaryDto edsd: result) {
            System.out.println(edsd);
        }

        log.info("TC_06 test finished successfully");
    }
}
