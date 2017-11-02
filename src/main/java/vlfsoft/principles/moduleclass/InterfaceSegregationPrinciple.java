package vlfsoft.principles.moduleclass;

import vlfsoft.principles.ProgrammingPrinciple;
import vlfsoft.tags.SOLIDTag;

import java.lang.annotation.*;

/**
 * See <a href="https://en.wikipedia.org/wiki/Interface_segregation_principle">Interface segregation principle</a>
 * The interface-segregation principle (ISP) states that no client should be forced to depend on methods it does not use.[1]
 * ISP splits interfaces that are very large into smaller and more specific ones so that clients will only have to know about the methods that are of interest to them.
 * Such shrunken interfaces are also called role interfaces.[2]
 * ISP is intended to keep a system decoupled and thus easier to refactor, change, and redeploy.
 * See <a href="http://java-design-patterns.com/principles/#interface-segregation-principle">Interface Segregation Principle</a>
 */
@SOLIDTag
@ProgrammingPrinciple.ModuleClass
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
public @interface InterfaceSegregationPrinciple {
}
