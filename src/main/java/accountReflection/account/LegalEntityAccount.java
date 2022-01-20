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
    @Blocked
    public BigDecimal getBalance() {
        return super.getBalance();
    }



}
