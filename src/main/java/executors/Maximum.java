import java.util.ArrayList;
import java.util.concurrent.Callable;

public class Maximum implements Callable<Long> {

    private ArrayList<Long> longList;

    Maximum(ArrayList<Long> longList) {
        this.longList = longList;
    }
    @Override
    public Long call() throws Exception {
        return longList.stream().max(Long::compare).get();
    }
}
