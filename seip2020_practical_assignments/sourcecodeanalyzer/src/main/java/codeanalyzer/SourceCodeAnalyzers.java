package codeanalyzer;

import java.io.IOException;

/**
 * The abstract class needed to be extended in order to calculate the metrics.
 * 
 * @author loukas
 * @since May 2020
 */
public abstract class SourceCodeAnalyzers {

	protected SourceFileReaders sfrtype;
	
	public SourceCodeAnalyzers(SourceFileReaders _sfrtype) {
		this.sfrtype = _sfrtype;
	}
	
	public abstract int calculateLOC(String filepath) throws IOException;
	public abstract int calculateNOM(String filepath) throws IOException;
	public abstract int calculateNOC(String filepath) throws IOException;
	
}
