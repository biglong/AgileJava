package sis.studentinfo;

import junit.framework.TestCase;

/**
 * <p>Title: BasicGradingStraegeyTest</p>
 * <p>Description: BasicGradingStraegeyTest</p>
 * <p>Copyright: Copyright (c) 2012</p>
 * <p>Company: Kewill-IPACS e-Solutions (S) Pte Ltd.</p>
 *
 * @author <shaolong.huang@kewill-ipacs.com>
 */
public class BasicGradingStraegeyTest extends TestCase{
    public void testGetGradingPoints(){
        BasicGradingStrategy basicGradingStrategy = new BasicGradingStrategy();
        assertEquals(4,basicGradingStrategy.getGradePointsFor(Student.Grade.A));
        assertEquals(3,basicGradingStrategy.getGradePointsFor(Student.Grade.B));
        assertEquals(2,basicGradingStrategy.getGradePointsFor(Student.Grade.C));
        assertEquals(1,basicGradingStrategy.getGradePointsFor(Student.Grade.D));
        assertEquals(0,basicGradingStrategy.getGradePointsFor(Student.Grade.F));
    }

}
