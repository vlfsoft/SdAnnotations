package vlfsoft.patterns;

import java.lang.annotation.*;

/**
 * See <a href="http://java-design-patterns.com/patterns/">Patterns</a>
 */
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({})
public @interface OtherPattern {

    /**
     * See <a href="http://java-design-patterns.com/patterns/caching/">Caching</a>
     */
    @DesignPattern.Other
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
    @interface Caching {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/callback/">Callback</a>
     */
    @DesignPattern.Other
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
    @interface Callback {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/double-dispatch/">DoubleDispatch</a>
     */
    @DesignPattern.Other
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
    @interface DoubleDispatch {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/execute-around/">ExecuteAround</a>
     */
    @DesignPattern.Other
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
    @interface ExecuteAround {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/fluentinterface/">FluentInterface</a>
     */
    @DesignPattern.Other
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
    @interface FluentInterface {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/lazy-loading/">Lazy Loading</a>
     */
    @DesignPattern.Other
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
    @interface LazyLoading {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/monad/">Monad</a>
     */
    @DesignPattern.Other
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
    @interface Monad {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/abstract-document/">MuteIdiom</a>
     */
    @DesignPattern.Other
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
    @interface MuteIdiom {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/poison-pill/">Poison Pill</a>
     */
    @DesignPattern.Other
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.FIELD})
    @interface PoisonPill {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/private-class-data/">Private Class Data</a>
     */
    @DesignPattern.Other
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
    @interface PrivateClassData {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/queue-load-leveling/">Queue based load leveling</a>
     */
    @DesignPattern.Other
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
    @interface QueueBasedLoadLeveling {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/resource-acquisition-is-initialization/">Resource Acquisition Is Initialization</a>
     */
    @DesignPattern.Other
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
    @interface ResourceAcquisitionIsInitialization {
    }

}
