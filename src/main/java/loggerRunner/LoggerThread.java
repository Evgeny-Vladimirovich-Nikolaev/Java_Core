import java.time.*;
import java.time.format.DateTimeFormatter;
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
        LocalTime time = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        System.out.println(
                time.format(formatter) +
                " Старт потока" + "\n"
                + "Статус потока: " + logLevel + "\n"
                + "Идентификатор: " + Thread.currentThread().getName() + "\n"
                + msg
                + "\n-------------------------------------------------------------------"
        );
    }

    //Метод вызывает createNewLog() в течение 60 секунд со случайной задержкой
    private void startLogging() {
        Instant start = Instant.now();
        Instant finish = start;
        while(Duration.between(start, finish).toMillis() < 60_000) {
            createNewLog();
            try {
                Thread.sleep((new Random().nextInt(5) + 1) * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
            finish = Instant.now();
        }
    }

    private void createNewLog() {
        new LoggerFactory().getLogger(logLevel);
    }
}
