package Tests;

import static io.restassured.RestAssured.given;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import Utilities.BaseTest;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.equalTo;

public class CreateUser_POST_Request extends BaseTest{
	
	//JsonPath jsonPath;
	JsonPath responseBodyjsonPath;
	JsonPath requestBodyjsonPath;
	@Test
	public void createUserWithPOSTRequest() throws Exception
	{
		Faker faker =new Faker();
		requestBodyjsonPath=getDataFromJsonFile();
		String name = faker.name().firstName();
		Map<String, Object> map= new HashMap<String, Object>();
		map.put("name", name);
		map.put("email", name +"@gmail.com");
		map.put("gender" ,"male");
		map.put("status", "inactive");
		System.out.println(map);
		//  Converting MAP to Json Object 
		JSONObject jsonObject = new JSONObject(map);
		System.out.println(jsonObject);
		// Read Data from JSON File
		//JsonPath jsonpath= readDataFromJsonFile.getDataFromJsonFile();
		RestAssured.baseURI= requestBodyjsonPath.getString("BaseURI");
		
		Response response=  
				 given()
				.header("Authorization" , "Bearer " + requestBodyjsonPath.getString("AccessToken"))
				.header("Content-Type" ,"application/json")
				.body(jsonObject.toJSONString())
				.when()
				.post("public/v2/users")
				.then()
				.statusCode(201)
				.extract()
				.response();
		
		//Creating Json Object for response body after POST Request
		responseBodyjsonPath= response.jsonPath();
		System.out.println("RESPOSE   :  " + responseBodyjsonPath.toString());
		System.out.println("public/v2/users/"+responseBodyjsonPath.getString("id"));
		
		
		//Get Request after POST to validate response
		given()
			.get("public/v2/users/"+responseBodyjsonPath.getString("id"))
			.then().statusCode(200)
			.body("[1].name", equalTo(responseBodyjsonPath.getString("name")));
//		
//		String responseJson= response.toString();
//		System.out.println("Respose is .......:  " +response.toString());
}
}
