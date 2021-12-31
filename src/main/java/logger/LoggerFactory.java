import java.util.Random;

public class LoggerFactory {

    private static String[] status = new String[] { "ERROR", "WARN", "INFO", "DEBUG", "TRACE" };

    Logger getLogger(String logLevel) {
        return new Logger (status[new Random().nextInt(status.length)], logLevel);
    }
}
