import java.util.ArrayList;
import java.util.concurrent.Callable;

public class Maximum extends CallableInt implements Callable<Integer> {

    private ArrayList<Integer> integerList;

    Maximum(ArrayList<Integer> integerList) {
        this.integerList = integerList;
    }
    @Override
    public Integer call() throws Exception {
        return integerList.stream().max(Integer::compare).get();
    }
}
