package vlfsoft.common.annotations.enterprise.persistence.patterns;

import vlfsoft.common.annotations.design.DesignPattern;

import java.lang.annotation.*;

@DesignPattern.Structural
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({})
public @interface PsStructuralPattern {

    /**
     * Since façade classes and DTO are used to interact with persistence layer (including entities) and in order to avoid boiler plate code, simplify and unify declaring entities,
     * the following pattern is used:
     * Declare entity as a data class with all the properties declared in the primary constructor with var and with default values.
     * The names of the properties are the same as the field names in the db table.
     * The data class doesn’t implement Serializable see. When and why JPA entities should implement Serializable interface?
     * Name pattern of {@link EntityInKotlin} is *Entity. (* - name of db table or view in java name style)
     * Package pattern: Place all {@link EntityInKotlin} sources into package company.appname.persistence.entity;
     */
    @DesignPattern.Structural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE})
    @DesignPattern.ETC
    @interface EntityInKotlin {
    }

    /**
     * Use save* methods to insert single object data into db table. Pros: transparent way to obtain new id value with GenerationType.IDENTITY
     * Use remove* methods to delete single object data from db table.
     * Use @Modifying queries to update single object data in db table instead of save* methods.
     * Use @Modifying queries to perform group insert/delete to/from db table instead of save* / remove* methods.
     * Use ?1 syntax for parameters, if parameters are not POJO (Entities, DTO).
     * Use @Param with SPEL syntax for parameters, if parameters are POJO (Entities, DTO).
     * Try to use always parameter(s) Entity which Repository is declared with and @Param with SPEL syntax for parameters.
     * Name pattern of {@link SpringDataJPA} is *RepositoryA. (* - name of db table or view in java name style)
     * Package pattern: Place all {@link SpringDataJPA} sources into package company.appname.persistence.repository;
     */
    @DesignPattern.Structural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE})
    @DesignPattern.ETC
    @interface SpringDataJPA {
    }

}
