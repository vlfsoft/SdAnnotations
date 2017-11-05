package vlfsoft.patterns;

import java.lang.annotation.*;

/**
 * See <a href="http://java-design-patterns.com/patterns/">Patterns</a>
 */
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({})
public @interface ConcurrencyPattern {

    //////////////////////////////////////
    /**
     * See <a href="http://java-design-patterns.com/patterns/async-method-invocation/">Async Method Invocation</a>
     */
    @DesignPattern.Concurrency
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
    @interface AsyncMethodInvocation {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/balking/   ">Balking</a>
     */
    @DesignPattern.Concurrency
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
    @interface Balking {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/double-checked-locking/">Double Checked Locking</a>
     */
    @DesignPattern.Concurrency
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
    @interface DoubleCheckedLocking {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/event-queue/">Event Queue</a>
     */
    @DesignPattern.Concurrency
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
    @interface EventQueue {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/event-asynchronous/">Event-based Asynchronous</a>
     */
    @DesignPattern.Concurrency
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
    @interface EventBasedAsynchronous {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/guarded-suspension/">Guarded Suspension</a>
     */
    @DesignPattern.Concurrency
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
    @interface GuardedSuspension {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/half-sync-half-async/">Half-Sync/Half-Async</a>
     */
    @DesignPattern.Concurrency
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
    @interface HalfSyncHalfAsync {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/mutex/">Mutex</a>
     */
    @DesignPattern.Concurrency
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
    @interface Mutex {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/producer-consumer">Producer Consumer pattern</a>
     * Intent:
     * Producer Consumer Design pattern i a classic concurrency pattern which reduces coupling between Producer and Consumer by separating
     * Identification of work with Execution of Work.
     * Use the Producer Consumer idiom when: <ul>
     * <li> decouple system by separate work in two process produce and consume.
     * <li> addresses the issue of different timing require to produce work or consuming work
     * </ul>
     */
    @DesignPattern.Concurrency
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({})
    @interface ProducerConsumer {

        @DesignPattern.Concurrency
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({})
        @interface Producer {

            @DesignPattern.Concurrency
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.TYPE})
            @interface Interface {
            }

            @DesignPattern.Concurrency
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.TYPE})
            @interface Implementation {
            }

        }

        /**
         *
         */
        @DesignPattern.Concurrency
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({})
        @interface Queue {

            @DesignPattern.Concurrency
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.TYPE})
            @interface Interface {
            }

            @DesignPattern.Concurrency
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.TYPE})
            @interface Implementation {
            }

            @ObjectKindPattern.VO
            @ObjectKindPattern.DTO
            @ObjectKindPattern.Immutable
            @DesignPattern.Concurrency
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({})
            @interface Item {

                @DesignPattern.Concurrency
                @Documented
                @Inherited
                @Retention(RetentionPolicy.SOURCE)
                @Target({ElementType.TYPE})
                @interface Interface {
                }

                @DesignPattern.Concurrency
                @Documented
                @Inherited
                @Retention(RetentionPolicy.SOURCE)
                @Target({ElementType.TYPE})
                @interface Implementation {
                }

                @DesignPattern.Concurrency
                @Documented
                @Inherited
                @Retention(RetentionPolicy.SOURCE)
                @Target({ElementType.FIELD})
                @interface PoisonPill {
                }

            }

            /**
             * Rule of thumb:
             * Start to declare all the {@link Queue} fields/methods in single {@link CreationalPattern.Singleton} interface/class named f.e. MainAppBus*
             *
             * Package pattern: Place all the {@link Queue} MainAppBus* sources into package company.appname.bus.*;
             *
             * If it becomes difficult to work with single MainAppBus* interface/class,
             * split the original MainAppBus* interface/class into several smaller ones by logical areas (modules, packages, etc.).
             */
            @DesignPattern.Concurrency
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({})
            @interface Container {

                @DesignPattern.Concurrency
                @Documented
                @Inherited
                @Retention(RetentionPolicy.SOURCE)
                @Target({ElementType.TYPE})
                @interface Interface {
                }

                @DesignPattern.Concurrency
                @Documented
                @Inherited
                @Retention(RetentionPolicy.SOURCE)
                @Target({ElementType.TYPE})
                @interface Implementation {
                }
            }

        }

        @DesignPattern.Concurrency
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({})
        @interface Consumer {

            @DesignPattern.Concurrency
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.TYPE})
            @interface Interface {
            }

            @DesignPattern.Concurrency
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.TYPE})
            @interface Implementation {
            }

        }

    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/abstract-factory/">Promise</a>
     */
    @DesignPattern.Concurrency
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
    @interface Promise {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/reactor/">Reactor</a>
     */
    @DesignPattern.Concurrency
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
    @interface Reactor {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/reader-writer-lock/    ">Reader Writer Lock</a>
     */
    @DesignPattern.Concurrency
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
    @interface ReaderWriterLock {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/semaphore/">Semaphore</a>
     */
    @DesignPattern.Concurrency
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
    @interface Semaphore {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/tls/">Thread Local Storage</a>
     */
    @DesignPattern.Concurrency
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
    @interface ThreadLocalStorage {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/thread-pool/">Thread Pool</a>
     */
    @DesignPattern.Concurrency
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
    @interface ThreadPool {
    }

}
