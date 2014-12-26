package sis.studentinfo;

/**
 * <p>Title: IllegalStudentNameException</p>
 * <p>Description: IllegalStudentNameException</p>
 * <p>Copyright: Copyright (c) 2012</p>
 * <p>Company: Kewill-IPACS e-Solutions (S) Pte Ltd.</p>
 *
 * @author <shaolong.huang@kewill-ipacs.com>
 */
public class StudentNameFormatException extends IllegalArgumentException{

    public StudentNameFormatException() {
    }

    public StudentNameFormatException(String message) {
        super(message);
    }
}
