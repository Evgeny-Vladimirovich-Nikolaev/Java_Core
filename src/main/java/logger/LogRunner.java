import java.io.IOException;

/**
 * В программе создаётся 3 побочных потока с разным уровнем логирования (TRACE, DEBUG, INFO).
 * Каждый поток пишет в лог-файл сообщения, соответствующие присвоенному уровню логирования.
 * Сообщения со статусом ниже уровня логирования выводятся в консоль.
 */

public class LogRunner {

    private static String logFile = "./src/main/resources/log.txt";

    public static void main(String[] args) {
        Logger.fileName = logFile;
        runThreads();
        readLogFile();
    }

    private static void runThreads() {
        LoggerThread loggerThread_2 = new LoggerThread
                ("TRACE", "Трассировщик создаёт пошаговые записи процесса");
        loggerThread_2.setName("Трассировщик");
        loggerThread_2.start();
        LoggerThread loggerThread_3 = new LoggerThread
                ("DEBUG", "Отладчик регистрирует наиболее важные программные события");
        loggerThread_3.setName("Отладчик");
        loggerThread_3.start();
        LoggerThread loggerThread_4 = new LoggerThread
                ("INFO", "Поток фиксирует общую информацию о работе программы");
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
