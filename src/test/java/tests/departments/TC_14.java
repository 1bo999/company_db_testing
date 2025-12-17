package tests.departments;

import dao.DepartmentDao;
import model.DepartmentSalaryDto;
import model.EmployeeSalaryDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.Base.BaseTest;

import java.util.List;

public class TC_14 extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(TC_14.class);
    private DepartmentDao departmentDao;

    @BeforeMethod
    public void setUpDao() {
        log.info("Setting up Dao");
        departmentDao = new DepartmentDao(connection);
    }

    @Test
    public void test() {
        String dept_name = "Sales";

        log.info("Running test");

        List<EmployeeSalaryDto> result = departmentDao.listHighestSalEmpByDeptName(dept_name);

        Assert.assertFalse(result.getFirst().getSalary() <0,
                "Employee with dept_name: " + dept_name + " is equal to 0 or negative value");

        log.info("TC_14 test run successfully");
    }
}
