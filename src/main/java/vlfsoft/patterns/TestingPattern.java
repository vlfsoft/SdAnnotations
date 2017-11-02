package vlfsoft.patterns;

import vlfsoft.patterns.DesignPattern;

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
     * See <a href="http://java-design-patterns.com/patterns/page-object/">PageObject</a>
     */
    @DesignPattern.Testing
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
    @interface PageObject {
    }

}
