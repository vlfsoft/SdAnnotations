package vlfsoft.principles.database;

import java.lang.annotation.*;

@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({})
public @interface DB {
    /**
     * See <a href="https://en.wikipedia.org/wiki/Database_transaction">Database transaction</a>
     * A transaction symbolizes a unit of work performed within a database management system (or similar system) against a database, and treated in a coherent and
     * reliable way independent of other transactions. A transaction generally represents any change in a database. Transactions in a database environment have two main purposes:
     * 1. To provide reliable units of work that allow correct recovery from failures and keep a database consistent even in cases of system failure, when execution stops (completely or partially) and many operations upon a database remain uncompleted, with unclear status.
     * 2. To provide isolation between programs accessing a database concurrently. If this isolation is not provided, the programs' outcomes are possibly erroneous.
     */
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @interface Transaction {
        /**
         * @return On or more of {@link ACID#AsAtomic},
         * A database transaction, by definition, must be atomic {@link ACID#AsAtomic}, consistent, isolated and durable.[1] Database practitioners often refer to these properties of database transactions using the acronym {@link ACID}.
         */
        String[] value() default {ACID.AsAtomic, ACID.AsConsistent, ACID.AsIsolated, ACID.AsDurable};

        /**
         * @return ON or more of {@link IsolationLevel#AsSerializable}, {@link IsolationLevel#AsRepeatableReads}, {@link IsolationLevel#AsReadCommitted}, {@link IsolationLevel#AsReadUncommitted}
         */
        String[] supportIsolationLevels();

        /**
         * See <a href="https://en.wikipedia.org/wiki/Isolation_(database_systems)#Isolation_levels">Isolation levels</a>
         *
         */
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({})
        @interface IsolationLevel {
            /**
             * This is the highest isolation level.
             * With a lock-based concurrency control DBMS implementation, serializability requires read and write locks (acquired on selected data) to be released at the end of the transaction.
             * Also range-locks must be acquired when a SELECT query uses a ranged WHERE clause, especially to avoid the phantom reads phenomenon.
             * When using non-lock based concurrency control, no locks are acquired; however, if the system detects a write collision among several concurrent transactions,
             * only one of them is allowed to commit. See snapshot isolation for more details on this topic.
             */
            String AsSerializable = "AsSerializable";
            /**
             * In this isolation level, a lock-based concurrency control DBMS implementation keeps read and write locks (acquired on selected data) until the end of the transaction.
             * However, range-locks are not managed, so phantom reads can occur.
             */
            String AsRepeatableReads = "AsRepeatableReads";
            /**
             * In this isolation level, a lock-based concurrency control DBMS implementation keeps write locks (acquired on selected data) until the end of the transaction,
             * but read locks are released as soon as the SELECT operation is performed (so the non-repeatable reads phenomenon can occur in this isolation level).
             * As in the previous level, range-locks are not managed.
             * Putting it in simpler words, read committed is an isolation level that guarantees that any data read is committed at the moment it is read.
             * It simply restricts the reader from seeing any intermediate, uncommitted, 'dirty' read.
             * It makes no promise whatsoever that if the transaction re-issues the read, it will find the same data; data is free to change after it is read.
             */
            String AsReadCommitted = "AsReadCommitted";
            /**
             * This is the lowest isolation level. In this level, dirty reads are allowed, so one transaction may see not-yet-committed changes made by other transactions.
             */
            String AsReadUncommitted = "AsAsReadUncommitted";
        }


    }
}
