package logger;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class SimpleCustomLogger {
    private Class callerClass;
    private DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    private SimpleCustomLogger() throws Exception {
        throw new Exception("Not instantiable class"); //prevents instantiation by reflection
    }

    public Class getCallerClass() {
        return callerClass;
    }

    public void setCallerClass(Class callerClass) {
        this.callerClass = callerClass;
    }

    public DateFormat getSimpleDateFormat() {
        return simpleDateFormat;
    }

    public void setSimpleDateFormat(DateFormat simpleDateFormat) {
        this.simpleDateFormat = simpleDateFormat;
    }
}
