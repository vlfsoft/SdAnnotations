package vlfsoft.common.annotations.design.patterns.etc;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import vlfsoft.common.annotations.design.patterns.SoftwareDesignPattern;

/**
 *
 */
@SoftwareDesignPattern.Creational
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface EtcCreationalPattern {

    /**
     * Instance of class can't be created with new.
     * Instance of class can be created with {@link vlfsoft.common.annotations.design.patterns.gof.CreationalPattern.FactoryMethod}.
     * Empty private constructor prevent creating instances of class with new.
     */
    @SoftwareDesignPattern.Creational
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.METHOD})
    @interface CreatedWithFactory {
    }

    /**
     * Instance of class can't be created with new.
     * Instance of class can't be created with @FactoryMethod.
     * Empty private constructor prevent creating instances of class with new.
     * contains only static methods.
     */
    @SoftwareDesignPattern.Creational
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.CONSTRUCTOR})
    @interface UtilityClass {
    }

}
