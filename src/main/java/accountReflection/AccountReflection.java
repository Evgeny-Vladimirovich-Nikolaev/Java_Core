package accountReflection;

import accountReflection.account.Account;
import accountReflection.account.IndividualAccount;
import accountReflection.account.LegalEntityAccount;
import accountReflection.reflector.IndividualAccountReflector;

import java.math.BigDecimal;

public class AccountReflection {

    public static void main(String[] args) {
        Account individualAccount = new IndividualAccount(new BigDecimal(1_000),"Bender", "Ostap", "Ibrahimovich");

        Account legalAccount = new LegalEntityAccount(new BigDecimal(1_000_000), "Horns&Hooves", "Chernomorsk");
        individualAccount.getBalance();
        legalAccount.getBalance();
        individualAccount.withdraw(new BigDecimal(1000));
        legalAccount.withdraw(new BigDecimal(10_000));
        individualAccount.getBalance();
        legalAccount.getBalance();

        System.out.println("\nВЫЗОВЫ МЕТОДОВ КЛАССА IndividualAccountReflector");
        new IndividualAccountReflector(individualAccount).reflect();
    }

}
