package com.blessing.rest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import org.json.JSONObject;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;


public class POSTRequestReadPayloadFromJSON {

	
	@Test
	public void POSTRequestWithPayLoadFromJsonFile() throws IOException {

		Properties prop=ReUsableMethods.readDataFromPropertiesFile();

		String jsonFilePath="C:\\Users\\61086862\\eclipse-workspace\\BlessingRestAssuredTest\\TestData\\PayLoad1.json";
		//Reading File path

		String jsonData=new String(Files.readAllBytes(Paths.get(jsonFilePath)));

		//JSONObject jsonObject = new JSONObject(jsonData);
		//System.out.println("Input Data:  " +jsonObject);
		//System.out.println("BaseURI  "+prop.getProperty("baseURI"));
		//System.out.println("Resource "+prop.getProperty("postResource"));
		RestAssured.baseURI=prop.getProperty("baseURI");

		Response response= given()
				.header("Content-Type", "application/json")
				.header("Accept","application/json")
				.body(jsonData)
				.when().post(prop.getProperty("postResource"))
				.then().log().all().assertThat().statusCode(200).extract().response();
		System.out.println("Response: "+ response);


	}

}
