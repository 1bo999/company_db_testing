package model;

public class DepartmentHighestAvgSalaryDTO {

    private String departmentName;
    private String firstName;
    private String lastName;
    private double avgSalary;

    public DepartmentHighestAvgSalaryDTO() {
    }

    public DepartmentHighestAvgSalaryDTO(String departmentName, String firstName, String lastName, double avgSalary) {
        this.departmentName = departmentName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.avgSalary = avgSalary;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getAvgSalary() {
        return avgSalary;
    }

    @Override
    public String toString() {
        return "DepartmentHighestAvgSalaryDTO{" +
                "departmentName='" + departmentName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", avgSalary=" + avgSalary +
                '}';
    }
}
