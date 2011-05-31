/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package superfy.functions;
import java.util.Iterator;

/**
 *
 * @author haswellj
 */
public abstract class Option<T> implements Seq<T>, Iterator<T> {

	public static <T> Option<T> some(T anyObject) {

		throw new UnsupportedOperationException("Not yet implemented");
	}

	public abstract boolean isSome();



	public final class Some<T> extends Option<T> {

		private final T element;
		public Some(final T element) {
			this.element = element;
		}


		@Override
		public boolean isSome() {
			return true;
		}

		@Override
		public <U> Seq<U> map(UnaryFunction<U, T> transformation) {
			return some(transformation.apply(element));
		}

		@Override
		public <U> U foldl(U acc, BinaryFunction<U, U, T> transformation) {
			return transformation.apply(acc, element);
		}

		@Override
		public <U> U foldr(U acc, BinaryFunction<U, U, T> transformation) {
			return foldl(acc, transformation);
		}

		@Override
		public <U> Seq<U> scanl(U acc, BinaryFunction<U, U, T> transformation) {
			throw new UnsupportedOperationException("Not supported yet.");
		}

		@Override
		public Iterator<T> iterator() {
			throw new UnsupportedOperationException("Not supported yet.");
		}

		@Override
		public boolean hasNext() {
			throw new UnsupportedOperationException("Not supported yet.");
		}

		@Override
		public T next() {
			throw new UnsupportedOperationException("Not supported yet.");
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException("Not supported yet.");
		}

	}
}
