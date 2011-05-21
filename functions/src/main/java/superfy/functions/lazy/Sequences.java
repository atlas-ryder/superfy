/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package superfy.functions.lazy;
import superfy.functions.Seq;

/**
 *
 * @author haswellj
 */
public class Sequences {

	public static <T> Seq<T> seq(T...items) {
		return new LazySequence<T>(items);
	}

	public static <T> Seq<T> seq(Iterable<T> items) {
		return new LazySequence<T>(items);
	}
}
