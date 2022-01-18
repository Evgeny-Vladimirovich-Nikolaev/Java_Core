import java.lang.annotation.Annotation;


public class Reflector {

    public void reflect(Account acc) {
        Class klass = acc.getClass();
        Annotation[] annotations = klass.getAnnotations();
        for (Annotation a : annotations) {
            System.out.println("toString() " + a.toString());
            System.out.println("annotationType() " + a.annotationType());


        }
    }

}
