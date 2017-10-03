package vlfsoft.common.annotations.architecture.patterns;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * See <a href="https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93controller">Model–view–controller</a>
 */
@Inherited
@Documented
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface ModelViewController {

    /**
     * stores data that is retrieved according to command from the controller and displayed in the view.
     */
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.METHOD})
    @interface Model {
    }

    /**
     * generates new output to the user based on changes in the model.
     */
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.METHOD})
    @interface View {
    }

    /**
     * can send command to the model to update the model's state (e.g., editing a document).
     * It can also send command to its associated view to change the view's presentation of the model (e.g., scrolling through a document).
     */
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.METHOD})
    @interface Controller {
    }

}
