package sis;

import junit.framework.TestSuite;


/**
 * <p>Title: AllTests</p>
 * <p>Description: AllTests</p>
 * <p>Copyright: Copyright (c) 2012</p>
 * <p>Company: Kewill-IPACS e-Solutions (S) Pte Ltd.</p>
 *
 * @author <shaolong.huang@kewill-ipacs.com>
 */
public class AllTests{
    public static TestSuite suite(){
        TestSuite suite = new TestSuite();
        suite.addTest(sis.report.AllTests.suite());
        suite.addTest(sis.studentinfo.AllTests.suite());
        suite.addTest(sis.summer.AllTests.suite());
        return suite;
    }

}
