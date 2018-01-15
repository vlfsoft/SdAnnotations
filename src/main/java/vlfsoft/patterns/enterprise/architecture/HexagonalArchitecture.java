package vlfsoft.patterns.enterprise.architecture;

import vlfsoft.patterns.design.DesignPattern;

import java.lang.annotation.*;

/**
 * See <a href="http://java-design-patterns.com/patterns/hexagonal/">HexagonalArchitecture Architecture</a>
 * See <a href="http://alistair.cockburn.us/Hexagonal+architecture">Hexagonal architecture</a>
 *
 *  The connection between the {@link InsidePart} and the {@link OutsidePart} of our application is realized via
 *  abstractions called {@link Port}s and their implementation counterparts called {@link Adapter}s.
 *
 *  The Left-Right Asymmetry
 *  The ports and adapters pattern is deliberately written pretending that all ports are fundamentally similar. That pretense is useful at the architectural level.
 *  In implementation, ports and adapters show up in two flavors, which I’ll call {@link Port.Primary}/{@link Adapter.Primary} and {@link Port.Secondary}/{@link Adapter.Secondary},
 *  for soon-to-be-obvious reasons. They could be also called ‘’driving’’ adapters and ‘’driven’’ adapters.
 *  This is related to the idea from use cases of “primary actors” and “secondary actors”.
 *  A ‘’primary actor’’ is an actor that drives the application (takes it out of quiescent state to perform one of its advertised functions).
 *  A ‘’secondary actor’’ is one that the application drives, either to get answers from or to merely notify.
 *  The distinction between ‘’primary ‘’and’’ secondary ‘’lies in who triggers or is in charge of the conversation.
 *
 */
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({})
@DesignPattern(aka = "Ports & Adapters")
public @interface HexagonalArchitecture {

    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE})
    @interface InsidePart {
    }

    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE})
    @interface OutsidePart {
    }

    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @interface Port {
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE})
        @interface Primary {
        }
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE})
        @interface Secondary {
        }
    }

    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.ANNOTATION_TYPE})
    @interface Adapter {
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE})
        @interface Primary {
        }
        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE})
        @interface Secondary {
        }
    }

}
