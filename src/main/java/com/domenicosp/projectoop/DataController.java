package com.domenicosp.projectoop;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.domenicosp.projectoop.StockData;

@RestController
public class DataController {

	@GetMapping("/data")
	@ResponseBody
	public ArrayList<StockRecord> Jdata() {
		return StockData.getRecords();
	}

	@GetMapping("/metadata")
	@ResponseBody
	public ArrayList<Metadato> Jmetadato() {
		return ManageMetadata.getMetadati();
	}

	@GetMapping("/statistics")
	@ResponseBody
	public StaDat Jstatisticlat(@RequestParam String field) {
		if (field.equals("lat") || field.equals("lon")) {
			return Statistic.geoStatistics(field);
		} else if (field.equals("hotspot")) {
			// hotspot
		}
		
		return null;
	}
}
