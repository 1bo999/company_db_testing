package model;

public class DepartmentEmployeeCountDTO {

    private String deptName;
    private int employeeCount;

    public DepartmentEmployeeCountDTO() {
    }

    public DepartmentEmployeeCountDTO(String deptName, int employeeCount) {
        this.deptName = deptName;
        this.employeeCount = employeeCount;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }

    @Override
    public String toString() {
        return "DepartmentEmployeeCountDTO{" +
                "deptName='" + deptName + '\'' +
                ", employeeCount=" + employeeCount +
                '}';
    }
}

