package codeanalyzer;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** 
 * Calculates the following metrics: loc = lines of code,
 * nom = number of methods, and noc=number of classes with 
 * the use of Regular Expressions (commonly known "regex").
 * 
 * @author loukas
 * @since May 2020
 */
public class RegularExpressions extends SourceCodeAnalyzers {

	/**
	 * Constructor of the class with a parameter.
	 * 
	 * @param _sfrtype is the type of the source file reader
	 *(<b>Local</b> for locally stored files, 
	 * <b>Web</b> for files stored on the web)
	 */
	public RegularExpressions(SourceFileReaders _sfrtype) {
		super(_sfrtype);
	}
	
	@Override
	public int calculateLOC(String filepath) throws IOException {
		String sourceCode = this.sfrtype.readFileintoString(filepath);
		Pattern pattern = Pattern.compile("((//.*)|(/\\*.*)|(\\*+.*))");
        Matcher nonCodeLinesMatcher = pattern.matcher(sourceCode);

        int nonCodeLinesCounter = 0;
        while (nonCodeLinesMatcher.find()) {
        	nonCodeLinesCounter++;
        }
		
        int sourceFileLength = sourceCode.split("\n").length;
        int loc =  sourceFileLength - nonCodeLinesCounter;		
		return loc;
	}
	
	@Override
	public int calculateNOM(String filepath) throws IOException {
		String sourceCode = this.sfrtype.readFileintoString(filepath);
		Pattern pattern = Pattern.compile(".*(public |protected |private |static )?[\\w\\<\\>\\[\\]]+\\s+(\\w+) *\\([^\\)]*\\) *(\\{?|[^;]).*"); 
        Matcher methodSignatures = pattern.matcher(sourceCode);

        int methodCounter = 0;
        while (methodSignatures.find()) {
        	methodCounter++;
        }
		return methodCounter;
	}
	
	@Override
	public int calculateNOC(String filepath) throws IOException {
		String sourceCode = this.sfrtype.readFileintoString(filepath);
		Pattern pattern = Pattern.compile(".*\\s*class\\s+.*"); 
        Matcher classSignatures = pattern.matcher(sourceCode);

        int classCounter = 0;
        while (classSignatures.find()) {
        	classCounter++;
        }
		return classCounter;
	}
}

