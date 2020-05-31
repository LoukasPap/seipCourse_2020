package codeanalyzer;

import java.util.Map;

/**
 * Throws Illegal Argument Exception with a message,
 * if the given export type is not valid.
 * 
 * @author loukas
 * @since May 2020
 */

public class NullWriter implements FileWriter {

	@Override
	public void writeFile(Map<String, Integer> metrics, String filepath) throws IllegalArgumentException{
		if(true) throw new IllegalArgumentException("The output file type is not valid.");
	
	}

}
