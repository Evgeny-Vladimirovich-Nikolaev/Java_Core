import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;


public class Reflector {

    public void reflect(Account acc) {
        Class<?> klass = acc.getClass();
        Constructor<?>[] constructors = klass.getConstructors();
        IndividualAccount account;
        for(int i = 0; i < constructors.length; i++) {
            try{
                account = (IndividualAccount) constructors[i].newInstance(new BigDecimal(1_000_000), "Zits", "Predsedatel", "Funt");
                System.out.printf("Конструктором № %s создан объект %s\n",
                        (i + 1),
                        account.toString());
            } catch (InvocationTargetException |InstantiationException | IllegalAccessException |IllegalArgumentException e) {
                System.out.printf("Конструктор № %s не поддерживает такой набор аргументов\n", (i + 1));
                e.printStackTrace(System.out);
            }
        }

        Field[] fields = klass.getFields();
        for (Field f : fields) {
            f.setAccessible(true);
            System.out.print("field ");
            System.out.println(f.toString());
        }


    }

}
