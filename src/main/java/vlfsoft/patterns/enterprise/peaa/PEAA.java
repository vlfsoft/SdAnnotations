package vlfsoft.patterns.enterprise.peaa;

import vlfsoft.paradigms.ProgrammingParadigm.Declarative;
import vlfsoft.patterns.GOF;
import vlfsoft.patterns.GOF.Interpreter;
import vlfsoft.patterns.GOF.Memento;
import vlfsoft.patterns.Pattern;
import vlfsoft.patterns.design.DesignPattern;
import vlfsoft.patterns.design.DesignPattern.Language;
import vlfsoft.patterns.enterprise.architecture.HexagonalArchitecture;
import vlfsoft.patterns.enterprise.architecture.LayeredArchitecture;
import vlfsoft.patterns.enterprise.ddd.DDD;
import vlfsoft.patterns.enterprise.ddd.DDD.DomainLayer;
import vlfsoft.patterns.enterprise.eip.EIP;
import vlfsoft.patterns.enterprise.jee.JEE;
import vlfsoft.principles.solid.SOLID;
import vlfsoft.tags.MFowlerTag;
import vlfsoft.tags.NoteTag;
import vlfsoft.tags.Related;

import java.lang.annotation.*;

import static vlfsoft.patterns.enterprise.eip.EIP.*;

/**
 * Patterns of Enterprise Application Architecture
 * See <a href="https://martinfowler.com/eaaCatalog/index.html">Catalog of Patterns of Enterprise Application Architecture</a>
 */
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({})
public @interface PEAA {

    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({})
    @interface Patterns {

        /**
         * Layering is one of the most common techniques that software designers use to break apart a complicated software system.
         * You see it in machine architectures, where layers descend from a programming language
         * with operating system calls into device drivers and CPU instruction sets, and into logic gates inside chips.
         * Networking has FTP layered on top of TCP, which is on top of IP, which is on top of ethernet.
         * <p>
         * When people discuss {@link Layer}, there's often some confusion over the terms layer and tier.
         * Often the two are used as synonyms, but most people see tier as implying a physical separation.
         * Client–server systems are often described as two-tier systems, and the separation is physical: The client is a desktop and the server is a server.
         * I use layer to stress that you don't have to run the layers on different machines.
         * A distinct layer of domain logic often runs on either a desktop or the database server.
         * In this situation you have two nodes but three distinct layers.
         * With a local database I can run all three layers on a single laptop, but there will still be three distinct layers.
         * <p>
         * Sometimes the layers are arranged so that the domain layer completely hides the data source from the presentation.
         * More often, however, the presentation accesses the data store directly. While this is less pure, it tends to work better in practice.
         * The presentation may interpret a command from the user, use the data source to pull the relevant data out of the database,
         * and then let the domain logic manipulate that data before presenting it on the glass.
         * <p>
         * In {@link HexagonalArchitecture} everything external is fundamentally an outside interface, and thus it's a symmetrical view rather than my asymmetric layering scheme {@link LayeredArchitecture}.
         * I find this asymmetry useful, however, because I think there is a good distinction to be made between an interface that you provide as a service to others and your use of someone else's service.
         * Presentation is an external interface for a service your system offers to someone else, whether it be a complex human or a simple remote program.
         * Data source is the interface to things that are providing a service to you.
         * <p>
         * Rule of thumb 1: My general advice is to choose the most appropriate form of separation for your problem but make sure you do some kind of separation—at least at the subroutine level.
         * Rule of thumb 2: there's also a steady rule about dependencies: The domain and data source should never be dependent on the presentation. That is, there should be no subroutine call from the domain or data source code into the presentation code.
         * The relationship between the domain and the data source is more complex and depends upon the architectural patterns used for the data source.
         * Once you've chosen your processing nodes, you should try to keep all the code in a single process, either on one node or copied on several nodes in a cluster.
         * Don't try to separate the layers into discrete processes unless you absolutely have to. Doing that will both degrade performance and add complexity, as you have to add things like Remote Facades (388) and Data Transfer Objects (401).
         */
        @DesignPattern(aka = "tier")
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({})
        @interface Layer {
            /**
             * Provision of services, display of information (e.g., in Windows or HTML, handling of user request (mouse clicks, keyboard hits), HTTP requests, command-line invocations, batch API)
             */
            @DesignPattern(aka = "WebPresentation")
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.ANNOTATION_TYPE})
            @Related.Patterns({FPEAA.Patterns.Presentation.class})
            @interface Presentation {
                /**
                 * {@link Presentation.Logic} is about how to handle the interaction between the user and the software.
                 * This can be as simple as a command-line or text-based menu system, but these days it's more likely to be a rich-client graphics UI or an HTML-based browser UI.
                 * (In this book I use rich client to mean a Windows/Swing/fat-client UI, as opposed to an HTML browser.)
                 * The primary responsibilities of the presentation layer are to display information to the user and to interpret commands from the user into actions upon the domain and data source.
                 */
                @DesignPattern
                @Documented
                @Inherited
                @Retention(RetentionPolicy.SOURCE)
                @Target({})
                @interface Logic {
                }
            }

            /**
             * Logic that is the real point of the system
             */
            @DesignPattern
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({})
            @interface Domain {

                /**
                 * business rules, validations, calculations, and the like also referred to as business logic. This is the work that this
                 * application needs to do for the domain you're working with. It involves calculations based on inputs and stored
                 * data, validation of any data that comes in from the presentation, and figuring out exactly what data source
                 * logic to dispatch, depending on commands received from the presentation
                 */
                @DesignPattern(aka = "business logic")
                @Documented
                @Inherited
                @Retention(RetentionPolicy.SOURCE)
                @Target({ElementType.ANNOTATION_TYPE})
                @interface Logic {
                }
            }

            /**
             * Communication with databases, messaging systems, transaction managers, other packages
             */
            @DesignPattern(aka = "DataSourceArchitectural")
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.ANNOTATION_TYPE})
            @interface DataSource {
                /**
                 * {@link DataSource.Logic} is about communicating with other systems that carry out tasks on behalf of the application.
                 * These can be {@link NoteTag}: transaction monitors, {@link NoteTag}: other applications, {@link NoteTag}: messaging systems, and so forth. For most enterprise
                 * applications the biggest piece of {@link DataSource.Logic} is a {@link NoteTag}: database that is primarily responsible for storing persistent data.
                 */
                @Documented
                @Inherited
                @Retention(RetentionPolicy.SOURCE)
                @Target({})
                @interface Logic {
                }
            }
        }

        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.ANNOTATION_TYPE})
        @interface ObjectRelationalBehavioral {
        }

        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.ANNOTATION_TYPE})
        @interface ObjectRelationalStructural {
        }

        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.ANNOTATION_TYPE})
        @interface ObjectRelationalMetadataMapping {
        }

        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.ANNOTATION_TYPE})
        @interface Distribution {
        }

        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.ANNOTATION_TYPE})
        @interface OfflineConcurrency {
        }

        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.ANNOTATION_TYPE})
        @interface SessionState {
        }

        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.ANNOTATION_TYPE})
        @interface Base {
        }

    }

    @Retention(RetentionPolicy.SOURCE)
    @interface BEG_DomainLogic {
    }

    /**
     * See <a href="https://martinfowler.com/eaaCatalog/transactionScript.html">Transaction Script</a>
     * {@link Language.Form#Problem}: Most business applications can be thought of as a series of transactions.
     * A transaction may view some information as organized in a particular way, another will make changes to it.
     * Each interaction between a client system and a server system contains a certain amount of logic.
     * In some cases this can be as simple as displaying information in the database. In others it may involve many steps of validations and calculations.
     * {@link Language.Form#Solution}: A Transaction Script organizes all this logic primarily as a single procedure, making calls directly to the database or through a thin database wrapper.
     * Each transaction will have its own Transaction Script, although common subtasks can be broken into subprocedures.
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Layer.Domain.Logic
    @interface TransactionScript {
    }

    /**
     * See <a href="https://martinfowler.com/eaaCatalog/domainModel.html">Domain Model</a>
     * An object model of the domain that incorporates both behavior and data.
     * {@link Language.Form#Problem}: At its worst business logic can be very complex. Rules and logic describe many different cases and slants of behavior, and it's this complexity that objects were designed to work with.
     * {@link Language.Form#Solution}: A Domain Model creates a web of interconnected objects, where each object represents some meaningful individual,
     * whether as large as a corporation or as small as a single line on an order form.
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Layer.Domain.Logic
    @interface DomainModel {
    }

    /**
     * See <a href="https://martinfowler.com/eaaCatalog/tableModule.html">Table Module</a>
     * {@link Language.Form#Problem}: One of the problems with Domain Model (116) is the interface with relational databases. In many ways this approach treats the relational database like a crazy aunt who's shut up in an attic and whom nobody wants to talk about. As a result you often need considerable programmatic gymnastics to pull data in and out of the database,
     * transforming between two different representations of the data.
     * {@link Language.Form#Solution}: A Table Module organizes domain logic with one class per table in the data-base, and a single instance of a class contains the various procedures that will act on the data.
     * The primary distinction with Domain Model (116) is that, if you have many orders, a Domain Model (116) will have one order object per order while a Table Module will have one object to handle all orders.
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Layer.Domain.Logic
    @interface TableModule {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/service-layer/">Service Layer</a>
     * See <a href="https://martinfowler.com/eaaCatalog/serviceLayer.html">Service Layer</a>
     * {@link Language.Form#Problem}: A Service Layer defines an application's boundary [Cockburn PloP] and its set of available operations from the perspective of interfacing client layers. It encapsulates the application's business logic,
     * controlling transactions and coor-dinating responses in the implementation of its operations.
     * {@link Language.Form#Solution}: A Service Layer defines an application's boundary [Cockburn PloP] and its set of available operations from the perspective of interfacing client layers.
     * It encapsulates the application's business logic, controlling transactions and coor-dinating responses in the implementation of its operations.
     * MF: My preference is thus to have the thinnest Service Layer (133) you can, if you even need one.
     * My usual approach is to assume that I don't need one and only add it if it seems that the application needs it.
     * <p>
     * {@link MFowlerTag} At this point it becomes apparent that there is a lot of similarity between the presentation and data source layers in that they
     * both are about connection to the outside world. This is the logic behind Alistair Cockburn's {@link HexagonalArchitecture} pattern [wiki],
     * which visualizes any system as a core surrounded by interfaces to external systems.
     * In {@link HexagonalArchitecture} everything external is fundamentally an outside interface, and thus it's a symmetrical view rather than my asymmetric layering scheme.
     * I find this asymmetry useful, however, because I think there is a good distinction to be made between an interface that you provide as a service to others and your use of someone else's service.
     * Driving down to the core, this is the real distinction I make between {@link Patterns.Layer.Presentation} and {@link Patterns.Layer.DataSource}.
     * {@link Patterns.Layer.Presentation} is an external interface for a service your system offers to someone else, whether it be a complex human or a simple remote program.
     * {@link Patterns.Layer.DataSource} is the interface to things that are providing a service to you. I find it beneficial to think about these differently because the difference in clients alters the way you think about the service
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Layer.Domain.Logic
    @DDD.ApplicationLayer
    @interface ServiceLayer {
    }

    @Retention(RetentionPolicy.SOURCE)
    @interface BEG_DataSourceArchitectural {
    }

    /**
     * See <a href="https://martinfowler.com/eaaCatalog/tableDataGateway.html">Table Data Gateway</a>
     * An object that acts as a Gateway (466) to a database table. One instance handles all the rows in the table.
     * {@link Language.Form#Problem}: Mixing SQL in application logic can cause several problems. Many developers aren't comfortable with SQL, and many who are comfortable may not write it well.
     * Database administrators need to be able to find SQL easily so they can figure out how to tune and evolve the database.
     * {@link Language.Form#Solution}: A Table Data Gateway holds all the SQL for accessing a single table or view: selects, inserts, updates, and deletes.
     * Other code calls its methods for all interaction with the database.
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Layer.DataSource
    @Gateway
    @interface TableDataGateway {
    }

    /**
     * See <a href="https://martinfowler.com/eaaCatalog/rowDataGateway.html">Row Data Gateway</a>
     * An object that acts as a Gateway (466) to a single record in a data source. There is one instance per row.
     * {@link Language.Form#Problem}: Embedding database access code in in-memory objects can leave you with a few disadvantages.
     * For a start, if your in-memory objects have business logic of their own, adding the database manipulation code increases complexity.
     * Testing is awkward too since, if your in-memory objects are tied to a database, tests are slower to run because of all the database access.
     * You may have to access multiple databases with all those annoying little variations on their SQL.
     * {@link Language.Form#Solution}: A Row Data Gateway gives you objects that look exactly like the record in your record structure but can be accessed with the regular mechanisms of your programming language.
     * All details of data source access are hidden behind this interface.
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Layer.DataSource
    @Gateway
    @interface RowDataGateway {
    }

    /**
     * See <a href="https://martinfowler.com/eaaCatalog/activeRecord.html">Active Record</a>
     * An object that wraps a row in a database table or view, encapsulates the database access, and adds domain logic on that data.
     * {@link Language.Form#Problem}: An object carries both data and behavior. Much of this data is persistent and needs to be stored in a database.
     * {@link Language.Form#Solution}: Active Record uses the most obvious approach, putting data access logic in the domain object.
     * This way all people know how to read and write their data to and from the database.
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Layer.DataSource
    @interface ActiveRecord {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/data-mapper/">DataMapper</a>
     * See <a href="https://martinfowler.com/eaaCatalog/dataMapper.html">Data Mapper</a>
     * A layer of Mappers that moves data between objects and a database while keeping them independent of each other and the mapper itself.
     * {@link Language.Form#Problem}: Objects and relational databases have different mechanisms for structuring data. Many parts of an object, such as collections and inheritance,
     * aren't present in relational databases. When you build an object model with a lot of business logic it's valuable to use these mechanisms to better organize the data and the behavior that goes with it.
     * Doing so leads to variant schemas; that is, the object schema and the relational schema don't match up.
     * You still need to transfer data between the two schemas, and this data transfer becomes a complexity in its own right.
     * If the in-memory objects know about the relational database structure, changes in one tend to ripple to the other.
     * {@link Language.Form#Solution}: The Data Mapper is a layer of software that separates the in-memory objects from the database.
     * Its responsibility is to transfer data between the two and also to isolate them from each other.
     * With Data Mapper the in-memory objects needn't know even that there's a database present; they need no SQL interface code, and certainly no knowledge of the database schema.
     * (The database schema is always ignorant of the objects that use it.) Since it's a form of {@link Mapper}, {@link DataMapper} itself is even unknown to the {@link DomainLayer}.
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD})
    @Patterns.Layer.DataSource
    @GOF.Factory
    @Related.Patterns(MessageEndpoint.MessagingMapper.class)
    @Mapper
    @interface DataMapper {
    }

    @Retention(RetentionPolicy.SOURCE)
    @interface BEG_ObjectRelationalBehavioral {
    }

    /**
     * See <a href="https://martinfowler.com/eaaCatalog/unitOfWork.html">Unit of work</a>
     * {@link Language.Form#Problem}: When you're pulling data in and out of a database, it's important to keep track of what you've changed; otherwise, that data won't be written back into the database.
     * Similarly you have to insert new objects you create and remove any objects you delete.
     * {@link Language.Form#Solution}: A Unit of Work keeps track of everything you do during a business transaction that can affect the database.
     * When you're done, it figures out everything that needs to be done to alter the database as a result of your work.
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Layer.DataSource
    @interface UnitOfWork {
    }

    /**
     * See <a href="https://martinfowler.com/eaaCatalog/identityMap.html">Identity Map</a>
     * {@link Language.Form#Problem}: If you load the same data more than once you're incurring an expensive cost in remote calls.
     * Thus, not loading the same data twice doesn't just help correctness, but can also speed up your application.
     * {@link Language.Form#Solution}: An Identity Map keeps a record of all objects that have been read from the database in a single business transaction.
     * Whenever you want an object, you check the Identity Map first to see if you already have it.
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Layer.DataSource
    @interface IdentityMap {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/lazy-loading/">Lazy Loading</a>
     * <p>
     * See <a href="https://martinfowler.com/eaaCatalog/lazyLoad.html">Lazy Load</a>
     * {@link Language.Form#Problem}: For loading data from a database into memory it's handy to design things so that as you load an object of interest you also load the objects that are related to it.
     * This makes loading easier on the developer using the object, who otherwise has to load all the objects he needs explicitly.
     * {@link Language.Form#Solution}: A Lazy Load interrupts this loading process for the moment, leaving a marker in the object structure so that if the data is needed it can be loaded only when it is used.
     * As many people know, if you're lazy about doing things you'll win when it turns out you don't need to do them at all.
     * There are four main varieties of lazy load: Lazy Initialization, Virtual Proxy, Value Holder, ghost.
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Layer.DataSource
    @interface LazyLoad {
    }

    @Retention(RetentionPolicy.SOURCE)
    @interface BEG_ObjectRelationalStructural {
    }

    /**
     * See <a href="https://martinfowler.com/eaaCatalog/identityField.html">Identity Field</a>
     * {@link Language.Form#Problem}: Relational databases tell one row from another by using key - in particular, the primary key.
     * However, in-memory objects don't need such a key, as the object system ensures the correct identity under the covers (or in C++'s case with raw memory locations).
     * Reading data from a database is all very well,
     * but in order to write data back you need to tie the database to the in-memory object system.
     * {@link Language.Form#Solution}: In essence, Identity Field is mind-numbingly simple. All you do is store the primary key of the relational database table in the object's fields.
     * <p>
     * Use {@link DDD.Entity.Id} instead of {@link IdentityField}.
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({})
    @Patterns.Layer.DataSource
    @Related.Patterns(DDD.Entity.Id.class)
    @interface IdentityField {
    }

    /**
     * See <a href="https://martinfowler.com/eaaCatalog/foreignKeyMapping.html">Foreign Key Mapping</a>
     * {@link Language.Form#Problem}: Objects can refer to each other directly by object references. Even the simplest object-oriented system will contain a bevy of objects connected to each other in all sorts of interesting ways. To save these objects to a database, it's vital to save these references. However, since the data in them is specific to the specific instance of the running program, you can't just save raw data values. Further complicating things is the fact that objects can easily hold collections of refer-ences to other objects.
     * Such a structure violates the first normal form of rela-tional databases.
     * {@link Language.Form#Solution}: A Foreign Key Mapping maps an object reference to a foreign key in the database.
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Layer.DataSource
    @interface ForeignKeyMapping {
    }

    /**
     * See <a href="https://martinfowler.com/eaaCatalog/associationTableMapping.html">Association Table Mapping</a>
     * {@link Language.Form#Problem}: Objects can handle multivalued fields quite easily by using collections as field values.
     * Relational databases don't have this feature and are constrained to sin-gle- valued fields only.
     * When you're mapping a one-to-many association you can handle this using Foreign Key Mapping (236), essentially using a foreign key for the single-valued end of the association.
     * But a many-to-many association can't do this because there is no single-valued end to hold the foreign key.
     * {@link Language.Form#Solution}: The answer is the classic resolution that's been used by relational data people for decades: create an extra table to record the relationship.
     * Then use Associa-tion Table Mapping to map the multivalued field to this link table.
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Layer.DataSource
    @interface AssociationTableMapping {
    }

    /**
     * See <a href="https://martinfowler.com/eaaCatalog/dependentMapping.html">Dependent Mapping</a>
     * {@link Language.Form#Problem}: Some objects naturally appear in the context of other objects. Tracks on an album may be loaded or saved whenever the underlying album is loaded or saved.
     * {@link Language.Form#Solution}:  If they aren't referenced to by any other table in the database, you can simplify the mapping procedure by having the album mapper perform the map-ping for the tracks as well - treating this mapping as a dependent mapping.
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Layer.DataSource
    @interface DependentMapping {
    }

    /**
     * See <a href="https://martinfowler.com/eaaCatalog/embeddedValue.html">Embedded Value</a>
     * {@link Language.Form#Problem}: Many small objects make sense in an OO system that don't make sense as tables in a database. Examples include currency-aware money objects and date ranges.
     * Although the default thinking is to save an object as a table, no sane person would want a table of money values.
     * {@link Language.Form#Solution}: An Embedded Value maps the values of an object to fields in the record of the object's owner. In the sketch we have an employment object with links to a date range object and a money object.
     * In the resulting table the fields in those objects map to fields in the employment table rather than make new records themselves.
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Layer.DataSource
    @interface EmbeddedValue {
    }

    /**
     * See <a href="https://martinfowler.com/eaaCatalog/serializedLOB.html">Serialized LOB</a>
     * {@link Language.Form#Problem}: Not so easy is putting all this into a relational schema. The basic schema is simple - an organization table with a parent foreign key, however,
     * its manipula-tion of the schema requires many joins, which are both slow and awkward.
     * {@link Language.Form#Solution}: Objects don't have to be persisted as table rows related to each other. Another form of persistence is serialization,
     * where a whole graph of objects is written out as a single large object (LOB) in a table this Serialized LOB then becomes a form of {@link Memento}.
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Layer.DataSource
    @interface SerializedLOB {
    }

    /**
     * See <a href="https://martinfowler.com/eaaCatalog/singleTableInheritance.html">Single Table Inheritance</a>
     * {@link Language.Form#Problem}: Relational databases don't support inheritance, so when mapping from objects to databases we have to consider how to represent our nice inheritance struc-tures in relational tables.
     * When mapping to a relational database, we try to minimize the joins that can quickly mount up when processing an inheritance structure in multiple tables.
     * {@link Language.Form#Solution}: Single Table Inheritance maps all fields of all classes of an inheritance structure into a single table.
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Layer.DataSource
    @interface SingleTableInheritance {
    }

    /**
     * See <a href="https://martinfowler.com/eaaCatalog/classTableInheritance.html">Class Table Inheritance</a>
     * {@link Language.Form#Problem}: A very visible aspect of the object-relational mismatch is the fact that relational databases don't support inheritance.
     * You want database structures that map clearly to the objects and allow links anywhere in the inheritance structure.
     * {@link Language.Form#Solution}: Class Table Inheritance supports this by using one database table per class in the inheritance structure.
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Layer.DataSource
    @interface ClassTableInheritance {
    }

    /**
     * See <a href="https://martinfowler.com/eaaCatalog/concreteTableInheritance.html">Concrete Table Inheritance</a>
     * {@link Language.Form#Problem}: As any object purist will tell you, relational databases don't support inherit-ance - a fact that complicates object-relational mapping.
     * Thinking of tables from an object instance point of view, a sensible route is to take each object in memory and map it to a single database row.
     * {@link Language.Form#Solution}: This implies Concrete Table Inher-itance, where there's a table for each concrete class in the inheritance hierarchy.
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Layer.DataSource
    @interface ConcreteTableInheritance {
    }

    /**
     * See <a href="https://martinfowler.com/eaaCatalog/inheritanceMappers.html">Inheritance Mappers</a>
     * {@link Language.Form#Problem}: When you map from an object-oriented inheritance hierarchy in memory to a relational database you have to minimize the amount of code needed to save and load the data to the database.
     * You also want to provide both abstract and concrete mapping behavior that allows you to save or load a superclass or a subclass.
     * {@link Language.Form#Solution}: Although the details of this behavior vary with your inheritance mapping scheme (Single Table Inheritance (278),
     * Class Table Inheritance (285), and Concrete Table Inheritance (293)) the general structure works the same for all of them.
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Layer.DataSource
    @interface InheritanceMappers {
    }

    @Retention(RetentionPolicy.SOURCE)
    @interface BEG_ObjectRelationalMetadataMapping {
    }

    /**
     * See <a href="https://martinfowler.com/eaaCatalog/metadataMapping.html">Metadata Mapping</a>
     * Holds details of object-relational mapping in metadata.
     * {@link Language.Form#Problem}: Much of the code that deals with object-relational mapping describes how fields in the database correspond to fields in in-memory objects.
     * The resulting code tends to be tedious and repetitive to write.
     * {@link Language.Form#Solution}: A Metadata Mapping allows developers to define the mappings in a simple tabular form,
     * which can then be processed by generic code to carry out the details of reading, inserting, and updating the data.
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Layer.DataSource
    @interface MetadataMapping {
    }

    /**
     * See <a href="https://martinfowler.com/eaaCatalog/queryObject.html">Query Object</a>
     * An object that represents a database query.
     * {@link Language.Form#Problem}: SQL can be an involved language, and many developers aren't particularly familiar with it. Furthermore, you need to know what the database schema looks like to form queries.
     * You can avoid this by creating specialized finder methods that hide the SQL inside parameterized methods, but that makes it dif-ficult to form more ad hoc queries.
     * It also leads to duplication in the SQL state-ments should the database schema change.
     * {@link Language.Form#Solution}: A Query Object is an {@link Interpreter}, that is, a structure of objects that can form itself into a SQL query.
     * You can create this query by refer-ring to classes and fields rather than tables and columns.
     * In this way those who write the queries can do so independently of the database schema and changes to the schema can be localized in a single place.
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Layer.DataSource
    @interface QueryObject {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/repository/">Repository</a>
     * See <a href="https://martinfowler.com/eaaCatalog/repository.html">Repository</a>
     * Mediates between the domain and data mapping layers using a collection-like interface for accessing domain objects.
     * {@link Language.Form#Problem}: A system with a complex {@link DomainModel} often benefits from a layer, such as the one provided by {@link DataMapper},
     * that isolates domain objects from details of the database access code. In such systems it can be worthwhile to build another layer of abstraction over the mapping layer where query construction code is concentrated.
     * This becomes more important when there are a large number of domain classes or heavy querying. In these cases particularly, adding this layer helps minimize duplicate query logic.
     * {@link Language.Form#Solution}: A Repository mediates between the domain and data mapping layers, acting like an in-memory domain object collection.
     * Client objects construct query specifications declaratively and submit them to Repository for satisfaction. Objects can be added to and removed from the Repository, as they can from a simple collection of objects,
     * and the mapping code encapsulated by the Repository will carry out the appropriate operations behind the scenes.
     * Conceptually, a Repository encapsulates the set of objects persisted in a data store and the operations performed over them,
     * providing a more object-oriented view of the persistence layer. Repository also supports the objective of achieving a clean separation and one-way dependency between the domain and data mapping layers.
     * <p>
     * Use {@link DDD.Repository} instead of this annotation.
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({})
    @Patterns.Layer.DataSource
    @Related.Patterns(DDD.Repository.class)
    @interface Repository {
    }

    @Retention(RetentionPolicy.SOURCE)
    @interface BEG_WebPresentation {
    }

    /**
     * See <a href="https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93controller">Model–view–controller</a>
     * See <a href="http://java-design-patterns.com/patterns/model-view-controller/">Model-View-Controller</a>
     * See <a href="https://martinfowler.com/eaaCatalog/modelViewController.html">Model View Controller</a>
     * {@link Language.Form#Problem}:
     * {@link Language.Form#Solution}: Splits user interface interaction into three distinct roles.
     * {@link Language.Form#Intent} Controller Model View Controller (MVC) is one of the most quoted (and most misquoted) patterns around. It started as a framework developed by Trygve Reenskaug for the Smalltalk platform in the late 1970s.
     * Since then it has played an influential role in most UI frameworks and in the thinking about UI design.
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Layer.Presentation
    @interface ModelViewController {
        /**
         * stores data that is retrieved according to command from the controller and displayed in the view.
         */
        @DesignPattern.Architectural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.METHOD})
        @interface Model {
        }

        /**
         * generates new output to the user based on changes in the model.
         */
        @DesignPattern.Architectural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE, ElementType.METHOD})
        @interface View {
        }

        /**
         * can send command to the model to update the model's state (e.g., editing a document).
         * It can also send command to its associated view to change the view's presentation of the model (e.g., scrolling through a document).
         */
        @DesignPattern.Architectural
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.METHOD})
        @interface Controller {
        }

    }

    /**
     * See <a href="https://martinfowler.com/eaaCatalog/pageController.html">Page Controller</a>
     * {@link Language.Form#Problem}: Most people's basic Web experience is with static HTML pages. When you request static HTML you pass to the Web server the name and path for a HTML document stored on it.
     * The key notion is that each page on the Web site is a separate document on the server. With dynamic pages things can get much more interesting since there's a much more complex relationship between path names and the file that responds.
     * However, the approach of one path leading to one file that handles the request is a simple model to understand.
     * {@link Language.Form#Solution}: As a result, Page Controller has one input controller for each logical page of the Web site. That controller may be the page itself,
     * as it often is in server page environments, or it may be a separate object that corresponds to that page.
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Layer.Presentation
    @interface PageController {
    }

    /**
     * See <a href="http://java-design-patterns.com/patterns/front-controller/">SEC_FrontController</a>
     * {@link DesignPattern#Solution}:
     * "Introduce a common handler for all requests for a web site. ",
     * "This way we can encapsulate common functionality such as security, internationalization, routing and logging in a single place."
     * <p>
     * {@link DesignPattern#ExamplesFromRealWorld}: <a href="https://struts.apache.org/">struts</a>""
     * <p>
     * See <a href="https://martinfowler.com/eaaCatalog/frontController.html">Front Controller</a>
     * {@link Language.Form#Problem}: In a complex Web site there are many similar things you need to do when handling a request.
     * These things include security, internationalization, and providing particular views for certain users.
     * If the input controller behavior is scattered across multiple objects, much of this behavior can end up duplicated.
     * Also, it's difficult to change behavior at runtime.
     * {@link Language.Form#Solution}: The Front Controller consolidates all request handling by channeling requests through a single handler object.
     * This object can carry out common behavior, which can be modified at runtime with decorators.
     * The handler then dispatches to command objects for behavior particular to a request.
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Layer.Presentation
    @Related.Patterns(JEE.SEC_FrontController.class)
    @interface FrontController {
    }

    /**
     * See <a href="https://martinfowler.com/eaaCatalog/templateView.html"></a>
     * {@link Language.Form#Problem}: Writing a program that spits out HTML is often more difficult than you might imagine. Although programming languages are better at creating text than they used to be (some of us remember character handling in Fortran and stan-dard Pascal), creating and concatenating string constructs is still painful.
     * If there isn't much to do, it isn't too bad, but a whole HTML page is a lot of text manipulation.
     * {@link Language.Form#Solution}: The best way to work is to compose the dynamic Web page as you do a static page but put in markers that can be resolved into calls to gather dynamic information.
     * Since the static part of the page acts as a template for the particular response,
     * I call this a Template View.
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Layer.Presentation
    @interface TemplateView {
    }

    /**
     * See <a href="https://martinfowler.com/eaaCatalog/transformView.html">Transform View</a>
     * {@link Language.Form#Problem}: Transform When you issue requests for data to the domain and data source layers, you get back all the data you need to satisfy them,
     * but without the formatting you need to make a proper Web page.
     * The role of the view in Model View Controller (330) is to render this data into a Web page.
     * {@link Language.Form#Solution}: Using Transform View means thinking of this as a transformation where you have the model's data as input and its HTML as output.
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Layer.Presentation
    @interface TransformView {
    }

    /**
     * See <a href="https://martinfowler.com/eaaCatalog/twoStepView.html">Two-Step View</a>
     * {@link Language.Form#Problem}: If you have a Web application with many pages, you often want a consistent look and organization to the site.
     * If every page looks different, you end up with a site that users find confusing. You may also want to make global changes to the appearance of the site easily,
     * but common approaches using Template View (350) or Transform View (361) make this difficult because presentation decisions are often duplicated across multiple pages or transform modules.
     * A global change can force you to change several files.
     * {@link Language.Form#Solution}: Two Step View deals with this problem by splitting the transformation into two stages.
     * The first transforms the model data into a logical presentation without any specific formatting; the second converts that logical presentation with the actual formatting needed.
     * This way you can make a global change by altering the second stage, or you can support multiple output looks and feels with one second stage each.
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Layer.Presentation
    @interface TwoStepView {
    }

    /**
     * See <a href="https://martinfowler.com/eaaCatalog/applicationController.html">Application Controller</a>
     * {@link Language.Form#Problem}: Some applications contain a significant amount of logic about the screens to use at different points, which may involve invoking certain screens at certain times in an application.
     * This is the wizard style of interaction, where the user is led through a series of screens in a certain order. In other cases we may see screens that are only brought in under certain conditions,
     * or choices between different screens that depend on earlier input.
     * {@link Language.Form#Solution}: You can remove this duplication by placing all the flow logic in an Applica-tion Controller.
     * Input controllers then ask the Application Controller for the appropriate commands for execution against a model and the correct view to use depending on the application context.
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Layer.Presentation
    @interface ApplicationController {
    }

    @Retention(RetentionPolicy.SOURCE)
    @interface BEG_Distribution {
    }

    /**
     * See <a href="https://martinfowler.com/eaaCatalog/remoteFacade.html">Remote Facade</a>
     * {@link Language.Form#Problem}: Within a single address space fine-grained interaction works well, but this happy state does not exist when you make calls between processes. Remote calls are much more expensive because there's a lot more to do: Data may have to be marshaled, security may need to be checked, packets may need to be routed through switches.
     * {@link Language.Form#Solution}: A Remote Facade is a coarse-grained {@link GOF.Facade} over a web of fine-grained objects. None of the fine-grained objects have a remote interface, and the Remote Facade contains no domain logic.
     * All the Remote Facade does is translate coarse-grained methods onto the underlying fine-grained objects.
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Distribution
    @interface RemoteFacade {
    }

    /**
     * See <a href="https://martinfowler.com/eaaCatalog/dataTransferObject.html">Data Transfer Object</a>
     * When you're working with a remote interface, such as Remote Facade (388), each call to it is expensive.
     * As a result you need to reduce the number of calls, and that means that you need to transfer more data with each call.
     * One way to do this is to use lots of parameters. However, this is often awkward to program - indeed, it's often impossible with languages such as Java that return only a single value.
     * The solution is to create a Data Transfer Object that can hold all the data for the call. It needs to be serializable to go across the connection.
     * Usually an assembler is used on the server side to transfer data between the DTO and any domain objects.
     * Although the main reason for using a Data Transfer Object is to batch up what would be multiple remote calls into a single call,
     * it's worth mentioning that another advantage is to encapsulate the serialization mechanism for transferring data over the wire.
     * By encapsulating the serialization like this, the DTOs keep this logic out of the rest of the code and also provide a clear point to change serialization should you wish.
     * <p>
     * See <a href="http://java-design-patterns.com/patterns/data-transfer-object/">Data Transfer Object</a>
     * Intent:
     * Pass data with multiple attributes in one shot from client to server, to avoid multiple calls to remote server.
     * <p>
     * See <a href="https://en.wikipedia.org/wiki/Data_transfer_object">Data transfer object</a>
     * A data transfer object (DTO[1][2]) is an object that carries data between processes.
     * The motivation for its use is that communication between processes is usually done resorting to remote interfaces (e.g. web services),
     * where each call is an expensive operation.[2] Because the majority of the cost of each call is related to the round-trip time between
     * the client and the server, one way of reducing the number of calls is to use an object (the DTO) that aggregates the data
     * that would have been transferred by the several calls, but that i served by one call only.[2]
     * Don't use directly. Use {@link DDD.ValueObject}({@link PEAA.DTO}) or {@link DDD.ValueObject}({@link PEAA.DTO.InStream}) instead.
     * {@link DTO} is used to pass several parameter values to a method/function in a single parameter or to return several values from method/function in a single return value.
     * <p>
     * {@link Language.Form#Problem}: When you're working with a remote interface, such as Remote Facade (388), each call to it is expensive.
     * s a result you need to reduce the number of calls, and that means that you need to transfer more data with each call.
     * {@link Language.Form#Solution}: The solution is to create a Data Transfer Object that can hold all the data for the call. It needs to be serializable to go across the connection.
     * Usually an assembler is used on the server side to transfer data between the DTO and any domain objects
     */

    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({})
    @Related.Patterns({DDD.Entity.class, DDD.ValueObject.class, JEE.TransferObject.class})
    @DDD.DomainObject
    @Patterns.Distribution
    @interface DTO {
        /**
         * It is used either to transfer event state data between (reactive, or non-reactive) stream operators.
         * F.e., it wraps several objects to be handled inside stream operators, into single {@link InStream},
         * since stream operators can accept only one object as a parameter.
         * Disadvantage: There are rather many cases when {@link InStream} is required just to support {@link Declarative.Functional}, especially in streams.
         * <p>
         * {@link DDD.Mutable} - every stream operator can amend state of {@link InStream} in order to save results of its work.
         * Thus, results of work done by one operator can be transferred to another one without creating new instance of {@link InStream}.
         * One instance of {@link InStream}{@link DDD.Mutable} can be used instead of creating several instances of {@link InStream}{@link DDD.Immutable}.
         */

        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({})
        @Related.Patterns({DDD.Entity.class, DDD.ValueObject.class})
        @DDD.DomainObject
        @Patterns.Distribution
        @interface InStream {
        }

    }


    @Retention(RetentionPolicy.SOURCE)
    @interface BEG_OfflineConcurrency {
    }

    /**
     * See <a href="https://martinfowler.com/eaaCatalog/optimisticOfflineLock.html">Optimistic Offline Lock</a>
     * {@link Language.Form#Problem}: Often a business transaction executes across a series of system transactions. Once outside the confines of a single system transaction,
     * we can't depend on our database manager alone to ensure that the business transaction will leave the record data in a consistent state.
     * Data integrity is at risk once two sessions begin to work on the same records and lost updates are quite possible. Also, with one session editing data that another is reading an inconsistent read becomes likely.
     * {@link Language.Form#Solution}: Optimistic Offline Lock solves this problem by validating that the changes about to be committed by one session don't conflict with the changes of another session.
     * A successful pre-commit validation is, in a sense, obtaining a lock indi-cating it's okay to go ahead with the changes to the record data.
     * So long as the validation and the updates occur within a single system transaction the business transaction will display consistency.
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.OfflineConcurrency
    @interface OptimisticOfflineLock {
    }

    /**
     * See <a href="https://martinfowler.com/eaaCatalog/pessimisticOfflineLock.html">Pessimistic Offline Lock</a>
     * {@link Language.Form#Problem}: Since offline concurrency involves manipulating data for a business transaction that spans multiple requests,
     * the simplest approach would seem to be having a system transaction open for the whole business transaction.
     * {@link Language.Form#Solution}: Pessimistic Offline Lock prevents conflicts by avoiding them altogether. It forces a business transaction to acquire a lock on a piece of data before it starts to use it,
     * so that, most of the time, once you begin a business transaction you can be pretty sure you'll complete it without being bounced by concurrency control.
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.OfflineConcurrency
    @interface PessimisticOfflineLock {
    }

    /**
     * See <a href="https://martinfowler.com/eaaCatalog/coarseGrainedLock.html">Coarse Grained Lock</a>
     * {@link Language.Form#Problem}: Objects can often be edited as a group. Perhaps you have a customer and its set of addresses.
     * If so, when using the application it makes sense to lock all of these items if you want to lock any one of them. Having a separate lock for individual objects presents a number of challenges.
     * {@link Language.Form#Solution}: A Coarse-Grained Lock is a single lock that covers many objects. It not only simplifies the locking action itself but also frees you from having to load all the members of a group in order to lock them.
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.OfflineConcurrency
    @interface CoarseGrainedLock {
    }

    /**
     * See <a href="https://martinfowler.com/eaaCatalog/implicitLock.html">Implicit Lock</a>
     * {@link Language.Form#Problem}: The key to any locking scheme is that there are no gaps in its use. Forgetting to write a single line of code that acquires a lock can render an entire offline lock-ing scheme useless.
     * Failing to retrieve a read lock where other transactions use write locks means you might not get up-to-date session data;
     * failing to use a version count properly can result in unknowingly writing over someone's changes.
     * {@link Language.Form#Solution}: One solution is to not allow developers to make such a mistake. Locking tasks that cannot be overlooked should be handled not explicitly by developers but implicitly by the application.
     * The fact that most enterprise applications make use of some combination of framework, Layer Supertypes (475), and code generation provides us with ample opportunity to facilitate Implicit Lock.
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.OfflineConcurrency
    @interface ImplicitLock {
    }

    @Retention(RetentionPolicy.SOURCE)
    @interface BEG_SessionState {
    }

    /**
     * See <a href="https://martinfowler.com/eaaCatalog/clientSessionState.html">Client Session State</a>
     * {@link Language.Form#Problem}:
     * {@link Language.Form#Solution}:
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.SessionState
    @interface ClientSessionState {
    }

    /**
     * See <a href="https://martinfowler.com/eaaCatalog/serverSessionState.html">Server Session State</a>
     * {@link Language.Form#Problem}:
     * {@link Language.Form#Solution}:
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.SessionState
    @interface ServerSessionState {
    }

    /**
     * See <a href="https://martinfowler.com/eaaCatalog/databaseSessionState.html">Database Session State</a>
     * {@link Language.Form#Problem}:
     * {@link Language.Form#Solution}:
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.SessionState
    @interface DatabaseSessionState {
    }

    @Retention(RetentionPolicy.SOURCE)
    @interface BEG_Base {
    }

    /**
     * See <a href="https://martinfowler.com/eaaCatalog/gateway.html">Gateway</a>
     * {@link Language.Form#Problem}: When accessing external resources like this, you'll usually get APIs for them.
     * However, these APIs are naturally going to be somewhat complicated because they take the nature of the resource into account.
     * Anyone who needs to under-stand a resource needs to understand its API - whether JDBC and SQL for rela-tional databases or W3C or JDOM for XML
     * {@link Language.Form#Solution}: The answer is so common that it's hardly worth stating. Wrap all the special API code into a class whose interface looks like a regular object.
     * Other objects access the resource through this Gateway, which translates the simple method calls into the appropriate specialized API.
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.FIELD})
    @Patterns.Base
    @interface Gateway {
    }

    /**
     * See <a href="https://martinfowler.com/eaaCatalog/mapper.html">Mapper</a>
     * {@link Language.Form#Problem}: Sometimes you need to set up communications between two subsystems that still need to stay ignorant of each other.
     * This may be because you can't modify them or you can but you don't want to create dependencies between the two or even between them and the isolating element.
     * {@link Language.Form#Solution}: An object that sets up a communication between two independent objects.
     * Widespread specialized forms of {@link Mapper}: {@link DataMapper}, {@link MessageEndpoint.MessagingMapper}.
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE})
    @Patterns.Base
    @interface Mapper {
    }

    /**
     * See <a href="https://martinfowler.com/eaaCatalog/layerSupertype.html">Layer Supertype</a>
     * {@link Language.Form#Problem}: It's not uncommon for all the objects in a layer to have methods you don't want to have duplicated throughout the system.
     * {@link Language.Form#Solution}: You can move all of this behavior into a common Layer Supertype.
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Base
    @interface LayerSupertype {
    }

    /**
     * See <a href="https://martinfowler.com/eaaCatalog/separatedInterface.html">Separated Interface</a>
     * {@link Language.Form#Problem}: As you develop a system, you can improve the quality of its design by reducing the coupling between the system's parts.
     * A good way to do this is to group the classes into packages and control the dependencies between them.
     * You can then follow rules about how classes in one package can call classes in another - for example, one that says that classes in the domain layer may not call classes in the presentation package.
     * {@link Language.Form#Solution}: If so, use Separated Interface to define an interface in one package but implement it in another.
     * This way a client that needs the dependency to the interface can be completely unaware of the implementation. The Separated Interface provides a good plug point for Gateway (466).
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @SOLID.DependencyInversion(true)
    @Patterns.Base
    @interface SeparatedInterface {
    }

    /**
     * See <a href="https://martinfowler.com/eaaCatalog/registry.html">Registry</a>
     * {@link Language.Form#Problem}: When you want to find an object you usually start with another object that has an association to it, and use the association to navigate to it.
     * Thus, if you want to find all the orders for a customer, you start with the customer object and use a method on it to get the orders.
     * However, in some cases you won't have an appropriate object to start with. You may know the customer's ID number but not have a reference.
     * In this case you need some kind of lookup method - a finder - but the question remains: How do you get to the finder?
     * {@link Language.Form#Solution}: A Registry is essentially a global object, or at least it looks like one - even if it isn't as global as it may appear.
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Base
    @interface Registry {
    }

    /**
     * See <a href="https://martinfowler.com/eaaCatalog/valueObject.html">Value Object</a>
     * {@link Language.Form#Problem}:
     * {@link Language.Form#Solution}: A small simple object, like money or a date range, whose equality isn't based on identity.
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Base
    @interface ValueObject {
    }

    /**
     * See <a href="https://martinfowler.com/eaaCatalog/money.html">Money</a>
     * {@link Language.Form#Problem}: A large proportion of the computers in this world manipulate money, so it's always puzzled me that money isn't actually a first class data type in any mainstream programming language.
     * {@link Language.Form#Solution}: The good thing about object-oriented programming is that you can fix these problems by creating a Money class that handles them. Of course,
     * it's still surprising that none of the mainstream base class libraries actually do this.
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Base
    @interface Money {
    }

    /**
     * See <a href="https://martinfowler.com/eaaCatalog/specialCase.html">SpecialCase</a>
     * {@link Language.Form#Problem}: Nulls are awkward things in object-oriented programs because they defeat polymorphism.
     * {@link Language.Form#Solution}: Instead of returning null, or some odd value, return a Special Case that has the same interface as what the caller expects.
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Base
    @Pattern.NullObject
    @interface SpecialCase {
    }

    /**
     * See <a href="https://martinfowler.com/eaaCatalog/plugin.html">Plugin</a>
     * {@link Language.Form#Problem}:
     * {@link Language.Form#Solution}: Plugin solves both problems by providing centralized, runtime configuration. Links classes during configuration rather than compilation.
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Base
    @interface Plugin {
    }

    /**
     * See <a href="https://martinfowler.com/eaaCatalog/serviceStub.html">ServiceStub</a>
     * {@link Language.Form#Problem}: Enterprise systems often depend on access to third-party services such as credit scoring, tax rate lookups, and pricing engines.
     * Any developer who has built such a system can speak to the frustration of being dependent on resources completely out of his control.
     * Feature delivery is unpredictable, and as these services are often remote reliability and performance can suffer as well.
     * {@link Language.Form#Solution}: Enterprise systems often depend on access to third-party services such as credit scoring, tax rate lookups, and pricing engines.
     * Any developer who has built such a system can speak to the frustration of being dependent on resources completely out of his control.
     * Feature delivery is unpredictable, and as these services are often remote reliability and performance can suffer as well.
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Base
    @interface ServiceStub {
    }

    /**
     * See <a href="https://martinfowler.com/eaaCatalog/recordSet.html">RecordSet</a>
     * {@link Language.Form#Problem}: These data-aware UI frameworks rely on the fact that the underlying data is rela-tional, and they provide UI widgets of various kinds that make it easy to view and manipulate this data with almost no programming.
     * {@link Language.Form#Solution}: The idea of the Record Set is to give you your cake and let you eat it,
     * by pro-viding an in-memory structure that looks exactly like the result of an SQL query but can be generated and manipulated by other parts of the system.
     */
    @DesignPattern
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @Patterns.Base
    @interface RecordSet {
    }

    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @interface Performance {

        /**
         * Response time is the amount of time it takes for the system to process a request from the outside.
         * This may be a UI action, such as pressing a button, or a server API call.
         */
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.ANNOTATION_TYPE})
        @Patterns.Base
        @interface ResponseTime {
        }

        /**
         * Responsiveness is about how quickly the system acknowledges a request as opposed to processing it.
         * This is important in many systems because users may become frustrated if a system has low responsiveness,
         * even if its {@link ResponseTime} is good. If your system waits during the whole request, then your responsiveness and response time are the same.
         * However, if you indicate that you've received the request before you complete,
         * then your responsiveness is better. Providing a progress bar during a file copy improves the responsiveness of
         * your user interface, even though it doesn't improve response time
         */
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.ANNOTATION_TYPE})
        @Patterns.Base
        @interface Responsiveness {
        }

        /**
         * Latency is the minimum time required to get any form of response, even if the work to be done is nonexistent.
         * For {@link EIP.Performance.MessagingLatency} {@link #value} {@link #timeUnit} time for one message to travel through the system
         */
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.ANNOTATION_TYPE})
        @Patterns.Base
        @Related.Patterns(EIP.Performance.MessagingLatency.class)
        @interface Latency {
            long value();

            String timeUnit();
        }

        /**
         * Throughput is how much stuff you can do in a given amount of time.
         * If you're timing the copying of a file, throughput might be measured in bytes per second. For enterprise applications a typical measure is
         * transactions per second (tps), but the problem is that this depends on the complexity of your transaction.
         * For your particular system you should pick a common set of transactions.
         * For {@link EIP.Performance.MessagingThroughput} {@link #value} is a number of messages processed {@link #per} per time unit
         */
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.ANNOTATION_TYPE})
        @Patterns.Base
        @Related.Patterns(EIP.Performance.MessagingThroughput.class)
        @interface Throughput {
            long value();

            String per();
        }

        /**
         * Load is a statement of how much stress a system is under, which might be measured in how many users are currently connected to it.
         */
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.ANNOTATION_TYPE})
        @Patterns.Base
        @interface Load {
        }

        /**
         * Load sensitivity is an expression of how the response time varies with the load.
         * Let's say that system A has a response time of 0.5 seconds for 10 through 20 users and system B has a response time of 0.2 seconds for 10
         * users that rises to 2 seconds for 20 users. In this case system A has a lower load sensitivity than system B.
         * We might also use the term degradation to say that system B degrades more than system A.
         */
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.ANNOTATION_TYPE})
        @Patterns.Base
        @interface LoadSensitivity {
        }

        /**
         * Efficiency is performance divided by resources.
         * A system that gets 30 tps on two CPUs is more efficient than a system that gets 40 tps on four identical CPUs.
         */
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.ANNOTATION_TYPE})
        @Patterns.Base
        @interface Efficiency {
        }

        /**
         * The capacity of a system is an indication of maximum effective throughput or load.
         * This might be an absolute maximum or a point at which the performance dips below an acceptable threshold.
         */
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.ANNOTATION_TYPE})
        @Patterns.Base
        @interface Capacity {
        }

        /**
         * Scalability is a measure of how adding resources (usually hardware) affects performance.
         * A scalable system is one that allows you to add hardware and get a commensurate performance improvement, such as doubling
         * how many servers you have to double your throughput.
         * {@link Vertical} {@link Scalability}, or scaling up, means adding more power to a single server, such as more memory.
         * {@link Horizontal} {@link Scalability}, or scaling out, means adding more servers.
         */
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.ANNOTATION_TYPE})
        @Patterns.Base
        @interface Scalability {
            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.ANNOTATION_TYPE})
            @Patterns.Base
            @interface Vertical {
            }

            @Documented
            @Inherited
            @Retention(RetentionPolicy.SOURCE)
            @Target({ElementType.ANNOTATION_TYPE})
            @Patterns.Base
            @interface Horizontal {
            }
        }

    }

}
