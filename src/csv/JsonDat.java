//package com.example.demo;
//
//
//import com.fasterxml.jackson.databind.ObjectMapper;
////import org.json.simple.JSONObject;
//
//public class JsonDat {
//	
//	public static void printJsonDat() {
//
//		if (StockData.getRecords().isEmpty()) {
//			System.out.println("Non ci sono records! ");
//			return;
//		}
//		try {
//			ObjectMapper objectMapper = new ObjectMapper();
//			System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(StockData.getRecords()));
//		} 
//		catch (Exception e) 
//		{
//			e.printStackTrace();
//
//		}
//
//	}
//	
//	
//	
//public static void printstats() {
//		
//		try {
//			ObjectMapper objectMapper = new ObjectMapper();
//			
//			System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(Statistic.getStadat()));
//		
//		} catch (Exception e)
//		{
//		
//			e.printStackTrace();
//
//		}
//	
//}
//	
//	
//	
//}
//
//
