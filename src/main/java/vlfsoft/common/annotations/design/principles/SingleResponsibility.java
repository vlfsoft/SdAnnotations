package vlfsoft.common.annotations.design.principles;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * See <a href="https://en.wikipedia.org/wiki/Single_responsibility_principle">Single responsibility principle</a>
 * The single responsibility principle states that every module or class should have responsibility
 * over a single part of the functionality provided by the software, and that responsibility
 * should be entirely encapsulated by the class. All its services should be narrowly aligned with that responsibility.
 */
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.TYPE})
public @interface SingleResponsibility {
    /**
     * Contains the description of a single part of the functionality provided by the software, that class is responsible over.
     */
    String over();
}
