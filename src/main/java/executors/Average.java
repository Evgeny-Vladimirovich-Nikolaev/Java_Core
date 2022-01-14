import java.util.ArrayList;
import java.util.concurrent.Callable;

public class Average implements Callable<Double> {

    private ArrayList<Integer> integers;

    Average(ArrayList<Integer> integers) {
        this.integers = integers;
    }

    @Override
    public Double call() {
        return integers.stream()
                .mapToInt(i -> i)
                .summaryStatistics()
                .getAverage();
    }
}
