package sis.report;

import sis.studentinfo.Student;

import java.util.EnumMap;

/**
 * <p>Title: ReportCard</p>
 * <p>Description: ReportCard</p>
 * <p>Copyright: Copyright (c) 2012</p>
 * <p>Company: Kewill-IPACS e-Solutions (S) Pte Ltd.</p>
 *
 * @author <shaolong.huang@kewill-ipacs.com>
 */
public class ReportCard {
    public static final String A_MESSAGE="Excellent";
    public static final String B_MESSAGE="Very good";
    public static final String C_MESSAGE="Hmmm...";
    public static final String D_MESSAGE="You are not trying";
    public static final String F_MESSAGE="Loser";
    private EnumMap<Student.Grade,String> messageMap;
    static {
        
    }
    public String getMessage(Student.Grade grade){
       if(messageMap == null){
           loadMessageMap();
       }
        return messageMap.get(grade);
    }

    private void loadMessageMap() {
        messageMap = new EnumMap<Student.Grade,String>(Student.Grade.class);
        messageMap.put(Student.Grade.A,A_MESSAGE);
        messageMap.put(Student.Grade.B,B_MESSAGE);
        messageMap.put(Student.Grade.C,C_MESSAGE);
        messageMap.put(Student.Grade.D,D_MESSAGE);
        messageMap.put(Student.Grade.F,F_MESSAGE);
    }


}
