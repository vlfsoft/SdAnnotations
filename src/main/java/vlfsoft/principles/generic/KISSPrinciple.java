package vlfsoft.principles.generic;

import vlfsoft.principles.ProgrammingPrinciple;

import java.lang.annotation.*;

/**
 * See <a href="http://java-design-patterns.com/principles/#kiss">KISSPrinciple</a>
 * KISSPrinciple - Keep It Simple Stupid
 * Most systems work best if they are kept simple rather than made complex.
 * Why: Less code takes less time to write, has less bugs, and is easier to modify.
 * Why: Simplicity is the ultimate sophistication.
 * Why: It seems that perfection is reached not when there is nothing left to add, but when there is nothing left to take away.
 */
@ProgrammingPrinciple.Generic
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
public @interface KISSPrinciple {
}
