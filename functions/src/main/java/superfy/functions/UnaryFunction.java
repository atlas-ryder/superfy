/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package superfy.functions;

import javax.annotation.Nullable;

/**
 * This interface specified a function with arity 1 defining the relation {@code F} on
 * two sets {@code T} and {@code U} {@code F: U -&gt; T}.  This interface does not impose any
 * restrictions on the injectivity, surjectivity, bijectivity, or definition of this operator on
 * an element. Actual implementations that do not accept elements should explicitly state so.  The
 * default behavior is that {@code null} is accepted, though this is not required by implementations. 
 * The user should interpret the {@code @Nullable} as suggestions applicable to this interface, not
 * as strictures.
 * 
 * As with all functions, we recommend that they be reentrant (or preferably referentially
 * transparent), although there is no practical way to enforce this.  Generators (NullaryFunctions) in particular
 * are generally stateful, and the impact of this feature should be limited.
 * 
 * 
 * The author disagrees with the notion that exceptions should be checked.  Therefore, this interface does not admit 
 * the specification of exceptions in its signature.  Moreover, Superfy function definitions try to adhere to the mathematical
 * formalism of functions, and it's not clear what the mathematical analog of a function throwing an exception is (except for being
 * undefined at that element).  Superfy provides the UndefinedOperationError, which should be taken as a <i>very serious exception!</i>.  If a function
 * is not defined at a point and throws this exception, then it should be considered a programmer error as undefined values should not
 * be passed to functions within Superfy
 * 
 * @param <T>  The image of this function
 * @param <U> The domain of this function
 * @see superfy.functions.UndefinedOperandError
 * @author haswellj
 */
public interface UnaryFunction<T, U> {


	/**
	 * Apply this function to the specified element.  
	 * @param item
	 * @return 
	 */
	@Nullable T apply(@Nullable U item);
}
