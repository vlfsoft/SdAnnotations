package vlfsoft.principles.generic;

import vlfsoft.principles.ProgrammingPrinciple;

import java.lang.annotation.*;

/**
 * See <a href="http://java-design-patterns.com/principles/#do-the-simplest-thing-that-could-possibly-work">Do The Simplest Thing That Could Possibly Work</a>
 * Why: Real progress against the real problem is maximized if we just work on what the problem really is.
 * How: Ask yourself: "What is the simplest thing that could possibly work?"
 */
@ProgrammingPrinciple.Generic
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
public @interface DoTheSimplestThingThatCouldPossiblyWorkPrinciple {
}
