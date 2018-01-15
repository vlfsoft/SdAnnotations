package vlfsoft.concepts;

import java.lang.annotation.*;

/**
 * See <a href="https://en.wikipedia.org/wiki/Syntactic_sugar">Syntactic sugar</a>
 * This is syntax within a programming language that is designed to make things easier to read or to express. It makes the language "sweeter" for human use: things can be expressed more clearly, more concisely, or in an alternative style that some may prefer.
 */
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.LOCAL_VARIABLE, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE_PARAMETER, ElementType.PACKAGE})
@SoftwareDevelopmentConcept
public @interface SyntacticSugar {
    String[] value();

    String due() default "";
}
