import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Contact {

    private final String LAST_NAME;
    private final String FIRST_NAME;
    private final String PATRONYMIC;
    private final Long PHONE_NUMBER;
    private final String typePhone;
    private String operator;
    private List<Contact> contacts;

    public Contact(String lastName,
                   String firstName,
                   String patronymic,
                   long phoneNumber,
                   String typePhone,
                   String operator) {
        this.LAST_NAME = lastName;
        this.FIRST_NAME = firstName;
        this.PATRONYMIC = patronymic;
        this.PHONE_NUMBER = phoneNumber;
        this.typePhone = typePhone;
        this.operator = operator;
        contacts = new ArrayList<>();
    }

    public Contact(String lastName,
                   String firstName,
                   String patronymic,
                   String phoneNumber,
                   String typePhone,
                   String operator) {
        this.LAST_NAME = lastName;
        this.FIRST_NAME = firstName;
        this.PATRONYMIC = patronymic;
        this.PHONE_NUMBER = parseNumber(phoneNumber);
        this.typePhone = typePhone;
        this.operator = operator;
        contacts = new ArrayList<>();
    }

    public Contact(String lastName,
                   String firstName,
                   String patronymic,
                   long phoneNumber,
                   String typePhone) {
        this.LAST_NAME = lastName;
        this.FIRST_NAME = firstName;
        this.PATRONYMIC = patronymic;
        this.PHONE_NUMBER = phoneNumber;
        this.typePhone = typePhone;
        contacts = new ArrayList<>();
    }

    public Contact(String lastName,
                   String firstName,
                   String patronymic,
                   String phoneNumber,
                   String typePhone) {
        this.LAST_NAME = lastName;
        this.FIRST_NAME = firstName;
        this.PATRONYMIC = patronymic;
        this.PHONE_NUMBER = parseNumber(phoneNumber);
        this.typePhone = typePhone;
        contacts = new ArrayList<>();
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
        return operator;
    }

    public void setMobileOperator(String mobileOperator) {
        this.operator = mobileOperator;
    }

    public long getPHONE_NUMBER() {
        return PHONE_NUMBER;
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
