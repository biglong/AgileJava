package sis.studentinfo;

import junit.framework.TestCase;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * <p>Title: SessionTest</p>
 * <p>Description: SessionTest</p>
 * <p>Copyright: Copyright (c) 2012</p>
 * <p>Company: Kewill-IPACS e-Solutions (S) Pte Ltd.</p>
 *
 * @author <shaolong.huang@kewill-ipacs.com>
 */
public abstract class SessionTest extends TestCase {

    private static final int CREDITS = 3;
    protected Session session;
    protected Date startDate;

    @Override
    public void setUp() {
        startDate = DateUtil.createDate(2012, 8, 16);
        session = createSession(new Course("ENGL", "101"), startDate);
        session.setNumberOfCredits(CREDITS);
    }

    public void testCreate() {
        assertEquals("ENGL", session.getDepartment());
        assertEquals("101", session.getNumber());
        assertEquals(0, session.getNumberOfStudents());
        assertEquals(startDate, session.getStartDate());
    }

    public void testEnrollStudents() {
        Student student1 = new Student("Cave Dive");
        session.enroll(student1);
        assertEquals(1, session.getNumberOfStudents());
        assertEquals(CREDITS, student1.getCredits());

        Student student2 = new Student("Coralee DeVaghn");
        session.enroll(student2);
        assertEquals(2, session.getNumberOfStudents());
        assertEquals(3, student1.getCredits());

        assertEquals(student1, session.get(0));
        assertEquals(student2, session.get(1));
    }

    public void testComparable() {
        Session sessionA = createSession(new Course("CMSC", "101"), startDate);
        Session sessionB = createSession(new Course("ENGL", "101"), startDate);
        assertTrue(sessionA.compareTo(sessionB) < 0);
        assertTrue(sessionB.compareTo(sessionA) > 0);
        Session sessionC = createSession(new Course("CMSC", "101"), startDate);
        assertEquals(0, sessionA.compareTo(sessionC));
    }

    public void testAverageGpaForPartTimeStudents() {
        session.enroll(creatFullTimeStudent());
        Student partTime1 = new Student("p");
        partTime1.addGrade(Student.Grade.A);
        session.enroll(partTime1);

        session.enroll(creatFullTimeStudent());
        Student partTime2 = new Student("p");
        partTime2.addGrade(Student.Grade.B);
        session.enroll(partTime2);

        assertEquals(3.5, session.averageGpaForPartTimeStudents(), 0.05);
    }

    private Student creatFullTimeStudent() {
        Student student = new Student("a");
        student.addCredits(Student.CREDITS_REQUIRED_FOR_FULL_TIME);
        return student;
    }

    public void testIterator() {
        enrollStudents(session);
        List<Student> results = new ArrayList<Student>();
        for (Student student : session) {
            results.add(student);
        }
        assertEquals(results, session.getAllStudents());
    }

    protected void enrollStudents(Session session) {
        session.enroll(new Student("a"));
        session.enroll(new Student("b"));
        session.enroll(new Student("c"));
    }

    public void testSessionUrl() throws SessionException {
        final String url = "http://www.baidu.com";
        session.setUrl(url);
        assertEquals(url, session.getUrl());
    }
    
    public void testInvalidSessionUrl(){
        final String url = "httsp://asdfasdf";
        try {
            session.setUrl(url);
            fail("expect exception due to invalid protocol in URL");
        } catch (SessionException success) {
        }
    }

    protected abstract Session createSession(Course course, Date startDate);

}
