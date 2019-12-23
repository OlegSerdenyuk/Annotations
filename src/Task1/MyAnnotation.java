package Task1;

import java.lang.annotation.*;

@Inherited
@Target(value =ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    int a();
    int b();

}
