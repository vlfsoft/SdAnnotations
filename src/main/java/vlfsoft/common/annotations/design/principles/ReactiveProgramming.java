package vlfsoft.common.annotations.design.principles;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * See <a href="https://en.wikipedia.org/wiki/Reactive_programming">Reactive programming</a>
 * See <a href="http://www.reactivemanifesto.org">The Reactive Manifesto</a>
 *
 */
@SoftwareDesign
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({})
public @interface ReactiveProgramming {

    @SoftwareDesign
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.FIELD})
    public @interface Responsive {
    }

    @SoftwareDesign
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.FIELD})
    public @interface Resilient {
    }

    @SoftwareDesign
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.FIELD})
    public @interface Elastic {
    }

    @SoftwareDesign
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.FIELD})
    public @interface MessageDriven {
    }

}
