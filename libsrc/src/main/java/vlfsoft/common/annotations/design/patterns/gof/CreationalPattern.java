package vlfsoft.common.annotations.design.patterns.gof;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import vlfsoft.common.annotations.design.patterns.SoftwareDesignPattern;

/**
 * See <a href="https://en.wikipedia.org/wiki/Creational_pattern">Creational pattern</a>
 */
@SoftwareDesignPattern.Creational
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface CreationalPattern {

    /**
     * See <a href="https://en.wikipedia.org/wiki/Abstract_factory_pattern">Abstract factory pattern</a>
     */
    @SoftwareDesignPattern.Creational
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.METHOD})
    @interface AbstractFactory {
    }

    /**
     * See <a href="https://en.wikipedia.org/wiki/Factory_method_pattern">Factory method pattern</a>
     */
    @SoftwareDesignPattern.Creational
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.METHOD})
    @interface FactoryMethod {
    }

    /**
     * See <a href="https://en.wikipedia.org/wiki/Singleton_pattern">Singleton_pattern</a>
     */
    @SoftwareDesignPattern.Creational
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
    @interface Singleton {
    }


    /**
     * See <a href="https://en.wikipedia.org/wiki/Builder_pattern">Builder_pattern</a>
     */
    @SoftwareDesignPattern.Creational
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.METHOD})
    @interface Builder {
    }

}
