package vlfsoft.principles.generic;

import vlfsoft.principles.ProgrammingPrinciple;

import java.lang.annotation.*;

/**
 * See <a href="http://java-design-patterns.com/principles/#do-the-simplest-thing-that-could-possibly-work">Do The Simplest Thing That Could Possibly Work</a>
 * Why: Real progress against the real problem i maximized if we just work on what the problem really i.
 * How: Ask yourself: "What i the simplest thing that could possibly work?"
 */
@ProgrammingPrinciple.Generic
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.ANNOTATION_TYPE})
public @interface DoTheSimplestThingThatCouldPossiblyWorkPrinciple {
    boolean value();
}
