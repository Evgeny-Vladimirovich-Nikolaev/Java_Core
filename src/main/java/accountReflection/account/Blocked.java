package accountReflection.account;

import java.lang.annotation.*;

@Documented
@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)

public @interface Blocked {
    boolean access() default true;
}
