package sis.summer;

import sis.studentinfo.Course;
import sis.studentinfo.CourseSession;
import sis.studentinfo.Session;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * <p>Title: SummerCourseSession</p>
 * <p>Description: SummerCourseSession</p>
 * <p>Copyright: Copyright (c) 2012</p>
 * <p>Company: Kewill-IPACS e-Solutions (S) Pte Ltd.</p>
 *
 * @author <shaolong.huang@kewill-ipacs.com>
 */
public class SummerCourseSession extends Session {
    final int sessionLength = 8;

    public static SummerCourseSession create(Course course, Date startDate){
        return new SummerCourseSession(course,  startDate);
    }

    private SummerCourseSession(Course course, Date startDate) {
        super(course, startDate);
    }

    @Override
    protected int getSessionLength(){
        return 8;
    }
 
}
