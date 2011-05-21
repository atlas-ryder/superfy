/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package superfy.functions;

/**
 *
 * @author haswellj
 */
public interface Seq<T> extends Iterable<T> {

	/**
	 * Map this sequence to another via the specified transformation.
	 * This operation preserves the following identities:
	 *
	 * Given:
	 * Seq a = [1,2,3]
	 * a.map(Any.identity()).equals(a)
	 * a.map(f).map(f.inverse()).equals(a)
	 * @param <U>
	 * @param transformation
	 * @return
	 */
	<U> Seq<U> map(final UnaryFunction<U, T> transformation);

	/**
	 *
	 * @param <U>
	 * @param transformation
	 * @return
	 */
	<U> U foldl(U acc, final BinaryFunction<U, U, T> transformation);


}
