package math;

/**
 * A class that executes advanced mathematic operations
 * 
 * @author loukas(loukas.pap@hotmail.gr)
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
	
	/**
	 * Receives an Integer number and returns true if it a prime number
	 * Arguments less than 2 cause an {@link IllegalArgumentException} 
	 * @param n is the integer input number
	 * @return an true if the input is prime, or false if the input is composite (non-prime)
	 * @exception NumberFormatException when the input is not an Integer
	 */	

	public  boolean isPrime(int n) {
		boolean prime = true;

		if(n < 2) {
			throw new IllegalArgumentException("n should be bigger or equal to 2");
		} else {
			int i = 2;
	        while(i <= n/2) {
	            if(n % i == 0){ //Condition for composite(or non-prime) number
	                prime = false;
	                i = n/2;
	            }
	            ++i;
	        }
		}
	return prime;
	}
}