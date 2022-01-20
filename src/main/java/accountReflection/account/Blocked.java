import java.lang.annotation.*;

@Documented
@Inherited
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)

public @interface Blocked {

    boolean access() default false;
    Class<?> clazz() default Blocked.class;

}
