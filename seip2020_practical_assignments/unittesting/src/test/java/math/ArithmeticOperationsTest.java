package math;

import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Rule;
import org.junit.Assert;
import org.junit.Ignore;


public class ArithmeticOperationsTest {

	ArithmeticOperations ao = new ArithmeticOperations();
	
	@Test(expected = ArithmeticException.class)
	public void divide_zeroDenominator() {
		ao.divide(2.5, 0.0);
	}
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
//IllegalArgumentException
	@Test
	public void multiply_negativeArgument_X(){
		ao.multiply(-1, 3);
	}
	
	
	@Ignore
	@Test
	public void multiply_XequalsY() throws IllegalArgumentException{
		ao.multiply(3, 3);
	}
		
}
