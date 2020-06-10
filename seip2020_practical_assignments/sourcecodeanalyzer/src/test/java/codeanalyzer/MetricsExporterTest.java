package codeanalyzer;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import codeanalyzer.MetricsExporterFactory;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.doCallRealMethod;

/**
 * A class that tests the exporters
 * 
 * @author loukas
 * @since May 2020
 */
public class MetricsExporterTest {

	/* 
	 * A reference to the MetricsExporterFactory class 
	 * which methods we are testing in this class
	 */
	MetricsExporterFactory mex = new MetricsExporterFactory();

	/*
	 * A test case for when the exporter input is csv.
	 */
	@Test
	public void testWriteCsv() {
		// create the metrics content
		Map<String, Integer> metrics = new HashMap<>();
		metrics.put("loc",30);
		metrics.put("nom",5);
		metrics.put("noc",2);

		// generate and write the output file
		String outputFilepath = "src/test/resources/output_metrics";
		mex.writeFile("csv", metrics, outputFilepath);
	
		// evaluate that the file exists
		File outputFile = new File(outputFilepath + ".csv");
		Assert.assertTrue(outputFile.exists());
		
		// delete the generated file
		outputFile.delete();
	}
	
	/*
	 * A test case for when the exporter input is json
	 */
	@Test
	public void testWriteJson() {
		MetricsExporterFactory mockedExporter = mock(MetricsExporterFactory.class);
		// create an empty metrics content
		Map<String, Integer> metrics = new HashMap<>();
		String outputFilepath = "whatever-path";
		
		//this is a demo of how a mocked object can call a real method (partial mocking)
		doCallRealMethod().when(mockedExporter).writeFile("json", metrics, outputFilepath);
		mockedExporter.writeFile("json", metrics, outputFilepath);
		//just verify that the method was executed/called
		verify(mockedExporter).writeFile("json", metrics, outputFilepath);
	}


	@Rule
	public ExpectedException thrown = ExpectedException.none(); //Initializing to .none()
	
	/*
	 * A test case for the exception caused when the exporter input is invalid
	 */
	@Test
	public void testWriteFileWithUknownFIleType() {
		thrown.expect(IllegalArgumentException.class);	
		thrown.expectMessage("The output file type is not valid.");

		mex.writeFile("non-existing-type", null, null);
	}

}
