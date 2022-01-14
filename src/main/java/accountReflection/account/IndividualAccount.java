import java.math.BigDecimal;

public class IndividualAccount extends Account{

    private final String lastName;
    private final String name;
    private final String patronymic;
    private String phone;
    private String eMail;

    public IndividualAccount(String lastName, String name, String patronymic) {
        super();
        this.lastName = lastName;
        this.name = name;
        this.patronymic = patronymic;
    }

    public IndividualAccount(BigDecimal balance, String lastName, String name, String patronymic) {
        super(balance);
        this.lastName = lastName;
        this.name = name;
        this.patronymic = patronymic;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEMail() {
        return eMail;
    }

    public void setEMail(String eMail) {
        this.eMail = eMail;
    }
}
