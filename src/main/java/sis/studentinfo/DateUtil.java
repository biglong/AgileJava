package sis.studentinfo;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * <p>Title: DateUtil</p>
 * <p>Description: DateUtil</p>
 * <p>Copyright: Copyright (c) 2012</p>
 * <p>Company: Kewill-IPACS e-Solutions (S) Pte Ltd.</p>
 *
 * @author <shaolong.huang@kewill-ipacs.com>
 */
public class DateUtil {

    private DateUtil() {
    }

    public static Date createDate(int year, int realMonth, int day) {
        GregorianCalendar cal = new GregorianCalendar();
        int month = realMonth-1; //set month ,value from 0-11;
        cal.clear();
        cal.set(year,month,day);
        return cal.getTime();
    }
}
