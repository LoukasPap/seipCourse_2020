package codeanalyzer;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * A class that tests the Local class independently
 * 
 * @author loukas
 * @since May 2020
 */
public class LocalTest {
	SourceFileReaders sfrLocal = new Local();
	SourceFileReaders sfrWeb = new Web();
	private static List<String> expectedList;
	private static String expectedString;
	private final static String TEST_CLASS_LOCAL = "src/test/resources/TestClass.java";
	private final static String TEST_CLASS_WEB ="https://drive.google.com/uc?export=download&id=1z51FZXqPyun4oeB7ERFlOgfcoDfLLLhg";
	
	@BeforeClass
	public static void setUp() throws IOException {
		expectedList = Files.readAllLines(new File(TEST_CLASS_LOCAL).toPath(), Charset.defaultCharset());
		expectedString = String.join("\n", expectedList) + "\n"; // transforms a list into a String (with 'new line' as delimiter) 
	}
	
	/*
	 * A test case for when reading in List
	 */
	@Test
	public void testReadFileIntoListLocal() throws IOException {
		//read a locally stored file into a List
		List<String> actualList = sfrLocal.readFileintoList(TEST_CLASS_LOCAL);
		
		String[] expecteds = expectedList.stream().toArray(String[]::new);
		String[] actuals = actualList.stream().toArray(String[]::new);
		
		assertArrayEquals(expecteds, actuals);
	}
	
	/*
	 * A test case for when reading in String
	 */
	@Test
	public void testReadFileIntoStringLocal() throws IOException {
		//read a locally stored file into a String
		String actuals = sfrLocal.readFileintoString(TEST_CLASS_LOCAL);

		assertEquals(expectedString, actuals);
	}
}