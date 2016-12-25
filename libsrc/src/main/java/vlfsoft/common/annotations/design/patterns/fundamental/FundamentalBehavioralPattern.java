package vlfsoft.common.annotations.design.patterns.fundamental;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import vlfsoft.common.annotations.design.patterns.SoftwareDesignPattern;

@SoftwareDesignPattern.Behavioral
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.CONSTRUCTOR})
public @interface FundamentalBehavioralPattern {
    /**
     * See <a href="https://en.wikipedia.org/wiki/Delegation_pattern">Delegation pattern</a>
     */
    @SoftwareDesignPattern.Behavioral
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.CONSTRUCTOR})
    @interface Delegation {
    }

    /**
     * The holder pattern is used for providing fast access to an object.
     * Holder object keeps (caches) reference to the object. It allows to avoid slow access (calling one or more methods and etc.) to access the object.
     * Android ViewHolder pattern allows to avoid calling Menu#findItem, Activity#findViewById
     * <a href="android.view.Menu#findItem">Menu.findItem</a> method.
     */
    @SoftwareDesignPattern.Behavioral
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.FIELD})
    @interface Holder {
    }

}
