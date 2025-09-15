package com.blessing.rest;
import static io.restassured.RestAssured.given;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class POSTGETRequestValidateResposeAsJsonFile {

	@Test
	public static void getBookingDetails()
	{
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		Faker faker= new Faker();
		String firstname=faker.name().firstName();
		String lastname=faker.name().lastName();
		String totalprice= "1000";
		boolean depositpaid=true;
		String additionalneeds="Breakfast";
		String checkin="2018-01-01";
		String checkout="2019-01-01";
		
		String jsonBody = "{"
				+ "\"firstname\":\"" + firstname + "\","
				+ "\"lastname\":\"" + lastname + "\","
				+ "\"totalprice\":" + totalprice + ","
				+ "\"depositpaid\":" + depositpaid + ","
				+ "\"bookingdates\":{"
				+     "\"checkin\":\"" + checkin + "\","
				+     "\"checkout\":\"" + checkout + "\""
				+ "},"
				+ "\"additionalneeds\":\"" + additionalneeds + "\""
		+ "}";
		
		String response = given().header("Content-Type" ,"application/json").
				body(jsonBody).
				when().post("/booking").
				then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath jsonPath= new JsonPath(response); // JSON PATH
		String bookingId= jsonPath.getString("bookingid");
				
		Response getresponse = 
				 given().header("Content-Type", "application-json")
				.when().get("/booking/"+bookingId)
				.then().assertThat()
				.statusCode(200).extract().response();
		
		// Getting status code from RESPOSNE
		System.out.println("Status Code is :  " + getresponse.statusCode());
		// Converting RESPONSE as a String
		System.out.println("Response as String is :  " + getresponse.asString());
		//Reading data from Response directly OR
		// we use JsonPath jsonPath=new JsonPath(response);
		Assert.assertEquals(firstname, getresponse.jsonPath().getString("firstname"));
		Assert.assertEquals(lastname, getresponse.jsonPath().getString("lastname"));
		Assert.assertEquals(checkin, getresponse.jsonPath().getString("bookingdates.checkin"));
	}
}
