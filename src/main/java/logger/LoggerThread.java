import java.time.*;
import java.util.Random;

public class LoggerThread extends Thread{

    @Override
    public void run() {
        Instant start = Instant.now();
        Instant finish = start;
        while(Duration.between(start, finish).toMillis() < 60_000L) {
            createNewLog();
            try {
                Thread.sleep((new Random().nextLong(5L) + 1) * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            finish = Instant.now();
        }
    }

    private void createNewLog() {
        LoggerFactory loggerFactory = new LoggerFactory();
        Logger logger = loggerFactory.getLogger();
    }
}
