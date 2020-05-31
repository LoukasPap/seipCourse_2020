package codeanalyzer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Receives the analyzer type, the path and the source of a file
 * and stores the results of the metrics in a Map.
 * 
 * @author loukas
 * @since May 2020
 */
public class AnalyzeMetricsSystem {
	
	/**
	 * Reads a file, calculates and stores its metrics.
	 * @param scat as the source code analyzer type
	 * @param filepath the url of the file
	 * @param source the source of the file(web or local)
	 * @return a Map that containes the results of the metrics
	 * @throws IOException
	 */
	public Map<String,Integer> calculateMetrics(String scat, String filepath, SourceFileReaders source) throws IOException{
		int LOC = 0, NOM = 0, NOC = 0;
		if(scat.equals("regex")) {
			LOC = new RegularExpressions(source).calculateLOC(filepath);
			NOM = new RegularExpressions(source).calculateNOM(filepath);
			NOC = new RegularExpressions(source).calculateNOC(filepath);
			
		}else if(scat.equals("strcomp")) {
			LOC = new StringComparison(source).calculateLOC(filepath);
			NOM = new StringComparison(source).calculateNOC(filepath);
			NOC = new StringComparison(source).calculateNOC(filepath);
		}else {
			System.err.println("Put a valid source code analyzer as an argument.");
		}
		
		Map<String, Integer> metrics = new HashMap<>();
		metrics.put("loc",LOC);
		metrics.put("nom",NOM);
		metrics.put("noc",NOC);
		
		return metrics;

	
	}
}
