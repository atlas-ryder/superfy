/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package superfy.functions;

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
public abstract class SeqMapTestCase extends SeqTestCase {
	@Test
	public void testMapCollectionOfNonNullItems() {
		Seq<Integer> seq = seq(1,2,3,4,5);
		assertThat(
			eval.strict(seq.map(Any.<Integer>show()), new ArrayList<String>()),
			is(equalTo(Arrays.asList("1", "2", "3","4","5")))
		);
	}

	@Test
	public void ensureMapNullCollectionIsSameAsMapEmptyCollection() {
		Seq<Integer> seq = seq((List<Integer>)null);
		assertThat(
			eval.strict(seq.map(Any.<Integer>show()), new ArrayList<String>()),
			is(equalTo(Collections.<String>emptyList()))
		);
	}

	@Test
	public void ensureMapCollectionOfNullItemsMapsToCollectionOfNullItems() {
		Seq<Integer> seq = seq(null, null);
		final String valueOfNull = String.valueOf((Object)null);
		assertThat(
			eval.strict(seq.map(Any.<Integer>show()), new ArrayList<String>()),
			is(equalTo(Arrays.<String>asList(valueOfNull, valueOfNull)))
		);
	}

	@Test
	public void ensureMapOnEmptyCollectionMapsToEmptyCollection() {
		Seq<Integer> seq = seq();
		assertThat(
			eval.strict(seq.map(Any.<Integer>show()), Collections.<String>emptyList()),
			is(equalTo(Collections.<String>emptyList()))
		);
	}

	@Test
	public void ensureMapIsInvertibleOnce() {
		Seq<Integer> intSeq = seq(1,2,3,4);
		Seq<String> stringSeq = seq("1", "2", "3", "4");
		assertThat()

	}

}
