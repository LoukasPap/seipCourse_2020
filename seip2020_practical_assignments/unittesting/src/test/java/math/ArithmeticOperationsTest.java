package math;

import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Rule;
import org.junit.Assert;
import org.junit.Ignore;


public class ArithmeticOperationsTest {

	ArithmeticOperations ao = new ArithmeticOperations();
	
	@Test(expected = ArithmeticException.class)
	public void test_divide_zeroDenominator() {
		ao.divide(2.5, 0.0);
	}
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();	
		@Test
		public void test_multiply_negativeArgument_X(){
			thrown.expect(IllegalArgumentException.class);
			thrown.expectMessage("x & y should be >= 0");
			ao.multiply(-1, 3);
		}
		@Test
		public void test_multiply_negativeArgument_Y(){
			thrown.expect(IllegalArgumentException.class);
			thrown.expectMessage("x & y should be >= 0");
			ao.multiply(3, -1);
		}		
		@Test
		public void test_multiply_XequalsY(){
			ao.multiply(3, 3);
		}
		@Test
		public void test_multiply_maxValue_X(){
			thrown.expect(IllegalArgumentException.class);
			thrown.expectMessage("The product does not fit in an Integer variable");
			ao.multiply(2147483647, 3);
		}
		@Test
		public void test_multiply_maxValue_Y(){
			thrown.expect(IllegalArgumentException.class);
			thrown.expectMessage("The product does not fit in an Integer variable");
			ao.multiply(3, 2147483647);
		}
		@Test
		public void test_multiply_minValue_X(){
			thrown.expect(IllegalArgumentException.class);
			thrown.expectMessage("x & y should be >= 0");
			ao.multiply(-2147483647, 3);
		}
		@Test
		public void test_multiply_minValue_Y(){
			thrown.expect(IllegalArgumentException.class);
			thrown.expectMessage("x & y should be >= 0");
			ao.multiply(3, -2147483647);
		}
		@Test
		public void test_multiply_maxValues_XandY(){
			thrown.expect(IllegalArgumentException.class);
			thrown.expectMessage("The product does not fit in an Integer variable");
			ao.multiply(2147483647, 2147483646);
		}
		
}
