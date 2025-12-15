package model;

import java.time.LocalDate;

public class Salary {

    private int emp_no;
    private double salary;
    private LocalDate from_date;
    private LocalDate to_date;

    public Salary() {
    }

    public Salary(int emp_no, double salary, LocalDate from_date, LocalDate to_date) {
        this.emp_no = emp_no;
        this.salary = salary;
        this.from_date = from_date;
        this.to_date = to_date;
    }

    public int getEmp_no() {
        return emp_no;
    }

    public void setEmp_no(int emp_no) {
        this.emp_no = emp_no;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
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
        return "Salary{" +
                "emp_no=" + emp_no +
                ", salary=" + salary +
                ", from_date=" + from_date +
                ", to_date=" + to_date +
                '}';
    }
}
