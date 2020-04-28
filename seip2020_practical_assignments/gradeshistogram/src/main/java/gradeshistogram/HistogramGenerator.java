package gradeshistogram;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/***
 * The purpose of this class, is to complete the 2nd assignment
 * of the course 'Software Engineering in Practice'."
 * 
 * @author loukas
 * @since May 2020
 */

public class HistogramGenerator {
	
	/***
	 * The user gives a text file as an argument. The text file must have a grade (number) in separate lines.
	 * Then, the file is read and the frequency of each grade is added to a one-dimension array. Finally, a 
	 * diagram is created (using JFreeChart XYLine chart) based on this array, presenting how many times each 
	 * grade exists. It is required the class is being executed by command line.
	 * 
	 * @param path A text file with a grade in separate lines
	 */

	public static void main(String[] args) {
		String path = null; 
		if (args.length > 0) {
			  	path = args[0]; // The parameter from the command line
			  	int[] gradesArray = histogramArray(path);
			  	generateDiagram(gradesArray);
		}else{
			// If no arguments are given, system throws error message and exits
			System.err.println("Please put your text file's path as an argument.");
			System.exit(0);
		}
	}	
	
	public static int[] histogramArray(String path) {
		
		File file = new File(path);//Creates a variable of "File" Type with .txt file as a parameter
		
		int[] gradesArray = new int[11];// Creating array with 12 indexes
		for(int j=0;j < gradesArray.length;j++) gradesArray[j] = 0;//Initialize the array
		
		try {
			BufferedReader br = null;
			br = new BufferedReader(new FileReader(file)); // Opens the file for reading
			String next;
			
			/* 
			 * Reads the file, converts strings to integers and adds 1 to the position 
			 * of the array that is the same number with the integer. That way, we easily 
			 * count the frequency of each grade. For example, everytime the system finds 3,
			 * it will add 1 to the 3rd position of the array. If we have 5 threes, in the end, 
			 * garray[3] will be 5.
			*/
			while ( (next = br.readLine()) != null ) { //
				gradesArray[Integer.parseInt(next)] += 1;
			}
			br.close(); // Closes the file
					
		} catch (IOException e) {
			e.printStackTrace();
		}
		return gradesArray; // Returns the array with integers
	}
	
	public static void generateDiagram(int[] grades){
		/*
		 * The XYSeriesCollection object is a set XYSeries series (dataset) that
		 * can be visualized in the same chart
		 */
		XYSeriesCollection dataset = new XYSeriesCollection();
		
		/*
		 * The XYSeries that are loaded in the dataset. There might be many
		 * series in one dataset.
		 */		
		XYSeries data = new XYSeries("Frequency of grades");

		/*
		 * Populating the XYSeries data object from the input Integer array
		 * values.
		 */
		for (int i = 0; i < grades.length; i++) {
			data.add(i, grades[i]); //
		}
		
		// add the series to the dataset
		dataset.addSeries(data);

		boolean legend = true; // do visualize a legend
		boolean tooltips = false; // do not visualize tooltips
		boolean urls = false; // do not visualize urls
		

		// Declare and initialize a createXYLineChart JFreeChart
		JFreeChart chart = ChartFactory.createXYLineChart("Grade's frequency", "Grade", "Frequency", dataset,
				PlotOrientation.VERTICAL, legend, tooltips, urls);

		/*
		 * Initialize a frame for visualizing the chart and attach the
		 * previously created chart.
		 */
		ChartFrame frame = new ChartFrame("gfseip", chart);
		frame.pack();
		// makes the previously created frame visible
		frame.setVisible(true);		
	}	
}