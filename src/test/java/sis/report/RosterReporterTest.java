package sis.report;

import junit.framework.TestCase;
import sis.studentinfo.*;

import java.io.*;
import java.util.Date;

/**
 * <p>Title: RosterReporterTest</p>
 * <p>Description: RosterReporterTest</p>
 * <p>Copyright: Copyright (c) 2012</p>
 * <p>Company: Kewill-IPACS e-Solutions (S) Pte Ltd.</p>
 *
 * @author <shaolong.huang@kewill-ipacs.com>
 */
public class RosterReporterTest extends TestCase{
    Session session;
    Date startDate;
    @Override
    public void setUp(){
        startDate = DateUtil.createDate(2012, 8, 16);
        session =  CourseSession.create(new Course("ENGL","101"),startDate);
        session.enroll(new Student("A"));
        session.enroll(new Student("B"));
    }


    public void testRosterReport(){

        Writer writer = new StringWriter();
        new RosterReporter(session).writerReport(writer);
        assertReportContents(writer.toString());
//        String rosterReport = writer.toString();
//        String report = new RosterReporter(session).getRosterReport();
//        System.out.println(report);
//        System.out.println(rosterReport);


    }

    private void assertReportContents(String rosterReport) {
        assertEquals(String.format(RosterReporter.ROSTER_REPORT_HEADER +
                "A%n"+"B%n"+
                RosterReporter.ROSTER_REPORT_FOOTER
                ,session.getNumberOfStudents()),
                rosterReport);
    }

    public void testFiledReport() throws IOException {
        final String fileName = "testFiledReport.txt";
        try {
            delete(fileName);
            new RosterReporter(session).writerReport(fileName);

            StringBuffer buffer = new StringBuffer();
            String line;

            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            while ((line = reader.readLine()) != null)
                buffer.append(String.format(line + "%n"));
            reader.close();

            assertReportContents(buffer.toString());
        }finally {
            delete(fileName);
        }
    }

    private void delete(String fileName) {
        File  file = new File(fileName);
        if(file.exists()){
            assertTrue("unable to delete "+fileName,file.delete());
        }
    }

}
