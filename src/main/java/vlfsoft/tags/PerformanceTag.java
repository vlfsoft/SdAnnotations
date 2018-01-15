package vlfsoft.tags;

import java.lang.annotation.*;

/**
 * Use only in javadoc like: {@link PerformanceTag}: ...
 */
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({})
public @interface PerformanceTag {
}
