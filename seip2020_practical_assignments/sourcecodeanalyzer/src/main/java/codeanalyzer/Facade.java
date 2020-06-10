package codeanalyzer;

import java.io.IOException;
import java.util.Map;

/**
 * Calls all the neseccary methods to export the metrics:
 * loc = lines of code, nom = number of methods, and noc=number of classes
 * 
 * @author loukas
 * @since May 2020
 */

public class Facade {
	
	public void operationMetrics(String filepath, 
								 String sourceCodeAnalyzerType,
								 String sourceFileLocation,
								 String outputFilePath,
								 String outputFileType) throws IOException {

		//Checks if the file is stored locally, or at Web
		SourceFileCheckerFactory sfcf = new SourceFileCheckerFactory();
		SourceFileReaders source = sfcf.checkSourceFile(sourceFileLocation);
		
		//Here we calculate the metrics
		AnalyzeMetricsSystem analyzer = new AnalyzeMetricsSystem();
		Map<String, Integer> metrics = analyzer.calculateMetrics(sourceCodeAnalyzerType, filepath, source);
		
		//Exporting the metrics
		MetricsExporterFactory exporter = new MetricsExporterFactory();
		exporter.writeFile(outputFileType, metrics, outputFilePath);
		
	}
	
}
