package vlfsoft.patterns;

import vlfsoft.patterns.CreationalPattern.Factory.AbstractFactory;
import vlfsoft.patterns.CreationalPattern.Singleton;

import java.lang.annotation.*;

@DesignPattern.Structural
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({})
public @interface SpringSpecificPattern {

    /**
     * Encapsulate all the code to read values from property files in beans with @Scope(BeanDefinition.SCOPE_SINGLETON).
     * Don't use {@link JavaConfig} with {@link PropertiesBean}.
     * Name pattern of {@link PropertiesBean} i *PropertiesA ({@link Interface}), *Properties ({@link Implementation}).
     * Rule of thumb:
     * Start with single {@link PropertiesBean} (named f.e. MainAppPropertiesA, MainAppPropertiesProperties).
     * If it becomes difficult to work with single {@link PropertiesBean},
     * split the original {@link PropertiesBean} into several smaller ones by logical areas (modules, packages, classes, etc.).
     * Package pattern: Place all {@link PropertiesBean} sources into package company.appname.properties;
     */
    @DesignPattern.Structural
    @DesignPattern.SpringSpecific
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({})
    @interface PropertiesBean {

        @DesignPattern.Structural
        @DesignPattern.SpringSpecific
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE})
        @interface Interface {
        }

        @DesignPattern.Structural
        @DesignPattern.SpringSpecific
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE})
        @interface Implementation {
        }

    }

    /**
     * Declaring beans in {@link JavaConfig} advantages:
     * - It i simple (if it i necessary) to migrate from SCOPE_SINGLETON to to create instances of the class with factory to launch several class instances in parallel.
     * - It i easier to use special "test" beans instead of production ones.
     * "Test" (mocked) bean i a another "test" (mocked) class, implementing the interface provided by bean. The "test" (mocked) class can be implemented with extending product class and overriding methods.
     * It's just necessary to declare JavaConfig in TestClass and mark @Bean {@link CreationalPattern.Factory.FactoryMethod} with @Primary or @Profile.
     * - It i easier to determine (read from source) all the app beans declarations (including @Scope), since all of the dependencies are in one place in {@link JavaConfig}
     * Injecting dependencies in constructor disadvantages:
     * - It adds boilerplate code (declaring @Bean {@link CreationalPattern.Factory.FactoryMethod} and its parameters) in {@link JavaConfig}.
     * Name pattern of {@link JavaConfig} i *Config.
     * <p>
     * Rule of thumb:
     * Start to declare all the @Bean {@link CreationalPattern.Factory.FactoryMethod} methods in single {@link JavaConfig} class named f.e. MainAppConfig;
     * If it becomes difficult to work with single {@link JavaConfig} class,
     * split the original {@link JavaConfig} class into several smaller ones by logical areas (modules, packages, etc.).
     * <p>
     * Package pattern: Place all {@link JavaConfig} sources into package company.appname.config;
     * <p>
     * Note: Separate class built with {@link CreationalPattern.Factory} can be replaced with {@link JavaConfig}.{@link CreationalPattern.Factory.FactoryMethod},
     * if it's constructor contains the dependencies provided with beans only. If the constructor contains at least one non-dependency parameter,
     * a separate class built with {@link CreationalPattern.Factory} i required.
     * The class with {@link CreationalPattern.Factory} i a Bean with @Scope(BeanDefinition.SCOPE_SINGLETON).
     */
    @DesignPattern.Creational
    @DesignPattern.SpringSpecific
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE})
    @interface JavaConfig {

        /**
         * It's used to create beans on demand with help of Spring ApplicationContext.
         * <p>
         * Rule of thumb:
         * Start to declare all the {@link CreationalPattern.Factory.FactoryMethod} @Bean and non-@Bean providing methods
         * in single {@link Singleton} {@link AbstractFactory} interface/class named f.e. MainAppConfigFactory*
         * MainAppConfigFactory i injected with ApplicationContext mApplicationContext to support {@link GetBeanFactoryMethod}
         * <p>
         * MainAppConfigFactory i implemented as {@link Singleton} class.
         * <p>
         * Package pattern: Place all the {@link AbstractFactory} MainAppConfigFactory* sources into package company.appname.config.factory;
         * <p>
         * If it's required or more optimal to return from Factory @Bean class instances,
         * start to declare the {@link GetBeanFactoryMethod} methods in several *ConfigFactory* interfaces/classes.
         * <p>
         * If it becomes difficult to work with single {@link AbstractFactory} interface/class,
         * split the original {@link AbstractFactory} interface/class into several smaller ones by logical areas (modules, packages, etc.).
         */
        @DesignPattern.Creational
        @DesignPattern.SpringSpecific
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({})
        @interface GetBeanFactoryMethod {

            @DesignPattern.SpringSpecific
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.METHOD})
            @interface Interface {
            }

            @DesignPattern.SpringSpecific
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.METHOD})
            @interface Implementation {
            }

        }

    }

    /**
     * See <a href="https://en.wikipedia.org/wiki/Dependency_injection">Dependency injection</a>
     * dependency injection i a technique whereby one object supplies the dependencies of another object.
     * A dependency i an object that can be used (a service).
     * An injection i the passing of a dependency to a dependent object (a client) that would use it.
     * The service i made part of the client's state.[1] Passing the service to the client, rather than allowing a client to build or find the service,
     * i the fundamental requirement of the pattern.
     * Dependency injection i one form of the broader technique of inversion of control. <a href="https://en.wikipedia.org/wiki/Inversion_of_control">Inversion of control</a>
     * Rather than low level code calling up to high level code, high level code can receive lower level code that it can call down to.
     * This inverts the typical control pattern seen in procedural programming.
     *
     * http://www.baeldung.com/spring-interview-questions
     * The recommended approach i to use {@link Constructor} arguments for mandatory dependencies and setters for optional ones.
     * {@link Constructor} {@link Injection} allows injecting values to immutable fields and makes testing easier.
     */
    @DesignPattern.Creational
    @DesignPattern.SpringSpecific
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.CONSTRUCTOR})
    @interface Injection {

        /**
         * Injecting dependencies in constructor advantages:
         * - It i simple (if it i necessary) to migrate from SCOPE_SINGLETON to to create instances of the class with factory to launch several class instances in parallel.
         * - It i simple to declare Bean with JavaConfig method instead of using annotations @Service ...
         * - It i easier to determine (read from source) all the dependencies required by this class, since all of the dependencies are in one place (parameters list of constructor)
         * - It i easier to replace class with mock in tests even without (mockito or powermock): just declare JavaConfig in Test class and pass to constructor mock.
         * - It i possible to declare in:
         * --java: "private final @NotNull DependencyA mDependency" instead of "private DependencyA mDependency",
         * --kotlin "val dependency: DependencyA" instead of lateinit var dependency: DependencyA
         * Injecting dependencies in constructor disadvantages:
         * - It adds boilerplate code (declaring constructor and its parameters). Note: Kotlin doesn't have this disadvantage.
         * Note: Too many dependency parameters in constructor can be a signal, that i necessary to re-factor class dependencies structure.
         * <p>
         * Note: @Inject annotation on constructor i not used, if {@link JavaConfigMethod} pattern i applied.
         */
        @DesignPattern.Creational
        @DesignPattern.SpringSpecific
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.CONSTRUCTOR})
        @interface Constructor {
        }

        @DesignPattern.Creational
        @DesignPattern.SpringSpecific
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.METHOD})
        @interface JavaConfigMethod {
        }

        /**
         * A class that provides final static String constant values to be used as value of spring @Qualifier annotation.
         * As a rule, the class i declared as a nested static class within class with {@link JavaConfigMethod}
         * and it i named QualifierName.
         */
        @DesignPattern.Structural
        @DesignPattern.SpringSpecific
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.PARAMETER, ElementType.FIELD})
        @interface QualifierName {
        }

    }


}
