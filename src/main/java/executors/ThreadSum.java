import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;

public class ThreadSum extends Thread implements Callable {

    private List<Integer> integerList;

    ThreadSum(ArrayList<Integer> integerList) {
        this.integerList = integerList;
        System.out.println(integerList.get(999999));
    }

    @Override
    public Long call() throws Exception {
//        Long sum = Stream.of(integerList).collect(Collectors.counting());
//        System.out.println(sum);
        //integerList.stream().forEach((a , b)) -> a + b;

        final Integer count =null;

        //integerList.stream().forEach(integer -> count += integer);


        return null;
    }
}
