package vlfsoft.common.annotations.design.principles;

import java.lang.annotation.*;

/**
 * See <a href="https://en.wikipedia.org/wiki/SOLID_(object-oriented_design)">SOLID (object-oriented design)</a>
 * a mnemonic acronym for five design principles intended to make software designs more understandable, flexible and maintainable.
s */
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.TYPE})
public @interface SOLID {

    /**
     * See <a href="https://en.wikipedia.org/wiki/Single_responsibility_principle">Single responsibility principle</a>
     * The single responsibility principle states that every module or class should have responsibility
     * over a single part of the functionality provided by the software, and that responsibility
     * should be entirely encapsulated by the class. All its services should be narrowly aligned with that responsibility.
     */
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE})
    @interface SingleResponsibility {
        /**
         * Contains the description of a single part of the functionality provided by the software, that class is responsible over.
         */
        String over();
    }

    /**
     * See <a href="https://en.wikipedia.org/wiki/Open/closed_principle">Open/closed principle</a>
     * the open/closed principle states "software entities (classes, modules, functions, etc.) should be open for extension,
     * but closed for modification";[1] that is, such an entity can allow its behaviour to be extended without modifying its source code.
     */
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE})
    @interface OpenClosed {
    }

    /**
     * See <a href="https://en.wikipedia.org/wiki/Liskov_substitution_principle">Liskov substitution principle</a>
     * Substitutability is a principle in object-oriented programming stating that, in a computer program,
     * if S is a subtype of T, then objects of type T may be replaced with objects of type S (i.e. an object of type T may be substituted with any object of a subtype S)
     * without altering any of the desirable properties of T (correctness, task performed, etc.).
     */
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE})
    @interface LiskovSubstitution {
    }

    /**
     * See <a href="https://en.wikipedia.org/wiki/Interface_segregation_principle">Interface segregation principle</a>
     * The interface-segregation principle (ISP) states that no client should be forced to depend on methods it does not use.[1]
     * ISP splits interfaces that are very large into smaller and more specific ones so that clients will only have to know about the methods that are of interest to them.
     * Such shrunken interfaces are also called role interfaces.[2]
     * ISP is intended to keep a system decoupled and thus easier to refactor, change, and redeploy.
     */
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE})
    @interface InterfaceSegregation {
    }

    /**
     * See <a href="https://en.wikipedia.org/wiki/Dependency_inversion_principle">Dependency inversion principle</a>
     * the dependency inversion principle refers to a specific form of decoupling software modules.
     * When following this principle, the conventional dependency relationships established from high-level, policy-setting modules to low-level, dependency modules are reversed,
     * thus rendering high-level modules independent of the low-level module implementation details. The principle states:<ul>
     * <li> High-level modules should not depend on low-level modules. Both should depend on abstractions.
     * <li> Abstractions should not depend on details. Details should depend on abstractions.
     * </ul>
     * This design principle inverts the way some people may think about object-oriented programming, dictating that both high- and low-level objects must depend on the same abstraction.
     */
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE})
    @interface DI {
    }

}
