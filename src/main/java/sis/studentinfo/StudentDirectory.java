package sis.studentinfo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: hsl
 * Date: 12-9-8
 * Time: 下午7:55
 * To change this template use File | Settings | File Templates.
 */
public class StudentDirectory {
    Map<String,Student> students = new HashMap<String,Student>();
    public Student findById(String i) {
     return students.get(i);
    }

    public void add(Student student) {
        students.put(student.getId(),student);
    }
}
