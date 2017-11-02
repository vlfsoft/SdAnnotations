package vlfsoft.contracts;

import java.lang.annotation.*;

@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.CONSTRUCTOR})
public @interface Contracts {
    Contract[] value();
}
