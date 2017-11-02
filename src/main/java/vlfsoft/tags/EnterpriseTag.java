package vlfsoft.tags;

import java.lang.annotation.*;

@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.ANNOTATION_TYPE})
public @interface EnterpriseTag {

    /**
     * From books of Martin Fowler
     */
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @interface MartinFowlerBoooks {
    }

    /**
     * From books of Gregor Hohpe
     */
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @interface GregorHohpeBooks {
    }

}
