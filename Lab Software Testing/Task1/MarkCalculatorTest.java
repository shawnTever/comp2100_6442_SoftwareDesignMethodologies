/**
 * Sample code with JUnit 4 for the parameterized test
 * 
 */

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class MarkCalculatorTest {
	/**
	 * Return a list of parameters which are different implementation of 
	 * interface {@linkplain MarkCalculator}. 
	 * Do NOT Modify this part
	*/
	@Parameters
    public static Iterable<? extends Object> getImplementations() {
        return Arrays.asList(
                new MarkCalculator0(),
                new MarkCalculator1(),
                new MarkCalculator2(),
                new MarkCalculator3(),
                new MarkCalculator4(),
                new MarkCalculator5(),
                new MarkCalculator6(),
                new MarkCalculator7(),
                new MarkCalculator8(),
                new MarkCalculator9()
        );
    }
	
	@Parameter
	public MarkCalculator calculator;
	
	
	// ########## YOUR CODE STARTS HERE ##########
	
	/* EXAMPLE Test case 1 */
	@Test(expected = ComponentOutOfRangeException.class)
	public void testException() throws ComponentOutOfRangeException {
		this.calculator.calculateMark(-1, 0, 0, 0, true);
	}

	/* EXAMPLE Test case 2 */
	@Test
	public void testGradeN() throws ComponentOutOfRangeException {
		assertEquals(new MarkGrade(0, Grade.N), this.calculator.calculateMark(0, 0, 0, 0, true));
	}
	
	//TODO: write other test cases
	@Test(expected = ComponentOutOfRangeException.class)
	public void testLabException1() throws ComponentOutOfRangeException {
		this.calculator.calculateMark(-1, 0, 0, 0, true);
	}

	@Test(expected = ComponentOutOfRangeException.class)
	public void testLabException2() throws ComponentOutOfRangeException {
		this.calculator.calculateMark(11, 0, 0, 0, true);
	}

	@Test(expected = ComponentOutOfRangeException.class)
	public void testAss1Exception1() throws ComponentOutOfRangeException {
		this.calculator.calculateMark(0, -1, 0, 0, true);
	}
	@Test(expected = ComponentOutOfRangeException.class)
	public void testAss1Exception2() throws ComponentOutOfRangeException {
		this.calculator.calculateMark(0, 11, 0, 0, true);
	}
	@Test(expected = ComponentOutOfRangeException.class)
	public void testAss2Exception1() throws ComponentOutOfRangeException {
		this.calculator.calculateMark(0, 0, -1, 0, true);
	}
	@Test(expected = ComponentOutOfRangeException.class)
	public void testAss2Exception2() throws ComponentOutOfRangeException {
		this.calculator.calculateMark(0, 0, 11, 0, true);
	}

	@Test(expected = ComponentOutOfRangeException.class)
	public void testFinalException() throws ComponentOutOfRangeException {
		this.calculator.calculateMark(0, 0, 0, -1, true);
		this.calculator.calculateMark(0, 0, 0, 101, true);
	}

	@Test
	public void notAttendedFinal() throws ComponentOutOfRangeException {
		assertEquals(new MarkGrade(null, Grade.NCN), this.calculator.calculateMark(9, 9, 6, 0, false));
		assertEquals(new MarkGrade(null, Grade.NCN), this.calculator.calculateMark(10, 10, 10, 0, false));
	}

	@Test
	public void testGrade() throws ComponentOutOfRangeException {
		assertEquals(new MarkGrade(44, Grade.N), this.calculator.calculateMark(0, 0, 0, 74, true));
		assertEquals(new MarkGrade(14, Grade.N), this.calculator.calculateMark(9, 0, 3, 0, true));

		assertEquals(new MarkGrade(45, Grade.PX), this.calculator.calculateMark(1, 1, 0, 70, true));
		assertEquals(new MarkGrade(49, Grade.PX), this.calculator.calculateMark(5, 1, 0, 70, true));

		assertEquals(new MarkGrade(50, Grade.P), this.calculator.calculateMark(2, 7, 8, 43, true));
		assertEquals(new MarkGrade(59, Grade.P), this.calculator.calculateMark(6, 3, 4, 70, true));

		assertEquals(new MarkGrade(60, Grade.C), this.calculator.calculateMark(7, 3, 3, 74, true));
		assertEquals(new MarkGrade(69, Grade.C), this.calculator.calculateMark(7, 2, 10, 74, true));

		assertEquals(new MarkGrade(70, Grade.D), this.calculator.calculateMark(8, 7, 6, 70, true));
		assertEquals(new MarkGrade(79, Grade.D), this.calculator.calculateMark(8, 7, 8, 80, true));

		assertEquals(new MarkGrade(80, Grade.HD), this.calculator.calculateMark(9, 10, 5, 80, true));
		assertEquals(new MarkGrade(100, Grade.HD), this.calculator.calculateMark(10, 10, 10, 100, true));

		assertEquals(new MarkGrade(44, Grade.N), this.calculator.calculateMark(0, 0, 0, 74, true));
		assertEquals(new MarkGrade(14, Grade.N), this.calculator.calculateMark(9, 0, 3, 0, true));

	}
	// ########## YOUR CODE ENDS HERE ##########
}
