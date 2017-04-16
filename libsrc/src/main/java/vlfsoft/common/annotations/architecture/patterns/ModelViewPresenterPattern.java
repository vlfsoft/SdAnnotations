package vlfsoft.common.annotations.architecture.patterns;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * See <a href="https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93presenter">Model–view–presenter</a>
 * is a derivation of the model–view–controller (MVC) architectural pattern, and is used mostly for building user interfaces.
 * In MVP the presenter assumes the functionality of the "middle-man". In MVP, all presentation logic is pushed to the presenter.
 * See <a href="http://stackoverflow.com/questions/4733700/what-is-the-difference-between-controller-in-mvc-pattern-and-presenter-in-mvp-pa">What is the difference between controller in MVC pattern and presenter in MVP pattern?</a>
 * See <a href="http://stackoverflow.com/questions/2056/what-are-mvp-and-mvc-and-what-is-the-difference">What are MVP and MVC and what is the difference?</a>
 * See <a href="http://www.infragistics.com/community/blogs/todd_snyder/archive/2007/10/17/mvc-or-mvp-pattern-whats-the-difference.aspx">MVC or MVP Pattern – Whats the difference?</a>
 */
@Inherited
@Documented
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface ModelViewPresenterPattern {

    /**
     * interface defining the data to be displayed or otherwise acted upon in the user interface.
     */
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.METHOD})
    @interface Model {
    }

    /**
     * passive interface that displays data (the model) and routes user commands (events) to the presenter to act upon that data.
     */
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.METHOD})
    @interface View {
    }

    /**
     * acts upon the model and the view. It retrieves data from repositories (the model), and formats it for display in the view.
     */
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.METHOD})
    @interface Presenter {
    }

    /**
     * view is updated by either the model or the presenter. If no formatting is required, the view updates itself via the model.
     * If formatting is required, it updates itself via the presenter.
     */
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.METHOD})
    @interface SupervisingController {
    }

}
