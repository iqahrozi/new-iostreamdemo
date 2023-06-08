package exercise6;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

/**
 * This program enables Processing  Daily  Rainfall Data  from Selected Station using Byte-Based Stream
 * The data is written in byte-based using DataOutputStream class. 
 * 
 * The data consists of station id, station name, name of district and 6-days reading of daily rainfall.
 * @author-NUR SYAFIQAH (B032110192)
 *
 */
public class RainFallByteBasedGenerator {
	
	public static void main (String [] args)
	{
		// 1. Declare output file as RainfallByteBased.txt
		String outFile = "RainfallByteBased.txt";
		
		// Data declaration
		// Station id
		int id[] = {2421003, 2322006, 2424031, 2324032, 2223023, 2222006};
		
		// Station name
		String stations[] = {"Simpang Ampat", "Melaka Pindah", "Datoh Kramat", "Ldg Sing Lian", "Sg. Duyong", "Cheng"};
		
		// district name
		String district[] = {"Alor Gajah", "Alor Gajah", "Jasin", "Jasin", "Melaka Tengah", "Melaka Tengah"};
		
		// readings on 2 June 2023
		double readings1[] = {2.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		
		// readings on 3 June 2023
		double readings2[] = {4.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		
		// readings on 4 June 2023
		double readings3[] = {1.0, 0.0, 0.0, 0.0, 3.0, 3.5};
		
		// readings on 5 June 2023
		double readings4[] = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		
		// readings on 6 June 2023
		double readings5[] = {6.0, 2.0, 0.0, 0.5, 43.0, 42.5};
		
		// readings on 7 June 2023
		double readings6[] = {19.0, 18.5, 17.0, 45.0, 26.0, 14.5};
		
		try {
			
			// 2. Create output stream to read data
			DataOutputStream dosOut = new DataOutputStream(new FileOutputStream(outFile));
			
			// Process data
			for (int index = 0; index < stations.length; index++) {
				
				// 3. Write data into data stream
				dosOut.writeInt(id[index]);
				dosOut.writeUTF(stations[index]);
				dosOut.writeUTF(district[index]);
				dosOut.writeDouble(readings1[index]);
				dosOut.writeDouble(readings2[index]);
				dosOut.writeDouble(readings3[index]);
				dosOut.writeDouble(readings4[index]);
				dosOut.writeDouble(readings5[index]);
				dosOut.writeDouble(readings6[index]);
				
				// 4. Flush for each writing
				dosOut.flush();
			}
			
			// 5. Close stream
			dosOut.close();
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
		}
		
		// Indicate end of program 
		System.out.println("End of program. Check out " + outFile); 
	}
}
