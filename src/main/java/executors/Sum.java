package executors;

import java.util.ArrayList;
import java.util.concurrent.Callable;

public class Sum implements Callable<Long> {

    private ArrayList<Integer> integers;

    Sum(ArrayList<Integer> integers) {
        this.integers = integers;
    }

    @Override
    public Long call() {
        return integers.stream()
                .mapToInt(i -> i)
                .summaryStatistics()
                .getSum();
    }
}
