package codeanalyzer;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * A class that tests the results of the metric in a Map
 * 
 * @author loukas
 * @since May 2020
 */
public class AnalyzeMetricsSystemTest {
	
	private final static String TYPE_REGEX = "regex";
	private final static String TYPE_STRCOMP = "strcomp";
	private final static String LOCAL_TEST_CLASS = "src/test/resources/TestClass.java";
	private final static String WEB_TEST_CLASS = "https://drive.google.com/uc?export=download&id=1z51FZXqPyun4oeB7ERFlOgfcoDfLLLhg";

	private AnalyzeMetricsSystem ams = new AnalyzeMetricsSystem();
	
	/*
	 * A test case for the metrics calculated locally, with regex
	 */
	@Test
	public void testAssertMapwithRegexLocally() throws IOException {
		Map<String, Integer> expectedMetrics = new HashMap<>();
		expectedMetrics.put("loc", 23);
		expectedMetrics.put("nom", 3);
		expectedMetrics.put("noc", 3);
		
		assertThat(ams.calculateMetrics(TYPE_REGEX, LOCAL_TEST_CLASS, new Local()), is(expectedMetrics));
	
	}

	/*
	 * A test case for the metrics calculated locally, with strcomp
	 */
	@Test
	public void testAssertMapwithStrcompLocally() throws IOException {
		Map<String, Integer> expectedMetrics = new HashMap<>();
		expectedMetrics.put("loc", 8);
		expectedMetrics.put("nom", 2);
		expectedMetrics.put("noc", 2);
		
		assertThat(ams.calculateMetrics(TYPE_STRCOMP, LOCAL_TEST_CLASS, new Local()), is(expectedMetrics));
	}
	
	/*
	 * A test case for the metrics calculated locally, with invalid type of source code analyzer
	 */
	@Test
	public void testAssertMapwithInvalidInputLocally() throws IOException {
		Map<String, Integer> expectedMetrics = new HashMap<>();
		expectedMetrics.put("loc", 0);
		expectedMetrics.put("nom", 0);
		expectedMetrics.put("noc", 0);
		
		assertThat(ams.calculateMetrics("nothing", LOCAL_TEST_CLASS, new Local()), is(expectedMetrics));
	}
	
	/*
	 * A test case for the metrics calculated in web, with regex
	 */
	@Test
	public void testAssertMapwithRegexWeb() throws IOException {
		Map<String, Integer> expectedMetrics = new HashMap<>();
		expectedMetrics.put("loc", 21);
		expectedMetrics.put("nom", 3);
		expectedMetrics.put("noc", 3);
		
		assertThat(ams.calculateMetrics(TYPE_REGEX, WEB_TEST_CLASS, new Web()), is(expectedMetrics));
	}

	/*
	 * A test case for the metrics calculated in web, with strcomp
	 */
	@Test
	public void testAssertMapwithStrcompWeb() throws IOException {
		Map<String, Integer> expectedMetrics = new HashMap<>();
		expectedMetrics.put("loc", 7);
		expectedMetrics.put("nom", 3);
		expectedMetrics.put("noc", 3);
		
		assertThat(ams.calculateMetrics(TYPE_STRCOMP, WEB_TEST_CLASS, new Web()), is(expectedMetrics));	
	}
	
	/*
	 * A test case for the metrics calculated in web, with invalid type of source code analyzer
	 */
	@Test
	public void testAssertMapwithInvalidInputWeb() throws IOException {
		Map<String, Integer> expectedMetrics = new HashMap<>();
		expectedMetrics.put("loc", 0);
		expectedMetrics.put("nom", 0);
		expectedMetrics.put("noc", 0);
		
		assertThat(ams.calculateMetrics("nothing", WEB_TEST_CLASS, new Web()), is(expectedMetrics));
	}
}
