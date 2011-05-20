/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package superfy.functions;
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
public class SeqTestCase {

	@Test
	public void testMapCollectionOfNonNullItems() {
		Seq<Integer> seq = new Seq<Integer>(1,2,3,4,5);
		assertThat(
			eval.strict(seq.map(Any.<Integer>show()), new ArrayList<String>()),
			is(equalTo(Arrays.asList("1", "2", "3","4","5")))
		);
	}

	@Test
	public void testMapSingletonCollectionOfNullItems() {
		Seq<Integer> seq = new Seq<Integer>((List<Integer>)null);
		assertThat(
			eval.strict(seq.map(Any.<Integer>show()), new ArrayList<String>()),
			is(equalTo(Collections.<String>emptyList()))
		);
	}

	@Test
	public void testMapCollectionOfNullItems() {
		Seq<Integer> seq = new Seq<Integer>(null, null);
		final String valueOfNull = String.valueOf((Object)null);
		assertThat(
			eval.strict(seq.map(Any.<Integer>show()), new ArrayList<String>()),
			is(equalTo(Arrays.<String>asList(valueOfNull, valueOfNull)))
		);
	}

	@Test
	public void testMapEmptyCollection() {
		Seq<Integer> seq = new Seq<Integer>();
		assertThat(
			eval.strict(seq.map(Any.<Integer>show()), Collections.<String>emptyList()),
			is(equalTo(Collections.<String>emptyList()))
		);
	}
}
