package vlfsoft.principles.intermoduleclass;

import vlfsoft.principles.ProgrammingPrinciple;
import vlfsoft.principles.moduleclass.MaximiseCohesionPrinciple;
import vlfsoft.tags.DDDEvansTag;
import vlfsoft.tags.Related;

import java.lang.annotation.*;

/**
 * See <a href="http://java-design-patterns.com/principles/#minimise-coupling">Minimise coupling principle</a>
 * {@link DDDEvansTag} Low coupling is fundamental to object design. When you can, go all the way. Eliminate all other concepts from the picture.
 * Then the class will be completely self-contained and can be studied and understood alone. Every such self-contained class significantly eases the burden of understanding a MODULE.
 */
@ProgrammingPrinciple.InterModule
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.ANNOTATION_TYPE})
@Related.Patterns(MaximiseCohesionPrinciple.class)
public @interface MinimiseCouplingPrinciple {
    boolean value();
}
