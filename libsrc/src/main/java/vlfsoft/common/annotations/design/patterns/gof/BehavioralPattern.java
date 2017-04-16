package vlfsoft.common.annotations.design.patterns.gof;

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
     * See <a href="https://en.wikipedia.org/wiki/Mediator_pattern">Mediator pattern</a>
     */
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
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
    @interface State {
    }

    /**
     * See <a href="https://en.wikipedia.org/wiki/Chain-of-responsibility_pattern">Chain-of-responsibility pattern</a>
     */
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
    @interface ChainOfResponsibility {
    }

    /**
     * See <a href="https://en.wikipedia.org/wiki/Command_pattern">Command pattern</a>
     * An object is used to encapsulate all information needed to perform an action or trigger an event at a later time.
     * This information includes the method name, the object that owns the method and values for the method parameters.
     */
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
    @interface Command {
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
    @interface Strategy {
    }

}
