package tests;

import dao.DepartmentDao;
import model.Department;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.Base.BaseTest;

public class DepartmentTest extends BaseTest {

    private DepartmentDao departmentDao;

    @BeforeMethod
    public void setUpDao() { departmentDao = new DepartmentDao(connection);}

    @Test
    public void insertDepartment() {
        Department department = new Department("d942", "Armud");
        departmentDao.insertDepartment(department);
    }
}
