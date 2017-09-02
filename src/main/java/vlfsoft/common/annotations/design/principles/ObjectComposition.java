package vlfsoft.common.annotations.design.principles;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * See <a href="https://en.wikipedia.org/wiki/Object_composition">Object composition</a>
 * See <a href="https://https://en.wikipedia.org/wiki/Composition_over_inheritance">Composition over inheritance</a>
 * See <a href="http://stackoverflow.com/questions/9071067/design-patterns-composite-vs-composition">Design patterns: Composite vs. Composition</a>
 * is a way to combine simple objects or data types into more complex ones.
 */
@SoftwareDesign
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
public @interface ObjectComposition {

    /**
     * See <a href="https://en.wikipedia.org/wiki/Object_composition">Object composition</a>
     * Composition is a kind of association where the composite object has sole responsibility for the disposition of the component parts.
     * The relationship between the composite and the component is a strong “has a” relationship, as the composite object takes ownership of the component.
     */
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
    @interface Composition {

        /**
         * See <a href="https://en.wikipedia.org/wiki/Containment_(computer_programming)">Containment (computer programming)</a>
         * Composition that is used to store several instances of the composited data type is referred to as containment.
         * Examples of such containers are arrays, associative arrays, binary trees, and linked lists.
         */
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
        @interface Containment {
        }

    }

    /**
     * See <a href="https://en.wikipedia.org/wiki/Object_composition">Object composition</a>
     * Aggregation differs from ordinary composition in that it does not imply ownership.
     * In composition, when the owning object is destroyed, so are the contained objects. In aggregation, this is not necessarily true.
     * See <a href="https://dzone.com/articles/aggregate-pattern">Aggregate Pattern</a>
     * Aggregation is a kind of association that specifies a whole/part relationship between the aggregate (whole) and component part.
     * This relationship between the aggregate and component is a weak “has a” relationship, as the component may survive the aggregate object.
     */
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
    @interface Aggregation {
    }


    /**
     * See <a href="https://en.wikipedia.org/wiki/Composition_over_inheritance">Composition over inheritance</a>
     * Composition over inheritance (or composite reuse principle) in object-oriented programming (OOP) is the principle that classes should achieve polymorphic behavior and
     * code reuse by their composition (by containing instances of other classes that implement the desired functionality) rather than inheritance from a base or parent class.
     */
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
    @interface Composition_over_inheritance {
    }

}
