package exercise5;

import java.io.DataInputStream;
import java.io.FileInputStream;

/*
 * Lab 12 - Programming using Java I/O Streams
 * Exercise 5: Processing Daily Rainfall Data A Station
 * 
 * Task D
 * 
 * This program represents to generate the data for 6 days reading of daily rainfall
 * from station Simpang Ampat in Alor Gajah district
 * and write these data into a certain output file named "RainFall.txt"
 * with the help of DataOutputStream.
 
 *  @author-NUR SYAFIQAH (B032110192)
 */
public class RainFallDataReader {
	
	public static void main(String[] args) {

		// 1. Declare source file as rainfall.txt
		String sourceFile = "RainFall.txt";
		
		// display the "Reading data from" and read data from source file
		System.out.println("Reading data from " + sourceFile + "\n");

		try {

			// 2. Stream is created to read data
			DataInputStream disInput = new DataInputStream(new FileInputStream(sourceFile));
			
			// 3. read the values from the stream 
			// variables to handle data read from the source file
			
			// receive daily rainfall reading in double form
			double dailyRainfall = 0;
			
			// count number of daily reading in the source file in int form
			int noOfRecords = 0;
			
			// variable to calculate the total daily rainfall in double
			double totalRainfall = 0.0;
			
			// Read values from the stream
			dailyRainfall = disInput.read();
			//display "The 6 days readings of daily rainfall from station Simpang Ampat in Alor Gajah district:
			System.out.println("The 6 days readings of daily rainfall from station Simpang Ampat in Alor Gajah district: ");
			
			// -1: read until end of file/stream
			while (dailyRainfall != -1) {
				
				// Display daily rainfall 
				System.out.println(dailyRainfall);
				
				// Calculate total daily rainfall
				totalRainfall = totalRainfall + dailyRainfall;
				
				// Auto update current number of records
				//read from the sourcefile
				noOfRecords ++;
				
				// Read next value for the daily rainfall reading
				dailyRainfall = disInput.read();
	
			} 
			
			// Display total number of records for the daily rainfall 
			System.out.println("\nTotal Records: " + noOfRecords);
			
			// Display total daily rainfall
			System.out.println("Total Daily Rainfall: " + totalRainfall);
			
			// Calculate average daily rainfall in double
			double averageRainfall = totalRainfall / Double.valueOf(noOfRecords);
			
			
			String formattedAverage = String.format("%.1f", averageRainfall);
			System.out.print("\nAverage rainfall for " + noOfRecords 
					+ " days from station Simpang Ampat in Alor Gajah district: " + formattedAverage);
			
			
			// 4. Close stream
			disInput.close();
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
		}

		// Indicate end of program 
		System.out.println("\nEnd of program.");
		

	}
}
