package vlfsoft.common.annotations.design.patterns.gof;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import vlfsoft.common.annotations.design.patterns.SoftwareDesignPattern;

/**
 * See <a href="https://en.wikipedia.org/wiki/Creational_pattern">Creational pattern</a>
 */
@SoftwareDesignPattern.Creational
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface CreationalPattern {

    /**
     * See <a href="https://en.wikipedia.org/wiki/Abstract_factory_pattern">Abstract factory pattern</a>
     * provides a way to encapsulate a group of individual factories that have a common theme without specifying their concrete classes.
     * In normal usage, the client software creates a concrete implementation of the abstract factory and then uses the generic interface
     * of the factory to create the concrete objects that are part of the theme.
     * The client doesn't know (or care) which concrete objects it gets from each of these internal factories,
     * since it uses only the generic interfaces of their products.
     * This pattern separates the details of implementation of a set of objects from their general usage and relies on object composition,
     * as object creation is implemented in methods exposed in the factory interface.
     */
    @SoftwareDesignPattern.Creational
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.METHOD})
    @interface AbstractFactory {
    }

    /**
     * See <a href="https://en.wikipedia.org/wiki/Factory_method_pattern">Factory method pattern</a>
     * creational pattern that uses factory methods to deal with the problem of creating objects
     * without having to specify the exact class of the object that will be created.
     * This is done by creating objects by calling a factory method—either specified in an interface
     * and implemented by child classes, or implemented in a base class and optionally overridden
     * by derived classes—rather than by calling a constructor.
     */
    @SoftwareDesignPattern.Creational
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.METHOD})
    @interface FactoryMethod {
    }

    /**
     * See <a href="https://en.wikipedia.org/wiki/Singleton_pattern">Singleton_pattern</a>
     * restricts the instantiation of a class to one object.
     * This is useful when exactly one object is needed to coordinate actions across the system.
     */
    @SoftwareDesignPattern.Creational
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
    @interface Singleton {
    }


    /**
     * See <a href="https://en.wikipedia.org/wiki/Builder_pattern">Builder_pattern</a>
     * the intention of the builder pattern is to find a solution to the telescoping constructor anti-pattern[citation needed].
     * The telescoping constructor anti-pattern occurs when the increase of object constructor parameter combination leads to an exponential
     * list of constructors. Instead of using numerous constructors, the builder pattern uses another object, a builder,
     * that receives each initialization parameter step by step and then returns the resulting constructed object at once.
     * The builder pattern has another benefit.
     * It can be used for objects that contain flat data (html code, SQL query, X.509 certificate...),
     * that is to say, data that can't be easily edited.
     * This type of data can't be edited step by step and must be edited at once.
     */
    @SoftwareDesignPattern.Creational
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.METHOD})
    @interface Builder {
    }

}
