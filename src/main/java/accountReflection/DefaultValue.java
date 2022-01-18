import java.lang.annotation.*;

@Documented
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DefaultValue {
    String value() default "15";
    Class<?> clazz() default DefaultValue.class;
}
