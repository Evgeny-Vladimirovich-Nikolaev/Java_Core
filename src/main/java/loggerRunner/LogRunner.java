package loggerRunner;

import utils.ResourcesReader;

import java.io.IOException;

/**
 * В программе создаётся 3 побочных потока с разным уровнем логирования (TRACE, DEBUG, INFO).
 * Каждый поток пишет в лог-файл сообщения, соответствующие присвоенному уровню логирования.
 * Сообщения со статусом ниже уровня логирования выводятся в консоль.
 */

public class LogRunner {

    private static final String PATH = Paths.LOG_BY_RUNNABLE.getPath();

    public static void main(String[] args) {
        runThreads();
        readLogFile();
    }

    private static void runThreads() {
        LoggerRunnable loggerRunnable_2 = new LoggerRunnable
                (PATH, "TRACE", LoggerMsg.TRACE_DESCRIPTION.getMsg());
        loggerRunnable_2.setName("Трассировщик");
        loggerRunnable_2.start();
        LoggerRunnable loggerRunnable_3 = new LoggerRunnable
                (PATH, "DEBUG", LoggerMsg.DEBUG_DESCRIPTION.getMsg());
        loggerRunnable_3.setName("Отладчик");
        loggerRunnable_3.start();
        LoggerRunnable loggerRunnable_4 = new LoggerRunnable
                (PATH, "INFO", LoggerMsg.INFO_DESCRIPTION.getMsg());
        loggerRunnable_4.setName("Отчёты");
        loggerRunnable_4.start();
        try {
            Thread.sleep(60_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }

    private synchronized static void readLogFile() {
        System.out.println("\n-------------------------------------------------------------------");
        System.out.println("ЧТЕНИЕ ЛОГ-ФАЙЛА");
        try {
            ResourcesReader.printConsole(PATH);
        } catch (IOException e) {
            System.out.println(LoggerMsg.IO_ERROR.getMsg());
            e.printStackTrace();
        }
    }
}
