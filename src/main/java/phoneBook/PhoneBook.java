import java.util.*;


public class PhoneBook {

    public static void main(String[] args) {

        List<Contact> contacts = new ContactBuilder(1000).getContacts();
        Random random = new Random();
        for (Contact currentContact : contacts) {
            int j = random.nextInt(100);
            for(int i = 0; i < j; i++) {
                Contact cnt = contacts.get(random.nextInt(1000));
                if(!currentContact.equals(cnt) && !currentContact.getContacts().contains(cnt)) {
                    currentContact.setContact(cnt);
                }
            }
            System.out.println(currentContact.toString());
            System.out.println("----------------------------------------------");
        }
    }
}
