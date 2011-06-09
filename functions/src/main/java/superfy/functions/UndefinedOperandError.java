/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package superfy.functions;

import javax.annotation.Nonnull;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import static javax.annotation.meta.When.*;
/**
 * This error indicates that a function is not defined for a set of operands.  Usually,
 * encountering this error means that a developer has not enforced preconditions sufficiently
 * to call a function. This error, like all Superfy exceptions, is unchecked.
 * @author haswellj
 */
public class UndefinedOperandError extends RuntimeException {

	private final List<Object> offendingOperands;


	public UndefinedOperandError(
		String message, 
		List<Object> offendingOperands
	) {
		super(message);
		this.offendingOperands = offendingOperands;
	}

	public UndefinedOperandError(String message) {
		this(message, Collections.emptyList());
	}


	/**
	 * Return the offending (undefined) operands underlying this error
	 * @return a list of the offending operands
	 */
	@Nonnull(when = ALWAYS)
	public List<Object> getOffendingOperands() {
		return offendingOperands;
	}
}