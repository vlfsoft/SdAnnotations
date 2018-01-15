package vlfsoft.principles.generic;

import vlfsoft.principles.ProgrammingPrinciple;

import java.lang.annotation.*;

/**
 * See <a href="http://java-design-patterns.com/principles/#separation-of-concerns">Separation of Concerns</a>
 */
@ProgrammingPrinciple.Generic
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.ANNOTATION_TYPE})
public @interface SeparationOfConcernsPrinciple {
    boolean value();
}
