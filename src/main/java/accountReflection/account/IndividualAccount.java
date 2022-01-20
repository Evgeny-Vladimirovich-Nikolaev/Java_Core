import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter


class IndividualAccount extends Account {

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



    @Blocked
    private void printMessage() {
        System.out.println("This method was called by using reflection");
    }

    @Override
    public String toString() {
        return "IndividualAccount{" +
                "lastName='" + lastName + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", phone='" + phone + '\'' +
                ", eMail='" + eMail + '\'' +
                '}';
    }
}