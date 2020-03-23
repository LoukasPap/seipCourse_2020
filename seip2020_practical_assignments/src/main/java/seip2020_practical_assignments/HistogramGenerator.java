package seip2020_practical_assignments;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class HistogramGenerator {

	public static void main(String[] args) {
//		String path = "C:\\Users\\louka\\Desktop\\grades.txt";
		
		String path = null;
		if (args.length > 0) {
			  	path = args[0];
		} else {
			path = "C:\\Users\\louka\\Desktop\\grades.txt";
			System.out.println("Please put a String-type argument");
//			System.exit(0);
		}
		
		histogram(path);
	}	
	
	public static void histogram(String path) {
		
		int[] garray = new int[11];
		for(int j=0;j < garray.length;j++) garray[j] = 0;
			
		File file = new File(path);
		
		try {
			BufferedReader br;
			br = new BufferedReader(new FileReader(file));
			
			String next;
			while ( (next = br.readLine()) != null ) {
				System.out.print("next is " + Integer.parseInt(next) + "\n");
				garray[Integer.parseInt(next)] += 1;
			}
			
			for(int i=0;i<garray.length;i++) System.out.println(i +" shows up " + garray[i] + " times.");
					
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
	