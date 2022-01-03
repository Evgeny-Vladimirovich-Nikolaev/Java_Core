import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class FutureFactory {

    //private ArrayList<Integer> integerList;
    private List<CallableInt> callableInts;

    FutureFactory(ArrayList<Integer> integerList) {
        //Collection<Callable<Integer>> tasks = new ArrayList<>();
        Collection<CompletableFuture<Integer>> c = new ArrayList<>() {
        };
        c.add(findInteger(new Minimum(integerList)));
        ExecutorService executorService = Executors.newFixedThreadPool(3);


    }

    public static <T> CompletableFuture<T> makeCompletableFuture(Future<T> future) {
        if (future.isDone())
            return transformDoneFuture(future);
        return CompletableFuture.supplyAsync(() -> {
            try {
                if (!future.isDone())
                    awaitFutureIsDoneInForkJoinPool(future);
                return future.get();
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                // Normally, this should never happen inside ForkJoinPool
                Thread.currentThread().interrupt();
                // Add the following statement if the future doesn't have side effects
                // future.cancel(true);
                throw new RuntimeException(e);
            }
        });
    }

    private static <T> CompletableFuture<T> transformDoneFuture(Future<T> future) {
        CompletableFuture<T> cf = new CompletableFuture<>();
        T result;
        try {
            result = future.get();
        } catch (Throwable ex) {
            cf.completeExceptionally(ex);
            return cf;
        }
        cf.complete(result);
        return cf;
    }

    private static void awaitFutureIsDoneInForkJoinPool(Future<?> future)
            throws InterruptedException {
        ForkJoinPool.managedBlock(new ForkJoinPool.ManagedBlocker() {
            @Override public boolean block() throws InterruptedException {
                try {
                    future.get();
                } catch (ExecutionException e) {
                    throw new RuntimeException(e);
                }
                return true;
            }
            @Override public boolean isReleasable() {
                return future.isDone();
            }
        });
    }


    private CompletableFuture<Integer> findInteger(CallableInt callableInt) {
        return CompletableFuture.supplyAsync(() -> {
            Integer integer = null;
            try {
                integer = callableInt.call();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return integer;
        });
    }


    private static ArrayList<Integer> getIntegerList() {
        ArrayList<Integer> list = new ArrayList<>(1_000_000);
        Random rnd = new Random();
        for(int i = 0; i < 1_000_000; i++) {
            list.add(rnd.nextInt());
        }
        return list;
    }
}
