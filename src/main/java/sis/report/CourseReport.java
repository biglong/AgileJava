package sis.report;

import sis.studentinfo.CourseSession;
import sis.studentinfo.Session;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static sis.report.RosterReporter.NEWLINE;

/**
 * <p>Title: CourseReport</p>
 * <p>Description: CourseReport</p>
 * <p>Copyright: Copyright (c) 2012</p>
 * <p>Company: Kewill-IPACS e-Solutions (S) Pte Ltd.</p>
 *
 * @author <shaolong.huang@kewill-ipacs.com>
 */
public class CourseReport {
    private List<Session> sessions = new ArrayList<Session>();
    public void add(Session session) {
        sessions.add(session);
    }

    public String text() {
        Collections.sort(sessions);
        StringBuilder buffer = new StringBuilder();
        for (Session session : sessions) {
            buffer.append(session.getDepartment()+" "+session .getNumber()+NEWLINE);
        }
        return buffer.toString();
    }
}
