package model;

import java.time.LocalDate;

public class EmployeeSalaryDto {

    private int emp_no;
    private String full_name;
    private int salary;
    private LocalDate from_date;
    private LocalDate to_date;

    public EmployeeSalaryDto() {
    }

    public EmployeeSalaryDto(int emp_no, String full_name, int salary, LocalDate from_date, LocalDate to_date) {
        this.emp_no = emp_no;
        this.full_name = full_name;
        this.salary = salary;
        this.from_date = from_date;
        this.to_date = to_date;
    }

    public EmployeeSalaryDto(int emp_no, String full_name, int salary) {
        this.emp_no = emp_no;
        this.full_name = full_name;
        this.salary = salary;
    }

    public EmployeeSalaryDto(String full_name, int salary) {
        this.full_name = full_name;
        this.salary = salary;
    }

    public int getEmp_no() {
        return emp_no;
    }

    public void setEmp_no(int emp_no) {
        this.emp_no = emp_no;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public LocalDate getFrom_date() {
        return from_date;
    }

    public void setFrom_date(LocalDate from_date) {
        this.from_date = from_date;
    }

    public LocalDate getTo_date() {
        return to_date;
    }

    public void setTo_date(LocalDate to_date) {
        this.to_date = to_date;
    }

    @Override
    public String toString() {
        return "EmployeeSalaryDto{" +
                "emp_no=" + emp_no +
                ", full_name='" + full_name + '\'' +
                ", salary=" + salary +
                ", from_date=" + from_date +
                ", to_date=" + to_date +
                '}';
    }
}
