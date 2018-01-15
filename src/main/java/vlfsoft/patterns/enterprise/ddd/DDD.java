package vlfsoft.patterns.enterprise.ddd;

import vlfsoft.contracts.Contract;
import vlfsoft.paradigms.ProgrammingParadigm;
import vlfsoft.patterns.GOF;
import vlfsoft.patterns.Pattern;
import vlfsoft.patterns.VLFP;
import vlfsoft.patterns.design.DesignPattern;
import vlfsoft.patterns.enterprise.architecture.HexagonalArchitecture;
import vlfsoft.patterns.enterprise.jee.JEE;
import vlfsoft.patterns.enterprise.peaa.PEAA;
import vlfsoft.principles.ProgrammingPrinciple;
import vlfsoft.principles.generic.FunctionPrinciple;
import vlfsoft.principles.intermoduleclass.MinimiseCouplingPrinciple;
import vlfsoft.principles.moduleclass.MaximiseCohesionPrinciple;
import vlfsoft.tags.DDDEvansTag;
import vlfsoft.tags.DDDSampleTag;
import vlfsoft.tags.NoteTag;
import vlfsoft.tags.Related;

import java.lang.annotation.*;

import static vlfsoft.patterns.enterprise.peaa.PEAA.DTO;

/**
 */
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({})
@Related.Patterns(VLFP.BusinessRule.class)
public @interface DDD {

    /**
     * See <a href="https://martinfowler.com/bliki/UbiquitousLanguage.html">Ubiquitous language</a>
     * Ubiquitous Language is the term Eric Evans uses in Domain Driven Design for the practice of building up a common, rigorous language between developers and users.
     * This language should be based on the {@link PEAA.DomainModel} used in the software - hence the need for it to be rigorous, since software doesn't cope well with ambiguity.
     * <p>
     * {@link DDDEvansTag}: The vital detail about the design is captured in the code. A well-written implementation should be transparent, revealing the model underlying it.
     * Supplemental diagrams and documents can guide people's attention to the central points. Natural language discussion can fill in the nuances of meaning.
     * This is why I prefer to turn things inside out from the way a typical UML diagram handles them. Rather than a diagram annotated with text, I write a text document illustrated with selective
     * and simplified diagrams.
     * <p>
     * {@link DDDEvansTag}: Always remember that the model is not the diagram. The diagram's purpose is to help communicate and explain the model.
     * The code can serve as a repository of the details of the design. Well-written Java is as expressive as UML in its way.
     * But code as a design document does have its limits. It can over-whelm the reader with detail. A document shouldn't try to do what the code already does well. The code already supplies the
     * detail. It is an exact specification of program behavior. Other documents need to illuminate meaning, to give insight into large-scale structures,
     * and to focus attention on core elements.
     * Tightly relating the code to an underlying model gives the code meaning and makes the model relevant.
     * {@link DDDEvansTag}: Projects that have no {@link PEAA.DomainModel} at all, but just write code to fulfill one function after another,
     * gain few of the advantages of knowledge crunching and communication discussed in the previous two chapters. A complex domain will swamp them.
     * {@link DDDEvansTag}: If the design, or some central part of it, does not map to the {@link PEAA.DomainModel}, that model is of little value, and the correctness of the software is suspect.
     * At the same time, complex mappings between models and design functions are difficult to understand and, in practice, impossible to maintain as the design changes.
     * A deadly divide opens between analysis and design so that insight gained in each of those activities does not feed into the other.
     * <p>
     * {@link DDDSampleTag}: Listen to the language the domain experts use. Are there terms that succinctly state something complicated? Are they correcting your word choice (perhaps
     * diplomatically)? Do the puzzled looks on their faces go away when you use a particular phrase? These are hints of a concept that might benefit the model.
     * <p>
     * {@link DDDEvansTag}: Software design is a constant battle with complexity. We must make distinctions so that special handling is applied only where necessary.
     * {@link DDDEvansTag}: Whatever the dominant model {@link ProgrammingParadigm} may be on a project, there are bound to be parts of the domain that would be much easier to express in some other {@link ProgrammingParadigm}s.
     */
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({})
    @interface UbiquitousLanguage {
    }

    /**
     * {@link DDDEvansTag}: The {@link PEAA.DomainModel} is a set of concepts. The {@link DomainLayer} is the manifestation of that model and
     * all directly related design elements. The design and implementation of business logic {@link PEAA.Patterns.Layer.Domain.Logic} constitute the {@link DomainLayer}.
     * In a {@link ModelDrivenDesign}, the software constructs of the {@link DomainLayer} mirror the model concepts.
     */
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({})
    @Related.Patterns(PEAA.DomainModel.class)
    @interface ModelDrivenDesign {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/specification/">Specification</a>
     * {@link DDDEvansTag}: Create explicit predicate-like VALUE OBJECTS for specialized purposes. A SPECIFICATION is a predicate that determines if an object does or does not satisfy some criteria.
     */
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({})
    @Related.Patterns(PEAA.DomainModel.class)
    @interface Specification {
    }

    /**
     * See <a href="https://en.wikipedia.org/wiki/Immutable_object">Immutable object</a>
     * object whose state cannot be modified after it is created.
     * In some cases, an object is considered immutable even if some internally used attributes change but the object's state appears to be unchanging from an external point of view.
     * For example, an object that uses memoization to cache the results of expensive computations could still be considered an Immutable object.
     */

    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({})
    @interface Immutable {
    }

    /**
     * See <a href="https://en.wikipedia.org/wiki/Immutable_object">Immutable object</a>
     * (changeable object), which can be modified after it is created
     */

    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({})
    @interface Mutable {
    }


    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @interface Stateful {
    }


    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @interface Stateless {
    }

    /**
     * See <a href="https://en.wikipedia.org/wiki/Plain_old_Java_object">Plain old Java object</a>
     * {@link POJO} - ordinary Java object, not bound by any special restriction and not requiring any class path.
     */

    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.FIELD})
    @interface POJO {
    }


    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({})
    @Related.Patterns(DomainObject.class)
    @POJO
    @interface BusinessObject {
    }

    /**
     * See <a href="https://en.wikipedia.org/wiki/Business_object">Business object</a>
     * A business object is an {@link Entity} within a multi-tiered software application that works in conjunction with the data access and business logic layers to transport data.
     * Aliases: {@link BusinessObject}, {@link Entity} object.
     * See <a href="https://dzone.com/articles/stateful-or-stateless-classes">Object-Oriented Design Decisions: Stateful or Stateless Classes?</a>
     * There are multiple names such as {@link Entity} classes, {@link BusinessObject}s etc...given to classes which represent a clear state of something.
     * If we take the example of an Employee class, its sole purpose is to hold the state of an employee.
     * What might that state contain? EmpId, Company, Designation, JoinedDate etc...
     * I hope there will be no confusions at this point. Everybody agrees that this type of class should be {@link Stateful} without much arguments because this is taught in college.
     */

    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Related.Patterns(BusinessObject.class)
    @Stateful
    @interface DomainObject {
    }

    /**
     * {@link DDDEvansTag}: Some objects are not defined primarily by their attributes. They represent a thread of identity that runs through time and often across distinct representations.
     * Sometimes such an object must be matched with another object even {@link NoteTag} though attributes differ. An object must be distinguished from other objects even though they might have the same attributes.
     * Mistaken identity can lead to data corruption.
     * Domain-Driven Design Distilled:
     * An {@link Entity} models an individual thing. Each {@link Entity} has a unique identity {@link Id} in that you can distinguish its individuality from among all other Entities of the same or a different type.
     * Many times, perhaps even most times, an {@link Entity} will be {@link Mutable}; that is, it state will change over time. Still, an {@link Entity} is not of necessity {@link Mutable} and may be {@link Immutable}.
     * The main thing that separates an {@link Mutable} from other modeling tools is its uniqueness - its individuality.
     * <p>
     * See <a href="https://medium.com/@yauritux/ddd-part-ii-b0735ba584ca">DDD Part II. DDD Building Blocks</a>
     * Entities (or “entity” in singular form) is a plain object that has an identity (ID) and potentially mutable. Each entity is uniquely identified by an ID rather than by an attribute,
     * therefore two entities can be considered as equal (identifier equality) if both of them have the same ID, even though they have different attributes.
     * This means the state of the entity can be changed anytime, but as long as two entities have the same ID, both are considered as equal regardless what attributes they have.
     */

    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE})
    @Related.Patterns({PEAA.DTO.class})
    @DomainObject
    @interface Entity {
        Class[] value() default Mutable.class;

        /**
         * {@link DDDEvansTag}: Each ENTITY must have an operational way of establishing its identity with another object—distinguishable even from another object with the same descriptive attributes.
         * An identifying attribute must be guaranteed to be unique within the system however that system is defined—even if distributed, even when objects are archived.
         * <p>
         * Use {@link DDD.Entity.Id} instead of {@link PEAA.IdentityField}.
         */
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.ANNOTATION_TYPE, ElementType.FIELD})
        @interface Id {
        }
    }

    /**
     * {@link DDDEvansTag}: An object that represents a descriptive aspect of the domain with no conceptual identity is called a {@link ValueObject}.
     * {@link ValueObject}s are instantiated to represent elements of the design that we care about only for what they are, not who or which they are.
     * <p>
     * Domain-Driven Design Distilled:
     * A Value Object, simply Value, models an immutable conceptual whole. Within model the Value os just that, a value.
     * Unlike Entity, it does not have a unique identity, and equivalence is determined by comparing the attributes encapsulated by the value type.
     * Furthermore, a Value Object is not a thing but is often used to describe, quantify, or measure and Entity.
     * <p>
     * See <a href="http://java-design-patterns.com/patterns/value-object/">ValueObject</a>
     * See <a href="https://en.wikipedia.org/wiki/Value_object">Value object</a>
     * small object that represents a simple entity whose equality is not based on identity:
     * i.e. two value objects are equal when they have the same value, not necessarily being the same object.
     * Usually, we also make/treat the value objects as {@link Immutable}, i.e. instead of changing the value objects, we create new instances that wrap the new values:
     * <p>
     * See <a href="https://dzone.com/articles/value-objects">Value Objects</a>
     * The Value Objects pattern does just that – it transforms our values into objects.
     * Everything boils down to wrapping the standard ddd inside our own, named by the concept their representing:
     * <p>
     * In Kotlin:
     * data classes in Kotlin implement {@link ValueObject} in very concise manner
     * <p>
     * data class PersonId (val value: Long)
     * data class FirstName (val value: String)
     * <p>
     * The Value Objects pattern transforms values in our projects into real objects, giving us more type safety, hiding implementation, and giving a home to all related logic.
     * That being said, we should always evaluate if the mentioned benefits outweigh the drawbacks of creating extra classes, which, in Java,
     * implies extra source files and a rapidly growing size of the project.
     * To implement a value object, we simply wrap a value into an immutable class with an equals/hashcode pair that compares the objects by values.
     * <p>
     * See <a href="https://medium.com/@yauritux/ddd-part-ii-b0735ba584ca">DDD Part II. DDD Building Blocks</a>
     * Value Objects are immutable. They have no identity (ID) like we found in Entity.
     * Two value objects can be considered as equal if both of them have the same type and the same attributes (applied to all of its attributes).
     * They are often uses for a thing like message passing and in fact they are particularly useful in the API layer within an Onion Architecture
     * {@link DDDEvansTag}:  Further control side effects by moving complex logic into {@link ValueObject}s when a concept fitting the responsibility presents itself.
     */

    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.FIELD})
    @DomainObject
    @FunctionPrinciple.Pure
    @interface ValueObject {
        Class[] value() default Immutable.class;

        /**
         * {@link ValueObject} can contain one property {@link SingleProperty}.
         * Hint: Use "value" as a name for this property. data class PersonId (val value: Long)
         * In kotlin it's possible to use also typealias PersonId = Long for {@link SingleProperty}
         */
        @Retention(RetentionPolicy.SOURCE)
        @Target({})
        @interface SingleProperty {
        }

        /**
         * {@link ValueObject} can contain more than one property {@link MultiProperties}.
         */
        @Retention(RetentionPolicy.SOURCE)
        @Target({})
        @interface MultiProperties {
        }

        /**
         * Rule of thumb: Use {@link OptionalProperty}, if there is a clear need to represent "no result" (Java, Kotlin) or null is likely to cause errors (Java).
         * {@link OptionalProperty} should be used just as a return value from a function.
         */
        @Retention(RetentionPolicy.SOURCE)
        @Target({})
        @interface OptionalProperty {
        }

    }

    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.METHOD})
    @Entity
    @Related.Patterns({Contract.class, Factory.class})
    @interface Invariant {
        String value() default "";
    }

    /**
     * {@link DDDEvansTag}:  An {@link Aggregate} is a cluster of associated objects that we treat as a unit for the purpose of data changes.
     * Each {@link Aggregate} has a {@link Root} and a {@link Boundary}. The {@link Boundary} defines what is inside the {@link Aggregate}.
     * The {@link Root} is a single, specific {@link Entity} contained in the {@link Aggregate}. The {@link Root} is the only member of the {@link Aggregate} that outside objects are allowed to hold references to,
     * although objects within the {@link Boundary} may hold references to each other. {@link Entity}s other than the {@link Root} have local {@link Entity.Id},
     * but that {@link Entity.Id} needs to be distinguishable only within the {@link Aggregate}, because no outside object can ever see it out of the context of the {@link Root} {@link Entity}.
     * <p>
     * Domain-Driven Design Distilled:
     * Each {@link Aggregate} is composed of one or more {@link Entity}s, where one {@link Entity} is called the {@link Aggregate.Root}. {@link Aggregate}s may have {@link ValueObject}s composed on them.
     * Aggregate Rules of Thumb:
     * 1. Protect business {@link Invariant}s inside Aggregate boundaries.
     * 2. Design small Aggregates
     * 3. Reference other Aggregates by identity only.
     * 4. Update othewr Aggregates using eventual consistency
     * <p>
     * See <a href="https://martinfowler.com/bliki/DDD_Aggregate.html">DDD_Aggregate</a>
     * A DDD {@link Aggregate} is a cluster of {@link DomainObject}s that can be treated as a single unit.
     * An example may be an order and its line-items, these will be separate objects, but it's useful to treat the order (together with its line items) as a single {@link Aggregate}.
     * An {@link Aggregate} will have one of its component objects be the aggregate {@link Root}. Any references from outside the {@link Aggregate} should only go to the {@link Aggregate.Root}.
     * The {@link Root} can thus ensure the integrity of the {@link Aggregate} as a whole.
     * <p>
     * <p>
     * See <a href="https://dzone.com/articles/aggregate-pattern">Aggregate Pattern</a>
     * Although some try to identify {@link Aggregate}s by looking for matching domain concepts, the pattern’s real purpose is to help you ensure transactional consistency between your {@link Entity}s.
     * We’re doing this by deeming one of the {@link Entity}s responsible for ensuring the consistency and performing persistence operations just on this {@link Entity}.
     * We call such entity an {@link Aggregate.Root}. Any other {@link Entity}s that are “ensured” consistent have to be saved in a single transaction by saving the {@link Aggregate.Root} itself.
     * There’s a good rule for working with {@link Aggregate}s that says that we should not update more than one {@link Aggregate} per transaction.
     * Keep The Aggregates Small
     * Taking the concepts above even further, if we only want to update one aggregate per transaction and we strive to keep the aggregates small, one could employ the practice of referencing other aggregates only by ID.
     * <p>
     * See <a href="https://medium.com/@yauritux/ddd-part-ii-b0735ba584ca">DDD Part II. DDD Building Blocks</a>
     * Aggregate root is an entity that binds together with other entities. Moreover, aggregate root is actually a part of aggregate (collection/cluster of associated objects that treated as a single unit for the purpose of data changes).
     * Thus, each aggregate actually consists of an aggregate root and a boundary. For example, the relationship between Order and OrderLineItem within SalesOrder domain can be considered as an aggregate where Order acts as the aggregate Root,
     * while the OrderLineItem is the child of Order within SalesOrder boundary.
     */

    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE})
    @Entity
    @interface Aggregate {

        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE})
        @Entity
        @interface Root {
        }

        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE})
        @Entity
        @interface Boundary {
        }

    }

    /**
     * Domain-Driven Design Distilled:
     * ?
     * <p>
     * {@link DDDSampleTag}: See <a href="http://dddsample.sourceforge.net/characterization.html">Domain Event</a>
     * Some things clearly have identity but no life-cycle, or an extremely limited life-cycle with just one state. We call these things Domain Events and they can be viewed as hybrid of {@link Entity}s and {@link ValueObject}s.
     * In the sample application HandlingEvent is a Domain Event that represent a real-life event such as a Cargo being loaded or unloaded, customs cleared etc.
     * They carry both a completion time and a registration time. The completion time is the time when the event occurred and the registration time is the time when the event was received by the system.
     * The HandlingEvent id is composed of the cargo, voyage, completion time, location and type (LOAD, UNLOAD etc).
     */

    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE})
    @Stateful
    @Entity
    @ValueObject(DTO.class)
    @interface DomainEvent {
    }

    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.METHOD})
    @Stateless
    @interface DomainOperation {
    }

    /**
     * {@link DDDEvansTag}: In some cases, the clearest and most pragmatic design includes {@link DomainOperation}s that do not conceptually belong to any {@link DomainObject}.
     * Rather than force the issue, we can follow the natural contours of the problem space and include {@link Service}s explicitly in the model.
     * {@link DDDEvansTag}: There are important {@link DomainOperation}s that can't find a natural home in an {@link Entity} or {@link ValueObject}.
     * Some of these are {@link NoteTag} intrinsically activities or actions, not things, but since our modeling paradigm is objects, we try to {@link NoteTag} fit them into objects anyway.
     * {@link DDDEvansTag}: Sometimes {@link Service}s masquerade as model objects, appearing as objects with no meaning beyond doing some operation. These "doers" end up with names ending in "Manager" and the like.
     * They have no state of their own nor any meaning in the domain beyond the operation they host. Still, at least this solution gives these distinct behaviors a home without messing up a real model object.
     * {@link DDDEvansTag}: Some concepts from the domain aren't natural to model as objects. Forcing the required domain functionality to be the responsibility of an {@link Entity} or {@link ValueObject} either distorts
     * the definition of a model-based object or adds meaningless artificial objects.
     * {@link DDDEvansTag}: A {@link Service} is an operation offered as an interface that stands alone in the model, without encapsulating state, as {@link Entity} and {@link ValueObject}s do.
     * {@link Service}s are a common pattern in technical frameworks, but they can also apply in the {@link DomainLayer}.
     * {@link DDDEvansTag}: A good SERVICE has three characteristics.
     * 1. The operation relates to a domain concept that is not a natural part of an {@link Entity} or {@link ValueObject}.
     * 2. The interface is defined in terms of other elements of the {@link PEAA.DomainModel}.
     * 3. The operation is {@link Stateless}.
     * {@link DDDEvansTag}: When a significant process or transformation in the domain is not a natural responsibility of an {@link Entity} or {@link ValueObject},
     * add an operation to the model as a standalone interface declared as a {@link Service}. Define the interface in terms of the language of the model and make sure the operation name is part of the UBIQUITOUS LANGUAGE.
     * Make the {@link Service} {@link Stateless}.
     * {@link DDDEvansTag}: It can be harder to distinguish {@link ApplicationService}s from {@link DomainService}s.
     * {@link DDDEvansTag}: Partitioning {@link Service}d into {@link Layer}s.
     * ...
     * <p>
     * See <a href="https://medium.com/@yauritux/ddd-part-ii-b0735ba584ca">DDD Part II. DDD Building Blocks</a>
     * A service is basically exist to provide a home for operations that don’t quite fit into an aggregate root.
     * As an example, when you have an operation that you don’t know on which aggregate root it goes into,
     * perhaps it operates on multiple aggregate roots or maybe it doesn’t belong to any existing aggregate root, then you can put the logic into a service.
     * However, don’t be rush to put everything into a service. First and foremost, its better to carefully analyze whether the operation fits into one of the existing aggregate root or not.
     * If you couldn’t find the aggregate root, subsequently better to ask your self in case you have missed one aggregate root or perhaps there are domain concepts that you haven’t considered that should be brought into your domain before you put the operation into a service.
     */

    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE})
    @Stateless
    @interface Service {
    }

    /**
     * {@link DDDSampleTag}: See <a href="http://dddsample.sourceforge.net/characterization.html">Domain services</a>
     * {@link DomainService}s are expressed in terms of the ubiquitous language and the domain ddd, i.e. the method arguments and the return values are proper domain classes.
     * Sometimes, only the {@link Service} interface (what the {@link Service} does) is part of the {@link DomainLayer},
     * but the implementation (how the {@link Service} does it) is part of the {@link InfrastructureLayer}.
     * This is analogous to how {@link Repository} interfaces are part of the {@link DomainLayer}, but the Hibernate implementations are not.
     * <p>
     * A good example of that is the <a href="http://dddsample.sourceforge.net/xref/se/citerus/dddsample/domain/service/RoutingService.html">RoutingService</a>,
     * which provides access to the routing system and is used to find possible routes for a give specification.
     * The implementation communicates with another team's context and translates to and from an external API and data model.
     *
     * On the other hand, if the {@link Service} is possible to implement strictly using the {@link DomainLayer}, both the interface and the implementation could be part of the {@link DomainLayer}.
     *
     */
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE})
    @Stateless
    @Service
    @interface DomainService {
    }

    /**
     * {@link DDDSampleTag}: See <a href="http://dddsample.sourceforge.net/characterization.html">Application services</a>
     * The {@link ApplicationService}s in the sample application are responsible for driving workflow and coordinating transaction management (by use of the declarative transaction management support in Spring).
     * They also provide a high-level abstraction for clients to use when interacting with the domain. These services are typically designed to define or support specific use cases.
     * See <a href="http://dddsample.sourceforge.net/xref/se/citerus/dddsample/application/impl/BookingServiceImpl.html">BookingService</a>
     * or <a href="http://dddsample.sourceforge.net/xref/se/citerus/dddsample/application/impl/HandlingEventServiceImpl.html">HandlingEventService</a>.
     * {@link DDDSampleTag}: In some situations, e.g. when dealing with graphs of lazy-loaded {@link DomainObject}s or when passing services' return values over network boundaries, the services are wrapped in {@link GOF.Facade}s.
     * The {@link GOF.Facade}s handle ORM session management issues and/or convert the {@link DomainObject}s to more portable {@link PEAA.DTO}) that can be tailored to specific use cases.
     * In that case, we consider the {@link PEAA.DTO}-serializing s part of the {@link InterfacesLayer}. See <a href="http://dddsample.sourceforge.net/xref/se/citerus/dddsample/interfaces/booking/facade/internal/BookingServiceFacadeImpl.html">BookingServiceFacade</a> for an example.
     * <p>
     * Domain-Driven Design Distilled:
     * Application services, Input Adapters, Output Adapters.
     * <p>
     * See <a href="https://dzone.com/articles/stateful-or-stateless-classes">Object-Oriented Design Decisions: Stateful or Stateless Classes?</a>
     * The class implements set of operations on {@link DDD.DomainObject}.
     * Aliases: Helper class, Manipulator class, Service class.
     */
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE})
    @Stateless
    @Service
    @interface ApplicationService {
    }

    /**
     * How to distinguish {@link ApplicationService}s and {@link InfrastructureService}s ?
     * {@link VLFP.SpringSpecific.SpringDataJPA} is {@link InfrastructureService}, {@link VLFP.DatabaseMapper} is {@link ApplicationService} ?
     * {@link DDDEvansTag}:
     */
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE})
    @Stateless
    @Service
    @interface InfrastructureService {
    }

    /**
     * The class combines traits both {@link DDD.DomainObject} and {@link ApplicationService}.
     * Whenever there is a feel that a class is falling into this {@link Hybrid} category, time to think about refactoring.
     * This is a pseudo-annotation, since Target({}) will not allow to apply it. Use combination of {@link DDD.DomainObject} and {@link ApplicationService} instead.
     */
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({})
    @interface Hybrid {
    }

    /**
     * {@link DDDEvansTag}: It is a truism that there should be low coupling between {@link Module}s and high cohesion within them.
     * {@link DDDEvansTag}: Use packaging to separate the domain layer from other code.
     * Otherwise, leave as much freedom as possible to the domain developers to package the domain objects in ways that support their model and design choices.
     */
    @DesignPattern(aka = "Package")
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({})
    @interface Module {
    }

    /**
     * {@link DDDSampleTag}: See <a href="http://dddsample.sourceforge.net/architecture.html">Architecture</a>
     * {@link DDDSampleTag}: See <a href="http://dddsample.sourceforge.net/images/layers.jpg">The sample application is layered as illustrated by this picture:</a>
     * See <a href="http://java-design-patterns.com/patterns/layers/">Layers</a>
     * See <a href="https://en.wikipedia.org/wiki/Layer_(object-oriented_design)">Layer (object-oriented_design)</a>
     */
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Related.Patterns({JEE.Patterns.Core.PresentationTier.class,
            JEE.Patterns.Core.BusinessTier.class,
            JEE.Patterns.Core.IntegrationTier.class,
            PEAA.ServiceLayer.class})
    @interface Layer {
    }

    /**
     * {@link DDDEvansTag}: Responsible for showing information to the user and interpreting the user's commands. The external actor might sometimes be another computer system rather than a human user.
     * {@link DDDSampleTag}: See <a href="http://dddsample.sourceforge.net/architecture.html">Architecture</a>
     * This layer holds everything that interacts with other systems, such as web services, RMI interfaces or web applications, and batch processing frontends.
     * It handles interpretation, validation and translation of incoming data. It also handles serialization of outgoing data, such as HTML or XML across HTTP to web browsers or web service clients,
     * or {@link DTO} classes and distributed facade interfaces for remote Java clients.
     */
    @DesignPattern(aka = "Presentation Layer")
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE})
    @Layer
    @interface InterfacesLayer {
    }

    /**
     * {@link DDDEvansTag}: Defines the jobs the software is supposed to do and directs the expressive {@link DomainObject}s to work out problems.
     * The tasks this layer is responsible for are meaningful to the business or necessary for interaction with the application layers of other systems.
     * {@link DDDSampleTag}: See <a href="http://dddsample.sourceforge.net/architecture.html">Architecture</a>
     * The application layer is responsible for driving the workflow of the application, matching the use cases at hand.
     * These operations are interface-independent and can be both synchronous or message-driven. This layer is well suited for spanning transactions, high-level logging and security.
     * The application layer is thin in terms of domain logic - it merely coordinates the domain layer objects to perform the actual work.
     */
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE})
    @Layer
    @PEAA.ServiceLayer
    @interface ApplicationLayer {
    }

    /**
     * {@link DDDEvansTag}: Responsible for representing concepts of the business, information about the business situation, and {@link VLFP.BusinessRule}s.
     * State that reflects the business situation is controlled and used here, even though the technical details of storing it are delegated to the infrastructure.
     * This layer is the heart of business software.
     * {@link DDDEvansTag}: Concentrate all the code related to the {@link PEAA.DomainModel} in one layer and {@link NoteTag} isolate it from the user interface, application, and
     * infrastructure code. The {@link DomainObject}s, free of the responsibility of displaying themselves, storing themselves, managing application tasks, and so forth, can be
     * focused on expressing the {@link PEAA.DomainModel}. This allows a model to evolve to be rich enough and clear enough to capture essential business knowledge and put it to work
     * <p>
     * {@link DDDSampleTag}: See <a href="http://dddsample.sourceforge.net/architecture.html">Architecture</a>
     * The {@link DomainLayer} is the heart of the software, and this is where the interesting stuff happens. There is one package per aggregate, and to each aggregate belongs entities, value objects, domain events, a repository interface and sometimes factories. The aggregate roots are Cargo, HandlingEvent, Location and Voyage.
     * The core of the business logic, such as determining whether a handling event should be registered and how the delivery of a cargo is affected by handling, belongs in here.
     * The structure and naming of aggregates, classes and methods in the domain layer should follow the ubiquitous language, and you should be able
     * to explain to a domain expert how this part of the software works by drawing a few simple diagrams and using the actual class and method names of the source code.
     * <p>
     * {@link NoteTag}: that the {@link DomainLayer}, not the {@link ApplicationLayer}, is responsible for fundamental {@link VLFP.BusinessRule}s—in this case, the rule is "Every credit has a matching debit."
     */
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE})
    @Layer
    @interface DomainLayer {
    }

    /**
     * {@link DDDEvansTag}: Provides generic technical capabilities that support the higher layers: message sending for the application, persistence for the domain, drawing widgets for the UI, and so on.
     * The {@link InfrastructureLayer} may also support the pattern of interactions between the four layers through an architectural framework.
     * {@link DDDSampleTag}: See <a href="http://dddsample.sourceforge.net/architecture.html">Architecture</a>
     * In addition to the three vertical layers, there is also the infrastructure.
     * As the the picture shows, it supports all of the three layers in different ways, facilitating communication between the layers.
     * In simple terms, the infrastructure consists of everything that exists independently of our application: external libraries, database engine, application server, messaging backend and so on.
     * <p>
     * Also, we consider code and configuration files that glues the other layers to the infrastructure as part of the infrastructure layer.
     * Looking for example at the persistence aspect, the database schema definition, Hibernate configuration and mapping files and implementations of the repository interfaces
     * are part of the infrastructure layer.
     * <p>
     * While it can be tricky to give a solid definition of what kind of code belongs to the infrastructure layer for any given situation,
     * it should be possible to completely stub out the infrastructure in pure Java unit/scenario tests and still be able to use the domain layer and possibly the application layer
     * to work out the core business problems.
     */
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE})
    @Layer
    @Related.Patterns(DatabaseAbstractionLayer.class)
    @interface InfrastructureLayer {
    }

    /**
     * See <a href="https://en.wikipedia.org/wiki/Database_abstraction_layer">Database abstraction layer</a>
     * Use {@link InfrastructureLayer} instead of this annotation.
     */
    @DesignPattern.Architectural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({})
    @InfrastructureLayer
    @interface DatabaseAbstractionLayer {
    }

    /**
     * {@link DDDSampleTag}: See <a href="http://dddsample.sourceforge.net/characterization.html">Repositories</a>
     * With the {@link Aggregate}s and their {@link Aggregate.Root}s defined its fairly trivial to define the {@link Repository}s.
     * The {@link Repository}s work on {@link Aggregate.Root}s and in the sample application there is one {@link Repository} per {@link Aggregate.Root},
     * the <a href="http://dddsample.sourceforge.net/xref/se/citerus/dddsample/domain/model/cargo/CargoRepository.html">CargoRepository</a> is responsible for {@link NoteTag}: finding and storing Cargo aggregates.
     * The finders return Cargo instances or lists of Cargo instances.
     * {@link NoteTag}: The {@link DDD.Repository} interfaces are part of the {@link DomainLayer}, their implementations are part of the {@link InfrastructureLayer}.
     * {@link DDDEvansTag}: For each type of object that needs global access, create an object that can provide the illusion of an in-memory collection of all objects of that type.
     * Set up access through a well-known global interface. Provide methods to add and remove objects, which will encapsulate the actual insertion or removal of data in the data store.
     * Provide methods that select objects based on some criteria and return fully instantiated objects or collections of objects whose attribute values meet the criteria, thereby encapsulating the actual storage and query technology.
     * Provide REPOSITORIES only for AGGREGATE roots that actually need direct access. Keep the client focused on the model, delegating all object storage and access to the REPOSITORIES.
     * <p>
     * E.g. <a href="http://dddsample.sourceforge.net/xref/se/citerus/dddsample/domain/model/cargo/CargoRepository.html">CargoRepository</a> has an Hibernate implementation in the infrastructure layer: CargoRepositoryHibernate.
     * <p>
     * See <a href="https://medium.com/@yauritux/ddd-part-ii-b0735ba584ca">DDD Part II. DDD Building Blocks</a>
     * {@link Repository}s are mostly used to deal with the storage.
     * They are actually one of the most important concepts on the DDD because they have abstracted away a lot of the storage concerns (i.e. some form / mechanism of storage).
     * The {@link Repository} implementation could be a {@link NoteTag}: file-based storage, or {@link NoteTag}: database (SQL / NoSQL based), or any other thing that is related with {@link NoteTag}: storage mechanism such as {@link NoteTag}: caching.
     * Any {@link NoteTag}: combination of those are also possible.
     * {@link Repository} should not be confused with the data store. A repository job is to store {@link Aggregate.Root}s.
     * Underneath that, {@link Repository}s implementation may actually have to talk to {@link NoteTag}: multiple different storage locations in order to construct the {@link Aggregate}s.
     * Thus, a single {@link Aggregate.Root} might be drawn from a REST API, as well as a database or files.
     * You may wrap those in something called the data store, but the {@link Repository} is sort of a further layer of an abstraction on top of all those individual data stores.
     * Usually, i implement the {@link DDD.Repository} as an interface within the {@link DomainLayer}/{@link DomainService}s within Onion Architecture (skip for now, gonna talk about this “Onion” later),
     * and then the implementation logic of the {@link DDD.Repository} interface is going to be defined in the {@link InfrastructureLayer}.
     */
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE})
    @GOF.Singleton
    @DDD.Stateless
    @GOF.Factory
    @PEAA.Gateway
    @PEAA.DataMapper
    @interface Repository {
    }

    /**
     * {@link DDDEvansTag}: But object creation and assembly usually have no meaning in the domain; they are a necessity of the implementation. To solve this problem, we have to add constructs to the domain design that are
     * {@link NoteTag}: not {@link Entity}s, {@link ValueObject}s, or {@link Service}s.
     * {@link DDDEvansTag}: Shift the responsibility for creating instances of complex objects and AGGREGATES to a separate object, which may itself have no responsibility in the domain model but is still
     * part of the domain design. Provide an interface that encapsulates all complex assembly and that does not require the client to reference the concrete classes of the objects being instantiated.
     * Create entire AGGREGATES as a piece, enforcing their {@link Invariant}s.
     * {@link DDDEvansTag}: A FACTORY is very tightly coupled to its product, so a FACTORY should be attached only to an object that has a {@link NoteTag} close natural relationship with the product.
     * <p>
     * See <a href="https://medium.com/@yauritux/ddd-part-ii-b0735ba584ca">DDD Part II. DDD Building Blocks</a>
     * The factories are used to give an abstraction to the object construction (see {@link GOF.Factory}).
     * A {@link Factory} can also potentially return an aggregate root or an entity or perhaps a value object.
     * Often times, when you need a {@link GOF.Factory.FactoryMethod} for an {@link Aggregate.Root}, it will be rolled in to the {@link Repository}.
     * So your {@link Repository} might have a finder create method on it.
     * Usually {@link Factory} also implemented as an interface within the {@link DomainLayer}/{@link DomainService}s with the implementation logic defined in the {@link InfrastructureLayer}.
     */
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({})
    @Stateless
    @Related.Patterns({GOF.Factory.class, Invariant.class})
    @interface Factory {
    }

    /**
     * {@link DDDEvansTag}: There is no formula for designing software like this, but I have culled a set of patterns that, in my experience,
     * tend to lend suppleness to a design when they fit. These patterns and examples should give a feel for what a supple design is like and the kind of thinking that goes into it.
     */
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Stateless
    @interface SuppleDesign {
    }

    /**
     * {@link DDDEvansTag}: Name classes and operations to describe their effect and purpose, without reference to the means by which they do what they promise.
     * This relieves the client developer of the need to understand the internals. These names should conform to the {@link UbiquitousLanguage} so that team members can quickly infer their meaning.
     * Write a test for a behavior before creating it, to force your thinking into client developer mode.
     * <p>
     * If a developer must consider the implementation of a component in order to use it, the value of encapsulation is lost. If someone other than the original developer must infer
     * the purpose of an object or operation based on its implementation, that new developer may infer a purpose that the operation or class fulfills only by chance.
     * If that was not the intent, the code may work for the moment, but the conceptual basis of the design will have been corrupted, and the two developers will be working at cross-purposes.
     */
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.METHOD})
    @Stateless
    @FunctionPrinciple.Pure
    @SuppleDesign
    @interface IntentionRevealingInterface {
    }

    /**
     * {@link DDDEvansTag}: Operations that return results without producing side effects are called functions.
     * A function can be called multiple times and return the same value each time. A function can call on other functions without worrying about the depth of nesting.
     * Functions are much easier to test than operations that have side effects. For these reasons, functions lower risk.
     * {@link DDDEvansTag}: Place as much of the logic of the program as possible into functions, operations that return results with no observable side effects.
     * {@link DDDEvansTag}: SIDE-EFFECT-FREE {@link Function}s, especially in {@link Immutable} {@link ValueObject}s, allow safe combination of operations.
     * When a {@link Function} is presented through an INTENTION-REVEALING INTERFACE, a developer can use it without understanding the detail of its implementation.
     */
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.METHOD})
    @Stateless
    @FunctionPrinciple.Pure
    @SuppleDesign
    @interface Function {
    }

    /**
     * {@link DDDEvansTag}: State post-conditions of operations and invariants of classes and AGGREGATES.
     * If ASSERTIONS cannot be coded directly in your programming language, write automated unit tests for them. Write them into documentation or diagrams where it fits the style
     * of the project's development process.
     * <p>
     * When the side effects of operations are only defined implicitly by their implementation, designs with a lot of delegation become a tangle of cause and effect.
     * The only way to understand a program is to trace execution through branching paths. The value of encapsulation is lost. The necessity of tracing concrete execution defeats abstraction.
     */
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.METHOD})
    @Stateless
    @FunctionPrinciple.Pure
    @SuppleDesign
    @interface Assertion {
    }

    /**
     * {@link DDDEvansTag}: Decompose design elements (operations, interfaces, classes, and AGGREGATES) into cohesive units,
     * taking into consideration your intuition of the important divisions in the domain. Observe the axes of change and stability through successive refactorings and look for the underlying CONCEPTUAL CONTOURS that explain these shearing patterns.
     * Align the model with the consistent aspects of the domain that make it a viable area of knowledge in the first place.
     */
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.METHOD})
    @Stateless
    @FunctionPrinciple.Pure
    @SuppleDesign
    @Related.Principles({MaximiseCohesionPrinciple.class, MinimiseCouplingPrinciple.class})
    @interface ConceptualContour {
    }

    /**
     * {@link DDDEvansTag}: Low coupling is fundamental to object design. When you can, go all the way. Eliminate all other concepts from the picture.
     * Then the class will be completely self-contained and can be studied and understood alone. Every such self-contained class significantly eases the burden of understanding a MODULE.
     * Try to factor the most intricate computations into STANDALONE CLASSES, perhaps by modeling VALUE OBJECTS held by the more connected classes.
     * <p>
     * Low coupling is a basic way to reduce conceptual overload. A STANDALONE CLASS is an extreme of low coupling.
     */
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE})
    @Stateless
    @FunctionPrinciple.Pure
    @SuppleDesign
    @interface StandaloneClass {
    }

    /**
     * {@link DDDEvansTag}:
     * Most interesting objects end up doing things that can't be characterized by primitives alone.
     * Where it fits, define an operation whose return type is the same as the type of its argument(s).
     * If the implementer has state that is used in the computation, then the implementer is effectively an argument of the operation, so the argument(s) and return value should be of the same type as the implementer.
     * Such an operation is closed under the set of instances of that type. A closed operation provides a high-level interface without introducing any dependency on other concepts.
     * !!! This pattern is most often applied to the operations of a VALUE OBJECT.
     */
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE})
    @Stateless
    @FunctionPrinciple.Pure
    @SuppleDesign
    @interface ClosureOfOperations {
    }

    /**
     * {@link DDDEvansTag}: These are some of the motivations behind declarative design. This term means many things to many people, but usually it indicates a way to write a program,
     * or some part of a program, as a kind of executable specification. A very precise description of properties actually controls the software.
     */
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE})
    @Stateless
    @FunctionPrinciple.Pure
    @SuppleDesign
    @interface DeclarativeDesign {
    }

    /**
     * {@link DDDEvansTag}:  In this style, client code is written in a programming language tailored to a particular model of a particular domain.
     *
     */
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE})
    @Stateless
    @FunctionPrinciple.Pure
    @SuppleDesign
    @Related.Patterns(Pattern.FluentInterface.class)
    @interface DSL {
    }

    /**
     * It is used as {@link PEAA.DTO}
     * The Tuple generic classes below are intended to simplify applying {@link ProgrammingParadigm.Declarative.Functional}
     * (see. {@link PEAA.DTO}), when even data classes are too cumbersome.
     * In order to make {@link Tuple} more readable, try to declare {@link Tuple} generic classes with {@link DDD.ValueObject} instead of standard ddd.
     */
    @ProgrammingParadigm.Declarative.Functional
    @ProgrammingPrinciple.ModuleClass
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE})
    @DDD.ValueObject({PEAA.DTO.class, PEAA.DTO.InStream.class})
    @interface Tuple {
    }

}
