package model;

import java.time.LocalDate;

public class Dept_emp {

    private int emp_no;
    private String dept_no;
    private LocalDate from_date;
    private LocalDate to_date;

    public Dept_emp() {
    }

    public Dept_emp(LocalDate to_date, LocalDate from_date, String dept_no, int emp_no) {
        this.to_date = to_date;
        this.from_date = from_date;
        this.dept_no = dept_no;
        this.emp_no = emp_no;
    }

    public int getEmp_no() {
        return emp_no;
    }

    public void setEmp_no(int emp_no) {
        this.emp_no = emp_no;
    }

    public String getDept_no() {
        return dept_no;
    }

    public void setDept_no(String dept_no) {
        this.dept_no = dept_no;
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
        return "Dept_emp{" +
                "emp_no=" + emp_no +
                ", dept_no='" + dept_no + '\'' +
                ", from_date=" + from_date +
                ", to_date=" + to_date +
                '}';
    }
}
