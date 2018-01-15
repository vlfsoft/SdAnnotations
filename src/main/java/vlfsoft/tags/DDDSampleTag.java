package vlfsoft.tags;

import java.lang.annotation.*;

/**
 * See <a href="http://dddsample.sourceforge.net/characterization.html">DDDSample</a>
 * Use only in javadoc like: {@link DDDSampleTag}: ...
 */
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({})
public @interface DDDSampleTag {
}
