import java.math.BigDecimal;

public class AccountReflection {

    public static void main(String[] args) {
        Account acc = new IndividualAccount(new BigDecimal(1_000),"Bender", "Ostap", "Ibrahimovich");
        Account acc2 = new LegalEntityAccount(new BigDecimal(1_000_000), "Horns&Hooves", "Chernomorsk");
        System.out.println(acc.getNumber() + " " + acc.getBalance());
        System.out.println(acc2.getNumber() + " " + acc2.getBalance());
        acc.withdraw(new BigDecimal(1000));
        acc2.withdraw(new BigDecimal(10_000));
        System.out.println(acc.getNumber() + " " + acc.getBalance());
        System.out.println(acc2.getNumber() + " " + acc2.getBalance());

        new IndividualAccountReflector(acc).reflect();
    }

}
