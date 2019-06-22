package com.domenicosp.projectoop;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.domenicosp.projectoop.StockData;

/**
 * Controller Spring
 * @author Domenico
 *
 */
@RestController
public class DataController {

	/**
	 * Restituisce i dati 
	 * @return records {@code ArrayList<StockData>}
	 */
	@GetMapping("/data")
	@ResponseBody
	public ArrayList<StockRecord> Jdata() {
		return StockData.getRecords();
	}

	/**
	 * Restituisce i metadati del data-set
	 * @return metadata
	 */
	@GetMapping("/metadata")
	@ResponseBody
	public ArrayList<Metadato> Jmetadato() {
		return ManageMetadata.getMetadati();
	}

	/**
	 * 
	 * @param field passato dall'utente
	 * @return StaDat ArrayList
	 */
	@GetMapping("/stats")
	@ResponseBody
	public StaDat Jstatisticlat(@RequestParam String field) {
		if (field.equals("lat") || field.equals("lon")) {
			return Statistic.geoStatistics(field);
	
		} else if (field.equals("hotspot")) {
			return Statistic.hotSpotStatistics(field);
		}
		
		return null;
	}
	
}
