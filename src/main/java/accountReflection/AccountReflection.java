import java.math.BigDecimal;

public class AccountReflection {

    public static void main(String[] args) {
        Account acc = new IndividualAccount(new BigDecimal(1_000),"Bender", "Ostap", "Ibrahimovich");
        Account acc2 = new LegalEntityAccount(new BigDecimal(1_000_000), "Horns&Hooves", "Chernomorsk");
        acc.getBalance();
        acc2.getBalance();
        acc.withdraw(new BigDecimal(1000));
        acc2.withdraw(new BigDecimal(10_000));
        acc.getBalance();
        acc2.getBalance();

        System.out.println("\nВЫЗОВЫ МЕТОДОВ КЛАССА IndividualAccountReflector");
        new IndividualAccountReflector(acc).reflect();
    }

}
