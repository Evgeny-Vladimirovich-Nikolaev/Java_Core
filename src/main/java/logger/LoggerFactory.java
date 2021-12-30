import java.util.Random;

public class LoggerFactory {

    private static String[] status = new String[] {
            "ERROR",
            "WARN",
            "INFO",
            "DEBUG",
            "TRACE",
            "ALL"
    };
    private static int logThreshold = 1;

    Logger getLogger() {
        String logStatus = status[new Random().nextInt(status.length)];
        //TODO
        return null;
    }
}
