package vlfsoft.common.annotations.design.patterns;

import vlfsoft.common.annotations.design.DesignPattern;

import java.lang.annotation.*;

@DesignPattern.Structural
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({})
public @interface KtStructuralPattern {

    /**
     * See <a href="https://kotlinlang.org/docs/reference/extensions.html">“Extensions”
     * Annotate methods, that can be converted to Kotlin extension function or properties
     */
    @DesignPattern.Structural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.METHOD})
    @DesignPattern.ETC
    @interface ExtensionCandidate {
        /**
         * Class of Extension receiver.
         */
        Class receiver();
    }

}
