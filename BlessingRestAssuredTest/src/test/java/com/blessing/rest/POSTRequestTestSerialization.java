package com.blessing.rest;

import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import DeserializationForResponse.GetPostResponseBookingDates;
import DeserializationForResponse.GetPostResponsePojo;
import SerializationData.BookingDatePOJO;
import SerializationData.CreateBookingPOJO;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

public class POSTRequestTestSerialization {
	
@Test
public void CreateBooking()
{
RestAssured.baseURI="https://restful-booker.herokuapp.com";
// Creating object of POJO class and initialise values
	CreateBookingPOJO cPojo=new CreateBookingPOJO(); 
	cPojo.setFirstname("Sapare");
	cPojo.setLastname("SWamy");
	cPojo.setTotalprice("2000");
	cPojo.setDepositpaid(true);
	cPojo.setAdditionalneeds("NightCheckin");

// Create object of BookingDate class
	
	BookingDatePOJO bPojo= new BookingDatePOJO();
	bPojo.setCheckin("2025-08-24");
	bPojo.setCheckout("2025-08-29");
	cPojo.setBookingdates(bPojo);
	System.out.println("------------Post Request to create Booking----------");
	String PostResponse= given().header("Content-Type","application/json").
		header("Accept","application/json").
		body(cPojo).
		when().post("/booking").
		then().log().all().assertThat().statusCode(200).extract().response().asString();
		
	JsonPath js1= ReUsableMethods.rawJsonPath(PostResponse);
	String bookindId=js1.getString("bookingid");
	
	// DeSerialization  
			// GET Request
	System.out.println("------------GET Request after create Booking----------");
	GetPostResponsePojo Ppojo= given().when().get("/booking/"+bookindId).as(GetPostResponsePojo.class);
	
	System.out.println("Deserialization------------------");
	System.out.println(Ppojo.getFirstname());
	System.out.println(Ppojo.getBookingdates());
	

    //ObjectMapper mapper = new ObjectMapper();

	//GetPostResponseBookingDates bookingResponse = mapper.readValue(response.asString(), GetPostResponseBookingDates.class);
}	

}
