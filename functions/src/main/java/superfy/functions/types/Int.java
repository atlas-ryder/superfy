/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package superfy.functions.types;

import superfy.functions.BinaryFunction;

/**
 *
 * @author haswellj
 */
public final class Int {

	private Int() {}

	private static final BinaryFunction<Integer, Integer, Integer> add;

	static {
		add = new BinaryFunction<Integer, Integer, Integer>() {
			@Override
			public Integer apply(Integer fst, Integer snd) {
				return fst + snd;
			}
		};
	}

	public static BinaryFunction<Integer, Integer, Integer> add() {
		return add;
	}
}
