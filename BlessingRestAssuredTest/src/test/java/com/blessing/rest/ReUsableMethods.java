package com.blessing.rest;

import io.restassured.path.json.JsonPath;

import java.io.FileInputStream;
import java.io.IOException;
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
}
