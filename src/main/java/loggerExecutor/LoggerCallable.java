import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.Callable;

public class LoggerCallable extends Thread implements Callable<Void> {

    private String logLevel;
    private String msg;


    LoggerCallable(String logLevel, String msg) {
        this.logLevel = logLevel;
        this.msg = msg;
     }

    @Override
    public Void call() throws Exception {
        printMessage();
        startLogging();
        return null;
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
        while (Duration.between(start, finish).toMillis() < 60_000) {
            createNewLog();
            try {
                Thread.sleep((new Random().nextLong(5L) + 1) * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace(System.out);
                Thread.currentThread().interrupt();
            }
            finish = Instant.now();
        }
    }

    private void createNewLog() {
        new LoggerFactory().getLogger(logLevel);
    }

}
