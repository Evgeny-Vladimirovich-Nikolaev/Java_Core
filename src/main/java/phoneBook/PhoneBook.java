import java.util.*;


public class PhoneBook {

    public static void main(String[] args) {

        List<Contact> contacts = new ContactBuilder(1000).getContacts();
        for (Contact c : contacts) {
            System.out.println(
                    c.getLastName()
                    + " "
                    + c.getFirstName()
                    + " "
                    + c.getPatronymic()
                    + " "
                    + c.getMobileOperator()
                    + " "
                    + c.getPhoneNumber());
        }
    }

}
