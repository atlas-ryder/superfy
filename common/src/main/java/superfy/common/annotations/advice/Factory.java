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

/**
 * This annotation is used to provide information about factory methods and classes, specifically
 * the type they construct.
 * @author haswellj
 */
@Documented
@Retention(
	RetentionPolicy.RUNTIME
)
@Target({
	ElementType.METHOD, 
	ElementType.TYPE
})
public @interface Factory {
	Class<?> returns() default Object.class;
}
