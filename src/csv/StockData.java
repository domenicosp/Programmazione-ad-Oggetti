package csv;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.ArrayList;

// *************Method[] m1 = obj.getClass().getMethods(); m1[0].getReturnType().equals(Double.TYPE); //String.TYPE, Integer.TYPE….

public class StockData  {

	private static String filepath = "hotspot.csv";
	private static ArrayList<StockRecord> records = new ArrayList<StockRecord>();
	private static String[] info;
	private static String[] nextRecord;
	
	public static String[] getInfoalias() {
		return info;
	}
	
	public static ArrayList<StockRecord> getRecords() {
		return records;
	}

	public static void setRecords(ArrayList<StockRecord> records) {
		StockData.records = records;
	}
	
	@Override
	public String toString() {
		return "StockData [records=" + records + "]";
	}

	public static ArrayList<StockRecord> loadDataFromFile() {
		System.out.println("path: " + filepath);
		
		StockRecord record;
		
		try {
			FileReader fr = new FileReader(filepath);
			
			CSVReader csvReader = new CSVReader(fr);
//			String[] nextRecord;
			
			info = csvReader.readNext();
			
			while((nextRecord = csvReader.readNext()) != null) {

				String sede = nextRecord[0]; 
				String luogo = nextRecord[1]; 
				
				int num_hotspot = Integer.parseInt(nextRecord[2]);
				double lat = ParseDouble(nextRecord[3]);
				double lon = ParseDouble(nextRecord[4]);
				String cod_impianto = nextRecord[5]; 
				String note = nextRecord[6];
				
				record = new StockRecord(sede, luogo, num_hotspot, lat, lon, cod_impianto, note);
				records.add(record);
				
				
			}
			
			csvReader.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return records;

	}
	
	private static double ParseDouble(String number) {
		if (number != null && number.length() > 0) {
			try {
				return Double.parseDouble(number);
			} catch(Exception e) {
				return Double.NaN;
			}
		}
		
		return Double.NaN;
	}

	public static void printdata () {
		for(StockRecord rec : records) {
			System.out.println(rec);
		}
	
	}
	
	
	
	
	
}
