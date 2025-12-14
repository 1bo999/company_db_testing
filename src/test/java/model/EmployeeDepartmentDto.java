package model;

public class EmployeeDepartmentDto {

    // SELECT e.first_name, e.last_name, e.emp_no, d.dept_name, d.dept_no

    private String firstName;
    private String lastName;
    private int emp_no;
    private String dept_name;
    private String dept_no;

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

    public int getEmp_no() {
        return emp_no;
    }

    public void setEmp_no(int emp_no) {
        this.emp_no = emp_no;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public String getDept_no() {
        return dept_no;
    }

    public void setDept_no(String dept_no) {
        this.dept_no = dept_no;
    }

    @Override
    public String toString() {
        return "EmployeeDepartmentDto{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emp_no=" + emp_no +
                ", dept_name='" + dept_name + '\'' +
                ", dept_no='" + dept_no + '\'' +
                '}';
    }
}
