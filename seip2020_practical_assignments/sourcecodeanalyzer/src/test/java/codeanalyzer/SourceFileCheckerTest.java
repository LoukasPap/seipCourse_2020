package codeanalyzer;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * A class that provides test cases for
 * method checkSourceFile of the SourceFileCheckerFactory class.
 * 
 * @author louka
 * @since May 2020
 */
public class SourceFileCheckerTest {
	SourceFileCheckerFactory sfcf = new SourceFileCheckerFactory();
	private final static String TYPE_LOCAL = "local";
	private final static String TYPE_WEB = "web";
	
	/*
	 * A test case for the object being instance of Local class 
	 */
	@Test
	public void testSourceIsLocal() {
		assertTrue(sfcf.checkSourceFile(TYPE_LOCAL) instanceof Local);
	}

	/*
	 * A test case for the object being instance of Web class 
	 */
	@Test
	public void testSourceIsWeb() {
		assertTrue(sfcf.checkSourceFile(TYPE_WEB) instanceof Web);
	}
	
	/*
	 * A test case for the object not being instance of a Source File Reader class.
	 */
	@Test
	public void testSourceIsInvalid() {
		assertNull(sfcf.checkSourceFile("nope"));
	}
}
