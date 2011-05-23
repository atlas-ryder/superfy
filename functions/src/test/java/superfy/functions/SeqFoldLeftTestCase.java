/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package superfy.functions;

import java.util.LinkedList;
import java.util.Arrays;
import java.util.List;
import superfy.functions.types.Int;
import org.junit.Ignore;
import java.util.Collections;
import org.junit.Test;
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

	@Test
	public void ensureFoldLeftOnListContainingNoNullsReturnsCorrectFold() {
		final Seq<Integer> anySequence = this.<Integer>seq(1,2,3,4,5);
		final Integer expectedSum = 15;
		assertThat(anySequence.foldl(0, Int.add()), is(equalTo(expectedSum)));
	}

	@Test
	public void ensureFoldingListIntoListReturnsList() {
		final Seq anySequence = seq(1, null, 3, 4, 5);
		final List expectedResult = Arrays.asList(1, null, 3, 4, 5);
		final List actualResult = (List) anySequence.foldl(
			new LinkedList(),
			new BinaryFunction<List, List, Object>() {
			@Override
			public List apply(List fst, Object snd) {
				fst.add(snd);
				return fst;
			}
		});
		assertThat(actualResult, is(equalTo(expectedResult)));
	}

}
