/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package superfy.functions;
import java.util.Collections;
import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.matchers.JUnitMatchers.*;

/**
 *
 * @author haswellj
 */
@Ignore
public abstract class SeqOperationsTestCase extends SeqTestCase {


	@Test
	public void ensureEmptySequenceIsEmpty() {
		assertThat(
			seq().iterator().hasNext(),
			is(false)
		);
	}

	@Test
	public void ensureEmptySequenceHasSameValuesAsEmptySequence() {
		assertThat(seq(), hasItems());
	}



	@Test
	public void ensureEmptySequencesAreEqual() {
		assertThat(seq(), is(equalTo(seq())));
	}
	@Test
	public void ensureNullSequencesAreEqual() {
		assertThat(seq((Iterable<Integer>)null), is(equalTo(this.<Integer>seq())));
		assertThat(seq(), is(equalTo(seq((Iterable)null))));
	}

	@Test
	public void  ensureEmptySequenceIsNotEqualToNonEmptySequence() {
		final Object anyElement = new Object();
		assertThat(seq(anyElement), is(not(equalTo(seq()))));
		assertThat(seq(), is(not(equalTo(seq(anyElement)))));
	}




	@Test
	public void ensureSingletonSequencesContainingIdenticalElementsAreEqual() {
		final Object anyElement = new Object();
		assertThat(seq(anyElement), is(equalTo(seq(anyElement))));
	}

	@Test
	public void ensureSingletonSequenceContainingNullIsNotEqualToSingletonSequenceContainingNonNull() {
		final Object anyElement = new Object();
		assertThat(
			seq(Collections.singletonList(null)),
			is(not(equalTo((seq(anyElement)))))
		);

		assertThat(
			seq(anyElement),
			is(not(equalTo(seq(Collections.singletonList(null)))))
		);
	}

	@Test
	public void ensureLongerSequenceIsNotEqualToShorterSequence() {
		final Object fstAnyObject = null;
		final Object sndAnyObject = new Object();
		final Seq left = seq(fstAnyObject, sndAnyObject);
		final Seq right = seq(fstAnyObject);
		assertThat(left, is(not(equalTo(right))));
		assertThat(right, is(not(equalTo(left))));
	}

}
