package executors;

import java.util.ArrayList;
import java.util.concurrent.Callable;

public class Maximum implements Callable<Integer> {

    private ArrayList<Integer> integers;

    Maximum(ArrayList<Integer> integers) {
        this.integers = integers;
    }
    @Override
    public Integer call() {
        return integers.stream()
                .mapToInt(i -> i)
                .summaryStatistics()
                .getMax();
    }
}
