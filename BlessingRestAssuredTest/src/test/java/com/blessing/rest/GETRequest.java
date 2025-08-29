package com.blessing.rest;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;


public class GETRequest {
	
	 @Test
	 public static void getBookingDetails()
	 
	 {
		RestAssured.baseURI= "https://restful-booker.herokuapp.com";
		String response= given()
			.header("Content-Type" ,"application-json")
		.when().get("/booking")
		.then().assertThat().statusCode(200).extract().response().asString();
		System.out.println("Response is :  "+ response);
	 }
	

}
