package com.blessing.rest;

import io.restassured.path.json.JsonPath;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class ReUsableMethods {

	
	public static JsonPath rawJsonPath(String responseAsString)
	{
		JsonPath jsonPath= new JsonPath(responseAsString);
		return jsonPath;
	}
	
	
	public static Properties readDataFromPropertiesFile() throws IOException
	{
		Properties  props = new Properties();
		FileInputStream fis= new FileInputStream("config.properties");
		props.load(fis);
		return props;
	}
	
	public static String getJsonDataAsPayLoad(String jsonFileName) throws IOException
	{
		// Get the current working directory
		String projectDir=System.getProperty("user.dir");
		// Append the relative path to your JSON file
		String jsonFilePath = projectDir + File.separator + "TestData" + File.separator + jsonFileName;
		System.out.println("JSON FILE PATH: "+jsonFilePath);
		//Reading data from JSON file and converting as String
		String jsonData=new String(Files.readAllBytes(Paths.get(jsonFilePath)));
		return jsonData;
	}
}
