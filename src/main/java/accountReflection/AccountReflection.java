import java.math.BigDecimal;

public class AccountReflection {

    public static void main(String[] args) {
        Account acc = new IndividualAccount(new BigDecimal(10_000),"Zits", "Predsedatel", "Funt");
        Account acc2 = new LegalEntityAccount(new BigDecimal(1_000_000), "Horns&Hooves", "Chernomorsk");
        System.out.println(acc.getNumber() + " " + acc.getBalance());
        System.out.println(acc2.getNumber() + " " + acc2.getBalance());
        acc.withdraw(new BigDecimal(2000));
        acc2.withdraw(new BigDecimal(20_000));
        System.out.println(acc.getNumber() + " " + acc.getBalance());
        System.out.println(acc2.getNumber() + " " + acc2.getBalance());

        Reflector reflector = new Reflector();
        reflector.reflect(acc);
        reflector.reflect(acc2);
    }

}
