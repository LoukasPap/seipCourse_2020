package math;

/**
 * The ArrayOperations class reads a text file with integers
 * and returns an array with all the prime numbers
 * of the text file.
 * 
 * @author louka
 * @since April 2020
 */

import java.util.ArrayList;
import java.util.List;

import io.FileIO;

public class ArrayOperations {
	
	/**
	 * Returns an array of all prime numbers contained in a text file
	 * @param fileIo is the class that reads the file and returns an array with file's integers
	 * @param filepath is the file that can contain many types of variables
	 * @param MyMath provides the function to find all prime numbers
	 * @return an array of all prime numbers
	 */
	
	public int[] findPrimesInFile(FileIO fileIo, String filepath, MyMath MyMath) {
		
		List<Integer> primeArray = new ArrayList<>();
		int[] fileArray = fileIo.readFile(filepath);
		
		for(int i=0; i < fileArray.length; i++) {
			if(MyMath.isPrime(fileArray[i])) {
				primeArray.add(fileArray[i]); //Store the prime numbers
			}
		}
		// Converting a List to an array and returning it
		return primeArray.stream().mapToInt(i -> i).toArray();
	}
}
