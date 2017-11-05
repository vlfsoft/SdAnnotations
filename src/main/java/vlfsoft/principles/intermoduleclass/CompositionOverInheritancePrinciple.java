package vlfsoft.principles.intermoduleclass;

import vlfsoft.principles.ProgrammingPrinciple;

import java.lang.annotation.*;

/**
 * See <a href="http://java-design-patterns.com/principles/#composition-over-inheritance">Composition Over Inheritance</a>
 * See <a href="https://https://en.wikipedia.org/wiki/Composition_over_inheritance">Composition over inheritance</a>
 * Composition over inheritance (or composite reuse principle) in object-oriented programming (OOP) i the principle that classes should achieve polymorphic behavior and
 * code reuse by their composition (by containing instances of other classes that implement the desired functionality) rather than inheritance from a base or parent class.
 */
@ProgrammingPrinciple.InterModule
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
public @interface CompositionOverInheritancePrinciple {
    boolean value();
}
