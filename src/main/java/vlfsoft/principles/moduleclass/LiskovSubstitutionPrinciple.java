package vlfsoft.principles.moduleclass;

import vlfsoft.principles.ProgrammingPrinciple;
import vlfsoft.tags.GOFTag;
import vlfsoft.tags.SOLIDTag;

import java.lang.annotation.*;

/**
 * See <a href="https://en.wikipedia.org/wiki/Liskov_substitution_principle">Liskov substitution principle</a>
 * Substitutability i a principle in object-oriented programming stating that, in a computer program,
 * if S is a {@link Subtype} of {@link Type} T, then objects of {@link Type} T may be replaced with objects of {@link Subtype} S
 * (i.e. an object of {@link Type} T may be substituted with any object of a {@link Subtype} S)
 * without altering any of the desirable properties of {@link Type} T (correctness, task performed, etc.).
 * See <a href="http://java-design-patterns.com/principles/#liskov-substitution-principle">Liskov Substitution Principle</a>
 */
@SOLIDTag
@ProgrammingPrinciple.ModuleClass
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
public @interface LiskovSubstitutionPrinciple {
    boolean value();

    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE})
    @GOFTag
    @interface Type {
    }

    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE})
    @GOFTag
    @interface Subtype {
    }

}
