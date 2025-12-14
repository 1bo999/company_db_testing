package tests.employees;

import dao.EmployeeDao;
import model.EmployeeDepartmentDto;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.Base.BaseTest;

import java.util.List;

public class TC_02 extends BaseTest {

    private EmployeeDao employeeDao;

    @BeforeMethod
    public void setUpDao() { employeeDao = new EmployeeDao(connection);}

    @Test
    public void test() {
        String deptName = "Human Resources";

        List<EmployeeDepartmentDto> eddDto = employeeDao.findEmpByDepartName(deptName);

        Assert.assertFalse(eddDto.isEmpty(),
                "No Employee found with dept_name: " + deptName);

        Assert.assertEquals(eddDto.getFirst().getDept_name(), deptName,
                "First employee with dept_name: " + eddDto.getFirst().getDept_name()
                         + "does not match dept_name: " + deptName);
    }
}
