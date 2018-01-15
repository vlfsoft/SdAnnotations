package vlfsoft.patterns;

import vlfsoft.patterns.design.DesignPattern;
import vlfsoft.patterns.enterprise.ddd.DDD;
import vlfsoft.patterns.enterprise.peaa.PEAA;
import vlfsoft.tags.Related;

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
     * See <a href="https://en.wikipedia.org/wiki/Compare-and-swap">Compare-and-swap</a>
     * {@link DesignPattern.Language.Form#Problem}: How can we report against message information without disturbing the loosely coupled and transient nature of a messaging system?
     * {@link DesignPattern.Language.Form#Solution}: compares the contents of a memory location with a given value and, only if they are the same, modifies the contents of that memory location to a new given valu
     *
     * an atomic instruction used in multithreading to achieve synchronization.
     * It compares the contents of a memory location with a given value and, only if they are the same, modifies the contents of that memory location to a new given value.
     * This is done as a single atomic operation. The atomicity guarantees that the new value is calculated based on up-to-date information;
     * if the value had been updated by another thread in the meantime, the write would fail.
     * The result of the operation must indicate whether it performed the substitution; this can be done either with a simple boolean response (this variant is often called compare-and-set),
     * or by returning the value read from the memory location (not the value written to it).
     */
    @DesignPattern.Concurrency
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @interface CompareAndSwap {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/async-method-invocation/">Async Method Invocation</a>
     * <p>
     * {@link DesignPattern#ExamplesFromRealWorld}: "http://docs.oracle.com/javase/8/docs/api/java/util/concurrent/FutureTask.html",
     * "https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/CompletableFuture.html",
     * "http://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ExecutorService.html"
     * })
     */
    @DesignPattern.Concurrency
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @interface AsyncMethodInvocation {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/balking/   ">Balking</a>
     */
    @Related.Patterns({
            GOF.State.class,
            GuardedSuspension.class,
            DoubleCheckedLocking.class})
    @DesignPattern.Concurrency
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @interface Balking {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/double-checked-locking/">Double Checked Locking</a>
     * <p>
     * {@link DesignPattern.Language.Form#Problem}:"Reduce the overhead of acquiring a lock by first testing the locking criterion (the 'lock hint') without actually acquiring the lock.",
     * "Only if the locking criterion check indicates that locking is required does the actual locking logic proceed."
     */
    @Related.Patterns(GOF.Singleton.class)
    @DesignPattern.Concurrency
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @interface DoubleCheckedLocking {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/event-queue/">Event Queue</a>
     * <p>
     * {@link DesignPattern.Language.Form#Problem}: "Event Queue is a good pattern if You have a limited accessibility resource (for example: Audio or Database), ",
     * "but You need to handle all the requests that want to use that. ",
     * "It puts all the requests in a queue and process them asynchronously. ",
     * "Gives the resource for the event when it is the next in the queue and in same time removes it from the queue."
     * <p>
     * {@link DesignPattern#Solution} : "Instead of storing just the current state of the data in a domain,",
     * "use an append-only store to record the full series of actions taken on that data.",
     * "The store acts as the system of record and can be used to materialize the domain objects.",
     * "This can simplify tasks in complex domains, by avoiding the need to synchronize the data model and the business domain,",
     * "while improving performance, scalability, and responsiveness.",
     * "It can also provide consistency for transactional data, and maintain full audit trails and history that can enable compensating actions."
     * })
     */
    @DesignPattern.Concurrency
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @interface EventQueue {
    }

    @DesignPattern.Concurrency
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @interface EventSourcing {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/event-asynchronous/">Event-based Asynchronous</a>
     * <p>
     * {@link DesignPattern.Language.Form#Problem}: "The Event-based Asynchronous Pattern makes available the advantages of multithreaded applications while hiding many of the complex issues inherent in multithreaded design.",
     * "Using a class that supports this pattern can allow you to:",
     * "1. Perform time-consuming tasks, such as downloads and database operations, \"in the background,\" without interrupting your application.",
     * "2. Execute multiple operations simultaneously, receiving notifications when each completes.",
     * "3. Wait for resources to become available without stopping (\"hanging\") your application.",
     * "4. Communicate with pending asynchronous operations using the familiar events-and-delegates model."
     */
    @DesignPattern.Concurrency
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @interface EventBasedAsynchronous {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/guarded-suspension/">Guarded Suspension</a>
     */
    @DesignPattern.Concurrency
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @interface GuardedSuspension {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/half-sync-half-async/">Half-Sync/Half-Async</a>
     */
    @DesignPattern.Concurrency
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @interface HalfSyncHalfAsync {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/mutex/">Mutex</a>
     */
    @DesignPattern.Concurrency
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
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

            @DDD.ValueObject(PEAA.DTO.class)
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
             * Start to declare all the {@link Queue} fields/methods in single {@link GOF.Singleton} interface/class named f.e. MainAppBus*
             * <p>
             * Package pattern: Place all the {@link Queue} MainAppBus* sources into package company.appname.bus.*;
             * <p>
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
    @Target({ElementType.ANNOTATION_TYPE})
    @interface Promise {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/reactor/">Reactor</a>
     */
    @DesignPattern.Concurrency
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @interface Reactor {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/reader-writer-lock/    ">Reader Writer Lock</a>
     */
    @DesignPattern.Concurrency
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @interface ReaderWriterLock {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/semaphore/">Semaphore</a>
     */
    @DesignPattern.Concurrency
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @interface Semaphore {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/tls/">Thread Local Storage</a>
     */
    @DesignPattern.Concurrency
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @interface ThreadLocalStorage {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/thread-pool/">Thread Pool</a>
     */
    @DesignPattern.Concurrency
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @interface ThreadPool {
    }

}
