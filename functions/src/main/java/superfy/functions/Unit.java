/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package superfy.functions;

import javax.annotation.Nonnull;
import superfy.common.annotations.advice.Factory;
import superfy.common.annotations.advice.Singleton;

import static javax.annotation.meta.When.ALWAYS;


/**
 * A unit represets a type that can hold exactly one value, and thus no
 * information.  This class is used throughout Superfy instead of Java's native
 * {@code void} type, and we recommend adhering to this policy wherever Superfy
 * is used.  This type is roughly equivalent to java.lang.Void, but is not compatible
 * with it for simplicity and consistency.  This may change at some point.
 * @author haswellj
 */
@Singleton(ALWAYS)
public final class Unit {

	private static final int unitHashCode;
	private static final String stringValue;

	static {
		unitHashCode = 31;
		stringValue = "()::Unit";
	}


	private Unit() {

	}

	@Override 
	@Nonnull(when = ALWAYS)
	public String toString() {
		return stringValue;	
	}


	@Override
	public int hashCode() {
		return unitHashCode;
	}

	@Override
	public boolean equals(Object o) {
		if(o == this) return true;
		if(o == null) return false;
		if(o.getClass().equals(Unit.class)) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @return the one and only instance of this class.  Guaranteed to never
	 * return null
	 */
	@Nonnull(when = ALWAYS)
	@Factory(returns = Unit.class)
	public static Unit unit() {
		return Holder.INSTANCE;
	}


	static final class Holder {
		static final Unit INSTANCE = new Unit();
	}


}
