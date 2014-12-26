package sis.studentinfo;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

/**
 * <p>Title: Session</p>
 * <p>Description: Session</p>
 * <p>Copyright: Copyright (c) 2012</p>
 * <p>Company: Kewill-IPACS e-Solutions (S) Pte Ltd.</p>
 *
 * @author <shaolong.huang@kewill-ipacs.com>
 */
public abstract class Session implements Comparable<Session>,Iterable<Student>{
    final int sessionLength = 16;
    final int daysInWeek = 7;
    final int dayFromFridayToMonday = 3;
    private static int count = 0;
    private int numberOfCredits;

    private Course course;
    private List<Student> students = new ArrayList<Student>();
    private Date startDate;
    private URL url;

    protected Session(Course course,Date startDate) {
        this.course = course;
        this.startDate = startDate;
    }

    public String getDepartment() {
        return course.getDepartment();
    }

    public String getNumber() {
        return course.getNumber();
    }


    public Student get(int index) {
        return students.get(index);
    }

    public void enroll(Student student) {
        student.addCredits(numberOfCredits);
        students.add(student);
    }

    public int getNumberOfStudents() {
        return students.size();
    }

    /**
     *
     * @return Date the last date of the course session
     * @author hsl
     */
    public  Date getEndDate() {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(startDate);
        int numberOfDays = getSessionLength() * daysInWeek - dayFromFridayToMonday;
        cal.add(Calendar.DAY_OF_YEAR, numberOfDays);
        return cal.getTime();
    }

    protected Date getStartDate() {
        return startDate;
    }

    public  List<Student> getAllStudents(){
        return students;
    }

    public int getNumberOfCredits() {
        return numberOfCredits;
    }

    public void setNumberOfCredits(int numberOfCredits) {
        this.numberOfCredits = numberOfCredits;
    }

    public int compareTo(Session that) {
        int result = getDepartment().compareTo(that.getDepartment());
        if (result == 0)
            result = getNumber().compareTo(that.getNumber());
        return result;
    }

    protected abstract int getSessionLength();


    public double averageGpaForPartTimeStudents() {
        int partTimeStudentCount = 0;
        Double partTimeStudentGpa = 0d;
        for (Student student : students) {
            if(student.isFullTime())
                continue;
               partTimeStudentCount++;
               partTimeStudentGpa += student.getGpa();
        }
        if(partTimeStudentCount != 0){
            return partTimeStudentGpa/partTimeStudentCount;
        }else{
            return 0.0;
        }
    }

    public Iterator<Student> iterator() {
        return students.iterator();
    }

    public void setUrl(String url) throws SessionException {

        try {
            this.url = new URL(url);
        } catch (MalformedURLException e) {
            log(e);
            throw new SessionException(e);
        }
    }

    private void log(MalformedURLException e) {
        //To change body of created methods use File | Settings | File Templates.
    }

    public String getUrl() {
       return  this.url.toString();
    }
}
