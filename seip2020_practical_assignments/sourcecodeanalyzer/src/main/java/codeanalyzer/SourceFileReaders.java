package codeanalyzer;

import java.io.IOException;
import java.util.List;

/**
 * The interface needed to be implemented in order to read the file.
 * 
 * @author loukas
 * @since May 2020
 */
public interface SourceFileReaders {
	public String readFileintoString(String filepath) throws IOException;
	public List<String> readFileintoList(String filepath) throws IOException;
}
