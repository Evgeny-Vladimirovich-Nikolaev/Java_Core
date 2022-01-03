import java.util.Random;

public class LogFactory {

    private static String[] status = new String[] { "ERROR", "WARN", "INFO", "DEBUG", "TRACE" };

    Log getLog(String PATH, String logLevel) {
        return new Log
                (PATH, status[new Random().nextInt(status.length)], logLevel);
    }

    Log getLog(String PATH, String logLevel, String loggerName) {
        return new Log(PATH, status[new Random().nextInt(status.length)], logLevel, loggerName);
    }
}
