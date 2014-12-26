package sis.studentinfo;

/**
 * <p>Title: EliteGradingStrategy</p>
 * <p>Description: EliteGradingStrategy</p>
 * <p>Copyright: Copyright (c) 2012</p>
 * <p>Company: Kewill-IPACS e-Solutions (S) Pte Ltd.</p>
 *
 * @author <shaolong.huang@kewill-ipacs.com>
 */
public class EliteGradingStrategy extends BasicGradingStrategy{

    public int getGradePointsFor(Student.Grade grade) {
       return super.getGradePointsFor(grade)+1;
    }
}
