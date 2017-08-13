package vlfsoft.common.annotations.enterprise;

import java.lang.annotation.*;

@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.TYPE})
public @interface EnterprisePattern {

    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE})
    @interface ETC {
    }

    /**
     * From books of Martin Fowler
     */
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE})
    @interface MF {
    }

    /**
     * From books of Gregor Hohpe
     */
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE})
    @interface GH {
    }

}
