package vlfsoft.principles.database;

import java.lang.annotation.*;

/**
 * See <a href="https://en.wikipedia.org/wiki/ACID">ACID</a>
 * ACID (Atomicity, Consistency, Isolation, Durability) is a set of properties of database transactions intended to guarantee validity even in the event of errors,
 * power failures, etc. In the context of databases, a sequence of database operations that satisfies the ACID properties,
 * and thus can be perceived as a single logical operation on the data, is called a transaction. For example, a transfer of funds from one bank account to another,
 * even involving multiple changes such as debiting one account and crediting another, is a single transaction.
 */
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.ANNOTATION_TYPE})
public @interface ACID {

    /**
     * See <a href="https://en.wikipedia.org/wiki/Atomicity_(database_systems)">Atomicity (database systems)</a>
     * An atomic transaction is an indivisible and irreducible series of database operations such that either all occur, or nothing occurs.[1]
     * A guarantee of atomicity prevents updates to the database occurring only partially, which can cause greater problems than rejecting the whole series outright.
     * As a consequence, the transaction cannot be observed to be in progress by another database client. At one moment in time, it has not yet happened,
     * and at the next it has already occurred in whole (or nothing happened if the transaction was cancelled in progress).
     */
    String AsAtomic = "AsAtomic";

    /**
     * See <a href="https://en.wikipedia.org/wiki/Consistency_(database_systems)">Consistency (database systems)</a>
     * refers to the requirement that any given database transaction must change affected data only in allowed ways.
     * Any data written to the database must be valid according to all defined rules, including constraints, cascades, triggers, and any combination thereof.
     * This does not guarantee correctness of the transaction in all ways the application programmer might have wanted (that is the responsibility of application-level code)
     * but merely that any programming errors cannot result in the violation of any defined database constraints
     */
    String AsConsistent = "AsConsistent";

    /**
     * See <a href="https://en.wikipedia.org/wiki/Isolation_(database_systems)">Isolation (database systems)</a>
     * determines how transaction integrity is visible to other users and systems. For example, when a user is creating a Purchase Order and has created the header,
     * but not the Purchase Order lines, is the header available for other systems/users (carrying out concurrent operations,
     * such as a report on Purchase Orders) to see?
     */
    String AsIsolated = "AsIsolated";

    /**
     * See <a href="https://en.wikipedia.org/wiki/Durability_(database_systems)">Durability (database systems)</a>
     */
    String AsDurable = "AsDurable";

}
