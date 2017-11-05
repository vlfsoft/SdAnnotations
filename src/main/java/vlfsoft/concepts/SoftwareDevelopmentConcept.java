package vlfsoft.concepts;

import java.lang.annotation.*;

/**
 * See <a href="https://en.wikipedia.org/wiki/Category:Programming_principles">Category:Programming principles</a>
 * This category describes rules and aphorisms applicable to software engineering. They range from the highly formal to those open to interpretation, and from serious to humorous.
 */
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.ANNOTATION_TYPE})
public @interface SoftwareDevelopmentConcept {
}
