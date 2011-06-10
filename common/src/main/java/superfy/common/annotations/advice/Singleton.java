/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package superfy.common.annotations.advice;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.annotation.meta.When;

/**
 * Types annotated with this element must be singletons.
 * @author haswellj
 */
@Documented
@Retention(
	RetentionPolicy.RUNTIME
)
@Target(ElementType.TYPE)
public @interface Singleton {
	When value() default When.ALWAYS;
}
