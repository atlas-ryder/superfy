/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package superfy.functions;

/**
 *
 * @author haswellj
 */
public interface UnaryFunction<T, U> {

	T apply(U argument);
}
