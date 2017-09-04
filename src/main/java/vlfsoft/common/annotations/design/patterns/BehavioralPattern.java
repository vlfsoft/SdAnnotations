package vlfsoft.common.annotations.design.patterns;

import vlfsoft.common.annotations.design.DesignPattern;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * See <a href="https://en.wikipedia.org/wiki/Behavioral_pattern">Behavioral pattern</a>
 */
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface BehavioralPattern {

    /**
     * See <a href="https://en.wikipedia.org/wiki/Delegation_pattern">Delegation pattern</a>
     * allows object composition to achieve the same code reuse as inheritance
     */
    @DesignPattern.Behavioral
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.CONSTRUCTOR})
    @DesignPattern.Fundamental
    @interface Delegation {
    }

    /**
     * The holder pattern is used for providing fast access to an object.
     * Holder object keeps (caches) reference to the object. It allows to avoid slow access (calling one or more methods and etc.) to access the object.
     * Android ViewHolder pattern allows to avoid calling Menu#findItem, Activity#findViewById
     * <a href="android.view.Menu#findItem">Menu.findItem</a> method.
     */
    @DesignPattern.Behavioral
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.FIELD})
    @DesignPattern.Fundamental
    @interface Holder {
    }

    /**
     * See <a href="https://en.wikipedia.org/wiki/Mediator_pattern">Mediator pattern</a>
     */
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
    @DesignPattern.GOF
    @interface Mediator {
    }

    /**
     * See <a href="https://en.wikipedia.org/wiki/State_pattern">State pattern</a>
     * The state pattern can be interpreted as a {@link Strategy} pattern
     * which is able to switch the current strategy through invocations of methods defined in the pattern's interface.
     * If in object there are internal states, but there are no methods that are used in all states and have different behaviour,
     * State pattern shouldn't be used.
     */
    @Strategy
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
    @DesignPattern.GOF
    @interface State {

        /**
         * a single interface to the outside world,
         * keeps internally reference to the current State object and delegates to it handling methods,
         * that have different implementation in different states
         */
        @Strategy
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.FIELD})
        @DesignPattern.GOF
        @interface Context {
        }
    }

    /**
     * See <a href="https://en.wikipedia.org/wiki/Chain-of-responsibility_pattern">Chain-of-responsibility pattern</a>
     */
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
    @DesignPattern.GOF
    @interface ChainOfResponsibility {
    }

    /**
     * See <a href="https://en.wikipedia.org/wiki/Command_pattern">Command pattern</a>
     * An object is used to encapsulate all information needed to perform an action or trigger an event at a later time.
     * This information includes the {@link Receiver.Method} name, {@link Receiver} - the object that owns the method and {@link ParameterValues} - values for the method parameters.
     * Four terms always associated with the command pattern are {@link Command}, {@link Receiver}, {@link Invoker} and {@link Client}.
     * A {@link Command} object knows about {@link Receiver} and invokes a {@link Receiver.Method} or several {@link Receiver.Method} of the {@link Receiver}.
     * {@link ParameterValues} - values for parameters of the {@link Receiver} {@link Receiver.Method} are stored in the {@link Command},
     * the {@link Receiver} object to execute these {@link Receiver.Method}-methods is also stored
     * in the {@link Command} object by {@link vlfsoft.common.annotations.design.principles.ObjectComposition.Aggregation}.
     * The {@link Receiver} then does the work when the {@link Execute}() method in {@link Command} is called.
     * An {@link Invoker} object knows how to execute a {@link Command}, and optionally does bookkeeping about the {@link Command} execution.
     * The {@link Invoker} does not know anything about a concrete command, it knows only about command interface.
     * {@link Invoker} object(s), {@link Command} objects and {@link Receiver} objects are held by a {@link Client} object,
     * the {@link Client} decides which {@link Receiver} objects it assigns to the {@link Command} objects,
     * and which {@link Command}s it assigns to the {@link Invoker}.
     * The {@link Client} decides which {@link Command}s to execute at which points. To execute a {@link Command}, it passes the {@link Command} object to the {@link Invoker} object.
     */
    @DesignPattern.Behavioral
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE})
    @DesignPattern.GOF
    @interface Command {

        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE})
        @DesignPattern.GOF
        @interface Abstraction {
        }

        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE})
        @DesignPattern.GOF
        @interface Implementation {

            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.TYPE})
            @DesignPattern.GOF
            @interface Generic {
            }

            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.TYPE})
            @DesignPattern.GOF
            @interface Concrete {
            }

        }

        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
        @DesignPattern.GOF
        @interface ParameterValues {
        }

        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.METHOD})
        @DesignPattern.GOF
        @interface Execute {
        }

        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.FIELD, ElementType.PARAMETER})
        @DesignPattern.GOF
        @interface Receiver {

            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.FIELD, ElementType.METHOD})
            @DesignPattern.GOF
            @interface Method {
            }

        }

        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
        @DesignPattern.GOF
        @interface Invoker {
        }

        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.FIELD})
        @DesignPattern.GOF
        @interface Client {
        }

    }

    /**
     * See <a href="https://en.wikipedia.org/wiki/Strategy_pattern">Strategy pattern</a>
     * enables an algorithm's behavior to be selected at runtime.
     * defines a family of algorithms, encapsulates each algorithm, and makes the algorithms interchangeable within that family.
     */
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
    @DesignPattern.GOF
    @interface Strategy {
    }

    // Template method pattern

    /**
     * See <a href="https://en.wikipedia.org/wiki/Template_method_pattern">Template method pattern</a>
     * In software engineering, the template method pattern is a behavioral design pattern that defines the program skeleton of an algorithm in an operation,
     * deferring some steps to subclasses.[1] It lets one redefine certain steps of an algorithm without changing the algorithm's structure.
     */
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
    @DesignPattern.GOF
    @interface TemplateMethod {
    }

    /**
     * See <a href="https://en.wikipedia.org/wiki/Visitor_pattern">Visitor pattern</a>
     * is a way of separating an algorithm from an object structure on which it operates.
     * A practical result of this separation is the ability to add new operations to extant object structures
     * without modifying the structures. It is one way to follow the open/closed principle.
     */
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
    @DesignPattern.GOF
    @interface Visitor {

        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
        @interface Element {
        }
    }

}
