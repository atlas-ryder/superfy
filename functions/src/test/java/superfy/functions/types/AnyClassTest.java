/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package superfy.functions.types;

import java.util.logging.Logger;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
/**
 *
 * @author haswellj
 */
public class AnyClassTest {

	@Test(expected = IllegalAccessException.class)
	public void ensureAnyCannotBeConstructedViaConstructor() throws Exception {
		Any.class.newInstance();	
	}
}
