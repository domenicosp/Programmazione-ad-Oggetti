package com.domenicosp.projectoop;


/**
 * Classe base che modella i record del file csv
 * @author Domenico
 *
 */

public class StockRecord {

	/**
	 * Attributi 
	 */
	
	private String sede;
	private String luogo;
	private int numhotspot;
	private double lat;
	private double lon;
	private String cod_impianto;
	private String note;
	
	/**
	 * Metodi base: Setter, Getter Costruttore della classe + override toString  
	 */
	
	/** 
	 * Costruttore della classe StockRecord
	 *@param sede nome della sede
	 *@param luogo via della citta
	 *@param numhotspot numero degli hotspot presenti 
	 *@param lat latitudine 
	 *@param lon longitudine
	 *@param cod_impianto codice dell'impianto
	 *@param note note aggiuntive
	 *  
	*/
	
	public StockRecord(String sede, String luogo, int numhotspot, double lat, double lon, String cod_impianto,
			String note) {
		this.sede = sede;
		this.luogo = luogo;
		this.numhotspot = numhotspot;
		this.lat = lat;
		this.lon = lon;
		this.cod_impianto = cod_impianto;
		this.note = note;
	}
	
	public StockRecord() {}

	/**
	 * Fornisce il nome della sede
	 * @return la sede
	 */
	public String getSede() {
		return sede;
	}

	 /**
     * Imposta l'attributo sede
     * @param sede stringa
     */
	public void setSede(String sede) {
		this.sede = sede;
	}
	
	/**
	 * Fornisce il nome del luogo
	 * @return il luogo
	 */
	public String getLuogo() {
		return luogo;
	}
	
	 /**
     * Imposta l'attributo luogo
     * @param luogo stringa
     */
	public void setLuogo(String luogo) {
		this.luogo = luogo;
	}
	
	/**
	 * Fornisce il numero di hotspot
	 * @return hotspot presenti 
	 */
	public int getNumhotspot() {
		return numhotspot;
	}
	
	 /**
     * Imposta l'attributo numhotspot
     * @param numhotspot int
     */
	public void setNumhotspot(int numhotspot) {
		this.numhotspot = numhotspot;
	}
	
	/**
	 * Fornisce la latitudine
	 * @return latitudine 
	 */
	public double getLat() {
		return lat;
	}
	
	 /**
     * Imposta l'attributo latitudine
     * @param lat double latitudine
     */
	public void setLat(double lat) {
		this.lat = lat;
	}
	
	/**
	 * Fornisce le coordinate 
	 * @return la longitudine
	 */
	public double getLon() {
		return lon;
	}
	
	 /**
     * Imposta l'attributo longitudine
     * @param lon double longitudine
     */
	public void setLon(double lon) {
		this.lon = lon;
	}
	
	 /**
     * Fornisce il codice dell'impianto
     * @return codice impianto
     */
	public String getCod_impianto() {
		return cod_impianto;
	}
	
	/**
     * Imposta l'attributo cod_impianto
     * @param cod_impianto string codice impianto
     */
	public void setCod_impianto(String cod_impianto) {
		this.cod_impianto = cod_impianto;
	}
	
	 /**
    * Fornisce le note 
    * @return note descrizione
    */
	public String getNote() {
		return note;
	}
	
	 /**
     * Imposta l'attributo note
     * @param note double 
     */
	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "StockRecord [sede=" + sede + ", luogo=" + luogo + ", num_hotspot=" + numhotspot + ", lat=" + lat
				+ ", lon=" + lon + ", cod_impianto=" + cod_impianto + ", note=" + note + "]";
	}
	
	
}
