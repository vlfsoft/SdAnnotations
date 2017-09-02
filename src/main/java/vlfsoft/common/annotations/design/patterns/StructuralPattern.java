package vlfsoft.common.annotations.design.patterns;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import vlfsoft.common.annotations.design.DesignPattern;

/**
 * See <a href="https://en.wikipedia.org/wiki/Structural_pattern">Structural pattern</a>
 *
 * An adapter can be used when the wrapper must respect a particular interface and must support polymorphic behavior. Alternatively, a decorator makes it possible to add or alter behavior of an interface at run-time, and a Facade is used when an easier or simpler interface to an underlying object is desired.[2]
 * Pattern	Intent
 * Adapter or Wrapper	Converts one interface to another so that it matches what the client is expecting
 * Decorator	Dynamically adds responsibility to the interface by wrapping the original code
 * Delegation	Support "composition over inheritance"
 * Facade	Provides a simplified interface
 *
 * See <a href="https://en.wikipedia.org/wiki/Decorator_pattern">Decorator pattern</a>
 * {@link Adapter} Converts one interface to another so that it matches what the client is expecting
 * {@link Decorator} Dynamically adds responsibility to the interface by wrapping the original code
 * {@link Facade} Provides a simplified interface
 */
@DesignPattern.Structural
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface StructuralPattern {

    /**
     * See <a href="https://en.wikipedia.org/wiki/Composite_pattern">Composite pattern</a>
     */
    @DesignPattern.Structural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.FIELD})
    @DesignPattern.GOF
    @interface Composite {
    }

    /**
     * See <a href="https://en.wikipedia.org/wiki/Proxy_pattern">Proxy_pattern</a>
     * See <a href="https://sourcemaking.com/design_patterns/proxy">Proxy Design Pattern</a>
     */
    @DesignPattern.Structural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.FIELD})
    @DesignPattern.GOF
    @interface Proxy {

        /**
         * See <a href="https://sourcemaking.com/design_patterns/proxy">Proxy Design Pattern</a>
         * A virtual proxy is a placeholder for "expensive to create" objects. The real object is only created when a client first requests/accesses the object.
         */
        @DesignPattern.Structural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.FIELD})
        @DesignPattern.GOF
        @interface Virtual {
        }

        /**
         * See <a href="https://sourcemaking.com/design_patterns/proxy">Proxy Design Pattern</a>
         * A remote proxy provides a local representative for an object that resides in a different address space. This is what the "stub" code in RPC and CORBA provides.
         */
        @DesignPattern.Structural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.FIELD})
        @DesignPattern.GOF
        @interface Remote {
        }

        /**
         * See <a href="https://sourcemaking.com/design_patterns/proxy">Proxy Design Pattern</a>
         * A protective proxy controls access to a sensitive master object. The "surrogate" object checks that the caller has the access permissions required prior to forwarding the request.
         */
        @DesignPattern.Structural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.FIELD})
        @DesignPattern.GOF
        @interface Protective {
        }

        /**
         * See <a href="https://sourcemaking.com/design_patterns/proxy">Proxy Design Pattern</a>
         * A smart proxy interposes additional actions when an object is accessed. Typical uses include:<ul>
         * <li> Counting the number of references to the real object so that it can be freed automatically when there are no more references (aka smart pointer),
         * <li> Loading a persistent object into memory when it's first referenced,
         * <li> Checking that the real object is locked before it is accessed to ensure that no other object can change it.
         * </ul>
         */
        @DesignPattern.Structural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.FIELD})
        @DesignPattern.GOF
        @interface Smart {
        }

        @DesignPattern.Structural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.FIELD})
        @DesignPattern.GOF
        @interface RealObject {
        }
    }

    /**
     * See <a href="https://en.wikipedia.org/wiki/Facade_pattern">Facade pattern</a>
     */
    @DesignPattern.Structural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.FIELD})
    @DesignPattern.GOF
    @interface Facade {

        @DesignPattern.Structural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.FIELD})
        @DesignPattern.GOF
        @interface Subsystem {

        }
    }

    /**
     * See <a href="https://en.wikipedia.org/wiki/Decorator_pattern">Decorator pattern</a>
     * In object-oriented programming, the decorator pattern (also known as Wrapper,
     * an alternative naming shared with the Adapter pattern) is a design pattern
     * that allows behavior to be added to an individual object, either statically or dynamically,
     * without affecting the behavior of other objects from the same class.
     * The decorator pattern is often useful for adhering to the Single Responsibility Principle,
     * as it allows functionality to be divided between classes with unique areas of concern.
     */
    @DesignPattern.Structural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.METHOD})
    @DesignPattern.GOF
    @interface Decorator {
    }

    /**
     * See <a href="https://en.wikipedia.org/wiki/Adapter_pattern">Adapter or Wrapper or Translator pattern</a>
     * Convert the interface of a class into another interface clients expect.
     * An adapter lets classes work together that could not otherwise because of incompatible interfaces.
     * In software engineering, the adapter pattern is a software design pattern
     * (also known as Wrapper, an alternative naming shared with the Decorator pattern)
     * that allows the interface of an existing class to be used as another interface.[1]
     * It is often used to make existing classes work with others without modifying their source code.
     */
    @DesignPattern.Structural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.FIELD})
    @DesignPattern.GOF
    @interface Adapter {
        /**
         * In this adapter pattern, the adapter contains an instance of the class it wraps.
         * In this situation, the adapter makes calls to the instance of the wrapped object.
         */
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.FIELD})
        @DesignPattern.GOF
        @interface ObjectAdapter {
        }

        /**
         * This adapter pattern uses multiple polymorphic interfaces implementing or inheriting both the interface that is expected
         * and the interface that is pre-existing.
         * It is typical for the expected interface to be created as a pure interface class,
         * especially in languages such as Java (before jdk 1.8) that do not support multiple inheritance of classes.
         * See <a href="http://www.programcreek.com/2014/12/default-methods-in-java-8-and-multiple-inheritance">Default Methods in Java 8 and Multiple Inheritance</a>
         */
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.FIELD})
        @DesignPattern.GOF
        @interface ClassAdapter {
        }

    }

    /**
     * See <a href="https://en.wikipedia.org/wiki/Bridge_pattern">Bridge pattern</a>
     * The bridge pattern is a design pattern used in software engineering that is meant
     * to "decouple an abstraction from its implementation so that the two can vary independently"
     * The bridge uses encapsulation, aggregation, and can use inheritance to separate responsibilities into different classes.
     * The bridge pattern is often confused with the adapter pattern.
     * In fact, the bridge pattern is often implemented using the class {@link Adapter.ClassAdapter}
     */
    @DesignPattern.Structural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE})
    @DesignPattern.GOF
    @interface Bridge {

        @DesignPattern.Structural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE})
        @DesignPattern.GOF
        @interface Abstraction {

            @DesignPattern.Structural
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.TYPE})
            @DesignPattern.GOF
            @interface Refined {
            }

        }

        @DesignPattern.Structural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE})
        @DesignPattern.GOF
        @interface Implementation {

            @DesignPattern.Structural
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.TYPE})
            @DesignPattern.GOF
            @interface Generic {
            }

            @DesignPattern.Structural
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.TYPE})
            @DesignPattern.GOF
            @interface Concrete {
            }

        }

    }

    /**
     * See <a href="https://en.wikipedia.org/wiki/Flyweight_pattern">Flyweight pattern</a>
     * A flyweight is an object that minimizes memory usage by sharing as much data as possible with other similar objects;
     * it is a way to use objects in large numbers when a simple repeated representation would use an unacceptable amount of memory.
     * Often some parts of the object state can be shared, and it is common practice to hold them in external data structures and
     * pass them to the flyweight objects temporarily when they are used.
     */
    @DesignPattern.Structural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.FIELD})
    @DesignPattern.GOF
    @interface Flyweight {

        /**
         * Factory to produce new and re-use existing Flyweight from internal cache
         */
        @DesignPattern.Structural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.FIELD})
        @DesignPattern.GOF
        @interface Factory {
        }

        /**
         *  The state-dependent (extrinsic) part.
         *  Extrinsic state is stored or computed by client objects, and passed to the Flyweight when its operations are invoked.
         */
        @DesignPattern.Structural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.FIELD})
        @DesignPattern.GOF
        @interface Extrinsic {
        }

        /**
         *  The state-independent (intrinsic) part.
         *  Intrinsic state is stored (shared) in the Flyweight object.
         */
        @DesignPattern.Structural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.FIELD})
        @DesignPattern.GOF
        @interface Intrinsic {
        }


    }

    /**
     *  Reduces quantity of code to access variable.
     */
    @DesignPattern.Structural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.METHOD, ElementType.FIELD, ElementType.LOCAL_VARIABLE})
    @DesignPattern.ETC
    @interface ShorthandPattern {
    }

    /**
     * See <a href="https://sourcemaking.com/design_patterns/private_class_data">Private Class Data</a>
     * Control write access to class attributes
     * Separate data from methods that use it
     * Encapsulate class data initialization
     * Providing new type of final - final after constructor
     */
    @DesignPattern.Structural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.FIELD})
    @DesignPattern.ETC
    @interface PrivateClassData {
    }

}
