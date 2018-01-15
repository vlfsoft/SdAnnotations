package vlfsoft.principles.moduleclass;

import vlfsoft.principles.ProgrammingPrinciple;

import java.lang.annotation.*;

/**
 * See <a href="http://java-design-patterns.com/principles/#hide-implementation-details">Hide Implementation Details</a>
 */
@ProgrammingPrinciple.ModuleClass
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.ANNOTATION_TYPE})
public @interface HideImplementationDetailsPrinciple {
    boolean value();
}
