/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package superfy.functions;
/**
 *
 * @author haswellj
 */
public interface BinaryFunction<T, U, V> {

	T apply(U fst, V snd);
}
