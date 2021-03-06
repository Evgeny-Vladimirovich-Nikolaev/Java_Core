package phoneBook;

import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class PhoneBook {

    private static final int SUBSCRIBERS = 10_000;
    private static final int PHONEBOOK_LIMIT = 100;
    private static List<Contact> contactsList = new ContactBuilder(SUBSCRIBERS).getContacts();
    private static Contact[] contactsArray = contactsListToArray();
    private static Set<Contact> contactsSet = contactsListToSet();
    private static HashMap<Contact, Long> contactsMap = contactsListToMap();
    private static HashMap<Contact, Integer> relatedContactsMap = new HashMap<>();

    public static void main(String[] args) {
        fillContacts();
        countRelatedContactsByLists();
        countRelatedContactsBySets();
        countRelatedContactsByArrays();
        countRelatedContactsByMaps();
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

    private static HashMap<Contact, Long> contactsListToMap() {
        HashMap<Contact, Long> map = new HashMap<>();
        for(Contact contact : contactsList) {
            map.put(contact, contact.getPhoneNumber());
        }
        return map;
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

    private static void fillRelatedContactsMap() {
        for (Contact contact : contactsList) {
            Integer integer = 0;
            relatedContactsMap.put(contact, integer);
        }
    }

    private static void countRelatedContactsByLists() {
        //???????????????????? ???? ?????????????? ???????????????? ????????
        ///////////////////////////////////////////////////////////////////////////////////////////////////
        fillRelatedContactsMap();
        Instant start = Instant.now();
        for (Contact contact : contactsList) {
            for (Contact relatedContact : contact.getCallersList()) {
                int count = relatedContactsMap.get(relatedContact);
                count++;
                relatedContactsMap.replace(relatedContact, count);
            }
        }
        Instant finish = Instant.now();
        ///////////////////////////////////////////////////////////////////////////////////////////////////
        long timeByLists = Duration.between(start, finish).toMillis();
        System.out.println("----------------------------------------------------------------------");
        System.out.println("?????????????? ?????????????????? ?? ?????????????????? ??????????????: " + timeByLists + " ????");
        findPopularContactsByMap();
    }

    private static void countRelatedContactsByMaps() {
        //???????????????????? ???? ?????????????? ???????????????? ????????
        ///////////////////////////////////////////////////////////////////////////////////////////////////
        fillRelatedContactsMap();
        Instant start = Instant.now();
        Iterator<Map.Entry<Contact, Long>> outEntries = contactsMap.entrySet().iterator();
        while (outEntries.hasNext()) {
            Contact currentContact = outEntries.next().getKey();
            Iterator<Map.Entry<Contact, Long>> inEntries
                    = currentContact.getCallersMap().entrySet().iterator();
            while(inEntries.hasNext()) {
                Contact relatedContact = inEntries.next().getKey();
                int count = relatedContactsMap.get(relatedContact);
                count++;
                relatedContactsMap.replace(relatedContact, count);
            }
        }
        Instant finish = Instant.now();
        ///////////////////////////////////////////////////////////////////////////////////////////////////
        long timeByMaps = Duration.between(start, finish).toMillis();
        System.out.println("----------------------------------------------------------------------");
        System.out.println("?????????????? ???????????????? ?? ?????????????????? ????????: " + timeByMaps + " ????");
        findPopularContactsByMap();
    }

    private static void countRelatedContactsBySets() {
        //???????????????????? ???? ?????????????? ???????????????? ????????
        ///////////////////////////////////////////////////////////////////////////////////////////////////
        fillRelatedContactsMap();
        Instant start = Instant.now();
        for (Contact contact : contactsSet) {
            for (Contact relatedContact : contact.getCallersSet()) {
                int count = relatedContactsMap.get(relatedContact);
                count++;
                relatedContactsMap.replace(relatedContact, count);
            }
        }
        Instant finish = Instant.now();
        ///////////////////////////////////////////////////////////////////////////////////////////////////
        long timeBySets = Duration.between(start, finish).toMillis();
        System.out.println("----------------------------------------------------------------------");
        System.out.println("?????????????? ?????????????????? ?? ?????????????????? ????????????????: " + timeBySets + " ????");
        findPopularContactsByMap();
    }

    private static void countRelatedContactsByArrays() {
        //???????????????????? ???? ?????????????? ???????????????? ????????
        ///////////////////////////////////////////////////////////////////////////////////////////////////
        fillRelatedContactsMap();
        Instant start = Instant.now();
        for (Contact contact : contactsArray) {
            for (Contact relatedContact : contact.getCallersArray()) {
                int count = relatedContactsMap.get(relatedContact);
                count++;
                relatedContactsMap.replace(relatedContact, count);
            }
        }
        Instant finish = Instant.now();
        ///////////////////////////////////////////////////////////////////////////////////////////////////
        long timeByArrays = Duration.between(start, finish).toMillis();
        System.out.println("----------------------------------------------------------------------");
        System.out.println("?????????????? ?????????????????? ?? ?????????????????? ????????????????: " + timeByArrays + " ????");
        findPopularContactsByMap();
    }

    private static void printContactsMap() {
        System.out.println("?????? ????????????");
        System.out.println("----------------------------------------------------------------------");
        relatedContactsMap.forEach((contact, value) -> {
            System.out.println("----------------------------------------------------------------------");
            System.out.println(contact);
            System.out.println("???????????????????? ?????????????????????????? ???????????? ?????????????? ???????????????????? ?????? ???????????????? ");
            System.out.print(contact.getFIO() + ":");
            System.out.println(relatedContactsMap.get(contact));
        });
    }

    private static void findPopularContactsByMap() {
        List<Contact> popularContacts = new ArrayList<>();
        Iterator<Map.Entry<Contact, Integer>> entries = relatedContactsMap.entrySet().iterator();
        int max = 0;
        //???????????????????? ???? ?????????????? ???????????????? ????????
        ///////////////////////////////////////////////////////////////////////////////////////////////////
        Instant start = Instant.now();
        while (entries.hasNext()) {
            Contact currentContact = entries.next().getKey();
            int temp = relatedContactsMap.get(currentContact);
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
        System.out.println("?????????? ???????????? ?????????? relatedContactsMap: " + timeByMap + " ????");
        printContactsList(popularContacts);
    }

    private static void printContactsList(List<Contact> contacts) {
        System.out.println("???????????????????? ????????????");
        System.out.println("----------------------------------------------------------------------");
        for (Contact contact : contacts) {
            System.out.println(contact);
            System.out.println("???????????????????? ?????????????????????????? ???????????? ?????????????? ???????????????????? ?????? ???????????????? ");
            System.out.print(contact.getFIO() + ":");
            System.out.println(relatedContactsMap.get(contact));
        }
    }

}
