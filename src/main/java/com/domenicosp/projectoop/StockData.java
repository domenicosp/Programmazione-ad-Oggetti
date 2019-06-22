package com.domenicosp.projectoop;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.ArrayList;


/**
 * Classe Stockdata che estende {@link StockRecord}  
 * la classe implementa un metodo fondamentale, loadDataFromFile 
 * per fare il parsing del file e inserirlo all'interno 
 * di un arraylist di oggetti di tipo StockData
 * @author Domenico
 *
 */

public class StockData extends StockRecord  {

	/**
	 * Attributi della classe StockData
	 */
	
	private static String filepath = "hotspot.csv";
	private static ArrayList<StockRecord> records = new ArrayList<StockRecord>();
	private static String[] info;
	private static String[] nextRecord;

	
	public StockData(String sede, String luogo, int numhotspot, double lat, double lon, String cod_impianto,
			String note) {
		super(sede, luogo, numhotspot, lat, lon, cod_impianto, note);
	}
	
	/**
	 * metodo per prelevare il primo record del file di tipo informativo
	 * utilizzato dalla classe
	 * @return info string array
	 */
	public static String[] getInfoalias() {
		return info;
	}
	
	/**
	 * Imposta l'arraylist di tipo StockRecord
	 * @return records {@code ArrayList<StockRecord>}
	 */
	public static ArrayList<StockRecord> getRecords() {
		return records;
	}

	/**
	 * Fa il Set dell'arraylist di oggetti della classe StockRecord
	 * @param records ArrayList di StockRecord
	 */
	public static void setRecords(ArrayList<StockRecord> records) {
		StockData.records = records;
	}

	@Override
	public String toString() {
		return "StockData [records=" + records + "]";
	}

	 /**
     * loadDataFromFile legge il file csv contenente i record da prelevare, 
     * ad ogni riga corrisponde un oggetto StockRecord,
     * esegue il parsing del file e restituisce un ArrayList di Stockrecord (quindi di oggetti)
     * @return records {@code ArrayList<StockRecord>}
     */
	public static ArrayList<StockRecord> loadDataFromFile() {
		System.out.println("path: " + filepath);

		StockRecord record;

		try {
			FileReader fr = new FileReader(filepath);

			CSVReader csvReader = new CSVReader(fr);

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

	/**
	 * metodo per gestire il parsing di double dove i campi
	 * del file sono vuoti. utilizzato in loadDataFromFile
	 * 
	 * @param number string
	 * @return double
	 */
	public static double ParseDouble(String number) {
		if (number != null && number.length() > 0) {
			try {
				return Double.parseDouble(number);
			} catch(Exception e) {
				return Double.NaN;
			}
		}

		return Double.NaN;
	}

}
