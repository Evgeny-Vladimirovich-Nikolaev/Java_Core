package executors;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.*;

public class CompletableFutureExperience {

    static private final ExecutorService executor = Executors.newFixedThreadPool(4);
    static private final int LIMIT = 1_000_000;
    static private final ArrayList<Integer> integers = getIntegerList();

    public static void main(String[] args) {
        runCompletableFutures();
    }

    static private void runCompletableFutures() {
        try {
            CompletableFuture.supplyAsync(() -> maximum(), executor);
            CompletableFuture.supplyAsync(() -> minimum(), executor);
            CompletableFuture.supplyAsync(() -> sum(), executor);
            CompletableFuture.supplyAsync(() -> average(), executor);
        } catch (Exception e) {
            e.printStackTrace();
        }
        executor.shutdown();
    }

    static ArrayList<Integer> getIntegerList() {
        ArrayList<Integer> list = new ArrayList<>();
        Random rnd = new Random();
        for (int i = 0; i < LIMIT; i++) {
            list.add(rnd.nextInt());
        }
        return list;
    }

    private static Integer maximum() {
        Integer max = null;
        try {
            max = new Maximum(integers).call();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Максимум в списке равен " + max);
        return max;
    }

    private static Integer minimum() {
        Integer min = null;
        try {
            min = new Minimum(integers).call();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Минимум в списке равен " + min);
        return min;
    }

    private static Long sum() {
        Long sum = null;
        try {
            sum = new Sum(integers).call();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Сумма значений в списке равна " + sum);
        return (sum);
    }

    private static Double average() {
        Double avg = null;
        try {
            avg = new Average(integers).call();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Среднее арифметическое значений в списке равно " + avg);
        return avg;
    }
}
