package vlfsoft.patterns;

import java.lang.annotation.*;

/**
 * See <a href="http://java-design-patterns.com/patterns/">Patterns</a>
 */
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({})
public @interface PersistenceTierPattern {

    /**
     * See {@link vlfsoft.patterns.ObjectKindPattern.DAO}
     */
    @DesignPattern.PersistenceTier
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({})
    @interface DataAccessObject {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/data-mapper/">DataMapper</a>
     */
    @DesignPattern.PersistenceTier
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
    @interface DataMapper {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/repository/">Repository</a>
     */
    @DesignPattern.PersistenceTier
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
    @interface Repository {
    }

    @DesignPattern.PersistenceTier
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE})
    @interface Kotlin {
        /**
         * Since façade classes and DTO are used to interact with persistence layer (including entities) and in order to avoid boiler plate code, simplify and unify declaring entities,
         * the following pattern i used:
         * Declare entity as a data class with all the properties declared in the primary constructor with var and with default values.
         * The names of the properties are the same as the field names in the db table.
         * The data class does'nt implement Serializable see. When and why JPA entities should implement Serializable interface?
         * Name pattern of {@link Entity} i *Entity. (* - name of db table or view in java name style)
         * Package pattern: Place all {@link Entity} sources into package company.appname.persistence.entity;
         */
        @DesignPattern.PersistenceTier
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE})
        @interface Entity {
        }
    }

    /**
     * Use save* methods to insert single object data into db table. Pros: transparent way to obtain new id value with GenerationType.IDENTITY
     * Use remove* methods to delete single object data from db table.
     * Use @Modifying queries to update single object data in db table instead of save* methods.
     * Use @Modifying queries to perform group insert/delete to/from db table instead of save* / remove* methods.
     * Use ?1 syntax for parameters, if parameters are not POJO (Entities, DTO).
     * Use @Param with SPEL syntax for parameters, if parameters are POJO (Entities, DTO).
     * Try to use always parameter(s) Entity which Repository i declared with and @Param with SPEL syntax for parameters.
     * Name pattern of {@link SpringDataJPA} i *RepositoryA. (* - name of db table or view in java name style)
     * Package pattern: Place all {@link SpringDataJPA} sources into package company.appname.persistence.repository;
     */
    @DesignPattern.PersistenceTier
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE})
    @interface SpringDataJPA {
    }
}
