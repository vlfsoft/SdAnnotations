package vlfsoft.tags;

import java.lang.annotation.*;

/**
 * Use only in javadoc like: {@link NoteTag}: ...
 */
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({})
public @interface NoteTag {
}
