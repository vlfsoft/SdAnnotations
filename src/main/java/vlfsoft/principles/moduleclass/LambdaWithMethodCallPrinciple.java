package vlfsoft.principles.moduleclass;

import vlfsoft.paradigms.ProgrammingParadigm;
import vlfsoft.principles.ProgrammingPrinciple;

import java.lang.annotation.*;

/**
 * Every lambda (f.e. that is passed to Stream operators) should be implemented as a method.
 * As a rule, the lambda then can be replaced with method reference.
 * Advantages:
 * More simple debugging.
 * More simple unit testing.
 * More simple stacktrace analysis.
 * More readable code.
 */
@ProgrammingPrinciple.ModuleClass
@ProgrammingParadigm.Declarative.Functional
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.METHOD})
public @interface LambdaWithMethodCallPrinciple {
}
