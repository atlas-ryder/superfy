/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package superfy.functions.traversable;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import superfy.functions.Traversable;


import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 *
 * @author haswellj
 */
public class IterationTest extends TraversableTestCase {

	@Test
	public void assertThatEmptyTraversableHasNoElements() {
		assertThat(traversableFor().iterator().hasNext(), is(false));
	}

	@Test
	public void assertThatTraversableConstructedFromNullDoesNotThrowExceptionWhenIteratorIsAccessed() {
		final Iterable nullIterable = null;
		assertThat(traversableFor(nullIterable).iterator().hasNext(), is(false));
	}

	@Test
	public void assertThatTraversableConstructedFromOneElementHasOneElement() {
		final Object anyValue = new Object();
		final Iterable<Object> singletonIterable = Collections.singleton(anyValue);
		final Iterator<Object> backingIterator = singletonIterable.iterator();
		assertThat(backingIterator.hasNext(), is(true));
		backingIterator.next();
		assertThat(backingIterator.hasNext(), is(false));
	}

	@Test
	public void assertThatTraversableConstructedFromOneElementContainsOnlyThatElement() {
		final Object anyValue = new Object();
		final Iterable<Object> singletonIterable = Collections.singleton(anyValue);
		final Iterator<Object> backingIterator = singletonIterable.iterator();
		assertThat(backingIterator.hasNext(), is(true));
		assertThat(backingIterator.next(), is(sameInstance(anyValue)));
		assertThat(backingIterator.hasNext(), is(false));
	}

	@Test
	public void assertThatTraversableConstructedFromMultipleElementsContainsExactlyThoseElements() {
		final List<Object> anyContent = Arrays.asList("one", 2, "3", new Object());
		final Traversable<Object> traversableContainingContent = traversableFor(anyContent);
		for(Object content : traversableContainingContent) {
			assertTrue(anyContent.contains(content));
		}
	}
}
