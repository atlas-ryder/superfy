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
import superfy.functions.nice.F2;

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

	@Override
	public <U> Seq<U> map(final UnaryFunction<U, T> transformation) {
		return null;
	}

	@Override
	public <U> U foldl(final U acc, final BinaryFunction<U, U, T> transformation) {
		U accumulatedValue = acc;
		for(T item : this) {
			accumulatedValue = transformation.apply(accumulatedValue, item);
		}
		return accumulatedValue;
	}


	@Override
	public <U> U foldr(final U acc, final BinaryFunction<U, U, T> transformation) {
		return foldRight(acc, transformation, iterator());
	}

	private <U> U foldRight(final U acc, final BinaryFunction<U, U, T> t, final Iterator<T> iter) {
		if(iter.hasNext()) {
			final T next = iter.next();
			return t.apply(foldRight(acc, t, iter), next);
		}
		return acc;
	}

	@Override
	public Iterator<T> iterator() {
		return iterator.iterator();
	}

	@Override
	public <U> Seq<U> scanl(U acc, BinaryFunction<U, U, T> transformation) {

		return null;
	}


	@Override
	public boolean equals(Object o) {
		if(o == null) return false;
		if(o == this) return true;
		if(o.getClass().equals(getClass())) {
			final Iterator<T> yours = ((Seq<T>)o).iterator();
			final Iterator<T> mine = iterator();
			while(mine.hasNext() || yours.hasNext()) {
				if(mine.hasNext() && yours.hasNext()) {
					final T yourNext = yours.next();
					final T myNext = mine.next();
					if(yourNext != myNext) return false;
					else if(myNext != null && !myNext.equals(yourNext)) return false;
					else if(yourNext != null && !yourNext.equals(myNext)) return false;
				} else return false;
			}
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		for(final T item : this) {
			hash += item == null ? 0 : item.hashCode();
		}
		return hash;
	}

	@Override
	public String toString() {
		return foldl(
			new StringBuilder().append("{LazySequence=["),
			new F2<StringBuilder, StringBuilder, T>() {
				@Override
				public StringBuilder apply(StringBuilder fst, T snd) {
					return fst.append(" (").append(snd).append(')');
				}
			}
		).append("]}").toString();
	}

	static final class MapIterator<T, U> implements Iterator<T> {
		final Iterator<U> domain;
		final UnaryFunction<T, U> transformation;
		MapIterator(
		 final Iterator<U> domain,
		 final UnaryFunction<T, U> transformation
		)	{
			this.domain = domain;
			this.transformation = transformation;
		}

		@Override
		public boolean hasNext() {
			return domain.hasNext();
		}

		@Override
		public T next() {
			return transformation.apply(domain.next());
		}

		@Override
		public void remove() {

		}
	}

	static final class IteratorWrapper<T> implements Iterable<T> {
		final Iterator<T> iterator;
		public IteratorWrapper(final Iterator<T> iterator) {
			if(iterator == null)
				throw new IllegalStateException(
					"Error!  Promised that Iterator would never be null--it was"
				);
			this.iterator = iterator;
		}

		@Override
		public Iterator<T> iterator() {
			return iterator;
		}
	}
}


