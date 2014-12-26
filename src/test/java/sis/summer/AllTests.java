package sis.summer;

import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>Title: AllTests</p>
 * <p>Description: AllTests</p>
 * <p>Copyright: Copyright (c) 2012</p>
 * <p>Company: Kewill-IPACS e-Solutions (S) Pte Ltd.</p>
 *
 * @author <shaolong.huang@kewill-ipacs.com>
 */
public class AllTests extends TestCase{
    public static TestSuite suite(){
        TestSuite suite = new TestSuite();
        suite.addTestSuite(SummerCourseSessionTest.class);
        return suite;
    } 

}
