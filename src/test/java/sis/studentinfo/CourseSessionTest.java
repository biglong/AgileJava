package sis.studentinfo;

import junit.framework.TestCase;

import java.util.Calendar;
import java.util.Date;

/**
 * <p>Title: TestCourseSession</p>
 * <p>Description: TestCourseSession</p>
 * <p>Copyright: Copyright (c) 2012</p>
 * <p>Company: Kewill-IPACS e-Solutions (S) Pte Ltd.</p>
 *
 * @author <shaolong.huang@kewill-ipacs.com>
 */
public class CourseSessionTest extends SessionTest {
    Date startDate;


    @Override
    protected Session createSession(Course course, Date startDate) {
        return  CourseSession.create( course,  startDate);
    }

    public void testCount(){
        CourseSession.resetCount();
        createSession(createCourse(),startDate);
        assertEquals(1,CourseSession.getCount());
        createSession(new Course("CMSC","101"),startDate);
        assertEquals(2,CourseSession.getCount());
    }

    private Course createCourse() {
      return  new Course("CMSC","101");
    }

    public void testCourseDates(){
        int year = 2012;
        int month = 11;
        int day = 3;

        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.set(year, month, day);
        Date endDate = session.getEndDate();
        assertEquals(cal.getTime(),endDate);
    }
}
