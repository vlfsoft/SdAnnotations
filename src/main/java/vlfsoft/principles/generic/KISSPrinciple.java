package vlfsoft.principles.generic;

import vlfsoft.principles.ProgrammingPrinciple;

import java.lang.annotation.*;

/**
 * See <a href="http://java-design-patterns.com/principles/#kiss">KISSPrinciple</a>
 * KISSPrinciple - Keep It Simple Stupid
 * Most systems work best if they are kept simple rather than made complex.
 * Why: Less code takes less time to write, has less bugs, and i easier to modify.
 * Why: Simplicity i the ultimate sophistication.
 * Why: It seems that perfection i reached not when there i nothing left to add, but when there i nothing left to take away.
 */
@ProgrammingPrinciple.Generic
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
public @interface KISSPrinciple {
    boolean value();
}
