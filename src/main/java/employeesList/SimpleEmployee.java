import java.time.LocalDate;

public class SimpleEmployee {

    private final int id;
    private String lastName;
    private final String firstName;
    private final String patronymic;
    private final LocalDate hireDate;

    public SimpleEmployee(int id, String lastName, String firstName, String patronymic, LocalDate hireDate) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.hireDate = hireDate;
    }

    public int getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getFIO() {
        StringBuilder sb = new StringBuilder(lastName);
        sb.append(" ");
        sb.append(firstName);
        sb.append(" ");
        sb.append(patronymic);
        return sb.toString();
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    @Override
    public String toString() {
        return  "\nТабельный номер: " + id +
                "\nФамилия: " + lastName +
                "\nИмя: " + firstName +
                "\nОтчество: " + patronymic +
                "\nДата приема на работу: " + hireDate;
    }
}
