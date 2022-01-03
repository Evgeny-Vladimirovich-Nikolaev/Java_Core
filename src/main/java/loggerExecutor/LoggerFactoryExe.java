import java.util.Random;

public class LoggerFactoryExe {

    private static String[] status = new String[] { "ERROR", "WARN", "INFO", "DEBUG", "TRACE" };

    ExeLog getExeLog(String logLevel) {
        return new ExeLog(status[new Random().nextInt(status.length)], logLevel);
    }
}
