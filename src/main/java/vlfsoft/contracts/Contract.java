package vlfsoft.contracts;

import java.lang.annotation.*;

@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.CONSTRUCTOR})
@Repeatable(Contracts.class)
public @interface Contract {
    String value();
}
