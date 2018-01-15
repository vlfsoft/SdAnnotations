package vlfsoft.principles.intermoduleclass;

import vlfsoft.principles.ProgrammingPrinciple;

import java.lang.annotation.*;

/**
 * See <a href="https://en.wikipedia.org/wiki/Inversion_of_control">Inversion of Control</a>
 * custom-written portions of a computer program receive the flow of control from a generic framework.
 * A software architecture with this design inverts control as compared to traditional procedural programming: in traditional programming,
 * the custom code that expresses the purpose of the program calls into reusable libraries to take care of generic tasks, but with inversion of control,
 * it is the framework that calls into the custom, or task-specific, code.
 * See <a href="http://java-design-patterns.com/principles/#inversion-of-control">Inversion of Control</a>
 */
@ProgrammingPrinciple.InterModule
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.ANNOTATION_TYPE})
public @interface InversionOfControlPrinciple {
    boolean value();
}
