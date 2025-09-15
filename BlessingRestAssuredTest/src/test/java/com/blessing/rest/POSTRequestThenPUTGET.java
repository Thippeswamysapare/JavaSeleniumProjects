package com.blessing.rest;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.given;
import java.util.Map;

public class POSTRequestThenPUTGET {
	
	static String accessToken;
	
	@Test
	public static void ValidatePutRequest()
	{
		accessToken=GetAuthorizationToken.getAccessToken();
		
		RestAssured.baseURI="https://restful-booker.herokuapp.com";
		// GET POST Request:
		String response = given().header("Content-Type","application/json").
				header("Accept","application/json").
				body(PayLoads.createBooking()).
				when().post("/booking").
				then().log().all().assertThat().
				statusCode(200).extract().response().asString();
		System.out.println("Post Request response -: "+ response);
		
		JsonPath js=ReUsableMethods.rawJsonPath(response);
		String bookingId= js.getString("bookingid");
		// Update existing Booking details using PUT Request
		
		String PUTRequestResponse= given().header("Content-Type","application/json").
				header("Accept","application/json").
				header("Cookie","token="+accessToken).
				body(PayLoads.UpdateBooking()).
				when().put("/booking"+"/"+bookingId).
				then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		Map<String,Object> PUTRequestResponseData = ReUsableMethods.rawJsonPath(PUTRequestResponse).getMap(""); 
		 System.out.println("PUTRequestResponse---- "+PUTRequestResponse);
		 
		 //GET request after Update the values
		 String GETRequestResponse= 
				 given().header("Content-Type","application/json").header("Accept","application/json").
				 when().get("/booking"+"/"+bookingId).
				 then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		 //Converting Response to Map
		 Map<String,Object> GETRequestResponseData=ReUsableMethods.rawJsonPath(GETRequestResponse).getMap("");
		 System.out.println("-----------GETRequestResponse--------- ");
		 System.out.println(GETRequestResponse);
		 
		 Assert.assertEquals(PUTRequestResponseData, GETRequestResponseData);
		 		 
		 //Delete the Booking Id
		 System.out.println("Deleting the Booking -------------------");
		 given().header("Accept","application/json").
		 		 header("Content-Type", "application/json").
		 		 header("Cookie","token="+accessToken).
		 		 when().delete("/booking"+"/"+bookingId).
		 		 then().log().all().assertThat().statusCode(201);
		 
		 //Get Method after deleted the booking details
		 given().header("Content-Type","application/json").
			header("Accept","application/json").
			when().get("/booking"+"/"+bookingId).
			then().log().all().assertThat().statusCode(404).extract().response().asString();
	}
}
