package datadriven;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import org.testng.Assert;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public class ExcelData {

	/**public static void main(String[] args) {
		getNumber1();
	}
	public static void getNumber1() {
		String file = Helpers.getFileFromResources("basses.csv");
		FileReader fileReader;

		try {
			fileReader = new FileReader(file);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(file + " could not be read.");
		}

		CSVReader reader = new CSVReaderBuilder(fileReader).withSkipLines(1).build();
		List<Bass> basses = new ArrayList<Bass>();
		String[] record = null;

		try {
			while ((record = reader.readNext()) != null) {			
				Bass bass = new Bass();
				bass.setMake(record[0]);
				bass.setModel(record[1]);
				bass.setStringCount(Integer.parseInt(record[2]));

				basses.add(bass);
			}
		}
		catch(Exception ex) {
			throw new RuntimeException(ex.getMessage());
		}
		
		Assert.assertEquals(basses.size(), 6, "File contains 6 rows not including header.");
		Assert.assertNotNull(basses.get(0).getMake(), "All Object in collection should be populated.");
	} **/
}