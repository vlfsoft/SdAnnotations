package vlfsoft.common.annotations.design.principles;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 */
@SoftwareDesign
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface ObjectClassifier {

    /**
     * See <a href="https://en.wikipedia.org/wiki/Business_object">Business object</a>
     */
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.FIELD})
    @interface BO {
    }

    /**
     * See <a href="https://en.wikipedia.org/wiki/Value_object">Value object</a>
     * small object that represents a simple entity whose equality is not based on identity:
     * i.e. two value objects are equal when they have the same value, not necessarily being the same object.
     * See <a href="https://dzone.com/articles/value-objects">Value Objects</a>
     */
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.FIELD})
    @interface VO {
    }

    /**
     * See <a href="https://en.wikipedia.org/wiki/Data_access_object">Data access object</a>
     */
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.FIELD})
    @interface DAO {
    }

    /**
     * See <a href="https://en.wikipedia.org/wiki/Data_transfer_object">Data transfer object</a>
     * A data transfer object (DTO[1][2]) is an object that carries data between processes.
     * The motivation for its use is that communication between processes is usually done resorting to remote interfaces (e.g. web services),
     * where each call is an expensive operation.[2] Because the majority of the cost of each call is related to the round-trip time between
     * the client and the server, one way of reducing the number of calls is to use an object (the DTO) that aggregates the data
     * that would have been transferred by the several calls, but that is served by one call only.[2]
     */
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.FIELD})
    @interface DTO {
    }

    /**
     * See <a href="https://en.wikipedia.org/wiki/Immutable_object">Immutable object</a>
     * object whose state cannot be modified after it is created.
     * In some cases, an object is considered immutable even if some internally used attributes change but the object's state appears to be unchanging from an external point of view.
     * For example, an object that uses memoization to cache the results of expensive computations could still be considered an immutable object.
     */
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.FIELD})
    @interface ImmutableObject {
    }

    /**
     * See <a href="https://en.wikipedia.org/wiki/Immutable_object">Immutable object</a>
     * (changeable object), which can be modified after it is created
     */
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.FIELD})
    @interface MutableObject {
    }

}
