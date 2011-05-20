/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package superfy.functions.types;
import java.util.logging.Logger;
import superfy.functions.UnaryFunction;

/**
 *
 * @author haswellj
 */
public class Any {
	private Any(){}

	/**
	 * Create and return a function mapping the type to its string representation.
	 * @param <T> The type to map to a string
	 * @return a unary function F: T x String -gt; String
	 */
	public static <T> UnaryFunction<String, T> show() {
		return new UnaryFunction<String, T>() {
			@Override
			public String apply(T argument) {
				return String.valueOf(argument);
			}
		};
	}
}
