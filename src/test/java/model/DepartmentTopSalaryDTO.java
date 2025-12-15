package model;

public class DepartmentTopSalaryDTO {

    private String departmentName;
    private String firstName;
    private String lastName;
    private int peakSalary;

    public DepartmentTopSalaryDTO() {
    }

    public DepartmentTopSalaryDTO(String departmentName, String firstName, String lastName, int peakSalary) {
        this.departmentName = departmentName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.peakSalary = peakSalary;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
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

    public int getPeakSalary() {
        return peakSalary;
    }

    public void setPeakSalary(int peakSalary) {
        this.peakSalary = peakSalary;
    }

    @Override
    public String toString() {
        return "DepartmentTopSalaryDTO{" +
                "departmentName='" + departmentName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", peakSalary=" + peakSalary +
                '}';
    }
}
