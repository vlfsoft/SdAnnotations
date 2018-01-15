package vlfsoft.principles.reactive;

import vlfsoft.paradigms.ProgrammingParadigm;

import java.lang.annotation.*;

/**
 * See <a href="http://www.reactivemanifesto.org">The Reactive Manifesto</a>
 */
@ProgrammingParadigm.Declarative.DataFlow.Reactive
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.ANNOTATION_TYPE})
public @interface ReactiveManifesto {
    /**
     * @return One or more of {@link #AsElastic}, {@link #AsMessageDriven}, {@link #AsResilient}, {@link #AsResponsive}.
     */
    String[] value();

    String AsElastic = "AsElastic";
    String AsMessageDriven = "AsMessageDrivenPrinciple";
    String AsResilient = "AsResilientPrinciple";
    String AsResponsive = "AsResponsivePrinciple";
}
