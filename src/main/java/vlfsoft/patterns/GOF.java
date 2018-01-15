package vlfsoft.patterns;

import vlfsoft.concepts.TechnicalDebt;
import vlfsoft.patterns.design.DesignPattern;
import vlfsoft.patterns.enterprise.ddd.DDD;
import vlfsoft.tags.Related;

import java.lang.annotation.*;

/**
 * See <a href="https://en.wikipedia.org/wiki/Design_Patterns">Design Patterns</a>
 */
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({})
public @interface GOF {

    @Retention(RetentionPolicy.SOURCE)
    @Target({})
    @interface BEG_Behavioral {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/mediator/">Mediator</a>
     * See <a href="https://en.wikipedia.org/wiki/Mediator_pattern">Mediator pattern</a>
     * defines an object that encapsulates how a set of objects interact.
     * With the mediator pattern, communication between objects is encapsulated within a mediator object.
     * Objects no longer communicate directly with each other, but instead communicate through the mediator.
     * This reduces the dependencies between communicating objects, thereby reducing coupling.
     */
    @Behavioral
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE})
    @interface Mediator {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/state/">State</a>
     * See <a href="https://en.wikipedia.org/wiki/State_pattern">State pattern</a>
     * The state pattern can be interpreted as a {@link Strategy} pattern
     * which i able to switch the current strategy through invocations of methods defined in the pattern's interface.
     * If in object there are internal states, but there are no methods that are used in all states and have different behaviour,
     * State pattern shouldn't be used.
     */
    @Behavioral
    @Strategy
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
    @interface State {

        /**
         * a single interface to the outside world,
         * keeps internally reference to the current State object and delegates to it handling methods,
         * that have different implementation in different states
         */
        @Behavioral
        @Strategy
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.FIELD})
        @interface Context {
        }
    }

    /**
     * See <a href="https://en.wikipedia.org/wiki/Chain-of-responsibility_pattern">Chain-of-responsibility pattern</a>
     * See <a href="http://java-design-patterns.com/patterns/chain/">Chain of responsibility</a>
     */
    @Behavioral
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
    @interface ChainOfResponsibility {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/command/">Command</a>
     * See <a href="https://en.wikipedia.org/wiki/Command_pattern">Command pattern</a>
     * An object is used to encapsulate all information needed to perform an action or trigger an event at a later time.
     * This information includes the {@link Receiver.Method} name, {@link Receiver} - the object that owns the method and {@link ParameterValues} - values for the method parameters.
     * Four terms always associated with the command pattern are {@link Command}, {@link Receiver}, {@link Invoker} and {@link Client}.
     * A {@link Command} object knows about {@link Receiver} and invokes a {@link Receiver.Method} or several {@link Receiver.Method} of the {@link Receiver}.
     * {@link ParameterValues} - values for parameters of the {@link Receiver} {@link Receiver.Method} are stored in the {@link Command},
     * the {@link Receiver} object to execute these {@link Receiver.Method}-methods i also stored
     * in the {@link Command} object by {@link Pattern.Association.Aggregation}.
     * The {@link Receiver} then does the work when the {@link ExecuteMethod}() method in {@link Command} i called.
     * An {@link Invoker} object knows how to execute a {@link Command}, and optionally does bookkeeping about the {@link Command} execution.
     * The {@link Invoker} does not know anything about a concrete command, it knows only about command interface.
     * {@link Invoker} object(s), {@link Command} objects and {@link Receiver} objects are held by a {@link Client} object,
     * the {@link Client} decides which {@link Receiver} objects it assigns to the {@link Command} objects,
     * and which {@link Command}s it assigns to the {@link Invoker}.
     * The {@link Client} decides which {@link Command}s to execute at which points. To execute a {@link Command}, it passes the {@link Command} object to the {@link Invoker} object.
     */
    @Behavioral
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE})
    @interface Command {

        @Behavioral
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
        @interface ParameterValues {
        }

        @Behavioral
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.METHOD})
        @interface ExecuteMethod {
        }

        @Behavioral
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.FIELD, ElementType.PARAMETER})
        @interface Receiver {

            @Behavioral
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.FIELD, ElementType.METHOD})
            @interface Method {
            }

        }

        @Behavioral
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
        @interface Invoker {
        }

        @Behavioral
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.FIELD})
        @interface Client {
        }

    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/strategy/">Strategy</a>
     * See <a href="https://en.wikipedia.org/wiki/Strategy_pattern">Strategy pattern</a>
     * enables an algorithm's behavior to be selected at runtime.
     * defines a family of algorithms, encapsulates each algorithm, and makes the algorithms interchangeable within that family.
     */
    @Behavioral
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.PARAMETER})
    @interface Strategy {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/template-method/">Template method</a>
     * See <a href="https://en.wikipedia.org/wiki/Template_method_pattern">Template method pattern</a>
     * In software engineering, the template method pattern i a behavioral design pattern that defines the program skeleton of an algorithm in an operation,
     * deferring some steps to subclasses.[1] It lets one redefine certain steps of an algorithm without changing the algorithm's structure.
     */
    @Behavioral
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
    @interface TemplateMethod {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/visitor/">Visitor</a>
     * See <a href="https://en.wikipedia.org/wiki/Visitor_pattern">Visitor pattern</a>
     * i a way of separating an algorithm from an object structure on which it operates.
     * A practical result of this separation i the ability to add new operations to extant object structures
     * without modifying the structures. It i one way to follow the open/closed principle.
     */
    @Behavioral
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
    @interface Visitor {

        @Behavioral
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
        @interface Element {
        }
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/observer/">Observer</a>
     * See <a href="https://en.wikipedia.org/wiki/Observer_pattern">Observer pattern</a>
     * The observer pattern is a software design pattern in which an object, called the subject, maintains a list of its dependents, called observers,
     * and notifies them automatically of any state changes, usually by calling one of their methods.
     */
    @Behavioral
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE})
    @interface Observer {

        @Behavioral
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.METHOD})
        @interface NotifyMethod {
        }

        @Behavioral
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.FIELD})
        @interface Observable {
        }

    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/interpreter/">Interpreter</a>
     */
    @Behavioral
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @interface Interpreter {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/iterator/">Iterator</a>
     */
    @Behavioral
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @interface Iterator {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/memento/">Memento</a>
     */
    @Behavioral
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @interface Memento {
    }

    @Retention(RetentionPolicy.SOURCE)
    @Target({})
    @interface BEG_Creational {
    }

    /**
     * See <a href="https://en.wikipedia.org/wiki/Factory_(object-oriented_programming)#Terminology">Factory (object-oriented programming)</a>
     * a pool i an object for creating other objects – formally a pool i a function or method that returns objects of a varying prototype or class[1] from some method call,
     * which i assumed to be "new".
     * More broadly, a subroutine that returns a "new" object may be referred to as a "pool", as in pool method or pool function.
     * See <a href="https://www.codeproject.com/Articles/1131770/Factory-Patterns-Simple-Factory-Pattern">Factory Patterns - Simple Factory Pattern</a>
     */
    @Creational
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Related.Patterns(DDD.Factory.class)
    @interface Factory {

        /**
         * See <a href="http://coding-geek.com/design-pattern-factory-patterns/">Design Pattern: pool patterns</a>
         */
        enum Need {
            /**
             * we could have modified the way an instance i created (for example by using a prototype pattern instead of creating a new object from scratch each time).
             */
            ControlOverInstantiation,
            /**
             * you can easily change the logger implementation from FileSystemLogger to DatabaseLogger.
             * You just have to modify the function createLogger() (which i a pool).
             * This change i invisible for the client (business) code since the client code use an interface of logger (ILogger) and the choice of the logger implementation i made by the pool.
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
             * using a pool adds a description of what the creation i about with the pool method name
             */
            Disambiguation
        }

        /**
         * See <a href="http://coding-geek.com/design-pattern-factory-patterns/">Design Pattern: pool patterns</a>
         * Joshua Bloch “Effective Java”
         * "A class can provide a public static pool method, which i simply a static method that returns an instance of the class."
         */
        @Creational
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.METHOD})
        @interface StaticFactoryMethod {
            Need[] needs() default {};
        }

        /**
         * See <a href="https://www.codeproject.com/Articles/1131770/Factory-Patterns-Simple-Factory-Pattern">Factory Patterns - Simple Factory Pattern</a>
         * In simple pool pattern, we have a pool class which has a method that returns different ddd of object based on given input.
         * <p>
         * See <a href="https://dzone.com/articles/factory-method-vs-simple-factory-1">Factory Method vs. Simple Factory</a>
         * a pool class which has a method that returns different ddd of object based on given input
         * Creates objects without exposing the instantiation logic to the client and refers to the newly created object through a common interface.
         * It i a simplified version of {@link FactoryMethod}
         * <p>
         * See <a href="http://coding-geek.com/design-pattern-factory-patterns/">Design Pattern: pool patterns</a>
         */
        @Creational
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.METHOD})
        @interface SimpleFactory {
            Need[] needs() default {};
        }

        /**
         * See <a href="https://en.wikipedia.org/wiki/Factory_method_pattern">Factory method pattern</a>
         * creational pattern that uses pool methods to deal with the problem of creating objects
         * without having to specify the exact class of the object that will be created.
         * This i done by creating objects by calling a pool method—either specified in an interface
         * and implemented by child classes, or implemented in a base class and optionally overridden
         * by derived classes—rather than by calling a constructor.
         * <p>
         * Define an interface for creating an object, but let subclasses decide which class to instantiate.
         * Factory Method lets a class defer instantiation to subclasses
         * <p>
         * <p>
         * See <a href="https://sourcemaking.com/design_patterns/factory_method">Factory method pattern</a>
         * Factory Methods are usually called within Template Methods.
         * Factory Method i to creating objects as Template Method i to implementing an algorithm.
         * A superclass specifies all standard and generic behavior (using pure virtual "placeholders" for creation steps),
         * and then delegates the creation details to subclasses that are supplied by the client.
         * <p>
         * Often, designs start out using {@link FactoryMethod} (less complicated, more customizable, subclasses proliferate) and
         * evolve toward {@link AbstractFactory}, {@link GOF.Prototype}, or {@link GOF.Builder} (more flexible, more complex) as the designer discovers where more flexibility i needed.
         */
        @Creational
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD})
        @interface FactoryMethod {
            Need[] needs() default {};
        }

        /**
         * See <a href="http://java-design-patterns.com/patterns/abstract-factory/">Abstract Factory</a>
         * See <a href="https://en.wikipedia.org/wiki/Abstract_factory_pattern">Abstract pool pattern</a>
         * provides a way to encapsulate a group of individual factories that have a common theme without specifying their concrete classes.
         * In normal usage, the client software creates a concrete implementation of the abstract pool and then uses the generic interface
         * of the pool to create the concrete objects that are part of the theme.
         * The client doesn't know (or care) which concrete objects it gets from each of these internal factories,
         * since it uses only the generic interfaces of their products.
         * This pattern separates the details of implementation of a set of objects from their general usage and relies on object composition,
         * as object creation i implemented in methods exposed in the pool interface.
         * <p>
         * See <a href="https://sourcemaking.com/design_patterns/abstract_factory">Abstract Factory Design Pattern</a>
         * Provide an interface for creating families of related or dependent objects without specifying their concrete classes.
         */
        @Creational
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE})
        @interface AbstractFactory {
            Need[] needs() default {};
        }

        /**
         * See <a href="http://java-design-patterns.com/patterns/factory-kit/">Factory Kit</a>
         * <p>
         * {@link DesignPattern#Solution}: "Define a factory of immutable content with separated builder and factory interfaces.",
         */
        @Creational
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.ANNOTATION_TYPE})
        @interface FactoryKit {
        }

    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/singleton/">Singleton</a>
     * The Singleton class offers two things: one and only one instance of the class, and a global single point of access to that object.
     * See <a href="https://en.wikipedia.org/wiki/Singleton_pattern">Singleton pattern</a>
     * restricts the instantiation of a class to one object.
     * This is useful when exactly one object i needed to coordinate actions across the system.
     */
    @Creational
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
    @interface Singleton {

        @Creational
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({})
        @interface Implementation {

            @Creational
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
            @interface Lazy {
            }

            @Creational
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
            @interface Eager {
            }

        }

    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/builder/">Builder</a>
     * See <a href="https://en.wikipedia.org/wiki/Builder_pattern">Builder pattern</a>
     * the intention of the builder pattern i to find a solution to the telescoping constructor anti-pattern[citation needed].
     * The telescoping constructor anti-pattern occurs when the increase of object constructor parameter combination leads to an exponential
     * list of constructors. Instead of using numerous constructors, the builder pattern uses another object, a builder,
     * that receives each initialization parameter step by step and then returns the resulting constructed object at once.
     * The builder pattern has another benefit.
     * It can be used for objects that contain flat data (html code, SQL query, X.509 certificate...),
     * that is to say, data that can't be easily edited.
     * This type of data can't be edited step by step and must be edited at once.
     *
     * Object is immutable (there is no setters), separate Builder object is mutable with setter methods to initialize parameters of Builder separately.
     * build() method call constructor of immutable Object and pass to it all necessary parameters.
     */
    @Creational
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.METHOD})
    @interface Builder {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/prototype/">Prototype</a>
     * See <a href="https://en.wikipedia.org/wiki/Prototype_pattern">Prototype pattern</a>
     * The prototype pattern i a creational design pattern in software development. It i used when the type of objects to create i determined by a prototypical instance, which i cloned to produce new objects.
     */
    @Creational
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.METHOD})
    @interface Prototype {
    }

    @Retention(RetentionPolicy.SOURCE)
    @Target({})
    @interface BEG_Structural {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/composite/">Composite</a>
     * See <a href="https://en.wikipedia.org/wiki/Composite_pattern">Composite pattern</a>
     * the composite pattern is a partitioning design pattern.
     * The composite pattern describes a group of objects that is treated the same way as a single instance of the same type of object.
     * The intent of a composite is to "compose" objects into tree structures to represent part-whole hierarchies.
     * Implementing the composite pattern lets clients treat individual objects and compositions uniformly.
     * Composite should be used when clients ignore the difference between compositions of objects and individual objects.[1]
     * If programmers find that they are using multiple objects in the same way, and often have nearly identical code to handle each of them, then composite i a good choice;
     * it is less complex in this situation to treat primitives and composites as homogeneous.
     */
    @Structural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
    @interface Composite {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/proxy/">Proxy</a>
     * See <a href="https://en.wikipedia.org/wiki/Proxy_pattern">Proxy_pattern</a>
     * a class functioning as an interface to something else.
     * The proxy could interface to anything: a network connection, a large object in memory, a filemodified, or some other resource that i expensive or impossible to duplicate.
     * In short, a proxy i a wrapper or agent object that i being called by the client to access the real serving object behind the scenes.
     * Use of the proxy can simply be forwarding to the {@link RealObject}, or can provide additional logic. In the proxy, extra functionality can be provided,
     * for example caching when operations on the {@link RealObject} are resource intensive, or checking preconditions before operations on the real object are invoked.
     * For the client, usage of a proxy object i similar to using the real object, because both implement the same interface.
     * See <a href="https://sourcemaking.com/design_patterns/proxy">Proxy Design Pattern</a>
     */
    @Structural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.FIELD})
    @interface Proxy {

        /**
         * For the client, usage of a {@link Proxy} object is similar to using the {@link RealObject}, because both implement the same {@link Interface}.
         */
        @Structural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE})
        @interface Interface {
        }

        @Structural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.FIELD})
        @interface RealObject {
        }

        /**
         * See <a href="https://en.wikipedia.org/wiki/Proxy_pattern">Proxy_pattern</a>
         * In place of a complex or heavy object, a skeleton representation may be advantageous in some cases.
         * When an underlying image i huge in size, it may be represented using a virtual proxy object, loading the real object on demand.
         * See <a href="https://sourcemaking.com/design_patterns/proxy">Proxy Design Pattern</a>
         * A virtual proxy i a placeholder for "expensive to create" objects. The real object i only created when a client first requests/accesses the object.
         */
        @Structural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.FIELD})
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
        @Structural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.FIELD})
        @interface Remote {
        }

        /**
         * See <a href="https://en.wikipedia.org/wiki/Proxy_pattern">Proxy_pattern</a>
         * A protection proxy might be used to control access to a resource based on access rights.
         * See <a href="https://sourcemaking.com/design_patterns/proxy">Proxy Design Pattern</a>
         * A protective proxy controls access to a sensitive master object. The "surrogate" object checks that the caller has the access permissions required prior to forwarding the request.
         */
        @Structural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.FIELD})
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
        @Structural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.FIELD})
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
    @Structural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE})
    @interface Facade {

        @Structural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.FIELD})
        @interface SubsystemOrComponent {
        }
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/decorator/">Decorator</a>
     * See <a href="https://en.wikipedia.org/wiki/Decorator_pattern">Decorator pattern</a>
     * In object-oriented programming, the decorator pattern (also known as Wrapper,
     * an alternative naming shared with the {@link GOF.Adapter} pattern) i a design pattern
     * that allows behavior to be added to an individual object, either statically or dynamically,
     * without affecting the behavior of other objects from the same class.
     * The decorator pattern i often useful for adhering to the Single Responsibility Principle,
     * as it allows functionality to be divided between classes with unique areas of concern.
     */
    @Structural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.METHOD})
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
     * Adapter class that converts the (incompatible) interface of a class ({@link Adapter} fromAdapteeInterface) into another interface ({@link Adapter} toTargetInterface), which clients require
     */
    @Structural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)

    @TechnicalDebt("Remove ElementType.TYPE, ElementType.FIELD")
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.FIELD})
    @interface Adapter {

        @TechnicalDebt("Remove annotation")
        @Structural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.FIELD})
        @interface AdapteeInterface {
        }

        @TechnicalDebt("Remove annotation")
        @Structural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE})
        @interface TargetInterface {
        }

        /**
         * In this adapter pattern, the adapter contains an instance of the class it wraps.
         * In this situation, the adapter makes calls to the instance of the wrapped object.
         */
        @Structural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.FIELD})
        @interface ObjectAdapter {
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.TYPE, ElementType.FIELD})
            @interface Convert {
                Class fromAdapteeInterface();

                Class toTargetInterface();

                Class[] requiredBy();
            }
        }

        /**
         * This adapter pattern uses multiple polymorphic interfaces implementing or inheriting both the interface that is expected
         * and the interface that is pre-existing.
         * It is typical for the expected interface to be created as a pure interface class,
         * especially in languages such as Java (before jdk 1.8) that do not support multiple inheritance of classes.
         * See <a href="http://www.programcreek.com/2014/12/default-methods-in-java-8-and-multiple-inheritance">Default Methods in Java 8 and Multiple Inheritance</a>
         */
        @Structural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @TechnicalDebt("Remove ElementType.TYPE, ElementType.FIELD")
        @Target({ElementType.TYPE, ElementType.FIELD})
        @interface ClassAdapter {
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.TYPE, ElementType.FIELD})
            @interface Convert {
                Class fromAdapteeInterface();

                Class toTargetInterface();

                Class[] requiredBy();
            }
        }

    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/bridge/">Bridge</a>
     * See <a href="https://en.wikipedia.org/wiki/Bridge_pattern">Bridge pattern</a>
     * The bridge pattern is a design pattern used in software engineering that is meant
     * to "decouple an abstraction from its implementation so that the two can vary independently"
     * The bridge uses encapsulation, aggregation, and can use inheritance to separate responsibilities into different classes.
     * The bridge pattern is often confused with the adapter pattern.
     * In fact, the bridge pattern is often implemented using {@link Adapter.ObjectAdapter}
     */
    @Structural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({})
    @interface Bridge {

        /**
         * See <a href="https://en.wikipedia.org/wiki/Bridge_pattern">Bridge pattern</a>
         * {@link Abstraction} is an abstract class, that holds the {@link Implementor.Reference}.
         */
        @Structural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE})
        @interface Abstraction {
        }

        /**
         * See <a href="https://en.wikipedia.org/wiki/Bridge_pattern">Bridge pattern</a>
         * {@link RefinedAbstraction} class, that extend {@link Abstraction} class, and adds optionally new public methods.
         */
        @Structural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE})
        @interface RefinedAbstraction {
        }

        /**
         * See <a href="https://en.wikipedia.org/wiki/Bridge_pattern">Bridge pattern</a>
         * {@link Implementor} defines the interface for implementation classes {@link Implementor.Concrete}
         */
        @Structural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE})
        @interface Implementor {

            @Structural
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.FIELD})
            @interface Reference {
            }

            /**
             * See <a href="https://en.wikipedia.org/wiki/Bridge_pattern">Bridge pattern</a>
             * ConcreteImplementor (normal class): implements the Implementor interface
             */
            @Structural
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.TYPE})
            @interface Concrete {
            }

        }

    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/flyweight/">Flyweight</a>
     * See <a href="https://en.wikipedia.org/wiki/Flyweight_pattern">Flyweight pattern</a>
     * A flyweight is an object that minimizes memory usage by sharing as much data as possible with other similar objects;
     * it i a way to use objects in large numbers when a simple repeated representation would use an unacceptable amount of memory.
     * Often some parts of the object state can be shared, and it i common practice to hold them in external data structures and
     * pass them to the flyweight objects temporarily when they are used.
     */
    @Structural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({})
    @interface Flyweight {

        /**
         * Factory to produce new and re-use existing Flyweight from internal cache
         */
        @Structural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({})
        @interface Factory {

            Implementation[] implementation() default {};
            /**
             * adds to the {@link Repository} a new {@link Flyweight} only after request from a client
             * populates the {@link Repository} with {@link Flyweight}(a) during instantiation of {@link Flyweight.Factory}.
             */
            enum Implementation {Lazy, Eager}

            /**
             * See <a href="https://sourcemaking.com/design_patterns/flyweight">Flyweight pattern</a>
             * Flyweights are stored in a Factory's repository {@link Flyweight.Factory.Repository}
             */
            @Structural
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.TYPE, ElementType.FIELD})
            @interface Repository {
            }

        }

        /**
         * The state-dependent (extrinsic) part.
         * Extrinsic state i stored or computed by client objects, and passed to the Flyweight when its operations are invoked.
         */
        @Structural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.PARAMETER})
        @interface Extrinsic {
        }

        /**
         * The state-independent (intrinsic) part.
         * Intrinsic state i stored (shared) in the Flyweight object.
         */
        @Structural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.FIELD})
        @interface Intrinsic {
        }

    }

    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @interface Behavioral {
    }

    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @interface Creational {
    }

    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @interface Structural {
    }
}
