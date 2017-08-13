package vlfsoft.common.annotations.design.patterns;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import vlfsoft.common.annotations.design.DesignPattern;

/**
 * See <a href="https://en.wikipedia.org/wiki/Creational_pattern">Creational pattern</a>
 */
@DesignPattern.Creational
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface CreationalPattern {

    /**
     * See <a href="http://softwareengineering.stackexchange.com/questions/231274/property-container-design-pattern-in-depth-definition/231587">“Property Container” design-pattern in-depth definition</a>
     */
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
    @DesignPattern.Fundamental
    @interface PropertyContainer {
    }

    /**
     *
     *
     * See <a href="https://www.codeproject.com/Articles/1131770/Factory-Patterns-Simple-Factory-Pattern">https://www.codeproject.com/Articles/1131770/Factory-Patterns-Simple-Factory-Pattern</a>
     * See <a href="https://dzone.com/articles/factory-method-vs-simple-factory-1">Factory Method vs. Simple Factory</a>
     * a factory class which has a method that returns different types of object based on given input
     *
     * Creates objects without exposing the instantiation logic to the client and refers to the newly created object through a common interface.
     * It is a simplified version of {@link FactoryMethod}
     */
    @DesignPattern.Creational
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.METHOD})
    @DesignPattern.ETC
    @interface SimpleFactory {
    }

    /**
     * See <a href="https://en.wikipedia.org/wiki/Factory_method_pattern">Factory method pattern</a>
     * creational pattern that uses factory methods to deal with the problem of creating objects
     * without having to specify the exact class of the object that will be created.
     * This is done by creating objects by calling a factory method—either specified in an interface
     * and implemented by child classes, or implemented in a base class and optionally overridden
     * by derived classes—rather than by calling a constructor.
     *
     * Define an interface for creating an object, but let subclasses decide which class to instantiate.
     * Factory Method lets a class defer instantiation to subclasses
     *
     *
     * See <a href="https://sourcemaking.com/design_patterns/factory_method">Factory method pattern</a>
     * Factory Methods are usually called within Template Methods.
     * Factory Method is to creating objects as Template Method is to implementing an algorithm.
     * A superclass specifies all standard and generic behavior (using pure virtual "placeholders" for creation steps),
     * and then delegates the creation details to subclasses that are supplied by the client.
     */
    @DesignPattern.Creational
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.METHOD})
    @DesignPattern.GOF
    @interface FactoryMethod {
    }

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
    @DesignPattern.Creational
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.METHOD})
    @DesignPattern.GOF
    @interface AbstractFactory {
    }

    /**
     * See <a href="https://en.wikipedia.org/wiki/Singleton_pattern">Singleton pattern</a>
     * restricts the instantiation of a class to one object.
     * This is useful when exactly one object is needed to coordinate actions across the system.
     */
    @DesignPattern.Creational
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
    @DesignPattern.GOF
    @interface Singleton {

        @DesignPattern.Creational
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
        @DesignPattern.GOF
        @interface Lazy {
        }

        @DesignPattern.Creational
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
        @DesignPattern.GOF
        @interface NonLazy {
        }

    }


    /**
     * See <a href="https://en.wikipedia.org/wiki/Builder_pattern">Builder pattern</a>
     * the intention of the builder pattern is to find a solution to the telescoping constructor anti-pattern[citation needed].
     * The telescoping constructor anti-pattern occurs when the increase of object constructor parameter combination leads to an exponential
     * list of constructors. Instead of using numerous constructors, the builder pattern uses another object, a builder,
     * that receives each initialization parameter step by step and then returns the resulting constructed object at once.
     * The builder pattern has another benefit.
     * It can be used for objects that contain flat data (html code, SQL query, X.509 certificate...),
     * that is to say, data that can't be easily edited.
     * This type of data can't be edited step by step and must be edited at once.
     */
    @DesignPattern.Creational
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.METHOD})
    @DesignPattern.GOF
    @interface Builder {
    }

    /**
     * See <a href="https://en.wikipedia.org/wiki/Prototype_pattern">Prototype pattern</a>
     * The prototype pattern is a creational design pattern in software development. It is used when the type of objects to create is determined by a prototypical instance, which is cloned to produce new objects.
     */
    @DesignPattern.Creational
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.METHOD})
    @DesignPattern.GOF
    @interface Prototype {
    }


    /**
     * Instance of class can't be created with new.
     * Instance of class can be created with {@link CreationalPattern.FactoryMethod}.
     * Empty private constructor prevent creating instances of class with new.
     */
    @DesignPattern.Creational
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.METHOD})
    @DesignPattern.ETC
    @interface CreatedWithFactory {
    }

    /**
     * Instance of class can't be created with new.
     * Instance of class can't be created with @FactoryMethod.
     * Empty private constructor prevent creating instances of class with new.
     * contains only static methods.
     */
    @DesignPattern.Creational
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.CONSTRUCTOR})
    @DesignPattern.ETC
    @interface UtilityClass {
    }

}
