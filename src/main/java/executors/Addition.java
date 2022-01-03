import java.util.ArrayList;
import java.util.concurrent.Callable;

public class Addition implements Callable<Long> {

    private ArrayList<Long> longList;

    Addition(ArrayList<Long> longList) {
        this.longList = longList;
    }

    @Override
    public Long call() throws Exception {
        Long sum = 0L;
        for (Long i : longList) sum += i;
        return sum;
    }
}
