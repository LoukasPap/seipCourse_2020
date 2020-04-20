package math;

/**
 * A class that finds the factorial of a given input
 * 
 * @author louka (loukas.pap@hotmail.gr)
 * @since April 2020
 */

public class MyMath {
	
	/**
	 * Receives an Integer number and returns its factorial.
	 * Arguments less than 0 and bigger than 12 cause an {@link IllegalArgumentException} 
	 * @param n is the integer input number
	 * @return an integer with the factorial value
	 * @exception IllegalArgumentException when input is <0 & >12
	 */	

	public int factorial(int n) {
		if(n<0 || n>12) {
			throw new IllegalArgumentException("n should be between 0 and 12");
		}else {
			if(n!=0) { //The case where the argument is not 0
				int f = n;
				for(int i=1; i<(f); i++) {
					n *= (f-i);
				}
			}else{ //The case where the argument is 0
				n = 1;
			}
		}
		return n;
	}
}
