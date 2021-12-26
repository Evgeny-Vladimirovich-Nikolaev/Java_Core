import java.util.*;

public class Contact {

    private final String lastName;
    private final String firstName;
    private final String patronymic;
    private final Long phoneNumber;
    private final String typePhone;
    private String operator;
    private List<Contact> callersList;
    private HashSet<Contact> callersSet;
    private Contact[] callersArray;
    private HashMap<Contact, Long> callersMap;

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
        callersList = new ArrayList<>();
        callersSet = new HashSet<>();
        callersMap = new HashMap<>();
        fillCallersCollections();
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

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public String getTypePhone() {
        return typePhone;
    }

    public List<Contact> getCallersList() {
        return callersList;
    }

    public void setContact(Contact contact) {
        callersList.add(contact);
    }

    void fillCallersCollections() {
        callersArray = new Contact[callersList.size()];
        int ind = 0;
        for(Contact caller : callersList) {
            callersArray[ind++] = caller;
            callersSet.add(caller);
            callersMap.put(caller,caller.phoneNumber);
        }
    }

    public Contact[] getCallersArray() {
        return callersArray;
    }

    public HashSet<Contact> getCallersSet() {
        return callersSet;
    }

    public HashMap getCallersMap() {
        return callersMap;
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
        Long[] numbersList = new Long[callersList.size()];
        int ind = 0;
        for (Contact contact : callersList) {
            numbersList[ind++] = contact.getPhoneNumber();
        }
        return numbersList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact cnt = (Contact) o;
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
