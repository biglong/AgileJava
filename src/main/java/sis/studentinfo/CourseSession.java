package sis.studentinfo;

import java.util.Date;

/**
 * <p>Title: main.java.sis.sudentinfo.CourseSession</p>
 * <p>Description: main.java.sis.sudentinfo.CourseSession</p>
 * <p>Copyright: Copyright (c) 2012</p>
 * <p>Company: Kewill-IPACS e-Solutions (S) Pte Ltd.</p>
 *
 * @author <shaolong.huang@kewill-ipacs.com>
 */
public class CourseSession extends Session{
     private static int count;

    protected CourseSession(Course course, Date startDate) {
        super(course, startDate);
        CourseSession.incrementAccount();
    }

    protected  int getSessionLength(){
        return 16;
    }

    public static int getCount(){
        return count;
    }

    public static void resetCount() {
        count = 0;
    }

    public static  Session create(Course course, Date startDate) {
        return new CourseSession( course,  startDate);  //To change body of implemented methods use File | Settings | File Templates.
    }

    private static void incrementAccount(){
        count++;
    }
}
