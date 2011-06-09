/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package superfy.functions.types;

import javax.annotation.Nonnull;
import superfy.functions.UnaryFunction;
import static javax.annotation.meta.When.*;
/**
 * Utility Class containing functions applicable to any reference type (show, etc.)
 * @author haswellj
 */
public class Any {

	static final UnaryFunction<String, Object> mapObjectToString;

	static {
		mapObjectToString = new UnaryFunction<String, Object>() {
			@Override 
			public String apply(Object o) {
				return String.valueOf(o);
			}
		};
	}

	@Nonnull(when = ALWAYS)
	public static UnaryFunction<String, Object> show() {
		return mapObjectToString;
	}
}
