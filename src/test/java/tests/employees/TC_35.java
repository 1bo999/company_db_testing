package tests.employees;

import dao.EmployeeDao;
import model.Dept_emp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.Base.BaseTest;

import java.util.List;

public class TC_35 extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(TC_35.class);
    private EmployeeDao employeeDao;

    @BeforeMethod
    public void setupDao() {
        log.info("Setting up DAO");
        employeeDao = new EmployeeDao(connection);
    }

    @Test
    public void testManagerialHistory() {
        log.info("Running test");

        int empNo = 110022;
        List<Dept_emp> result = employeeDao.findManagerialHistory(empNo);

        Assert.assertFalse(result.isEmpty(), "Managerial history should not be empty");
        Assert.assertEquals(result.getFirst().getEmp_no(), empNo);
        log.info("Test finished successfully");
    }
}
