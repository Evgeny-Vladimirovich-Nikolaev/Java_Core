import java.util.List;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.stream.Stream;

public class ThreadMin extends Thread implements Callable<Integer> {

    private List<Integer> integerList;

    ThreadMin(List<Integer> integerList) {
        this.integerList = integerList;
        System.out.println("aa");
        System.out.println(integerList.get(9999));

    }

    @Override
    public Integer call() throws Exception {
        integerList.stream().min((a, b) -> a.compareTo(b));
        Stream<Integer> st = integerList.stream().map(x -> x.intValue());
        int c = st.reduce(0, (l, r) -> (l + r));
        System.out.println(c);

        Optional<Integer> min = integerList.stream().min(Integer::compare);
        System.out.println(min);
        return null;
    }
}
