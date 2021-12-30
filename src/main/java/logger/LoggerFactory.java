import java.util.Random;

public class LoggerFactory {

    private static String[] status = new String[] { "ERROR", "WARN", "INFO", "DEBUG", "TRACE" };
    private static final String logLevel = "INFO";

    Logger getLogger() {
        return new Logger (status[new Random().nextInt(status.length)], logLevel);
    }
}
