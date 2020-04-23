/**
 * 
 */
package search;


import org.junit.Assert;
import org.junit.Test;

import io.FileIO;
import math.ArrayOperations;
import math.MyMath;

import static org.mockito.Mockito.*;

/**
 * @author louka
 * @since April 2020
 */
public class ArrayOperationsTest {

	@Test
	public void testFindPrimesInFileWithIntegers() {
		
		ArrayOperations ao = new ArrayOperations();
		MyMath mm = new MyMath();
		
		//Mock FileIO and MyMath dependecnies
		FileIO fileio = mock(FileIO.class);
		MyMath mymath = mock(MyMath.class);
		String path = "src/test/resources/findPrimes.txt";
		
		when(fileio.readFile(path)).thenReturn(new int[] {3, 53, 25, 223, 23, 41, 130, 38});

		when(mymath.isPrime(3)).thenReturn(true);
		when(mymath.isPrime(53)).thenReturn(true);
		when(mymath.isPrime(25)).thenReturn(false);
		when(mymath.isPrime(223)).thenReturn(true);
		when(mymath.isPrime(23)).thenReturn(true);
		when(mymath.isPrime(41)).thenReturn(true);
		when(mymath.isPrime(130)).thenReturn(false);
		when(mymath.isPrime(38)).thenReturn(false);
		
		int[] expected = {3, 53, 223, 23, 41};
		int[] actual = ao.findPrimesInFile(fileio, path, mymath);
		
		Assert.assertArrayEquals(expected, actual);
	}	
}
