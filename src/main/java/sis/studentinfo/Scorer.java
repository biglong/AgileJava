package sis.studentinfo;

/**
 * <p>Title: Scorer</p>
 * <p>Description: Scorer</p>
 * <p>Copyright: Copyright (c) 2012</p>
 * <p>Company: Kewill-IPACS e-Solutions (S) Pte Ltd.</p>
 *
 * @author <shaolong.huang@kewill-ipacs.com>
 */
public class Scorer {

    public int score(String s) {
            return Integer.parseInt(s);
    }

    public boolean isValid(String score) {
        try {
            Integer.parseInt(score);
        } catch (NumberFormatException e) {
           return false;
        }
        return true;
    }
}
