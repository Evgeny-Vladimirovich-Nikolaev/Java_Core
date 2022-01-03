import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * Так же как и в LogRunner, в программе создаётся 3 побочных потока с разным уровнем логирования
 * (TRACE, DEBUG, INFO).
 * Каждый поток пишет в лог-файл сообщения, соответствующие присвоенному уровню логирования.
 * Сообщения со статусом ниже уровня логирования выводятся в консоль.
 */

public class LogExecutor {

    private final static String logFile = "./src/main/resources/executorLog.txt";

    public static void main(String[] args) {
        ExeLog.fileName = logFile;
        exeCallables();
        readLogFile();
    }

    private static void exeCallables() {

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        List<LoggerCallable> tasks = new ArrayList<>();

        LoggerCallable logger_Callable_2 = new LoggerCallable
                ("TRACE", LoggerMsg.TRACE_DESCRIPTION.getMsg(), "Трассировщик");


        LoggerCallable logger_Callable_3 = new LoggerCallable
                ("DEBUG", LoggerMsg.DEBUG_DESCRIPTION.getMsg(), "Отладчик");


        LoggerCallable logger_Callable_4 = new LoggerCallable
                ("INFO", LoggerMsg.INFO_DESCRIPTION.getMsg(), "Отчёты");



        tasks.add(logger_Callable_2);
        tasks.add(logger_Callable_3);
        tasks.add(logger_Callable_4);

        try {
            executorService.invokeAll(tasks);
            executorService.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        } catch (Exception e) {
            e.printStackTrace();
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
