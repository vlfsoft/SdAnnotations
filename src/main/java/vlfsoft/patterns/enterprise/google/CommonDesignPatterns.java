package vlfsoft.patterns.enterprise.google;

import vlfsoft.patterns.design.DesignPattern;

import java.lang.annotation.*;

/**
 * See <a href="https://cloud.google.com/apis/design/design_patterns">Common Design Patterns</a>
 *
 */
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({})
public @interface CommonDesignPatterns {

    /**
     * See <a href="http://java-design-patterns.com/patterns/partial-response/">Partial Response</a>
     */
    @DesignPattern.Architectural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @interface PartialResponse {
    }

}
