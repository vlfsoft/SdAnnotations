package vlfsoft.patterns;

import java.lang.annotation.*;

/**
 * See <a href="http://java-design-patterns.com/patterns/">Patterns</a>
 */
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({})
public @interface ArchitecturalPattern {

    /**
     * See <a href="http://java-design-patterns.com/patterns/api-gateway">API Gateway</a>
     */
    @DesignPattern.Architectural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
    @interface ApiGateway {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/aggregator-microservices/">Aggregator Microservices</a>
     */
    @DesignPattern.Architectural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
    @interface AggregatorMicroservices {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/cqrs/">CQRS</a>
     * CQRS - Command Query Responsibility Segregation
     */
    @DesignPattern.Architectural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
    @interface CQRS {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/data-bus/">Data Bus</a>
     */
    @DesignPattern.Architectural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
    @interface DataBus {
    }

    /**
     * See {@link vlfsoft.patterns.ObjectKindPattern.DTO}
     */
    @DesignPattern.Architectural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({})
    @interface DataTransferObject {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/event-driven-architecture/">Event Driven Architecture</a>
     */
    @DesignPattern.Architectural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
    @interface EventDrivenArchitecture {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/event-sourcing/">Event Sourcing</a>
     */
    @DesignPattern.Architectural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
    @interface EventSourcing {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/hexagonal/">Hexagonal Architecture</a>
     */
    @DesignPattern.Architectural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
    @interface HexagonalArchitecture {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/layers/">Layers</a>
     */
    /**
     * See <a href="https://en.wikipedia.org/wiki/Layer_(object-oriented_design)">Layer (object-oriented_design)</a>
     */
    @DesignPattern.Architectural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE})
    @interface Layers {


        /**
         * See <a href="https://en.wikipedia.org/wiki/Data_access_layer">Data access layer</a>
         */
        @DesignPattern.Architectural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE})
        @interface DAL {

        }

        /**
         * See <a href="https://en.wikipedia.org/wiki/Database_abstraction_layer">Database abstraction layer</a>
         * {@link ObjectKindPattern.DAO}
         */
        @DesignPattern.Architectural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE})
        @interface DatabaseAbstractionLayer {

        }

        /**
         */
        @DesignPattern.Architectural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE})
        @interface ServiceLayer {

        }

    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/partial-response/">Partial Response</a>
     */
    @DesignPattern.Architectural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
    @interface PartialResponse {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/service-layer/">Service Layer</a>
     */
    @DesignPattern.Architectural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
    @interface ServiceLayer {
    }

    /**
     * See <a href="https://en.wikipedia.org/wiki/Hierarchical_model%E2%80%93view%E2%80%93controller">Hierarchical model–view–controller</a>
     */
    @DesignPattern.Architectural
    @Inherited
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.METHOD})
    @interface HierarchicalModelViewController {

        @DesignPattern.Architectural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.METHOD})
        @interface Model {
        }

        @DesignPattern.Architectural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.METHOD})
        @interface View {
        }

        @DesignPattern.Architectural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.METHOD})
        @interface Controller {
        }

    }

    /**
     * See <a href="https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93adapter">Model–view–adapter</a>
     */
    @DesignPattern.Architectural
    @Inherited
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.METHOD})
    @interface ModelViewAdapter {

        @DesignPattern.Architectural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.METHOD})
        @interface Model {
        }

        @DesignPattern.Architectural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.METHOD})
        @interface View {
        }

        @DesignPattern.Architectural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.METHOD})
        @interface Adapter {
        }

    }

    /**
     * See <a href="https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93controller">Model–view–controller</a>
     */
    @DesignPattern.Architectural
    @Inherited
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.METHOD})
    @interface ModelViewController {

        /**
         * stores data that i retrieved according to command from the controller and displayed in the view.
         */
        @DesignPattern.Architectural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.METHOD})
        @interface Model {
        }

        /**
         * generates new output to the user based on changes in the model.
         */
        @DesignPattern.Architectural
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
        @DesignPattern.Architectural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.METHOD})
        @interface Controller {
        }

    }

    /**
     * See <a href="https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93presenter">Model–view–presenter</a>
     * i a derivation of the model–view–controller (MVC) architectural pattern, and i used mostly for building user interfaces.
     * In MVP the presenter assumes the functionality of the "middle-man". In MVP, all presentation logic i pushed to the presenter.
     * See <a href="http://stackoverflow.com/questions/4733700/what-is-the-difference-between-controller-in-mvc-pattern-and-presenter-in-mvp-pa">What i the difference between controller in MVC pattern and presenter in MVP pattern?</a>
     * See <a href="http://stackoverflow.com/questions/2056/what-are-mvp-and-mvc-and-what-is-the-difference">What are MVP and MVC and what i the difference?</a>
     * See <a href="http://www.infragistics.com/community/blogs/todd_snyder/archive/2007/10/17/mvc-or-mvp-pattern-whats-the-difference.aspx">MVC or MVP Pattern – Whats the difference?</a>
     */
    @DesignPattern.Architectural
    @Inherited
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.METHOD})
    @interface ModelViewPresenterPattern {

        /**
         * interface defining the data to be displayed or otherwise acted upon in the user interface.
         */
        @DesignPattern.Architectural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.METHOD})
        @interface Model {
        }

        /**
         * passive interface that displays data (the model) and routes user command (events) to the presenter to act upon that data.
         */
        @DesignPattern.Architectural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.METHOD})
        @interface View {
        }

        /**
         * acts upon the model and the view. It retrieves data from repositories (the model), and formats it for display in the view.
         */
        @DesignPattern.Architectural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.METHOD})
        @interface Presenter {
        }

        /**
         * view i updated by either the model or the presenter. If no formatting i required, the view updates itself via the model.
         * If formatting i required, it updates itself via the presenter.
         */
        @DesignPattern.Architectural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.METHOD})
        @interface SupervisingController {
        }

    }

    /**
     * See <a href="https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93viewmodel">Model–view–viewmodelr</a>
     *
     * Declarative data- and command-binding are implicit in the MVVM pattern.
     * In the Microsoft solution stack, the binder i a markup language called XAML.[8]
     * The binder frees the developer from being obliged to write boiler-plate logic to synchronize the view model and view.
     * When implemented outside of the Microsoft stack the presence of a declarative databinding technology i a key enabler of the pattern
     *
     * A criticism of the pattern comes from MVVM creator John Gossman himself,[13]
     * who points out overhead in implementing MVVM i "overkill" for simple UI operations.
     * He states for larger applications, generalizing the ViewModel becomes more difficult.
     * Moreover, he illustrates data binding in very large applications can result in considerable memory consumption.
     */
    @DesignPattern.Architectural
    @Inherited
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.METHOD})
    @interface ModelViewViewModelPattern {

        @DesignPattern.Architectural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.METHOD})
        @interface Model {
        }

        @DesignPattern.Architectural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.METHOD})
        @interface View {
        }

        @DesignPattern.Architectural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.METHOD})
        @interface ViewModel {
        }

    }

}
