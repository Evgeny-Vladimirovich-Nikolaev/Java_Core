import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Contact {

    private final String lastName;
    private final String firstName;
    private final String patronymic;
    private final Long phoneNumber;
    private final String typePhone;
    private String operator;
    private List<Contact> contacts;

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
        contacts = new ArrayList<>();
    }

    public Contact(String[] fio,
                   String StringNumber,
                   String typePhone,
                   String operator) {
        this.lastName = fio[0];
        this.firstName = fio[1];
        this.patronymic = fio[2];
        this.phoneNumber = parseNumber(StringNumber);
        this.typePhone = typePhone;
        this.operator = operator;
        contacts = new ArrayList<>();
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

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContact(Contact contact) {
        contacts.add(contact);
    }

    private Long parseNumber( String number) {
        Long num = null;
        number = number.replace(" ", "");
        number = number.replace("+7", "8");
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(number);
        String res = "";
        while (m.find()) {
            res += m.group();
        }
        try {
            num = Long.parseLong(res);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.out.println("\"" + number + "\" - неправильный формат номера");
        }
        return num;
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
        Long[] numbersList = new Long[contacts.size()];
        int ind = 0;
        for (Contact contact : contacts) {
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
        return Objects.hash(phoneNumber);
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
