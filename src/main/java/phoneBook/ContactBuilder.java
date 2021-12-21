import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ContactBuilder {


    ContactBuilder() {
        ArrayList<String> numbers = new ArrayList<>();
        TreeMap<Integer, String> op = new TreeMap<>();
        FileResourcesUtils f = new FileResourcesUtils("resources/mts.txt", numbers);
        for(String s : numbers) {
            try {
                Integer i = Integer.parseInt(s);
                op.put(i, "Operator");
                System.out.println(op.get(i));
            } catch (NumberFormatException e) {
                System.out.println("Не удалось распознать значение " + s);
                e.printStackTrace();
            }
        }
        System.out.println(op);

    }

}