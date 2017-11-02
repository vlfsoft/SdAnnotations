package vlfsoft.paradigms;

import vlfsoft.tags.ReactiveManifestoTag;

import java.lang.annotation.*;

/**
 * See <a href="https://en.wikipedia.org/wiki/Programming_paradigm">Programming paradigm</a>
 * Way to classify programming languages based on their features. Languages can be classified into multiple paradigms.
 * Common programming paradigms include: <ul>
 * <li> imperative which allows side effects {@link Imperative},
 * <li> functional which disallows side effects {@link Declarative.Functional},
 * <li> declarative which does not state the order in which operations execute {@link Declarative},
 * <li> object-oriented which groups code together with the state the code modifies {@link Structured.ObjectOriented},
 * <li> procedural which groups code into functions {@link Imperative.Procedural},
 * <li> logic which has a particular style of execution model coupled to a particular style of syntax and grammar {@link Declarative.Logic}, and
 * <li> symbolic programming which has a particular style of syntax and grammar {@link Symbolic}.
 * </ul>
 */
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.ANNOTATION_TYPE})
public @interface ProgrammingParadigm {

    /**
     * See <a href="https://en.wikipedia.org/wiki/Declarative_programming">Declarative programming</a>
     * {@link ProgrammingParadigm} - a style of building the structure and elements of computer programs—that expresses the logic of a computation without describing its control flow.[1].
     */
    @ProgrammingParadigm
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
    @interface Declarative {

        /**
         * See <a href="https://en.wikipedia.org/wiki/Dataflow_programming">Dataflow programming</a>
         * {@link ProgrammingParadigm} that models a program as a directed graph of the data flowing between operations, thus implementing dataflow principles and architecture.
         *
         */
        @ProgrammingParadigm
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.ANNOTATION_TYPE})
        @interface DataFlow {
            /**
             * See <a href="https://en.wikipedia.org/wiki/Dataflow_programming">Flow-based programming</a>
             * FBP - Flow-based programming
             * {@link ProgrammingParadigm} that defines applications as networks of "black box" processes, which exchange data across predefined connections by message passing,
             * where the connections are specified externally to the processes. These black box processes can be reconnected endlessly to form different applications without having to be changed internally.
             * FBP is thus naturally component-oriented.
             *
             */
            @ProgrammingParadigm
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
            @interface FlowBased {
            }

            /**
             * See <a href="https://en.wikipedia.org/wiki/Reactive_programming">Reactive programming</a>
             * See <a href="http://www.reactivemanifesto.org">The Reactive Manifesto</a>
             * Asynchronous {@link ProgrammingParadigm}  concerned with data streams and the propagation of change.
             * This means that it becomes possible to express static (e.g. arrays) or dynamic (e.g. event emitters) data streams with ease via the employed programming language(s),
             * and that an inferred dependency within the associated execution model exists, which facilitates the automatic propagation of the change involved with data flow.
             */
            @ProgrammingParadigm
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
            @interface Reactive {

            }

        }

        /**
         * See <a href="https://en.wikipedia.org/wiki/Functional_programming">Functional programming</a>
         * {@link ProgrammingParadigm} - a style of building the structure and elements of computer programs—that treats computation as the evaluation of mathematical functions
         * and avoids changing-state and mutable data. It is a declarative programming paradigm, which means programming is done with expressions[1] or declarations[2] instead of statements.
         */
        @ProgrammingParadigm
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
        @interface Functional {
        }

        /**
         * See <a href="https://en.wikipedia.org/wiki/Logic_programming">Logic programming</a>
         * {@link ProgrammingParadigm} - which is largely based on formal logic. Any program written in a logic programming language is a set of sentences in logical form,
         * expressing facts and rules about some problem domain.
         */
        @ProgrammingParadigm
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
        @interface Logic {
        }

    }

    /**
     * See <a href="https://en.wikipedia.org/wiki/Programming_paradigm">Programming paradigm</a>
     * {@link ProgrammingParadigm} that uses statements that change a program's state.
     */
    @ProgrammingParadigm
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
    @interface Imperative {
        /**
         * See <a href="https://en.wikipedia.org/wiki/Procedural_programming">Procedural programming</a>
         * {@link ProgrammingParadigm} - derived from structured programming, based upon the concept of the procedure call. Procedures, also known as routines, subroutines,
         * or functions (not to be confused with mathematical functions, but similar to those used in functional programming), simply contain a series of computational steps to be carried out.
         */
        @ProgrammingParadigm
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
        @interface Procedural {
        }
    }

    /**
     * See <a href="https://en.wikipedia.org/wiki/Structured_programming">Structured programming</a>
     * {@link ProgrammingParadigm} - aimed at improving the clarity, quality, and development time of a computer program by making extensive use of subroutines, block structures,
     * for and while loops—in contrast to using simple tests and jumps such as the go to statement, which could lead to "spaghetti code" that is difficult to follow and maintain.
     */
    @ProgrammingParadigm
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
    @interface Structured {

        /**
         * See <a href="https://en.wikipedia.org/wiki/Object-oriented_programming">Object-oriented programming</a>
         * {@link ProgrammingParadigm} - based on the concept of "objects", which may contain data, in the form of fields, often known as attributes; and code, in the form of procedures, often known as methods.
         */
        @ProgrammingParadigm
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
        @interface ObjectOriented {
        }

        /**
         * See <a href="https://en.wikipedia.org/wiki/Recursion_(computer_science)">Recursion (computer science)</a>
         */
        @ProgrammingParadigm
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
        @interface Recursion {

            /**
             * See <a href="https://en.wikipedia.org/wiki/Recursion_(computer_science)#Recursive_procedures">Recursive procedures</a>
             */
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.METHOD})
            @interface Procedure {
            }

        }

    }

    /**
     * See <a href="https://en.wikipedia.org/wiki/Symbolic_programming">Symbolic programming</a>
     * {@link ProgrammingParadigm} - in which the program can manipulate its own formulas and program components as if they were plain data.[1]
     * Through symbolic programming, complex processes can be developed that build other more intricate processes by combining smaller units of logic or functionality.
     */
    @ProgrammingParadigm
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
    @interface Symbolic {
    }

}
