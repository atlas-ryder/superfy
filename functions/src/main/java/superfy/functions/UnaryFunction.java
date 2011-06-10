/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package superfy.functions;

/**
 * This class represents a relation F from {@code <T>} to {@code <U>}. 
 * For example, integer negation may be represented by this interface as follows:
 * <code>
 *   UnaryFunction<Integer, Integer> negate = new UnaryFunction<Integer, Integer>() {
 *   		public Integer apply(Integer x) {
 *  			return -x;
 *      }
 *   }
 * </code>
 * Or, to map an object to its string representation, one could use:
 * 
 * <code>
 *   UnaryFunction<String, Object> show = new UnaryFunction<String, Object>() {
 *   		public String apply(Object x) {
 * 				return String.valueOf(x);
 *      }
 *   }
 * </code>
 * Additionally, instances of this are good candidates to safely wrap exceptions
 * into an Option monad.  For example, if you have a String that may contain
 * a value formatted as an Integer, you can convert the String into an integer via
 * a function like:
 * <code>
 * 	UnaryFunction<Option<Integer>, String> intParser = new UnaryFunction<Option<Integer>, String>() {
 *  	public Option<Integer> apply(String input) {
 * 			try {
 * 				return Option.some(Integer.parseInt(input));
 * 			} catch(NumberFormatException ex) {
 * 				return Option.<Integer>none();
 * 			}
 * 		}
 *  }
 * </code>
 * 
 * It's recommended that implementations be stateless, but this is not enforced.
 * @see superfy.functions.Option;
 * @author haswellj
 */
public interface UnaryFunction<T, U> {

	/**
	 * Apply this function on an element of its domain {@code u} to yield an element
	 * of its image {@code t}.  This function doesn't always have to succeed.  If it fails, (or could fail), 
	 * it's usually good to return an option containing the success or failure.
	 * @param u element of its image to transform
	 * @return the results of the transformation
	 */
	T apply(U u);
	
}
