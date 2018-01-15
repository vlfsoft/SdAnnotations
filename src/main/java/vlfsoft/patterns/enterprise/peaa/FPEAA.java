package vlfsoft.patterns.enterprise.peaa;

import vlfsoft.paradigms.ProgrammingParadigm;
import vlfsoft.patterns.GOF;
import vlfsoft.patterns.design.DesignPattern;
import vlfsoft.patterns.enterprise.architecture.HexagonalArchitecture;
import vlfsoft.patterns.enterprise.ddd.DDD;
import vlfsoft.patterns.enterprise.microservices.Microservices;
import vlfsoft.patterns.enterprise.peaa.PEAA.ApplicationController;
import vlfsoft.principles.moduleclass.CommandQuerySeparationPrinciple;
import vlfsoft.tags.DDDEvansTag;
import vlfsoft.tags.Related;

import java.lang.annotation.*;

/**
 * Further Patterns of Enterprise Application Architecture
 * See <a href="https://martinfowler.com/eaaDev/">Development of Further Patterns of Enterprise Application Architecture</a>
 */
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({})
public @interface FPEAA {

    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({})
    @interface Patterns {

        /**
         * See <a href="https://martinfowler.com/eaaDev/timeNarrative.html">Temporal Patterns</a>
         */
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.ANNOTATION_TYPE})
        @interface Temporal {
        }

        /**
         * See <a href="https://martinfowler.com/eaaDev/EventNarrative.html">Focusing on Events</a>
         * <p>
         * See <a href="http://java-design-patterns.com/patterns/event-driven-architecture/">Event Driven Architecture</a>
         * See <a href="https://en.wikipedia.org/wiki/Event-driven_architecture">Event-driven architecture</a>
         * <p>
         * See <a href="https://martinfowler.com/tags/event%20architectures.html">tagged by: event architectures</a>
         * See <a href="https://martinfowler.com/articles/201701-event-driven.html">What do you mean by “Event-Driven”?</a>
         * Event Notification, Event-Carried State Transfer, {@link EventSourcing}, {@link CQRS}
         * <p>
         * {@link DesignPattern#Solution}: Send and notify state changes of your objects to other applications using an Event-driven Architecture.
         */
        @ProgrammingParadigm.Declarative.DataFlow.Reactive
        @DesignPattern.Architectural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.ANNOTATION_TYPE})
        @Related.Patterns({CQRS.class, EventSourcing.class})
        @DesignPattern(aka = {"event-driven programming model"})
        @interface EventDrivenArchitecture {
        }

        /**
         * See <a href="https://martinfowler.com/eaaDev/AccountingNarrative.html">Patterns for Accounting</a>
         */
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.ANNOTATION_TYPE})
        @interface Accounting {
        }

        /**
         * See <a href="https://martinfowler.com/eaaDev/OrganizingPresentations.html">Organizing Presentation Logic</a>
         * See <a href="https://martinfowler.com/eaaDev/uiArchs.html">GUI Architectures</a>
         */
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.ANNOTATION_TYPE})
        @interface Presentation {
        }

        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.ANNOTATION_TYPE})
        @interface Base {
        }

        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.ANNOTATION_TYPE})
        @interface Unclassified {
        }

    }

    @Retention(RetentionPolicy.SOURCE)
    @interface BEG_Temporal {
    }

    /**
     * See <a href="https://martinfowler.com/eaaDev/AuditLog.html">Audit Log</a>
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Temporal
    @interface AuditLog {
    }

    /**
     * See <a href="https://martinfowler.com/eaaDev/TimePoint.html">Time Point</a>
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Temporal
    @interface TimePoint {
    }

    /**
     * See <a href="https://martinfowler.com/eaaDev/Effectivity.html">Effectivity</a>
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Temporal
    @interface Effectivity {
    }

    /**
     * See <a href="https://martinfowler.com/eaaDev/TemporalProperty.html">Temporal Property</a>
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Temporal
    @interface TemporalProperty {
    }

    /**
     * See <a href="https://martinfowler.com/eaaDev/TemporalObject.html">Temporal Object</a>
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Temporal
    @interface TemporalObject {
    }

    /**
     * See <a href="https://martinfowler.com/eaaDev/Snapshot.html">Snapshot</a>
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Temporal
    @interface Snapshot {
    }

    @Retention(RetentionPolicy.SOURCE)
    @interface BEG_EventDrivenArchitecture {
    }

    /**
     * See <a href="https://martinfowler.com/eaaDev/DomainEvent.html">Domain Event</a>
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({})
    @Patterns.EventDrivenArchitecture
    @Related.Patterns(DDD.DomainEvent.class)
    @interface DomainEvent {
    }

    /**
     * See <a href="https://martinfowler.com/eaaDev/EventCollaboration.html">Event Collaboration</a>
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({})
    @Patterns.EventDrivenArchitecture
    @Related.Patterns(DDD.DomainEvent.class)
    @interface EventCollaboration {
    }

    /**
     * See <a href="https://martinfowler.com/eaaDev/EventSourcing.html">Event Sourcing</a>
     * See <a href="http://java-design-patterns.com/patterns/event-sourcing/">Event Sourcing</a>
     */
    @DesignPattern.Architectural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.EventDrivenArchitecture
    @interface EventSourcing {
    }

    /**
     * See <a href="https://martinfowler.com/eaaDev/AgreementDispatcher.html">Agreement Dispatcher</a>
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({})
    @Patterns.EventDrivenArchitecture
    @Related.Patterns(DDD.DomainEvent.class)
    @interface AgreementDispatcher {
    }

    /**
     * See <a href="https://martinfowler.com/eaaDev/ParallelModel.html">Parallel Model</a>
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({})
    @Patterns.EventDrivenArchitecture
    @Related.Patterns(DDD.DomainEvent.class)
    @interface ParallelModel {
    }

    /**
     * See <a href="https://martinfowler.com/eaaDev/RetroactiveEvent.html">Retroactive Event</a>
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({})
    @Patterns.EventDrivenArchitecture
    @Related.Patterns(DDD.DomainEvent.class)
    @interface RetroactiveEvent {
    }

    @Retention(RetentionPolicy.SOURCE)
    @interface BEG_Accounting {
    }

    /**
     * See <a href="https://martinfowler.com/eaaDev/Account.html">Account</a>
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Accounting
    @interface Account {
    }

    /**
     * See <a href="https://martinfowler.com/eaaDev/AccountingEntry.html">Accounting Entry</a>
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Accounting
    @interface AccountingEntry {
    }

    /**
     * See <a href="https://martinfowler.com/eaaDev/AccountingTransaction.html">Accounting Transaction</a>
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Accounting
    @interface AccountingTransaction {
    }

    /**
     * See <a href="https://martinfowler.com/eaaDev/ReplacementAdjustment.html">Replacement Adjustment</a>
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Accounting
    @interface ReplacementAdjustment {
    }

    /**
     * See <a href="https://martinfowler.com/eaaDev/ReversalAdjustment.html">Reversal Adjustment</a>
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Accounting
    @interface ReversalAdjustment {
    }

    /**
     * See <a href="https://martinfowler.com/eaaDev/DifferenceAdjustment.html">Difference Adjustment</a>
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Accounting
    @interface DifferenceAdjustment {
    }

    @Retention(RetentionPolicy.SOURCE)
    @interface BEG_Presentation {
    }

    /**
     * See <a href="https://martinfowler.com/eaaDev/Notification.html">Notification</a>
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Presentation
    @interface Notification {
    }

    /**
     * See <a href="https://martinfowler.com/eaaDev/SupervisingPresenter.html">Supervising Controller</a>
     * Factor the UI into a view and controller where the view handles simple mapping to the underlying model and the the controller handles input response and complex view logic.
     * {@link SupervisingController} decomposes presentation functionality into two parts: a controller (often called {@link ModelViewPresenter.Presenter}) and view.
     * The domain data that needs to be displayed is separate, and following rough MVC terminology I'll refer to it as a model, although it need not be a Domain Model.
     * A Supervising Controller has two primary responsibilities: input response and partial view/model synchronization.
     * For input response the controller operates in the {@link ModelViewPresenter.Presenter} style. The user gestures are handled initially by the screen widgets,
     * however all they do in response is to hand these events off to the presenter, which handles all further logic.
     * For view/model synchronization the controller defers as much of this as reasonable to the view.
     * The view typically uses some form of {@link DataBinding} to populate much of the information for its fields.
     * Where {@link DataBinding} isn't up to more complex interactions then the controller steps in.
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Presentation
    @Related.Patterns({ModelViewPresenter.class, PassiveView.class})
    @GUIArchitectures
    @interface SupervisingController {
    }

    /**
     * See <a href="https://martinfowler.com/eaaDev/PassiveScreen.html">Passive View</a>
     * A screen and components with all application specific behavior extracted into a controller so that the widgets have their state controlled entirely by controller.
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Presentation
    @Related.Patterns(ModelViewPresenter.class)
    @GUIArchitectures
    @interface PassiveView {
    }

    /**
     * See <a href="https://martinfowler.com/eaaDev/PresentationModel.html">Presentation Model</a>
     * Represent the state and behavior of the presentation independently of the GUI controls used in the interface
     *
     * {@link GUIArchitectures}: The {@link PresentationModel} works well also for another presentation logic problem - presentation state.
     * The basic MVC notion assumes that all the state of the view can be derived from the state of the model. In this case how do we figure out which station is selected in the list box?
     * The {@link PresentationModel} solves this for us by giving us a place to put this kind of state. A similar problem occurs if we have save buttons that are only enabled if data has changed - again that's state about our interaction with the model, not the model itself.
     * {@link PresentationModel} is a pattern that pulls presentation behavior from a view. As such it's an alternative to to {@link SupervisingController} and {@link PassiveView}.
     * It's useful for allowing you to test without the UI, support for some form of multiple view and a separation of concerns which may make it easier to develop the user interface.
     * <p>
     *
     * {@link PresentationModel} may interact with several domain objects, but {@link PresentationModel} is not a GUI friendly facade to a specific domain object.
     * Instead it is easier to consider {@link PresentationModel} as an abstract of the view that is not dependent on a specific GUI framework.
     * While several views can utilize the same {@link PresentationModel}, each view should require only one {@link PresentationModel}.
     * In the case of composition a Presentation Model may contain one or many child {@link PresentationModel} instances, but each child control will also have only one {@link PresentationModel}.
     *
     * Compared to {@link PassiveView} and {@link SupervisingController}, {@link PresentationModel} allows you to write logic that is completely independent of the views used for display.
     * You also do not need to rely on the view to store state. The downside is that you need a synchronization mechanism between the presentation model and the view.
     * This synchronization can be very simple, but it is required.
     */
    @DesignPattern(aka = "UI-state model")
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Presentation
    @Related.Patterns(ModelViewViewModel.class)
    @interface PresentationModel {
    }

    /**
     * See <a href="https://martinfowler.com/eaaDev/EventAggregator.html">Event Aggregator</a>
     * <p>
     * See <a href="http://java-design-patterns.com/patterns/event-aggregator/">Event Aggregator</a>
     * <p>
     * {@link DesignPattern.Language.Form#Problem}: "A system with lots of objects can lead to complexities when a client wants to subscribe to events.",
     * "The client has to find and register for each object individually,",
     * "if each object has multiple events then each event requires a separate subscription.",
     * {@link DesignPattern#Solution}:
     * "An Event Aggregator acts as a single source of events for many objects.",
     * "It registers for all the events of the many objects allowing clients to register with just the aggregator.",
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Presentation
    @interface EventAggregator {
    }

    /**
     * See <a href="https://martinfowler.com/eaaDev/WindowDriver.html">Window Driver</a>
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Presentation
    @interface WindowDriver {
    }

    /**
     * See <a href="https://martinfowler.com/eaaDev/FlowSynchronization.html">Flow Synchronization</a>
     * Synchronize screens with an underlying model based on the flow of the user interaction between the screens.
     * Applications often contain multiple screens that display the same data. If the data is edited in one screen, then the other screens must be updated to reflect the changes.
     * {@link FlowSynchronization} does this by having the screen code explicitly re-synchronize at the appropriate point in the work flow of the screen.
     * {@link FlowSynchronization} is a very simple approach to explain. Essentially each time you do something that changes state that's shared across multiple screens,
     * you tell each screen to update itself. The problem is that this means, in general, that every screen is somewhat coupled to the other the other screens in the application.
     * If you have a lot of screens that are working in a very open-ended way, this can be nasty - which is {@link ObserverSynchronization} is such a strong alternative.
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Presentation
    @interface FlowSynchronization {
    }

    /**
     * See <a href="https://martinfowler.com/eaaDev/MediatedSynchronization.html">Observer Synchronization</a>
     * Synchronize multiple screens by having them all be observers to a shared area of domain data.
     * The essence of this approach is that each screen, with its associated screen state, acts as an {@link GOF.Observer} on a common area of session data.
     * All changes to the session data result in events which the screens listen to and respond by reloading from the session data.
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Presentation
    @interface ObserverSynchronization {
    }

    /**
     * See <a href="https://martinfowler.com/eaaDev/PresentationChooser.html">Presentation Chooser</a>
     * When the navigation between screens is directed by the presentation, the presentation can encode the sequence of screens to display directly.
     * This way the presentation always knows which screen needs to be opened whenever a suitable event occurs.
     * Sometimes, however, the screen that should be displayed depends upon information in the domain.
     * The presentation does not know which screen to show, instead it knows that it should display a domain object in some window. The domain object cannot choose the screen,
     * because that would violate Separated Presentation
     * A Presentation Chooser resovles what screen should be used for a particular domain object. The client knows it should open a new screen to display a particular domain object.
     * The client asks the Presentation Chooser what screen should be used for this domain object and opens the returned window.
     * <p>
     * Both {@link PresentationChooser} and {@link ApplicationController} decouple the choice of screen class the triggerring navigation.
     * {@link PresentationChooser} is best when the domain object to be displayed is the primary variation, {@link ApplicationController} is better when the state of the application is the primary variation. When both vary it makes sense to combine the patterns.
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Presentation
    @SeparatedPresentation
    @Related.Patterns(ApplicationController.class)
    @interface PresentationChooser {
    }

    /**
     * See <a href="https://martinfowler.com/eaaDev/SeparatedPresentation.html">Separated Presentation</a>
     * Ensure that any code that manipulates presentation only manipulates presentation, pushing all domain and data source logic into clearly separated areas of the program.
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Presentation
    @interface SeparatedPresentation {
    }

    @Retention(RetentionPolicy.SOURCE)
    @interface BEG_Base {
    }

    /**
     * See <a href="https://martinfowler.com/eaaDev/Range.html">Range</a>
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Base
    @interface Range {
    }

    @Retention(RetentionPolicy.SOURCE)
    @interface BEG_Unclassified {
    }

    /**
     * See <a href="https://martinfowler.com/eaaDev/MoneyBag.html">(Money Bag*********)</a>
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Related.Patterns(Patterns.Presentation.class)
    @interface MoneyBag {
    }

    /**
     * See <a href="https://martinfowler.com/eaaDev/ProposedObject.html">(Proposed Object*********)</a>
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Related.Patterns(Patterns.Presentation.class)
    @interface ProposedObject {
    }

    /**
     * See <a href="https://martinfowler.com/eaaDev/RequestResponseCollaboration.html">(Request-Response Collaboration*********)</a>
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Related.Patterns(Patterns.Presentation.class)
    @interface RequestResponseCollaboration {
    }

    /**
     * See <a href="https://martinfowler.com/eaaDev/AutonomousView.html">(Autonomous View*********)</a>
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Related.Patterns(Patterns.Presentation.class)
    @interface AutonomousView {
    }

    /**
     * See <a href="https://martinfowler.com/eaaDev/DataBinding.html">(Data Binding*********)</a>
     * A mechanism that ensures that any change made to the data in a UI control is automatically carried over to the underlying session state (and vice versa).
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Related.Patterns(Patterns.Presentation.class)
    @interface DataBinding {
    }

    /**
     * See <a href="https://en.wikipedia.org/wiki/Command%E2%80%93query_separation">Command–query separation</a>
     * See <a href="https://martinfowler.com/bliki/CommandQuerySeparation.html">CommandQuerySeparation</a>
     */
    @DesignPattern.Architectural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({})
    @Related.Patterns(CQRS.class)
    @CommandQuerySeparationPrinciple(true)
    @interface CQS {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/cqrs/">CQRS</a>
     * CQRS: Command Query Responsibility Segregation - separate the query side from the command side.
     * <p>
     * See <a href="https://martinfowler.com/bliki/CQRS.html">CQRS</a>
     * Pictures illustrating pattern: ...
     * When to use it: ...
     * ...
     * Despite these benefits, you should be very cautious about using CQRS.
     * {@link DDDEvansTag}: Operations can be broadly divided into two categories, {@link Command}s and {@link Query}s.
     * {@link Query}s obtain information from the system, possibly by simply accessing data in a variable, possibly performing a calculation based on that data.
     * {@link Command}s (also known as modifiers) are operations that affect some change to the systems (for a simple example, by setting a variable).
     * {@link DDDEvansTag}: Strictly segregate commands (methods that result in modifications to observable state) into very simple operations that do not return domain information.
     */
    @DesignPattern.Architectural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @CommandQuerySeparationPrinciple(true)
    @Related.Patterns({CQS.class, Patterns.EventDrivenArchitecture.class, Microservices.CQRS.class})
    @interface CQRS {
        /**
         * See <a href="https://habrahabr.ru/post/268627/">Типы CQRS</a>
         *
         * @return one of {@link CQRS_0},  ...
         */
        Class[] value() default {};

        @Retention(RetentionPolicy.SOURCE)
        @Target({})
        @interface CQRS_0 {
        }

        @Retention(RetentionPolicy.SOURCE)
        @Target({})
        @interface CQRS_1 {
        }

        @Retention(RetentionPolicy.SOURCE)
        @Target({})
        @interface CQRS_2 {
        }

        @Retention(RetentionPolicy.SOURCE)
        @Target({})
        @interface CQRS_3 {
        }

        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD})
        @interface Command {
        }

        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD})
        @interface Query {
        }
    }

    /**
     * See <a href="https://martinfowler.com/eaaDev/uiArchs.html">GUI Architectures</a>
     */
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @interface GUIArchitectures {
    }

    /**
     * See <a href="https://martinfowler.com/eaaDev/ModelViewPresenter.html">Retirement note for Model View Presenter Pattern</a>
     * <p>
     * See <a href="https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93presenter">Model–view–presenter</a>
     * is a derivation of the model–view–controller (MVC) architectural pattern, and i used mostly for building user interfaces.
     * In MVP the presenter assumes the functionality of the "middle-man". In MVP, all presentation logic i pushed to the presenter.
     * See <a href="http://stackoverflow.com/questions/4733700/what-is-the-difference-between-controller-in-mvc-pattern-and-presenter-in-mvp-pa">What i the difference between controller in MVC pattern and presenter in MVP pattern?</a>
     * See <a href="http://stackoverflow.com/questions/2056/what-are-mvp-and-mvc-and-what-is-the-difference">What are MVP and MVC and what i the difference?</a>
     * See <a href="http://www.infragistics.com/community/blogs/todd_snyder/archive/2007/10/17/mvc-or-mvp-pattern-whats-the-difference.aspx">MVC or MVP Pattern – Whats the difference?</a>
     * <p>
     * See <a href="http://java-design-patterns.com/patterns/model-view-presenter/">Model-View-Presenter</a>
     * <p>
     * {@link vlfsoft.tags.MFowlerTag}: Upon further study and reflection, I decided that pattern that was here under the name {@link ModelViewPresenter} needed to be split,
     * so I have separated it into {@link SupervisingController} and {@link PassiveView}. You can find a discussion of the origins of {@link ModelViewPresenter} in the context of {@link GUIArchitectures} here .
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Related.Patterns({Patterns.Presentation.class, SupervisingController.class, PassiveView.class})
    @interface ModelViewPresenter {
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
     * See <a href="https://en.wikipedia.org/wiki/Hierarchical_model%E2%80%93view%E2%80%93controller">Hierarchical model–view–controller</a>
     */
    @DesignPattern.Architectural
    @Inherited
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.METHOD})
    @GUIArchitectures
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
    @GUIArchitectures
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
     * See <a href="https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93viewmodel">Model–view–viewmodelr</a>
     * <p>
     * Declarative data- and command-binding are implicit in the MVVM pattern.
     * In the Microsoft solution stack, the binder i a markup language called XAML.[8]
     * The binder frees the developer from being obliged to write boiler-plate logic to synchronize the view model and view.
     * When implemented outside of the Microsoft stack the presence of a declarative databinding technology i a key enabler of the pattern
     * <p>
     * A criticism of the pattern comes from MVVM creator John Gossman himself,[13]
     * who points out overhead in implementing MVVM i "overkill" for simple UI operations.
     * He states for larger applications, generalizing the ViewModel becomes more difficult.
     * Moreover, he illustrates data binding in very large applications can result in considerable memory consumption.
     * <p>
     * {@link ModelViewViewModel} is a variation of Martin Fowler's {@link PresentationModel} design pattern.[2][3]
     * {@link ModelViewViewModel} abstracts a view's state and behavior in the same way,[3]
     * but a {@link PresentationModel} abstracts a view (creates a view model) in a manner not dependent on a specific user-interface platform.
     *
     * Rule of thumb: {@link ViewModel} is combination of properties,
     * that are derived from {@link PEAA.DomainModel} -> {@link ViewModel.ApplicationDataModel}
     * and from UI specific properties derived from {@link PresentationModel} -> {@link ViewModel.UIStateModel}
     * In order to streamline decoupling {@link ViewModel} and {@link PEAA.DomainModel,
     * hold both {@link ViewModel.ApplicationDataModel} and {@link ViewModel.UIStateModel} properties in {@link ViewModel}.
     * I.e. {@link ViewModel.ApplicationDataModel} properties in {@link ViewModel} should be populated from {@link PEAA.DomainModel} via {@link HexagonalArchitecture.Port.Primary},
     * {@link ViewModel.ApplicationDataModel} properties in {@link ViewModel} can be populated either from UI-control properties or from {@link ViewModel.ApplicationDataModel} properties.
     * {@link ViewModel} properties are bound to UI-control internal propeties bi-directionally.
     * https://hsto.org/files/3c7/764/ed8/3c7764ed889e4bde850c6871d7b4db7b.png
     * https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93viewmodel#/media/File:MVVMPattern.png
     */
    @DesignPattern.Architectural
    @Inherited
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.METHOD})
    @GUIArchitectures
    @interface ModelViewViewModel {

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
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.FIELD})
            @Related.Patterns(PEAA.DomainModel.class)
            @interface ApplicationDataModel {
            }
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.FIELD})
            @PresentationModel
            @interface UIStateModel {
            }
        }

    }

    /**
     * See <a href="https://martinfowler.com/bliki/ReportingDatabase.html">ReportingDatabase</a>
     */
    @DesignPattern.Architectural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @interface ReportingDatabase {
    }

}
