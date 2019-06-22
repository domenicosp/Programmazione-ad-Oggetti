Progetto OOP

DESCRIZIONE:

- Download del Data-Set con il relativo parsing del file per successiva manipolazione dei dati contenuti al suo interno.

In particolare il Data-set assegnato è posto nel seguente link : : https://goo.gl/ul2UX2.

Sono state create un insieme di classi tali da poter gestire la richiesta del testo assegnato quali:
 
- Gestione del download da URL che richiede il parse di un JSON per ricavare l'URL su cui fare il download
	del Data-Set in questione;

- Creazione di classi e relativi metodi per effettuare il parsing del file gestendo le varie eccezioni

- Creazione di un insieme di classi per manipolare i dati che sono stati caricati in RAM (ogni record, 
	cioè ogni riga del file costituito da diversi campi di tipo diverso è un'oggetto della classe 
	"StockRecord") e manipolati successivamente.

- Creazione di classi per effettuare statistiche e restituire dati formato JSON richiesti dall'utente con 
	chiamate REST.

STRUMENTI UTILIZZATI:	

- Gli strumenti utilizzati per realizzare il progetto:
	
	- IDE : Eclipse EE con relativi tool per lo sviluppo;
	- FRAMEWORK  : Spring Boot per le chiamate REST;
	- JAVADOC;
	- GITHUB  : per versionare il codice.
	- MAVEN;
	
	
UTILIZZO DEL PROGRAMMA:

Dopo l'avvio con Spring Appilication l'utente può effettuare le seguenti richieste e ottenere dati sul Data-set:

-	Restituzione dei metadati: localhost://8080/metadata;

-	Restituzione dei dati: localhost://8080/data;

- 	Restituzione delle statistiche:
	
	-(longitudine): localhost://8080/stats?field=lon;
	
	-(latitudine): localhost://8080/stats?field=lat;
	
	-(hotspot):	localhost://8080/stats?field=hotspot;
	

		
	