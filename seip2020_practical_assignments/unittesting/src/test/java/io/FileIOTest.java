package io;

/**
 * Test cases for the FileIO class.
 * 
 * @author loukas(loukas.pap@hotmail.gr)
 * @since April 2020
 */

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class FileIOTest {
	
	/* 
	 * A reference to the FileIO class
	 * which functions we are testing in this class.
	 */	
	FileIO fio = new FileIO();
	public static String resourcesPath = "src/test/resources/";
	
	/*
	 * A test case with valid inputs
	 */
	@Test
	public void testReadFile_NormalCase() {
		int[] expectedValues = new int[] {345, 765, 0, 987, 3, 65, 765};
		String validInputFilePath = resourcesPath.concat("integersOnly.txt");
		
		Assert.assertArrayEquals(expectedValues, fio.readFile(validInputFilePath));
	}
	
	@Rule
	public ExpectedException thrown = ExpectedException.none(); //Initializing to .none()
	
	/*
	 * A test case for the exception thrown
	 * when the file given as an input does not exist
	 */
	@Test
	public void testReadFile_ShouldThrowExceptionOnMissingFile() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Input file does not exist");
		String validInputFilePath = resourcesPath.concat("missingfile.txt");
		fio.readFile(validInputFilePath);
	}
	
	/*
	 * A test case for the exception thrown
	 * when the file given as an input is empty
	 */
	@Test
	public void testReadFile_ShouldThrowExceptionOnEmptyFile() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Given file is empty");
		String validInputFilePath = resourcesPath.concat("empty.txt");
		fio.readFile(validInputFilePath);
	}

	/*
	 * A test case that checks
	 * that the non-integers values are not parsed.
	 */
	@Test
	public void testReadFileContainsInvalidEntries() {
		String validInputFilePath = resourcesPath.concat("multipleValues.txt");
		fio.readFile(validInputFilePath);
		
		int[] expectedValues = new int[] {4, 5432, 613, 2222, 141832};
		Assert.assertArrayEquals(expectedValues, fio.readFile(validInputFilePath));
	}
	
}
