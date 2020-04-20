package math;

/**
* A class that provides two simple arithmetic operations
*
* @author louka (loukas.pap@hotmail.gr)
* @since April 2020
*/

public class ArithmeticOperations {
	
	/**
	 * Performs the basic arithmetic operation of division
	 * between two doubles.
	 * @param numerator the numerator of the operation
	 * @param denominator the denominator of the operation
	 * @return the result of the division of numerator and denominator
	 * @exception ArithmeticException when denominator is zero
	 * @exception IllegalArgumentException when the result of the division does not fit in a double variable
	 */
	
	public double divide(double numerator, double denominator) {
		if (denominator == 0) {
			throw new ArithmeticException("Cannot divide with zero");
		} else if(numerator/denominator > Double.MAX_VALUE || numerator/denominator < -Double.MAX_VALUE){ //The case where the division does not fit in a double variable
			throw new IllegalArgumentException("the division does not fit in a double variable");
		} else {
			return numerator/denominator;
		}
	}
	
	
	/**
	 * Performs the basic arithmetic operation of multiplication 
	 * between two non-negative Integers
	 * @param x the first input
	 * @param y the second input
	 * @return the product of the multiplication
	 * @exception IllegalArgumentException when <b>x</b> or <b>y</b> are negative numbers 
	 * @exception IllegalArgumentException when the product does not fit in an Integer variable 
	 */
	
	public int multiply(int x, int y) {
		if (x < 0 || y < 0) { //The case where at least one argument is negative
			throw new IllegalArgumentException("x and y should be >= 0");
		} else if(x == 0 || y == 0) { //The case where the product is 0
			return 0;
		} else if (x <= Integer.MAX_VALUE/y) { //The case where the product fits in an Integer variable
			return x*y;			
		} else {
			throw new IllegalArgumentException("The product does not fit in an Integer variable");		
		}
	}
}
