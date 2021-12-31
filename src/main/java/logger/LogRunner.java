public class LogRunner {

    private static String logFile = "./src/main/java/logger/log.txt";

    public static void main(String[] args) {
        Logger.fileName = logFile;
        runThreads();
    }

    private static void runThreads() {
        LoggerThread loggerThread_2 = new LoggerThread();
        loggerThread_2.setName("Поток_2");
        loggerThread_2.start();
        LoggerThread loggerThread_3 = new LoggerThread();
        loggerThread_3.setName("Поток_3");
        loggerThread_3.start();
        LoggerThread loggerThread_4 = new LoggerThread();
        loggerThread_4.setName("Поток_4");
        loggerThread_4.start();
    }
}
