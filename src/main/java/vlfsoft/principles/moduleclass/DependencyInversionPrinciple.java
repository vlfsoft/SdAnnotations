package vlfsoft.principles.moduleclass;

import vlfsoft.principles.ProgrammingPrinciple;
import vlfsoft.tags.GOFTag;
import vlfsoft.tags.SOLIDTag;

import java.lang.annotation.*;

/**
 * See <a href="https://en.wikipedia.org/wiki/Dependency_inversion_principle">Dependency inversion principle</a>
 * the dependency inversion principle refers to a specific form of decoupling software modules.
 * When following this principle, the conventional dependency relationships established from high-level, policy-setting modules to low-level, dependency modules are reversed,
 * thus rendering high-level modules independent of the low-level module implementation details. The principle states:<ul>
 * <li> High-level modules should not depend on low-level modules. Both should depend on abstractions.
 * Java:
 * {@link Implementation.HighLevelModule} class should not contain fields with type {@link Implementation.LowLevelModule}.
 * {@link Implementation.HighLevelModule} class should contain fields with type {@link Abstraction} only.
 * <li> Abstractions should not depend on details. Details should depend on abstractions.
 * Java:
 * {@link Implementation} class implements/extends {@link Abstraction}
 * </ul>
 * This design principle inverts the way some people may think about object-oriented programming, dictating that both high- and low-level objects must depend on the same abstraction.
 */
@SOLIDTag
@ProgrammingPrinciple.ModuleClass
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.TYPE})
public @interface DependencyInversionPrinciple {

    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE})
    @interface Abstraction {

        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE})
        @GOFTag
        @interface Refined {
        }

    }

    /**
     * details
     */
    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE})
    @interface Implementation {

        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE})
        @interface HighLevelModule {
        }

        @Documented
        @Inherited
        @Retention(RetentionPolicy.SOURCE)
        @Target({ElementType.TYPE})
        @interface LowLevelModule {
        }

    }

}
