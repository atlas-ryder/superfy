/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package superfy.functions;

import superfy.functions.types.Int;
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
/**
 *
 * @author haswellj
 */
@Ignore
public abstract class SeqFoldLeftTestCase extends SeqTestCase {

	@Test
	public void ensureFoldLeftOnNullListReturnsAccumulator() {
		final int anyInt = 17;
		assertThat(
			this.<Integer>seq((Iterable<Integer>)null).foldl(anyInt, Int.add()),
			is(equalTo(anyInt))
		);
	}


	@Test
	public void ensureFoldLeftOnEmptySeqReturnsAccumulator() {
		final int anyInt = 17;
		assertThat(
			this.<Integer>seq().foldl(anyInt, Int.add()),
			is(equalTo(anyInt))
		);
	}

	@Test
	public void ensureFoldLeftOnSingletonListReturnsSingleFold() {
		final int anyInt = 17;
		final int doubleAny = 2 * anyInt;
		assertThat(
			this.<Integer>seq(Collections.singleton(anyInt)).foldl(anyInt, Int.add()),
			is(equalTo(doubleAny))
		);
	}

	@Test
	public void ensureFoldLeftOnSingletonArgumentReturnsSingleFold() {
		final int anyInt = 17;
		final int doubleAny = 2 * anyInt;
		assertThat(
			this.<Integer>seq(anyInt).foldl(anyInt, Int.add()),
			is(equalTo(doubleAny))
		);
	}
}
