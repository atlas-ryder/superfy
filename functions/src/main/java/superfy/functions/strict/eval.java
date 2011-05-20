/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package superfy.functions.strict;
import java.util.Collection;

/**
 *
 * @author haswellj
 */
public class eval {

	/**
	 * Evaluate a lazy sequence into a strict collection.  If the specified collection
	 * is null, this function does nothing.  If the lazy sequence is infinite, this function
	 * never returns. If the target collection contains items, the items in the lazy
	 * sequence are appended.
	 *
	 * @param <T> The type of element contained in the lazy sequence
	 * @param <U> The strict collection to fill with the values in the lazy sequence.
	 * @param sequence
	 * @param target
	 * @return the collection
	 */
	public static <
		T,
		U extends Collection<T>
	> U strict(Iterable<T> sequence, U target) {
		if(target != null) {
			for(T item : sequence) {
				target.add(item);
			}
			return target;
		} 
		return null;
	}
}
