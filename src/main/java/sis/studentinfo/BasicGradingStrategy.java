package sis.studentinfo;

/**
 * <p>Title: BasicGradingStrategy</p>
 * <p>Description: BasicGradingStrategy</p>
 * <p>Copyright: Copyright (c) 2012</p>
 * <p>Company: Kewill-IPACS e-Solutions (S) Pte Ltd.</p>
 *
 * @author <shaolong.huang@kewill-ipacs.com>
 */
public  class BasicGradingStrategy implements GradingStraegegy{

    public int getGradePointsFor(Student.Grade grade) {
      return grade.getPoints();
    }
}
