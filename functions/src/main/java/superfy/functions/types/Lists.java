/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package superfy.functions.types;
import java.util.List;
import superfy.functions.BinaryFunction;

/**
 *
 * @author haswellj
 */
public class Lists {

	public static <T> BinaryFunction<List<T>, List<T>, T> append() {
		return new BinaryFunction<List<T>, List<T>, T>() {
			@Override
			public final List<T> apply(final List<T> fst, final T snd) {
				fst.add(snd);
				return fst;
			}
		};
	}
}
