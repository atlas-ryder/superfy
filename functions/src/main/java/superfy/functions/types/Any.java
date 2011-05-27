/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package superfy.functions.types;
import superfy.functions.UnaryFunction;

/**
 *
 * @author haswellj
 */
public class Any {
	private Any(){}

	/**
	 * This is definitely thread-safe, so avoid object-creation by reusing.
	 */
	private static final UnaryFunction<String, ?> show;

	static {
		show = new UnaryFunction<String, Object>() {
			@Override
			public String apply(Object argument) {
				return String.valueOf(argument);
			}
		};
	}
	/**
	 * Create and return a function mapping the type to its string representation.
	 * @param <T> The type to map to a string
	 * @return a unary function F: T x String -gt; String
	 */
	@SuppressWarnings("unchecked")
	public static <T> UnaryFunction<String, T> show() {
		return (UnaryFunction<String, T>) show;
	}
}
