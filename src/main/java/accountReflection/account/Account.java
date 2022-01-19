import lombok.ToString;

import java.math.BigDecimal;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

abstract class Account {

    private static long accountsCounter = 0;
    private final long number;
    private BigDecimal balance;
    private Lock lock = new ReentrantLock();

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

    protected void withdraw(BigDecimal money) {
        if (lock.tryLock()
                && Double.parseDouble(money.toString()) <= Double.parseDouble(balance.toString())) {
            this.balance = this.balance.subtract(money);
        }
    }

    protected void deposit(BigDecimal money) {
        if (lock.tryLock()) {
            this.balance = this.balance.add(money);
        } else {
            lock.unlock();
        }
    }

    protected BigDecimal getBalance() {
        return balance;
    }


}
