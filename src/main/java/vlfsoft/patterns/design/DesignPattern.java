package vlfsoft.patterns.design;

import vlfsoft.patterns.enterprise.peaa.PEAA;

import java.lang.annotation.*;

/**
 * See <a href="https://en.wikipedia.org/wiki/Software_design_pattern">Software design pattern</a>
 * a software design pattern is a general reusable solution to a commonly occurring problem within a given context in software design.
 * It is not a finished design that can be transformed directly into source or machine code.
 * It is a description or template for how to solve a problem that can be used in many different situations.
 * Design patterns are formalized best practices that the programmer can use to solve common problems when designing an application or system.
 * <p>
 * Christopher Alexander, A Pattern Language, 1977
 * Each pattern describes a problem which occurs over and over again in our environment, and then describes the core of the solution to that problem,
 * in such a way that you can use this solution a million times over, without ever doing it the same way twice
 */
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.ANNOTATION_TYPE, ElementType.FIELD, ElementType.METHOD})
public @interface DesignPattern {

    /**
     * @return list of other names, that this pattern also as known is.
     */
    @Language.Form
    String[] aka() default {};

    /**
     * This is an identifier for the pattern that indicates what the pattern does. ...
     * It is used only inside doc comments likewise: {@link DesignPattern#Name}: ...
     */
    @Language.Form
    String Name() default "";

    /**
     * Many patterns are associated with an icon in addition to the pattern name.
     * Because many architects are used to communicating visually by using diagrams, we wanted to provide a visual language in addition to the verbal language.
     * It is used only inside doc comments likewise: {@link DesignPattern#Icon}: <img src="url">
     */
    @Language.Form
    String Icon() default "";

    /**
     * It is used only inside doc comments likewise: {@link DesignPattern#Context}: ...
     * This explains what you might be working on that would make you likely to run into the problem that this pattern solves.
     * The context sets the stage for the problem and often refers to other patterns you may have already applied.
     */
    @Language.Form
    String Context() default "";

    /**
     * This explains the difficulty you are facing, expressed as a question you’re asking yourself, which this pattern solves.
     * You should be able to read the problem statement and quickly determine if this pattern is relevant to your work.
     * It is used only inside doc comments likewise: {@link DesignPattern#Problem}: ...
     * <p>
     * {@link PEAA}: The next section describes a motivating problem for the pattern. This may not be the only problem that the pattern solves, but it's one that I think best motivates the pattern.
     */
    @Language.Form
    String Problem() default "";

    /**
     * It is used only inside doc comments likewise: {@link DesignPattern#Forces}: ...
     * The forces explore the constraints that make the problem difficult to solve.
     * If it were easy, you wouldn’t need a pattern. They often consider alternative solutions that seem promising but don’t pan out, which helps show the value of the real solution.
     */
    @Language.Form
    String Forces() default "";

    /**
     * This is a template that explains what you should do to solve the problem.
     * It is not specific to your particular circumstances, but describes what to do in the variety of circumstances represented by the problem.
     * If you understand a pattern’s problem and solution, you understand the pattern and don’t necessarily need to read the other sections.
     * It is used only inside doc comments likewise: {@link DesignPattern#Solution}: ...
     * <p>
     * {@link PEAA}: How It Works describes the solution. In here I put a discussion of implementation issues {@link #Sidebars and variations that I've come across.
     * The discussion is as independent as possible of any particular platform—where there are platform-specific sections I've indented them so you can see them and easily skip over them.
     * Where useful I've
     * put in UML diagrams to help explain them.
     */
    @Language.Form
    @DesignPattern(aka = "How It Works")
    String Solution() default "";

    /**
     * It describes when the pattern should be used. Here I talk about the trade-offs that make you select
     * this solution compared to others. Many of the patterns in this book are alternatives; such Page Controller (333)
     * and Front Controller (344). Few patterns are always the right choice, so whenever I find a pattern I always ask
     * myself, "When would I not use this?" That question often leads me to alternative patterns
     */
    @Language.Form
    String WhenToUse() default "";

    /**
     * {@link PEAA}:
     * Next are two items that go together: the {@link #Intent} and the {@link #Sketch}. The {@link #Intent} sums up the pattern in a sentence or
     * two; the {@link #Sketch} is a visual representation of the pattern, often but not always a UML diagram. The idea is to
     * create a brief reminder of what the pattern is about so you can quickly recall it. If you already "have the
     * pattern," meaning that you know the solution even if you don't know the name, then the intent and the sketch
     * should be all you need to know what the pattern is.
     */
    @Language.Form
    String Intent() default "";

    /**
     * It is used only inside doc comments likewise: {@link DesignPattern#Sketch}: ...
     * One of the most appealing properties of the Alexandrian form is that each pattern contains a sketch that illustrates the solution.
     * In many cases, just by looking at the pattern name and the sketch you can understand the essence of the pattern.
     * We tried to maintain this style by inserting a solution picture, or sketch, after the solution statement of each pattern.
     */
    @Language.Form
    String Sketch() default "";

    /**
     * It is used only inside doc comments likewise: {@link DesignPattern#Consequences}: ...
     * This part expands upon the solution to explain the details of how to apply the solution and how it resolves the forces.
     * It also addresses new challenges that may arise as a result of applying this pattern.
     */
    @Language.Form
    @DesignPattern(aka = "Results")
    String Consequences() default "";

    /**
     * It is used only inside doc comments likewise: {@link DesignPattern#Next}: ...
     * This section lists other patterns to be considered after applying the current one.
     * Patterns don’t live in isolation; the application of one pattern usually leads you to new problems that are solved by other patterns.
     * This is what makes the collection a pattern language and not just a pattern catalog.
     *
     * {@link PEAA}: The Further Reading section points you to other discussions of this pattern
     */
    @Language.Form
    @DesignPattern(aka = " Further Reading")
    String Next() default "";

    /**
     * It is used only inside doc comments likewise: {@link DesignPattern#Sidebars}: ...
     * These sections discuss more detailed technical issues or variations of the pattern.
     * We set these sections visually apart from the remainder of the text so you can easily skip them if they are not be relevant to your particular application of the pattern.
     */
    @Language.Form
    String Sidebars() default "";

    /**
     * A pattern usually includes one or more examples of the pattern being applied or having been applied.
     * It is used only inside doc comments likewise: {@link DesignPattern#ExamplesSimple}:
     */
    @Language.Form
    String ExamplesSimple() default "";

    @Language.Form
    String ExamplesFromRealWorld() default "";

    /**
     * See <a href="http://www.enterpriseintegrationpatterns.com/patterns/messaging/Introduction.html">Messaging Patterns Introduction</a>
     * This book is structured as a set of patterns organized into a pattern language. Books such as Design Patterns, Pattern Oriented Software Architecture, Core J2EE Patterns, and Patterns of Enterprise Application Architecture have popularized the concept of using patterns to document computer-programming techniques. Christopher Alexander pioneered the concept of patterns and pattern languages in his books A Pattern Language and A Timeless Way of Building.
     */
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @DesignPattern(aka = "Pattern Structure")
    @interface Language {
        /**
         * See Pattern Form in <a href="http://www.enterpriseintegrationpatterns.com/patterns/messaging/Introduction.html">Messaging Patterns Introduction</a>
         */
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.METHOD})
        @DesignPattern(aka = "Pattern Structure")
        @interface Form {
        }
    }

    /**
     * {@link vlfsoft.tags.DDDEvansTag}: Chapter Eleven. Applying Analysis Patterns
     *
     * {@link vlfsoft.tags.MFowlerTag}: Analysis patterns are groups of concepts that represent a common construction in business modeling.
     * It may be relevant to only one domain or it may span many domains.
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @interface Analysis {
    }

    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @interface Architectural {
    }

    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @interface Concurrency {
    }

    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @interface Testing {
    }

    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @interface Other {
    }

}

