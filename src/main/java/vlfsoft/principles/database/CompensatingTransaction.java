package vlfsoft.principles.database;

import vlfsoft.tags.Related;

import java.lang.annotation.*;

/**
 * See <a href="https://en.wikipedia.org/wiki/Compensating_transaction">Compensating transaction</a>
 * Basically Available, Soft state, Eventual consistency
 */
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.ANNOTATION_TYPE})
@Related.Patterns({BASE.class,EventualConsistency.class})
public @interface CompensatingTransaction {
}
