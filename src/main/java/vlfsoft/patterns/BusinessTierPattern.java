package vlfsoft.patterns;

import java.lang.annotation.*;

/**
 * See <a href="http://java-design-patterns.com/patterns/">Patterns</a>
 */
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({})
public @interface BusinessTierPattern {

    /**
     * See <a href="http://java-design-patterns.com/patterns/business-delegate/">BusinessDelegate</a>
     */
    @DesignPattern.BusinessTier
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
    @interface BusinessDelegate {
    }

}
