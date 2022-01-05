import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class HashCodeExperiment {

    private static final int SUBSCRIBERS = 10_000;
    private static final int CASH_LIMIT = 1000;
    private static List<Contact> diffHash = new DifferentContactBuilder(SUBSCRIBERS).getContacts();
    private static List<Contact> equalHash = new EqualContactBuilder(SUBSCRIBERS).getContacts();
    private static List<Contact> balancedHash = new BalancedContactBuilder(SUBSCRIBERS).getContacts();
    private static HashSet<Contact> contactsSet;
    private static HashMap<Contact, Long> contactsMap;
    private static ArrayList<Contact> cash = new ArrayList<>();
    private static ArrayList<Long> results = new ArrayList<>();


    public static void main(String[] args) {
        check(diffHash);
        check(equalHash);
        check(balancedHash);
        System.out.println(results);
        printReport();
        System.out.println(cash.get(0));

    }

    private static void check(List<Contact> list) {
        fillCash(list);
        contactsSet = new HashSet<>(list);
        contactsMap = contactsListToMap(list);
        findByValue(contactsMap);
        findByList(list);
        findBySet(contactsSet);
        findByKey(contactsMap);
    }

    private static HashMap<Contact, Long> contactsListToMap(List<Contact> list) {
        HashMap<Contact, Long> map = new HashMap<>();
        for (Contact contact : list) {
            map.put(contact, contact.getPhoneNumber());
        }
        return map;
    }

    private static void fillCash(List<Contact> list) {
        Random rnd = new Random();
        cash.clear();
        for(int i = 0; i < CASH_LIMIT; i++) {
            cash.add(list.get(rnd.nextInt(SUBSCRIBERS)));
        }
    }

    private static void findByList(List<Contact> list) {
        //замеряемый по времени фрагмент кода
        ///////////////////////////////////////////////////////////////////////////////////////////////////
        Instant start = Instant.now();
        for(Contact contact : cash) {
            list.contains(contact);
        }
        Instant finish = Instant.now();
        ///////////////////////////////////////////////////////////////////////////////////////////////////
        results.add(Duration.between(start, finish).toMillis());
    }

    private static void findBySet(HashSet<Contact> set) {
        //замеряемый по времени фрагмент кода
        ///////////////////////////////////////////////////////////////////////////////////////////////////
        Instant start = Instant.now();
        for(Contact contact : cash) {
            set.contains(contact);
        }
        Instant finish = Instant.now();
        ///////////////////////////////////////////////////////////////////////////////////////////////////
        results.add(Duration.between(start, finish).toMillis());
    }

    private static void findByKey(HashMap<Contact, Long> map) {
        //замеряемый по времени фрагмент кода
        ///////////////////////////////////////////////////////////////////////////////////////////////////
        Instant start = Instant.now();
        for(Contact contact : cash) {
            map.containsKey(contact);
        }
        Instant finish = Instant.now();
        ///////////////////////////////////////////////////////////////////////////////////////////////////
        results.add(Duration.between(start, finish).toMillis());
    }

    private static void findByValue(HashMap<Contact, Long> map) {
        //замеряемый по времени фрагмент кода
        ///////////////////////////////////////////////////////////////////////////////////////////////////
        Instant start = Instant.now();
        for(Contact contact : cash) {
            map.containsValue(contact.getPhoneNumber());
        }
        Instant finish = Instant.now();
        ///////////////////////////////////////////////////////////////////////////////////////////////////
        results.add(Duration.between(start, finish).toMillis());
    }

    private static void printReport() {
        print("РАЗНЫМ", 0);
        print("РАВНЫМ", 4);
        print("СБАЛАНСИРОВАННЫМ", 8);
    }

    private static void print(String hashType, int ind) {
        StringBuilder sb = new StringBuilder("------------------------------------------------------\n");
        sb.append("ВРЕМЯ ПОИСКА С ");
        sb.append(hashType);
        sb.append(" ХЭШ-КОДОМ:\nКарта по значению: ");
        sb.append(results.get(ind++));
        sb.append("\nСписок: ");
        sb.append(results.get(ind++));
        sb.append("\nХэш-сет: ");
        sb.append(results.get(ind++));
        sb.append("\nКарта по ключу: ");
        sb.append(results.get(ind));
        System.out.println(sb);
    }
}
