package executors;

import java.util.ArrayList;
import java.util.concurrent.Callable;

public class Minimum implements Callable<Integer> {

    private ArrayList<Integer> integers;

    Minimum(ArrayList<Integer> integers) {
        this.integers = integers;
    }
    @Override
    public Integer call() {
        return integers.stream()
                .mapToInt(i -> i)
                .summaryStatistics()
                .getMin();
    }
}
