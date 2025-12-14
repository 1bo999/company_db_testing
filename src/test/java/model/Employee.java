package model;

import java.time.LocalDate;

public class Employee {

    private int emp_no;
    private LocalDate birth_date;
    private String firstName;
    private String lastName;
    private String gender;
    private LocalDate hire_date;
    private String dept_no;

    public Employee() {
    }

    public Employee(int emp_no, LocalDate birth_date, String firstName, String lastName, String gender, LocalDate hire_date, String dept_no) {
        this.emp_no = emp_no;
        this.birth_date = birth_date;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.hire_date = hire_date;
        this.dept_no = dept_no;
    }

    public int getEmp_no() {
        return emp_no;
    }

    public void setEmp_no(int emp_no) {
        this.emp_no = emp_no;
    }

    public LocalDate getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(LocalDate birth_date) {
        this.birth_date = birth_date;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getHire_date() {
        return hire_date;
    }

    public void setHire_date(LocalDate hire_date) {
        this.hire_date = hire_date;
    }

    public String getDept_no() {
        return dept_no;
    }

    public void setDept_no(String dept_no) {
        this.dept_no = dept_no;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "emp_no=" + emp_no +
                ", birth_date=" + birth_date +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", hire_date=" + hire_date +
                ", dept_no='" + dept_no + '\'' +
                '}';
    }
}
