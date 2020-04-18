package math;

import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Rule;


public class ArithmeticOperationsTest {

	ArithmeticOperations ao = new ArithmeticOperations();
	
	@Test(expected = ArithmeticException.class)
	public void test_divide_zeroDenominator() {
		ao.divide(2.5, 0.0);
	}

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
//		@Test
//		public void test_divide_DenominatorBiggerThanMAX_VALUE() {
//			thrown.expect(IllegalArgumentException.class);
//			thrown.expectMessage("numerator and/or denominator do not fit in a Double variable");
//			ao.divide(Double.MAX_VALUE,Double.MAX_VALUE);
//		}
//		@Test
//		public void test_divide_DenominatorLessThanMIN_VALUE() {
//			thrown.expect(IllegalArgumentException.class);
//			thrown.expectMessage("numerator and/or denominator do not fit in a Double variable");
//			ao.divide(6,-Double.MAX_VALUE-5);
//		}
		
		@Test
		public void test_multiply_negativeArgument_X() {
			thrown.expect(IllegalArgumentException.class);
			thrown.expectMessage("x and y should be >= 0");
			ao.multiply(-1, 3);
		}
		@Test
		public void test_multiply_negativeArgument_Y() {
			thrown.expect(IllegalArgumentException.class);
			thrown.expectMessage("x and y should be >= 0");
			ao.multiply(240, -1);
		}		
		@Test
		public void test_multiply_maxValue_X() {
			thrown.expect(IllegalArgumentException.class);
			thrown.expectMessage("The product does not fit in an Integer variable");
			ao.multiply(2147483647, 240);
		}
		@Test
		public void test_multiply_maxValue_Y() {
			thrown.expect(IllegalArgumentException.class);
			thrown.expectMessage("The product does not fit in an Integer variable");
			ao.multiply(240, 2147483647);
		}
		@Test
		public void test_multiply_minValue_X() {
			thrown.expect(IllegalArgumentException.class);
			thrown.expectMessage("x and y should be >= 0");
			ao.multiply(-2147483647, 240);
		}
		@Test
		public void test_multiply_minValue_Y() {
			thrown.expect(IllegalArgumentException.class);
			thrown.expectMessage("x and y should be >= 0");
			ao.multiply(240, -2147483647);
		}
		@Test
		public void test_multiply_maxValues_XandY() {
			thrown.expect(IllegalArgumentException.class);
			thrown.expectMessage("The product does not fit in an Integer variable");
			ao.multiply(2147483647, 2147483646);
		}
}
