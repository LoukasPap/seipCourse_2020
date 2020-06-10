package codeanalyzer;

import java.util.Map;

/**
 * The interface needed to be implemented, in order to export the metrics.
 * 
 * @author loukas
 * @since May 2020
 */
public interface FileWriter {
	public void writeFile(Map<String, Integer> metrics, String filepath);
}
