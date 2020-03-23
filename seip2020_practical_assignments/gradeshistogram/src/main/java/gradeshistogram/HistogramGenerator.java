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

public class HistogramGenerator {

	public static void main(String[] args) {
		String path = null; 
		if (args.length > 0) {
			  	path = args[0]; // args[0] is the parameter from the command line
			  	int[] gradesArray = histogramArray(path);
			  	generateDiagram(gradesArray);
		}else{
			// If no arguments are given, system throws error message and exits
			System.err.println("Please put your text file's path as an argument.");
			System.exit(0);
		}
	}	
	
	public static int[] histogramArray(String path) {
		
		File file = new File(path);//Creates a variable of "file" Type
		
		//Creates an array and then puts 0 to all its positions | garray = grades' array
		int[] garray = new int[11];
		for(int j=0;j < garray.length;j++) garray[j] = 0;
		
		try {
			BufferedReader br = null;
			br = new BufferedReader(new FileReader(file)); // Opens the file for reading
			String next;
			while ( (next = br.readLine()) != null ) { // Reads the file,
				// Converts strings to integers, then takes them, and adds 1 to the position of the array that is the same number with the integer
				// That way, we easily count the frequency of each grade.
				// For example, everytime the system finds 3, it will add 1 to the 3rd position of the array. If we have 5 threes, in the end garray[3] will be 5.
				garray[Integer.parseInt(next)] += 1;
			}
			br.close(); // Closes the file
					
		} catch (IOException e) {
			e.printStackTrace();
		}
		return garray; // Returns the array with integers
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
		
		
		for (int i = 0; i < grades.length; i++) {
			data.add(i, grades[i]); //grades[i] is the grade | i is the frequency
		}
		dataset.addSeries(data);

		boolean legend = true; // do not visualize a legend
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