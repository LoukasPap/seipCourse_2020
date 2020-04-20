package math;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author louka
 *
 */

public class MyMathTest {

	MyMath mm = new MyMath();	
	
	@Test(expected = IllegalArgumentException.class)
	public void testFactorialShouldThrowExceptionForNLessThan0() {
		Assert.assertEquals("n should be between 0 and 12", mm.factorial(-5));
	}
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
