/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package superfy.functions.types;
import java.util.Collection;
import java.util.List;
import superfy.functions.BinaryFunction;

/**
 *
 * @author haswellj
 */
public class Lists {

	public static <T> BinaryFunction<? extends Collection<T>, ? extends Collection<T>, T> append() {
		return new BinaryFunction<Collection<T>, Collection<T>, T>() {
			@Override
			public final Collection<T> apply(final Collection<T> fst, final T snd) {
				fst.add(snd);
				return fst;
			}
		};
	}

	public static <T> BinaryFunction<? extends List<T>, ? extends List<T>, T> prepend() {
		return new BinaryFunction<List<T>, List<T>, T>() {
			@Override
			public final List<T> apply(final List<T> fst, final T snd) {
				fst.add(0, snd);
				return fst;
			}
		};
	}

}
