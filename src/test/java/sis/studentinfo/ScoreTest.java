package sis.studentinfo;

import junit.framework.TestCase;

/**
 * <p>Title: ScoreTest</p>
 * <p>Description: ScoreTest</p>
 * <p>Copyright: Copyright (c) 2012</p>
 * <p>Company: Kewill-IPACS e-Solutions (S) Pte Ltd.</p>
 *
 * @author <shaolong.huang@kewill-ipacs.com>
 */
public class ScoreTest extends TestCase{
    public void testCaptureScore(){
        Scorer scorer = new Scorer();
        try {
           scorer.score("abd");
            fail("expected NumberFormatException on bad input");
        } catch (Exception success) {
        }
    }

    public void testValid(){
        Scorer scorer = new Scorer();
        assertTrue(scorer.isValid("75"));
        assertFalse(scorer.isValid("db"));
    }

}
