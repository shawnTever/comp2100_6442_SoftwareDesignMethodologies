import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * 
 * You are given the java class called PathComplete, which has a method
 * called findSomething. Implement the minimum number of JUnit test cases to achieve 
 * path complete to the findSomething method. Write your test case(s) in the test() method
 * in the PathCompleteTest.java file. All test cases should pass the JUnit test. You are not
 * allowed to alter the signatures of the given methods and the package
 * structures of the given classes. Please upload ONLY the PathCompleteTest.java file to
 * Wattle for marking.
 *
 */
public class PathCompleteTest {

	@Test
	public void test() {
		// Implement your test cases
		// START YOUR CODE
		assertEquals(3, PathComplete.findSomething(3,2,1));
		assertEquals(3, PathComplete.findSomething(2,1,3));
		assertEquals(3, PathComplete.findSomething(1,3,2));
		assertEquals(3, PathComplete.findSomething(1,2,3));

		// END YOUR CODE
	}
}
