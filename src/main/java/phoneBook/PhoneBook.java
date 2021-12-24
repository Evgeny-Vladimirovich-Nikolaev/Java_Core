import java.util.*;

public class PhoneBook {

    private static final int SUBSCRIBERS = 10_0;
    private static final int PHONEBOOK_LIMIT = 100;
    private static List<Contact> contactsList = new ContactBuilder(SUBSCRIBERS).getContacts();
    private static HashMap<Contact, Integer> contactsMap = new HashMap<>();

    public static void main(String[] args) {
        fillContacts();
        fillTree();
        countContacts();
        extracted();
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
        System.out.println("ВСЕ НОМЕРА");
        System.out.println("--------------------------------------------------------");
        Iterator<Map.Entry<Contact, Integer>> entries = contactsMap.entrySet().iterator();
        while (entries.hasNext()){
            Contact currentContact = entries.next().getKey();
            System.out.println(currentContact);
            System.out.println("Количество использования номера другими абонентами для абонента ");
            System.out.println(
                    currentContact.getLastName() + " "
                    + currentContact.getFirstName() + " "
                    + currentContact.getPatronymic() + ":");
            System.out.println(contactsMap.get(currentContact));
        }
    }

    private static void extracted() {
        System.out.println("ПОПУЛЯРНЫЕ НОМЕРА");
        System.out.println("--------------------------------------------------------");

        HashMap<Contact, Integer> popularContacts = new HashMap<>();
        Iterator<Map.Entry<Contact, Integer>> entries = contactsMap.entrySet().iterator();
        Integer integer = 0;
        while (entries.hasNext()) {
            Contact currentContact = entries.next().getKey();
            if(contactsMap.get(currentContact) > integer) {
                popularContacts.clear();
                popularContacts.put(currentContact, contactsMap.get(currentContact));
            } else if (contactsMap.get(currentContact) == integer) {
                popularContacts.put(currentContact, contactsMap.get(currentContact));
            }
        }
        entries = popularContacts.entrySet().iterator();
        while (entries.hasNext()){
            Contact currentContact = entries.next().getKey();
            System.out.println(currentContact);
            System.out.println("Количество использования номера другими абонентами для абонента ");
            System.out.println(
                    currentContact.getLastName() + " "
                            + currentContact.getFirstName() + " "
                            + currentContact.getPatronymic() + ":");
            System.out.println(popularContacts.get(currentContact));
        }
    }
}
