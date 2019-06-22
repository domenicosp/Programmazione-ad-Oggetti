package com.domenicosp.projectoop;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 * la classe DownloadfilefromURL implementa tutti metodi
 * necessari a fare il parsing del JSON + il download del 
 * file nella directory di lavoro
 * 
 * @author Domenico
 *
 */
public class DownloadfilefromURL {

	// Attributi
	
	private static final String DATA_URL = "https://www.dati.gov.it/api/3/action/package_show?id=3561d951-46e7-4a82-a712-04bcc5f47896";

	private static final String CSV_DATASET = "hotspot.csv";

	//Metodi
	/**
	 * Il metodo CreateDataFromURL è 
	 * il metodo principale della classe DownloadfilefromURL 
	 * che fa il parsing di un JSON per selezionare l'URL da cui
	 * fare il download del file
	 */
	public static void CreateDataFromURL() {


		try {

			URLConnection openConnection = new URL(DATA_URL).openConnection();
			openConnection.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
			InputStream in = openConnection.getInputStream();

			String data = "";
			String line = "";
			try {
				InputStreamReader inR = new InputStreamReader( in );
				BufferedReader buf = new BufferedReader( inR );

				while ( ( line = buf.readLine() ) != null ) {
					data+= line;
					System.out.println( line );
				}
			} finally {
				in.close();
			}

			CreateURLFromData(data);
			System.out.println( "OK" );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * CreateURLFromData fa il parsing del JSON per selezionare
	 * l'URL da cui fare il download
	 * @param data Stringa
	 */
	public static void CreateURLFromData(String data) {
		try {
			JSONObject obj = (JSONObject) JSONValue.parseWithException(data); 
			JSONObject objI = (JSONObject) (obj.get("result"));
			JSONArray objA = (JSONArray) (objI.get("resources"));

			for(Object o: objA){
				if ( o instanceof JSONObject ) {
					JSONObject o1 = (JSONObject)o; 
					String format = (String)o1.get("format");
					String urlD = (String)o1.get("url");
					System.out.println(format + " | " + urlD);
					if(format.equals("csv")) {
						try {
							DownloadCSV(urlD, CSV_DATASET);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
/**
 * metodo per il download del data-set
 * @param url Stringa 
 * @param fileName nome del file
 * @throws Exception 
 */
	public static void DownloadCSV(String url, String fileName) throws Exception {
		try (InputStream in = URI.create(url).toURL().openStream()) {
			Files.copy(in, Paths.get(fileName));
		}
	}
	
	/**
	 * metodo per il controllo della presenza del dataset 
	 * nella Directory
	 * @return boolean value
	 */
	public static boolean checkForFile() {
		File f = new File("hotspot.csv");
		if (f.isFile() && !f.isDirectory()) {
			System.out.println("file trovato");
			return true;
		}
		return false;
	}
	
	/**
	 * checkDownload chiama il metodo {@link checkForFile}
	 * se il file non è presente nella Directory effettua il download
	 * altrimenti non fa nulla
	 */
	public static void checkDownload () {
		if(!DownloadfilefromURL.checkForFile()) {
			DownloadfilefromURL.CreateDataFromURL();
		}
	}
}
