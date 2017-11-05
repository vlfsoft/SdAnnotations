package vlfsoft.concepts;

import java.lang.annotation.*;

/**
 * See <a href="https://en.wikipedia.org/wiki/Technical_debt">Technical debt</a>
 * Concept in software development that reflects the implied cost of additional rework caused by choosing an easy solution now instead of using a better approach that would take longer.[2].
 */
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.LOCAL_VARIABLE, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE_PARAMETER, ElementType.PACKAGE})
@SoftwareDevelopmentConcept
@Repeatable(TechnicalDebts.class)
public @interface TechnicalDebt {
    String value();
    String due() default "";
}
