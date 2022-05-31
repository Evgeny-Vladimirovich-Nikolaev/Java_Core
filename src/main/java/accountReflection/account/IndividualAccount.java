package accountReflection.account;

import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Getter
@Setter
public class IndividualAccount extends Account {

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

    @Override
    @Blocked(access = false)
    public void deposit(BigDecimal money) {
        super.deposit(money);
    }

    @Override
    @Blocked(access = false)
    public void withdraw(BigDecimal money) {
        super.deposit(money);
    }

    @Override
    @Blocked
    public BigDecimal getBalance() {
        return super.getBalance();
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