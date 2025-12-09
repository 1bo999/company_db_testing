package model;

public class Department {

    /**
     * pgAdminde mutlaka tablolari cagirip bakmaniz lazim
     * burani anlamak icin 👺
     *
     * departments tablosunda dept_no, dept_name
     * String olarak tutuluyor. buna pgadminden
     * baka bilirsiniz
     */

    // tabloda bu 'd009' ⚠️max 4 karakter
    private String dept_no;

    // tabloda bu 'Customer Service'
    private String name;


    public Department() {
    }

    /** Department eklerken dept_no ve dept_name kullandigimiz constructor */
    public Department(String dept_no, String name) {
        this.dept_no = dept_no;
        this.name = name;
    }

    public String getDept_no() {
        return dept_no;
    }

    public void setDept_no(String dept_no) {
        this.dept_no = dept_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department{" +
                "dept_no='" + dept_no + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
