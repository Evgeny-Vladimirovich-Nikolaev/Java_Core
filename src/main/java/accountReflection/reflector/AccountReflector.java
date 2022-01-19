import java.lang.reflect.*;
import java.math.BigDecimal;
import java.util.Arrays;


public class AccountReflector {

    private Class<?> klass;
    private Account account;
    private Account reflectAccount = null;
    private BalanceChanging proxyAccount;
    private Constructor<?>[] constructors;
    private Field[] fields;
    private Method[] methods;

    AccountReflector(Account account) {
        this.account = account;
    }

    public void reflect() {
        extractClassMembers();
        createReflectAccount();
        readFields();
        readMethods();
        createProxyAccount();
    }

    private void extractClassMembers() {
        klass = account.getClass();
        constructors = klass.getDeclaredConstructors();
        fields = klass.getDeclaredFields();
        methods = klass.getDeclaredMethods();
    }

    private void createReflectAccount() {
        for (int i = 0; i < constructors.length; i++) {
            try {
                reflectAccount = (IndividualAccount) constructors[i].newInstance(new BigDecimal(1_000_000), "Zits", "Predsedatel", "Funt");
                System.out.printf(
                        "Конструктором № %s создан объект %s\n",
                        (i + 1),
                        reflectAccount);
            } catch (InvocationTargetException | InstantiationException e) {
                e.printStackTrace(System.out);
            } catch (IllegalAccessException e) {
                System.out.println("Запрещен доступ к члену класса");
                e.printStackTrace(System.out);
            } catch (IllegalArgumentException e) {
                System.out.printf(
                        "Конструктор № %s не поддерживает такой набор аргументов\n",
                        (i + 1));
                e.printStackTrace(System.out);
            }
        }
    }

    private void readFields() {
        for (Field f : fields) {
            f.setAccessible(true);
            try {
                System.out.println(f);
                System.out.println(f.get(reflectAccount));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    private void readMethods() {
        for (Method m : methods) {
            m.setAccessible(true);
            try {
                System.out.println(m);
                System.out.println(Arrays.toString(m.getDeclaredAnnotations()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void createProxyAccount() {
        proxyAccount = (BalanceChanging) Proxy.newProxyInstance(AccountReflector.class.getClassLoader(),
                new Class[]{BalanceChanging.class},
                new ProxyHandler(reflectAccount));
    }

}
