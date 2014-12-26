package sis.studentinfo;

import junit.framework.TestCase;

/**
 * Created with IntelliJ IDEA.
 * User: hsl
 * Date: 12-9-8
 * Time: 下午7:35
 * To change this template use File | Settings | File Templates.
 */
public class StudentDirectoryTest extends TestCase {
    private StudentDirectory studentDirectory;
    public void setUp(){
        studentDirectory = new StudentDirectory();
    }

    public void testStoreAndRetrieve(){
        final int numberOfStudents  = 10;
        for (int i = 0; i < numberOfStudents; i++) {
             addStudents(studentDirectory,i);
        }
        for (int i = 0; i < numberOfStudents; i++) {
             verifyStudentLookup(studentDirectory,i);
        }
    }

    private void verifyStudentLookup(StudentDirectory studentDirectory, int i) {
        String id = ""+i;
        Student student = studentDirectory.findById(id);
        assertEquals(i,student.getCredits());
        assertEquals(id,student.getLastName());
        assertEquals(id,student.getId());
    }

    private void addStudents(StudentDirectory studentDirectory, int i) {
        String id = ""+i;
        Student student = new Student(id);
        student.setId(id);
        student.addCredits(i);
        studentDirectory.add(student);
    }


}
