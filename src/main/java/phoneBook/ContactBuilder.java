import java.security.KeyStore;
import java.util.*;

public class ContactBuilder {

    private static TreeMap<Integer, String> operators = new TreeMap<>();

    private static List<Contact> contactList = new ArrayList<>();

    void addContacts(int item) {
        for(int i = 0; i < item; i++) {
            contactList.add(create());
        }
    }

    private Contact create() {
        String[] names = NameCreator.createFIO();
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
        Hashtable<Integer, String> h = new Hashtable<>();
        h.put(900, null);
        h.put(902, null);

        long number = 0;
        return null;
    }

    ContactBuilder() {
        ArrayList<String> numbers;
        TreeMap<Integer, String> op = new TreeMap<>();
        numbers = ResourcesReader.readLines("mts.txt");
        for (String s : numbers) {
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

class NumberCreator {

    private static int number = 7_654_321;

    private int getNextNumber() {
        return number++;
    }
}

class OperatorsList {
    private static HashMap<Integer, String> codes = new HashMap<>();

    private OperatorsList(){}


}
