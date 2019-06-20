package com.domenicosp.projectoop;

import java.util.ArrayList;

public class Statistic extends StaDat {

	public Statistic(double avg, double min, double max, double sum, int count) {
		super(avg, min, max, sum, count);
	}

	public static StaDat geoStatistics(String field) {

		double average = 0, locsum = 0, locmin = 0, locmax = 0;
		int loccount = 0;

		double tempval = 0;
		
		ArrayList<StockRecord> records = StockData.getRecords();

		if(records.isEmpty()) return null;
		
		locmin = records.get(0).getLon();
		locmax = records.get(0).getLon();

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
					if (tempval >= locmax) {
						locmax = tempval;
					}
					if (tempval <= locmin) {
						locmin = tempval;
					}
				}


				if(loccount > 0) { 
					average = locsum / loccount; 
				}
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return new StaDat(average, locmin, locmax, locsum, loccount);
	}
}