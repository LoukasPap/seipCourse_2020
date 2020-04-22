/**
 * 
 */
package math;

import java.util.ArrayList;

import io.FileIO;

/**
 * @author louka
 * @since April 2020
 */
public class ArrayOperations {
	
	public int[] findPrimesInFile(FileIO fileIo, String filepath, MyMath MyMath) {
		int[] primeArray = {};
		int[] fileArray = fileIo.readFile(filepath);
		
		for(int i=0;i < fileArray.length;i++) {
			if(MyMath.isPrime(fileArray[i])) {
				primeArray[i] = fileArray[i];
			}
		}
		return primeArray;
	
	}

	
}
