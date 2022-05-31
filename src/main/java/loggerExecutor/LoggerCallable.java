package loggerExecutor;

import loggerRunner.LogFactory;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.Callable;

public class LoggerCallable extends Thread implements Callable<Void> {

    private final String PATH;
    private String logLevel;
    private String msg;
    private String loggerName;

    LoggerCallable(String path, String logLevel, String msg, String loggerName) {
        this.PATH = path;
        this.logLevel = logLevel;
        this.msg = msg;
        this.loggerName = loggerName;
     }

    @Override
    public Void call() {
        try {
            printMessage();
            startLogging();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
        return null;
    }

    private void printMessage() {
        LocalTime time = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        System.out.println(
                time.format(formatter) +
                        " Старт потока" + "\n"
                        + "Статус потока: " + logLevel + "\n"
                        + "Идентификатор: " + loggerName + "\n"
                        + msg
                        + "\n-------------------------------------------------------------------"
        );
    }

    //Метод вызывает createNewLog() в течение 60 секунд со случайной задержкой
    private void startLogging() throws InterruptedException {
        Instant start = Instant.now();
        Instant finish = start;
        while (Duration.between(start, finish).toMillis() < 60_000) {
            createNewLog();
            Thread.sleep((new Random().nextInt(5) + 1) * 1000);
            finish = Instant.now();
        }
    }

    private void createNewLog() {
        LogFactory.getLog(PATH, logLevel, loggerName).writeLog();
    }

}
