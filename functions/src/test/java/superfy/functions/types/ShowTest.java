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
public class ShowTest {

	
	@Test
	public void ensureShowOnNonNullObjectReturnsStringRepresentationOfObject() {
		final Object anyObject = new Object();
		assertThat(Any.show().apply(anyObject), is(equalTo(String.valueOf(anyObject))));
	}
	
	@Test
	public void ensureShowOnNullObjectReturnsStringRepresentationOfNull() {
		final Object nullObject = null;
		assertThat(
			Any.show().apply(nullObject), 
			is(equalTo(String.valueOf((Object)null)))
		);
	}
}
