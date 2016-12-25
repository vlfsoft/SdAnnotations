package vlfsoft.common.annotations.architecture.principles;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * See <a href="https://en.wikipedia.org/wiki/Layer_(object-oriented_design)">Layer (object-oriented_design)</a>
 */
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.TYPE})
public @interface Layer {


    /**
     * See <a href="https://en.wikipedia.org/wiki/Data_access_layer">Data access layer</a>
     */
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE})
    @interface DAL {

    }

    /**
     * See <a href="https://en.wikipedia.org/wiki/Database_abstraction_layer">Database abstraction layer</a>
     * {@link vlfsoft.common.annotations.design.principles.ObjectClassifier.DAO}
     */
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE})
    @interface DatabaseAbstractionLayer {

    }

}
