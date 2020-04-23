/**
 * 
 */
package math;

import java.util.ArrayList;
import java.util.List;

import io.FileIO;

/**
 * @author louka
 * @since April 2020
 */
public class ArrayOperations {
	
	public int[] findPrimesInFile(FileIO fileIo, String filepath, MyMath MyMath) {
		
		List<Integer> primeArray = new ArrayList<>();
		int[] fileArray = fileIo.readFile(filepath);
		
		for(int i=0; i < fileArray.length; i++) {
			if(MyMath.isPrime(fileArray[i])) {
				primeArray.add(fileArray[i]);
			}
		}
		
		return primeArray.stream().mapToInt(i -> i).toArray();

	}
//	FileIO fileIo = new FileIO();
//	MyMath MyMath = new MyMath();
//	"C:\\Users\\louka\\seipCourse\\seipCourse_2020\\seip2020_practical_assignments\\unittesting\\src\\test\\resources\\findPrimes.txt"
//	public static void main(String[] args) {
//	findPrimesInFile();
//}
	
}
