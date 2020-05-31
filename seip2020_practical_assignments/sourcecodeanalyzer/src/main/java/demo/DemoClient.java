package demo;

import java.io.IOException;

import codeanalyzer.Facade;

public class DemoClient {

	public static void main(String[] args) throws IOException {
		String filepath;
		String sourceCodeAnalyzerType;
		String sourceFileLocation;
		String outputFilePath;
		String outputFileType;
		
		if(args.length == 5) {
			filepath = args[0];
			sourceCodeAnalyzerType = args[1];
			sourceFileLocation = args[2];
			outputFilePath = args[3];
			outputFileType = args[4];
			
			Facade facade = new Facade();
			facade.operationMetrics(filepath, 
					   				sourceCodeAnalyzerType,
					   				sourceFileLocation,
					   				outputFilePath,
					   				outputFileType);
			
		} else if (args.length != 0) {
			System.out.println("Incorrect number of arguments.");
			System.exit(1);
		}

	}

}
