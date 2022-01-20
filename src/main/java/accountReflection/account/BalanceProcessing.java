import java.math.BigDecimal;

public interface BalanceProcessing {

    BigDecimal getBalance();
    void withdraw(BigDecimal money);
    void deposit(BigDecimal money);

}
