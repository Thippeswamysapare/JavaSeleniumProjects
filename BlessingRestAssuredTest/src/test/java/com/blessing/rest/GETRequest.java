package com.blessing.rest;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GETRequest {

	@Test
	public static void getBookingDetails()

	{
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		Response response = 
				 given().header("Content-Type", "application-json")
				.when().get("/booking/891")
				.then().assertThat()
				.statusCode(200).extract().response();
		
		System.out.println("Status Code is :  " + response.statusCode());
		System.out.println("Response from direct reseponse is :  " + response);
		System.out.println("Response as String is :  " + response.asString());
		
		response.
				then().
				assertThat().
				statusCode(200);
	}
}
