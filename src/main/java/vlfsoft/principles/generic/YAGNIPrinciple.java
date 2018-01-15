package vlfsoft.principles.generic;

import vlfsoft.principles.ProgrammingPrinciple;

import java.lang.annotation.*;

/**
 * See <a href="http://java-design-patterns.com/principles/#yagni">YAGNIPrinciple</a>
 * YAGNIPrinciple - you aren't gonna need it
 */
@ProgrammingPrinciple.Generic
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.ANNOTATION_TYPE})
public @interface YAGNIPrinciple {
    boolean value();
}
