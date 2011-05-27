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
	 * Fold this sequence into the accumulated value via the specified transformation.
	 * This fold operates from left-to-right and cannot be made lazy.
	 * @param transformation the transformation to combine elements of this sequence
	 * with the accumulator
	 * @param acc the accumulator to fold this sequence into
	 * @param <U> The type of the result of this function
	 * @return this sequence folded into the specified value
	 */
	<U> U foldl(U acc, final BinaryFunction<U, U, T> transformation);

	/**
	 * Fold this sequence into the accumulated value via the specified transformation.
	 * This fold operates from right to left.
	 * @param <U>
	 * @param acc
	 * @param transformation
	 * @return
	 */
	<U> U foldr(U acc, final BinaryFunction<U, U, T> transformation);

	<U> Seq<U> scanl(U acc, final BinaryFunction<U, U, T> transformation);


	@Override 
	public boolean equals(Object other);

	@Override 
	public int hashCode();

	@Override
	public String toString();


}
