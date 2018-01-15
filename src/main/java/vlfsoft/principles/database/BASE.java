package vlfsoft.principles.database;

import vlfsoft.patterns.enterprise.peaa.FPEAA;
import vlfsoft.tags.Related;

import java.lang.annotation.*;

/**
 * See <a href="http://queue.acm.org/detail.cfm?id=1394128">Base: An Acid Alternative</a>
 * Basically Available, Soft state, Eventual consistency
 */
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.ANNOTATION_TYPE})
@Related.Patterns({FPEAA.Patterns.EventDrivenArchitecture.class,CompensatingTransaction.class})
public @interface BASE {


}
