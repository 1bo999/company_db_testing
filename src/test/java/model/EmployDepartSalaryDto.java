package model;

public class EmployDepartSalaryDto {
    private String firstName;
    private String lastName;
    private String deptName;
    private int salary;

    public EmployDepartSalaryDto() {
    }

    public EmployDepartSalaryDto(String firstName, String lastName, String deptName, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.deptName = deptName;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "EmployDepartSalaryDto{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", deptName='" + deptName + '\'' +
                ", salary=" + salary +
                '}';
    }
}
