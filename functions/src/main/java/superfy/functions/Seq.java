/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package superfy.functions;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

/**
 *
 * @author haswellj
 */
public final class Seq<T> implements Iterable<T> {

	private final Iterable<T> iterator;
	public Seq(T...elements) {
		this(Arrays.asList(elements));
	}

	public Seq(Iterable<T> iterator) {
		this.iterator = iterator == null ? Collections.<T>emptyList() : iterator;
	}


	public <U> Seq<U> map(final UnaryFunction<U, T> transformation) {
		final Iterator<T> iter = iterator();
		return new Seq<U>(new Iterable<U>(){
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
						throw new UnsupportedOperationException(
							"Map Iterator won't allow changes to map cardinality"
						);
					}
				};
			}
		});
	}

	@Override
	public Iterator<T> iterator() {
		return iterator.iterator();
	}

}
