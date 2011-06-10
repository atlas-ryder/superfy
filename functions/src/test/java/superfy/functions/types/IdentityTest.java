/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package superfy.functions.types;


import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
/**
 *
 * @author haswellj
 */
public class IdentityTest {

	@Test
	public void ensureIdentityOperationReturnsSameInstance() {
		final Object anyElement = new Object();
		assertThat(
			Any.identity().apply(anyElement), 
			is(sameInstance(anyElement))
		);
	}


	@Test
	public void ensureIdentityDoesNotThrowExceptionOnNull() {
		final Object nullElement = null;
		assertThat(Any.identity().apply(nullElement), is(nullValue()));
	}

}
