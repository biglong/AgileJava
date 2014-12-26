package sis.studentinfo;

import junit.framework.TestCase;

import java.util.logging.Handler;
import java.util.logging.Logger;

/**
 * <p>Title: TestStudent</p>
 * <p>Description: TestStudent</p>
 * <p>Copyright: Copyright (c) 2012</p>
 * <p>Company: Kewill-IPACS e-Solutions (S) Pte Ltd.</p>
 *
 * @author <shaolong.huang@kewill-ipacs.com>
 */
public class StudentTest extends TestCase {
     private static final String firstStudentName = "Jane Brave";
     private static final String secondStudentName = "Joe Steven Brown";
    private static final double GRADE_TOLERANCE = 0.05;

    
    public void testCreate(){
        Student firstStudent = new Student(firstStudentName);
        Student secondStudent = new Student(secondStudentName);
        assertEquals(firstStudentName,firstStudent.getName());
        assertEquals("Jane",firstStudent.getFirstName());
        assertEquals("Brave",firstStudent.getLastName());
        assertEquals(secondStudentName,secondStudent.getName());
        assertEquals("Joe",secondStudent.getFirstName());
        assertEquals("Steven",secondStudent.getMiddleName());
        assertEquals("Brown",secondStudent.getLastName());
    }

    public void testStudentStatus(){
        Student student = new Student("Joe");
        assertEquals(0,student.getCredits());
        student.addCredits(3);
        assertEquals(3,student.getCredits());
        student.addCredits(4);
        assertEquals(7,student.getCredits());
        student.addCredits(5);
        assertEquals(Student.CREDITS_REQUIRED_FOR_FULL_TIME,student.getCredits());
        assertTrue("not enough credits for FT students",student.isFullTime());
    }

    public void testInState(){
        Student student = new Student("a");
        assertFalse(student.isInState());
        student.setState(Student.IN_STATE);
        assertTrue(student.isInState());
        student.setState("MD");
        assertFalse(student.isInState());
    }
    
    public void testCalculateGpa() {
        Student student = new Student("a");
        assertEquals(0.0,student.getGpa(),GRADE_TOLERANCE);
        student.addGrade(Student.Grade.A);
        assertEquals(4.0,student.getGpa(),GRADE_TOLERANCE);
        student.addGrade(Student.Grade.B);
        assertEquals(3.5,student.getGpa(),GRADE_TOLERANCE);
        student.addGrade(Student.Grade.C);
        assertEquals(3.0,student.getGpa(),GRADE_TOLERANCE);
        student.addGrade(Student.Grade.D);
        assertEquals(2.5,student.getGpa(),GRADE_TOLERANCE);
        student.addGrade(Student.Grade.F);
        assertEquals(2.0,student.getGpa(),GRADE_TOLERANCE);
    }


    public void testCharge(){
        Student student = new Student("a");
        student.addCharge(500);
        student.addCharge(600);
        student.addCharge(309);
        assertEquals((Long)1409L,student.totalCharges());
    }
    
    public void testBadlyFormatName(){
        final String studentName = "a b c d";
        Handler handler = new TestHandler();
        Student.logger.addHandler(handler);
        try {
            Student student  = new Student(studentName);
            fail("expect exception from 4-part name");
        } catch (StudentNameFormatException expectException) {
            String message = String.format(Student.TOO_MANY_NAME_PARTS,studentName,Student.MAX_NAME_PARTS);
            assertEquals(message,expectException.getMessage());
            assertEquals(message,((TestHandler)handler).getMessage());
        }
    }


    public void testLoggingHierarchy(){
        Logger logger = Logger.getLogger("sis.studentinfo.student");
        assertTrue(logger == Logger.getLogger("sis.studentinfo.student"));
        Logger parent = Logger.getLogger("sis.studentinfo");
        assertTrue(parent == logger.getParent());
    }


}
