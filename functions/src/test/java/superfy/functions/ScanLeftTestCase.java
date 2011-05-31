/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package superfy.functions;
import java.util.logging.Logger;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.List;
import superfy.functions.types.Int;
import org.junit.Ignore;
import java.util.Collections;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
/**
 *
 * @author haswellj
 */
@Ignore
public abstract class ScanLeftTestCase extends SeqTestCase {

	
	@Test
	public void ensureLeftScanOnEmptySeqIsInitialValue() {
		Seq<Integer> emptySequence = seq();
		final int anyAccumulator = 0;
		assertThat(
			emptySequence.scanl(anyAccumulator, Int.add()),
			is(equalTo(seq(anyAccumulator)))
		);
	}
}
