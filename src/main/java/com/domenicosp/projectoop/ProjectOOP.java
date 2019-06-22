package com.domenicosp.projectoop;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectOOP {

	public static void main(String[] args) {

		DownloadfilefromURL.checkDownload();		/**	viene invocato il metodo checkDownload della classe DownloadfilefromURL per 
													* 	effettuare il download del file se non è presente nella directory
													*/
				
		StockData.loadDataFromFile();				/**
													*	loadDataFromFile restituisce l'arraylist pieno di oggetti letti da file
													*/
		ManageMetadata.composeMetadata();			

		SpringApplication.run(ProjectOOP.class, args);
	}

}
