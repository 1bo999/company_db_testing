package tests.employees;

import dao.EmployeeDao;
import model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.Base.BaseTest;

import java.sql.SQLException;
import java.util.List;

public class TC_01 extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(TC_01.class);
    private EmployeeDao employeeDao;

    @BeforeMethod
    public void setUpDao() {
        log.info("Setting up  DAO");

        employeeDao = new EmployeeDao(connection);
    }

    @Test
    public void test() throws SQLException {
        String deptNo = "d001";

        log.info("Running test");

        List<Employee> employees = employeeDao.findEmployeeByDeptNo(deptNo);

        Assert.assertFalse(employees.isEmpty(), "No Employee found with dept_no: " + deptNo);

        Assert.assertEquals(employees.getFirst().getDept_no(), deptNo,
                "First employee with dept_no: " + employees.getFirst().getDept_no()
                         + "does no match dept_no: " + deptNo);

        log.info("TC_01 test finished successfully");
    }
}
