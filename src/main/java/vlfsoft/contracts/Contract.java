package vlfsoft.contracts;

import vlfsoft.patterns.enterprise.ddd.DDD;
import vlfsoft.tags.Related;

import java.lang.annotation.*;

@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.CONSTRUCTOR})
@Repeatable(Contracts.class)

@Related.Patterns(DDD.Invariant.class)
public @interface Contract {
    String value();
}
