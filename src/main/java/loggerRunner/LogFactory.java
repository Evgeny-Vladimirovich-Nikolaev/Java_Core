import java.util.Random;

public class LogFactory {

    private static String[] status = new String[] { "ERROR", "WARN", "INFO", "DEBUG", "TRACE" };

    private LogFactory() {}

    public static Log getLog(String PATH, String logLevel) {
        return new Log(
                PATH,
                status[new Random().nextInt(status.length)],
                logLevel);
    }

    public static Log getLog(String PATH, String logLevel, String loggerName) {
        return new Log(
                PATH,
                status[new Random().nextInt(status.length)],
                logLevel,
                loggerName);
    }
}
