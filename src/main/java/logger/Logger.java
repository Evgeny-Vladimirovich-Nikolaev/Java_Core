import java.io.BufferedWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    private String msg;
    private String status;
    private int level;

    Logger(String msg, String status) {
        this.msg = msg;
        this.status = status;
        this.level = LogLevel.getLevel(status);
    }

    void writeLog(String fileName) {
        String log = time() + " "
                    + "log status: "+ status + " "
                    + "thread name: " + Thread.currentThread().getName() + " "
                    + msg + " ";
        try{
            BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(fileName, true));
            writer.write(log);
            writer.flush();
            writer.close();
        }catch(IOException err){
            System.out.println(LoggerMsg.IO_ERROR.getMsg());
        }
    }

    private String time() {
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return time.format(formatter);
    }
}
