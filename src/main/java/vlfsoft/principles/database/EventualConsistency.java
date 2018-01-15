package vlfsoft.principles.database;

import vlfsoft.tags.Related;

import java.lang.annotation.*;

/**
 * See <a href="https://en.wikipedia.org/wiki/Eventual_consistency">Eventual consistency</a>
 * 
 */
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.ANNOTATION_TYPE})
@BASE
@Related.Patterns(CompensatingTransaction.class)
public @interface EventualConsistency {
}
