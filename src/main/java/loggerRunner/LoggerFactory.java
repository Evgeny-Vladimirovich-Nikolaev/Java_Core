import java.util.Random;

public class LoggerFactory {

    private static String[] status = new String[] { "ERROR", "WARN", "INFO", "DEBUG", "TRACE" };

    Log getLogger(String logLevel) {
        return new Log(status[new Random().nextInt(status.length)], logLevel);
    }
}
