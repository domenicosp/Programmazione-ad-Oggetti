package csv;

public class StockRecord {


/** attributi classe json */
	
	private String sede;
	private String luogo;
	private int num_hotspot;
	private double lat;
	private double lon;
	private String cod_impianto;
	private String note;
	
	
	/** Methods */
	
	public StockRecord(String sede, String luogo, int num_hotspot, double lat, double lon, String cod_impianto,
			String note) {
		this.sede = sede;
		this.luogo = luogo;
		this.num_hotspot = num_hotspot;
		this.lat = lat;
		this.lon = lon;
		this.cod_impianto = cod_impianto;
		this.note = note;
	}
	
	public String getSede() {
		return sede;
	}
	
	public void setSede(String sede) {
		this.sede = sede;
	}
	public String getLuogo() {
		return luogo;
	}
	public void setLuogo(String luogo) {
		this.luogo = luogo;
	}
	public int getNum_hotspot() {
		return num_hotspot;
	}
	public void setNum_hotspot(int num_hotspot) {
		this.num_hotspot = num_hotspot;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLon() {
		return lon;
	}
	public void setLon(double lon) {
		this.lon = lon;
	}
	public String getCod_impianto() {
		return cod_impianto;
	}
	public void setCod_impianto(String cod_impianto) {
		this.cod_impianto = cod_impianto;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "StockRecord [sede=" + sede + ", luogo=" + luogo + ", num_hotspot=" + num_hotspot + ", lat=" + lat
				+ ", lon=" + lon + ", cod_impianto=" + cod_impianto + ", note=" + note + "]";
	}
	
	
}
