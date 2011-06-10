/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package superfy.functions;

import org.junit.Test;

/**
 *
 * @author haswellj
 */
public class OptionTest {

	@Test(expected = IllegalAccessException.class)
	public void ensureThatOptionCannotBeInstantiatedViaConstructor() throws Exception {
		Option.class.newInstance();	
	}


}
