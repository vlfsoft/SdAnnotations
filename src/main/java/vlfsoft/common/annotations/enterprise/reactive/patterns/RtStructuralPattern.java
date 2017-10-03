package vlfsoft.common.annotations.enterprise.reactive.patterns;

import vlfsoft.common.annotations.design.DesignPattern;
import vlfsoft.common.annotations.design.patterns.StructuralPattern;
import vlfsoft.common.annotations.design.principles.ObjectClassifier;

import java.lang.annotation.*;

@DesignPattern.Structural
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({})
public @interface RtStructuralPattern {

    /**
     * DTO that contains reactive event state. It is used to transfer data between reactive stream operators.
     */
    @DesignPattern.Structural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE})
    @DesignPattern.ETC
    @ObjectClassifier.DTO
    @interface EventDTO {

        @DesignPattern.Structural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE})
        @DesignPattern.ETC
        @ObjectClassifier.ImmutableObject
        @interface Immutable {
        }

        /**
         * Every reactive stream operator can amend state of {@link EventDTO.Mutable} in order to save results of its work.
         * Thus, results of work done by one operator can be transferred to another one without creating new instance of {@link EventDTO}.
         * One instance of {@link EventDTO.Mutable} can be used instead of creating several instances of {@link EventDTO.Immutable}.
         */
        @DesignPattern.Structural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE})
        @DesignPattern.ETC
        @ObjectClassifier.MutableObject
        @interface Mutable {
        }

        /**
         * Wraps several objects to be handled inside reactive stream operators, into single {@link EventDTO},
         * since reactive stream operators can accept only one object as a parameter.
         */
        @DesignPattern.Structural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE})
        @DesignPattern.ETC
        @StructuralPattern.Adapter
        @interface ObjectAdapter {
        }
    }

}
