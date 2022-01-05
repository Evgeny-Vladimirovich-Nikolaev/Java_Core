import java.util.ArrayList;
import java.util.concurrent.*;

public class CompletableFutureExperience {

    static private ExecutorService executor = Executors.newFixedThreadPool(3);
    static private int limit = 1_000_000;
    //static private int limit = 100_000_000;
    static private ArrayList<Long> longList = getLongList();

    public static void main(String[] args) {
        runCompletableFutures();
    }

    static private void runCompletableFutures() {
        try {
            CompletableFuture<Long> maximum = CompletableFuture.supplyAsync(CompletableFutureExperience::max, executor);
            CompletableFuture<Long> minimum = CompletableFuture.supplyAsync(CompletableFutureExperience::min, executor);
            CompletableFuture<Double> average = CompletableFuture.supplyAsync(CompletableFutureExperience::avg, executor);
        } catch (Exception e) {
            e.printStackTrace();
        }
        executor.shutdown();
    }

    static ArrayList<Long> getLongList() {
        ArrayList<Long> list = new ArrayList<>();
        for (long i = 0; i < limit; i++) {
            list.add(i);
        }
        return list;
    }

    private static Long max() {
        Long max = null;
        try {
            max = new Maximum(longList).call();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(max);
        return max;
    }

    private static Long min() {
        Long min = null;
        try {
            min = new Minimum(longList).call();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(min);
        return min;
    }

    private static Double avg() {
        double avg;
        Long sum = null;
        try {
            sum = new Addition(longList).call();
        } catch (Exception e) {
            e.printStackTrace();
        }
        avg = sum / longList.size();
        System.out.println(avg);
        return (avg);
    }
}