import java.util.ArrayList;
import java.util.List;

public class Contact {

    private final String LAST_NAME;
    private final String FIRST_NAME;
    private final String PATRONYMIC;
    private String mobileOperator;
    private final String PHONE_NUMBER;
    private List<Contact> contacts;

    public Contact(String lastName,
                      String firstName,
                      String patronymic,
                      String mobileOperator,
                      String phoneNumber) {
        this.LAST_NAME = lastName;
        this.FIRST_NAME = firstName;
        this.PATRONYMIC = patronymic;
        this.mobileOperator = mobileOperator;
        this.PHONE_NUMBER = phoneNumber;
        contacts = new ArrayList<Contact>();
    }

    public String getLAST_NAME() {
        return LAST_NAME;
    }

    public String getFIRST_NAME() {
        return FIRST_NAME;
    }

    public String getPATRONYMIC() {
        return PATRONYMIC;
    }

    public String getMobileOperator() {
        return mobileOperator;
    }

    public void setMobileOperator(String mobileOperator) {
        this.mobileOperator = mobileOperator;
    }

    public String getPHONE_NUMBER() {
        return PHONE_NUMBER;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContact(Contact contact) {
        contacts.add(contact);
    }
}
