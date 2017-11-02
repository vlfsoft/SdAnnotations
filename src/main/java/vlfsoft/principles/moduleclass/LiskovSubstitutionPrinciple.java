package vlfsoft.principles.moduleclass;

import vlfsoft.principles.ProgrammingPrinciple;
import vlfsoft.tags.SOLIDTag;

import java.lang.annotation.*;

/**
 * See <a href="https://en.wikipedia.org/wiki/Liskov_substitution_principle">Liskov substitution principle</a>
 * Substitutability is a principle in object-oriented programming stating that, in a computer program,
 * if S is a subtype of T, then objects of type T may be replaced with objects of type S (i.e. an object of type T may be substituted with any object of a subtype S)
 * without altering any of the desirable properties of T (correctness, task performed, etc.).
 * See <a href="http://java-design-patterns.com/principles/#liskov-substitution-principle">Liskov Substitution Principle</a>
 */
@SOLIDTag
@ProgrammingPrinciple.ModuleClass
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
public @interface LiskovSubstitutionPrinciple {
}
