package vlfsoft.patterns.enterprise.eip;

import vlfsoft.paradigms.ProgrammingParadigm;
import vlfsoft.patterns.GOF;
import vlfsoft.patterns.GOF.ChainOfResponsibility;
import vlfsoft.patterns.GOF.Observer;
import vlfsoft.patterns.VLFP;
import vlfsoft.patterns.design.DesignPattern;
import vlfsoft.patterns.enterprise.ddd.DDD;
import vlfsoft.patterns.enterprise.ddd.DDD.Layer;
import vlfsoft.patterns.enterprise.jee.JEE;
import vlfsoft.patterns.enterprise.microservices.Microservices;
import vlfsoft.patterns.enterprise.peaa.FPEAA;
import vlfsoft.patterns.enterprise.peaa.PEAA;
import vlfsoft.principles.generic.ComposabilityPrinciple;
import vlfsoft.tags.Related;

import java.lang.annotation.*;

import static vlfsoft.patterns.design.DesignPattern.Language;
import static vlfsoft.patterns.enterprise.ddd.DDD.*;

/**
 * See <a href="http://www.enterpriseintegrationpatterns.com/">Enterprise Integration Patterns</a>
 * <p>
 * See <a href="http://www.enterpriseintegrationpatterns.com/patterns/messaging/toc.html">Messaging Patterns</a>
 * Table with the list of Messaging patterns group by.
 * <p>
 * <p>
 */
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({})
public @interface EIP {

    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({})
    @interface Patterns {

        /**
         * See <a href="http://www.enterpriseintegrationpatterns.com/patterns/messaging/IntegrationStylesIntro.html">Introduction to Integration Styles</a>
         */
        @DesignPattern
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.ANNOTATION_TYPE})
        @interface IntegrationStyles {
        }

        /**
         * See <a href="http://www.enterpriseintegrationpatterns.com/patterns/messaging/MessagingComponentsIntro.html">Introduction to Messaging Systems</a>
         * Mediation. The messaging system acts as a mediator—as in the {@link GOF.Mediator} pattern
         * {@link GOF}—between all of the programs that can send and receive messages
         */
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.ANNOTATION_TYPE})
        @GOF.Mediator
        @interface MessagingSystems {
        }

        /**
         * See <a href="http://www.enterpriseintegrationpatterns.com/patterns/messaging/MessagingChannelsIntro.html">Messaging Channels</a>
         */
        @DesignPattern
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.ANNOTATION_TYPE})
        @interface MessagingChannels {
        }

        /**
         * See <a href="http://www.enterpriseintegrationpatterns.com/patterns/messaging/MessageConstructionIntro.html">Message Construction</a>
         */
        @DesignPattern
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.ANNOTATION_TYPE})
        @interface MessageConstruction {
        }

        /**
         * See <a href="http://www.enterpriseintegrationpatterns.com/patterns/messaging/MessageRoutingIntro.html">Message Routing</a>
         */
        @DesignPattern
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.ANNOTATION_TYPE})
        @interface MessageRouting {
        }

        /**
         * See <a href="http://www.enterpriseintegrationpatterns.com/patterns/messaging/index.html">Message Transformation</a>
         */
        @DesignPattern
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.ANNOTATION_TYPE})
        @interface MessageTransformation {
        }

        /**
         * See <a href="http://www.enterpriseintegrationpatterns.com/patterns/messaging/MessagingComponentsIntro.html">Introduction to Messaging Systems</a>
         * Rather, it must contain a layer of code that knows both how the application works and how the messaging system works, bridging the two so that they work together.
         * This bridge code is a set of coordinated Message Endpoints that enable the application to send and receive messages.
         * <p>
         * See <a href="http://www.enterpriseintegrationpatterns.com/patterns/messaging/MessagingEndpointsIntro.html">Messaging Endpoints</a>
         * An application does not have some built-in capability to interface with a messaging system.
         */
        @DesignPattern
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.ANNOTATION_TYPE, ElementType.FIELD})
        @interface MessagingEndpoints {
        }

        /**
         * See <a href="http://www.enterpriseintegrationpatterns.com/patterns/messaging/SystemManagementIntro.html">System Management</a>
         */
        @DesignPattern
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.ANNOTATION_TYPE})
        @interface SystemManagement {
        }

    }

    @Retention(RetentionPolicy.SOURCE)
    @interface BEG_IntegrationStyles {
    }

    /**
     * See <a href="http://www.enterpriseintegrationpatterns.com/patterns/messaging/FileTransferIntegration.html">File Transfer</a>
     * {@link Language.Form#Problem}: How can I integrate multiple applications so that they work together and can exchange information?
     * {@link Language.Form#Solution}: Have each application produce files containing information that other applications need to consume.
     * Integrators take the responsibility of transforming files into different formats.
     * Produce the files at regular intervals according to the nature of the business.
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE})
    @Patterns.IntegrationStyles
    @interface FileTransfer {
        boolean in();

        boolean out();

        /**
         * @return description of method to transfer files. It's possible to use one of the constants below.
         */
        Class by();

        /**
         * @return Name of the counterpart system.
         */
        Class with();

        @Retention(RetentionPolicy.SOURCE)
        @Target({})
        @interface ByEmail {
        }

        @Retention(RetentionPolicy.SOURCE)
        @Target({})
        @interface ByFTP {
        }
    }

    /**
     * See <a href="http://www.enterpriseintegrationpatterns.com/patterns/messaging/SharedDataBaseIntegration.html">Shared Database</a>
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE})
    @Patterns.IntegrationStyles
    @Related.Patterns(Microservices.SharedDatabase.class)
    @interface SharedDatabase {
        StorageType[] storage();

        enum StorageType {SharedDB, SharedFileSet, SharedMemory}
    }

    /**
     * See <a href="http://www.enterpriseintegrationpatterns.com/patterns/messaging/EncapsulatedSynchronousIntegration.html">Remote Procedure Invocation</a>
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.IntegrationStyles
    @interface RemoteProcedureInvocation {
    }

    /**
     * See <a href="http://www.enterpriseintegrationpatterns.com/patterns/messaging/Messaging.html">Messaging</a>
     * See <a href="http://www.enterpriseintegrationpatterns.com/patterns/messaging/Introduction.html">Messaging Patterns Introduction</a>
     * Specific benefits of messaging include:<ul>
     * <li> Complex programming model. Asynchronous messaging requires developers to work with an event-driven programming model {@link FPEAA.Patterns.EventDrivenArchitecture}.
     * <li> ...
     * <li> Thread Management. Asynchronous communication means that one application does not have to block {@link ProgrammingParadigm.Declarative.DataFlow.Reactive} while waiting for another application to perform a task, unless it wants to.
     * <li> ...
     * <ul/>
     * Many messaging vendors have incorporated some of this book’s patterns as features of their products, which simplifies applying the patterns and accelerates solution development.
     * See. the mapping table in <a href="http://www.enterpriseintegrationpatterns.com/patterns/messaging/Introduction.html">Messaging Patterns Introduction</a>
     * <p>
     * See <a href="http://www.enterpriseintegrationpatterns.com/patterns/messaging/index.html">Messaging Patterns Overview</a>
     * We have documented 65 messaging patterns, organized as follows: graphical diagram with group of patterns (basic elements of an integration solution).
     * <p>
     * <p>
     * See <a href="https://en.wikipedia.org/wiki/Messaging_pattern">Messaging pattern</a>
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.IntegrationStyles
    @ProgrammingParadigm.Declarative.DataFlow.Reactive
    @FPEAA.Patterns.EventDrivenArchitecture
    @interface Messaging {
    }

    @Retention(RetentionPolicy.SOURCE)
    @interface BEG_MessagingChannels {
    }

    /**
     * See <a href="http://www.enterpriseintegrationpatterns.com/patterns/messaging/MessageChannel.html">Message Channel</a>
     * See <a href="http://www.enterpriseintegrationpatterns.com/patterns/messaging/Introduction.html">Messaging Patterns Introduction</a>
     * Channels, also known as queues, are logical pathways that connect the programs and convey messages.
     */
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.FIELD, ElementType.METHOD})
    @DesignPattern(aka = "Message queue")
    @Patterns.MessagingSystems
    @Patterns.MessagingChannels
    @interface MessageChannel {
        /**
         * @return One or more of {@link PointToPoint}, {@link PublishSubscribe}, {@link Datatype}, {@link InvalidMessage}, {@link DeadLetter}, {@link GuaranteedDelivery}, {@link Hierarchical},
         * {@link Unidirectional}, {@link Bidirectional}
         */
        Class[] value();

        /**
         * See <a href="http://www.enterpriseintegrationpatterns.com/patterns/messaging/PointToPointChannel.html">Point-to-Point Channel</a>
         * {@link Language.Form#Problem}: How can the caller be sure that exactly one receiver will receive the document or perform the call?
         * {@link Language.Form#Solution}: Send the message on a Point-to-Point Channel, which ensures that only one receiver will receive a particular message.
         */
        @Retention(RetentionPolicy.SOURCE)
        @Target({})
        @interface PointToPoint {
        }

        /**
         * See <a href="http://java-design-patterns.com/patterns/publish-subscribe/">PublishSubscribe</a>
         * See <a href="http://www.enterpriseintegrationpatterns.com/patterns/messaging/PublishSubscribeChannel.html">Publish-Subscribe Channel</a>
         * {@link Language.Form#Problem}: How can the sender broadcast an event to all interested receivers?
         * {@link Language.Form#Solution}: Send the event on a Publish-Subscribe Channel, which delivers a copy of a particular event to each receiver.
         * {@link Language.Form#Intent}: A Publish-Subscribe Channel works like this: It has one input channel that splits into multiple output channels, one for each subscriber.
         * When an event is published into the channel, the Publish-Subscribe Channel delivers a copy of the message to each of the output channels.
         */
        @Retention(RetentionPolicy.SOURCE)
        @Target({})
        @interface PublishSubscribe {
        }

        /**
         * See <a href="http://www.enterpriseintegrationpatterns.com/patterns/messaging/DatatypeChannel.html">Datatype Channel</a>
         * {@link Language.Form#Problem}: How can the application send a data item such that the receiver will know how to process it?
         * {@link Language.Form#Solution}: Use a separate Datatype Channel for each data type, so that all data on a particular channel is of the same type.
         */
        @Retention(RetentionPolicy.SOURCE)
        @Target({})
        @interface Datatype {
        }

        /**
         * See <a href="http://java-design-patterns.com/patterns/message-channel/">Message Channel</a>
         * See <a href="http://www.enterpriseintegrationpatterns.com/patterns/messaging/InvalidMessageChannel.html">Invalid Message Channel</a>
         * {@link Language.Form#Problem}: How can a messaging receiver gracefully handle receiving a message that makes no sense?
         * {@link Language.Form#Solution}: The receiver should move the improper message to an Invalid Message Channel, a special channel for messages that could not be processed by their receivers.
         * A {@link InvalidMessage} {@link MessageChannel} is like an error log for messaging.
         * A similar but separate problem is when a message is structured properly, but its contents are semantically incorrect.
         * This is not a messaging error, but an application error. As such, while it may be tempting to move the message to the Invalid Message Channel,
         * there is nothing wrong with the message, so treating it as invalid is misleading.
         * If an error occurs while processing the message, the message is invalid and should be moved to the {@link InvalidMessage} {@link MessageChannel}.
         * If it occurs while the application processes the data from the message, that is an application error that has nothing to do with messaging.
         */
        @Retention(RetentionPolicy.SOURCE)
        @Target({})
        @interface InvalidMessage {
        }

        /**
         * See <a href="http://www.enterpriseintegrationpatterns.com/patterns/messaging/DeadLetterChannel.html">Dead Letter Channel</a>
         * {@link Language.Form#Problem}: What will the messaging system do with a message it cannot deliver?
         * {@link Language.Form#Solution}: When a messaging system determines that it cannot or should not deliver a message, it may elect to move the message to a Dead Letter Channel.
         * A similar concept implemented by many messaging systems is a Dead Letter Channel.
         * Whereas an Invalid Message Channel is for messages that can be delivered and received but not processed,
         * a {@link DeadLetter} {@link MessageChannel} is for messages that the messaging system cannot deliver properly.
         */
        @Retention(RetentionPolicy.SOURCE)
        @Target({})
        @interface DeadLetter {
        }

        /**
         * See <a href="http://www.enterpriseintegrationpatterns.com/patterns/messaging/GuaranteedMessaging.html">Guaranteed Delivery</a>
         * {@link Language.Form#Problem}: How can the sender make sure that a message will be delivered, even if the messaging system fails?
         * {@link Language.Form#Solution}: Use Guaranteed Delivery to make messages persistent so that they are not lost even if the messaging system crashes.
         */
        @Retention(RetentionPolicy.SOURCE)
        @Target({})
        @interface GuaranteedDelivery {
        }

        /**
         * Another exception is messaging system implementations that support hierarchical channels.
         * A receiver can subscribe to a parent in the hierarchy, then a sender can publish to a new child
         * channel the receiver knows nothing about, and the subscriber will still receive the message.
         */
        @Retention(RetentionPolicy.SOURCE)
        @Target({})
        @interface Hierarchical {
        }

        /**
         * Wildcard Subscribers:
         * Many messaging systems allow subscribers to {@link PublishSubscribe} {@link MessageChannel}s to specify special wild card characters.
         * This is a powerful technique to allow subscribers to subscribe to multiple channels at once.
         */
        @Retention(RetentionPolicy.SOURCE)
        @Target({})
        @interface Wildacard {
        }

        @Retention(RetentionPolicy.SOURCE)
        @Target({})
        @interface Unidirectional {
        }

        @Retention(RetentionPolicy.SOURCE)
        @Target({})
        @interface Bidirectional {
        }

        /**
         * {@link Language.Form#Problem}: A reply channel for each Observer can lead to an explosion of channels.
         * Such a large number of channels may be managable, but the messaging system administrator does not know how many static channels to create when the number of Observers needing to use these channels changes
         * dynamically at runtime.
         * Even if there are enough channels for all of the Observers, how does each Observer know which channel to use?
         * {@link Language.Form#Solution}:  An [GOF.Observer] can create a temporary queue, just for its own use, specify that as the Return Address in its request, and wait for the reply on that queue.
         * Creating new queues frequently can be inefficient, depending on your messaging system's implementation, and temporary queues cannot be persistent (for use with Guaranteed Delivery).
         * However, if you don't want to use the push model, you can implement the pull model using temporary queues.
         */
        @Retention(RetentionPolicy.SOURCE)
        @Target({})
        @interface Temporary {
        }
    }

    /**
     * See <a href="http://www.enterpriseintegrationpatterns.com/patterns/messaging/ChannelAdapter.html">Channel Adapter</a>
     * {@link Language.Form#Problem}: How can you connect an application to the messaging system so that it can send and receive messages?
     * Non-messaging clients — What if an application cannot connect to a messaging system but still wants to participate in messaging?
     * {@link Language.Form#Solution}: Use a Channel Adapter that can access the application's API or data and publish messages on a channel based on this data,
     * and that likewise can receive messages and invoke functionality inside the application.
     * {@link ChannelAdapter} is not part of an application code. In the application code use {@link MessageEndpoint.MessagingGateway} instead.
     * Therefore, most {@link ChannelAdapter}s require the combination with a {@link MessageTranslator} to convert the
     * application-specific message into a message format that complies with the {@link CanonicalDataModel}.
     * <p>
     * {@link ChannelAdapter}s can often times run on a different computer than the application or the database itself.
     * The {@link ChannelAdapter} can the connect to the application logic or the database via protocols such as HTTP or ODBC.
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.METHOD})
    @Patterns.MessagingChannels
    @Related.Patterns(MessageEndpoint.class)
    @interface ChannelAdapter {
        /**
         * A {@link ChannelAdapter} can connect to Different {@link Layer}s of an Application, via protocols such as HTTP, ODBC, ...
         * <p>
         * {@link JEE.Patterns.Core.PresentationTier}.class,
         * {@link JEE.Patterns.Core.BusinessTier}.class,
         * {@link JEE.Patterns.Core.IntegrationTier}.class,
         * {@link PEAA.ServiceLayer}.class
         *
         * @return One of {@link UserInterfaceAdapter}, {@link BusinessLogicAdapter}, {@link DatabaseAdapter}, {@link MetadataAdapter}, {@link MessagingBridge}
         */
        Class connectTo();

    }

    /**
     * Sometimes disparagingly called "screen scraping," these ddd of adapters can be very effective in many situations.
     */
    @Retention(RetentionPolicy.SOURCE)
    @Target({})
    @interface UserInterfaceAdapter {
    }

    /**
     * Most business applications expose their core functions as an API.
     */
    @Retention(RetentionPolicy.SOURCE)
    @Target({})
    @interface BusinessLogicAdapter {
    }

    /**
     * Most business applications persist their data inside a relational database
     * Since the information is already in the database, {@link ChannelAdapter} can extract information directly from the database
     * without the application ever noticing, which is very non-intrusive
     */
    @Retention(RetentionPolicy.SOURCE)
    @Target({})
    @interface DatabaseAdapter {
    }

    /**
     * An interesting variation of the {@link ChannelAdapter} is the {@link MetadataAdapter}, sometimes called DesignTimeAdapter.
     * This type of data does not invoke application functions,
     * but extracts metadata, data that describes the internal data formats of the application
     */
    @DesignPattern(aka = "DesignTimeAdapter")
    @Retention(RetentionPolicy.SOURCE)
    @Target({})
    @interface MetadataAdapter {
    }

    /**
     * See <a href="http://www.enterpriseintegrationpatterns.com/patterns/messaging/MessagingBridge.html">Messaging Bridge</a>
     * {@link Language.Form#Problem}: How can multiple messaging systems be connected so that messages available on one are also available on the others?
     * {@link Language.Form#Solution}: Use a Messaging Bridge, a connection between messaging systems, to replicate messages between systems.
     * A special form of the {@link ChannelAdapter} is the {@link MessagingBridge}. The {@link MessagingBridge} connects the messaging system to another messaging system as opposed to a specific application.
     * You may need to implement the {@link MessagingBridge} for your enterprise yourself. The bridge is a specialized {@link MessageEndpoint} application that is a client of both messaging systems.
     */
    @Retention(RetentionPolicy.SOURCE)
    @Target({})
    @interface MessagingBridge {
    }

    /**
     * See <a href="http://www.enterpriseintegrationpatterns.com/patterns/messaging/MessageBus.html">Message bus</a>
     * {@link Language.Form#Problem}: What is an architecture that enables separate applications to work together, but in a decoupled fashion such that applications can be easily added or removed without affecting the others?
     * {@link Language.Form#Solution}: Structure the connecting middleware between these applications as a {@link MessageBus} that enables them to work together using messaging.
     * A well designed set of channels forms a {@link MessageBus} that acts like a messaging API for a whole group of applications.
     * A {@link MessageBus} is a combination of a common data model {@link CanonicalDataModel}, a common command set {@link Message}{@link Message.Command},
     * and a messaging infrastructure {@link MessageRouter.MessageBroker} to allow different systems to communicate through a shared set of interfaces.
     * <p>
     * In our EAI example, a {@link MessageBus} could serve as a universal connector between the various insurance systems, and as a universal interface for client applications that wish to connect to the insurance systems.
     * <p>
     * {@link Language.Form#Intent}: A {@link MessageBus} forms a simple, useful service-oriented architecture for an enterprise.
     * Each service has at least one request channel that accepts requests of an agreed-upon format, and probably a corresponsing reply channel that supports a specified reply format.
     * Any participant application can make use of these services by making requests and waiting for replies. The request channels, in effect, act as a directory of the services available.
     * A {@link MessageBus} requires that all of the applications using the bus use the same {@link CanonicalDataModel}.
     * Applications adding messages to the bus may need to depend on {@link MessageRouter}s to route the messages to the appropriate final destinations.
     * Applications not designed to interface with a messaging system may require Channel Adapters and Service Activators.
     * <p>
     * <p>
     * See <a href="https://en.wikipedia.org/wiki/Message_queue">Message queue</a>
     * See <a href="http://stackoverflow.com/questions/7793927/message-queue-vs-message-bus-what-are-the-differences">Message Queue vs Message Bus — what are the differences?</a>
     * <p>
     * See <a href="http://java-design-patterns.com/patterns/data-bus/">Data Bus</a>
     * Intent:
     * Allows send of messages/events between components of an application without them needing to know about each other.
     * They only need to know about the type of the message/event being sent.
     * <p>
     * {@link Related.Patterns}: GOF.Mediator.class,
     * GOF.Observer.class,
     * IntegrationPattern.PublishSubscribe.class
     * <p>
     * See <a href="https://en.wikipedia.org/wiki/Message_queue">Message queue</a>
     */
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.MessagingChannels
    @DesignPattern.Architectural
    @DesignPattern(aka = {"Data Bus", "Event Bus"})
    @interface MessageBus {
    }

    @Retention(RetentionPolicy.SOURCE)
    @interface BEG_MessageConstruction {
    }

    /**
     * See <a href="http://www.enterpriseintegrationpatterns.com/patterns/messaging/Message.html">Message</a>
     * {@link Language.Form#Problem}:
     * {@link Language.Form#Solution}:
     * A message actually contains two parts, a header and a body.
     * The {@link Header} contains meta-information about the message—who sent it, where it’s going, etc.;
     * this information is used by the messaging system and is mostly (but not always) ignored by the applications using the messages.
     * The {@link Body} contains the data being transmitted and is ignored by the messaging system.
     * In conversation, when an application developer who is using messaging talks about a message, he’s usually referring to the data in the body of the message.
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.FIELD})
    @Patterns.MessagingSystems
    @Patterns.MessageConstruction
    @interface Message {
        /**
         * @return One or more of {@link Command}, {@link Document}, {@link Event}, {@link RequestReply.Request}, {@link RequestReply.Reply}
         */
        Class[] value();

        @DesignPattern
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.FIELD})
        @interface Identifier {
        }

        @DesignPattern
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.FIELD})
        @interface Header {
            @DesignPattern
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.FIELD})
            @interface Component {
            }
        }

        @DesignPattern
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.ANNOTATION_TYPE, ElementType.FIELD})
        @interface Body {
        }

        /**
         * See <a href="http://www.enterpriseintegrationpatterns.com/patterns/messaging/ReturnAddress.html">Return Address</a>
         * {@link Language.Form#Problem}: How does a replier know where to send the reply?
         * {@link Language.Form#Solution}: The request message should contain a Return Address that indicates where to send the reply message.
         * <p>
         * This way, the replier does not need to know where to send the reply, it can just ask the request. If different messages to the same replier require replies to different places,
         * the replier knows where to send the reply for each request. This encapsulates the knowledge of what channels to use for requests and replies within the requestor so those decisions do not have to be hard coded within the replier.
         * A Return Address is put in the {@link Message.Header} of a message because it’s not part of the data being transmitted.
         * Each receiver could automatically know which channel to send replies on, but hard coding such assumptions makes the software less flexible and more difficult to maintain.
         * Furthermore, a single replier could be processing calls from several different requestors, so the reply channel is not the same for every message; it depends on what requestor sent the request message.
         * <p>
         * A requestor potentially may not want a reply sent back to itself. Rather, it may have an associated callback processor to process replies, and the callback processor may monitor a different channel than the requestor does (or the requestor may not monitor any channels at all).
         * The requestor could have multiple callback processors such that replies for different requests from the same requestor should be sent to different processors.
         * <p>
         * This way, the replier does not need to know where to send the reply, it can just ask the request.
         * If different messages to the same replier require replies to different places, the replier knows where to send the reply for each request. This encapsulates the knowledge of what channels to use for
         * requests and replies within the requestor so those decisions do not have to be hard coded within the replier. A Return Address is put in the header of a message because it’s not part of the data being transmitted.
         * <p>
         * When the reply is sent back the channel indicated by the Return Address, it may also need a {@link CorrelationIdentifier}. The Return Address tells the receiver what channel to put the reply message on; the correlation identifier tells the sender which request a reply is for.
         */
        @DesignPattern
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.FIELD})
        @Patterns.MessageConstruction
        @interface ReturnAddress {
        }

        /**
         * See <a href="http://www.enterpriseintegrationpatterns.com/patterns/messaging/CorrelationIdentifier.html">Correlation Identifier</a>
         * Each {@link Message}({@link RequestReply.Reply}) should contain a {@link CorrelationIdentifier}, a unique identifier that indicates which {@link Message}({@link RequestReply.Reply}) this reply is for.
         * {@link Language.Form#Problem}: How does a requestor that has received a reply know which {@link RequestReply.Request} this is the {@link RequestReply.Reply} for?
         * {@link Language.Form#Solution}: Each reply message should contain a Correlation Identifier, a unique identifier that indicates which request message this reply is for.
         * <p>
         * There are six parts to Correlation Identifier:
         * 1. Requestor — An application that performs a business task by sending a request and
         * waiting for a reply.
         * 2. Replier — Another application that receives the request, fulfills it, then sends the reply. It
         * gets the request ID from the request and stores it as the correlation ID in the reply.
         * 3. Request — A Message sent from the requestor to the replier containing a request ID.
         * 4. Reply — A Message sent from the replier to the requestor containing a correlation ID.
         * 5. Request ID — A token in the request that uniquely identifies the request.
         * 6. Correlation ID — A token in the reply that has the same value as the request ID in the
         * request.
         * A correlation ID (and also the request ID) is usually put in the header of a message rather than the body.
         * <p>
         * Messages have separate message ID and correlation ID properties so that request-reply message pairs can be chained.
         */
        @Related.Patterns({RemoteProcedureInvocation.class, Message.class/*, AsSelectiveConsumer*/, /*AsMessageSequence,*/ RequestReply.class/*, AsReturnAddress*/})
        @DesignPattern
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.FIELD})
        @Patterns.MessageConstruction
        @interface CorrelationIdentifier {
        }

        /**
         * See <a href="http://www.enterpriseintegrationpatterns.com/patterns/messaging/MessageExpiration.html">Message Expiration</a>
         * {@link Language.Form#Problem}: How can a sender indicate when a message should be considered stale and thus shouldn’t be processed?
         * {@link Language.Form#Solution}: Set the Message Expiration to specify a time limit how long the message is viable.
         * A Message Expiration is a timestamp (date and time) that specifies how long the message will live or when it will expire. The setting can be specified in relative or absolute terms.
         * <p>
         * Once the time for which a message is viable passes, and the message still has not been consumed, then the message will expire. The messaging system’s consumers will ignore an expired message;
         * they treat the message as if it where never sent in the first place. Most messaging system implementations reroute expired messages to the Dead Letter Channel, while others simply discard expired messages; this may be configurable.
         * When a message expires, the messaging system may simply discard it or may move it to a Dead Letter Channel. A receiver that finds itself in possession of an expired message should move it to the Invalid Message Channel.
         */
        @DesignPattern
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.FIELD})
        @Patterns.MessageConstruction
        @interface Expiration {
        }

        /**
         * See <a href="http://www.enterpriseintegrationpatterns.com/patterns/messaging/FormatIndicator.html">Format Indicator</a>
         * {@link Language.Form#Problem}: How can a message’s data format be designed to allow for possible future changes?
         * {@link Language.Form#Solution}: Design a data format that includes a Format Indicator, so that the message specifies what format it is using.
         * There are three main alternatives for implementing a format indicator:
         * 1. Version Number – A number or string that that uniquely identifies the format. Both the sender and receiver must agree on which format is designated by a particular indicator.
         * 2. Foreign Key – A unique ID—such as a filename, a database row key, a home primary key, or an Internet URL—that specifies a format document.
         * The sender and receiver must agree on the mapping of keys to documents, and the format of the schema document.
         * 3. Format Document – A schema that describes the data format. The schema document does not have to be retrieved via a foreign key or inferred from a version number,
         * it is embedded in the message. The sender and the receiver must agree on the format of the schema.
         */
        @DesignPattern
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.FIELD})
        @Patterns.MessageConstruction
        @interface FormatIndicator {
        }

        /**
         * See <a href="http://www.enterpriseintegrationpatterns.com/patterns/messaging/CommandMessage.html">Command Message</a>
         * {@link Language.Form#Problem}: How can messaging be used to invoke a procedure in another application?
         * {@link Language.Form#Solution}: Use a Command Message to reliably invoke a procedure in another application.
         * Command Messages are usually sent on a {@link MessageChannel.PointToPoint} so that each command will only be consumed and invoked once.
         */
        @Related.Patterns(GOF.Command.class)
        @DesignPattern
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({})
        @Patterns.MessageConstruction
        @interface Command {
        }

        /**
         * See <a href="http://www.enterpriseintegrationpatterns.com/patterns/messaging/DocumentMessage.html">Document Message</a>
         * {@link Language.Form#Problem}: How can messaging be used to transfer data between applications?
         * {@link Language.Form#Solution}: Use a Document Message to reliably transfer a data structure between applications.
         * {@link Document} {@link Message}s can seem very much like {@link Event}{@link Message}s; the main difference is a matter of timing and content.
         * The important part of a {@link Document} {@link Message} is its content, the document.
         * Successfully transferring the document is important; the timing of when it is sent and received is less important.
         */
        @DesignPattern
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({})
        @Patterns.MessageConstruction
        @interface Document {
        }

        /**
         * See <a href="http://www.enterpriseintegrationpatterns.com/patterns/messaging/EventMessage.html">Event Message</a>
         * {@link Language.Form#Problem}: How can messaging be used to transmit events from one application to another?
         * {@link Language.Form#Solution}: Use an Event Message for reliable, asynchronous event notification between applications.
         * An {@link Event} {@link Message} is usually sent on a {@link MessageChannel.PublishSubscribe} because multiple dependents are often interested in an event.
         * If notifications should be acknowledged by the subscribers, use {@link RequestReply}, where the notification {@link Event} is the {@link RequestReply.Request} and the acknowledgement is the {@link RequestReply.Reply}.
         * The difference between an Event Message and a Document Message is a matter of timing and content.
         * An event’s contents is typically less important. Many events are empty; their mere occurrance tells the observer to react.
         * An event’s timing is very important; the subject should issue an event as soon as a change occurs, and the observer should process it quickly while it’s still relevant.
         * Guaranteed Delivery is usually not very helpful with events because they’re frequent and need to be delivered quickly.
         * Message Expiration can be very helpful to make sure that an event is processed quickly or not at all.
         */
        @Related.Patterns(Observer.class)
        @DesignPattern(aka = "Notification")
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({})
        @Patterns.MessageConstruction
        @interface Event {
        }

        /**
         * See <a href="http://www.enterpriseintegrationpatterns.com/patterns/messaging/RequestReply.html">Request-Reply</a>
         * Use @{@link Message}({@link RequestReply.Request}, {@link RequestReply.Reply}) instead of {@link RequestReply}
         * {@link Language.Form#Problem}: When an application sends a message, how can it get a response from the receiver?
         * {@link Language.Form#Solution}: Send a pair of Request-Reply messages, each on its own channel.
         * When a caller performs a Remote Procedure Invocation, the caller's thread must block while it waits for the response.
         * With Request-Reply, the requestor has two approaches for receiving the reply:
         * {@link RequestReply.SynchronousBlock} – A single thread in the caller sends the request message, blocks (as a Polling Consumer)
         * to wait for the reply message, then processes the reply. This is simple to implement, but if the requestor crashes, it will have difficulty re-establishing the blocked thread.
         * The request thread awaiting the response implies that there is only one outstanding request, or that the reply channel for this request is private for this thread.
         * {@link RequestReply.AsynchronousCallback} - One thread in the caller sends the request message and sets up a callback for the reply. A separate thread listens for reply messages.
         * When a reply message arrives, the reply thread invokes the appropriate callback, which re-establishes the caller's context and processes the reply.
         * This approach enables multiple outstanding requests to share a single reply channel, and a single reply thread to process replies for multiple request threads.
         * If the requestor crashes, it can recover by simply restarting the reply thread.
         * An added complexity, however, is the callback mechanism that must re-establish the caller's context.
         * {@link RequestReply.MessagingRPC} -  This is how to implement Remote Procedure Invocation using messaging.
         * The request is a Command Message that describes the function the replier should invoke. The reply is a Document Message that contains the function's return value or exception.
         * {@link RequestReply.MessagingQuery} - This is how to perform a remote query using messaging. The request is a Command Message containing the query, and the reply is the results of the query, perhaps a Message Sequence.
         * {@link RequestReply.NotifyAcknowledge} - This provides for event notfication with acknowledgement using messaging. The request is an Event Message that provides notification and the reply is a Document Message
         * acknowledging the notification. The acknowledgement may itself be another request, one seeking details about the event.
         * The request is like a method call. As such, the reply is one of three possibilities:
         * {@link RequestReply.VoidReply} – Simply notifies the caller that the method has finished so that the caller can proceed.
         * {@link RequestReply.ResultValue} – A single object that is the method's return value.
         * {@link RequestReply.ExceptionReply} – A single exception object indicating that the method aborted before completing successfully, and indicating why.
         */
        @DesignPattern
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({})
        @Patterns.MessageConstruction
        @Message({RequestReply.Request.class, RequestReply.Reply.class})
        @interface RequestReply {
            @Retention(RetentionPolicy.SOURCE)
            @Target({})
            @interface Request {
            }

            @Retention(RetentionPolicy.SOURCE)
            @Target({})
            @interface Reply {
            }

            @Retention(RetentionPolicy.SOURCE)
            @Target({})
            @interface SynchronousBlock {
            }

            @Retention(RetentionPolicy.SOURCE)
            @Target({})
            @interface AsynchronousCallback {
            }

            @Retention(RetentionPolicy.SOURCE)
            @Target({})
            @interface MessagingRPC {
            }

            @Retention(RetentionPolicy.SOURCE)
            @Target({})
            @interface MessagingQuery {
            }

            @Retention(RetentionPolicy.SOURCE)
            @Target({})
            @interface NotifyAcknowledge {
            }

            @Retention(RetentionPolicy.SOURCE)
            @Target({})
            @interface VoidReply {
            }

            @Retention(RetentionPolicy.SOURCE)
            @Target({})
            @interface ResultValue {
            }

            @Retention(RetentionPolicy.SOURCE)
            @Target({})
            @interface ExceptionReply {
            }
        }
    }

    /**
     * For distributed notification between applications, the {@link MessageChannel.PublishSubscribe} (e.g., messaging) approach has several advantages over the traditional,
     * synchronous (e.g., RPC) approach of implementing {@link Observer}:
     * ...
     * So as you can see, the {@link Model.Pull} is more complex than the {@link Model.Push}. It requires more {@link MessageChannel}s (including a {@link MessageChannel.Temporary} one for every observer),
     * it requires more messages (three messages per update per interested observer instead of one message for all observers), the subject and observer classes require more code to manage the additional messaging,
     * and the objects at runtime require more threads to execute the additional messaging. If all of this is acceptable in your application, then the pull model is a viable approach.
     * However, if in doubt, you should probably start with the push model because it is simpler.
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({})
    @Patterns.MessageConstruction
    @interface Model {
        /**
         * The message is a combined document/event message; the message’s delivery announces that the state has occurred and the message’s contents are the new state.
         * This is more efficient if all observers want these details, but otherwise can be the worst of both worlds: A large message that is sent frequently and often ignored by many observers.
         */
        @DesignPattern
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({})
        @Patterns.MessageConstruction
        @Message({Message.Document.class, Message.Event.class})
        @interface Push {
        }

        /**
         * There are three messages:
         * {@link Model.Pull.Update} – An {@link Message.Event} that notifies the observer of the event.
         * {@link Model.Pull.StateRequest} – A {@link Message.Command} an interested observer uses to request details from the subject.
         * {@link Model.Pull.StateReply} – A {@link Message.Document} the subject uses to send the details to the observer.
         * The advantage of the pull model is that the update messages are small, only interested observers request details,
         * and potentially each interested observer can request the details it specifically is interested in.
         * The disadvantage is the channels needed and traffic caused by three messages instead of one.
         */
        @DesignPattern
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({})
        @Patterns.MessageConstruction
        @interface Pull {
            @Retention(RetentionPolicy.SOURCE)
            @Target({})
            @interface Update {
            }

            @Retention(RetentionPolicy.SOURCE)
            @Target({})
            @interface StateRequest {
            }

            @Retention(RetentionPolicy.SOURCE)
            @Target({})
            @interface StateReply {
            }
        }
    }


    /**
     * See <a href="http://www.enterpriseintegrationpatterns.com/patterns/messaging/MessageSequence.html">Message Sequence</a>
     * {@link Language.Form#Problem}: How can messaging transmit an arbitrarily large amount of data?
     * {@link Language.Form#Solution}: Whenever a large set of data may need to be broken into message-size chunks, send the data as a Message Sequence and mark each message with sequence identification fields.
     * The three Message Sequence identification fields are:
     * 1. {@link SequenceIdentifier} – Distinguishes this cluster of messages from others.
     * 2. {@link PositionIdentifier} – Uniquely identifies and sequentially orders each message in a sequence.
     * 3. {@link SizeOrEndIndicator} – Specifies the number of messages in the cluster
     * When the Message Sequence is the reply message in a Request-Reply, the sequence identifier and the Correlation Identifier are usually the same thing.
     * They would be separate if the application sending the request expected multiple responses to the same request and one or more of the responses could be in multiple parts.
     * When only one response is expected, then uniquely identifying the response and its sequence is permissible, but redundant.
     * <p>
     * An alternative to Message Sequence is to use a {@link MessageTranslator.ClaimCheck}. Rather than transmitting a large document between two applications, if the applications both have access to a common database
     * or file system, store the document and just transmit the receipt in a single message.
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.MessageConstruction
    @interface MessageSequence {

        @DesignPattern(aka = "Sequence Number")
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.ANNOTATION_TYPE, ElementType.FIELD})
        @Patterns.MessageConstruction
        @interface SequenceIdentifier {
        }

        @DesignPattern
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.ANNOTATION_TYPE, ElementType.FIELD})
        @Patterns.MessageConstruction
        @interface PositionIdentifier {
        }

        @DesignPattern
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.ANNOTATION_TYPE, ElementType.FIELD})
        @Patterns.MessageConstruction
        @interface SizeOrEndIndicator {
        }

    }

    @Retention(RetentionPolicy.SOURCE)
    @interface BEG_MessageRouting {
    }

    /**
     * See <a href="http://www.enterpriseintegrationpatterns.com/patterns/messaging/PipesAndFilters.html">Pipes and Filters</a>
     * {@link Language.Form#Problem}: How can we perform complex processing on a message while maintaining independence and flexibility?
     * {@link Language.Form#Solution}: Use the Pipes and Filters architectural style to divide a larger processing task into a sequence of smaller, independent processing steps (Filters) that are connected by channels (Pipes).
     */
    @DesignPattern.Architectural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.MessagingSystems
    @Patterns.MessageRouting
    @Patterns.IntegrationStyles
    @ComposabilityPrinciple(true)
    @interface PipesAndFilters {
    }

    /**
     *
     */
    @DesignPattern.Architectural
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.MessagingSystems
    @Patterns.MessageRouting
    @Patterns.IntegrationStyles
    @ComposabilityPrinciple(true)
    @interface HubAndSpoke {
    }

    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({})
    @Patterns.MessagingSystems
    @Patterns.MessageRouting
    @interface RoutingModel {
        /**
         * {@link MessageRouter.ContentBasedRouter} is a frequently used form of the more generic Message Router. It uses predictive routing, i.e. it incorporates knowledge of the capabilities of all other systems.
         * This makes for efficient routing because each outgoing message is sent directly to the correct system. The downside is that the Content-Based Router has to have knowledge of all possible recipients and
         * their capabilities. As recipients are added, removed or changed, the Content-Based Router has to be changed every time. This can become a maintenance nightmare.
         */
        @DesignPattern
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.ANNOTATION_TYPE})
        @Patterns.MessagingSystems
        @Patterns.MessageRouting
        @interface PredictiveRouting {
        }

        /**
         * We can avoid the dependency of the {@link MessageRouter.ContentBasedRouter} on the individual recipients if the recipients assume more control over the routing process. These options can be summarized as
         * reactive filtering because they allow each participant to filter relevant messages as they come by. The distribution of routing control eliminates the need for a Content-Based Router but the solution
         * is generally less efficient. These solutions and associated trade-offs are described in more detail in the {@link MessageRouter.ContentBasedRouter.MessageFilter} and {@link MessageRouter.RoutingSlip}.
         */
        @DesignPattern
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.ANNOTATION_TYPE})
        @Patterns.MessagingSystems
        @Patterns.MessageRouting
        @interface ReactiveFiltering {
        }
    }


    /**
     * See <a href="http://www.enterpriseintegrationpatterns.com/patterns/messaging/MessageRouter.html">Message Router</a>
     * {@link Language.Form#Problem}: How can you decouple individual processing steps so that messages can be passed to different filters depending on a set of conditions?
     * {@link Language.Form#Solution}: Insert a special filter, a Message Router, which consumes a Message from one Message Channel and republishes it to a different Message Channel channel depending on a set of conditions.
     * <p>
     * Therefore, we can categorize the Message Routing patterns into the following groups:
     * {@link Group.Simple} Routers are variants of the Message Router and route messages from one inbound channel to one or more outbound channels.
     * {@link Group.Composed} Routers combine multiple simple routers to create more complex message flows.
     * {@link Group.Architectural} Patterns describe architectural styles based on Message Routers.
     * <p>
     * We should also try to minimize message traffic. For example we could route the order message through one inventory system after the other. The first system that can accept the order consumes
     * the message and processes the order. If it cannot process the order it passes the order message to the next system.
     * This approach is similar to the {@link ChainOfResponsibility} described in [GoF]. However, in the world of message-based integration passing messages through a chain of systems could mean significant overhead.
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.MessagingSystems
    @Patterns.MessageRouting
    @interface MessageRouter {

        /**
         * any router can be implemented as a dynamic variant.
         *
         * @return {} or {@link Dynamic}, {@link Static}, {@link ContentBasedRouter}, {@link RecipientList}, {@link Splitter}, {@link Aggregator},
         * {@link Resequencer}, {@link ComposedMessageProcessor}, {@link ScatterGather}, {@link RoutingSlip}, {@link RoutingSlip}, {@link ProcessManager}, {@link MessageBroker}
         */
        Class[] value();

        /**
         * See <a href="http://www.enterpriseintegrationpatterns.com/patterns/messaging/DynamicRouter.html">Dynamic Router</a>
         * {@link Language.Form#Problem}: How can you avoid the dependency of the router on all possible destinations while maintaining its efficiency?
         * {@link Language.Form#Solution}: Use a Dynamic Router, a Router that can self-configure based on special configuration messages from participating destinations.
         * <p>
         * any router can be implemented as a dynamic variant.
         */
        @DesignPattern
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({})
        @Patterns.MessageRouting
        @Group.Simple
        @Stateless
        @interface Dynamic {
        }

        /**
         * Opposite to {@link Dynamic}
         */
        @DesignPattern
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({})
        @Patterns.MessageRouting
        @interface Static {
        }

        /**
         * Therefore, we can categorize the Message Routing patterns into the following groups:
         * {@link Simple} Routers are variants of the Message Router and route messages from one inbound channel to one or more outbound channels.
         * {@link Composed} Routers combine multiple simple routers to create more complex message flows.
         * {@link Architectural} Patterns describe architectural styles based on Message Routers.
         */
        @DesignPattern
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({})
        @Patterns.MessagingSystems
        @Patterns.MessageRouting
        @interface Group {
            @DesignPattern
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.ANNOTATION_TYPE})
            @Patterns.MessagingSystems
            @Patterns.MessageRouting
            @interface Simple {
            }

            @DesignPattern
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.ANNOTATION_TYPE})
            @Patterns.MessagingSystems
            @Patterns.MessageRouting
            @interface Composed {
            }

            @DesignPattern
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.ANNOTATION_TYPE})
            @Patterns.MessagingSystems
            @Patterns.MessageRouting
            @interface Architectural {
            }
        }

        /**
         * See <a href="http://www.enterpriseintegrationpatterns.com/patterns/messaging/ContentBasedRouter.html">Content-Based Router</a>
         * {@link Language.Form#Problem}: How do we handle a situation where the implementation of a single logical function (e.g., inventory check) is spread across multiple physical systems?
         * {@link Language.Form#Solution}: Use a Content-Based Router to route each message to the correct recipient based on message content.
         * The Content-Based Router inspects the content of a message and routes it to another channel based on the content of the message.
         * Using such a router enables the message producer to send messages to a single channel and leave it to the Content-Based Router to inspect messages and route them to the proper destination.
         * Equivalent behavior can be achieved by using a Publish-Subscribe Channel and an array of Message Filters, one for each potential recipient. Each Message Filter eliminates the messages that to not match
         * the criteria for the specific destination.
         * <p>
         * The following table characterizes some of the differences between the solutions: Content-Based Router | Pub-Sub Channel with Message Filter
         * ...
         * The following table compares the two solutions: Recipient List vs. MessageFilter Array
         * ...
         */
        @DesignPattern
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.ANNOTATION_TYPE})
        @Patterns.MessageRouting
        @Group.Simple
        @Stateless
        @RoutingModel.PredictiveRouting
        @interface ContentBasedRouter {
            /**
             * any router can be implemented as a dynamic variant.
             *
             * @return {} or {@link Dynamic}.class
             */
            Class[] value();

            /**
             * See <a href="http://www.enterpriseintegrationpatterns.com/patterns/messaging/Filter.html">Message Filter</a>
             * {@link Language.Form#Problem}: How can a component avoid receiving uninteresting messages?
             * {@link Language.Form#Solution}: Use a special kind of Message Router, a Message Filter, to eliminate undesired messages from a channel based on a set of criteria.
             * A Message Filter is a special form of a Content-Based Router. It examines the message content and passes the message to another channel if the message content matches certain criteria.
             * Otherwise, it discards the message.
             * The Message Filter can be portrayed as a special case of a Content-Based Router that routes the message either to the output channel or the null channel, a channel that discards any message
             * published to it. Such a channel would be similar to /dev/null present in many operating systems or the Null Object.
             * We can use use a broadcast channel that routes a message to a set of Message Filters who eliminate unwanted messages to implement functionality equivalent to that of a Content-Based Router.
             */
            @DesignPattern
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.ANNOTATION_TYPE})
            @Patterns.MessageRouting
            @Stateless
            @Stateful
            @RoutingModel.ReactiveFiltering
            @interface MessageFilter {
                /**
                 * any router can be implemented as a dynamic variant.
                 *
                 * @return {} or {@link Dynamic}.class
                 */
                Class[] value() default {};
            }
        }

        /**
         * See <a href="http://www.enterpriseintegrationpatterns.com/patterns/messaging/RecipientList.html">Recipient List</a>
         * {@link Language.Form#Problem}: How do we route a message to a list of dynamically specified recipients?
         * {@link Language.Form#Solution}: Define a channel for each recipient. Then use a {@link RecipientList} to inspect an incoming message,
         * determine the list of desired recipients, and forward the message to all channels associated with the recipients in the list.
         * <p>
         * Sometimes, you need to send a message to more than one recipient, but want to maintain control over the recipients. The Recipient List allows you do just that.
         * In essence, a {@link RecipientList is a {@link ContentBasedRouter} that can route a single message to more than one destination channel.
         */
        @DesignPattern
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.ANNOTATION_TYPE})
        @Patterns.MessageRouting
        @Group.Simple
        @Stateless
        @interface RecipientList {
            /**
             * {@link Language.Form#Problem}:
             * {@link Language.Form#Solution}:
             * Therefore, we should look for a solution that allows subscribers to issue their subscription preferences and then send individual messages only to interested (and authorized) customers.
             * In order to perform this function we use a {@link Dynamic}. A {@link Dynamic} is the combination of two {@link Patterns.MessageRouting}.
             * A Recipient List is a router that propagates a single message to a set of recipients.
             * The main difference between the {@link RecipientList} and a Publish-Subscribe Channel {@link MessageChannel}({@link MessageChannel.PublishSubscribe}) is
             * that the {@link RecipientList} addresses each recipient specifically and therefore has tight control over who receives messages.
             * A {@link Dynamic} is a router whose routing algorithm can change based on control messages.
             * These control messages can take the form of subscription preferences issued by the subscribers.
             * Combining these two patterns results in a {@link Dynamic}.
             * <p>
             * any router can be implemented as a dynamic variant.
             *
             * @return {} or {@link Dynamic}.class
             */
            Class[] value();

            /**
             * If the {@link RecipientList} fails, it needs to be restartable. This can be accomplished in multiple ways:
             * {@link Robustness.SingleTransaction} - The Recipient List can use transactional channels and places the message on the outbound channels as part of a single transaction.
             * It does not commit the messages until all messages are placed on the channels.
             * This guarantees that either all or no messages are sent.
             * {@link Robustness.PersistentRecipientList} - The Recipient List can "remember" which messages it already sent so that on failure and restart can send messages to the remaining recipients.
             * The recipient list could be stored on disk or a database so that it survives a crash of the Recipient List component.
             * {@link Robustness.IdempotentReceivers} Alternatively, the Recipient List could simply resend all messages on restart. This options requires all potential recipients to be idempotent (see Idempotent Receiver).
             *
             * @return One or more of {@link Robustness}.*
             */
            Class[] robustness();

            @Retention(RetentionPolicy.SOURCE)
            @Target({})
            @interface Robustness {
                @Retention(RetentionPolicy.SOURCE)
                @Target({})
                @interface SingleTransaction {
                }

                @Retention(RetentionPolicy.SOURCE)
                @Target({})
                @interface PersistentRecipientList {
                }

                @Retention(RetentionPolicy.SOURCE)
                @Target({})
                @interface IdempotentReceivers {
                }
            }
        }

        /**
         * See <a href="http://www.enterpriseintegrationpatterns.com/patterns/messaging/Sequencer.html">Aggregator</a>
         * {@link Language.Form#Problem}: How can we process a message if it contains multiple elements, each of which may have to be processed in a different way?
         * {@link Language.Form#Solution}: Use a Splitter to break out the composite message into a series of individual messages, each containing data related to one item.
         * See <a href="http://java-design-patterns.com/patterns/eip-aggregator">eip Aggregator</a>
         * <p>
         * {@link Language.Form#Problem}: "It is very common in integration systems that incoming messages consists of many items bundled together.",
         * "For example an invoice document contains multiple invoice lines describing transaction (quantity, name of provided service/sold goods, price etc.).",
         * "Such bundled messages may not be accepted by other systems.",
         * {@link Language.Form#Solution}: "This is where splitter pattern comes in handy.",
         * "It will take the whole document, split it based on given criteria and send individual items to the endpoint.",
         * "http://java-design-patterns.com/patterns/eip-splitter/etc/sequencer.gif"
         * <p>
         * A Static Splitter is functionally equivalent to using a broadcast channel followed by a set of Content Filters.
         */
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.ANNOTATION_TYPE})
        @Patterns.MessageRouting
        @Group.Simple
        @Stateless
        @ContentBasedRouter.MessageFilter
        @interface Splitter {
            /**
             * any router can be implemented as a dynamic variant.
             *
             * @return {} or {@link Dynamic}.class, {@link Static}, {@link Iterating}
             */
            Class[] value();

            /**
             * Iterating Splitters
             * If we use message trees, the Splitter can be easily be configured to iterate through all children under a specified node and send one message for each child node.
             */
            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.ANNOTATION_TYPE})
            @interface Iterating {
            }

        }

        /**
         * See <a href="http://www.enterpriseintegrationpatterns.com/patterns/messaging/Aggregator.html">Aggregator</a>
         * {@link Language.Form#Problem}: How do we combine the results of individual, but related messages so that they can be processed as a whole?
         * {@link Language.Form#Solution}: Use a stateful filter, an Aggregator, to collect and store individual messages until a complete set of related messages has been received. Then, the Aggregator publishes a single message distilled from the individual messages.
         * See <a href="http://java-design-patterns.com/patterns/eip-aggregator">EIP Aggregator</a>
         * <p>
         * {@link Language.Form#Problem}: "Sometimes in enterprise systems there is a need to group incoming data in order to process it as a whole.",
         * "For example you may need to gather offers and after defined number of offers has been received you would like to choose the one with the best parameters.",
         * <p>
         * {@link DesignPattern#Solution}: "Aggregator allows you to merge messages based on defined criteria and parameters.",
         * "It gathers original messages, applies aggregation strategy and upon fulfilling given criteria, releasing merged messages.",
         * "http://java-design-patterns.com/patterns/eip-aggregator/etc/aggregator.gif"
         * When designing an Aggregator, we need to specify the following items:
         * {@link Correlation} - which incoming messages belong together? Correlation is typically achieved by either the type of the incoming messages or an explicit Correlation Identifier.
         * {@link CompletenessCondition} - when are we ready to publish the result message?
         * {@link AggregationAlgorithm} - how do we combine the received messages into a single result message?
         * <p>
         * We call this variation an Initialized Aggregator as opposed to the Self-starting Aggregator.
         */
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.ANNOTATION_TYPE})
        @Patterns.MessageRouting
        @Group.Simple
        @Stateful
        @ContentBasedRouter.MessageFilter
        @interface Aggregator {
            /**
             * any router can be implemented as a dynamic variant.
             *
             * @return {} or {@link Dynamic}.class, {@link Static}, {@link Initialized}, {@link SelfStarting}
             */
            Class[] value();

            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.ANNOTATION_TYPE})
            @interface Initialized {
            }

            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.ANNOTATION_TYPE})
            @interface SelfStarting {
            }

            /**
             * @return on of {@link Correlation}.*
             */
            Class[] correlation();

            /**
             * @return on of {@link CompletenessCondition}.*
             */
            Class[] completenessCondition();

            /**
             * @return on of {@link AggregationAlgorithm}.*
             */
            Class[] aggregationAlgorithm();

            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.ANNOTATION_TYPE})
            @interface Correlation {
            }

            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.ANNOTATION_TYPE})
            @interface CompletenessCondition {
                @Retention(RetentionPolicy.SOURCE)
                @Target({ElementType.ANNOTATION_TYPE})
                @interface WaitForAll {
                }

                @Retention(RetentionPolicy.SOURCE)
                @Target({ElementType.ANNOTATION_TYPE})
                @interface TimeOut {
                }

                @Retention(RetentionPolicy.SOURCE)
                @Target({ElementType.ANNOTATION_TYPE})
                @interface TimeOutWithOverride {
                }

                @Retention(RetentionPolicy.SOURCE)
                @Target({ElementType.ANNOTATION_TYPE})
                @interface ExternalEvent {
                }
            }

            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.ANNOTATION_TYPE})
            @GOF.Strategy
            @interface AggregationAlgorithm {
                @Retention(RetentionPolicy.SOURCE)
                @Target({ElementType.ANNOTATION_TYPE})
                @interface SelectTheBestAnswer {
                }

                @Retention(RetentionPolicy.SOURCE)
                @Target({ElementType.ANNOTATION_TYPE})
                @interface CondenseData {
                }

                @Retention(RetentionPolicy.SOURCE)
                @Target({ElementType.ANNOTATION_TYPE})
                @interface CollectDataForLaterEvaluation {
                }
            }
        }

        /**
         * See <a href="http://www.enterpriseintegrationpatterns.com/patterns/messaging/Resequencer.html">Resequencer</a>
         * {@link Language.Form#Problem}: How can we get a stream of related but out-of-sequence messages back into the correct order?
         * {@link Language.Form#Solution}: Use a stateful filter, a Resequencer, to collect and re-order messages so that they can be published to the output channel in a specified order.
         * <p>
         * One robust way to avoid buffer overruns is to throttle the message producer by using active acknowledgement. {@link VLFP.DataStream.Reactive.BackPressure}
         */
        @DesignPattern
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.ANNOTATION_TYPE})
        @Patterns.MessageRouting
        @Group.Simple
        @Stateful
        @ContentBasedRouter.MessageFilter
        @interface Resequencer {
            /**
             * any router can be implemented as a dynamic variant.
             *
             * @return {} or {@link Dynamic}.class
             */
            Class[] value();
        }

        /**
         * See <a href="http://www.enterpriseintegrationpatterns.com/patterns/messaging/DistributionAggregate.html">Composed Message Processor</a>
         * {@link Language.Form#Problem}: How can you maintain the overall message flow when processing a message consisting of multiple elements, each of which may require different processing?
         * {@link Language.Form#Solution}: Use Composed Message Processor to process a composite message.
         * The Composed Message Processor splits the message up, routes the sub-messages to the appropriate destinations and re-aggregates the responses back into a single message.
         * This patterns demonstrates the composability of individual patterns into a larger patterns.
         */
        @DesignPattern
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.ANNOTATION_TYPE})
        @Patterns.MessageRouting
        @Group.Composed
        @ComposabilityPrinciple(true)
        @interface ComposedMessageProcessor {
        }

        /**
         * See <a href="http://www.enterpriseintegrationpatterns.com/patterns/messaging/BroadcastAggregate.html">Scatter-Gather</a>
         * {@link Language.Form#Problem}: How do you maintain the overall message flow when a message needs to be sent to multiple recipients, each of which may send a reply?
         * {@link Language.Form#Solution}: Use a Scatter-Gather that broadcasts a message to multiple recipients and re-aggregates the responses back into a single message.
         * There are two variants of the Scatter-Gather that use different mechanisms to send the request messages to the intended recipients: {@link Distribution}, {@link Auction}
         */
        @DesignPattern
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.ANNOTATION_TYPE})
        @Patterns.MessageRouting
        @Group.Composed
        @interface ScatterGather {
            /**
             * @return one of {@link Distribution}, {@link Auction}
             */
            Class[] value();

            @Retention(RetentionPolicy.SOURCE)
            @Target({})
            @interface Distribution {
            }

            @Retention(RetentionPolicy.SOURCE)
            @Target({})
            @interface Auction {
            }
        }

        /**
         * See <a href="http://www.enterpriseintegrationpatterns.com/patterns/messaging/RoutingTable.html">Routing Slip</a>
         * {@link Language.Form#Problem}: How do we route a message consecutively through a series of processing steps when the sequence of steps is not known at design-time and may vary for each message?
         * {@link Language.Form#Solution}: Attach a Routing Slip to each message, specifying the sequence of processing steps.
         * Wrap each component with a special message router that reads the Routing Slip and routes the message to the next component in the list.
         * The Routing Slip is most useful in the following scenarios: ...
         */
        @DesignPattern
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.ANNOTATION_TYPE})
        @Patterns.MessageRouting
        @Group.Composed
        @interface RoutingSlip {
        }

        /**
         * See <a href="http://www.enterpriseintegrationpatterns.com/patterns/messaging/ProcessManager.html">Process Manager</a>
         * {@link Language.Form#Problem}: How do we route a message through multiple processing steps when the required steps may not be known at design-time and may not be sequential?
         * {@link Language.Form#Solution}: Use a central processing unit, a Process Manager, to maintain the state of the sequence and determine the next processing step based on intermediate results.
         * We can gain flexibility and maintain a central point of control, if after each individual processing unit we return control back to a central component.
         * That component can then determine the next processing unit(s) to be executed. Following this approach, we end up with an alternating process flow:
         * central component, processing unit, central component, processing unit and so on.
         * In fact, many EAI vendors make you believe that every integration problem is a process problem.
         * We think that using a Process Manager for every situation may be overkill. It can distract from the core design issue and also cause significant performance overhead.
         * <p>
         * Effectively, we can use an abstract notation to model the behavior of the system during design, and then decide whether we want to implement the behavior as
         * a distributed {@link PipesAndFilters} architecture
         * or
         * as a {@link HubAndSpoke} architecture using a central {@link ProcessManager}.
         * Comparing the Process Manager against Other Patterns: ...
         */
        @DesignPattern
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.ANNOTATION_TYPE})
        @Patterns.MessageRouting
        @Group.Composed
        @HubAndSpoke
        @interface ProcessManager {

            /**
             * Because the process execution can span many steps and can therefore take a long time, the Process Manager needs to be prepared to receive new messages while another process is still executing. In
             * order to manage multiple parallel executions, the Process Manager creates a new process instance for each incoming trigger message.
             * The process instance stores the state associated with the execution of the process triggered by the trigger message.
             * The state includes the current execution step of the process and any associated data. Each process instance is identified by a unique process identifier.
             * It is important to separate the concepts of a process definition (also referred to as process template) and a process instance. The process definition is a design construct that defines the sequence of steps to be executed.
             * The process instance is an active execution of a specific template.
             * It is apparent that state management is an important feature of the Process Manager. How, then, did the previous patterns get away without managing state?
             * In a traditional Pipes and Filters architecture, the pipes (i.e., the Message Channels) manage the state.
             */
            @DesignPattern
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.ANNOTATION_TYPE})
            @Patterns.MessageRouting
            @Group.Composed
            @interface Process {

                @DesignPattern
                @Documented
                @Inherited
                @Retention(RetentionPolicy.SOURCE)
                @Target({ElementType.ANNOTATION_TYPE})
                @Patterns.MessageRouting
                @Group.Composed
                @interface Instance {
                    @DesignPattern
                    @Documented
                    @Inherited
                    @Retention(RetentionPolicy.SOURCE)
                    @Target({ElementType.ANNOTATION_TYPE})
                    @Patterns.MessageRouting
                    @Group.Composed
                    @interface UniqueIdentifier {
                    }

                }

                @DesignPattern(aka = "template")
                @Documented
                @Inherited
                @Retention(RetentionPolicy.SOURCE)
                @Target({ElementType.ANNOTATION_TYPE})
                @Patterns.MessageRouting
                @Group.Composed
                @interface Definition {

                }

            }

        }

        /**
         * See <a href="http://www.enterpriseintegrationpatterns.com/patterns/messaging/MessageBroker.html">Message Broker</a>
         * See <a href="https://stackoverflow.com/questions/3144788/difference-between-message-bus-and-message-broker">Difference between message bus and message broker</a>
         * See <a href="https://neiljbrown.com/2017/05/13/message-broker-or-bus-whats-the-difference/">Message Broker or Bus – what’s the difference?</a>
         * {@link Language.Form#Problem}: How can you decouple the destination of a message from the sender and maintain central control over the flow of messages?
         * {@link Language.Form#Solution}: Use a central {@link MessageBroker} that can receive messages from multiple destinations, determine the correct destination and route the message to the correct channel.
         * Implement the internals of the {@link MessageBroker} using the design patterns presented in this chapter.
         * The {@link MessageBroker} is the integration equivalent of a {@link GOF.Mediator} presented in {@link GOF}.
         * <p>
         * The Message Broker is not a monolithic component. Internally, it uses many of the message routing patterns presented in this chapter.
         * So once you decide to use the Message Broker as an architectural pattern, you can choose the correct Message Router design patterns to implement the Message Broker.
         */
        @DesignPattern.Architectural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
        @Patterns.MessageRouting
        @GOF.Mediator
        @Group.Architectural
        @HubAndSpoke
        @interface MessageBroker {
            /**
             * @return One or more names of software, that implements functions of {@link MessageBroker}. Use "*", to point, that any software can be used as a {@link MessageBroker}.
             * It's possible to use constants below.
             */
            Class[] value() default {};

            /**
             * @return One or more classes of {@link MessageBroker} API.
             */
            Class[] api();

            /**
             * See <a href="https://core.telegram.org/bots/api">Telegram Bot API</a>
             */
            @Retention(RetentionPolicy.SOURCE)
            @Target({})
            @interface TelegramBot {
            }

            /**
             * See <a href="https://www.rabbitmq.com">RabbitMQ</a>
             */
            @Retention(RetentionPolicy.SOURCE)
            @Target({})
            @interface RabbitMQ {
            }

            /**
             * See <a href="http://activemq.apache.org">Apache ActiveMQ</a>
             */
            @Retention(RetentionPolicy.SOURCE)
            @Target({})
            @interface ApacheActiveMQ {
            }

            /**
             * See <a href="http://www-03.ibm.com/software/products/en/ibm-mq">IBM WebSphere MQ</a>
             */
            @Retention(RetentionPolicy.SOURCE)
            @Target({})
            @interface IBMWebSphereMQ {
            }

            /**
             * See <a href="https://firebase.google.com/products/cloud-messaging">Firebase Cloud Messaging</a>
             */
            @Retention(RetentionPolicy.SOURCE)
            @Target({})
            @interface FirebaseCloudMessaging {
            }
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @interface BEG_MessageTransformation {
    }

    /**
     * See <a href="http://www.enterpriseintegrationpatterns.com/patterns/messaging/MessageTranslator.html">Message Translator</a>
     * {@link DesignPattern#Problem}: How can systems using different data formats communicate with each other using messaging?
     * {@link DesignPattern#Solution}: Use a special filter, a Message Translator, between other filters or applications to translate one data format into another.
     * {@link DesignPattern#Icon}: <img src="http://www.enterpriseintegrationpatterns.com/img/MessageTranslatorIcon.gif">
     * It is not part of an application code. In the application code use {@link MessageEndpoint.MessagingMapper}.
     * <p>
     * The {@link MessageTranslator} is the messaging equivalent of the {@link GOF.Adapter} pattern described in {@link GOF}.
     * An adapter converts the interface of a component into a another interface so it can be used in a different context.
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.MessagingSystems
    @Patterns.MessageTransformation
    @Related.Patterns(MessageEndpoint.MessagingMapper.class)
    @GOF.Adapter
    @interface MessageTranslator {
        /**
         * @return One or more of {@link Envelope}.*, {@link ContentEnricher}.*, {@link ContentFilter}, {@link ClaimCheck}
         */
        Class[] value();

        Class from();

        Class to();

        /**
         * See <a href="http://www.enterpriseintegrationpatterns.com/patterns/messaging/DataEnricher.html">Content Enricher</a>
         * {@link Language.Form#Problem}: How do we communicate with another system if the message originator does not have all the required data items available?
         * {@link Language.Form#Solution}: Use a specialized transformer, a Content Enricher, to access an external data source in order to augment a message with missing information.
         * The additional information injected by the Content Enricher has to be available somewhere in the system. The most common sources for the new data are:
         * {@link Computation} The Content Enricher may be able to compute the missing information.
         * {@link Environment} The Content Enricher may be able to retrieve the additional data from the operating environment. The most common example is a time stamp.
         * {@link AnotherSystem} This option is the most common one. The Content Enricher has to retrieve the missing data from another system. This data resource can take on a number of forms,
         * including a database, a file, an LDAP directory, a system, or a user who manually enters missing data.
         */
        @DesignPattern
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({})
        @Patterns.MessageTransformation
        @interface ContentEnricher {
            @DesignPattern
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({})
            @Patterns.MessageTransformation
            @interface Computation {
            }

            @DesignPattern
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({})
            @Patterns.MessageTransformation
            @interface Environment {
            }

            @DesignPattern
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({})
            @Patterns.MessageTransformation
            @interface AnotherSystem {
            }
        }

        /**
         * See <a href="http://www.enterpriseintegrationpatterns.com/patterns/messaging/ContentFilter.html">Content Filter</a>
         * {@link Language.Form#Problem}: How do you simplify dealing with a large message, when you are interested only in a few data items?
         * {@link Language.Form#Solution}: Use a Content Filter to remove unimportant data items from a message leaving only important items.
         * The {@link ContentEnricher} helps us in situations where a message receiver requires more - or different - data elements than the message creator provides.
         * There are surprisingly many situations where the opposite effect is desired: removing data elements from a message.
         */
        @DesignPattern
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({})
        @Patterns.MessageTransformation
        @interface ContentFilter {
        }

        /**
         * See <a href="http://www.enterpriseintegrationpatterns.com/patterns/messaging/StoreInLibrary.html">Claim Check</a>
         * {@link Language.Form#Problem}: How can we reduce the data volume of message sent across the system without sacrificing information content?
         * {@link Language.Form#Solution}: Store message data in a persistent store and pass a Claim Check to subsequent components. These components can use the Claim Check to retrieve the stored information.
         */
        @DesignPattern
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({})
        @Patterns.MessageTransformation
        @interface ClaimCheck {
            /**
             * The "Check Luggage" component generates a unique key for the information. This key will be used later as the {@link ClaimCheck}
             */
            @DesignPattern
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({})
            @Patterns.MessageTransformation
            @interface CheckLuggage {
            }
        }

        /**
         * See <a href="http://www.enterpriseintegrationpatterns.com/patterns/messaging/Normalizer.html">Normalizer</a>
         * {@link Language.Form#Problem}: How do you process messages that are semantically equivalent, but arrive in a different format?
         * {@link Language.Form#Solution}: Use a Normalizer to route each message type through a custom Message Translator so that the resulting messages match a common format.
         * {@link Normalizer} consists of {@link MessageRouter}, and several {@link MessageTranslator}
         */
        @DesignPattern
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({})
        @Patterns.MessageTransformation
        @interface Normalizer {
        }

    }

    /**
     * See <a href="http://www.enterpriseintegrationpatterns.com/patterns/messaging/CanonicalDataModel.html">Canonical Data Model</a>
     * {@link Language.Form#Problem}: How can you minimize dependencies when integrating applications that use different data formats?
     * {@link Language.Form#Solution}: Therefore, design a Canonical Data Model that is independent from any specific application. Require each application to produce and consume messages in this common format.
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE})
    @Patterns.MessageTransformation
    @interface CanonicalDataModel {
    }

    @Retention(RetentionPolicy.SOURCE)
    @interface BEG_MessagingEndpoints {
    }

    /**
     * See <a href="http://www.enterpriseintegrationpatterns.com/patterns/messaging/MessageEndpoint.html">Message Endpoint</a>
     * See <a href="http://www.enterpriseintegrationpatterns.com/patterns/messaging/MessageEndpoint.html">Messaging Endpoint</a>
     * {@link Language.Form#Problem}: How does an application connect to a messaging channel to send and receive messages?
     * {@link Language.Form#Solution}: Connect an application to a messaging channel using a {@link MessageEndpoint}, a client of the messaging system that the application can then use to send or receive messages.
     * {@link MessageEndpoint} code is custom to both the application and the messaging system’s client API.
     * The rest of the application knows little about message formats, messaging channels, or any of the other details of communicating with other applications via messaging.
     * It just knows that it has a request or piece of data to send to another application, or is expecting those from another application.
     * It is the messaging endpoint code that takes that command or data, makes it into a message, and sends it on a particular messaging channel.
     * It is the endpoint that receives a message, extracts the contents, and gives them to the application in a meaningful way.
     * <p>
     * A {@link MessageEndpoint} is a specialized {@link ChannelAdapter}, one that has been custom developed for and integrated into its application.
     * A {@link MessageEndpoint} should be designed {@link MessagingGateway} to encapsulate the messaging code and hide the message system from the rest of the application
     * It can employ a {@link MessagingMapper} to transfer data between domain objects and messages
     * It can be structured {@link ServiceActivator} to provide asynchronous message access to a synchronous service or function call
     * An {@link MessageEndpoint} can explicitly control transactions with the messaging system {@link TransactionalClient}.
     * a single Message Endpoint may well combine several different patterns from this chapter. A group of Competing Consumers may be implemented as Polling Consumers
     * that are also Selective Consumers and act as a Service Activator on a service in the application. A Message Dispatcher may be an Event-Driven Consumer and a Durable Subscriber that uses a
     * Messaging Mapper. Whatever other patterns an endpoint implements, it should also be a Messaging Gateway. So don’t think of what one pattern to use, think of the combinations.
     * That’s the beauty of solving the problems with patterns.
     */
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE})
    @Patterns.MessagingSystems
    @Patterns.MessagingEndpoints
    @DesignPattern(aka = {"Client of the messaging system"})
    @Related.Patterns(ChannelAdapter.class)
    @interface MessageEndpoint {
        /**
         * @return One or more of {@link MessagingGateway}, {@link MessagingMapper}, {@link TransactionalClient}, {@link PollingConsumer}, {@link EventDrivenConsumer},
         * {@link CompetingConsumers}, {@link MessageDispatcher}, {@link SelectiveConsumer}, {@link DurableSubscriber}, {@link IdempotentReceiver}, {@link ServiceActivator}
         */
        Class[] value();

        /**
         * See <a href="http://www.enterpriseintegrationpatterns.com/patterns/messaging/MessagingGateway.html">Messaging Gateway</a>
         * {@link Language.Form#Problem}: How do you encapsulate access to the messaging system from the rest of the application?
         * {@link Language.Form#Solution}: Use a Messaging Gateway, a class than wraps messaging-specific method calls and exposes domain-specific methods to the application.
         * The {@link MessagingGateway} encapsulates messaging-specific code (e.g., the code required to send or receive a message) and separates it from the rest of the application code.
         * A {@link MessagingGateway} is a messaging-specific version of the more general {@link PEAA.Gateway} pattern. {@link PEAA}
         * The {@link MessagingGateway} is an {@link MessageEndpoint}, and it is a part of an application code, {@link ChannelAdapter} is not.
         */
        @Patterns.MessagingEndpoints
        @Related.Patterns(ChannelAdapter.class)
        @Retention(RetentionPolicy.SOURCE)
        @Target({})
        @PEAA.Gateway
        @interface MessagingGateway {
        }

        /**
         * See <a href="http://www.enterpriseintegrationpatterns.com/patterns/messaging/MessagingMapper.html">Messaging Mapper</a>
         * {@link Language.Form#Problem}: How do you move data between {@link DomainObject}s and the messaging infrastructure while keeping the two independent of each other?
         * {@link Language.Form#Solution}: Create a separate {@link MessagingMapper} that contains the mapping logic between the messaging infrastructure and the {@link DomainObject}s.
         * Neither the objects nor the infrastructure have knowledge of the Messaging Mapper's existence.
         * {@link MessagingMapper} is a code inside an application, {@link MessageTranslator} is {@link PipesAndFilters} component outside of an application.
         */
        @DesignPattern
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.METHOD})
        @Patterns.MessagingEndpoints
        @Related.Patterns({MessageTranslator.class, PEAA.DataMapper.class})
        @PEAA.Mapper
        @interface MessagingMapper {
            Class from();

            Class to();
        }

        /**
         * See <a href="http://www.enterpriseintegrationpatterns.com/patterns/messaging/TransactionalClient.html">Transactional Client</a>
         * {@link Language.Form#Problem}: How can a client control its transactions with the messaging system?
         * {@link Language.Form#Solution}: Use a Transactional Client—make the client’s session with the messaging system transactional so that the client can specify transaction boundaries.
         * Messaging systems also have to employ transactions—preferably two-phase, distributed transactions—to copy a message from the sender’s computer to the receiver’s computer,
         * such that at any given time, the message is “really” only on one computer or the other.
         * (Transactions are often described as being ACID: atomic, consistent, isolated, and durable. Only transactions for Guaranteed Delivery are durable, and a message by definition is atomic.
         * But all messaging transactions have to be consistent and isolated. A message can’t be sort of in the channel, it either is or isn’t.
         * And an application’s sending and receiving of messages has to be isolated from whatever other sending and receiving other threads and applications might be doing.
         * Messaging systems are capable of participating in a distributed transaction, although some implementations may not support it. In JMS, a provider can act as an XA resource and participate
         * in Java Transaction API [JTA] transactions. This behavior is defined by the “XA” classes in the javax.jms package, particularly javax.jms.XASession, and by the javax.transaction.xa package.
         */
        @Patterns.MessagingEndpoints
        @Retention(RetentionPolicy.SOURCE)
        @Target({})
        @interface TransactionalClient {

            /**
             * @return One or more of {@link Producer}, {@link Consumer}, {@link Scenario}.*.
             */
            Class[] value();

            @Patterns.MessagingEndpoints
            @Retention(RetentionPolicy.SOURCE)
            @Target({})
            @interface Producer {
            }

            @Patterns.MessagingEndpoints
            @Retention(RetentionPolicy.SOURCE)
            @Target({})
            @interface Consumer {
            }

            @Patterns.MessagingEndpoints
            @Retention(RetentionPolicy.SOURCE)
            @Target({})
            @interface Scenario {
                @Patterns.MessagingEndpoints
                @Retention(RetentionPolicy.SOURCE)
                @Target({})
                @interface SendReceiveMessagePairs {
                }

                @Patterns.MessagingEndpoints
                @Retention(RetentionPolicy.SOURCE)
                @Target({})
                @interface MessageGroups {
                }

                @Patterns.MessagingEndpoints
                @Retention(RetentionPolicy.SOURCE)
                @Target({})
                @interface MessageDatabaseCoordination {
                }

                @Patterns.MessagingEndpoints
                @Retention(RetentionPolicy.SOURCE)
                @Target({})
                @interface MessageWorkflowCoordination {
                }
            }

        }

        /**
         * See <a href="http://www.enterpriseintegrationpatterns.com/patterns/messaging/PollingConsumer.html">Polling Consumer</a>
         * {@link Language.Form#Problem}: How can an application consume a message when the application is ready?
         * {@link Language.Form#Solution}: The application should use a Polling Consumer, one that explicitly makes a call when it wants to receive a message.
         */
        @Patterns.MessagingEndpoints
        @Retention(RetentionPolicy.SOURCE)
        @Target({})
        @interface PollingConsumer {
        }

        /**
         * See <a href="http://www.enterpriseintegrationpatterns.com/patterns/messaging/EventDrivenConsumer.html">Event-Driven Consumer</a>
         * {@link Language.Form#Problem}: How can an application automatically consume messages as they become available?
         * {@link Language.Form#Solution}: The application should use an Event-Driven Consumer, one that is automatically handed messages as they’re delivered on the channel.
         */
        @DesignPattern
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.METHOD})
        @Patterns.MessagingEndpoints
        @interface EventDrivenConsumer {
        }

        /**
         * See <a href="http://www.enterpriseintegrationpatterns.com/patterns/messaging/CompetingConsumers.html">Competing Consumers</a>
         * {@link Language.Form#Problem}: How can a messaging client process multiple messages concurrently?
         * {@link Language.Form#Solution}: Create multiple Competing Consumers on a single channel so that the consumers can process multiple messages concurrently.
         */
        @Patterns.MessagingEndpoints
        @Retention(RetentionPolicy.SOURCE)
        @Target({})
        @interface CompetingConsumers {
        }

        /**
         * See <a href="http://www.enterpriseintegrationpatterns.com/patterns/messaging/MessageDispatcher.html">Message Dispatcher</a>
         * {@link Language.Form#Problem}: How can multiple consumers on a single channel coordinate their message processing?
         * {@link Language.Form#Solution}: Create a Message Dispatcher on a channel that will consume messages from a channel and distribute them to performers.
         * The Mediator pattern [GoF] offers some help. A Meditor coordinates a group of objects so that they don't need to know how to coordinate with each other.
         * What we need for messaging is a mediator that coordinates the consumers for a channel.
         * Then each consumer could focus on processing a particular kind of message, and the coordinator could make sure the right message gets to the right consumer.
         * A Message Dispatcher consists of two parts:
         * 1. {@link Dispatcher} – The object that consumes messages from a channel and distributes each message to a performer.
         * 2. {@link Performer} – The object that is given the message by the dispatcher and processes it.
         */
        @Patterns.MessagingEndpoints
        @Retention(RetentionPolicy.SOURCE)
        @Target({})
        @GOF.Mediator
        @interface MessageDispatcher {
            @Patterns.MessagingEndpoints
            @Retention(RetentionPolicy.SOURCE)
            @Target({})
            @GOF.Mediator
            @interface Dispatcher {
            }

            @Patterns.MessagingEndpoints
            @Retention(RetentionPolicy.SOURCE)
            @Target({})
            @GOF.Mediator
            @interface Performer {
            }
        }

        /**
         * See <a href="http://www.enterpriseintegrationpatterns.com/patterns/messaging/MessageSelector.html">Selective Consumer</a>
         * {@link Language.Form#Problem}: How can a message consumer select which messages it wishes to receive?
         * {@link Language.Form#Solution}: Make the consumer a Selective Consumer, one that filteres the messages delivered by its channel so that it only receives the ones that match its criteria.
         */
        @Patterns.MessagingEndpoints
        @Retention(RetentionPolicy.SOURCE)
        @Target({})
        @interface SelectiveConsumer {
        }

        /**
         * See <a href="http://www.enterpriseintegrationpatterns.com/patterns/messaging/DurableSubscription.html">Durable Subscriber</a>
         * {@link Language.Form#Problem}: How can a subscriber avoid missing messages while it’s not listening for them?
         * {@link Language.Form#Solution}: Use a Durable Subscriber to make the messaging system save messages published while the subscriber is disconnected.
         */
        @Patterns.MessagingEndpoints
        @Retention(RetentionPolicy.SOURCE)
        @Target({})
        @interface DurableSubscriber {
        }

        /**
         * See <a href="http://www.enterpriseintegrationpatterns.com/patterns/messaging/IdempotentReceiver.html">Idempotent Receiver</a>
         * {@link Language.Form#Problem}: How can a message receiver deal with duplicate messages?
         * {@link Language.Form#Solution}: Design a receiver to be an Idempotent Receiver--one that can safely receive the same message multiple times.
         */
        @Patterns.MessagingEndpoints
        @Retention(RetentionPolicy.SOURCE)
        @Target({})
        @interface IdempotentReceiver {
        }

        /**
         * See <a href="http://www.enterpriseintegrationpatterns.com/patterns/messaging/MessagingAdapter.html">Service Activator</a>
         * {@link Language.Form#Problem}: How can an application design a service to be invoked both via various messaging technologies and via non-messaging techniques?
         * {@link Language.Form#Solution}: Design a {@link ServiceActivator} that connects the {@link Message}s on the {@link MessageChannel} to the service being accessed.
         */
        @Patterns.MessagingEndpoints
        @Retention(RetentionPolicy.SOURCE)
        @Target({})
        @interface ServiceActivator {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @interface BEG_SystemManagement {
    }

    /**
     * See <a href="http://www.enterpriseintegrationpatterns.com/patterns/messaging/ControlBus.html">Control Bus</a>
     * {@link Language.Form#Problem}: How can we effectively administer a messaging system that is distributed across multiple platforms and a wide geographic area?
     * {@link Language.Form#Solution}: Use a Control Bus to manage an enterprise integration system. The Control Bus uses the same messaging mechanism used by the application data,
     * but uses separate channels to transmit data that is relevant to the management of components involved in the message flow.
     * The Control Bus is well suited to carry the following ddd of messages:
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.SystemManagement
    @interface ControlBus {

        @DesignPattern
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({})
        @Patterns.SystemManagement
        @interface Message {

            @DesignPattern
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({})
            @Patterns.SystemManagement
            @interface Configuration {
            }

            @DesignPattern
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({})
            @Patterns.SystemManagement
            @interface Heartbeat {
            }

            @DesignPattern
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({})
            @Patterns.SystemManagement
            @interface Test {
            }

            @DesignPattern
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({})
            @Patterns.SystemManagement
            @interface Exception {
            }

            @DesignPattern
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({})
            @Patterns.SystemManagement
            @interface Statistics {
            }

            @DesignPattern
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({})
            @Patterns.SystemManagement
            @interface LiveConsole {
            }

        }

    }

    /**
     * See <a href="http://www.enterpriseintegrationpatterns.com/patterns/messaging/Detour.html">Detour</a>
     * {@link Language.Form#Problem}: How can you route a message through intermediate steps to perform validation, testing or debugging functions?
     * {@link Language.Form#Solution}: Construct a Detour with a context-based router controlled via the Control Bus.
     * In one state the router routes incoming messages through additional steps while in the other it routes messages directly to the destination channel.
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.SystemManagement
    @interface Detour {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/eip-wire-tap/">EIP Wire Tap</a>
     * See <a href="http://www.enterpriseintegrationpatterns.com/patterns/messaging/WireTap.html">Wire Tap</a>
     * <p>
     * {@link Language.Form#Problem}: How do you inspect messages that travel on a point-to-point channel?
     * {@link Language.Form#Solution}: Insert a simple Recipient List into the channel that publishes each incoming message to the main channel and a secondary channel.
     */
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.SystemManagement
    @interface WireTap {
    }

    /**
     * See <a href="http://www.enterpriseintegrationpatterns.com/patterns/messaging/MessageHistory.html">Message History</a>
     * {@link Language.Form#Problem}: How can we effectively analyze and debug the flow of messages in a loosely coupled system?
     * {@link Language.Form#Solution}: Therefore, attach a Message History to the message. The Message History is a list of all applications that the message passed through since its origination.
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.SystemManagement
    @interface MessageHistory {
    }

    /**
     * See <a href="http://www.enterpriseintegrationpatterns.com/patterns/messaging/MessageStore.html">Message Store</a>
     * {@link Language.Form#Problem}: How can we report against message information without disturbing the loosely coupled and transient nature of a messaging system?
     * {@link Language.Form#Solution}: Use a Message Store to capture information about each message in a central location.
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.SystemManagement
    @interface MessageStore {
    }

    /**
     * See <a href="http://www.enterpriseintegrationpatterns.com/patterns/messaging/SmartProxy.html">Smart Proxy</a>
     * {@link Language.Form#Problem}: How can you track messages on a service that publishes reply messages to the Return Address specified by the requestor?
     * {@link Language.Form#Solution}: Use a Smart Proxy to store the Return Address supplied by the original requestor and replace it with the address of the Smart Proxy.
     * When the service sends the reply message route it to the original Return Address.
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.SystemManagement
    @interface SmartProxy {
    }

    /**
     * See <a href="http://www.enterpriseintegrationpatterns.com/patterns/messaging/TestMessage.html">Test Message</a>
     * {@link Language.Form#Problem}: What happens, though, if a component is actively processing messages, but garbles outgoing messages due to an internal fault?
     * {@link Language.Form#Solution}: Therefore, use Test Message to assure the health of message processing components (see Figure).
     * The Test Message pattern relies on the following components: {@link TestDataGenerator},  {@link TestMessageInjector}, {@link TestMessageSeparator}, {@link TestDataVerifier}
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.SystemManagement
    @interface TestMessage {
        @DesignPattern
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.ANNOTATION_TYPE})
        @Patterns.SystemManagement
        @interface TestDataGenerator {
        }

        @DesignPattern
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.ANNOTATION_TYPE})
        @Patterns.SystemManagement
        @interface TestMessageInjector {
        }

        @DesignPattern
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.ANNOTATION_TYPE})
        @Patterns.SystemManagement
        @interface TestMessageSeparator {
        }

        @DesignPattern
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.ANNOTATION_TYPE})
        @Patterns.SystemManagement
        @interface TestDataVerifier {
        }

    }

    /**
     * See <a href="http://www.enterpriseintegrationpatterns.com/patterns/messaging/ChannelPurger.html">Channel Purger</a>
     * {@link Language.Form#Problem}: How can you keep 'left-over' messages on a channel from disturbing tests or running systems?
     * {@link Language.Form#Solution}: Use a Channel Purger to remove unwanted messages from a channel.
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.SystemManagement
    @interface ChannelPurger {
    }

    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({})
    @Related.Patterns(PEAA.Performance.Latency.class)
    @interface Performance {
        /**
         * Use {@link PEAA.Performance.Throughput} instead of {@link MessagingThroughput}
         */
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({})
        @Related.Patterns(PEAA.Performance.Throughput.class)
        @interface MessagingThroughput {
        }

        /**
         * Use {@link PEAA.Performance.Latency} instead of {@link MessagingLatency}
         */
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({})
        @Related.Patterns(PEAA.Performance.Latency.class)
        @interface MessagingLatency {
        }
    }

    /**
     * See <a href="http://www.enterpriseintegrationpatterns.com/patterns/messaging/EnvelopeWrapper.html">Envelope Wrapper</a>
     * {@link Language.Form#Problem}: How can existing systems participate in a messaging exchange that places specific requirements on the message format, such as message header fields or encryption?
     * {@link Language.Form#Solution}: Use a Envelope Wrapper to wrap application data inside an {@link Envelope} that is compliant with the messaging infrastructure. Unwrap the message when it arrives at the destination.
     * The {@link Envelope} can be used with {@link MessageTranslator} or with {@link MessageEndpoint.MessagingMapper}
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE})
    @Patterns.MessageTransformation
    @Patterns.MessagingEndpoints
    @interface Envelope {
        @DesignPattern
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.METHOD})
        @Patterns.MessageTransformation
        @interface Wrapper {
        }

        @DesignPattern
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.METHOD})
        @Patterns.MessageTransformation
        @interface UnWrapper {
        }
    }
}
