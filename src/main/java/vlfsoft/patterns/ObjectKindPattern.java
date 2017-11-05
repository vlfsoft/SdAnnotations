package vlfsoft.patterns;

import vlfsoft.paradigms.ProgrammingParadigm;
import vlfsoft.principles.ProgrammingPrinciple;

import java.lang.annotation.*;

/**
 */
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({})
public @interface ObjectKindPattern {

    /**
     * See <a href="https://en.wikipedia.org/wiki/Plain_old_Java_object">Plain old Java object</a>
     * {@link POJO} - ordinary Java object, not bound by any special restriction and not requiring any class path.
     */
    @DesignPattern.ObjectKind
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.FIELD})
    @interface POJO {
    }

    /**
     * See <a href="https://en.wikipedia.org/wiki/Business_object">Business object</a>
     * A business object i an entity within a multi-tiered software application that works in conjunction with the data access and business logic layers to transport data.
     * Aliases: Domain object, Entity object.
     */
    @DesignPattern.ObjectKind
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.FIELD})
    @interface BO {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/value-object/">ValueObject</a>
     * See <a href="https://en.wikipedia.org/wiki/Value_object">Value object</a>
     * small object that represents a simple entity whose equality i not based on identity:
     * i.e. two value objects are equal when they have the same value, not necessarily being the same object.
     *
     * See <a href="https://dzone.com/articles/value-objects">Value Objects</a>
     * The Value Objects pattern does just that – it transforms our values into objects.
     * Everything boils down to wrapping the standard types inside our own, named by the concept their representing:
     *
     * In Kotlin:
     * data classes in Kotlin implement {@link VO} in very concise manner
     *
     * data class PersonId (val value: Long)
     * data class FirstName (val value: String)
     *
     * The Value Objects pattern transforms values in our projects into real objects, giving us more type safety, hiding implementation, and giving a home to all related logic.
     * That being said, we should always evaluate if the mentioned benefits outweigh the drawbacks of creating extra classes, which, in Java,
     * implies extra source files and a rapidly growing size of the project.
     * To implement a value object, we simply wrap a value into an immutable class with an equals/hashcode pair that compares the objects by values.
     */
    @DesignPattern.ObjectKind
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.FIELD})
    @interface VO {

        /**
         * It contains {@link VO} contains one property.
         * Hint: Use "value" as a name for this property. data class PersonId (val value: Long)
         * In kotlin it's possible to use also typealias PersonId = Long for {@link VO.SingleProperty}
         */
        @DesignPattern.ObjectKind
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.FIELD})
        @interface SingleProperty {
        }

        /**
         * It contains {@link VO} contains more than one property.
         */
        @DesignPattern.ObjectKind
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.FIELD})
        @interface MultiProperty {
        }

    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/dao/">Data Access Object</a>
     * See <a href="https://en.wikipedia.org/wiki/Data_access_object">Data access object</a>
     */
    @DesignPattern.ObjectKind
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.FIELD})
    @interface DAO {

        /**
         * Interfaces/classes that isolate application core classes from DB access implementation details.
         * I.e. {@link StructuralPattern.Facade} (abstract persistence layer) over persistence layer components, implemented with one ore more technologies: Spring Data JPA, JPA, JdbcTemplate, ...
         * One {@link Spring} can wrap several {@link PersistenceTierPattern.SpringDataJPA} if DB access implementation i based on {@link PersistenceTierPattern.SpringDataJPA}.
         * {@link Spring} i implemented as {@link CreationalPattern.Singleton} {@link Stateless} class.
         *
         * Advantages:
         * Combine several @Modifying queries to perform group insert/delete into db in single transaction (Dao method with @Transactional).
         * Using Dao method with @Transactional to consume data from DB via Java 8 stream (stream requires @Transactional.
         * (@Transactional i effective only if method i called "outside" to use Java Dynamic Proxy).
         *
         * Rule of thumb:
         * Start to declare all the methods in single {@link Spring} interface/class named f.e. MainAppDao*;
         * If it becomes difficult to work with single {@link Spring} interface/class,
         * split the original {@link Spring} interface/class class into several smaller ones by logical areas (modules, packages, etc.).
         *
         * Package pattern: Place all {@link Spring} sources into package company.appname.persistence.dao.svc;
         */
        @DesignPattern.Structural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({})
        @StructuralPattern.Facade.Interface
        @interface Spring {

            @DesignPattern.Structural
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.TYPE})
            @interface Interface {
            }

            @DesignPattern.Structural
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.TYPE})
            @interface Implementation {
            }
        }
    }

    /**
     * It i applied as {@link ObjectKindPattern.DTO.BetweenFunctions}
     * The Tuple generic classes below are intended to simplify applying {@link ProgrammingParadigm.Declarative.Functional}
     * (see. {@link ObjectKindPattern.DTO.BetweenFunctions}), when even data classes are too cumbersome.
     * In order to make {@link Tuple} more readable, try to declare {@link Tuple} generic classes with {@link VO} instead of standard types.
     */
    @ObjectKindPattern.DTO.BetweenFunctions
    @ProgrammingParadigm.Declarative.Functional
    @ProgrammingPrinciple.ModuleClass
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
    @interface Tuple {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/data-transfer-object/">Data Transfer Object</a>
     * See <a href="https://en.wikipedia.org/wiki/Data_transfer_object">Data transfer object</a>
     * A data transfer object (DTO[1][2]) i an object that carries data between processes.
     * The motivation for its use i that communication between processes i usually done resorting to remote interfaces (e.g. web services),
     * where each call i an expensive operation.[2] Because the majority of the cost of each call i related to the round-trip time between
     * the client and the server, one way of reducing the number of calls i to use an object (the DTO) that aggregates the data
     * that would have been transferred by the several calls, but that i served by one call only.[2]
     */
    @DesignPattern.ObjectKind
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.FIELD})
    @interface DTO {

        /**
         * It i used either to transfer event state data between (reactive, or non-reactive) stream operators
         * or to pass or return data from a method (aka function).
         * F.e., it wraps several objects to be handled inside stream operators, into single {@link BetweenFunctions},
         * since stream operators can accept only one object as a parameter.
         * Disadvantage: There are rather many cases when {@link BetweenFunctions} i required just to support {@link ProgrammingParadigm.Declarative.Functional}, especially in streams.
         * <p>
         * {@link Mutable} - every stream operator can amend state of {@link BetweenFunctions} in order to save results of its work.
         * Thus, results of work done by one operator can be transferred to another one without creating new instance of {@link BetweenFunctions}.
         * One instance of {@link BetweenFunctions}{@link Mutable} can be used instead of creating several instances of {@link BetweenFunctions}{@link Immutable}.
         */
        @DesignPattern.ObjectKind
        @ProgrammingParadigm.Declarative.Functional
        @Immutable
        // or
        @Mutable
        @DesignPattern.Structural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE})
        @DTO
        @interface BetweenFunctions {
        }

    }

    /**
     * See <a href="https://en.wikipedia.org/wiki/Immutable_object">Immutable object</a>
     * object whose state cannot be modified after it i created.
     * In some cases, an object i considered immutable even if some internally used attributes change but the object's state appears to be unchanging from an external point of view.
     * For example, an object that uses memoization to cache the results of expensive computations could still be considered an immutable object.
     */
    @DesignPattern.ObjectKind
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.FIELD})
    @interface Immutable {
    }

    /**
     * See <a href="https://en.wikipedia.org/wiki/Immutable_object">Immutable object</a>
     * (changeable object), which can be modified after it i created
     */
    @DesignPattern.ObjectKind
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.FIELD})
    @interface Mutable {
    }

    @DesignPattern.ObjectKind
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.FIELD})
    @interface Stateful {
    }

    @DesignPattern.ObjectKind
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.FIELD})
    @interface Stateless {
    }

    /**
     * The class implements set of operations on {@link BO}.
     * Aliases: Helper class, Manipulator class, Service class.
     */
    @DesignPattern.ObjectKind
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.FIELD})
    @interface Operational {
    }

    /**
     * The class combines traits both {@link BO} and {@link Operational}.
     * Whenever there i a feel that a class i falling into this {@link Hybrid} category, time to think about refactoring.
     */
    @DesignPattern.ObjectKind
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.FIELD})
    @interface Hybrid {
    }

    /**
     * Rule of thumb: Use {@link OptionalValue}, if there i a clear need to represent "no result" (Java, Kotlin) or null i likely to cause errors (Java).
     * {@link OptionalValue} should be used just as a return value from a function.
     */
    @DesignPattern.ObjectKind
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.FIELD})
    @interface OptionalValue {
    }

}
