import java.util.ArrayList;
import java.util.Random;

public class ExeRunner21 {

    public static void main(String[] args) {
        ArrayList<Integer> integerList = getIntegerList();
        new FutureFactory(integerList);
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
