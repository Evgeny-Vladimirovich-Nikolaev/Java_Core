import java.util.List;
import java.util.concurrent.Callable;

public class ThreadMax extends Thread implements Callable {

    private List<Integer> integerList;

    ThreadMax(List<Integer> integerList) {
        this.integerList = integerList;
        System.out.println(integerList.get(999999));
    }

    @Override
    public Long call() throws Exception {
        return null;
    }
}
