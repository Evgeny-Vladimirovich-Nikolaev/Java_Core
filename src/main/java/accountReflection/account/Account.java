import java.math.BigDecimal;

public abstract class Account {

    private static long accountsCounter = 0;
    private final long number;
    private BigDecimal balance;

    protected Account() {
        this.number = ++accountsCounter;
    }

    protected Account(BigDecimal balance) {
        this();
        this.balance = balance;
    }

    protected long getNumber() {
        return number;
    }

}
