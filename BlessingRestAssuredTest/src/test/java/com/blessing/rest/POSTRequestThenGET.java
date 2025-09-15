package com.blessing.rest;
import static io.restassured.RestAssured.given;
import java.util.Map;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import junit.framework.Assert;

public class POSTRequestThenGET {

@Test
public static void POSTRequestToCreateBooking() {
	
	RestAssured.baseURI="https://restful-booker.herokuapp.com";
	String response = given().header("Content-Type" ,"application/json").
			body(PayLoads.createBooking()).
			when().post("/booking").
			then().log().all().assertThat().statusCode(200).extract().response().asString();
	
	// Read response from POST Request
	JsonPath jsonPath1= new JsonPath(response);
	// Reading booking id from response
	String bookingId= jsonPath1.getString("bookingid");
	
	//converting json response to Map except booking id
	Map<String, Object> bookingDataPostRequest = jsonPath1.getMap("booking");
		
//	System.out.println("bookingId is : "+ bookingId);
//	System.out.println("POST Request reponse innerJson is : "+ bookingData.toString());
	
	// Validating the POST Response
	System.out.println("-----------Validating the POST Response--------");
	String getRequestRespose=given().
							when().get("/booking"+"/"+bookingId).
							then().log().all().assertThat().statusCode(200).extract().response().asString();
	
	System.out.println("GET request response is : "+ getRequestRespose);
	JsonPath jsonPath2= new JsonPath(getRequestRespose);
	Map<String, Object> bookingDataGetRequest = jsonPath2.getMap("");
	 
	Assert.assertEquals(bookingDataPostRequest, bookingDataGetRequest);
}
}
