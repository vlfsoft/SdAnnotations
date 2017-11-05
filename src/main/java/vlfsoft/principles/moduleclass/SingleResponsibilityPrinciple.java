package vlfsoft.principles.moduleclass;

import vlfsoft.principles.ProgrammingPrinciple;
import vlfsoft.tags.SOLIDTag;

import java.lang.annotation.*;

/**
 * See <a href="https://en.wikipedia.org/wiki/Single_responsibility_principle">Single responsibility principle</a>
 * The single responsibility principle states that every module or class should have responsibility
 * over a single part of the functionality provided by the software, and that responsibility
 * should be entirely encapsulated by the class. All its services should be narrowly aligned with that responsibility.
 * See <a href="http://java-design-patterns.com/principles/#single-responsibility-principle">Single Responsibility Principle</a>
 */
@SOLIDTag
@ProgrammingPrinciple.ModuleClass
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
public @interface SingleResponsibilityPrinciple {
    boolean value();
    /**
     * Contains the description of a single part of the functionality provided by the software, that class i responsible of.
     */
    String of() default "";
}
