/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package superfy.functions.types;

import org.junit.Test;
import superfy.functions.Show;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
/**
 *
 * @author haswellj
 */
public class ShowTest {


	@Test
	public void ensureThatShowOnObjectReturnsStringValueOfObject() {
		final Object anyObject = new Object();
		assertThat(
			new Show().apply(anyObject), 
			is(equalTo(String.valueOf(anyObject)))
		);
	}

}
