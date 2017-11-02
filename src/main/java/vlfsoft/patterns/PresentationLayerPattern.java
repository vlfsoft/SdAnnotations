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
public @interface PresentationLayerPattern {

    /**
     * See <a href="http://java-design-patterns.com/patterns/flux/">Flux</a>
     */
    @DesignPattern.PresentationLayer
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
    @interface Flux {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/front-controller/">FrontController</a>
     */
    @DesignPattern.PresentationLayer
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
    @interface FrontController {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/model-view-controller/">Model-View-Controller</a>
     */
    @DesignPattern.PresentationLayer
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
    @interface ModelViewController {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/model-view-presenter/">Model-View-Presenter</a>
     */
    @DesignPattern.PresentationLayer
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
    @interface ModelViewPresenter {
    }

}
