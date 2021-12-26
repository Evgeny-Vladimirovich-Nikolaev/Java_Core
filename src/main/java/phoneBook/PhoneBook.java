import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class PhoneBook {

    private static final int SUBSCRIBERS = 10_000;
    private static final int PHONEBOOK_LIMIT = 100;
    private static List<Contact> contactsList = new ContactBuilder(SUBSCRIBERS).getContacts();
    private static Contact[] contactsArray = contactsListToArray();
    private static Set<Contact> contactsSet = contactsListToSet();
    private static HashMap<Contact, Integer> contactsMap = new HashMap<>();

    public static void main(String[] args) {
        fillContacts();
        fillTree();
        countRelatedContactsByLists();
        countRelatedContactsBySets();
        countRelatedContactsByArrays();
        //printContactsMap();
    }

    private static Contact[] contactsListToArray() {
        Contact[] array = new Contact[contactsList.size()];
        int ind = 0;
        for (Contact contact : contactsList) {
            array[ind++] = contact;
        }
        return array;
    }

    private static HashSet<Contact> contactsListToSet() {
        return new HashSet<>(contactsList);
    }

    private static void fillContacts() {
        Random random = new Random();
        for (Contact currentContact : contactsList) {
            int j = random.nextInt(PHONEBOOK_LIMIT);
            for (int i = 0; i < j; i++) {
                Contact randomCnt = contactsList.get(random.nextInt(SUBSCRIBERS));
                if (!currentContact.equals(randomCnt) && !currentContact.getCallersList().contains(randomCnt)) {
                    currentContact.setContact(randomCnt);
                }
            }
            currentContact.fillCallersCollections();
        }
    }

    private static void fillTree() {
        for (Contact contact : contactsList) {
            Integer integer = 0;
            contactsMap.put(contact, integer);
        }
    }

    private static void countRelatedContactsByLists() {
        //замеряемый по времени фрагмент кода
        ///////////////////////////////////////////////////////////////////////////////////////////////////
        Instant start = Instant.now();
        for (Contact contact : contactsList) {
            for (Contact relatedContact : contact.getCallersList()) {
                int count = contactsMap.get(relatedContact);
                count++;
                contactsMap.replace(relatedContact, count);
            }
        }
        Instant finish = Instant.now();
        ///////////////////////////////////////////////////////////////////////////////////////////////////
        long timeByLists = Duration.between(start, finish).toMillis();
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Перебор основного и вложенных списков: " + timeByLists + " мс");
        findPopularContactsByMap();
    }

    private static void countRelatedContactsBySets() {
        //замеряемый по времени фрагмент кода
        ///////////////////////////////////////////////////////////////////////////////////////////////////
        Instant start = Instant.now();
        for (Contact contact : contactsSet) {
            for (Contact relatedContact : contact.getCallersSet()) {
                int count = contactsMap.get(relatedContact);
                count++;
                contactsMap.replace(relatedContact, count);
            }
        }
        Instant finish = Instant.now();
        ///////////////////////////////////////////////////////////////////////////////////////////////////
        long timeBySets = Duration.between(start, finish).toMillis();
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Перебор основного и вложенных множеств: " + timeBySets + " мс");
        findPopularContactsByMap();
    }

    private static void countRelatedContactsByArrays() {
        //замеряемый по времени фрагмент кода
        ///////////////////////////////////////////////////////////////////////////////////////////////////
        Instant start = Instant.now();
        for (Contact contact : contactsArray) {
            for (Contact relatedContact : contact.getCallersArray()) {
                int count = contactsMap.get(relatedContact);
                count++;
                contactsMap.replace(relatedContact, count);
            }
        }
        Instant finish = Instant.now();
        ///////////////////////////////////////////////////////////////////////////////////////////////////
        long timeByArrays = Duration.between(start, finish).toMillis();
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Перебор основного и вложенных массивов: " + timeByArrays + " мс");
        findPopularContactsByMap();
    }

    private static void printContactsMap() {
        System.out.println("ВСЕ НОМЕРА");
        System.out.println("----------------------------------------------------------------------");
        contactsMap.forEach((contact, value) -> {
            System.out.println("----------------------------------------------------------------------");
            System.out.println(contact);
            System.out.println("Количество использования номера другими абонентами для абонента ");
            System.out.print(contact.getFIO() + ":");
            System.out.println(contactsMap.get(contact));
        });
    }

    private static void findPopularContactsByMap() {
        List<Contact> popularContacts = new ArrayList<>();
        Iterator<Map.Entry<Contact, Integer>> entries = contactsMap.entrySet().iterator();
        int max = 0;
        //замеряемый по времени фрагмент кода
        ///////////////////////////////////////////////////////////////////////////////////////////////////
        Instant start = Instant.now();
        while (entries.hasNext()) {
            Contact currentContact = entries.next().getKey();
            int temp = contactsMap.get(currentContact);
            if (temp > max) {
                max = temp;
                popularContacts.clear();
            }
            if (temp >= max) {
                popularContacts.add(currentContact);
            }
        }
        Instant finish = Instant.now();
        ////////////////////////////////////////////////////////////////////////////////////////////////////
        long timeByMap = Duration.between(start, finish).toMillis();
        System.out.println("Время обхода карты: " + timeByMap + " мс");
        printContactsList(popularContacts);
    }

    private static void printContactsList(List<Contact> contacts) {
        System.out.println("ПОПУЛЯРНЫЕ НОМЕРА");
        System.out.println("----------------------------------------------------------------------");
        for (Contact contact : contacts) {
            System.out.println(contact);
            System.out.println("Количество использования номера другими абонентами для абонента ");
            System.out.print(contact.getFIO() + ":");
            System.out.println(contactsMap.get(contact));
        }
    }

}
