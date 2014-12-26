package sis.report;

import junit.framework.TestCase;
import sis.studentinfo.Course;
import sis.studentinfo.CourseSession;

import java.util.Date;

import static sis.report.RosterReporter.NEWLINE;

/**
 * <p>Title: CourseReportTest</p>
 * <p>Description: CourseReportTest</p>
 * <p>Copyright: Copyright (c) 2012</p>
 * <p>Company: Kewill-IPACS e-Solutions (S) Pte Ltd.</p>
 *
 * @author <shaolong.huang@kewill-ipacs.com>
 */
public class CourseReportTest extends TestCase {

    public void testReport() {
        final Date date = new Date();
        CourseReport report = new CourseReport();
        report.add(CourseSession.create(new Course("ENGL", "101"), date));
        report.add(CourseSession.create(new Course("CZEC", "200"), date));
        report.add(CourseSession.create(new Course("ITAL", "401"), date));
        assertEquals(
            "CZEC " + "200" + NEWLINE
                + "ENGL " + "101" + NEWLINE
                + "ITAL " + "401" + NEWLINE, report.text()
        );
    }


}
