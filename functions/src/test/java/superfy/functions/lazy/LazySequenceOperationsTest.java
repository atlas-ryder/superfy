/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package superfy.functions.lazy;

import java.util.logging.Logger;
import superfy.functions.Seq;
import superfy.functions.SeqOperationsTestCase;

/**
 *
 * @author haswellj
 */
public class LazySequenceOperationsTest extends SeqOperationsTestCase{

	private static final Logger logger;

	static {
		logger = Logger.getLogger(LazySequenceOperationsTest.class.getName());
	}

	public LazySequenceOperationsTest() {
	}

	@Override
	protected <T> Seq<T> seq(Iterable<T> items) {
		return new LazySequence<T>(items);
	}
}
