/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package superfy.functions.traversable;



import java.util.Arrays;
import superfy.functions.Traversable;

/**
 *
 * @author haswellj
 */
public class TraversableTestCase {

	protected <T> Traversable<T> traversableFor(Iterable<T> elements) {
		return new Traversable<T>(elements);
	}

	protected <T> Traversable<T> traversableFor(T...elements) {
		return traversableFor(Arrays.asList(elements));
	}
}
