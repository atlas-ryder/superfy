/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package superfy.functions.lazy;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 *
 * @author haswellj
 */
@RunWith(Suite.class)
@SuiteClasses({
	LazySequenceMapTest.class,
	LazySequenceFoldLeftTest.class,
	LazySequenceFoldRightTest.class,
	LazySequenceOperationsTest.class,
	LazySequenceScanLeftTest.class 
})
public class LazySequenceTest {
}
