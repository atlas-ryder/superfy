/* To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package superfy.functions;

import org.junit.runners.Suite;
import org.junit.runner.RunWith;
import org.junit.Test;

import org.junit.Ignore;
import java.util.List;
import java.util.Collections;
import superfy.functions.types.Any;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Test;
import superfy.functions.strict.eval;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import superfy.functions.option.*;

/**
 *
 * @author haswellj
 */
@RunWith(Suite.class)
@SuiteClasses({

})
public class OptionTest {


	@Test
	public void ensureSomeReturnsSome() {
		final Object anyObject = null;
		assertTrue(Option.some(anyObject).isSome());
	}
	@Test
	public void ensureSomeContainsOneItem() {
		final Object anyObject = null;
		assertTrue(Option.some(anyObject).hasNext());
		assertEquals(Option.some(anyObject).next(), is(equalTo(anyObject)));
	}




}
