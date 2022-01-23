import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

public class RandomDate {

    private RandomDate() {}

    static LocalDate getJavaEpochDate() {
        long startEpochDay = LocalDate.EPOCH.toEpochDay();
        long endEpochDay = LocalDate.now().toEpochDay();
        long randomDay = ThreadLocalRandom
                .current()
                .nextLong(startEpochDay, endEpochDay);
        return LocalDate.ofEpochDay(randomDay);
    }

}
