public class LogRunner {

    private static String logFile = "./src/main/java/logger/log.txt";

    public static void main(String[] args) {
        Logger.fileName = logFile;
        runThreads();
    }

    private static void runThreads() {
        LoggerThread loggerThread_2 = new LoggerThread("DEBUG");
        loggerThread_2.setName("Отладчик");
        loggerThread_2.start();
        LoggerThread loggerThread_3 = new LoggerThread("INFO");
        loggerThread_3.setName("Отчёты");
        loggerThread_3.start();
        LoggerThread loggerThread_4 = new LoggerThread("WARN");
        loggerThread_4.setName("Предупреждения");
        loggerThread_4.start();
    }
}
