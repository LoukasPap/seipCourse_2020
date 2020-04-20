package math;

/**
* The MathOperations provides simple arithmetic operations
* that serve as hands-on practice on Unit Testing.
*
* @author  louka
* @version 1.0
* @since   17-04-2020 
*/
public class ArithmeticOperations {
	
	/**
	 * Performs the basic arithmetic operation of division
	 * between two Doubles.
	 * @param numerator the numerator of the operation
	 * @param denominator the denominator of the operation
	 * @return the result of the division between numerator and denominator
	 * @exception ArithmeticException when denominator is zero 
	 */
	public double divide(double numerator, double denominator) {
		if (denominator == 0) {
			throw new ArithmeticException("Cannot divide with zero");
		} else if(numerator/denominator > Double.MAX_VALUE || numerator/denominator < -Double.MAX_VALUE){
			throw new IllegalArgumentException("the division does not fit in a Double variable");
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
		if (x < 0 || y < 0) {
			throw new IllegalArgumentException("x and y should be >= 0");
		} else if(x == 0 || y == 0) {
			return 0;
		} else if (x <= Integer.MAX_VALUE/y) {
			return x*y;			
		} else {
			throw new IllegalArgumentException("The product does not fit in an Integer variable");		
		}
	}

}
