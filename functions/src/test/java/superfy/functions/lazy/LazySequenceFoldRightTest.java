/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package superfy.functions.lazy;
import superfy.functions.Seq;
import superfy.functions.SeqFoldRightTestCase;

/**
 *
 * @author haswellj
 */
public class LazySequenceFoldRightTest extends SeqFoldRightTestCase {

	@Override
	protected <T> Seq<T> seq(Iterable<T> items) {
		return new LazySequence<T>(items);
	}
}
