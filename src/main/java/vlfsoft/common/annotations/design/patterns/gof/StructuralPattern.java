package vlfsoft.common.annotations.design.patterns.gof;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import vlfsoft.common.annotations.design.patterns.SoftwareDesignPattern;

/**
 * See <a href="https://en.wikipedia.org/wiki/Structural_pattern">Structural pattern</a>
 *
 * See <a href="https://en.wikipedia.org/wiki/Decorator_pattern">Decorator pattern</a>
 * {@link Adapter} Converts one interface to another so that it matches what the client is expecting
 * {@link Decorator} Dynamically adds responsibility to the interface by wrapping the original code
 * {@link Facade} Provides a simplified interface
 */
@SoftwareDesignPattern.Structural
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface StructuralPattern {

    /**
     * See <a href="https://en.wikipedia.org/wiki/Composite_pattern">Composite pattern</a>
     */
    @SoftwareDesignPattern.Structural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.FIELD})
    @interface Composite {
    }

    /**
     * See <a href="https://en.wikipedia.org/wiki/Proxy_pattern">Proxy_pattern</a>
     */
    @SoftwareDesignPattern.Structural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.FIELD})
    @interface Proxy {
    }

    /**
     * See <a href="https://en.wikipedia.org/wiki/Facade_pattern">Facade pattern</a>
     */
    @SoftwareDesignPattern.Structural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.FIELD})
    @interface Facade {

        @SoftwareDesignPattern.Structural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.FIELD})
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
    @SoftwareDesignPattern.Structural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.METHOD})
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
    @SoftwareDesignPattern.Structural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.FIELD})
    @interface Adapter {
        /**
         * In this adapter pattern, the adapter contains an instance of the class it wraps.
         * In this situation, the adapter makes calls to the instance of the wrapped object.
         */
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.FIELD})
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
    @SoftwareDesignPattern.Structural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE})
    @interface Bridge {

        @SoftwareDesignPattern.Structural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE})
        @interface Abstraction {
            @SoftwareDesignPattern.Structural
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.TYPE})
            @interface Refined {
            }
        }

        @SoftwareDesignPattern.Structural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE})
        @interface Implementor  {
            @SoftwareDesignPattern.Structural
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.TYPE})
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
    @SoftwareDesignPattern.Structural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.FIELD})
    @interface Flyweight {

        /**
         * Factory to produce new and re-use existing Flyweight from internal cache
         */
        @SoftwareDesignPattern.Structural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.FIELD})
        @interface Factory {
        }

        /**
         *  The state-dependent (extrinsic) part.
         *  Extrinsic state is stored or computed by client objects, and passed to the Flyweight when its operations are invoked.
         */
        @SoftwareDesignPattern.Structural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.FIELD})
        @interface Extrinsic {
        }

        /**
         *  The state-independent (intrinsic) part.
         *  Intrinsic state is stored (shared) in the Flyweight object.
         */
        @SoftwareDesignPattern.Structural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.FIELD})
        @interface Intrinsic {
        }


    }

}
