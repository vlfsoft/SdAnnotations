package vlfsoft.common.annotations.design.principles;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * See <a href="https://en.wikipedia.org/wiki/Recursion_(computer_science)">Recursion (computer science)</a>
 */
@SoftwareDesign
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
public @interface Recursion {

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
