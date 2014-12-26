package sis.ui;

import junit.framework.TestCase;
import sis.studentinfo.Student;

/**
 * <p>Description:  </p>
 *
 * @author: huangshaolong
 * Date: 2014/12/26
 * Time: 15:25
 * CopyRight com.tom.ule
 */
public class StudentUITest extends TestCase {
    private static final String name = "My Name";

    public void testCreateStudent() throws Exception {
        StringBuffer expectedOutput = new StringBuffer();
        StringBuffer input = new StringBuffer();
        setup(expectedOutput,input);

    }

    private void setup(StringBuffer expectedOutput, StringBuffer input) {
        expectedOutput.append(StudentUI.MENU);
        input.append(line(StudentUI.ADD_OPTION));
        expectedOutput.append(StudentUI.NAME_PROMPT);
        input.append(line(name));
        expectedOutput.append(line(StudentUI.ADDED_MESSAGE));
        expectedOutput.append(StudentUI.MENU);
        input.append(line(StudentUI.QUIT_OPTION));
    }

    private String line(String input) {
        return String.format("%s%n",input);
    }
}
