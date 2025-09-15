package com.shop.grocery;

import java.io.File; 
import java.io.IOException;
import org.testng.annotations.Test; 
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReadFromJsonFile {
	
	@Test
	public void readDataFromJson() throws IOException
	{
		
		ObjectMapper objectMapper= new ObjectMapper();
		JsonNode data = objectMapper.readTree(new File("src/test/resources/testData.json")); 
		System.out.println("URL: "+ data.get("ulr"));
		System.out.println("URL: "+ data.get("username"));
		System.out.println("URL: "+ data.get("password"));
	}

}
