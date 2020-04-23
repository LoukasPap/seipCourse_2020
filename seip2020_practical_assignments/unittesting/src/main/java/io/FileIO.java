package io;

/**
* The FileIO provides simple file input/output operation.
*
* @author  loukas(loukas.pap@hotmail.gr)
* @since   April 2020
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileIO {
	
	/**
	 * Reads a file that contains numbers line by line 
	 * and returns an array of the integers found in the file.
	 * @param filepath is the path of the text file
	 * @return an array of integers
	 * @exception IllegalArgumentException when the given file does not exist
	 * @exception IllegalArgumentException when the given file is empty
	 * @exception NumberFormatException when the value of a line can not be converted to Integer
	 * @exception IOException when an IO interruption occurs (not tested)
	 */
	public  int[] readFile(String filepath) {
		File file = new File(filepath);
		if (!file.exists()) 
			throw new IllegalArgumentException("Input file does not exist");
		
		List<Integer> numbersList = new ArrayList<>();
		BufferedReader reader;
		
		try {
			reader = new BufferedReader(new FileReader(file));
			String line = null;
			while ((line = reader.readLine()) != null) {
				try {
					System.out.println(Integer.parseInt(line));
					int number = Integer.parseInt(line);
					numbersList.add(number);
				} catch(NumberFormatException e) {
					//Skips line
				}
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (numbersList.size() == 0) 
			throw new IllegalArgumentException("Given file is empty");
		
		// Convert a List to an array using
		return numbersList.stream().mapToInt(i -> i).toArray();
	}

}
