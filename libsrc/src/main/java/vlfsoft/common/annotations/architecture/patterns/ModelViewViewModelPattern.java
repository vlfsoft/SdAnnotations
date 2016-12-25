package vlfsoft.common.annotations.architecture.patterns;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * See <a href="https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93viewmodel">Model–view–viewmodelr</a>
 *
 * Declarative data- and command-binding are implicit in the MVVM pattern.
 * In the Microsoft solution stack, the binder is a markup language called XAML.[8]
 * The binder frees the developer from being obliged to write boiler-plate logic to synchronize the view model and view.
 * When implemented outside of the Microsoft stack the presence of a declarative databinding technology is a key enabler of the pattern
 *
 * A criticism of the pattern comes from MVVM creator John Gossman himself,[13]
 * who points out overhead in implementing MVVM is "overkill" for simple UI operations.
 * He states for larger applications, generalizing the ViewModel becomes more difficult.
 * Moreover, he illustrates data binding in very large applications can result in considerable memory consumption.
 */
@Inherited
@Documented
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface ModelViewViewModelPattern {

    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.METHOD})
    @interface Model {
    }

    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.METHOD})
    @interface View {
    }

    @Documented
    @Inherited
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.METHOD})
    @interface ViewModel {
    }

}
