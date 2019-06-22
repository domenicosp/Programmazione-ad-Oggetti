package com.domenicosp.projectoop;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

/**
 * La classe ManageMetadata estende la classe {@link Metadato}
 * implementa dei metodi per la restituzioni dei metadati
 * @author Domenico
 *
 */
@Component
public class ManageMetadata extends Metadato {

	
	private static ArrayList<Metadato> metadati = new ArrayList<Metadato>();

/**
 * Preleva l'arraylist di oggetti di tipo metadato
 * @return metadati ArrayList<Metadato>
 */
	public static ArrayList<Metadato> getMetadati() {
		return metadati;
	}

/**
 * il composeMetadata restituisce un arraylist di oggetti di tipo 
 * Metadato che contiene i metadati del data-set
 * @return metadati ArrayList<Metadato>
 */
	public static ArrayList<Metadato> composeMetadata() {
		
		for (int i = 0; i < 7; i++) {
			
			metadati.add(new Metadato(StockData.getInfoalias()[i], getsourcefieldFromRecord(i+1), getTypeFromRecord(i+1)));
		}

		//System.out.println(metadati);

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
