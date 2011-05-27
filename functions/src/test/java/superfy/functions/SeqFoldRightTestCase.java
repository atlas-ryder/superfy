/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package superfy.functions;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.List;
import superfy.functions.types.Int;
import java.util.Collections;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
/**
 *
 * @author haswellj
 */
public abstract class SeqFoldRightTestCase extends SeqTestCase {
	@Test
	public void ensureFoldRightOnNullListReturnsAccumulator() {
		final int anyInt = 17;
		assertThat(
			this.<Integer>seq((Iterable<Integer>)null).foldr(anyInt, Int.add()),
			is(equalTo(anyInt))
		);
	}


	@Test
	public void ensureFoldRightOnEmptySeqReturnsAccumulator() {
		final int anyInt = 17;
		assertThat(
			this.<Integer>seq().foldr(anyInt, Int.add()),
			is(equalTo(anyInt))
		);
	}

	@Test
	public void ensureFoldRightOnSingletonListReturnsSingleFold() {
		final int anyInt = 17;
		final int doubleAny = 2 * anyInt;
		assertThat(
			this.<Integer>seq(Collections.singleton(anyInt)).foldr(anyInt, Int.add()),
			is(equalTo(doubleAny))
		);
	}

	@Test
	public void ensureFoldRightOnSingletonArgumentReturnsSingleFold() {
		final int anyInt = 17;
		final int doubleAny = 2 * anyInt;
		assertThat(
			this.<Integer>seq(anyInt).foldr(anyInt, Int.add()),
			is(equalTo(doubleAny))
		);
	}

	@Test
	public void ensureFoldRightOnListContainingNoNullsReturnsCorrectFold() {
		final Seq<Integer> anySequence = this.<Integer>seq(1,2,3,4,5);
		final Integer expectedSum = 15;
		assertThat(anySequence.foldr(0, Int.add()), is(equalTo(expectedSum)));
	}

	@Test
	public void ensureFoldingListIntoListReturnsListReversed() {
		final Seq anySequence = seq(1, null, 3, 4, 5);
		final List expectedResult = (Arrays.asList(1, null, 3, 4, 5));
		Collections.reverse(expectedResult);
		final List actualResult = (List) anySequence.foldr(
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
