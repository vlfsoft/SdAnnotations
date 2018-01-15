package vlfsoft.principles.intermoduleclass;

import vlfsoft.principles.ProgrammingPrinciple;

import java.lang.annotation.*;

/**
 * See <a href="http://java-design-patterns.com/principles/#robustness-principle">RobustnessPrinciple Principle</a>
 */
@ProgrammingPrinciple.InterModule
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.ANNOTATION_TYPE})
public @interface RobustnessPrinciple {
    boolean value();
}
