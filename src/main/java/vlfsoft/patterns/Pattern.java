package vlfsoft.patterns;

import vlfsoft.paradigms.ProgrammingParadigm;
import vlfsoft.patterns.design.DesignPattern;
import vlfsoft.patterns.enterprise.ddd.DDD;
import vlfsoft.principles.ProgrammingPrinciple;
import vlfsoft.principles.intermoduleclass.CompositionOverInheritancePrinciple;
import vlfsoft.principles.solid.SOLID;
import vlfsoft.tags.PerformanceTag;
import vlfsoft.tags.Related;

import java.lang.annotation.*;

/**
 * See <a href="http://java-design-patterns.com/patterns/">Patterns</a>
 */
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({})
public @interface Pattern {

    /**
     * See <a href="http://java-design-patterns.com/patterns/caching/">Caching</a>
     * {@link PerformanceTag}
     */

    @DesignPattern.Other
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @interface Caching {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/callback/">Callback</a>
     * Real world examples
     * <p>
     * {@link DesignPattern#ExamplesFromRealWorld}: "http://docs.oracle.com/javase/7/docs/api/java/util/concurrent/CyclicBarrier.html"
     */
    @ProgrammingParadigm.Declarative.Functional
    @DesignPattern.Other
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @interface Callback {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/double-dispatch/">DoubleDispatch</a>
     * <p>
     * {@link DesignPattern#Solution: "Double Dispatch pattern is a way to create maintainable dynamic behavior based on receiver and parameter ddd."
     * <p>
     * {@link DesignPattern#ExamplesFromRealWorld}: "https://docs.oracle.com/javase/8/docs/api/java/io/ObjectOutputStream.html"
     */
    @DesignPattern.Other
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @interface DoubleDispatch {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/execute-around/">ExecuteAround</a>
     * <p>
     * {@link DesignPattern#Solution}: "Execute Around idiom frees the user from certain actions that should always be executed before and after the business method.",
     * "A good example of this is resource allocation and deallocation leaving the user to specify only what to do with the resource."
     */
    @DesignPattern.Other
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @interface ExecuteAround {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/fluentinterface/">FluentInterface</a>
     *
     * {@link DesignPattern#Solution}: "A fluent interface provides an easy-readable, flowing interface, that often mimics a domain specific language. " {@link DDD.DSL},
     * "Using this pattern results in code that can be read nearly as human language."
     *
     * {@link DesignPattern#ExamplesFromRealWorld} "http://www.oracle.com/technetwork/articles/java/ma14-java-se-8-streams-2177646.html",
     * "https://github.com/google/guava/wiki/FunctionalExplained",
     * "http://www.jooq.org/doc/3.0/manual/getting-started/use-cases/jooq-as-a-standalone-sql-builder/",
     * "http://mockito.org/",
     * "http://code.google.com/p/hamcrest/wiki/Tutorial"
     * })
     */
    @DesignPattern.Other
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Related.Patterns(DDD.DSL.class)
    @interface FluentInterface {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/monad/">Monad</a>
     */
    @DesignPattern.Other
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @interface Monad {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/abstract-document/">MuteIdiom</a>
     */
    @DesignPattern.Other
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @interface MuteIdiom {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/poison-pill/">Poison Pill</a>
     */
    @DesignPattern.Other
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.FIELD})
    @interface PoisonPill {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/queue-load-leveling/">Queue based load leveling</a>
     */
    @DesignPattern.Other
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @interface QueueBasedLoadLeveling {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/resource-acquisition-is-initialization/">Resource Acquisition Is Initialization</a>
     */
    @DesignPattern.Other
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @interface ResourceAcquisitionIsInitialization {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/marker/">MarkerInterface</a>
     */
    @DesignPattern.Other
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @interface MarkerInterface {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/converter/">Converter</a>
     */
    @DesignPattern.Other
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @interface Converter {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/delegation/">Delegation</a>
     * See <a href="https://en.wikipedia.org/wiki/Delegation_pattern">Delegation pattern</a>
     * allows object {@link @Association.Composition} to achieve the same code reuse as inheritance
     * In delegation, two objects are involved in handling a request: a {@link ReceivingObject} delegates operations to its {@link Delegate}.
     * This i analogous to subclasses deferring requests to parent classes.
     * In {@link Delegation}, an object handles a request by delegating to a second object (the {@link Delegate}).
     */
    @GOF.Behavioral
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.CONSTRUCTOR})
    @interface Delegation {

        @GOF.Behavioral
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE})
        @interface ReceivingObject {
        }

        @GOF.Behavioral
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.FIELD})
        @interface Delegate {
        }

    }

    /**
     * The holder pattern i used for providing fast access to an object.
     * Holder object keeps (caches) reference to the object. It allows to avoid slow access (calling one or more methods and etc.) to access the object.
     * Android ViewHolder pattern allows to avoid calling Menu#findItem, Activity#findViewById
     * <a href="android.view.Menu#findItem">Menu.findItem</a> method.
     */
    @GOF.Behavioral
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.FIELD})
    @interface Holder {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/dependency-injection/">DependencyInjection</a>
     */
    @GOF.Behavioral
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @interface DependencyInjection {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/extension-objects/">Extension objects</a>
     * <p>
     * {@link DesignPattern#Problem}: "Anticipate that an object’s interface needs to be extended in the future. ",
     * "Additional interfaces are defined by extension objects."
     * <p>
     * {@link DesignPattern#ExamplesFromRealWorld}: "https://en.wikipedia.org/wiki/OpenDoc",
     * "https://en.wikipedia.org/wiki/Object_Linking_and_Embedding"
     */
    @GOF.Behavioral
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @interface ExtensionObjects {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/feature-toggle/">Feature Toggle</a>
     *
     * {@link DesignPattern.Language.Form#Problem}: "Used to switch code execution paths based on properties or groupings.",
     * "Allowing new features to be released, tested and rolled out. ",
     * "Allowing switching back to the older feature quickly if needed.",
     * "It should be noted that this pattern, can easily introduce code complexity.",
     * "There is also cause for concern that the old feature that the toggle is eventually going to phase out is never removed,",
     * "causing redundant code smells and increased maintainability."
     */
    @GOF.Behavioral
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @interface FeatureToggle {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/intercepting-filter/">Intercepting Filter</a>
     */
    @GOF.Behavioral
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @interface InterceptingFilter {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/null-object/">Null Object</a>
     */
    @GOF.Behavioral
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @interface NullObject {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/throttling/">Throttling</a>
     */
    @GOF.Behavioral
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @interface Throttling {
    }

    /**
     * Abstract class, that implement an interface and implements some base functions, that common for all other classes in the inheritance hierarchy.
     * Often, the class uses {@link GOF.TemplateMethod} to implement common functions in line with {@link SOLID.OpenClosed}
     */
    @GOF.Behavioral
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE})
    @interface GenericClassA {
    }

    /**
     * See <a href="http://softwareengineering.stackexchange.com/questions/231274/property-container-design-pattern-in-depth-definition/231587">“Property Container” design-pattern in-depth definition</a>
     */
    @GOF.Creational
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
    @interface PropertyContainer {
    }

    /**
     * Instance of class can't be created with new.
     * Instance of class must be created with {@link GOF.Factory.FactoryMethod}.
     * Empty private constructor can be used to prevent creating instances of class with new.
     */
    @GOF.Creational
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE})
    @interface CreatedWithFactory {
        /**
         * Name of {@link GOF.Factory.FactoryMethod} interface or {@link GOF.Factory.AbstractFactory} interface
         */
        Class value();
    }

    /**
     * The {@link UtilityClass} serves to to provide only static methods or to enclose other classes or interfaces.
     * Instance of class can't be created with new.
     * Instance of class can't be created with @FactoryMethod.
     * Empty private constructor prevent creating instances of class with new.
     */
    @GOF.Creational
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.CONSTRUCTOR})
    @interface UtilityClass {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/object-pool/">Object Pool</a>
     * See <a href="https://en.wikipedia.org/wiki/Object_pool_pattern">Object pool pattern</a>
     * uses a set of initialized objects kept ready to use – a "pool" – rather than allocating and destroying them on demand.
     * A client of the pool will request an object from the pool and perform operations on the returned object.
     * When the client has finished, it returns the object to the pool rather than destroying it; this can be done manually or automatically.
     * Object pools are primarily used for performance: in some circumstances, object pools significantly improve performance.
     * Object pools complicate object lifetime, as objects obtained from and returned to a pool are not actually created or destroyed at this time,
     * and thus require care in implementation.
     * See <a href="https://sourcemaking.com/design_patterns/object_pool">Object Pool Design Pattern</a>
     * Object pools (otherwise known as resource pools) are used to manage the object caching.
     * A client with access to a Object pool can avoid creating a new Objects by simply asking the pool for one that has already been instantiated instead.
     * Generally the pool will be a growing pool, i.e. the pool itself will create new objects if the pool i empty,
     * or we can have a pool, which restricts the number of objects created.
     * {@link ObjectPool} minimizes instantiating new objects, since cost of initializing a class instance i high.
     */
    @GOF.Creational
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.METHOD})
    @interface ObjectPool {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/module/">Module</a>
     */
    @GOF.Creational
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
            // , ElementType.MODULE}) // since source level 1.9
    @interface Module {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/monostate/">MonoState</a>
     */
    @GOF.Creational
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @interface MonoState {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/multiton/">Multiton</a>
     */
    @GOF.Creational
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @interface Multiton {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/object-mother/">Object Mother</a>
     */
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @interface ObjectMother {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/property/">Property</a>
     */
    @GOF.Creational
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @interface Property {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/step-builder/">Step Builder</a>
     */
    @GOF.Creational
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @interface StepBuilder {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/twin/">Twin</a>
     */
    @GOF.Creational
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @interface Twin {
    }

    /**
     * Reduces quantity of code to access variable.
     */
    @GOF.Factory.FactoryMethod
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.METHOD, ElementType.FIELD, ElementType.LOCAL_VARIABLE})
    @interface ShorthandPattern {
    }

    /**
     * See <a href="https://sourcemaking.com/design_patterns/private_class_data">Private Implementation Data</a>
     * Control write access to class attributes
     * Separate data from methods that use it
     * Encapsulate class data initialization
     * Providing new type of final - final after constructor
     * See <a href="http://java-design-patterns.com/patterns/private-class-data/">Private Class Data</a>
     */
    @GOF.Factory.FactoryMethod
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.FIELD})
    @interface PrivateClassData {
    }

    /**
     * See <a href="https://en.wikipedia.org/wiki/Association_(object-oriented_programming)">Association</a>
     * defines a relationship between classes of objects that allows one object instance to cause another to perform an action on its behalf.
     * This relationship i structural, because it specifies that objects of one kind are connected to objects of another and does not represent behaviour.
     */
    @GOF.Factory.FactoryMethod
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
    @interface Association {

        /**
         * See <a href="https://en.wikipedia.org/wiki/Object_composition">Object composition</a>
         * {@link Composition} is a kind of {@link Association} where the composite object has sole responsibility for the disposition of the component parts.
         * The relationship between the composite and the component is a strong “has a” relationship, as the composite object takes ownership of the component.
         */
        @CompositionOverInheritancePrinciple(true)
        @GOF.Factory.FactoryMethod
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
        @interface Composition {

            /**
             * See <a href="https://en.wikipedia.org/wiki/Containment_(computer_programming)">Containment (computer programming)</a>
             * Composition that is used to store several instances of the composited data type is referred to as {@link Containment}.
             * Examples of such containers are arrays, associative arrays, binary trees, and linked lists.
             */
            @GOF.Factory.FactoryMethod
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
            @interface Containment {
            }

        }

        /**
         * See <a href="https://en.wikipedia.org/wiki/Object_composition">Object composition</a>
         * {@link Aggregation} differs from ordinary {@link Composition} in that it does not imply ownership.
         * In {@link Composition}, when the owning object i destroyed, so are the contained objects. In {@link Aggregation}, this i not necessarily true.
         * See <a href="https://dzone.com/articles/aggregate-pattern">Aggregate Pattern</a>
         * {@link Aggregation} i a kind of {@link Association} that specifies a whole/part relationship between the aggregate (whole) and component part.
         * This relationship between the aggregate and component i a weak “has a” relationship, as the component may survive the aggregate object.
         */
        @GOF.Factory.FactoryMethod
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
        @interface Aggregation {
        }

    }

    /**
     * See <a href="https://en.wikipedia.org/wiki/Function_composition_(computer_science)">FunctionPrinciple composition (computer science)</a>
     * function composition (not to be confused with object composition) i an act or mechanism to combine simple functions to build more complicated ones.
     * Like the usual composition of functions in mathematics, the result of each function i passed as the argument of the next,
     * and the result of the last one i the result of the whole.
     */
    @ProgrammingParadigm.Declarative.Functional
    @ProgrammingPrinciple.ModuleClass
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @interface FunctionalComposition {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/abstract-document/">Abstract Document</a>
     * See <a href="https://en.wikipedia.org/wiki/Abstract_Document_Pattern">Abstract Document Pattern</a>
     */
    @GOF.Factory.FactoryMethod
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @interface AbstractDocument {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/service-locator/">Service Locator</a>
     */
    @GOF.Factory.FactoryMethod
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @interface ServiceLocator {
    }

}
