package vlfsoft.patterns.enterprise.flux;

import vlfsoft.patterns.design.DesignPattern;
import vlfsoft.tags.Related;

import java.lang.annotation.*;

/**
 * See <a href="http://java-design-patterns.com/patterns/flux/">Flux</a>
 *
 * {@link DesignPattern#Solution}:
 * "Flux eschews MVC in favor of a unidirectional data flow.",
 * "When a user interacts with a view, the view propagates an action through a central dispatcher,",
 * "to the various stores that hold the application's data and business logic,",
 * "which updates all of the views that are affected."
 */
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({})
public @interface Flux {
}
