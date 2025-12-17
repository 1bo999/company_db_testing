package model;

public class DepartmentEmployeeSalaryDto {

    private String full_name;
    private double avg_salary;

    public DepartmentEmployeeSalaryDto() {
    }

    public DepartmentEmployeeSalaryDto(String full_name, double avg_salary) {
        this.full_name = full_name;
        this.avg_salary = avg_salary;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public double getAvg_salary() {
        return avg_salary;
    }

    public void setAvg_salary(double avg_salary) {
        this.avg_salary = avg_salary;
    }

    @Override
    public String toString() {
        return "DepartmentEmployeeSalaryDto{" +
                "full_name='" + full_name + '\'' +
                ", avg_salary=" + avg_salary +
                '}';
    }
}
