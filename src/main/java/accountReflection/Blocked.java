import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)

public @interface Blocked {

    long value() default 9_352_352_253L;
    boolean access() default false;
    Class<?> clazz() default DefaultValue.class;

}
