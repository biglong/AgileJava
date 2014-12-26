package sis.studentinfo;

import junit.framework.TestSuite;


/**
 * <p>Title: AllTests</p>
 * <p>Description: AllTests</p>
 * <p>Copyright: Copyright (c) 2012</p>
 * <p>Company: Kewill-IPACS e-Solutions (S) Pte Ltd.</p>
 *
 * @author <shaolong.huang@kewill-ipacs.com>
 */
public class AllTests {
    public static TestSuite suite(){
        TestSuite suite = new TestSuite();
        suite.addTestSuite(BasicGradingStraegeyTest.class);
        suite.addTestSuite(CourseSessionTest.class);
        suite.addTestSuite(DateUtilTest.class);
        suite.addTestSuite(HonorsGradingStrategyTest.class);
        suite.addTestSuite(PerformanceTest.class);
        suite.addTestSuite(ScoreTest.class);
        suite.addTestSuite(StudentDirectoryTest.class);
        suite.addTestSuite(StudentTest.class);
        suite.addTestSuite(CourseTest.class);
        return suite;
    }

}
