package vlfsoft.principles.generic;

import vlfsoft.principles.ProgrammingPrinciple;

import java.lang.annotation.*;

/**
 * See <a href="https://en.wikipedia.org/wiki/Composability">Composability</a>
 * principle that deals with the inter-relationships of components. A highly composable system provides components that can be selected and assembled in various combinations to satisfy specific user requirements.
 * In information systems, the essential features that make a component composable are that it be:
 */
@ProgrammingPrinciple.Generic
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.ANNOTATION_TYPE})
public @interface ComposabilityPrinciple {
    boolean value();
}
