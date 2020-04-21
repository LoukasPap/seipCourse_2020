package io;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * 
 * @author louka
 * @since April 2020
 */
public class FileIOTest {
	
	/* 
	 * A reference to the FileIO class
	 * which functions we are testing in this class.
	 */	
	FileIO fio = new FileIO();
	public static String resourcesPath = "src/test/resources/";
	
	/*
	 * A test case with valid input
	 */
	@Test
	public void testReadFile_NormalCase() {
		int[] expectedValues = new int[] {345, 765, 0, 987, 3, 65, 765};
		String validInputFilePath = resourcesPath.concat("integers.txt");
		
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
		
		String validInputFilePath = resourcesPath.concat("whereisit.txt");
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
	
	
}
