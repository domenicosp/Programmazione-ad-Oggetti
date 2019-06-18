package csv;

import java.io.BufferedReader;
//import java.io.IOException;
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
//import org.json.simple.parser.ParseException;

public class DownloadfilefromURL {

	private static final String DATA_URL = "https://www.dati.gov.it/api/3/action/package_show?id=3561d951-46e7-4a82-a712-04bcc5f47896";

	private static final String CSV_DATASET = "hotspot.csv";
	
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
	
	public static void DownloadCSV(String url, String fileName) throws Exception {
	    try (InputStream in = URI.create(url).toURL().openStream()) {
	        Files.copy(in, Paths.get(fileName));
	    }
	}
}
