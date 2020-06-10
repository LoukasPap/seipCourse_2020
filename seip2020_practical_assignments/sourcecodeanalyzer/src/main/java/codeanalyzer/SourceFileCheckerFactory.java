package codeanalyzer;

/**
 * Checks the given source file reader and creates an object of it.
 * 
 * @author loukas
 * @since May 2020
 */
public class SourceFileCheckerFactory {

	public SourceFileReaders checkSourceFile(String sfr) {
		SourceFileReaders checker = null;
		if(sfr.toLowerCase().equals("local")) {
			checker = new Local();
		} else if (sfr.toLowerCase().equals("web")) {
			checker = new Web();
		}else {
			checker = null;
		}
		return checker;
		
	}

}
