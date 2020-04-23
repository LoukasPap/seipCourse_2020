/**
 * 
 */
package search;

/**
 * A class that provides a test case for the ArrayOperations class.
 * 
 * @author loukas(loukas.pap@hotmail.gr)
 * @since April 2020
 */

import org.junit.Assert;
import org.junit.Test;

import io.FileIO;
import math.ArrayOperations;
import math.MyMath;

import static org.mockito.Mockito.*;

public class ArrayOperationsTest {

	/**
	 * At this test case,
	 * In order to isolate the external (to this class) dependencies (MyMath, FileIO)
	 * we have to mock them and predefine the results of all calls
	 * that we plan to execute on the MyMath's & FileIO's function.
	 */	
	
	@Test
	public void testFindPrimesInFileWithIntegers() {

		/* 
		 * A reference to the ArrayOperations class
		 * which functions we are testing in this class
		 */
		ArrayOperations ao = new ArrayOperations();
		
		//Mock FileIO and MyMath dependecnies
		FileIO fileio = mock(FileIO.class);
		MyMath mymath = mock(MyMath.class);
		String path = "src/test/resources/findPrimes.txt";
		
		// Call the readFile with the mocked FileIO instance
		when(fileio.readFile(path)).thenReturn(new int[] {3, 53, 25, 223, 23, 41, 130, 38});

		// Call the isPrime with the mocked MyMath instance
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
