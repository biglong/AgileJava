package sis.studentinfo;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

/**
 * Created with IntelliJ IDEA.
 * User: hsl
 * Date: 12-9-4
 * Time: 下午9:41
 * To change this template use File | Settings | File Templates.
 */
public class TestHandler extends Handler {
    LogRecord logRecord;
    @Override
    public void publish(LogRecord record) {
        this.logRecord = record;
    }

    @Override
    public void flush() {
    }

    @Override
    public void close() throws SecurityException {

    }

    public String getMessage(){
        return logRecord.getMessage();
    }
}
