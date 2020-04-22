package math;

/**
 * A class that provides test cases for the
 * factorial function of the MyMath class
 * 
 * @author louka (loukas.pap@hotmail.gr)
 * @since April 2020
 */

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class MyMathTest {

	/* 
	 * A reference to the MyMath class which 
	 * functions we are testing in this class
	 */
	MyMath mm = new MyMath();
	
	/*
	 *  A test case for n equal to 0.
	 */
	@Test
	public void testFactorialForNTequalsTo0() {
		Assert.assertEquals(1, mm.factorial(0));
	}
	
	/*
	 *  A test case with a normal input.
	 */
	@Test
	public void testFactorial_WithNormalInput() {
		Assert.assertEquals(120, mm.factorial(5));
	}
	
	/*
	 *  A test case for the exception caused when the input is <0.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testFactorial_ShouldThrowExceptionForNLessThan0() {
		Assert.assertEquals("n should be between 0 and 12", mm.factorial(-5));
	}
	
	/*
	 * A test case for the exception caused when the input is >12.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testFactorial_ShouldThrowExceptionForNBiggerThan12() {
		Assert.assertEquals("n should be between 0 and 12", mm.factorial(14));
	}
	
	
	/**
	 * Test for isPrime function
	 */
	
	/*
	 * Test case with normal input
	 */
	@Test
	public void testPrime_WithNormalInput() {
		Assert.assertTrue(mm.isPrime(337));
	}
	
	@Rule
	public ExpectedException thrown = ExpectedException.none(); //Initializing to .none()
	
	/*
	 * A test case for the exception caused when the inut is negative
	 */
	@Test
	public void testPrime_ShouldThrowExceptionOnNegativeInput() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("n should be bigger or equal to 2");
		mm.isPrime(-2600);
	}
	
	/*
	 * A test case for the exception caused when the input is 0
	 */
	@Test
	public void testPrime_ShouldThrowExceptionOn0AsAnInput() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("n should be bigger or equal to 2");
		mm.isPrime(0);
	}
	
	/*
	 * A test case for the exception caused when the input is MAX_VALUE
	 */
	@Test
	public void testPrime_ShouldThrowExceptionOnMaxValueAsAnInput() {
		Assert.assertTrue(mm.isPrime(Integer.MAX_VALUE));
	}
	
}
