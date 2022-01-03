import java.util.ArrayList;
import java.util.concurrent.Callable;

public class Minimum extends CallableInt implements Callable<Integer> {

    private ArrayList<Integer> integerList;

    Minimum(ArrayList<Integer> integerList) {
        this.integerList = integerList;
    }
    @Override
    public Integer call() throws Exception {
        return integerList.stream().min(Integer::compare).get();
    }
}
