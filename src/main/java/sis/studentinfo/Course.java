package sis.studentinfo;

/**
 * <p>Description:  </p>
 *
 * @author: huangshaolong
 * Date: 2014/12/23
 * Time: 14:04
 * CopyRight com.tom.ule
 */
public class Course {
    private String department;
    private String number;
    public Course(String department, String number) {
        this.department = department;
        this.number = number;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
