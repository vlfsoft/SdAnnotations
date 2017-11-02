package vlfsoft.tags;

import java.lang.annotation.*;

/**
 * See <a href="https://en.wikipedia.org/wiki/SOLID_(object-oriented_design)">SOLID (object-oriented design)</a>
 * a mnemonic acronym for five design principles intended to make software designs more understandable, flexible and maintainable.
s */
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.ANNOTATION_TYPE})
public @interface SOLIDTag {
}
