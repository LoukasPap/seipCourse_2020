package codeanalyzer;

import java.io.IOException;
import java.util.List;

/** 
 * Calculates the following metrics: loc = lines of code,
 * nom = number of methods, and noc=number of classes with 
 * the use of String Comparison (commonly known "strcomp").
 * 
 * @author loukas
 * @since May 2020
 */

public class StringComparison extends SourceCodeAnalyzers{

	/**
	 * Constructor of the class with a parameter.
	 * 
	 * @param _sfrtype is the type of the source file reader
	 *(<b>Local</b> for locally stored files, 
	 * <b>Web</b> for files stored on the web)
	 */
	public StringComparison(SourceFileReaders _sfrtype) {
		super(_sfrtype);
	}
	
	@Override
	public int calculateLOC(String filepath) throws IOException {
		List<String> sourceCodeList = this.sfrtype.readFileintoList(filepath);
		int nonCodeLinesCounter = 0;
		for (String line : sourceCodeList) {
			line = line.trim(); //clear all leading and trailing white spaces
			if (line.startsWith("//") || line.startsWith("/*") || line.startsWith("*") || line.equals("{") || line.equals("}") || line.equals(""))
				nonCodeLinesCounter++;
		}
		int loc = sourceCodeList.size() - nonCodeLinesCounter;
		return loc; 
	}
	
	@Override
	public int calculateNOM(String filepath) throws IOException {
		List<String> sourceCodeList = this.sfrtype.readFileintoList(filepath);
		int methodCounter = 0;
		for (String line : sourceCodeList) {
			line = line.trim(); //clear all leading and trailing white spaces
			if ( ((line.contains("public") || line.contains("private") || line.contains("protected"))
					|| line.contains("void") || line.contains("int") || line.contains("String"))
				&& line.contains("(") && line.contains(")") && line.contains("{") )
				methodCounter++;
		}
		return methodCounter; 
	}
	
	@Override
	public int calculateNOC(String filepath) throws IOException {
		List<String> sourceCodeList = this.sfrtype.readFileintoList(filepath);
		int classCounter = 0;
		for (String line : sourceCodeList) {
			line = line.trim(); //remove leading and trailing white spaces
			if ((line.startsWith("class ") || line.contains(" class ")) && line.contains("{")) {
				classCounter++;
			}
		}
		return classCounter; 
	}

}
