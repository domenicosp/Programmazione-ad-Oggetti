package com.domenicosp.projectoop;

import java.util.ArrayList;
//import org.springframework.stereotype.Component;

/**
 * Classe che implementa i metodi per eseguire statistiche sui field di oggetti 
 * della superclasse StaDat
 * @author Domenico
 *
 */


public class Statistic extends StaDat {


	public Statistic(String field, double avg, double min, double max, double sum, int count) {
		super(field, avg, min, max, sum, count);
		// TODO Auto-generated constructor stub
	}

	/**
	 * il metodo geostatistics calcola delle statistiche sulle coordinate geografiche
	 * @param field string identifica il campo su cui fare le statistiche
	 * @return statistica della longitudine oppure della latitudine
	 */
	public static StaDat geoStatistics(String field) {

		double average = 0, locsum = 0, locmin = 0, locmax = 0;
		int loccount = 0;

		double tempval = 0;

		ArrayList<StockRecord> records = StockData.getRecords();

		if(records.isEmpty()) return null;

		try {
			for(StockRecord rec : records) {
				if (field.equals("lon")) {
					tempval = rec.getLon();

				} else if (field.equals("lat")) {
					tempval = rec.getLat();
				}

				if(!Double.isNaN(tempval)) {	
					
					loccount++;
					locsum += tempval;
				}
			}

			if(loccount > 0) { 
				average = locsum / loccount; 
			}
			locmin = average;
			locmax = average;
			for(StockRecord rec1 : records) {

				if(field.equals("lon") && rec1.getLon() < locmin) locmin = rec1.getLon();
				if(field.equals("lon") && rec1.getLon() > locmax) locmax = rec1.getLon();
				if(field.equals("lat") && rec1.getLat() < locmin) locmin = rec1.getLat();
				if(field.equals("lat") && rec1.getLat() > locmin) locmax = rec1.getLat();
			}

		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return new StaDat(field, average, locmin, locmax, locsum, loccount);
	}

/**
 * il metodo hotSpotStatistics calcola delle statistiche sul field hotspot
 * @param field string identifica il campo su cui fare le statistiche
 * @return StaDat oggetto contenente i dati delle statistiche su hotspot
 */
	public static StaDat hotSpotStatistics(String field) {

		double average = 0, locsum = 0, locmin = 0, locmax = 0;
		int loccount = 0;
		
		ArrayList<StockRecord> records = StockData.getRecords();

		try {
			for(StockRecord rec : records) {
				loccount++;
				locsum += rec.getNumhotspot();
			}
			average = locsum/loccount;
			locmin = average;
			locmax = average;

			for(StockRecord rec1 : records) {
				if(rec1.getNumhotspot() < locmin) locmin = rec1.getNumhotspot();
				if(rec1.getNumhotspot() > locmax) locmax = rec1.getNumhotspot();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

		return new StaDat(field, average, locmin, locmax, locsum, loccount);
	}
}