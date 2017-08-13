package vlfsoft.common.annotations.enterprise.integration.patterns;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import vlfsoft.common.annotations.design.DesignPattern;

/**
 *
 * See <a href="http://www.enterpriseintegrationpatterns.com/patterns/messaging/toc.html">Messaging Patterns</a>
 * See <a href="https://en.wikipedia.org/wiki/Messaging_pattern">Messaging pattern</a>
 *
 */
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface MessagingPattern {

    /**
     * See <a href="https://en.wikipedia.org/wiki/Message_queue">Message queue</a>
     * See <a href="http://stackoverflow.com/questions/7793927/message-queue-vs-message-bus-what-are-the-differences">Message Queue vs Message Bus — what are the differences?</a>
     *
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.METHOD})
    @interface MessageQueue {
    }

    /**
     *
     * See <a href="http://www.enterpriseintegrationpatterns.com/patterns/messaging/MessageBus.html">Message bus</a>
     * See <a href="http://stackoverflow.com/questions/7793927/message-queue-vs-message-bus-what-are-the-differences">Message Queue vs Message Bus — what are the differences?</a>
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.METHOD})
    @interface MessageBus {
    }

}
