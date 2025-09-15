package com.blessing.rest;

import java.io.IOException;
import java.util.Properties;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class POSTRequestReadPayloadFromJSON extends ReUsableMethods{
	
	@Test
	public void POSTRequestWithPayLoadFromJsonFile() throws IOException {

		Properties prop=ReUsableMethods.readDataFromPropertiesFile();
		//Reading File path
		String jsonData=getJsonDataAsPayLoad("PayLoad1.json");
		RestAssured.baseURI=prop.getProperty("baseURI");

		Response response= given()
				.header("Content-Type", "application/json")
				.header("Accept","application/json")
				.body(jsonData)
				.when().post(prop.getProperty("postResource"))
				.then().log().all().assertThat().statusCode(200).extract().response();
		//Printing response in console 
		System.out.println("Response: "+ response.asString());
		
		//Verifying status code from response
		response.then().assertThat().statusCode(200);
	}
}
