package vlfsoft.principles.generic;

import vlfsoft.patterns.BehavioralPattern;
import vlfsoft.principles.moduleclass.OpenClosedPrinciple;
import vlfsoft.principles.ProgrammingPrinciple;
import vlfsoft.tags.SOLIDTag;

import java.lang.annotation.*;

/**
 * There are two kinds of software artifacts: frameworks/libraries, applications.
 * Frameworks/libraries are intended to help in developing applications. These artifacts solve common tasks and have to be abstract enough,
 * to be able to use in many applications, that vary from each other.
 * Applications solve more concrete tasks, and don't need the same abstraction level like Frameworks/libraries.
 * Applications modules unlike frameworks/libraries don't need to have many options to customize behavior following {@link OpenClosedPrinciple} principle, with patterns like {@link BehavioralPattern.Strategy}.
 * Rule of thumb:
 * Therefore, to avoid exaggerated complexity, start developing an application following base {@link SOLIDTag} principles, except {@link OpenClosedPrinciple} principle.
 * In many cases it will be simpler to modify sources of the application instead of customizing classes behaviour with patterns like {@link BehavioralPattern.Strategy} and etc.
 * Start to add customization options with patterns like {@link BehavioralPattern.Strategy} and etc, only if it's required to change behaviour of application by configuring it without modifying sources.
 * Hint: To make experiments with different options use comments, copy of source files, git branches and etc.
 */
@ProgrammingPrinciple.Generic
@KISSPrinciple(true)
@DoTheSimplestThingThatCouldPossiblyWorkPrinciple(true)
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.TYPE})
public @interface FromSimpleToComplexPrinciple {
    boolean value();
}
