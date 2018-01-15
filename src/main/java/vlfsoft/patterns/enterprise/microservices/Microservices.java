package vlfsoft.patterns.enterprise.microservices;

import vlfsoft.patterns.GOF;
import vlfsoft.patterns.design.DesignPattern;
import vlfsoft.patterns.enterprise.eip.EIP;
import vlfsoft.patterns.enterprise.peaa.FPEAA;
import vlfsoft.tags.Related;

import java.lang.annotation.*;

/**
 * See <a href="http://microservices.io/patterns/">A pattern language for microservices</a>
 * See <a href="https://martinfowler.com/articles/microservices.html">Microservices</a>
 * See <a href="https://martinfowler.com/microservices/">Microservices Resource Guide</a>
 * See <a href="https://www.nginx.com/blog/introduction-to-microservices/">Introduction to Microservices</a>
 *
 */
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({})
public @interface Microservices {

    /**
     * See <a href="http://microservices.io/patterns/">A pattern language for microservices</a>
     */
    @DesignPattern.Architectural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({})
    @Related.Patterns({MonolithicArchitecture.class, MicroserviceArchitecture.class})
    @interface Patterns {
        /**
         * See <a href="http://microservices.io/patterns/">A pattern language for microservices</a>
         * Core patterns: Which architecture should you choose for an application?
         */
        @DesignPattern.Architectural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.ANNOTATION_TYPE})
        @interface Core {
        }

        @DesignPattern.Architectural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.ANNOTATION_TYPE})
        @interface Decomposition {
        }

        @DesignPattern.Architectural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.ANNOTATION_TYPE})
        @interface Deployment {
        }

        @DesignPattern.Architectural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.ANNOTATION_TYPE})
        @interface CrossCuttingConcerns {
        }

        @DesignPattern.Architectural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.ANNOTATION_TYPE})
        @interface Communication {

            @DesignPattern.Architectural
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.ANNOTATION_TYPE})
            @interface Style {
            }

            @DesignPattern.Architectural
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.ANNOTATION_TYPE})
            @interface ExternalAPI {
            }

            @DesignPattern.Architectural
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.ANNOTATION_TYPE})
            @interface ServiceDiscovery {
            }

            @DesignPattern.Architectural
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.ANNOTATION_TYPE})
            @interface Reliability {
            }

            @DesignPattern.Architectural
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.ANNOTATION_TYPE})
            @interface DataManagement {
            }

            @DesignPattern.Architectural
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.ANNOTATION_TYPE})
            @interface Security {
            }

            @DesignPattern.Architectural
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.ANNOTATION_TYPE})
            @interface Testing {
            }

            @DesignPattern.Architectural
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.ANNOTATION_TYPE})
            @interface Observability {
            }

            @DesignPattern.Architectural
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.ANNOTATION_TYPE})
            @interface UI {
            }

        }

    }

    @Retention(RetentionPolicy.SOURCE)
    @interface BEG_Core {
    }

    /**
     * See <a href="http://microservices.io/patterns/monolithic.html">Pattern: Monolithic Architecture</a>
     */
    @DesignPattern.Architectural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Core
    @interface MonolithicArchitecture {
    }

    /**
     * See <a href="http://microservices.io/patterns/microservices.html">Pattern: Microservice Architecture</a>
     */
    @DesignPattern.Architectural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Core
    @interface MicroserviceArchitecture {
    }

    @Retention(RetentionPolicy.SOURCE)
    @interface BEG_Decomposition {
    }

    /**
     * See <a href="http://microservices.io/patterns/decomposition/decompose-by-business-capability.html">Decompose by business capability</a>
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Decomposition
    @interface DecomposeByBusinessCapability {
    }

    /**
     * See <a href="http://microservices.io/patterns/decomposition/decompose-by-subdomain.html">Decompose by subdomain</a>
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Decomposition
    @interface DecomposeBySubdomain {
    }

    @Retention(RetentionPolicy.SOURCE)
    @interface BEG_Deployment {
    }

    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Deployment
    @interface ServiceInstances {
    }

    /**
     * See <a href="http://microservices.io/patterns/deployment/multiple-services-per-host.html">MultipleService instances per host</a>
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Deployment
    @interface MultipleServiceInstancesPerHost {
    }

    /**
     * See <a href="http://microservices.io/patterns/deployment/single-service-per-host.html">Service instance per host</a>
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Deployment
    @interface ServiceInstancePerHost {
    }

    /**
     * See <a href="http://microservices.io/patterns/deployment/service-per-vm.html">Service instance per VM</a>
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Deployment
    @interface ServiceInstancePerVM {
    }

    /**
     * See <a href="">Service instance per container</a>
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Deployment
    @interface ServiceInstancePerContainer {
    }

    /**
     * See <a href="http://microservices.io/patterns/deployment/service-per-container.html">Serverless deployment</a>
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Deployment
    @interface ServerlessDeployment {
    }

    /**
     * See <a href="http://microservices.io/patterns/deployment/service-deployment-platform.html">Service deployment platform</a>
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Deployment
    @interface ServiceDeploymentPlatform {
    }

    @Retention(RetentionPolicy.SOURCE)
    @interface BEG_CrossCuttingConcerns {
    }

    /**
     * See <a href="http://microservices.io/patterns/microservice-chassis.html">Microservice chassis</a>
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.CrossCuttingConcerns
    @interface MicroserviceChassis {
    }

    /**
     * See <a href="http://microservices.io/patterns/externalized-configuration.html">Externalized configuration</a>
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.CrossCuttingConcerns
    @interface ExternalizedConfiguration {
    }

    @Retention(RetentionPolicy.SOURCE)
    @interface BEG_Style {
    }

    /**
     * See <a href="http://microservices.io/patterns/communication-style/rpi.html">Remote procedure invocation</a>
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Communication.Style
    @interface RemoteProcedureInvocation {
    }

    /**
     * See <a href="http://microservices.io/patterns/communication-style/messaging.html">Messaging</a>
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Communication.Style
    @interface Messaging {
    }

    /**
     * See <a href="http://microservices.io/patterns/communication-style/domain-specific.html">Domain specific protocol</a>
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Communication.Style
    @interface DomainSpecificProtocol {
    }

    @Retention(RetentionPolicy.SOURCE)
    @interface BEG_ExternalAPI {
    }

    /**
     * See <a href="http://microservices.io/patterns/apigateway.html">API Gateway</a>
     * http://microservices.io/i/apigateway.jpg
     * Applicability:
     * you're also using the Microservices pattern and need a single point of aggregation for your microservice calls
     *
     * See <a href="http://java-design-patterns.com/patterns/api-gateway">API Gateway</a>
     *
     * {@link DesignPattern#Problem}: How do the clients of a Microservices-based application access the individual services?
     * {@link DesignPattern#Forces}: ...
     * {@link DesignPattern#Solution}: Implement an API gateway that is the single entry point for all clients. The API gateway handles requests in one of two ways.
     * Some requests are simply proxied/routed to the appropriate service. It handles other requests by fanning out to multiple services.
     * The API Gateway is responsible for tasks such as load balancing, caching, access control, API metering, and monitoring
     *
     *
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Communication.ExternalAPI
    @GOF.Facade
    @interface APIGateway {
    }

    /**
     * See <a href="http://microservices.io/patterns/apigateway.html">Backend for front end</a>
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Communication.ExternalAPI
    @interface BackendForFrontEnd {
    }

    @Retention(RetentionPolicy.SOURCE)
    @interface BEG_ServiceDiscovery {
    }

    /**
     * See <a href="http://microservices.io/patterns/client-side-discovery.html">Client side discovery</a>
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Communication.ServiceDiscovery
    @interface ClientSideDiscovery {
    }

    /**
     * See <a href="http://microservices.io/patterns/server-side-discovery.html">Server side discovery</a>
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Communication.ServiceDiscovery
    @interface ServerSideDiscovery {
    }

    /**
     * See <a href="http://microservices.io/patterns/service-registry.html">Service registry</a>
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Communication.ServiceDiscovery
    @interface ServiceRegistry {
    }

    /**
     * See <a href="http://microservices.io/patterns/self-registration.html">Self registration</a>
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Communication.ServiceDiscovery
    @interface SelfRegistration {
    }

    /**
     * See <a href="http://microservices.io/patterns/3rd-party-registration.html">3ird party registration</a>
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Communication.ServiceDiscovery
    @interface ThirdPartyRegistration {
    }

    @Retention(RetentionPolicy.SOURCE)
    @interface BEG_Reliability {
    }

    /**
     * See <a href="http://microservices.io/patterns/reliability/circuit-breaker.html">Circuit breaker</a>
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Communication.Reliability
    @interface CircuitBreaker {
    }

    @Retention(RetentionPolicy.SOURCE)
    @interface BEG_DataManagement {
    }

    /**
     * See <a href="http://microservices.io/patterns/data/database-per-service.html">Database per service</a>
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Communication.DataManagement
    @interface DatabasePerService {
    }

    /**
     * See <a href="http://microservices.io/patterns/data/shared-database.html">Shared database</a>
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({})
    @Patterns.Communication.DataManagement
    @Related.Patterns(EIP.SharedDatabase.class)
    @interface SharedDatabase {
    }

    /**
     * See <a href="http://microservices.io/patterns/data/saga.html">Saga</a>
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Communication.DataManagement
    @interface Saga {
    }

    /**
     * See <a href="http://microservices.io/patterns/data/api-composition.html">API Composition</a>
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Communication.DataManagement
    @interface APIComposition {
    }

    /**
     * See <a href="http://microservices.io/patterns/data/cqrs.html">CQRS</a>
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({})
    @Patterns.Communication.DataManagement
    @Related.Patterns(FPEAA.CQRS.class)
    @interface CQRS {
    }

    /**
     * See <a href="http://microservices.io/patterns/data/event-sourcing.html">Event sourcing</a>
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Communication.DataManagement
    @interface EventSourcing  {
    }

    /**
     * See <a href="http://microservices.io/patterns/data/transaction-log-tailing.html">Transaction log tailing</a>
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Communication.DataManagement
    @interface TransactionLogTailing {
    }

    /**
     * See <a href="http://microservices.io/patterns/data/database-triggers.html">Database triggers</a>
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Communication.DataManagement
    @interface DatabaseTriggers {
    }

    @Retention(RetentionPolicy.SOURCE)
    @interface BEG_Security {
    }

    /**
     * See <a href="http://microservices.io/patterns/security/access-token.html">Access token</a>
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Communication.Security
    @interface AccessToken {
    }

    @Retention(RetentionPolicy.SOURCE)
    @interface BEG_Testing {
    }

    /**
     * See <a href="http://microservices.io/patterns/testing/service-component-test.html">Service component test</a>
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Communication.Testing
    @interface ServiceComponentTest {
    }

    /**
     * See <a href="http://microservices.io/patterns/testing/service-integration-contract-test.html">Service integration contract test</a>
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Communication.Testing
    @interface ServiceIntegrationContractTest {
    }

    @Retention(RetentionPolicy.SOURCE)
    @interface BEG_Observability {
    }

    /**
     * See <a href="http://microservices.io/patterns/observability/application-logging.html">Log aggregation</a>
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Communication.Observability
    @interface LogAggregation  {
    }

    /**
     * See <a href="http://microservices.io/patterns/observability/application-metrics.html">Application metrics</a>
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Communication.Observability
    @interface ApplicationMetrics  {
    }

    /**
     * See <a href="http://microservices.io/patterns/observability/audit-logging.html">Audit logging</a>
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Communication.Observability
    @interface AuditLogging  {
    }

    /**
     * See <a href="http://microservices.io/patterns/observability/distributed-tracing.html">Distributed tracing</a>
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Communication.Observability
    @interface DistributedTracing  {
    }

    /**
     * See <a href="http://microservices.io/patterns/observability/exception-tracking.html">Exception tracking</a>
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Communication.Observability
    @interface ExceptionTracking  {
    }

    /**
     * See <a href="http://microservices.io/patterns/observability/health-check-api.html">Health check API</a>
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Communication.Observability
    @interface HealthCheckAPI  {
    }

    /**
     * See <a href="http://microservices.io/patterns/observability/log-deployments-and-changes.html">Log deployments and changes</a>
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Communication.Observability
    @interface LogDeploymentsAndChanges  {
    }

    @Retention(RetentionPolicy.SOURCE)
    @interface BEG_UI {
    }

    /**
     * See <a href="http://microservices.io/patterns/ui/server-side-page-fragment-composition.html">Server-side page fragment composition</a>
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Communication.UI
    @interface ServerSidePageFragmentComposition {
    }

    /**
     * See <a href="http://microservices.io/patterns/ui/client-side-ui-composition.html">Client-side UI composition</a>
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Communication.UI
    @interface ClientSideUIComposition {
    }

    @Retention(RetentionPolicy.SOURCE)
    @interface BEG_arungupta {
    }

    /**
     * See <a href="http://blog.arungupta.me/microservice-design-patterns/">Aggregator Microservice Design Pattern</a>
     * See <a href="http://java-design-patterns.com/patterns/aggregator-microservices/">Aggregator MicroserviceArchitecture</a>
     * Applicability:
     * Use the Aggregator Microservices pattern when you need a unified API for various microservices, regardless the client device.
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @interface Aggregator {
    }

    /**
     * See <a href="http://blog.arungupta.me/microservice-design-patterns/">Proxy Microservice Design Pattern</a>
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @interface Proxy {
    }

    /**
     * See <a href="http://blog.arungupta.me/microservice-design-patterns/">Chained Microservice Design Pattern</a>
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @interface Chained {
    }

    /**
     * See <a href="http://blog.arungupta.me/microservice-design-patterns/">Branch Microservice Design Pattern</a>
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @interface Branch {
    }

    /**
     * See <a href="http://blog.arungupta.me/microservice-design-patterns/">Shared Data Microservice Design Pattern</a>
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @interface SharedData {
    }

    /**
     * See <a href="http://blog.arungupta.me/microservice-design-patterns/">Asynchronous Messaging Microservice Design Pattern</a>
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @interface AsynchronousMessaging {
    }

}
