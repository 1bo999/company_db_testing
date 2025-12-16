package model;

public class EmployeeRoleDto {

    private int emp_no;
    private String firstName;
    private String lastName;
    private String role;

    public EmployeeRoleDto() {
    }

    public EmployeeRoleDto(int emp_no, String firstName, String lastName, String role) {
        this.emp_no = emp_no;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }

    public int getEmp_no() {
        return emp_no;
    }

    public void setEmp_no(int emp_no) {
        this.emp_no = emp_no;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "EmployeeRoleDto{" +
                "emp_no=" + emp_no +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
