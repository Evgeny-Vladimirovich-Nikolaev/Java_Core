import java.time.*;
import java.util.Random;

public class LoggerThread extends Thread{

    private String logLevel;
    private String msg;

    LoggerThread(String logLevel, String msg) {
     this.logLevel = logLevel;
     this.msg = msg;
    }

    @Override
    public void run() {
        printMessage();
        startLogging();
    }

    private void printMessage() {
        Instant threadStart = Instant.now();
        System.out.println(
                threadStart +
                " Старт потока" + "\n"
                + "Статус потока: " + logLevel + "\n"
                + "Идентификатор: " + Thread.currentThread().getName() + "\n"
                + msg
        );
    }

    private void startLogging() {
        Instant start = Instant.now();
        Instant finish = start;
        while(Duration.between(start, finish).toMillis() < 60_000L) {
            createNewLog();
            try {
                Thread.sleep((new Random().nextLong(5L) + 1) * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            finish = Instant.now();
        }
    }

    private void createNewLog() {
        new LoggerFactory().getLogger(logLevel);
    }
}
