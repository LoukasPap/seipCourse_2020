package codeanalyzer;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import org.junit.Test;

/**
 * A class that provide test cases for the metrics calculated with String Comprarison 
 * 
 * @author loukas
 * @since May 2020
 */
public class StringComparisonTest {

	private final static String LOCAL_TEST_CLASS = "src/test/resources/TestClass.java";
	private final static String WEB_TEST_CLASS = "https://drive.google.com/uc?export=download&id=1z51FZXqPyun4oeB7ERFlOgfcoDfLLLhg";
	private StringComparison strcompLocal = new StringComparison(new Local());
	private StringComparison strcompWeb = new StringComparison(new Web());
	
	/*
	 * A case that tests the Lines Of Code, locally
	 */
	@Test
	public void testCalculateStrcompLOCwhenLocal() throws IOException {
		assertEquals(8, strcompLocal.calculateLOC(LOCAL_TEST_CLASS));
	}
	
	/*
	 * A case that tests the Number Of Methods, locally
	 */
	@Test
	public void testCalculateStrcompNOMwhenLocal() throws IOException {
		assertEquals(3, strcompLocal.calculateNOM(LOCAL_TEST_CLASS));
	}

	/*
	 * A case that tests the Number Of Classes, locally
	 */
	@Test
	public void testCalculateStrcompNOCwhenLocal() throws IOException {
		assertEquals(2, strcompLocal.calculateNOC(LOCAL_TEST_CLASS));
	}

	/*
	 * A case that tests the Lines Of Code, in web
	 */
	@Test
	public void testCalculateStrcompLOCwhenWeb() throws IOException {
		assertEquals(7, strcompWeb.calculateLOC(WEB_TEST_CLASS));
	}
	
	/*
	 * A case that tests the Number Of Methods, in web
	 */
	@Test
	public void testCalculateStrcompNOMwhenWeb() throws IOException {
		assertEquals(3, strcompWeb.calculateNOM(WEB_TEST_CLASS));
	}

	/*
	 * A case that tests the Number Of Methods, in web
	 */
	@Test
	public void testCalculateStrcompRegexNOCwhenWeb() throws IOException {
		assertEquals(3, strcompWeb.calculateNOC(WEB_TEST_CLASS));
	}			
}

