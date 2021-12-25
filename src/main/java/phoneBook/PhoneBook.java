import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.*;

public class PhoneBook {

    private static final int SUBSCRIBERS = 10_000;
    private static final int PHONEBOOK_LIMIT = 100;
    private static List<Contact> contactsList = new ContactBuilder(SUBSCRIBERS).getContacts();
    private static HashMap<Contact, Integer> contactsMap = new HashMap<>();

    public static void main(String[] args) {
        fillContacts();
        fillTree();
        countRelatedContacts();
        //printContactsMap();
        findPopularContacts();
    }

    private static void fillContacts() {
        Random random = new Random();
        for (Contact currentContact : contactsList) {
            int j = random.nextInt(PHONEBOOK_LIMIT);
            for (int i = 0; i < j; i++) {
                Contact randomCnt = contactsList.get(random.nextInt(SUBSCRIBERS));
                if (!currentContact.equals(randomCnt) && !currentContact.getContacts().contains(randomCnt)) {
                    currentContact.setContact(randomCnt);
                }
            }
        }
    }

    private static void fillTree() {
        for (Contact contact : contactsList) {
            Integer integer = 0;
            contactsMap.put(contact, integer);
        }
    }

    private static void countRelatedContacts() {
        LocalDateTime start = LocalDateTime.now();
        for (Contact contact : contactsList) {
            for (Contact relatedContact : contact.getContacts()) {
                int count = contactsMap.get(relatedContact);
                count++;
                contactsMap.replace(relatedContact, count);
            }
        }
        LocalDateTime finish = LocalDateTime.now();
        System.out.println(finish.getNano() - start.getNano());
    }

    private static void printContactsMap() {
        System.out.println("ВСЕ НОМЕРА");
        System.out.println("----------------------------------------------------------------------");
        contactsMap.forEach((contact, value) -> {
            System.out.println("----------------------------------------------------------------------");
            System.out.println(contact);
            System.out.println("Количество использования номера другими абонентами для абонента ");
            System.out.println(contact.getFIO() + ":");
            System.out.println(contactsMap.get(contact));
        });
    }

    private static void findPopularContacts() {
        System.out.println("ПОПУЛЯРНЫЕ НОМЕРА");
        System.out.println("----------------------------------------------------------------------");
        List<Contact> popularContacts = new ArrayList<>(10);
        Iterator<Map.Entry<Contact, Integer>> entries = contactsMap.entrySet().iterator();
        int max = 0;

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
        long elapsed = Duration.between(start, finish).toMillis();
////////////////////////////////////////////////////////////////////////////////////////////////////

        printContactsList(popularContacts);
        System.out.println("time:");
        System.out.println(elapsed);
    }

    private static void printContactsList(List<Contact> contacts) {
        for (Contact contact : contacts) {
            System.out.println(contact);
            System.out.println("Количество использования номера другими абонентами для абонента ");
            System.out.println(contact.getFIO());
            System.out.println(contactsMap.get(contact));
        }
    }
}
