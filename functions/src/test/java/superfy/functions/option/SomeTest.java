/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package superfy.functions.option;


import superfy.functions.Option;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
/**
 *
 * @author haswellj
 */
public class SomeTest {


	@Test(expected = IllegalAccessException.class)
	public void ensureSomeCannotBeInstantiatedDirectly() throws Exception {
		Option.Some.class.newInstance();
	}


	@Test
	public void ensureSomeFactoryReturnsSome() {
		final Object anyValue = new Object();
		assertThat(Option.some(anyValue).isSome(), is(true));
	}


	@Test
	public void ensureSomeConstructedOverElementContainsElement() {
		
	}
}
