package model;

import java.time.LocalDate;

public class EmployeeSalaryDto {

    private int emp_no;
    private String firstName;
    private String lastName;
    private LocalDate hireDate;
    private double salary;

    public EmployeeSalaryDto() {
    }

    public EmployeeSalaryDto(int emp_no, String firstName, String lastName,
                             LocalDate hireDate, double salary) {
        this.emp_no = emp_no;
        this.firstName = firstName;
        this.lastName = lastName;
        this.hireDate = hireDate;
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

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getEmp_no() {
        return emp_no;
    }

    public void setEmp_no(int emp_no) {
        this.emp_no = emp_no;
    }

    @Override
    public String toString() {
        return "EmployeeSalaryDto{" +
                "emp_no=" + emp_no +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", hireDate=" + hireDate +
                ", salary=" + salary +
                '}';
    }
}