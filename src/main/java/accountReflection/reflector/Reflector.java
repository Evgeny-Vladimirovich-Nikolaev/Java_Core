import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;
import java.math.BigDecimal;


public class Reflector {

    public void reflect(Account acc) {
        Class<?> klass = acc.getClass();
        Constructor<?>[] constructors = klass.getConstructors();
        IndividualAccount account = null;
        for(int i = 0; i < constructors.length; i++) {
            try{
                account = (IndividualAccount) constructors[i].newInstance(new BigDecimal(1_000_000), "Zits", "Predsedatel", "Funt");
                System.out.printf("Конструктором № %s создан объект %s\n",
                        (i + 1),
                        account);
            } catch (InvocationTargetException |InstantiationException | IllegalAccessException |IllegalArgumentException e) {
                System.out.printf("Конструктор № %s не поддерживает такой набор аргументов\n", (i + 1));
                e.printStackTrace(System.out);
            }
        }

        Field[] fields = klass.getDeclaredFields();
        for (Field f : fields) {
            f.setAccessible(true);
            try {
                System.out.println(f.get(account));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            System.out.println(f);
            System.out.println(f.toGenericString());
        }

        IndividualAccount ac = (IndividualAccount) Proxy.newProxyInstance(Reflector.class.getClassLoader(),
                new Class[]{IndividualAccount.class},
                new ProxyHandler(account));


    }

}
