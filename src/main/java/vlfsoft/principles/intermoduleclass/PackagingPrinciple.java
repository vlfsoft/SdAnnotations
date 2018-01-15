package vlfsoft.principles.intermoduleclass;

import vlfsoft.principles.ProgrammingPrinciple;

import java.lang.annotation.*;

/**
 * See <a href="https://dzone.com/articles/happy-packaging">Happy Packaging!</a>
 * Packages should never depend on sub-packages.
 * Sub-packages should not introduce new concepts, just more details.
 * Packages should reflect business-concepts, not technical ones.
 */
@ProgrammingPrinciple.InterModule
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.ANNOTATION_TYPE})
public @interface PackagingPrinciple {
    boolean neverDependOnSubPackages();
    boolean subPackagesJustMoreDetails();
    boolean reflectBusinessConcepts();
}
