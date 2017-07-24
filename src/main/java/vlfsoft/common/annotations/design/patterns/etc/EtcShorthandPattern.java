package vlfsoft.common.annotations.design.patterns.etc;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import vlfsoft.common.annotations.design.patterns.SoftwareDesignPattern;

/**
 *  Reduces quantity of code to access variable.
 */
@SoftwareDesignPattern.Structural
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.LOCAL_VARIABLE})
public @interface EtcShorthandPattern {

}
