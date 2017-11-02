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
public @interface UnCategorizedPattern {

    /**
     * See <a href="http://java-design-patterns.com/patterns/eip-wire-tap/">EIP Wire Tap</a>
     */
    @DesignPattern.UnCategorized
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
    @interface EIPWireTap {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/marker/">MarkerInterface</a>
     */
    @DesignPattern.UnCategorized
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
    @interface MarkerInterface {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/converter/">Converter</a>
     */
    @DesignPattern.UnCategorized
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
    @interface Converter {
    }

}
