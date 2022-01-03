import java.io.BufferedWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExeLog {


    static String fileName;
    private String status;
    private int currentLevel;
    private int minLevel;
    private String msg;
    String loggerName;

    ExeLog(String status, String logLevel, String loggerName) {
        this.status = status;
        this.currentLevel = LogLevel.getLevel(status);
        this.minLevel = LogLevel.getLevel(logLevel);
        this.msg = LogLevel.getMsg(status);
        this.loggerName = loggerName;
        writeLog();
    }

    void writeLog() {
        String log = createLogText();
        if (currentLevel >= minLevel) {
            writeFile(log);
        } else {
            print(log);
        }
    }

    private String createLogText() {
        return time() + " / "
                + "log status: " + status + " / "
                + "thread name: " + loggerName + " / "
                + msg + "\n";
    }

    private String time() {
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return time.format(formatter);
    }

    private synchronized void writeFile(String log) {
        try {
            BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(fileName, true));
            writer.write(log);
            writer.flush();
            writer.close();
        } catch (IOException err) {
            System.out.println(LoggerMsg.IO_ERROR.getMsg());
            err.printStackTrace();
        }
    }

    private synchronized void print(String log) {
        System.out.print(log);
    }
}
