import java.util.ArrayList;
import java.util.concurrent.Callable;

public class Minimum implements Callable<Long> {

    private ArrayList<Long> longList;

    Minimum(ArrayList<Long> longList) {
        this.longList = longList;
    }
    @Override
    public Long call() throws Exception {
        return longList.stream().min(Long::compare).get();
    }
}
