package codeanalyzer;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

/**
 * A class that provide test cases for the metrics calculated with Regular Expressions 
 * 
 * @author loukas
 * @since May 2020
 */

public class RegularExpressionsTest {
	
	private final static String LOCAL_TEST_CLASS = "src/test/resources/TestClass.java";
	private final static String WEB_TEST_CLASS = "https://drive.google.com/uc?export=download&id=1z51FZXqPyun4oeB7ERFlOgfcoDfLLLhg";
	private RegularExpressions regexLocal = new RegularExpressions(new Local());
	private RegularExpressions regexWeb = new RegularExpressions(new Web());
	
	/*
	 * A case that tests the Lines Of Code, locally
	 */
	@Test
	public void testCalculateRegexLOCwhenLocal() throws IOException {
		assertEquals(23, regexLocal.calculateLOC(LOCAL_TEST_CLASS));
	}
	
	/*
	 * A case that tests the Number Of Methods, locally
	 */
	@Test
	public void testCalculateRegexNOMwhenLocal() throws IOException {
		assertEquals(3, regexLocal.calculateNOM(LOCAL_TEST_CLASS));
	}

	/*
	 * A case that tests the Number Of Classes, locally
	 */
	@Test
	public void testCalculateRegexNOCwhenLocal() throws IOException {
		assertEquals(3, regexLocal.calculateNOC(LOCAL_TEST_CLASS));
	}

	/*
	 * A case that tests the Lines Of Code, in web
	 */
	@Test
	public void testCalculateRegexLOCwhenWeb() throws IOException {
		assertEquals(21, regexWeb.calculateLOC(WEB_TEST_CLASS));
	}
	
	/*
	 * A case that tests the Number Of Methods, in web
	 */
	@Test
	public void testCalculateRegexNOMwhenWeb() throws IOException {
		assertEquals(3, regexWeb.calculateNOM(WEB_TEST_CLASS));
	}

	/*
	 * A case that tests the Number Of Classes, in web
	 */
	@Test
	public void testCalculateRegexNOCwhenWeb() throws IOException {
		assertEquals(3, regexWeb.calculateNOC(WEB_TEST_CLASS));
	}		
}
