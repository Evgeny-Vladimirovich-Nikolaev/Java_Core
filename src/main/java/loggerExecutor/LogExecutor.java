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

    private static final String PATH = Paths.LOG_BY_CALLABLE.getPath();

    public static void main(String[] args) {
        executeCallables();
        readLogFile();
    }

    private static void executeCallables() {

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        List<LoggerCallable> tasks = new ArrayList<>();

        LoggerCallable loggerCallable_1 = new LoggerCallable
                (PATH, "TRACE", LoggerMsg.TRACE_DESCRIPTION.getMsg(), "Трассировщик");
        LoggerCallable loggerCallable_2 = new LoggerCallable
                (PATH, "DEBUG", LoggerMsg.DEBUG_DESCRIPTION.getMsg(), "Отладчик");
        LoggerCallable loggerCallable_3 = new LoggerCallable
                (PATH, "INFO", LoggerMsg.INFO_DESCRIPTION.getMsg(), "Отчёты");

        tasks.add(loggerCallable_1);
        tasks.add(loggerCallable_2);
        tasks.add(loggerCallable_3);

        try {
            executorService.invokeAll(tasks);
            executorService.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
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
