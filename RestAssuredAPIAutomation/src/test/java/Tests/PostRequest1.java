package Tests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class PostRequest1 {
	
	
	@Test
	public void postReq()
	{
		RestAssured.baseURI ="https://restful-booker.herokuapp.com";
		Response tokenResponse= RestAssured.given().header("Content-Type","application/json")
				.body("{\r\n"
						+ "    \"username\": \"admin\",\r\n"
						+ "    \"password\": \"password123\"\r\n"
						+ "}")
		.when().post("auth").
		then().log().all().extract().response();
		
		JsonPath jp= new JsonPath(tokenResponse.asString());
		String accessToken= jp.getString("token");
		System.out.println("Access Token is:  "+ accessToken);
		
		String response=RestAssured.given().header("Content-Type","application/json").
				header("Accept","application/json").body("{\r\n"
						+ "    \"firstname\": \"James\",\r\n"
						+ "    \"lastname\": \"Brown\",\r\n"
						+ "    \"totalprice\": 111,\r\n"
						+ "    \"depositpaid\": true,\r\n"
						+ "    \"bookingdates\": {\r\n"
						+ "        \"checkin\": \"2018-01-01\",\r\n"
						+ "        \"checkout\": \"2019-01-01\"\r\n"
						+ "    },\r\n"
						+ "    \"additionalneeds\": \"Breakfast\"\r\n"
						+ "}").
				when().post("booking").
				then().log().all().extract().response().asString();
		
		System.out.println("POST Request respose: "+response);
		
	}

}
