package vlfsoft.patterns.enterprise.sdp;

import vlfsoft.patterns.design.DesignPattern;

import java.lang.annotation.*;

/**
 * See <a href="https://martinfowler.com/books/sdp.html">Service Design Patterns</a>
 *
 */
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({})
public @interface ServiceDesignPatterns {

    /**
     * See <a href="https://martinfowler.com/bliki/TolerantReader.html">TolerantReader</a>
     *
     * See <a href="http://java-design-patterns.com/patterns/tolerant-reader/">Tolerant Reader</a>
     */
    @DesignPattern.Architectural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @interface TolerantReader {
    }

}
