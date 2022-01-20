import java.lang.annotation.*;

@Documented
@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)

public @interface Blocked {

    boolean access() default true;
    Class<?> clazz() default Blocked.class;

}
