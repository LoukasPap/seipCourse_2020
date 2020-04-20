package math;

import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Rule;


public class ArithmeticOperationsTest {

	ArithmeticOperations ao = new ArithmeticOperations();
	
	@Test(expected = ArithmeticException.class)
	public void testDivision_ShouldThrowExceptionOnDenominatorEqualsTo0() {
		ao.divide(2.5, 0.0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testDivision_ShouldThrowExceptionOnDivisionBiggerThanMAXVALUE() {
		ao.divide(Double.MAX_VALUE, 0.5);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testDivision_ShouldThrowExceptionOnDivisionLessThanMINVALUE() {
		ao.divide(Double.MAX_VALUE, -0.5);
	}
	

	/*
	 * A test case for the exceptions caused when:
	 * 1) x and/or y are negative, and
	 * 2) the product does not fit in an Integer variable.
	 * Testing the exception is performed with a @Rule
	 */	
	
	@Rule
	public ExpectedException thrown = ExpectedException.none(); //Initializing to .none()
		
		@Test
		public void testMultiply_ShouldThrowExceptionOnNegativeInputsXandY() {
			thrown.expect(IllegalArgumentException.class);
			thrown.expectMessage("x and y should be >= 0");
			ao.multiply(-240, -20);
		}

		@Test
		public void testMultiply_ShouldThrowExceptionOnNegativeInputX() {
			thrown.expect(IllegalArgumentException.class);
			thrown.expectMessage("x and y should be >= 0");
			ao.multiply(-240, 20);
		}

		@Test
		public void testMultiply_ShouldThrowExceptionOnNegativeArgumenInputY() {
			thrown.expect(IllegalArgumentException.class);
			thrown.expectMessage("x and y should be >= 0");
			ao.multiply(240, -20);
		}

		@Test
		public void testMultiply_ShouldThrowExceptionOutOfBoundsProductBecauseOfX() {
			thrown.expect(IllegalArgumentException.class);
			thrown.expectMessage("The product does not fit in an Integer variable");
			ao.multiply(Integer.MAX_VALUE, 240);
		}

		@Test
		public void testMultiply_ShouldThrowExceptionOnOutOfBoundsProductBecauseOfY() {
			thrown.expect(IllegalArgumentException.class);
			thrown.expectMessage("The product does not fit in an Integer variable");
			ao.multiply(240, Integer.MAX_VALUE);
		}

}
