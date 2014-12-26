package sis.report;


import sis.studentinfo.Session;
import sis.studentinfo.Student;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * <p>Title: RosterReporter</p>
 * <p>Description: RosterReporter</p>
 * <p>Copyright: Copyright (c) 2012</p>
 * <p>Company: Kewill-IPACS e-Solutions (S) Pte Ltd.</p>
 *
 * @author <shaolong.huang@kewill-ipacs.com>
 */
public class RosterReporter {
    static final String NEWLINE  = System.getProperty("line.separator");
    static final String ROSTER_REPORT_HEADER = "Student%n-%n";
    static final String ROSTER_REPORT_FOOTER = "%n# students = %d%n";


    private Session session;
    private Writer writer;
    public RosterReporter(Session session) {
        this.session = session;
    }

//    String getRosterReport(){
//        StringBuilder buffer = new StringBuilder();
//        writeHeader(buffer);
//        writeBody(buffer);
//        writeFooter(buffer);
//        return buffer.toString();
//    }

    private void writeHeader() throws IOException {
        writer.write(String.format(ROSTER_REPORT_HEADER));
    }

    private void writeBody() throws IOException {
        for (Student student : session.getAllStudents()) {
            writer.write(String.format(student.getName()+"%n"));
        }
    }

    private void writeFooter() throws IOException {
        writer.write(String.format(ROSTER_REPORT_FOOTER,session.getAllStudents().size()));
    }

    public void writerReport(Writer writer) {
        this.writer = writer;
        try {
            writeHeader();
            writeBody();
            writeFooter();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void writerReport(String fileName) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));
        try {
            writerReport(bufferedWriter);
        } finally {
            bufferedWriter.close();
        }
    }
}
