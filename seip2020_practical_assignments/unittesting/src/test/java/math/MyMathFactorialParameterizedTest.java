package math;

/**
 * A test class that implements a Parameterized test
 * for the MyMath factorial function
 * 
 * @author louka (loukas.pap@hotmail.gr)
 * @since April 2020
 */

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;


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
		Object[][] data = new Object[][]{{0,1},{1,1},{2,2},{12,479001600}};
		
		return Arrays.asList(data);
	}
	
	
	/*
	 * The test which is executed for each pair of 
	 * parameters. 
	 */
	@Test
	public void testFactorialNormalCases() {
		Assert.assertEquals(fexpected, mm.factorial(finput));
	}
	
}
