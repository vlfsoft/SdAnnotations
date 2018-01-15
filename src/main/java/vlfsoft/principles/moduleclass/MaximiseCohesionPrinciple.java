package vlfsoft.principles.moduleclass;

import vlfsoft.principles.ProgrammingPrinciple;
import vlfsoft.principles.intermoduleclass.MinimiseCouplingPrinciple;
import vlfsoft.tags.DDDEvansTag;
import vlfsoft.tags.Related;

import java.lang.annotation.*;

/**
 * See <a href="https://en.wikipedia.org/wiki/Cohesion_(computer_science)">Cohesion (computer science)</a>
 * The degree to which the elements inside a module belong together. In one sense, it is a measure of the strength of relationship between the methods and data of a class and some unifying purpose or concept served by that class.
 *
 * See <a href="http://java-design-patterns.com/principles/#maximise-cohesion">Maximise Cohesion</a>
 * {@link DDDEvansTag}: The twin fundamentals of high cohesion and low coupling play a role in design at all scales, from individual methods up through classes and MODULES to large-scale structures.
 * https://en.wikipedia.org/wiki/Cohesion_(computer_science)
 *
 */
@ProgrammingPrinciple.ModuleClass
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.ANNOTATION_TYPE})
@Related.Patterns(MinimiseCouplingPrinciple.class)
public @interface MaximiseCohesionPrinciple {
    boolean value();
}
