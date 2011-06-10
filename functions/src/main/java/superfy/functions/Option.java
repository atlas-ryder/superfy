/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package superfy.functions;

import javax.annotation.Nonnull;
import javax.annotation.meta.When;
import superfy.common.annotations.advice.Factory;

/**
 * This class represents the monadic Option type.
 * @param <T> The type of the contents of the option
 * @author haswellj
 */
public abstract class Option<T> {

	private Option() {}


	/**
	 * Determine whether this option is some or none in lieu of
	 * pattern-matching in Java.
	 */
	public abstract boolean isSome();



	@Nonnull(when = When.ALWAYS)
	@Factory(returns = Some.class)
	public static <T> Some<T> some(T value) {
		return new Some<T>(value);
	}




	public static final class Some<T> extends Option<T> {
		private final T element;
		private Some(T element) {
			this.element = element;
		}

		@Override
		public boolean isSome() {
			return true;
		}

	}

}
