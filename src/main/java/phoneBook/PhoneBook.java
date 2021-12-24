import java.util.*;

public class PhoneBook {

    private static final int SUBSCRIBERS = 10_000;
    private static final int PHONEBOOK_LIMIT = 100;
    private static List<Contact> contactsList = new ContactBuilder(SUBSCRIBERS).getContacts();
    private static HashMap<Contact, Integer> contactsMap = new HashMap<>();

    public static void main(String[] args) {
        fillContacts();
        fillTree();
        countContacts();
    }

    private static void fillContacts() {
        Random random = new Random();
        for (Contact currentContact : contactsList) {
            int j = random.nextInt(PHONEBOOK_LIMIT);
            for(int i = 0; i < j; i++) {
                Contact randomCnt = contactsList.get(random.nextInt(SUBSCRIBERS));
                if(!currentContact.equals(randomCnt) && !currentContact.getContacts().contains(randomCnt)) {
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

    private static void countContacts() {
        for (Contact contact : contactsList) {
            for (Contact caller : contact.getContacts()) {
               Integer integer = contactsMap.get(caller);
               integer++;
               contactsMap.put(caller, integer);
            }
        }
        System.out.println(contactsMap);
    }
}
