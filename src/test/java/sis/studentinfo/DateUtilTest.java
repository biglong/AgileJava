package sis.studentinfo;

import junit.framework.TestCase;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * <p>Title: DateUtilTest</p>
 * <p>Description: DateUtilTest</p>
 * <p>Copyright: Copyright (c) 2012</p>
 * <p>Company: Kewill-IPACS e-Solutions (S) Pte Ltd.</p>
 *
 * @author <shaolong.huang@kewill-ipacs.com>
 */
public class DateUtilTest extends TestCase{

    public void testCreateDate(){
        Date date = DateUtil.createDate(2012,8,16);
        GregorianCalendar cal = new GregorianCalendar();
        cal.clear();
        cal.set(2012,7,16);
        assertEquals(cal.getTime(), date);
    }

}
