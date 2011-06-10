/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package superfy.functions.types;

import superfy.common.annotations.advice.Factory;
import javax.annotation.Nonnull;
import superfy.common.annotations.advice.Stateful;
import superfy.functions.UnaryFunction;

import static javax.annotation.meta.When.*;
/**
 *
 * @author haswellj
 */
public class Any {

	private static final UnaryFunction<String, Object> showAny;
	private static final UnaryFunction<?, ?> identity;

	static {
		showAny = new Show(); 
		identity = new Identity();
	}

	@Stateful(NEVER)
	@Nonnull(when = ALWAYS)
	@Factory(returns = UnaryFunction.class)
	public static UnaryFunction<String, Object> show() {
		return showAny;
	}

	@Stateful(NEVER)
	@Nonnull(when = ALWAYS)
	@Factory(returns = UnaryFunction.class)
	public static <T> UnaryFunction<T, T> identity() {
		return (UnaryFunction<T, T>) identity;
	}


	private Any() {
	}


	static final class Identity<T> implements UnaryFunction<T, T> {
		@Override
		public T apply(T u) {
			return u;
		}
	}

	static final class Show implements UnaryFunction<String, Object> {
		@Override
		public String apply(Object u) {
			return String.valueOf(u);
		}
	}
}

