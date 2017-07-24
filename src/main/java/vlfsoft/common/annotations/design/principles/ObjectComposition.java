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
 */
@SoftwareDesign
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
public @interface ObjectComposition {

    /**
     * Composition is a kind of association where the composite object has sole responsibility for the disposition of the component parts.
     * The relationship between the composite and the component is a strong “has a” relationship, as the composite object takes ownership of the component.
     */
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
    @interface Composition {
    }

    /**
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

}
