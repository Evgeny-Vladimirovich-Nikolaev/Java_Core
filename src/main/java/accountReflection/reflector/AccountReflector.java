import lombok.RequiredArgsConstructor;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.math.BigDecimal;
import java.util.Arrays;


public class AccountReflector {

    private Class<?> klass;
    private Account account;
    private Account reflectAccount = null;
    private BalanceChanging proxyAccount;
    private Constructor<?>[] constructors;
    private Field[] declaredFields;
    private Method[] declaredMethods;

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
        declaredFields = klass.getDeclaredFields();
        declaredMethods = klass.getDeclaredMethods();
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
        for (Field f : declaredFields) {
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
        for (Method m : declaredMethods) {
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
        proxyAccount.deposit(new BigDecimal(1000));
        proxyAccount.withdraw(new BigDecimal(10_000));
    }

    @RequiredArgsConstructor
    private static class ProxyHandler implements InvocationHandler {

        private final BalanceChanging origin;

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Object result = null;
            Method[] methods = origin.getClass().getDeclaredMethods();
            for(int i = 0; i < methods.length; i++) {
                Annotation annotation = methods[i].getAnnotation(Blocked.class);
                System.out.println("annotation = " + annotation );
            }



//            Parameter[] parameters = declaredMethod.getParameters();
//            for (int i = 0; i < parameters.length; i++) {
//                Parameter parameter = parameters[i];
//                DefaultValue de = parameter.getAnnotation(DefaultValue.class);
//                if (args[i] == null) {
//                    args[i] = Integer.decode(de.value());
//                }
//            }
//            DefaultValue annotation = declaredMethod.getAnnotation(DefaultValue.class);
//            Object result = declaredMethod.invoke(origin, args);
//            if (result == null && annotation != null) {
//                return Double.valueOf(annotation.value());
//            }
            return result;
        }
    }

}
