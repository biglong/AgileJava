package sis.studentinfo;

import junit.framework.TestCase;

/**
 * <p>Title: PerformanceTest</p>
 * <p>Description: PerformanceTest</p>
 * <p>Copyright: Copyright (c) 2012</p>
 * <p>Company: Kewill-IPACS e-Solutions (S) Pte Ltd.</p>
 *
 * @author <shaolong.huang@kewill-ipacs.com>
 */
public class PerformanceTest extends TestCase {
    private static double tolerance =0.05;
    public void testAverage(){
        Performance performance = new Performance();
        performance.setNumberOfTests(4);
        performance.set(0,95);
        performance.set(1,92);
        performance.set(2,87);
        performance.set(3,73);
        assertEquals(95,performance.get(0));
        assertEquals(86.75,performance.average(),tolerance);
    }

    public void testInitialization(){
        Performance performance = new Performance();
        performance.setScores(95,92,87,73);
        assertEquals(86.75,performance.average(),tolerance);
        performance.setScores(95,92);
        assertEquals(93.5,performance.average(),tolerance);
    }
}
