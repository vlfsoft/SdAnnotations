package vlfsoft.common.annotations.enterprise.ioc.patterns;

import vlfsoft.common.annotations.design.DesignPattern;

import java.lang.annotation.*;

@DesignPattern.Structural
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({})
public @interface IocStructuralPattern {

    /**
     * Injecting dependencies in constructor advantages:
     * - It is simple (if it is necessary) to migrate from SCOPE_SINGLETON to to create instances of the class with factory to launch several class instances in parallel.
     * - It is simple to declare Bean with SpringJavaConfigBean method instead of using annotations @Service ...
     * - It is easier to determine (read from source) all the dependencies required by this class, since all of the dependencies are in one place (parameters list of constructor)
     * - It is easier to replace class with mock in tests even without (mockito or powermock): just declare SpringJavaConfigBean in Test class and pass to constructor mock.
     * - It is possible to declare in:
     * --java: "private final @Nonnull DependencyA mDependency" instead of "private DependencyA mDependency",
     * --kotlin "val dependency: DependencyA" instead of lateinit var dependency: DependencyA
     * Injecting dependencies in constructor disadvantages:
     * - It adds boilerplate code (declaring constructor and its parameters). Note: Kotlin doesn't have this disadvantage.
     * Note: Too many dependency parameters in constructor can be a signal, that is necessary to re-factor class dependencies structure.
     *
     * Note: @Inject annotation on constructor is not used, if {@link IocCreationalPattern.SpringJavaConfigBean} pattern is applied.
     */
    @DesignPattern.Structural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.CONSTRUCTOR})
    @DesignPattern.ETC
    @interface ConstructorInjection {
    }

    /**
     * Encapsulate all the code to read values from property files in beans with @Scope(BeanDefinition.SCOPE_SINGLETON).
     * Don't use {@link IocCreationalPattern.SpringJavaConfigBean} with {@link PropertiesBean}.
     * Name pattern of {@link PropertiesBean} is *PropertiesA ({@link Interface}), *Properties ({@link Implementation}).
     * Rule of thumb:
     * Start with single {@link PropertiesBean} (named f.e. MainAppPropertiesA, MainAppPropertiesProperties).
     * If it becomes difficult to work with single {@link PropertiesBean},
     * split the original {@link PropertiesBean} into several smaller ones by logical areas (modules, packages, classes, etc.).
     * Package pattern: Place all {@link PropertiesBean} sources into package company.appname.properties;
     */
    @DesignPattern.Structural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({})
    @DesignPattern.ETC
    @interface PropertiesBean {

        @DesignPattern.Structural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE})
        @DesignPattern.ETC
        @interface Interface {
        }

        @DesignPattern.Structural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE})
        @DesignPattern.ETC
        @interface Implementation {
        }

    }

}
