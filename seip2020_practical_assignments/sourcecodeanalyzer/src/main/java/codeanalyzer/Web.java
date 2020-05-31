package codeanalyzer;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Retrieves (reads) the contents of a local given file.
 * The file is stored in web. 
 * 
 * @author loukas
 * @since May 2020
 */
class Web implements SourceFileReaders {
	
	/**
	 * Reads a file and returns its content in a single String
	 * @param filepath the url of the file in the web
	 * @return a String that contains the contents of the file
	 * @throws IOException
	 */
	@Override
	public String readFileintoString(String filepath) throws IOException{
		StringBuilder sb = new StringBuilder();
        URL url = new URL(filepath);
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        String line = null;
        while ((line = reader.readLine()) != null) {
        	sb.append(line + "\n");
        }
        reader.close();
		return sb.toString();
	}

	/**
	 * Reads a file and returns its content in a List. 
	 * @param filepath the url of the file in the web
	 * @return a List that contains the contents of the file
	 * @throws IOException
	 */
	@Override
	public List<String> readFileintoList(String filepath) throws IOException {
		List<String> lines = new ArrayList<>();
        URL url = new URL(filepath);
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        String line = null;
        while ((line = reader.readLine()) != null) {
        	lines.add(line);
        }
        reader.close();
		return lines;
	}

}
