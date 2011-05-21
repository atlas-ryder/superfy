/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package superfy.functions;

import java.util.Arrays;


/**
 *
 * @author haswellj
 */
public abstract class SeqTestCase {

	protected <T> Seq<T> seq(T...items) {
		return seq(Arrays.asList(items));
	}


	protected abstract <T> Seq<T> seq(Iterable<T> items);


}
