/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package superfy.functions;



import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 *
 * @author haswellj
 */
public class UnitTest {

	@Test
	public void ensureUnitTypeIsUnique() {
		assertThat(Unit.unit(), is(equalTo(Unit.unit())));
		assertThat(Unit.unit(), is(sameInstance(Unit.unit())));
	}

	@Test
	public void ensureUnitTypeHashCodeIsSameForAllUnits() {
		assertThat(
			Unit.unit().hashCode(), 
			is(equalTo(Unit.unit().hashCode()))
		);
	}

	@Test(expected = IllegalAccessException.class)
	public void ensureUnitCannotBeInstantiatedViaConstructor() throws Exception {
		Unit.class.newInstance();
	}

}
