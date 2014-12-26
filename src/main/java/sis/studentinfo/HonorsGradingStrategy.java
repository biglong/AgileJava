package sis.studentinfo;

/**
 * <p>Title: HonorsGradingStrategy</p>
 * <p>Description: HonorsGradingStrategy</p>
 * <p>Copyright: Copyright (c) 2012</p>
 * <p>Company: Kewill-IPACS e-Solutions (S) Pte Ltd.</p>
 *
 * @author <shaolong.huang@kewill-ipacs.com>
 */
public class HonorsGradingStrategy extends BasicGradingStrategy  {

    public int getGradePointsFor(Student.Grade grade) {
       return super.getGradePointsFor(grade)>0?super.getGradePointsFor(grade)+1:0;
    }
}
