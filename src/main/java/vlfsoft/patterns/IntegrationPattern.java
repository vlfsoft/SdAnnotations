package vlfsoft.patterns;

import java.lang.annotation.*;

/**
 * See <a href="http://java-design-patterns.com/patterns/">Patterns</a>
 */
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({})
public @interface IntegrationPattern {

    /**
     * See <a href="http://java-design-patterns.com/patterns/message-channel/">Message Channel</a>
     */
    @DesignPattern.Integration
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
    @interface MessageChannel {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/publish-subscribe/">PublishSubscribe</a>
     */
    @DesignPattern.Integration
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
    @interface PublishSubscribe {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/tolerant-reader/">Tolerant Reader</a>
     */
    @DesignPattern.Integration
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
    @interface TolerantReader {
    }

}
