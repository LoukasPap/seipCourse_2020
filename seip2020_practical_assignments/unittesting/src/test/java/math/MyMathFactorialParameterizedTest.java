package math;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;


/**
 * @author louka
 *
 */


@RunWith(Parameterized.class)
public class MyMathFactorialParameterizedTest {

	@Parameter(0) 
	public int finput;
	@Parameter(1)
	public int fexpected;
	
	MyMath mm = new MyMath();
	
	/*
	 * The following method generates the input values 
	 * for the tests. 
	 */
	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][]{{1,1},{2,2},{3,6},{4,24},{5,120},
										 {6,720},{7,5040},{8,40320},{9,362880},
										 {10,3628800},{11,39916800},{12,479001600}};
		
		return Arrays.asList(data);
	}
	
	@Test
	public void testFactorialNormalCases() {
		Assert.assertEquals(fexpected, mm.factorial(finput));
	}
	
}
