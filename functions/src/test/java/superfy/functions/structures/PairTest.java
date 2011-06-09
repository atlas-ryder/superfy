/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package superfy.functions.structures;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
/**
 *
 * @author haswellj
 */
public class PairTest {


	@Test
	public void ensurePairConstructorConstructsPairsFstAndSnd() {
		final Object anyFst = 1;
		final Object anySnd = 5;

		assertThat(new Pair(anyFst, anySnd).fst, is(equalTo(anyFst)));
		assertThat(new Pair(anyFst, anySnd).snd, is(equalTo(anySnd)));
	}

	@Test
	public void ensureSwapReversesElements() {
		final Object anyFstNotEqualToSnd = 1;
		final Object anySndNotEqualToFst = 15;
		final Pair p1 = new Pair(anyFstNotEqualToSnd, anySndNotEqualToFst);
		final Pair p2 = p1.swap();
		assertThat(p1.fst, is(equalTo(p2.snd)));
		assertThat(p1.snd, is(equalTo(p2.fst)));
	}
	@Test
	public void ensurePairConstructorPlacesFstInFstAndSndInSnd() {
		final Object fstDistinctFromSnd = new Object();
		final Object sndDistinctFromFst = new Object();
		final Pair pair = new Pair(fstDistinctFromSnd, sndDistinctFromFst);
		assertThat(pair.fst, is(not(equalTo(sndDistinctFromFst))));
		assertThat(pair.snd, is(not(equalTo(fstDistinctFromSnd))));
	}

	@Test
	public void ensurePairConstructorOnPairConstructsPair() {
		final Object anyFst = new Object();
		final Object anySnd = new Object();
		final Pair p1 = new Pair(anyFst, anySnd);
		final Pair p2 = new Pair(p1);
		assertThat(p1, is(equalTo(p2)));
		assertThat(p2, is(equalTo(p1)));
	}

	@Test
	public void ensurePairConstructorConstructsNullFstAndSndWhenPassedNullsForFstAndSnd() {
		assertThat(new Pair(null, null).fst, is(nullValue()));
		assertThat(new Pair(null, null).snd, is(nullValue()));
	}

	@Test
	public void ensurePairConstructorConstructsNullFstAndNonNullSndWhenFstIsNullAndSndIsNotNull() {
		final Object anySnd = new Object();
		final Object nullFst = null;
		final Pair pair = new Pair(nullFst, anySnd);
		assertThat(pair.fst, is(nullValue()));
		assertThat(pair.fst, is(equalTo(nullFst)));
		assertThat(pair.snd, is(not(nullValue())));
		assertThat(pair.snd, is(equalTo(anySnd)));
	}
	@Test
	public void ensurePairConstructorConstructsNullSndAndNonNullFstWhenSndIsNullAndFstIsNotNull() {
		final Object nullSnd = null;
		final Object anyFst = new Object();
		final Pair pair = Pair.pair(anyFst, nullSnd);
		assertThat(pair.fst, is(not(nullValue())));
		assertThat(pair.fst, is(equalTo(anyFst)));
		assertThat(pair.snd, is(nullValue()));
		assertThat(pair.snd, is(equalTo(nullSnd)));
	}




	@Test
	public void ensurePairFactoryConstructsPairsFstAndSnd() {
		final Object anyFst = 1;
		final Object anySnd = 5;

		assertThat(Pair.pair(anyFst, anySnd).fst, is(equalTo(anyFst)));
		assertThat(Pair.pair(anyFst, anySnd).snd, is(equalTo(anySnd)));
	}

	@Test
	public void ensurePairEqualityHoldsForNonNullElements() {
		final Object anyFst = 1;
		final Object anySnd = 6;
		assertThat(
			Pair.pair(anyFst,anySnd), 
			is(equalTo(Pair.pair(anyFst, anySnd)))
		);
	}
	@Test
	public void ensurePairEqualityIsSymmetricForNonNullElements() {
		final Object anyFst = 1;
		final Object anySnd = 6;

		final Pair firstPair = Pair.pair(anyFst, anySnd);
		final Pair sndPair = Pair.pair(anyFst, anySnd);

		assertThat(firstPair, is(equalTo(sndPair)));
		assertThat(sndPair, is(equalTo(firstPair)));
	}

	@Test
	public void ensurePairEqualityIsReflexiveForNonNullElements() {
		final Pair pair = Pair.pair(new Object(), new Object());
		assertThat(pair, is(equalTo(pair)));
	}

	@Test
	public void ensurePairEqualityIsTransitiveForNonNullElements() {
		final Object anyFst = 19;
		final Object anySnd = 20;
		final Pair fst = Pair.pair(anyFst, anySnd);
		final Pair snd = Pair.pair(anyFst, anySnd);
		final Pair third = Pair.pair(anyFst, anySnd);

		assertThat(fst, is(equalTo(snd)));
		assertThat(snd, is(equalTo(third)));
		assertThat(fst, is(equalTo(third)));
		assertThat(third, is(equalTo(fst)));
	}

	@Test
	public void ensurePairEqualityIsOrderDependentForNonNullElements() {
		final Object anyFst = 19;
		final Object anySnd = 1;
		Pair fstSnd = Pair.pair(anyFst, anySnd);
		Pair sndFst = Pair.pair(anySnd, anyFst);
		assertThat(fstSnd, is(not(equalTo(sndFst))));
		assertThat(sndFst, is(not(equalTo(fstSnd))));
	}

	@Test
	public void ensureEquivalentPairsContainingNonNullItemsHaveSameHashCode() {
		final Object anyFst = 19;
		final Object anySnd = 20;
		Pair p1 = Pair.pair(anyFst, anySnd);
		Pair p2 = Pair.pair(anyFst, anySnd);
		assertThat(p1.hashCode(), is(equalTo(p2.hashCode())));
	}

	@Test
	public void ensureAnyPairIsNotEqualToNull() {
		final Object anyNotNull = new Object();
		final Object anyNotNull1 = new Object();
		final Object anyNull = null;
		final Pair pair = Pair.pair(anyNotNull, anyNotNull1);
		assertThat(pair.equals(anyNull), is(false));
		assertThat(pair, is(not(equalTo(null))));
	}

	@Test
	public void ensureComparingPairToNotPairReturnsFalse() {
		final Object anyNotPair = new Object();
		final Object anyFst = new Object();
		final Object anySnd = new Object();
		final Pair pair = new Pair(anyFst, anySnd);
		assertThat(pair.equals(anyNotPair), is(false));
		assertThat(pair, is(not(equalTo(anyNotPair))));
	}


	@Test(expected = IllegalArgumentException.class)
	public void ensureConstructingPairFromNullPairThrowsException() {
		Pair pair = new Pair(null);
	}
	
	@Test(expected = IllegalArgumentException.class) 
	public void ensureConstructingPairViaPairFactoryFromNullThrowsException() {
		Pair.pair(null);
	}
	


	@Test 
	public void ensureNullFstAndNonNullSndReferentialEqualityIsReflexive() {
		final Object nullFst = null;
		final Object anySnd = new Object();
		final Pair pair = new Pair(nullFst, anySnd);
		assertThat(pair.equals(pair), is(true));
	}

	@Test
	public void ensureNullFstAndNonNullSndStructuralEqualityIsReflexive() {
		final Object nullFst = null;
		final Object anySnd = new Object();
		final Pair pair = new Pair(nullFst, anySnd);
		final Pair pair2 = new Pair(nullFst, anySnd);
		assertThat(pair, is(equalTo(pair2)));
		assertThat(pair2, is(equalTo(pair)));
	}
	@Test
	public void ensureNullFstAndSndStructuralEqualityIsReflexive() {
		final Object nullFst = null;
		final Object nullSnd = null;
		final Pair p1 = Pair.pair(nullFst, nullSnd);
		assertThat(p1, is(equalTo(p1)));
	}

	@Test
	public void ensureNullFstAndSndStructuralEqualityIsSymmetric() {
		final Object nullFst = null;
		final Object nullSnd = null;
		final Pair p1 = Pair.pair(nullFst, nullSnd);
		final Pair p2 = Pair.pair(nullFst, nullSnd);
		assertThat(p1, is(equalTo(p2)));
		assertThat(p2, is(equalTo(p1)));
	}

	@Test
	public void ensureNullFstAndSndStructuralEqualityIsTransitive() {
	
		final Object nullFst = null;
		final Object nullSnd = null;
		final Pair p1 = Pair.pair(nullFst, nullSnd);
		final Pair p2 = Pair.pair(nullFst, nullSnd);
		final Pair p3 = Pair.pair(nullFst, nullSnd);

		assertThat(p1, is(equalTo(p2)));
		assertThat(p2, is(equalTo(p3)));
		assertThat(p1, is(equalTo(p3)));
	}

	@Test
	public void ensureNullFstAndNonNullSndHashCodeIsEqual() {
		final Object nullFst = null; 
		final Object anySnd = new Object();
		final Pair p1 = Pair.pair(nullFst, anySnd);
		final Pair p2 = Pair.pair(nullFst, anySnd);
		assertThat(p1.hashCode(), is(equalTo(p2.hashCode())));
		assertThat(p2.hashCode(), is(equalTo(p1.hashCode())));
	}
	@Test
	public void ensureNullSndAndNonNullFstHashCodeIsEqual() {
		final Object anyFst = new Object();
		final Object nullSnd = null; 
		final Pair p1 = Pair.pair(anyFst, nullSnd);
		final Pair p2 = Pair.pair(anyFst, nullSnd);
		assertThat(p1.hashCode(), is(equalTo(p2.hashCode())));
		assertThat(p2.hashCode(), is(equalTo(p1.hashCode())));
	}

	@Test
	public void ensureHashingFunctionsCorrectly() {
		Map<Pair<String, String>, String> m1 = new HashMap();
		final String p1FstString = "first string";
		final String p1SndString = "second string";
		final String p2FstString = "first string p2";
		final String p2SndString = "second string p2";
		final Pair p1 = Pair.pair(p1FstString, p1SndString);
		final Pair p2 = new Pair(p1);
		final Pair p3 = Pair.pair(p2FstString, p2SndString);

		final String expectedValue = "hello";
		m1.put(p1, expectedValue);
		assertTrue(m1.containsKey(p1));
		assertTrue(m1.containsKey(p2));
		assertFalse(m1.containsKey(p3));
		assertThat(m1.get(p1), is(equalTo(expectedValue)));
		assertThat(m1.get(p2), is(equalTo(expectedValue)));
		assertThat(m1.get(p3), is(nullValue()));

	}

}
