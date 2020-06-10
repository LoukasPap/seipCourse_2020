package codeanalyzer;

import java.util.Map;

/**
 * Exports (writes) the metrics to a given output.
 * The output can be CSV or JSON files.
 * 
 * @author loukas
 * @since May 2020
 */
public class MetricsExporterFactory {
	
	/**
	 * Writes the metrics into a type of file (csv or json).
	 * 
	 * @param outputType the type which the file will be exported
	 * @param metrics the metrics stored in a map
	 * @param filepath the url of the file
	 */
	public void writeFile(String outputType, Map<String, Integer> metrics, String filepath) {
		codeanalyzer.FileWriter writer;
		if (outputType.equals("csv")) {
			writer = new CsvWriter();
		} else if (outputType.equals("json")) {
			writer = new JsonWriter();
		} else {
			writer = new NullWriter();
		}
		
		writer.writeFile(metrics, filepath);
	}	
}
