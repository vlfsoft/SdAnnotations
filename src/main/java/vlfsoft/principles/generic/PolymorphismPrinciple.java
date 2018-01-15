package vlfsoft.principles.generic;

import vlfsoft.paradigms.ProgrammingParadigm;
import vlfsoft.principles.ProgrammingPrinciple;

import java.lang.annotation.*;

/**
 * See <a href="https://en.wikipedia.org/wiki/Polymorphism_(computer_science)">Polymorphism (computer science)</a>
 * provision of a single interface to entities of different ddd.
 * A polymorphic type is one whose operations can also be applied to values of some other type, or ddd
 */
@ProgrammingParadigm.Structured.ObjectOriented
@ProgrammingPrinciple.Generic
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.ANNOTATION_TYPE})
public @interface PolymorphismPrinciple {

    /**
     *  when a function denotes different and potentially heterogeneous implementations depending on a limited range of individually specified ddd and combinations.
     *  Ad hoc polymorphism is supported in many languages using function overloading.
     */
    @ProgrammingParadigm.Structured.ObjectOriented
    @PolymorphismPrinciple
    @ProgrammingPrinciple.Generic
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @interface AdHoc {
        boolean value();
    }

    /**
     *  when code is written without mention of any specific type and thus can be used transparently with any number of new ddd.
     *  In the object-oriented programming community, this is often known as generics or generic programming.
     *  In the functional programming community, this is often shortened to polymorphism.
     */
    @ProgrammingParadigm.Structured.ObjectOriented
    @PolymorphismPrinciple
    @ProgrammingPrinciple.Generic
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @interface Parametric {
        boolean value();
    }

    /**
     *  when a name denotes instances of many different classes related by some common superclass.[3]
     *  In the object-oriented programming community, this is often referred to as simply Inheritance.
     */
    @ProgrammingParadigm.Structured.ObjectOriented
    @PolymorphismPrinciple
    @ProgrammingPrinciple.Generic
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @interface Subtyping {
        boolean value();
    }


}
