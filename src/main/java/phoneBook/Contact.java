import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Contact {

    private final String lastName;
    private final String firstName;
    private final String patronymic;
    private final Long phoneNumber;
    private final String typePhone;
    private String operator;
    private List<Contact> contactList;
    private Contact[] contactArray;

    public Contact(String[] fio,
                   long phoneNumber,
                   String typePhone,
                   String operator) {
        this.lastName = fio[0];
        this.firstName = fio[1];
        this.patronymic = fio[2];
        this.phoneNumber = phoneNumber;
        this.typePhone = typePhone;
        this.operator = operator;
        contactList = new ArrayList<>();
        fillContactArray();
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getMobileOperator() {
        return operator;
    }

    public void setMobileOperator(String mobileOperator) {
        this.operator = mobileOperator;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public String getTypePhone() {
        return typePhone;
    }

    public List<Contact> getContactList() {
        return contactList;
    }

    public void setContact(Contact contact) {
        contactList.add(contact);
    }

    void fillContactArray() {
        this.contactArray = new Contact[contactList.size()];
        int ind = 0;
        for(Contact contact : this.contactList) {
            this.contactArray[ind++] = contact;
        }
    }

    public Contact[] getContactArray() {
        return contactArray;
    }

    public String numberToString() {
        char[] c = phoneNumber.toString().toCharArray();
        String s = phoneNumber.toString();
        return String.format("+7 %s %s-%s-%s",
                s.substring(1, 4),
                s.substring(4, 7),
                s.substring(7, 9),
                s.substring(9));
    }

    public String getFIO() {
        return lastName + " " + firstName + " " + patronymic;
    }

    private Long[] contactsToArray () {
        Long[] numbersList = new Long[contactList.size()];
        int ind = 0;
        for (Contact contact : contactList) {
            numbersList[ind++] = contact.getPhoneNumber();
        }
        return numbersList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Contact cnt)) return false;
        return Objects.equals(phoneNumber, cnt.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operator);
    }

    @Override
    public String toString() {
        return "Абонент "
                + operator
                + ":\n"
                + getFIO() + "\n"
                + "Тип связи: " + typePhone + "\n"
                + "Номер: " + numberToString() + "\n"
                + "Связанные контакты:\n"
                + Arrays.toString(contactsToArray());
    }
}
