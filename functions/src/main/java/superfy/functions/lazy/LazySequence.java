/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package superfy.functions.lazy;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import superfy.functions.BinaryFunction;
import superfy.functions.Lazy;
import superfy.functions.Seq;
import superfy.functions.UnaryFunction;

/**
 *
 * @author haswellj
 */
final class LazySequence<T> implements Seq<T>, Lazy {
	private final Iterable<T> iterator;

	public LazySequence(T...elements) {
		this(Arrays.asList(elements));
	}

	public LazySequence(Iterable<T> iterator) {
		this.iterator = iterator == null ? Collections.<T>emptyList() : iterator;
	}

	/**
	 *
	 * @param <U>
	 * @param transformation
	 * @return
	 */
	@Override
	public <U> Seq<U> map(final UnaryFunction<U, T> transformation) {
		final Iterator<T> iter = iterator();
		return new LazySequence<U>(new Iterable<U>() {
			@Override
			public Iterator<U> iterator() {
				return new Iterator<U>() {

					@Override
					public boolean hasNext() {
						return iter.hasNext();
					}

					@Override
					public U next() {
						return transformation.apply(iter.next());
					}

					@Override
					public void remove() {
						throw new UnsupportedOperationException("Map Iterator won't allow changes to map cardinality");
					}
				};
			}
		});
	}

	@Override
	public <U> U foldl(U acc, BinaryFunction<U, U, T> transformation) {
		U accumulatedValue = acc;
		for(T item : this) {
			accumulatedValue = transformation.apply(accumulatedValue, item);
		}
		return accumulatedValue;
	}

	@Override
	public Iterator<T> iterator() {
		return iterator.iterator();
	}

}
