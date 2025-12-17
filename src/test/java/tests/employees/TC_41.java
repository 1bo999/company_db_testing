package tests.employees;

import dao.DepartmentDao;
import dao.EmployeeDao;
import model.Department;
import model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.Base.BaseTest;

import java.util.List;

public class TC_41 extends BaseTest {
    private static final Logger log = LoggerFactory.getLogger(TC_41.class);
    private DepartmentDao departmentDao;

    @BeforeMethod
    public void setUpDao() {
        log.info("Setting up Dao");
        departmentDao = new DepartmentDao(connection);
    }

    @Test
    public void test() {

        log.info("Running test");

        List<Department> result = departmentDao.departmentsByEmp10102();

        Assert.assertFalse(result.isEmpty());
        Assert.assertFalse(result.getFirst().getName().isEmpty(),
                "Department name is empty");
        Assert.assertFalse(result.getFirst().getDept_no().isEmpty(),
                "Department no is empty");

        log.info("TC_41 test run successful");
    }
}
