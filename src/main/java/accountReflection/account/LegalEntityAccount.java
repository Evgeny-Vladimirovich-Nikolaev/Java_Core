import java.math.BigDecimal;

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

    public String getOrganizationName() {
        return organizationName;
    }

    public String getLegalAddress() {
        return legalAddress;
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
