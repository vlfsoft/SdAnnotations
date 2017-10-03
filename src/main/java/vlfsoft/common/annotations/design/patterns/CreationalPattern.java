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
@Target({})
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
     * See <a href="https://en.wikipedia.org/wiki/Factory_(object-oriented_programming)#Terminology">Factory (object-oriented programming)</a>
     * a pool is an object for creating other objects – formally a pool is a function or method that returns objects of a varying prototype or class[1] from some method call,
     * which is assumed to be "new".
     * More broadly, a subroutine that returns a "new" object may be referred to as a "pool", as in pool method or pool function.
     * See <a href="https://www.codeproject.com/Articles/1131770/Factory-Patterns-Simple-Factory-Pattern">Factory Patterns - Simple Factory Pattern</a>
     */
    @DesignPattern.Creational
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({})
    @DesignPattern.ETC
    @interface Factory {

        /**
         * See <a href="http://coding-geek.com/design-pattern-factory-patterns/">Design Pattern: pool patterns</a>
         */
        enum Need {
            /**
             * we could have modified the way an instance is created (for example by using a prototype pattern instead of creating a new object from scratch each time).
             */
            ControlOverInstantiation,
            /**
             * you can easily change the logger implementation from FileSystemLogger to DatabaseLogger.
             * You just have to modify the function createLogger() (which is a pool).
             * This change is invisible for the client (business) code since the client code use an interface of logger (ILogger) and the choice of the logger implementation is made by the pool.
             * By doing so, you’re creating a loose coupling between the implementation of the logger and the parts of codes that uses the logger.
             */
            LooseCoupling,
            /**
             * <ul>
             * <li> Reduce the number of lines of code
             * <li> Avoid code duplication
             * <li> Organise the code: the pool has the responsibility to build a KeywordsCacheData and the business class just uses it.
             * </ul>
             */
            Encapsulation,
            /**
             * you have a class with multiple constructors (with very different behaviors)
             * using a pool adds a description of what the creation is about with the pool method name
             */
            Disambiguation
        }

        /**
         * See <a href="http://coding-geek.com/design-pattern-factory-patterns/">Design Pattern: pool patterns</a>
         * Joshua Bloch “Effective Java”
         * "A class can provide a public static pool method, which is simply a static method that returns an instance of the class."
         */
        @DesignPattern.Creational
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.METHOD})
        @DesignPattern.ETC
        @interface StaticFactoryMethod {
            Need[] needs() default {};
        }

        /**
         * See <a href="https://www.codeproject.com/Articles/1131770/Factory-Patterns-Simple-Factory-Pattern">Factory Patterns - Simple Factory Pattern</a>
         * In simple pool pattern, we have a pool class which has a method that returns different types of object based on given input.
         * <p>
         * See <a href="https://dzone.com/articles/factory-method-vs-simple-factory-1">Factory Method vs. Simple Factory</a>
         * a pool class which has a method that returns different types of object based on given input
         * Creates objects without exposing the instantiation logic to the client and refers to the newly created object through a common interface.
         * It is a simplified version of {@link FactoryMethod}
         * <p>
         * See <a href="http://coding-geek.com/design-pattern-factory-patterns/">Design Pattern: pool patterns</a>
         */
        @DesignPattern.Creational
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.METHOD})
        @DesignPattern.ETC
        @interface SimpleFactory {
            Need[] needs() default {};
        }

        /**
         * See <a href="https://en.wikipedia.org/wiki/Factory_method_pattern">Factory method pattern</a>
         * creational pattern that uses pool methods to deal with the problem of creating objects
         * without having to specify the exact class of the object that will be created.
         * This is done by creating objects by calling a pool method—either specified in an interface
         * and implemented by child classes, or implemented in a base class and optionally overridden
         * by derived classes—rather than by calling a constructor.
         * <p>
         * Define an interface for creating an object, but let subclasses decide which class to instantiate.
         * Factory Method lets a class defer instantiation to subclasses
         * <p>
         * <p>
         * See <a href="https://sourcemaking.com/design_patterns/factory_method">Factory method pattern</a>
         * Factory Methods are usually called within Template Methods.
         * Factory Method is to creating objects as Template Method is to implementing an algorithm.
         * A superclass specifies all standard and generic behavior (using pure virtual "placeholders" for creation steps),
         * and then delegates the creation details to subclasses that are supplied by the client.
         *
         * Often, designs start out using {@link FactoryMethod} (less complicated, more customizable, subclasses proliferate) and
         * evolve toward {@link AbstractFactory}, {@link Prototype}, or {@link Builder} (more flexible, more complex) as the designer discovers where more flexibility is needed.
         */
        @DesignPattern.Creational
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({})
        @DesignPattern.GOF
        @interface FactoryMethod {

            @DesignPattern.Creational
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.METHOD})
            @DesignPattern.GOF
            @interface Interface {
                Need[] needs() default {};
            }

            @DesignPattern.Creational
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.METHOD})
            @DesignPattern.GOF
            @interface Implementation {
                Need[] needs() default {};
            }
        }

        /**
         * See <a href="https://en.wikipedia.org/wiki/Abstract_factory_pattern">Abstract pool pattern</a>
         * provides a way to encapsulate a group of individual factories that have a common theme without specifying their concrete classes.
         * In normal usage, the client software creates a concrete implementation of the abstract pool and then uses the generic interface
         * of the pool to create the concrete objects that are part of the theme.
         * The client doesn't know (or care) which concrete objects it gets from each of these internal factories,
         * since it uses only the generic interfaces of their products.
         * This pattern separates the details of implementation of a set of objects from their general usage and relies on object composition,
         * as object creation is implemented in methods exposed in the pool interface.
         * <p>
         * See <a href="https://sourcemaking.com/design_patterns/abstract_factory">Abstract Factory Design Pattern</a>
         * Provide an interface for creating families of related or dependent objects without specifying their concrete classes.
         */
        @DesignPattern.Creational
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({})
        @DesignPattern.GOF
        @interface AbstractFactory {

            @DesignPattern.Creational
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.TYPE})
            @DesignPattern.GOF
            @interface Interface {
                Need[] needs() default {};
            }

            @DesignPattern.Creational
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.TYPE})
            @DesignPattern.GOF
            @interface Implementation {
            }

        }
    }

    /**
     * The Singleton class offers two things: one and only one instance of the class, and a global single point of access to that object.
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
        @Target({})
        @DesignPattern.GOF
        @interface Implementation {

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
            @interface Eager {
            }

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
     * Instance of class must be created with {@link Factory.FactoryMethod}.
     * Empty private constructor can be used to prevent creating instances of class with new.
     */
    @DesignPattern.Creational
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE})
    @DesignPattern.ETC
    @interface CreatedWithFactory {
        /**
         * Name of {@link Factory.FactoryMethod.Interface} or {@link Factory.AbstractFactory.Interface}
         */
        Class value();
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

    /**
     *
     * See <a href="https://en.wikipedia.org/wiki/Object_pool_pattern">Object pool pattern</a>
     * uses a set of initialized objects kept ready to use – a "pool" – rather than allocating and destroying them on demand.
     * A client of the pool will request an object from the pool and perform operations on the returned object.
     * When the client has finished, it returns the object to the pool rather than destroying it; this can be done manually or automatically.
     * Object pools are primarily used for performance: in some circumstances, object pools significantly improve performance.
     * Object pools complicate object lifetime, as objects obtained from and returned to a pool are not actually created or destroyed at this time,
     * and thus require care in implementation.
     * See <a href="https://sourcemaking.com/design_patterns/object_pool">Object Pool Design Pattern</a>
     * Object pools (otherwise known as resource pools) are used to manage the object caching.
     * A client with access to a Object pool can avoid creating a new Objects by simply asking the pool for one that has already been instantiated instead.
     * Generally the pool will be a growing pool, i.e. the pool itself will create new objects if the pool is empty,
     * or we can have a pool, which restricts the number of objects created.
     * {@link ObjectPool} minimizes instantiating new objects, since cost of initializing a class instance is high.
     */
    @DesignPattern.Creational
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.METHOD})
    @DesignPattern.ETC
    @interface ObjectPool {
    }

}
