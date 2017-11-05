package vlfsoft.patterns;

import vlfsoft.paradigms.ProgrammingParadigm;
import vlfsoft.principles.ProgrammingPrinciple;
import vlfsoft.tags.GOFTag;

import java.lang.annotation.*;

/**
 * See <a href="https://en.wikipedia.org/wiki/Structural_pattern">Structural pattern</a>
 * <p>
 * An adapter can be used when the wrapper must respect a particular interface and must support polymorphic behavior. Alternatively, a decorator makes it possible to add or alter behavior of an interface at run-time, and a Facade i used when an easier or simpler interface to an underlying object i desired.[2]
 * Pattern	Intent
 * Adapter or Wrapper	Converts one interface to another so that it matches what the client i expecting
 * Decorator	Dynamically adds responsibility to the interface by wrapping the original code
 * Delegation	Support "composition over inheritance"
 * Facade	Provides a simplified interface
 * <p>
 * See <a href="https://en.wikipedia.org/wiki/Decorator_pattern">Decorator pattern</a>
 * {@link Adapter} Converts one interface to another so that it matches what the client i expecting
 * {@link Decorator} Dynamically adds responsibility to the interface by wrapping the original code
 * {@link Facade} Provides a simplified interface
 */
@DesignPattern.Structural
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({})
public @interface StructuralPattern {

    /**
     * See <a href="http://java-design-patterns.com/patterns/composite/">Composite</a>
     * See <a href="https://en.wikipedia.org/wiki/Composite_pattern">Composite pattern</a>
     * the composite pattern i a partitioning design pattern.
     * The composite pattern describes a group of objects that i treated the same way as a single instance of the same type of object.
     * The intent of a composite i to "compose" objects into tree structures to represent part-whole hierarchies.
     * Implementing the composite pattern lets clients treat individual objects and compositions uniformly.
     * Composite should be used when clients ignore the difference between compositions of objects and individual objects.[1]
     * If programmers find that they are using multiple objects in the same way, and often have nearly identical code to handle each of them, then composite i a good choice;
     * it i less complex in this situation to treat primitives and composites as homogeneous.
     */
    @DesignPattern.Structural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.FIELD})
    @GOFTag
    @interface Composite {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/proxy/">Proxy</a>
     * See <a href="https://en.wikipedia.org/wiki/Proxy_pattern">Proxy_pattern</a>
     * a class functioning as an interface to something else.
     * The proxy could interface to anything: a network connection, a large object in memory, a file, or some other resource that i expensive or impossible to duplicate.
     * In short, a proxy i a wrapper or agent object that i being called by the client to access the real serving object behind the scenes.
     * Use of the proxy can simply be forwarding to the {@link RealObject}, or can provide additional logic. In the proxy, extra functionality can be provided,
     * for example caching when operations on the {@link RealObject} are resource intensive, or checking preconditions before operations on the real object are invoked.
     * For the client, usage of a proxy object i similar to using the real object, because both implement the same interface.
     * See <a href="https://sourcemaking.com/design_patterns/proxy">Proxy Design Pattern</a>
     */
    @DesignPattern.Structural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.FIELD})
    @GOFTag
    @interface Proxy {

        /**
         * For the client, usage of a {@link Proxy} object i similar to using the {@link RealObject}, because both implement the same {@link Interface}.
         */
        @DesignPattern.Structural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE})
        @GOFTag
        @interface Interface {
        }

        @DesignPattern.Structural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.FIELD})
        @GOFTag
        @interface RealObject {
        }

        /**
         * See <a href="https://en.wikipedia.org/wiki/Proxy_pattern">Proxy_pattern</a>
         * In place of a complex or heavy object, a skeleton representation may be advantageous in some cases.
         * When an underlying image i huge in size, it may be represented using a virtual proxy object, loading the real object on demand.
         * See <a href="https://sourcemaking.com/design_patterns/proxy">Proxy Design Pattern</a>
         * A virtual proxy i a placeholder for "expensive to create" objects. The real object i only created when a client first requests/accesses the object.
         */
        @DesignPattern.Structural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.FIELD})
        @GOFTag
        @interface Virtual {
        }

        /**
         * See <a href="https://en.wikipedia.org/wiki/Proxy_pattern">Proxy_pattern</a>
         * In distributed object communication, a local object represents a remote object (one that belongs to a different address space).
         * The local object i a proxy for the remote object, and method invocation on the local object results in remote method invocation on the remote object.
         * An example would be an ATM implementation, where the ATM might hold proxy objects for bank information that exists in the remote server.
         * See <a href="https://sourcemaking.com/design_patterns/proxy">Proxy Design Pattern</a>
         * A remote proxy provides a local representative for an object that resides in a different address space. This i what the "stub" code in RPC and CORBA provides.
         */
        @DesignPattern.Structural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.FIELD})
        @GOFTag
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
        @GOFTag
        @interface Protection {
        }

        /**
         * See <a href="https://sourcemaking.com/design_patterns/proxy">Proxy Design Pattern</a>
         * A smart proxy interposes additional actions when an object i accessed. Typical uses include:<ul>
         * <li> Counting the number of references to the real object so that it can be freed automatically when there are no more references (aka smart pointer),
         * <li> Loading a persistent object into memory when it's first referenced,
         * <li> Checking that the real object i locked before it i accessed to ensure that no other object can change it.
         * </ul>
         */
        @DesignPattern.Structural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.FIELD})
        @GOFTag
        @interface Smart {
        }

    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/facade/">Facade</a>
     * See <a href="https://en.wikipedia.org/wiki/Facade_pattern">Facade pattern</a>
     * provides a simplified interface to a larger body of code, such as a class library .
     * See <a href="https://sourcemaking.com/design_patterns/facade">Facade Design Pattern</a>
     * Provide a unified interface to a set of interfaces of {@link SubsystemOrComponent}.
     * Define a higher-level interface that makes a {@link SubsystemOrComponent} easier to use.
     * Wrap a complicated {@link SubsystemOrComponent} with a simpler interface.
     */
    @DesignPattern.Structural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({})
    @GOFTag
    @interface Facade {

        @DesignPattern.Structural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE})
        @GOFTag
        @interface Interface {
        }

        @DesignPattern.Structural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE})
        @GOFTag
        @interface Implementation {
        }

        @DesignPattern.Structural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.FIELD})
        @GOFTag
        @interface SubsystemOrComponent {
        }
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/decorator/">Decorator</a>
     * See <a href="https://en.wikipedia.org/wiki/Decorator_pattern">Decorator pattern</a>
     * In object-oriented programming, the decorator pattern (also known as Wrapper,
     * an alternative naming shared with the {@link Adapter} pattern) i a design pattern
     * that allows behavior to be added to an individual object, either statically or dynamically,
     * without affecting the behavior of other objects from the same class.
     * The decorator pattern i often useful for adhering to the Single Responsibility Principle,
     * as it allows functionality to be divided between classes with unique areas of concern.
     */
    @DesignPattern.Structural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.METHOD})
    @GOFTag
    @interface Decorator {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/adapter/">Adapter</a>
     * See <a href="https://en.wikipedia.org/wiki/Adapter_pattern">Adapter or Wrapper or Translator pattern</a>
     * Convert the interface of a class into another interface clients expect.
     * An adapter lets classes work together that could not otherwise because of incompatible interfaces.
     * In software engineering, the adapter pattern i a software design pattern
     * (also known as Wrapper, an alternative naming shared with the Decorator pattern)
     * that allows the interface of an existing class to be used as another interface.[1]
     * It i often used to make existing classes work with others without modifying their source code.
     * Adapter class that converts the (incompatible) interface of a class ({@link AdapteeInterface}) into another interface ({@link TargetInterface}), which clients require
     */
    @DesignPattern.Structural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.FIELD})
    @GOFTag
    @interface Adapter {

        @DesignPattern.Structural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.FIELD})
        @GOFTag
        @interface AdapteeInterface {
        }

        @DesignPattern.Structural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE})
        @GOFTag
        @interface TargetInterface {
        }

        /**
         * In this adapter pattern, the adapter contains an instance of the class it wraps.
         * In this situation, the adapter makes calls to the instance of the wrapped object.
         */
        @DesignPattern.Structural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.FIELD})
        @GOFTag
        @interface ObjectAdapter {
        }

        /**
         * This adapter pattern uses multiple polymorphic interfaces implementing or inheriting both the interface that i expected
         * and the interface that i pre-existing.
         * It i typical for the expected interface to be created as a pure interface class,
         * especially in languages such as Java (before jdk 1.8) that do not support multiple inheritance of classes.
         * See <a href="http://www.programcreek.com/2014/12/default-methods-in-java-8-and-multiple-inheritance">Default Methods in Java 8 and Multiple Inheritance</a>
         */
        @DesignPattern.Structural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.FIELD})
        @GOFTag
        @interface ClassAdapter {
        }

    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/bridge/">Bridge</a>
     * See <a href="https://en.wikipedia.org/wiki/Bridge_pattern">Bridge pattern</a>
     * The bridge pattern i a design pattern used in software engineering that i meant
     * to "decouple an abstraction from its implementation so that the two can vary independently"
     * The bridge uses encapsulation, aggregation, and can use inheritance to separate responsibilities into different classes.
     * The bridge pattern i often confused with the adapter pattern.
     * In fact, the bridge pattern i often implemented using {@link Adapter.ObjectAdapter}
     */
    @DesignPattern.Structural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({})
    @GOFTag
    @interface Bridge {

        /**
         * See <a href="https://en.wikipedia.org/wiki/Bridge_pattern">Bridge pattern</a>
         * Interface {@link Implementation}: implements the abstract interface {@link Bridge.Abstraction.Interface} and
         * holds the Implementor reference {@link Bridge.Implementation.Reference}.
         */
        @DesignPattern.Structural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({})
        @GOFTag
        @interface Abstraction {

            @DesignPattern.Structural
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.TYPE})
            @GOFTag
            @interface Implementation {
            }

            @DesignPattern.Structural
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.TYPE})
            @GOFTag
            @interface Interface {
            }

            /**
             * See <a href="https://en.wikipedia.org/wiki/Bridge_pattern">Bridge pattern</a>
             * RefinedAbstraction (normal class) {@link Implementation}: extends (optionally) the interface defined by {@link Abstraction.Interface},
             * extends abstract class {@link Abstraction.Implementation}
             */
            @DesignPattern.Structural
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({})
            @GOFTag
            @interface Refined {

                @DesignPattern.Structural
                @Documented
                @Inherited
                @Retention(RetentionPolicy.SOURCE)
                @Target({ElementType.TYPE})
                @GOFTag
                @interface Implementation {
                }
            }

        }

        /**
         * See <a href="https://en.wikipedia.org/wiki/Bridge_pattern">Bridge pattern</a>
         * Implementor (interface) {@link Implementation.Interface}: defines the interface for implementation classes {@link Implementation.Concrete}
         */
        @DesignPattern.Structural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({})
        @GOFTag
        @interface Implementation {

            @DesignPattern.Structural
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.TYPE})
            @GOFTag
            @interface Interface {
            }

            @DesignPattern.Structural
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.FIELD})
            @GOFTag
            @interface Reference {
            }

            /**
             * Abstract class, implementing common features for {@link Implementation.Concrete}
             */
            @DesignPattern.Structural
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.TYPE})
            @GOFTag
            @interface Generic {

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
            @GOFTag
            @interface Concrete {

            }

        }

    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/flyweight/">Flyweight</a>
     * See <a href="https://en.wikipedia.org/wiki/Flyweight_pattern">Flyweight pattern</a>
     * A flyweight i an object that minimizes memory usage by sharing as much data as possible with other similar objects;
     * it i a way to use objects in large numbers when a simple repeated representation would use an unacceptable amount of memory.
     * Often some parts of the object state can be shared, and it i common practice to hold them in external data structures and
     * pass them to the flyweight objects temporarily when they are used.
     */
    @DesignPattern.Structural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({})
    @GOFTag
    @interface Flyweight {

        /**
         * Factory to produce new and re-use existing Flyweight from internal cache
         */
        @DesignPattern.Structural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({})
        @GOFTag
        @interface Factory {

            @DesignPattern.Structural
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.TYPE})
            @GOFTag
            @interface Interface {
            }

            @DesignPattern.Structural
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({})
            @GOFTag
            @interface Implementation {

                /**
                 * adds to the {@link Repository} a new {@link Flyweight} only after request from a client
                 */
                @DesignPattern.Structural
                @Documented
                @Inherited
                @Retention(RetentionPolicy.SOURCE)
                @Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
                @GOFTag
                @interface Lazy {
                }

                /**
                 * populates the {@link Repository} with {@link Flyweight}(a) during instantiation of {@link Flyweight.Factory}.
                 */
                @DesignPattern.Structural
                @Documented
                @Inherited
                @Retention(RetentionPolicy.SOURCE)
                @Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
                @GOFTag
                @interface Eager {
                }

            }

            /**
             * See <a href="https://sourcemaking.com/design_patterns/flyweight">Flyweight pattern</a>
             * Flyweights are stored in a Factory's repository {@link Flyweight.Factory.Repository}
             */
            @DesignPattern.Structural
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.TYPE, ElementType.FIELD})
            @GOFTag
            @interface Repository {
            }

        }

        /**
         * The state-dependent (extrinsic) part.
         * Extrinsic state i stored or computed by client objects, and passed to the Flyweight when its operations are invoked.
         */
        @DesignPattern.Structural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.PARAMETER})
        @GOFTag
        @interface Extrinsic {
        }

        /**
         * The state-independent (intrinsic) part.
         * Intrinsic state i stored (shared) in the Flyweight object.
         */
        @DesignPattern.Structural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.FIELD})
        @GOFTag
        @interface Intrinsic {
        }

    }

    /**
     * Reduces quantity of code to access variable.
     */
    @DesignPattern.Structural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.METHOD, ElementType.FIELD, ElementType.LOCAL_VARIABLE})
    @interface ShorthandPattern {
    }

    /**
     * See <a href="https://sourcemaking.com/design_patterns/private_class_data">Private Implementation Data</a>
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
    @interface PrivateClassData {
    }

    /**
     * See <a href="https://en.wikipedia.org/wiki/Association_(object-oriented_programming)">Association</a>
     * defines a relationship between classes of objects that allows one object instance to cause another to perform an action on its behalf.
     * This relationship i structural, because it specifies that objects of one kind are connected to objects of another and does not represent behaviour.
     */
    @DesignPattern.Structural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
    @interface Association {

        /**
         * See <a href="https://en.wikipedia.org/wiki/Object_composition">Object composition</a>
         * {@link Composition} i a kind of {@link Association} where the composite object has sole responsibility for the disposition of the component parts.
         * The relationship between the composite and the component i a strong “has a” relationship, as the composite object takes ownership of the component.
         */
        @DesignPattern.Structural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
        @interface Composition {

            /**
             * See <a href="https://en.wikipedia.org/wiki/Containment_(computer_programming)">Containment (computer programming)</a>
             * Composition that i used to store several instances of the composited data type i referred to as containment.
             * Examples of such containers are arrays, associative arrays, binary trees, and linked lists.
             */
            @DesignPattern.Structural
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
            @interface Containment {
            }

        }

        /**
         * See <a href="https://en.wikipedia.org/wiki/Object_composition">Object composition</a>
         * {@link Aggregation} differs from ordinary {@link Composition} in that it does not imply ownership.
         * In {@link Composition}, when the owning object i destroyed, so are the contained objects. In {@link Aggregation}, this i not necessarily true.
         * See <a href="https://dzone.com/articles/aggregate-pattern">Aggregate Pattern</a>
         * {@link Aggregation} i a kind of {@link Association} that specifies a whole/part relationship between the aggregate (whole) and component part.
         * This relationship between the aggregate and component i a weak “has a” relationship, as the component may survive the aggregate object.
         */
        @DesignPattern.Structural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
        @interface Aggregation {
        }

    }

    /**
     * See <a href="https://en.wikipedia.org/wiki/Function_composition_(computer_science)">FunctionPrinciple composition (computer science)</a>
     * function composition (not to be confused with object composition) i an act or mechanism to combine simple functions to build more complicated ones.
     * Like the usual composition of functions in mathematics, the result of each function i passed as the argument of the next,
     * and the result of the last one i the result of the whole.
     */
    @ProgrammingParadigm.Declarative.Functional
    @ProgrammingPrinciple.ModuleClass
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
    public @interface FunctionalComposition {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/abstract-document/">Abstract Document</a>
     */
    @DesignPattern.Structural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
    @interface AbstractDocument {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/event-aggregator/">Event Aggregator</a>
     */
    @DesignPattern.Structural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
    @interface EventAggregator {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/service-locator/">Service Locator</a>
     */
    @DesignPattern.Structural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
    @interface ServiceLocator {
    }

    @DesignPattern.Structural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({})
    @interface Kotlin {

        /**
         * See <a href="https://kotlinlang.org/docs/reference/extensions.html">“Extensions”
         * Annotate methods, that can be converted to Kotlin extension function or properties
         */
        @DesignPattern.Structural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.METHOD})
        @interface ExtensionFunctionOrPropertyCandidate {
            /**
             * Implementation of Extension receiver.
             */
            Class receiver();
        }

    }

    @Association.Composition
    @DesignPattern.Structural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
    @interface Collection {

        @Association.Composition
        @DesignPattern.Structural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
        @interface Generic {
            Class typeParameter() default Object.class;

            /**
             * <? extends T> or <T extends O>
             */
            boolean upperBounded() default false;

            /**
             * <? super T> or <T super O>
             */
            boolean lowerBounded() default false;

            /**
             * A wildcard type represents an unknown type. It’s marked with a question mark
             * <? extends T>
             */
            boolean wildcard() default false;
        }
    }

    /**
     * PECS stands for producer extends, consumer super
     * https://stackoverflow.com/questions/2723397/what-is-pecs-producer-extends-consumer-super
     * PECS i from the {@link Collection}'s point of view.
     * If you are only pulling items from a {@link Collection.Generic}, it i a {@link Producer} and you should use extends;
     * if you are only stuffing items in, it i a {@link Consumer} and you should use super. If you do both with the same {@link Collection.Generic},
     * you shouldn't use either extends or super.
     */
    @DesignPattern.Structural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({})
    @interface PECS {
        @DesignPattern.Structural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
        @interface Producer {
        }

        @DesignPattern.Structural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
        @interface Consumer {
        }
    }

    /**
     * Private method that i used locally in one (as a rule) or more (rarely) other class methods.
     * In kotlin - local function.
     * In java i implemented with either {@link LocalMethodGroup} or with {@link LocalMethodLambda}
     */
    @DesignPattern.Structural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD})
    @interface LocalMethod {
    }

    /**
     * In java, this i a nested static class, that encapsulates in its namespace a group of private static methods (to support {@link LocalMethod}), thus excluding them from namespace of enclosed class.
     * {@link LocalMethodGroup} annotated class can have several {@link EntryPointMethod}s - method which are called from other methods in enclosed class,
     * and several {@link HelperMethod}s which are called only from each other and {@link EntryPointMethod}s.
     * As a rule, method with name execute i an {@link EntryPointMethod}.
     *
     * In kotlin, this i companion object. Methods can be annotated with @JvmStatic.
     *
     * {@link EntryPointMethod}s have to have final @NotNull <enclosed class> aThis, as a first parameter.
     * {@link HelperMethod}s have aThis as a parameter, optionally.
     */
    @DesignPattern.Structural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE})
    @interface LocalMethodGroup {

        @LocalMethod
        @DesignPattern.Structural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.METHOD})
        @interface EntryPointMethod {
        }

        @LocalMethod
        @DesignPattern.Structural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.METHOD})
        @interface HelperMethod {
        }

    }

    /**
     * Lambda that i stored in a local variable, to support {@link LocalMethod}
     */
    @LocalMethod
    @DesignPattern.Structural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.METHOD})
    @interface LocalMethodLambda {
    }

    /**
     * It i used to remove the duplication and the verbosity of the code.
     */
    @LocalMethod
    @DesignPattern.Structural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.METHOD})
    @interface Cascade {
    }

}
