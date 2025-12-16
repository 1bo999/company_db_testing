package model;

public class DepartmentSalaryDto {

    private String dept_no;
    private double average_salary;

    public DepartmentSalaryDto() {
    }

    public DepartmentSalaryDto(String dept_no, double average_salary) {
        this.dept_no = dept_no;
        this.average_salary = average_salary;
    }

    public String getDept_no() {
        return dept_no;
    }

    public void setDept_no(String dept_no) {
        this.dept_no = dept_no;
    }

    public double getAverage_salary() {
        return average_salary;
    }

    public void setAverage_salary(double average_salary) {
        this.average_salary = average_salary;
    }

    @Override
    public String toString() {
        return "DepartmentSalaryDto{" +
                "dept_no='" + dept_no + '\'' +
                ", average_salary=" + average_salary +
                '}';
    }
}
