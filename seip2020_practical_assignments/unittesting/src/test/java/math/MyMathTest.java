package math;

/**
 * A class that provides test cases for the
 * factorial function of the MyMath class
 * 
 * @author louka (loukas.pap@hotmail.gr)
 * @since April 2020
 */

import org.junit.Assert;
import org.junit.Test;


public class MyMathTest {

	/* 
	 * A reference to the MyMath class which 
	 * functions we are testing in this class
	 */
	MyMath mm = new MyMath();
	
	/*
	 *  A test case for the exception caused when the input is <0
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testFactorialShouldThrowExceptionForNLessThan0() {
		Assert.assertEquals("n should be between 0 and 12", mm.factorial(-5));
	}
	
	/*
	 * A test case for the exception caused when the input is >12
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testFactorialShouldThrowExceptionForNBiggerThan12() {
		Assert.assertEquals("n should be between 0 and 12", mm.factorial(14));
	}
	
	
/*	
 	Tests in case we need to test exceptions thrown on wrong type of arguments
 	
	@Ignore
	@Test(expected = Error.class)
	public void test_factorial_nShouldNotBeDouble() {
		Assert.assertEquals("n should not be double", mm.factorial(5.5));
	}
	@Ignore
	@Test(expected = Error.class)
	public void test_factorial_nShouldNotBeString() {
		Assert.assertEquals("n should not be double", mm.factorial("x"));
	}
	
*/
}
