package com.example.demo;

import java.util.ArrayList;

public class ManageMetadata extends Metadato {

	private static ArrayList<Metadato> metadati = new ArrayList<Metadato>();



	public static ArrayList<Metadato> getMetadati() {
		return metadati;
	}


	public static ArrayList<Metadato> composeMetadata() {

		for (int i = 0; i < 7; i++) {
			metadati.add(new Metadato(StockData.getInfoalias()[i], getsourcefieldFromRecord(i+1), getTypeFromRecord(i + 1)));
		}

		System.out.println(metadati);

		return metadati;
	}

	private static String getsourcefieldFromRecord(int index) {
		switch (index) {
		case 1:
			return "Sede";
		case 2:
			return "Luogo";
		case 3:
			return "Numero di Hotspot";
		case 4:
			return "Latitudine ";
		case 5:
			return "Longitudine";
		case 6:
			return "Codice dell'Impianto";
		case 7:
			return "Note aggiuntive";
		default:
			return "";
		}
	}

	private static String getTypeFromRecord(int index) {
		switch (index) {
		case 1:
			return "String";
		case 2:
			return "String";
		case 3:
			return "int";
		case 4:
			return "Double";
		case 5:
			return "Double";
		case 6:
			return "String";
		case 7:
			return "String";
		default:
			return "";
		}
	}



}
