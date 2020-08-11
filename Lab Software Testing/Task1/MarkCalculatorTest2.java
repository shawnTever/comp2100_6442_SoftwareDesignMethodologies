/**
 * Sample code with JUnit 4 for the parameterized test
 *
 */

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class MarkCalculatorTest2 {

	/**
	 * Return a list of parameters which are different implementation of 
	 * interface {@linkplain MarkCalculator}. 
	 * Do NOT Modify this part
	*/
	@Parameters
	public static Iterable<? extends Object>  getImplementations() {
		return Arrays.asList(
				new MarkCalculator2(),
				new MarkCalculator5(),
				new MarkCalculator0(),
				new MarkCalculator4(),
				new MarkCalculator6(),
				new MarkCalculator3(),
				new MarkCalculator1(),
				new MarkCalculator7(),
				new MarkCalculator8(),
				new MarkCalculator9()
		   );
	}

	@Parameter
	public MarkCalculator calculator;


	/**
	 * Beginning of Your modification
	 *
	 */

	@Test(expected = ComponentOutOfRangeException.class)
	public void testException() throws ComponentOutOfRangeException {
		this.calculator.calculateMark(-1, 0, 0, 0, true);
	}
	@Test(expected = ComponentOutOfRangeException.class)
	public void testException1() throws ComponentOutOfRangeException {
		this.calculator.calculateMark(11, 0, 0, 0, true);
	}
	@Test(expected = ComponentOutOfRangeException.class)
	public void testException2() throws ComponentOutOfRangeException {
		this.calculator.calculateMark(0, -1, 0, 0, true);
	}
	@Test(expected = ComponentOutOfRangeException.class)
	public void testException3() throws ComponentOutOfRangeException {
		this.calculator.calculateMark(0, 11, 0, 0, true);
	}
	@Test(expected = ComponentOutOfRangeException.class)
	public void testException4() throws ComponentOutOfRangeException {
		this.calculator.calculateMark(0, 0, -1, 0, true);
	}
	@Test(expected = ComponentOutOfRangeException.class)
	public void testException5() throws ComponentOutOfRangeException {
		this.calculator.calculateMark(0, 0, -1, 0, true);
	}
	@Test(expected = ComponentOutOfRangeException.class)
	public void testException6() throws ComponentOutOfRangeException {
		this.calculator.calculateMark(0, 0, 11, 0, true);
	}
	@Test(expected = ComponentOutOfRangeException.class)
	public void testException7() throws ComponentOutOfRangeException {
		this.calculator.calculateMark(0, 0, 0, -1, true);
	}
	@Test(expected = ComponentOutOfRangeException.class)
	public void testException8() throws ComponentOutOfRangeException {
		this.calculator.calculateMark(0, 0, 0, 101, true);
	}

	@Test
	public void testGradeN() throws ComponentOutOfRangeException {
		assertEquals(new MarkGrade(0, Grade.N), this.calculator.calculateMark(0, 0, 0, 0, true));
		//TODO: write more test cases if you need
		assertEquals(new MarkGrade(44, Grade.N), this.calculator.calculateMark(0, 0, 0, 74, true));
		assertEquals(new MarkGrade(14, Grade.N), this.calculator.calculateMark(9, 0, 3, 0, true));
	}

	//TODO: write more test methods to test MarkCalculators
	@Test
	public void testGradePX() throws ComponentOutOfRangeException {
		assertEquals(new MarkGrade(45, Grade.PX), this.calculator.calculateMark(1, 1, 0, 70, true));
		assertEquals(new MarkGrade(49, Grade.PX), this.calculator.calculateMark(5, 1, 0, 70, true));

	}

	@Test
	public void testGradeP() throws ComponentOutOfRangeException {
		assertEquals(new MarkGrade(50, Grade.P), this.calculator.calculateMark(2, 7, 8, 43, true));
		assertEquals(new MarkGrade(59, Grade.P), this.calculator.calculateMark(6, 1, 6, 70, true));

	}

	@Test
	public void testGradeC() throws ComponentOutOfRangeException {
		assertEquals(new MarkGrade(60, Grade.C), this.calculator.calculateMark(7, 0, 6, 74, true));
		assertEquals(new MarkGrade(69, Grade.C), this.calculator.calculateMark(7, 6, 6, 74, true));

	}

	@Test
	public void testGradeD() throws ComponentOutOfRangeException {
		assertEquals(new MarkGrade(70, Grade.D), this.calculator.calculateMark(8, 7, 6, 70, true));
		assertEquals(new MarkGrade(79, Grade.D), this.calculator.calculateMark(8, 9, 6, 80, true));

	}

	@Test
	public void testGradeHD() throws ComponentOutOfRangeException {
		assertEquals(new MarkGrade(80, Grade.HD), this.calculator.calculateMark(9, 9, 6, 80, true));
		assertEquals(new MarkGrade(100, Grade.HD), this.calculator.calculateMark(10, 10, 10, 100, true));

	}

	@Test
	public void notAttendedFinal() throws ComponentOutOfRangeException {
		assertEquals(new MarkGrade(null, Grade.NCN), this.calculator.calculateMark(9, 9, 6, 0, false));
		assertEquals(new MarkGrade(null, Grade.NCN), this.calculator.calculateMark(10, 10, 10, 0, false));
	}

	/**
	 * End of Your modification
	 *
	 */

}
