package model;

public class EmployeeDurationDto {

    private String firstName;
    private String lastName;
    private int empNo;
    private int duration;

    public EmployeeDurationDto() {
    }

    public EmployeeDurationDto(String firstName, String lastName, int empNo, int duration) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.empNo = empNo;
        this.duration = duration;
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

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "EmployeeDurationDto{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", empNo=" + empNo +
                ", duration=" + duration +
                '}';
    }
}
