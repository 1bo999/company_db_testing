package model;

import java.time.LocalDate;

public class EmployeeHireDateDTO {

    private String firstName;
    private String lastName;
    private LocalDate hireDate;

    public EmployeeHireDateDTO() {
    }

    public EmployeeHireDateDTO(String firstName, String lastName, LocalDate hireDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.hireDate = hireDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    @Override
    public String toString() {
        return "EmployeeHireDateDTO{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", hireDate=" + hireDate +
                '}';
    }
}
