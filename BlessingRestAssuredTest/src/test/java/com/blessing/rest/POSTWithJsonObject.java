package com.blessing.rest;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class POSTWithJsonObject {

	@Test
	public void TestPost() {
		Faker faker=new Faker();
		String name=faker.name().firstName();
		String token="4c18effdc972063bf8e7c9d92f6720e5e2285e626428fc083b6878a8af75ef08";
		Map<String, Object> map = new HashMap<>(); // Creating a map collection
		map.put("name", name);
		map.put("email", name+"@emmerich.test");
		map.put("gender", "male");
		map.put("status", "inactive");
		
		//Converting MAP into JsonObject
		JSONObject jsonObject = new JSONObject(map);
		System.out.println(jsonObject);
		RestAssured.baseURI = "https://gorest.co.in";

		Response response = given().header("Content-Type", "application/json").header("Accept", "application/json").
				 header("Authorization","Bearer "+ token). //Adding bearer token
				 body(jsonObject.toString()).
				 when().post("/public/v2/users").
				 then().log().all().statusCode(201).extract()
				.response();

		System.out.println("Respose : " + response.asString());
	}
}
