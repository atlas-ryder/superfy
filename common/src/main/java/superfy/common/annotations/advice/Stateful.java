/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package superfy.common.annotations.advice;

/**
 *
 * @author haswellj
 */
public @interface Stateful {
	State value() default State.UNKNOWN; 
}
