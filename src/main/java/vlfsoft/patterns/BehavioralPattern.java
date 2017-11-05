package vlfsoft.patterns;

import vlfsoft.paradigms.ProgrammingParadigm;
import vlfsoft.patterns.ObjectKindPattern.Mutable;
import vlfsoft.tags.GOFTag;

import java.lang.annotation.*;

/**
 * See <a href="https://en.wikipedia.org/wiki/Behavioral_pattern">Behavioral pattern</a>
 */
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({})
public @interface BehavioralPattern {

    /**
     * See <a href="http://java-design-patterns.com/patterns/delegation/">Delegation</a>
     * See <a href="https://en.wikipedia.org/wiki/Delegation_pattern">Delegation pattern</a>
     * allows object {@link @Association.Composition} to achieve the same code reuse as inheritance
     * In delegation, two objects are involved in handling a request: a {@link ReceivingObject} delegates operations to its {@link Delegate}.
     * This i analogous to subclasses deferring requests to parent classes.
     * In {@link Delegation}, an object handles a request by delegating to a second object (the {@link Delegate}).
     */
    @DesignPattern.Behavioral
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.CONSTRUCTOR})
    @interface Delegation {

        @DesignPattern.Behavioral
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE})
        @interface ReceivingObject {
        }

        @DesignPattern.Behavioral
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.FIELD})
        @interface Delegate {
        }

    }

    /**
     * The holder pattern i used for providing fast access to an object.
     * Holder object keeps (caches) reference to the object. It allows to avoid slow access (calling one or more methods and etc.) to access the object.
     * Android ViewHolder pattern allows to avoid calling Menu#findItem, Activity#findViewById
     * <a href="android.view.Menu#findItem">Menu.findItem</a> method.
     */
    @DesignPattern.Behavioral
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.FIELD})
    @interface Holder {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/mediator/">Mediator</a>
     * See <a href="https://en.wikipedia.org/wiki/Mediator_pattern">Mediator pattern</a>
     * defines an object that encapsulates how a set of objects interact.
     * With the mediator pattern, communication between objects i encapsulated within a mediator object.
     * Objects no longer communicate directly with each other, but instead communicate through the mediator.
     * This reduces the dependencies between communicating objects, thereby reducing coupling.
     */
    @DesignPattern.Behavioral
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({})
    @GOFTag
    @interface Mediator {

        @DesignPattern.Behavioral
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE})
        @GOFTag
        @interface Interface {
        }

        @DesignPattern.Behavioral
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE})
        @GOFTag
        @interface Implementation {
        }

    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/state/">State</a>
     * See <a href="https://en.wikipedia.org/wiki/State_pattern">State pattern</a>
     * The state pattern can be interpreted as a {@link Strategy} pattern
     * which i able to switch the current strategy through invocations of methods defined in the pattern's interface.
     * If in object there are internal states, but there are no methods that are used in all states and have different behaviour,
     * State pattern shouldn't be used.
     */
    @DesignPattern.Behavioral
    @Strategy
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
    @GOFTag
    @interface State {

        /**
         * a single interface to the outside world,
         * keeps internally reference to the current State object and delegates to it handling methods,
         * that have different implementation in different states
         */
        @DesignPattern.Behavioral
        @Strategy
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.FIELD})
        @GOFTag
        @interface Context {
        }
    }

    /**
     * See <a href="https://en.wikipedia.org/wiki/Chain-of-responsibility_pattern">Chain-of-responsibility pattern</a>
     * See <a href="http://java-design-patterns.com/patterns/chain/">Chain of responsibility</a>
     */
    @DesignPattern.Behavioral
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
    @GOFTag
    @interface ChainOfResponsibility {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/command/">Command</a>
     * See <a href="https://en.wikipedia.org/wiki/Command_pattern">Command pattern</a>
     * An object i used to encapsulate all information needed to perform an action or trigger an event at a later time.
     * This information includes the {@link Receiver.Method} name, {@link Receiver} - the object that owns the method and {@link ParameterValues} - values for the method parameters.
     * Four terms always associated with the command pattern are {@link Command}, {@link Receiver}, {@link Invoker} and {@link Client}.
     * A {@link Command} object knows about {@link Receiver} and invokes a {@link Receiver.Method} or several {@link Receiver.Method} of the {@link Receiver}.
     * {@link ParameterValues} - values for parameters of the {@link Receiver} {@link Receiver.Method} are stored in the {@link Command},
     * the {@link Receiver} object to execute these {@link Receiver.Method}-methods i also stored
     * in the {@link Command} object by {@link StructuralPattern.Association.Aggregation}.
     * The {@link Receiver} then does the work when the {@link ExecuteMethod}() method in {@link Command} i called.
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
    @Target({})
    @GOFTag
    @interface Command {

        @DesignPattern.Behavioral
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE})
        @GOFTag
        @interface Abstraction {
        }

        @DesignPattern.Behavioral
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({})
        @GOFTag
        @interface Implementation {

            @DesignPattern.Behavioral
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.TYPE})
            @GOFTag
            @interface Generic {
            }

            @DesignPattern.Behavioral
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.TYPE})
            @GOFTag
            @interface Concrete {
            }

        }

        @DesignPattern.Behavioral
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
        @GOFTag
        @interface ParameterValues {
        }

        @DesignPattern.Behavioral
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.METHOD})
        @GOFTag
        @interface ExecuteMethod {
        }

        @DesignPattern.Behavioral
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.FIELD, ElementType.PARAMETER})
        @GOFTag
        @interface Receiver {

            @DesignPattern.Behavioral
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.FIELD, ElementType.METHOD})
            @GOFTag
            @interface Method {
            }

        }

        @DesignPattern.Behavioral
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
        @GOFTag
        @interface Invoker {
        }

        @DesignPattern.Behavioral
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.FIELD})
        @GOFTag
        @interface Client {
        }

    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/strategy/">Strategy</a>
     * See <a href="https://en.wikipedia.org/wiki/Strategy_pattern">Strategy pattern</a>
     * enables an algorithm's behavior to be selected at runtime.
     * defines a family of algorithms, encapsulates each algorithm, and makes the algorithms interchangeable within that family.
     */
    @DesignPattern.Behavioral
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE})
    @GOFTag
    @interface Strategy {

        @DesignPattern.Behavioral
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
        @GOFTag
        @interface Interface {
        }

        @DesignPattern.Behavioral
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
        @GOFTag
        @interface Implementation {
        }

    }

    // Template method pattern

    /**
     * See <a href="http://java-design-patterns.com/patterns/template-method/">Template method</a>
     * See <a href="https://en.wikipedia.org/wiki/Template_method_pattern">Template method pattern</a>
     * In software engineering, the template method pattern i a behavioral design pattern that defines the program skeleton of an algorithm in an operation,
     * deferring some steps to subclasses.[1] It lets one redefine certain steps of an algorithm without changing the algorithm's structure.
     */
    @DesignPattern.Behavioral
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
    @GOFTag
    @interface TemplateMethod {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/visitor/">Visitor</a>
     * See <a href="https://en.wikipedia.org/wiki/Visitor_pattern">Visitor pattern</a>
     * i a way of separating an algorithm from an object structure on which it operates.
     * A practical result of this separation i the ability to add new operations to extant object structures
     * without modifying the structures. It i one way to follow the open/closed principle.
     */
    @DesignPattern.Behavioral
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
    @GOFTag
    @interface Visitor {

        @DesignPattern.Behavioral
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
     * The observer pattern i a software design pattern in which an object, called the subject, maintains a list of its dependents, called observers,
     * and notifies them automatically of any state changes, usually by calling one of their methods.
     */
    @DesignPattern.Behavioral
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({})
    @GOFTag
    @interface Observer {

        @DesignPattern.Behavioral
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.FIELD})
        @GOFTag
        @interface Interface {
        }

        @DesignPattern.Behavioral
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE})
        @GOFTag
        @interface Implementation {
        }

        @DesignPattern.Behavioral
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({})
        @GOFTag
        @interface NotifyMethod {

            @DesignPattern.Behavioral
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.METHOD})
            @GOFTag
            @interface Interface {
            }

            @DesignPattern.Behavioral
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.METHOD})
            @GOFTag
            @interface Implementation {
            }

        }

        @DesignPattern.Behavioral
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.FIELD})
        @GOFTag
        @interface Observable {
        }

    }


    /**
     * See <a href="http://java-design-patterns.com/patterns/dependency-injection/">DependencyInjection</a>
     */
    @DesignPattern.Behavioral
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
    @interface DependencyInjection {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/extension-objects/">Extension objects</a>
     */
    @DesignPattern.Behavioral
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
    @interface ExtensionObjects {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/feature-toggle/">Feature Toggle</a>
     */
    @DesignPattern.Behavioral
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
    @interface FeatureToggle {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/intercepting-filter/">Intercepting Filter</a>
     */
    @DesignPattern.Behavioral
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
    @interface InterceptingFilter {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/interpreter/">Interpreter</a>
     */
    @DesignPattern.Behavioral
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
    @interface Interpreter {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/iterator/">Iterator</a>
     */
    @DesignPattern.Behavioral
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
    @interface Iterator {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/memento/">Memento</a>
     */
    @DesignPattern.Behavioral
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
    @interface Memento {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/null-object/">Null Object</a>
     */
    @DesignPattern.Behavioral
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
    @interface NullObject {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/specification/">Specification</a>
     */
    @DesignPattern.Behavioral
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
    @interface Specification {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/throttling/">Throttling</a>
     */
    @DesignPattern.Behavioral
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
    @interface Throttling {
    }

}
