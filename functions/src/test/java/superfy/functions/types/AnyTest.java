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
public class AnyTest {


	@Test
	public void ensureShowAppliedToNullReturnsStringValueOfNull() {
		assertThat(
			Any.show().apply(null),
			is(equalTo(String.valueOf((Object)null)))
		);
	}

	@Test
	public void ensureShowAppliedToObjectReturnsStringValueOfObject() {
		final Object anyObject = new Object();
		assertThat(
			Any.show().apply(anyObject),
			is(equalTo(String.valueOf(anyObject)))
		);
	}

	@Test
	public void ensureShowAppliedToPrimitiveReturnsStringValueOfPrimitive() {
		final int anyPrimitive = 1;
		assertThat(
			Any.show().apply(anyPrimitive),
			is(equalTo(String.valueOf(anyPrimitive)))
		);
	}

}