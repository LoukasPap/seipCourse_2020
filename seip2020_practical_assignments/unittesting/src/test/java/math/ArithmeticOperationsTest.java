package math;

/**
 * A class that provides test cases
 * for the divide and multiply function
 * of the ArithmeticOperations class
 * 
 * @author louka (loukas.pap@hotmail.gr)
 * @since April 2020
 */

import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Assert;
import org.junit.Rule;

public class ArithmeticOperationsTest {

	/* 
	 * A reference to the ArithmeticOperations class
	 * which functions we are testing in this class.
	 */
	ArithmeticOperations ao = new ArithmeticOperations();
	

	/*
	 * A test case with normal inputs.
	 * 
	 * In order to do that, we are using the:
	 * @function Assert.assertEquals(double expected, double actual, double delta)
	 * @param delta is the maximum distance that the expected and actual values are allowed 
	 * to have, before the assertion is false.
	 */
	@Test
	public void testDivide_WithNormalInputs() {
		Assert.assertEquals(4, ao.divide(10.0, 2.5), 0); //We put delta=0 so that we have preciseness on our results
	}

	/*
	 * A test case with numerator equal to 0
	 */
	@Test
	public void testDivide_WithNumeratorEqualTo0() {
		ao.divide(0.0, 60.0);
	}

	/*
	 * A test case for the exception thrown when denominator is 0.
	 */
	@Test(expected = ArithmeticException.class)
	public void testDivide_ShouldThrowExceptionOnDenominatorEqualsTo0() {
		ao.divide(2.5, 0.0);
	}

	/*
	 * A test case for the exception thrown 
	 * when the result of the division
	 * is bigger than the maximum value of a double.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testDivide_ShouldThrowExceptionOnDivisionBiggerThanMAXVALUE() {
		ao.divide(Double.MAX_VALUE, 0.5);
	}

	/*
	 * A test case for the exception thrown 
	 * when the result of the division
	 * is less than the minimum value of double.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testDivide_ShouldThrowExceptionOnDivisionLessThanMINVALUE() {
		ao.divide(Double.MAX_VALUE, -0.5);
	}
	

	/*
	 * A test case with normal inputs.
	 */
	@Test
	public void testMultiply_WithNormalInputs() {
		Assert.assertEquals(1200, ao.multiply(40, 30));
	}
	
	/*
	 * A test case with x as 0.
	 */
	@Test
	public void testMultiply_WithXas0() {
		Assert.assertEquals(0, ao.multiply(0, 30));
	}
	
	/*
	 * A test case with y as 0.
	 */
	@Test
	public void testMultiply_WithYas0() {
		Assert.assertEquals(0, ao.multiply(578, 0));
	}	
	
	@Rule
	public ExpectedException thrown = ExpectedException.none(); //Initializing to .none()
		
	/*
	 * A test case for the exception thrown when all arguments are negative.
	 */
	@Test
	public void testMultiply_ShouldThrowExceptionOnNegativeInputsXandY() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("x and y should be >= 0");
		ao.multiply(-240, -20);
	}

	/*
	 * A test case for the exception thrown when x is negative.
	 */
	@Test
	public void testMultiply_ShouldThrowExceptionOnNegativeInputX() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("x and y should be >= 0");
		ao.multiply(-240, 20);
	}

	/*
	 * A test case for the exception thrown when y is negative.
	 */
	@Test
	public void testMultiply_ShouldThrowExceptionOnNegativeArgumenInputY() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("x and y should be >= 0");
		ao.multiply(240, -20);
	}

	/*
	 * A test case for the exception thrown when the result of multiplication
	 * is bigger than the maximum value of a double because of x.
	 */
	@Test
	public void testMultiply_ShouldThrowExceptionOutOfBoundsProductBecauseOfX() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("The product does not fit in an Integer variable");
		ao.multiply(Integer.MAX_VALUE, 240);
	}

	/*
	 * A test case for the exception thrown when the result of multiplication
	 * is bigger than the maximum value of a double due to y.
	 */
	@Test
	public void testMultiply_ShouldThrowExceptionOnOutOfBoundsProductBecauseOfY() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("The product does not fit in an Integer variable");
		ao.multiply(240, Integer.MAX_VALUE);
	}

}
