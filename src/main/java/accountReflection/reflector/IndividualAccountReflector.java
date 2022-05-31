package accountReflection.reflector;

import accountReflection.account.Account;
import accountReflection.account.BalanceProcessing;
import accountReflection.account.Blocked;
import accountReflection.account.IndividualAccount;
import lombok.RequiredArgsConstructor;
import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.math.BigDecimal;
import java.rmi.AccessException;
import java.util.Arrays;

public class IndividualAccountReflector {

    private Class<?> klass;
    private Account account;
    private Account reflectAccount = null;
    private BalanceProcessing proxyAccount;
    private Constructor<?>[] constructors;
    private Field[] declaredFields;
    private Method[] declaredMethods;

    public IndividualAccountReflector(Account account) {
        this.account = account;
    }

    public void reflect() {
        extractClassMembers();
        createReflectAccount();
        readFields();
        readMethods();
        createProxyAccount();
        tryWithProxy();
    }

    private void extractClassMembers() {
        klass = account.getClass();
        constructors = klass.getDeclaredConstructors();
        declaredFields = klass.getDeclaredFields();
        declaredMethods = klass.getDeclaredMethods();
    }

    private void createReflectAccount() {
        System.out.println("ВЫЗОВЫ КОНСТРУКТОРОВ");
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
        System.out.println("ЧТЕНИЙ ПОЛЕЙ КЛАССА");
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
        System.out.println("ЧТЕНИЕ МЕТОДОВ И АННОТАЦИЙ К МЕТОДАМ");
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
        System.out.println("СОЗДАНИЕ ПРОКСИ-КЛАССА");
        proxyAccount = (BalanceProcessing) Proxy.newProxyInstance(IndividualAccountReflector.class.getClassLoader(),
                new Class[]{BalanceProcessing.class},
                new ProxyHandler(reflectAccount));
    }

    private void tryWithProxy() {
        System.out.println("ВЫЗОВЫ МЕТОДОВ ЧЕРЕЗ ПРОКСИ-КЛАСС");
        try {
            proxyAccount.deposit(new BigDecimal(10000));
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        try {
            proxyAccount.withdraw(new BigDecimal(1000));
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        try {
            proxyAccount.getBalance();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    @RequiredArgsConstructor
    private static class ProxyHandler implements InvocationHandler {

        private final BalanceProcessing origin;

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Method declaredMethod = origin.getClass().getDeclaredMethod(method.getName(), method.getParameterTypes());
            Blocked ann;
            Annotation[] annotations = declaredMethod.getDeclaredAnnotations();
            for (int i = 0; i < annotations.length; i++) {
                if (annotations[i].annotationType() == Blocked.class) {
                    ann = (Blocked) annotations[i];
                    if (ann.access()) {
                        return declaredMethod.invoke(origin, args);
                    } else {
                        throw new AccessException("Отказано в доступе к операции");
                    }
                }
            }
            return null;
        }
    }
}
