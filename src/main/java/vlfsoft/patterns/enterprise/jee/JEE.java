package vlfsoft.patterns.enterprise.jee;

import vlfsoft.patterns.enterprise.ddd.DDD;
import vlfsoft.patterns.enterprise.peaa.PEAA;
import vlfsoft.tags.Related;

import java.lang.annotation.*;

import static vlfsoft.patterns.design.DesignPattern.*;

/**
 * Java EE patterns
 * See <a href="http://www.corej2eepatterns.com/">Core J2EE Patterns</a>
 */
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({})
public @interface JEE {

    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({})
    @interface Patterns {

        /**
         * See <a href="http://www.corej2eepatterns.com/index.htm">Core jee Patterns</a>
         */
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({})
        @interface Core {
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.ANNOTATION_TYPE})
            @interface PresentationTier {
            }

            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.ANNOTATION_TYPE})
            @interface BusinessTier {
            }


            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.ANNOTATION_TYPE})
            @interface IntegrationTier {
            }

        }

    }

    @Retention(RetentionPolicy.SOURCE)
    @interface BEG_PresentationTier {
    }

    /**
     * See <a href="http://www.corej2eepatterns.com/InterceptingFilter.htm">Intercepting Filter</a>
     */
    @Architectural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Core.PresentationTier
    @interface InterceptingFilter {
    }

    /**
     * See <a href="http://www.corej2eepatterns.com/ContextObject.htm">Context Object</a>
     */
    @Architectural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Core.PresentationTier
    @interface ContextObject {
    }

    /**
     * See <a href="http://www.corej2eepatterns.com/FrontController.htm">Front Controller</a>
     */
    @Architectural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Core.PresentationTier
    @interface SEC_FrontController {
    }

    /**
     * See <a href="http://www.corej2eepatterns.com/ApplicationController.htm">Application Controller</a>
     */
    @Architectural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Core.PresentationTier
    @interface ApplicationController {
    }

    /**
     * See <a href="http://www.corej2eepatterns.com/ViewHelper.htm">View Helper</a>
     */
    @Architectural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Core.PresentationTier
    @interface ViewHelper {
    }

    /**
     * See <a href="http://www.corej2eepatterns.com/CompositeView.htm">Composite View</a>
     */
    @Architectural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Core.PresentationTier
    @interface CompositeView {
    }

    /**
     * See <a href="http://www.corej2eepatterns.com/DispatcherView.htm">Dispatcher View</a>
     */
    @Architectural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Core.PresentationTier
    @interface DispatcherView {
    }

    /**
     * See <a href="http://www.corej2eepatterns.com/ServiceToWorker.htm">Service To Worker</a>
     */
    @Architectural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Core.PresentationTier
    @interface ServiceToWorker {
    }

    @Retention(RetentionPolicy.SOURCE)
    @interface BEG_BusinessTier {
    }

    /**
     * See <a href="http://www.corej2eepatterns.com/BusinessDelegate.htm">Business Delegate</a>
     * <p>
     * See <a href="http://java-design-patterns.com/patterns/business-delegate/">BusinessDelegate</a>
     */
    @Architectural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Core.PresentationTier
    @interface BusinessDelegate {
    }

    /**
     * See <a href="http://www.corej2eepatterns.com/ServiceLocator.htm">Service Locator</a>
     */
    @Architectural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Core.PresentationTier
    @interface ServiceLocator {
    }

    /**
     * See <a href="http://www.corej2eepatterns.com/SessionFacade.htm">Session Facade</a>
     */
    @Architectural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Core.PresentationTier
    @interface SessionFacade {
    }

    /**
     * See <a href="http://www.corej2eepatterns.com/ApplicationService.htm">Application Service</a>
     */
    @Architectural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Core.PresentationTier
    @interface ApplicationService {
    }

    /**
     * See <a href="http://www.corej2eepatterns.com/BusinessObject.htm">Business Object</a>
     */
    @Architectural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Core.PresentationTier
    @interface BusinessObject {
    }

    /**
     * See <a href="http://www.corej2eepatterns.com/CompositeEntity.htm">Composite Entity</a>
     */
    @Architectural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Core.PresentationTier
    @interface CompositeEntity {
    }

    /**
     * See <a href="http://www.corej2eepatterns.com/TransferObject.htm">Transfer Object</a>
     * {@link Language.Form#Problem}: You want to transfer multiple data elements over a tier.
     * {@link Language.Form#Forces}:
     * You want clients to access components in other tiers to retrieve and update data.
     * You want to reduce remote requests across the network.
     * You want to avoid network performance degradation caused by chattier applications that have high network traffic
     * {@link Language.Form#Solution}: Use a Transfer Object to carry multiple data elements across a tier.
     * {@link Language.Form#Consequences}:
     * Reduces network traffic
     * Simplifies remote object and remote interface
     * Transfers more data in fewer remote calls
     * Reduces code duplication
     * Introduces stale transfer objects
     * Increases complexity due to synchronization and version control
     */
    @Architectural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Core.PresentationTier
    @Related.Patterns({PEAA.DTO.class, DataAccessObject.class})
    @interface TransferObject {
    }

    /**
     * See <a href="http://www.corej2eepatterns.com/TransferObjectAssembler.htm">TO Assembler</a>
     */
    @Architectural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Core.PresentationTier
    @interface TOAssembler {
    }

    /**
     * See <a href="http://www.corej2eepatterns.com/ValueListHandler.htm">Value List Handler</a>
     */
    @Architectural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Core.PresentationTier
    @interface ValueListHandler {
    }

    @Retention(RetentionPolicy.SOURCE)
    @interface BEG_IntegrationTier {
    }

    /**
     * See <a href="http://www.corej2eepatterns.com/DataAccessObject.htm">Data Access Object</a>
     * See <a href="http://java-design-patterns.com/patterns/dao">Data Access Object</a>
     * {@link Language.Form#Problem}: You want to encapsulate data access and manipulation in a separate layer.
     * {@link Language.Form#Forces}:
     * You want to implement data access mechanisms to access and manipulate data in a persistent storage.
     * You want to decouple the persistent storage implementation from the rest of your application.
     * You want to provide a uniform data access API for a persistent mechanism to various ddd of data sources, such as RDBMS, LDAP, OODB, XML repositories, flat files, and so on.
     * You want to organize data access logic and encapsulate proprietary features to facilitate maintainability and portability.
     * {@link Language.Form#Solution}: Use a Data Access Object to abstract and encapsulate all access to the persistent store.
     * {@link Language.Form#Consequences}:
     * The Data Access Object manages the connection with the data source to obtain and store data.
     * Centralizes control with loosely coupled handlers
     * Enables transparency
     * Provides object-oriented view and encapsulates database schemas
     * Enables easier migration
     * Reduces code complexity in clients
     * Organizes all data access code into a separate layer
     * Adds extra layer
     * Needs class hierarchy design (Factory Method Strategies)
     * Introduces complexity to enable object-oriented design (RowSet Wrapper List Strategy)
     * Data access objects in their most basic form use {@link TransferObject}s to transport data to and from their clients. {@link TransferObject}s are used in other strategies of Data Access Objects.
     * The RowSet Wrapper List strategy returns a list as a {@link TransferObject}.
     */
    @Architectural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Related.Patterns({DDD.Repository.class, TransferObject.class})
    @Patterns.Core.IntegrationTier
    @interface DataAccessObject {
    }

    /**
     * See <a href="http://www.corej2eepatterns.com/ServiceActivator.htm">Service Activator</a>
     */
    @Architectural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Core.IntegrationTier
    @interface ServiceActivator {
    }

    /**
     * See <a href="http://www.corej2eepatterns.com/DomainStore.htm">Domain Store</a>
     */
    @Architectural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Core.IntegrationTier
    @interface DomainStore {
    }

    /**
     * See <a href="http://www.corej2eepatterns.com/WebServiceBroker.htm">Web Service Broker</a>
     */
    @Architectural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Core.IntegrationTier
    @interface WebServiceBroker {
    }

}
