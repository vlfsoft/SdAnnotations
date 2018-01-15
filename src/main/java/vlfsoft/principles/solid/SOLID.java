package vlfsoft.principles.solid;

import vlfsoft.principles.ProgrammingPrinciple;
import vlfsoft.principles.moduleclass.MaximiseCohesionPrinciple;
import vlfsoft.tags.Related;

import java.lang.annotation.*;

/**
 *
 * See <a href="https://en.wikipedia.org/wiki/SOLID_(object-oriented_design)">SOLID (object-oriented design)</a>
 * a mnemonic acronym for five design principles intended to make software designs more understandable, flexible and maintainable.
 */
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({})
public @interface SOLID {
    /**
     * See <a href="https://en.wikipedia.org/wiki/Single_responsibility_principle">Single responsibility principle</a>
     * The single responsibility principle states that every module or class should have responsibility
     * over a single part of the functionality provided by the software, and that responsibility
     * should be entirely encapsulated by the class. All its services should be narrowly aligned with that responsibility.
     * See <a href="http://java-design-patterns.com/principles/#single-responsibility-principle">Single Responsibility Principle</a>
     * There should be never more than one reason for a class to change.
     *
     * See <a href="https://dzone.com/articles/single-responsibility-principle-done-right">Single-Responsibility Principle Done Right</a>
     * So, what is the relationship between the Single-Responsibility Principle and cohesion? Cohesion gives us a formal rule to apply when we are in doubt if a type owns more than one responsibility.
     * If a client of a type tends to always use all the functions of that type, then the type is probably highly cohesive.
     * This means that it owns only one responsibility, and hence has only one reason for changing.
     */
    @ProgrammingPrinciple.ModuleClass
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Related.Principles(MaximiseCohesionPrinciple.class)
    @interface SingleResponsibility {
        boolean value();
        /**
         * Contains the description of a single part of the functionality provided by the software, that class is responsible of.
         */
        String of() default "";
    }

    /**
     * See <a href="https://en.wikipedia.org/wiki/Open/closed_principle">Open/closed principle</a>
     * the open/closed principle states "software entities (classes, modules, functions, etc.) should be open for extension,
     * but closed for modification";[1] that i, such an entity can allow its behaviour to be extended without modifying its source code.
     * See <a href="http://java-design-patterns.com/principles/#liskov-substitution-principle">Open/Closed Principle</a>
     * Software entities (classes, modules, functions, etc.) should be open for extension, but closed for modification.
     */
    @ProgrammingPrinciple.ModuleClass
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @interface OpenClosed {
        boolean value();
    }

    /**
     * See <a href="https://en.wikipedia.org/wiki/Liskov_substitution_principle">Liskov substitution principle</a>
     * Substitutability i a principle in object-oriented programming stating that, in a computer program,
     * if S is a {@link Subtype} of {@link Type} T, then objects of {@link Type} T may be replaced with objects of {@link Subtype} S
     * (i.e. an object of {@link Type} T may be substituted with any object of a {@link Subtype} S)
     * without altering any of the desirable properties of {@link Type} T (correctness, task performed, etc.).
     * See <a href="http://java-design-patterns.com/principles/#liskov-substitution-principle">Liskov Substitution Principle</a>
     * Subtypes must be substitutable for their base types.
     */
    @ProgrammingPrinciple.ModuleClass
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @interface LiskovSubstitution {
        boolean value();

        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE})

        @interface Type {
        }

        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE})

        @interface Subtype {
        }

    }

    /**
     * See <a href="https://en.wikipedia.org/wiki/Interface_segregation_principle">Interface segregation principle</a>
     * The interface-segregation principle (ISP) states that no client should be forced to depend on methods it does not use.[1]
     * ISP splits interfaces that are very large into smaller and more specific ones so that clients will only have to know about the methods that are of interest to them.
     * Such shrunken interfaces are also called role interfaces.[2]
     * ISP is intended to keep a system decoupled and thus easier to refactor, change, and redeploy.
     * See <a href="http://java-design-patterns.com/principles/#interface-segregation-principle">Interface Segregation Principle</a>
     * Classes that implement interfaces, should not be forced to implement methods they do not use.
     */
    @ProgrammingPrinciple.ModuleClass
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @interface InterfaceSegregation {
        boolean value();
    }

    /**
     * See <a href="https://en.wikipedia.org/wiki/Dependency_inversion_principle">Dependency inversion principle</a>
     * the dependency inversion principle refers to a specific form of decoupling software modules.
     * When following this principle, the conventional dependency relationships established from high-level, policy-setting modules to low-level, dependency modules are reversed,
     * thus rendering high-level modules independent of the low-level module implementation details. The principle states:<ul>
     * <li> High-level modules should not depend on low-level modules. Both should depend on abstractions.
     * Java:
     * {@link Implementation.HighLevelModule} class should not contain fields with type {@link Implementation.LowLevelModule}.
     * {@link Implementation.HighLevelModule} class should contain fields with type {@link Abstraction} only.
     * <li> Abstractions should not depend on details. Details should depend on abstractions.
     * Java:
     * {@link Implementation} class implements/extends {@link Abstraction}
     * </ul>
     * This design principle inverts the way some people may think about object-oriented programming, dictating that both high- and low-level objects must depend on the same abstraction.
     * High-level modules should not depend on low level modules, rather both should depend on abstraction. Abstraction should not depend on details; rather detail should depend on abstraction.
     */
    @ProgrammingPrinciple.ModuleClass
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @interface DependencyInversion {

        boolean value();

        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE})
        @interface Abstraction {

            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.TYPE})

            @interface Refined {
            }

        }

        /**
         * details
         */
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE})
        @interface Implementation {

            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.TYPE})
            @interface HighLevelModule {
            }

            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.TYPE})
            @interface LowLevelModule {
            }

        }

    }
}
