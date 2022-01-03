import java.io.IOException;

/**
 * В программе создаётся 3 побочных потока с разным уровнем логирования (TRACE, DEBUG, INFO).
 * Каждый поток пишет в лог-файл сообщения, соответствующие присвоенному уровню логирования.
 * Сообщения со статусом ниже уровня логирования выводятся в консоль.
 */

public class LogRunner {

    private static String logFile = "./src/main/resources/log.txt";

    public static void main(String[] args) {
        Log.fileName = logFile;
        runThreads();
        readLogFile();
    }

    private static void runThreads() {
        LoggerThread loggerThread_2 = new LoggerThread
                ("TRACE", LoggerMsg.TRACE_DESCRIPTION.getMsg());
        loggerThread_2.setName("Трассировщик");
        loggerThread_2.start();
        LoggerThread loggerThread_3 = new LoggerThread
                ("DEBUG", LoggerMsg.DEBUG_DESCRIPTION.getMsg());
        loggerThread_3.setName("Отладчик");
        loggerThread_3.start();
        LoggerThread loggerThread_4 = new LoggerThread
                ("INFO", LoggerMsg.INFO_DESCRIPTION.getMsg());
        loggerThread_4.setName("Отчёты");
        loggerThread_4.start();
        try {
            Thread.sleep(60_000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }

    private synchronized static void readLogFile() {
        System.out.println("\n-------------------------------------------------------------------");
        System.out.println("ЧТЕНИЕ ЛОГ-ФАЙЛА");
        try {
            ResourcesReader.printConsole(logFile);
        } catch (IOException e) {
            System.out.println(LoggerMsg.IO_ERROR.getMsg());
            e.printStackTrace();
        }
    }
}
