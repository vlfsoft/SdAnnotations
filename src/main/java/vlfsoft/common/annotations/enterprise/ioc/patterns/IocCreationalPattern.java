package vlfsoft.common.annotations.enterprise.ioc.patterns;

import vlfsoft.common.annotations.design.DesignPattern;
import vlfsoft.common.annotations.design.patterns.CreationalPattern;

import java.lang.annotation.*;

@DesignPattern.Structural
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({})
public @interface IocCreationalPattern {

    /**
     * Declaring beans in {@link SpringJavaConfigBean} advantages:
     * - It is simple (if it is necessary) to migrate from SCOPE_SINGLETON to to create instances of the class with factory to launch several class instances in parallel.
     * - It is easier to use special "test" beans instead of production ones.
     * "Test" (mocked) bean is a another "test" (mocked) class, implementing the interface provided by bean. The "test" (mocked) class can be implemented with extending product class and overriding methods.
     * It's just necessary to declare SpringJavaConfigBean in TestClass and mark @Bean {@link CreationalPattern.Factory.FactoryMethod} with @Primary or @Profile.
     * - It is easier to determine (read from source) all the app beans declarations (including @Scope), since all of the dependencies are in one place in {@link SpringJavaConfigBean}
     * Injecting dependencies in constructor disadvantages:
     * - It adds boilerplate code (declaring @Bean {@link CreationalPattern.Factory.FactoryMethod} and its parameters) in {@link SpringJavaConfigBean}.
     * Name pattern of {@link SpringJavaConfigBean} is *Config.
     * Rule of thumb:
     * Start to declare all the @Bean {@link CreationalPattern.Factory.FactoryMethod} methods in single {@link SpringJavaConfigBean} class named f.e. MainAppConfig.
     * If it becomes difficult to work with single {@link SpringJavaConfigBean} class,
     * split the original {@link SpringJavaConfigBean} class into several smaller ones by logical areas (modules, packages, etc.).
     * Package pattern: Place all {@link SpringJavaConfigBean} sources into package company.appname.config;
     *
     * Note: Separate class built with {@link CreationalPattern.Factory} can be replaced with {@link SpringJavaConfigBean}.{@link CreationalPattern.Factory.FactoryMethod},
     * if it's constructor contains the dependencies provided with beans only. If the constructor contains at least one non-dependency parameter,
     * a separate class built with {@link CreationalPattern.Factory} is required.
     * The class with {@link CreationalPattern.Factory} is a Bean with @Scope(BeanDefinition.SCOPE_SINGLETON).
     */
    @DesignPattern.Creational
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE})
    @DesignPattern.ETC
    @interface SpringJavaConfigBean {
    }

}
