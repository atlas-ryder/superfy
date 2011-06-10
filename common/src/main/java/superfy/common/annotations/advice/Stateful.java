/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package superfy.common.annotations.advice;

import javax.annotation.meta.When;

/**
 *
 * @author haswellj
 */
public @interface Stateful {
	When value() default When.NEVER; 
	
}
