package accountReflection.account;

import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Getter
@Setter
public class LegalEntityAccount extends Account {

    private final String organizationName;
    private final String legalAddress;
    private String phone;
    private String eMail;

    public LegalEntityAccount(String organizationName, String legalAddress) {
        super();
        this.organizationName = organizationName;
        this.legalAddress = legalAddress;
    }

    public LegalEntityAccount(BigDecimal balance, String organizationName, String legalAddress) {
        super(balance);
        this.organizationName = organizationName;
        this.legalAddress = legalAddress;
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
        return "LegalEntityAccount{" +
                "organizationName='" + organizationName + '\'' +
                ", legalAddress='" + legalAddress + '\'' +
                ", phone='" + phone + '\'' +
                ", eMail='" + eMail + '\'' +
                '}';
    }
}
