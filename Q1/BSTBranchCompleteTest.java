import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Fill in the items below with your UID and name:
 * @author: Xiyong Tian
 * @UID: u6782003
 */
public class BSTBranchCompleteTest {
	@Test(timeout=1000)
	public void test() {
		
		BranchComplete bc = new BranchComplete();

		// START YOUR CODE
		//HINT: assertEquals(xx, bc.DNATreeCalc(xx, xx, xx));
		assertEquals(0, bc.DNATreeCalc(0, 1, 2));
		assertEquals(58, bc.DNATreeCalc(30, 10, 10));
		assertEquals(30, bc.DNATreeCalc(30, 40, 2));
		// END YOUR CODE
	}
}
