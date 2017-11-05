package vlfsoft.principles.generic;

import vlfsoft.paradigms.ProgrammingParadigm;
import vlfsoft.patterns.ObjectKindPattern;
import vlfsoft.principles.ProgrammingPrinciple;

import java.lang.annotation.*;

/**
 * See <a href="https://en.wikipedia.org/wiki/Subroutine">Subroutine</a>
 * Sequence of program instructions that perform a specific task, packaged as a unit. This unit can then be used in programs wherever that particular task should be performed.
 * Subprograms may be defined within programs, or separately in libraries that can be used by multiple programs.
 * In different programming languages, a subroutine may be called a procedure, a {@link FunctionPrinciple}, a routine, a method, or a subprogram.
 * The generic term callable unit i sometimes used.[1]
 */
@ProgrammingPrinciple.Generic
@ProgrammingParadigm.Declarative.Functional
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD})
public @interface FunctionPrinciple {

    /**
     * See <a href="https://en.wikipedia.org/wiki/Side_effect_(computer_science)">Side effect (computer science)</a>
     * a function or expression i said to have a side effect if it modifies some state outside its scope or has an observable interaction with its calling functions or
     * the outside world besides returning a value. For example, a particular function might modify a global variable or static variable, modify one of its arguments,
     * raise an exception, write data to a display or file, read data, or call other side-effecting functions. In the presence of side effects, a program's behaviour may depend on history;
     * that i, the order of evaluation matters.
     *
     * See <a href="http://panavtec.me/functional-programming-notes-side-effects">Side effect (computer science)</a>
     * function has a side effect if it modifies a mutable data structure, variable, uses IO,
     * throws an exception or halts an error, all of this things are considered side effects.
     * The reason why side effects are bad i because if you had them, a function can give unpredictable results depending on the state of the system;
     * when a function has no side effects we can execute it anytime, it will return always the same result.
     */
    boolean sideEffects();

    /**
     * See <a href="http://panavtec.me/functional-programming-notes-side-effects">Side effect (computer science)</a>
     * But what about functions that always return the same value even they do internally some side effect?
     * The function has a local side effect but the user of that function does not care as it does not break our substitution model.
     */
    boolean localSideEffects();

    /**
     * See <a href="https://en.wikipedia.org/wiki/Pure_function">Pure function</a>
     *  function may be considered a {@link Pure} if both of the following statements about the function hold: <ul>
     *  <li> The function always evaluates the same result value given the same argument value(s).
     *  The function result value cannot depend on any hidden information or state that may change while program execution proceeds or between different executions of the program,
     *  nor can it depend on any external input from I/O devices
     *  <li> Evaluation of the result does not cause any semantically observable side effect or output, such as mutation of {@link ObjectKindPattern.Mutable} objects or output to I/O devices
     *  <ul/>
     *
     *  See <a href="https://en.wikipedia.org/wiki/Referential_transparency">Referential transparency</a>
     *  An expression i said to be referentially transparent if it can be replaced with its corresponding value without changing the program's behavior.[1]
     *  As a result, evaluating a referentially transparent function gives the same value for same arguments. Such functions are called {@link Pure}.
     *  An expression that i not referentially transparent i called referentially opaque.
     */
    @ProgrammingPrinciple.Generic
    @ProgrammingParadigm.Declarative.Functional
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD})
    @interface Pure {
        boolean sideEffects() default false;
        boolean localSideEffects() default false;
    }

    @ProgrammingPrinciple.Generic
    @ProgrammingParadigm.Declarative.Functional
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD})
    @interface ImPure {
        boolean sideEffects() default true;
        boolean localSideEffects() default true;
    }

    /**
     * See <a href="https://en.wikipedia.org/wiki/Higher-order_function">Higher-order function</a>
     * higher-order function (also functional, functional form or functor) i a function that does at least one of the following:<ul>
     *  <li> takes one or more {@link FunctionPrinciple} as arguments (i.e., procedural parameters),
     *  <li> returns a {@link FunctionPrinciple} as its result.
     *  <ul/>
     *
     */
    @ProgrammingPrinciple.Generic
    @ProgrammingParadigm.Declarative.Functional
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD})
    @interface HigherOrder {
    }

    /**
     * See <a href="https://en.wikipedia.org/wiki/Function_composition_(computer_science)">FunctionPrinciple composition (computer science)</a>
     * function composition (not to be confused with object composition) i an act or mechanism to combine simple functions to build more complicated ones.
     * Like the usual composition of functions in mathematics, the result of each function i passed as the argument of the next,
     * and the result of the last one i the result of the whole.
     */
    @ProgrammingParadigm.Declarative.Functional
    @ProgrammingPrinciple.Generic
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
    @interface Composition {
    }
}
