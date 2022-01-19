import java.math.BigDecimal;

public interface BalanceChanging {

    void withdraw(BigDecimal money);

    void deposit(BigDecimal money);

}
