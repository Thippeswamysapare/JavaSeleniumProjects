package com.blessing.rest;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.given;

public class GetAuthorizationToken {
	public static String getAccessToken()
	{
		RestAssured.baseURI="https://restful-booker.herokuapp.com";
		String response= given().header("Content-Type","application/json").
				body(PayLoads.PayLoadForGetToken()).
				when().post("/auth").
				then().log().all().assertThat().statusCode(200).extract().response().asString();

		JsonPath js = ReUsableMethods.rawJsonPath(response);
		//System.out.println("jsonPath "+ response);
		return js.getString("token");
	}
}
