package vlfsoft.common.annotations.design.patterns;

import vlfsoft.common.annotations.design.DesignPattern;

import java.lang.annotation.*;

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
     *  the composite pattern is a partitioning design pattern.
     *  The composite pattern describes a group of objects that is treated the same way as a single instance of the same type of object.
     *  The intent of a composite is to "compose" objects into tree structures to represent part-whole hierarchies.
     *  Implementing the composite pattern lets clients treat individual objects and compositions uniformly.
     *  Composite should be used when clients ignore the difference between compositions of objects and individual objects.[1]
     *  If programmers find that they are using multiple objects in the same way, and often have nearly identical code to handle each of them, then composite is a good choice;
     *  it is less complex in this situation to treat primitives and composites as homogeneous.
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
     * a class functioning as an interface to something else.
     * The proxy could interface to anything: a network connection, a large object in memory, a file, or some other resource that is expensive or impossible to duplicate.
     * In short, a proxy is a wrapper or agent object that is being called by the client to access the real serving object behind the scenes.
     * Use of the proxy can simply be forwarding to the real object, or can provide additional logic. In the proxy, extra functionality can be provided,
     * for example caching when operations on the real object are resource intensive, or checking preconditions before operations on the real object are invoked.
     * For the client, usage of a proxy object is similar to using the real object, because both implement the same interface.
     * See <a href="https://sourcemaking.com/design_patterns/proxy">Proxy Design Pattern</a>
     */
    @DesignPattern.Structural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.FIELD})
    @DesignPattern.GOF
    @interface Proxy {

        @DesignPattern.Structural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE})
        @DesignPattern.GOF
        @interface Abstraction {
        }

        /**
         * See <a href="https://en.wikipedia.org/wiki/Proxy_pattern">Proxy_pattern</a>
         * In place of a complex or heavy object, a skeleton representation may be advantageous in some cases.
         * When an underlying image is huge in size, it may be represented using a virtual proxy object, loading the real object on demand.
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
         * See <a href="https://en.wikipedia.org/wiki/Proxy_pattern">Proxy_pattern</a>
         * In distributed object communication, a local object represents a remote object (one that belongs to a different address space).
         * The local object is a proxy for the remote object, and method invocation on the local object results in remote method invocation on the remote object.
         * An example would be an ATM implementation, where the ATM might hold proxy objects for bank information that exists in the remote server.
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
         * See <a href="https://en.wikipedia.org/wiki/Proxy_pattern">Proxy_pattern</a>
         * A protection proxy might be used to control access to a resource based on access rights.
         * See <a href="https://sourcemaking.com/design_patterns/proxy">Proxy Design Pattern</a>
         * A protective proxy controls access to a sensitive master object. The "surrogate" object checks that the caller has the access permissions required prior to forwarding the request.
         */
        @DesignPattern.Structural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.FIELD})
        @DesignPattern.GOF
        @interface Protection {
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

        /**
         * See <a href="https://en.wikipedia.org/wiki/Bridge_pattern">Bridge pattern</a>
         * Abstraction (abstract class) {@link Bridge.Abstraction.Class}: defines the abstract interface {@link Bridge.Abstraction.Interface}, maintains the Implementor reference {@link Bridge.Implementation.Reference}.
         */
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
            @interface Class {
            }

            @DesignPattern.Structural
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.TYPE})
            @DesignPattern.GOF
            @interface Interface {
            }

            /**
             * See <a href="https://en.wikipedia.org/wiki/Bridge_pattern">Bridge pattern</a>
             * RefinedAbstraction (normal class) {@link Bridge.Abstraction.Refined.Class}: extends (optionally) the interface defined by {@link Abstraction}, extends abstract class {@link Bridge.Abstraction}
             */
            @DesignPattern.Structural
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.TYPE})
            @DesignPattern.GOF
            @interface Refined {

                @DesignPattern.Structural
                @Documented
                @Inherited
                @Retention(RetentionPolicy.SOURCE)
                @Target({ElementType.TYPE})
                @DesignPattern.GOF
                @interface Class {
                }
            }

        }

        /**
         * See <a href="https://en.wikipedia.org/wiki/Bridge_pattern">Bridge pattern</a>
         * Implementor (interface) {@link Bridge.Implementation.Interface}: defines the interface for implementation classes {@link Bridge.Implementation.Concrete.Class}
         */
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
            @interface Interface {
            }

            @DesignPattern.Structural
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.FIELD})
            @DesignPattern.GOF
            @interface Reference {
            }

            /**
             * See <a href="https://en.wikipedia.org/wiki/Bridge_pattern">Bridge pattern</a>
             * ConcreteImplementor (normal class): implements the Implementor interface
             */
            @DesignPattern.Structural
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.TYPE})
            @DesignPattern.GOF
            @interface Concrete {

                @DesignPattern.Structural
                @Documented
                @Inherited
                @Retention(RetentionPolicy.SOURCE)
                @Target({ElementType.TYPE})
                @DesignPattern.GOF
                @interface Class {
                }

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
