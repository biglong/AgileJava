package sis.studentinfo;

/**
 * <p>Title: Performance</p>
 * <p>Description: Performance</p>
 * <p>Copyright: Copyright (c) 2012</p>
 * <p>Company: Kewill-IPACS e-Solutions (S) Pte Ltd.</p>
 *
 * @author <shaolong.huang@kewill-ipacs.com>
 */
public class Performance {

    private int[] tests;

    public void set(int sNumber, int score) {
       tests[sNumber] = score;
    }

    public int get(int sNumber) {
        return tests[sNumber];
    }

    public double average() {
        double total=0;
        for (int test : tests) {
            total += test;    
        }
        if(tests.length > 0)
        return total/tests.length;
        return 0.0;
    }
    
    public void setNumberOfTests(int testNumber){
        tests = new int[testNumber];
    }

    public void setScores(int... scores) {
        tests = scores;
    }
}
