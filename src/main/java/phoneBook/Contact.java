import java.util.ArrayList;
import java.util.List;
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
                   String phoneNumber,
                   String typePhone,
                   String operator) {
        this.lastName = fio[0];
        this.firstName = fio[1];
        this.patronymic = fio[2];
        this.phoneNumber = parseNumber(phoneNumber);
        this.typePhone = typePhone;
        this.operator = operator;
        contacts = new ArrayList<>();
    }

    public Contact(String[] fio,
                   long phoneNumber,
                   String typePhone) {
        this.lastName = fio[0];
        this.firstName = fio[1];
        this.patronymic = fio[2];
        this.phoneNumber = phoneNumber;
        this.typePhone = typePhone;
        contacts = new ArrayList<>();
    }

    public Contact(String[] fio,
                   String phoneNumber,
                   String typePhone) {
        this.lastName = fio[0];
        this.firstName = fio[1];
        this.patronymic = fio[2];
        this.phoneNumber = parseNumber(phoneNumber);
        this.typePhone = typePhone;
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
}
