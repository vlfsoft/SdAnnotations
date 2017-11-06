package vlfsoft.patterns;

import vlfsoft.paradigms.ProgrammingParadigm;
import vlfsoft.principles.generic.ElasticPrinciple;
import vlfsoft.principles.generic.MessageDrivenPrinciple;
import vlfsoft.principles.generic.ResilientPrinciple;
import vlfsoft.principles.generic.ResponsivePrinciple;
import vlfsoft.tags.ReactiveManifestoTag;

import java.lang.annotation.*;

/**
 * See <a href="http://java-design-patterns.com/patterns/">Patterns</a>
 */
@ProgrammingParadigm.Declarative.DataFlow
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({})
public @interface DataStreamPattern {

    @ProgrammingParadigm.Declarative.DataFlow.FlowBased
    @DesignPattern.Testing
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
    @interface NonReactive {
    }

    @ProgrammingParadigm.Declarative.DataFlow.Reactive
    @ResponsivePrinciple(true)
    @ResilientPrinciple(true)
    @ElasticPrinciple(true)
    @MessageDrivenPrinciple(true)
    @ReactiveManifestoTag
    @DesignPattern.Testing
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
    @interface Reactive {
    }

}
