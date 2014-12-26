package sis.studentinfo;

import junit.framework.TestCase;

/**
 * <p>Title: HonorsGradingStrategyTest</p>
 * <p>Description: HonorsGradingStrategyTest</p>
 * <p>Copyright: Copyright (c) 2012</p>
 * <p>Company: Kewill-IPACS e-Solutions (S) Pte Ltd.</p>
 *
 * @author <shaolong.huang@kewill-ipacs.com>
 */
public class HonorsGradingStrategyTest extends TestCase{
    public void testGetGradingPoints(){
        HonorsGradingStrategy honorsGradingStrategy =new HonorsGradingStrategy();
        assertEquals(5,honorsGradingStrategy.getGradePointsFor(Student.Grade.A));
        assertEquals(4,honorsGradingStrategy.getGradePointsFor(Student.Grade.B));
        assertEquals(3,honorsGradingStrategy.getGradePointsFor(Student.Grade.C));
        assertEquals(2,honorsGradingStrategy.getGradePointsFor(Student.Grade.D));
        assertEquals(0,honorsGradingStrategy.getGradePointsFor(Student.Grade.F));
    }

}
