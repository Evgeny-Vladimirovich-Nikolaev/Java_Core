package accountReflection.account;

import java.math.BigDecimal;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public abstract class Account implements BalanceProcessing {

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

    @Override
    @Blocked
    public void withdraw(BigDecimal money) {
        System.out.println("Снятие со счёта:\nбаланс до операции: " + balance);
        if (lock.tryLock()
                && Double.parseDouble(money.toString()) <= Double.parseDouble(balance.toString())) {
            this.balance = this.balance.subtract(money);
        }
        System.out.println("баланс после операции: " + balance);
    }

    @Override
    @Blocked
    public void deposit(BigDecimal money) {
        System.out.println("Пополнение счёта:\nбаланс до операции: " + balance);
        if (lock.tryLock()) {
            this.balance = this.balance.add(money);
        } else {
            lock.unlock();
        }
        System.out.println("баланс после операции: " + balance);
    }


    @Override
    @Blocked
    public BigDecimal getBalance() {
        System.out.printf("Баланс на счете № %s равен: %s \n",
                number,
                balance);
        return balance;
    }
}
