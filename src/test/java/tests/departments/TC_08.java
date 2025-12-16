package tests.departments;

import dao.DepartmentDao;
import model.DepartmentSalaryDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.Base.BaseTest;

import java.util.List;

public class TC_08 extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(TC_08.class);
    private DepartmentDao departmentDao;

    @BeforeMethod
    public void setUpDao() {
        log.info("Setting up Dao");
        departmentDao = new DepartmentDao(connection);
    }

    @Test
    public void test() {

        log.info("Running test");

        List<DepartmentSalaryDto> result = departmentDao.avgSalaryEachDept();

        Assert.assertFalse(result.isEmpty(), "Result is empty");
        Assert.assertFalse(
                result.getFirst().getAverage_salary() < 0,
                "First department with avg_salary is smaller than zero"
        );

        log.info("TC_08 test finished successfully");
    }
}
