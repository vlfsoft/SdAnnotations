package vlfsoft.patterns;

import vlfsoft.paradigms.ProgrammingParadigm;
import vlfsoft.patterns.design.DesignPattern;
import vlfsoft.patterns.enterprise.ddd.DDD;
import vlfsoft.patterns.enterprise.eip.EIP;
import vlfsoft.patterns.enterprise.jee.JEE;
import vlfsoft.patterns.enterprise.peaa.PEAA;
import vlfsoft.principles.reactive.ReactiveManifesto;
import vlfsoft.tags.DDDSampleTag;
import vlfsoft.tags.Related;

import java.lang.annotation.*;

import static vlfsoft.principles.reactive.ReactiveManifesto.*;

@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({})
public @interface VLFP {

    /**
     * {@link DesignPattern.Language.Form#Intent} Interfaces/classes that isolate like {@link GOF.Mediator} application core classes from DB access implementation details, wrap DB access-specific method calls and exposes domain-specific methods to the application.
     *
     * {@link DesignPattern.Language.Form#Problem}: How to move data between {@link DDD.DomainObject}s and the database {@link DDD.InfrastructureLayer} components while keeping the two independent of each other?
     * {@link DesignPattern.Language.Form#Problem}: How to map data between {@link SpringSpecific.SpringDataJPA} Entities and {@link DDD.DomainObject}s ?
     * {@link DesignPattern.Language.Form#Problem}: How to have opportunity to replace database {@link DDD.InfrastructureLayer} components without affecting {@link DDD.DomainObject}s ?
     * {@link DesignPattern.Language.Form#Solution}: Create a separate {@link DatabaseMapper} that contains the mapping logic between the database {@link DDD.InfrastructureLayer} components and the {@link DDD.DomainObject}s in {@link DDD.DomainLayer}.
     * Database {@link DDD.InfrastructureLayer} components can be implemented with help of patterns like {@link SpringSpecific.SpringDataJPA}, {@link JEE.DataAccessObject} or {@link PEAA.Patterns.Layer.DataSource} patterns.
     * One {@link DatabaseMapper} can wrap several {@link SpringSpecific.SpringDataJPA}, if DB access implementation is based on {@link SpringSpecific.SpringDataJPA}.
     * {@link DatabaseMapper} like {@link GOF.Facade} defines a higher-level abstract persistence layer over other persistence layer components {@link GOF.Facade.SubsystemOrComponent},
     * implemented with one ore more technologies ({@link SpringSpecific.SpringDataJPA}, JPA, JdbcTemplate, ...), that makes easier to use underlying components {@link GOF.Facade.SubsystemOrComponent},
     * and allows to replace underlying components/technologies {@link GOF.Facade.SubsystemOrComponent} without affecting client code.
     *
     * {@link VLFP.DatabaseMapper} is close to {@link PEAA.DataMapper} and {@link DDD.Repository} and combines some traits of {@link JEE.DataAccessObject}.
     *
     * <p>
     * Advantages:
     * Combine several @Modifying queries to perform group insert/delete into db in single transaction ({@link DatabaseMapper} method with @Transactional).
     * Using {@link DatabaseMapper} method with @Transactional to consume data from DB via Java 8 stream (stream requires @Transactional.
     * (@Transactional is effective only if method is called "outside" to use Java Dynamic Proxy).
     * <p>
     * Rule of thumb:
     * Start to declare all the methods in single {@link DatabaseMapper} interface/class named f.e. MainAppDbm*;
     * If it becomes difficult to work with single {@link DatabaseMapper} interface/class,
     * split the original {@link DatabaseMapper} interface/class class into several smaller ones by logical areas (modules, packages, etc.).
     * <p>
     * Package pattern: Place all {@link DatabaseMapper} sources into package company.appname.dbapi.mappers;
     *
     */
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE})
    @GOF.Singleton
    @DDD.Stateless
    @GOF.Factory
    @Related.Patterns(PEAA.Repository.class)
    @PEAA.Mapper
    @interface DatabaseMapper {
    }

    /**
     * Rule of thumb:
     * Start to declare all the methods in single {@link FileStorageMapper} interface/class named f.e. MainAppFsm*;
     * If it becomes difficult to work with single {@link FileStorageMapper} interface/class,
     * split the original {@link FileStorageMapper} interface/class class into several smaller ones by logical areas (modules, packages, etc.).
     * <p>
     * Package pattern: Place all {@link FileStorageMapper} sources into package company.appname.filetypeapi.mappers;
     */
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE})
    @GOF.Singleton
    @DDD.Stateless
    @GOF.Factory
    @Related.Patterns(PEAA.Repository.class)
    @PEAA.Mapper
    @interface FileStorageMapper {
    }

    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({})
    @interface SpringSpecific {

        /**
         * Encapsulate all the code to read values from property files in beans with @Scope(BeanDefinition.SCOPE_SINGLETON).
         * Don't use {@link JavaConfig} with {@link PropertiesBean}.
         * Name pattern of {@link PropertiesBean} is *PropertiesA
         * Rule of thumb:
         * Start with single {@link PropertiesBean} (named f.e. MainAppPropertiesA, MainAppPropertiesProperties).
         * If it becomes difficult to work with single {@link PropertiesBean},
         * split the original {@link PropertiesBean} into several smaller ones by logical areas (modules, packages, classes, etc.).
         * Package pattern: Place all {@link PropertiesBean} sources into package company.appname.properties;
         * Rule of thumb: One {@link PropertiesBean} can aggregate {@link Pattern.Association} another {@link PropertiesBean} and {@link Pattern.Delegation.Delegate} some calls to it.
         * Hint: In Kotlin use {@link Pattern.Delegation} feature to simplify code.
         */


        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE})
        @PEAA.Mapper
        @interface PropertiesBean {
        }

        /**
         * Declaring beans in {@link JavaConfig} advantages:
         * - It i simple (if it i necessary) to migrate from SCOPE_SINGLETON to to create instances of the class with factory to launch several class instances in parallel.
         * - It i easier to use special "test" beans instead of production ones.
         * "Test" (mocked) bean i a another "test" (mocked) class, implementing the interface provided by bean. The "test" (mocked) class can be implemented with extending product class and overriding methods.
         * It's just necessary to declare JavaConfig in TestClass and mark @Bean {@link GOF.Factory.FactoryMethod} with @Primary or @Profile.
         * - It i easier to determine (read from source) all the app beans declarations (including @Scope), since all of the dependencies are in one place in {@link JavaConfig}
         * Injecting dependencies in constructor disadvantages:
         * - It adds boilerplate code (declaring @Bean {@link GOF.Factory.FactoryMethod} and its parameters) in {@link JavaConfig}.
         * Name pattern of {@link JavaConfig} i *Config.
         * <p>
         * Rule of thumb: Following the {@link vlfsoft.principles.generic.DoTheSimplestThingThatCouldPossiblyWorkPrinciple},
         * start to declare all the @Bean {@link GOF.Factory.FactoryMethod} methods in single {@link JavaConfig} class named f.e. MainAppConfig;
         * If it becomes difficult to work with single {@link JavaConfig} class,
         * split the original {@link JavaConfig} class into several smaller ones by logical areas (modules, packages, etc.).
         * <p>
         * Package pattern: Place all {@link JavaConfig} sources into package company.appname.config;
         * <p>
         * Note: Separate class built with {@link GOF.Factory} can be replaced with {@link JavaConfig}.{@link GOF.Factory.FactoryMethod},
         * if it's constructor contains the dependencies provided with beans only. If the constructor contains at least one non-dependency parameter,
         * a separate class built with {@link GOF.Factory} i required.
         * The class with {@link GOF.Factory} i a Bean with @Scope(BeanDefinition.SCOPE_SINGLETON).
         */
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE})
        @interface JavaConfig {

            /**
             * It's used to create beans on demand with help of Spring ApplicationContext.
             * <p>
             * Rule of thumb: Following the {@link vlfsoft.principles.generic.DoTheSimplestThingThatCouldPossiblyWorkPrinciple},
             * start to declare all the {@link GOF.Factory.FactoryMethod} @Bean and non-@Bean providing methods
             * in single {@link GOF.Singleton} {@link GOF.Factory.AbstractFactory} interface/class named f.e. MainAppConfigFactory*
             * MainAppConfigFactory i injected with ApplicationContext mApplicationContext to support {@link GetBeanFactoryMethod}
             * <p>
             * MainAppConfigFactory i implemented as {@link GOF.Singleton} class.
             * <p>
             * Package pattern: Place all the {@link GOF.Factory.AbstractFactory} MainAppConfigFactory* sources into package company.appname.config.factory;
             * <p>
             * If it's required or more optimal to return from Factory @Bean class instances,
             * start to declare the {@link GetBeanFactoryMethod} methods in several *ConfigFactory* interfaces/classes.
             * <p>
             * If it becomes difficult to work with single {@link GOF.Factory.AbstractFactory} interface/class,
             * split the original {@link GOF.Factory.AbstractFactory} interface/class into several smaller ones by logical areas (modules, packages, etc.).
             */
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.METHOD})
            @interface GetBeanFactoryMethod {
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
         * <p>
         * http://www.baeldung.com/spring-interview-questions
         * The recommended approach i to use {@link Constructor} arguments for mandatory dependencies and setters for optional ones.
         * {@link Constructor} {@link Injection} allows injecting values to immutable fields and makes testing easier.
         */
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.CONSTRUCTOR})
        @interface Injection {

            /**
             * Injecting dependencies in constructor advantages:
             * - It i simple (if it i necessary) to migrate from SCOPE_SINGLETON to to create instances of the class with factory to launch several class instances in parallel.
             * - It i simple to declare Bean with JavaConfig method instead of using annotation @Service ...
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
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.CONSTRUCTOR})
            @interface Constructor {
            }

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


            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.TYPE, ElementType.PARAMETER, ElementType.FIELD})
            @interface QualifierName {
            }

        }

        /**
         * {@link RestApiController} binds service methods to Url paths, builds.
         */
        @PEAA.ModelViewController.Controller
        @DesignPattern.Architectural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.ANNOTATION_TYPE})
        @interface RestApiController {

            /**
             * RequestMapping based annotations are used to binds service methods to Url paths.
             * Rule of thumb: Following the {@link vlfsoft.principles.generic.DoTheSimplestThingThatCouldPossiblyWorkPrinciple},
             * start to declare all the methods, annotated with {@link RequestMapping}
             * in single class named f.e. MainAppController
             * If it becomes difficult to work with single MainAppController class,
             * split the original MainAppController class into several smaller ones by logical areas (modules, packages, etc.).
             */
            @ProgrammingParadigm.Imperative
            @PEAA.ModelViewController.Controller
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.TYPE, ElementType.METHOD})
            @interface RequestMapping {
            }

            /**
             * The function binds service methods to Url paths, builds and return RouterFunction.
             * start to declare the method, annotated with {@link RouterFunction}
             * in single class/filemodified named f.e. MainAppController
             */
            @ProgrammingParadigm.Declarative.Functional
            @PEAA.ModelViewController.Controller
            @DesignPattern.Architectural
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.TYPE, ElementType.METHOD})
            @interface RouterFunction {
            }

            /**
             * override fun restApiFun(req: ServerRequest): Mono<ServerResponse> = ...
             * <p>
             * {@link RestApiFunction} extracts RestApi.RequestBody<T> from [Mono]<[ServerRequest]>, passes it to ServiceA.fun
             * [ServiceA.fun] processes request and returns RestApi.ResponseBody<T>.
             * {@link RestApiFunction} consumes RestApi.ResponseBody<T>, returned by ServiceA.fun and converts it to [Mono]<[ServerResponse]>
             */
            @ProgrammingParadigm.Declarative.Functional
            @PEAA.ModelViewController.Controller
            @DesignPattern.Architectural
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.METHOD})
            @interface RestApiFunction {
            }

        }

        /**
         * Use save* methods to insert single object data into db table. Pros: transparent way to obtain new id value with GenerationType.IDENTITY
         * Use remove* methods to delete single object data from db table.
         * Use @Modifying queries to update single object data in db table instead of save* methods.
         * Use @Modifying queries to perform group insert/delete to/from db table instead of save* / remove* methods.
         * Use ?1 syntax for parameters, if parameters are not POJO (Entities, DTO).
         * Use @Param with SPEL syntax for parameters, if parameters are POJO (Entities, DTO).
         * Try to use always parameter(s) Entity which Repository i declared with and @Param with SPEL syntax for parameters.
         * Name pattern of {@link SpringDataJPA} i *RepositoryA. (* - name of db table or view in java name style)
         * Package pattern: Place all {@link SpringDataJPA} sources into package company.appname.persistence.repository;
         */
        @DesignPattern.Architectural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE})
        @PEAA.TableDataGateway
        @interface SpringDataJPA {
        }

        @DesignPattern.Architectural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({})
        @interface Kotlin {
            /**
             * Since façade classes and DTO are used to interact with persistence layer (including entities) and in order to avoid boiler plate code, simplify and unify declaring entities,
             * the following pattern i used:
             * Declare entity as a data class with all the properties declared in the primary constructor with var and with default values.
             * The names of the properties are the same as the field names in the db table.
             * The data class does'nt implement Serializable see. When and why JPA entities should implement Serializable interface?
             * Name pattern of {@link Entity} i *Entity. (* - name of db table or view in java name style)
             * Package pattern: Place all {@link Entity} sources into package company.appname.persistence.entity;
             */
            @DesignPattern.Architectural
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.TYPE})
            @interface Entity {
            }
        }
    }

    @ProgrammingParadigm.Declarative.DataFlow
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({})
    @interface DataStream {

        @ProgrammingParadigm.Declarative.DataFlow.FlowBased
        @DesignPattern.Testing
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.ANNOTATION_TYPE})
        @interface NonReactive {
        }

        @ProgrammingParadigm.Declarative.DataFlow.Reactive
        @ReactiveManifesto({AsResponsive, AsResilient, AsElastic, AsMessageDriven})
        @DesignPattern.Testing
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.ANNOTATION_TYPE})
        @interface Reactive {
            @ProgrammingParadigm.Declarative.DataFlow.Reactive
            @ReactiveManifesto({AsResponsive, AsResilient, AsElastic, AsMessageDriven})
            @DesignPattern.Testing
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.ANNOTATION_TYPE})
            @interface BackPressure {
            }
        }

    }

    @Pattern.Association.Composition
    @GOF.Factory.FactoryMethod
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
    @interface Collection {

        @Pattern.Association.Composition
        @GOF.Factory.FactoryMethod
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
        @interface Generic {
            Class typeParameter() default Object.class;

            /**
             * <? extends T> or <T extends O>
             */
            boolean upperBounded() default false;

            /**
             * <? super T> or <T super O>
             */
            boolean lowerBounded() default false;

            /**
             * A wildcard type represents an unknown type. It’s marked with a question mark
             * <? extends T>
             */
            boolean wildcard() default false;
        }
    }

    /**
     * PECS stands for producer extends, consumer super
     * https://stackoverflow.com/questions/2723397/what-is-pecs-producer-extends-consumer-super
     * PECS is from the {@link Collection}'s point of view.
     * If you are only pulling items from a {@link Collection.Generic}, it i a {@link Producer} and you should use extends;
     * if you are only stuffing items in, it i a {@link Consumer} and you should use super. If you do both with the same {@link Collection.Generic},
     * you shouldn't use either extends or super.
     */
    @GOF.Factory.FactoryMethod
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({})
    @interface PECS {
        @GOF.Factory.FactoryMethod
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
        @DesignPattern(aka = {"Sender", "Publisher"})
        @interface Producer {
        }

        @GOF.Factory.FactoryMethod
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
        @DesignPattern(aka = {"Receiver", "Subscriber", "Listener"})
        @interface Consumer {
        }
    }

    /**
     * Private method that i used locally in one (as a rule) or more (rarely) other class methods.
     * In kotlin - local function.
     * In java i implemented with either {@link LocalMethodGroup} or with {@link LocalMethodLambda}
     */
    @GOF.Factory.FactoryMethod
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD})
    @interface LocalMethod {
    }

    /**
     * In java, this i a nested static class, that encapsulates in its namespace a group of private static methods (to support {@link LocalMethod}), thus excluding them from namespace of enclosed class.
     * {@link LocalMethodGroup} annotated class can have several {@link EntryPointMethod}s - method which are called from other methods in enclosed class,
     * and several {@link HelperMethod}s which are called only from each other and {@link EntryPointMethod}s.
     * As a rule, method with name execute i an {@link EntryPointMethod}.
     * <p>
     * In kotlin, this i companion object. Methods can be annotated with @JvmStatic.
     * <p>
     * {@link EntryPointMethod}s have to have final @NotNull <enclosed class> aThis, as a first parameter.
     * {@link HelperMethod}s have aThis as a parameter, optionally.
     */
    @GOF.Factory.FactoryMethod
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE})
    @interface LocalMethodGroup {

        @LocalMethod
        @GOF.Factory.FactoryMethod
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.METHOD})
        @interface EntryPointMethod {
        }

        @LocalMethod
        @GOF.Factory.FactoryMethod
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.METHOD})
        @interface HelperMethod {
        }

    }

    /**
     * Lambda that i stored in a local variable, to support {@link LocalMethod}
     */
    @LocalMethod
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.METHOD})
    @interface LocalMethodLambda {
    }

    /**
     * It is used to remove the duplication and the verbosity of the code.
     */
    @LocalMethod
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.METHOD})
    @interface Cascade {
    }

    /**
     * Abstract class, implementing common features for other classes in a class inheritance hierarchy.
     */
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE})
    @interface GenericClass {
    }

    /**
     * See <a href="https://en.wikipedia.org/wiki/Business_rule">Business rule</a>
     * a rule that defines or constrains some aspect of business and always resolves to either true or false.
     * Business rules are intended to assert business structure or to control or influence the behavior of the business.[1]
     * Business rules describe the operations, definitions and constraints that apply to an organization.
     * Business rules can apply to people, processes, corporate behavior and computing systems in an organization, and are put in place to help the organization achieve its goals.[
     */
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Related.Patterns(DDD.class)
    @interface BusinessRule {
    }

    /**
     * See <a href="https://www.martinfowler.com/bliki/AnemicDomainModel.html">https://www.martinfowler.com/bliki/AnemicDomainModel.html</a>
     * {@link DDD.DomainObject}s don't have their own behaviour.
     */
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Related.Patterns(DDD.class)
    @interface AnemicDomainModel {
    }

}
