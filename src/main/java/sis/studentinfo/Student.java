package sis.studentinfo;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;
import java.util.logging.Logger;

/**
 * <p>Title: main.java.sis.sudentinfo.Student</p>
 * <p>Description: main.java.sis.sudentinfo.Student</p>
 * <p>Copyright: Copyright (c) 2012</p>
 * <p>Company: Kewill-IPACS e-Solutions (S) Pte Ltd.</p>
 *
 * @author <shaolong.huang@kewill-ipacs.com>
 */
public class Student {
    static final Logger logger = Logger.getLogger(Student.class.getName());
    static final int CREDITS_REQUIRED_FOR_FULL_TIME = 12;
    static final int MAX_NAME_PARTS = 3;
    static final String TOO_MANY_NAME_PARTS ="student name '%s' contains more than %d parts";
    static final String IN_STATE = "CO";
    private String name;
    private String firstName;
    private String middleName;
    private String lastName;
    private int credits;
    private String state = "";
    private List<Grade> grades = new ArrayList<Grade>();
    private List<Integer> charges = new ArrayList<Integer>() ;
    private GradingStraegegy gradingStrategy = new BasicGradingStrategy();
    private String id;

    public void addCharge(int charge) {
        charges.add(charge);
    }

    public Long totalCharges() {
        Long totalCharges = 0L;
        for (Integer charge : charges) {
            totalCharges += charge;
        }
        return totalCharges;
    }
    public void addHandler(Handler handler) {
        logger.addHandler(handler);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public static enum Grade{
        A(4),B(3),C(2),D(1),F(0);

        private Grade(int points) {
            this.points = points;
        }
        private int points;

        public int getPoints() {
            return points;
        }

        public void setPoints(int points) {
            this.points = points;
        }
    }

    public Student(final String fullName) {
      this.name = fullName;
      this.credits = 0;
        List<String> nameParts = split(name);
        setName(nameParts);
    }

    private void setName(List<String>  nameParts) {
        this.lastName = removeLast(nameParts);
        String name = removeLast(nameParts);
        if(nameParts.isEmpty()) {
            this.firstName = name;
        }else{
            this.middleName = name;
            this.firstName = removeLast(nameParts);
        }
    }

    private String removeLast(List<String> nameParts) {
        if(nameParts.isEmpty())
            return "";
        return nameParts.remove(nameParts.size() - 1);
    }

    private List<String> split(String name) {
       String[] nameParts = name.split(" ");
        List<String> lst = new ArrayList<String>();
        final int maximumNumOfNameParts = 3;
        if(nameParts.length > maximumNumOfNameParts){
            String message =  String.format(TOO_MANY_NAME_PARTS,name,maximumNumOfNameParts);
            logger.info(message);
            throw new StudentNameFormatException(message);
        }
        for (String namePart : nameParts) {
            lst.add(namePart);
        }
        return lst;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredits() {
        return credits;
    }

    public void addCredits(int credits) {
        this.credits += credits;
    }

    public boolean isFullTime() {
        return this.credits >= CREDITS_REQUIRED_FOR_FULL_TIME;
    }

    public boolean isInState() {
        return IN_STATE.equals(state);
    }

    public void setState(String state) {
        this.state = state;
    }

    public double getGpa() {
        if(grades.isEmpty())
            return 0;
        Double total = 0d;
        for (Grade grade : grades) {
            total += gradingStrategy.getGradePointsFor(grade);
        }
        return total/grades.size();
    }
    
    public void addGrade(Grade grade) {
        grades.add(grade);
    }

    public void setGradingStrategy(GradingStraegegy gradingStrategy) {
        this.gradingStrategy = gradingStrategy;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }
}
