/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package superfy.functions;

import java.util.Collections;
import java.util.Iterator;
import java.util.logging.Logger;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.meta.When;

/**
 *
 * @author haswellj
 */
public class Traversable<T> implements Iterable<T>{


	private final Iterable<T> elements;

	/**
	 * Construct a new traversable over the specified iterable. If the value 
	 * provided is null, a new traversable backed by an empty iterable is created 
	 * (exceptions due to null are not thrown by this class)
	 * @param elements the elements to back this iterable by
	 */
	public Traversable(@Nullable Iterable<T> elements) {
		this.elements = 
			elements = elements == null ? 
			Collections.<T>emptyList() : elements;
	}

	@Override
	public Iterator<T> iterator() {
		return elements.iterator();
	}

}
