package vlfsoft.principles.generic;

import vlfsoft.paradigms.ProgrammingParadigm;
import vlfsoft.tags.ReactiveManifestoTag;

import java.lang.annotation.*;

@ReactiveManifestoTag
@ProgrammingParadigm.Declarative.DataFlow.Reactive
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface MessageDrivenPrinciple {
}
