package vlfsoft.patterns.enterprise.peaa;

import vlfsoft.patterns.design.DesignPattern;

import java.lang.annotation.*;

/**
 * See <a href="http://java-design-patterns.com/patterns/">Patterns</a>
 */
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({})
public @interface TestingPattern {

    /**
     *
     * See <a href="https://martinfowler.com/bliki/PageObject.html">PageObject</a>
     *
     * See <a href="http://java-design-patterns.com/patterns/page-object/">PageObject</a>
     */
    @DesignPattern.Testing
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @interface PageObject {
    }

}
