package com.domenicosp.projectoop;


import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectOOP {

	public static void main(String[] args) {
		if(!checkForFile()) {
			DownloadfilefromURL.CreateDataFromURL();
		} 

		StockData.loadDataFromFile();
		ManageMetadata.composeMetadata();

		SpringApplication.run(ProjectOOP.class, args);
	}

	private static boolean checkForFile() {
		File f = new File("hotspot.csv");
		if (f.isFile() && !f.isDirectory()) {
			System.out.println("file trovato");
			return true;
		}
		return false;
	}

}
