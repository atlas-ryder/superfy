/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package superfy.functions;

/**
 * Marker interface for lazy abstractions.  Be careful calling some of the usual
 * Java operations (equals, toString, .hashCode()) on these as they might not be finite.
 * @author haswellj
 */
public interface Lazy {


	/**
	 * Determine whether this lazy object is equal to another.  This method
	 * must be strict, otherwise, it could potentially fail.
	 * @param o the object to compare for equality
	 * @return true iff this lazy object is equal to another lazy object
	 */
	@Override
	public boolean equals(Object o);

	/**
	 * Return a string representation of this lazy object.  May omit its actual structure (be
	 * lazy)
	 * @return a string representation of this object.
	 */
	@Override
	public String toString();

}
