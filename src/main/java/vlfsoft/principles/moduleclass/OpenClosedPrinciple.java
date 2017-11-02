package vlfsoft.principles.moduleclass;

import vlfsoft.principles.ProgrammingPrinciple;
import vlfsoft.tags.SOLIDTag;

import java.lang.annotation.*;

/**
 * See <a href="https://en.wikipedia.org/wiki/Open/closed_principle">Open/closed principle</a>
 * the open/closed principle states "software entities (classes, modules, functions, etc.) should be open for extension,
 * but closed for modification";[1] that is, such an entity can allow its behaviour to be extended without modifying its source code.
 * See <a href="http://java-design-patterns.com/principles/#liskov-substitution-principle">Open/Closed Principle</a>
 */
@SOLIDTag
@ProgrammingPrinciple.ModuleClass
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
public @interface OpenClosedPrinciple {
}
