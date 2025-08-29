package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;

import static org.hamcrest.Matchers.equalTo;

 

public class MyFirstAPI {
	
	JsonPath jsonPath ;
	@Test
	public void getUser()
	{
	//RestAssured.get("https://gorest.co.in/public/v2/posts");  RestAssured is not required when we import io.restassured with static
	Response response=	get("https://gorest.co.in/public/v2/posts");
	System.out.println("Respose Code " + response.statusCode());
	System.out.println("Time " + response.time());
	//System.out.println("Respose is : "+ response.getBody().toString());
	System.out.println("Respose is : "+ response.asPrettyString()); 
	System.out.println("Header type : "+ response.header("content-type"));
	Assert.assertEquals(response.statusCode(),200);
	 
	}

	@Test
	public void test_2() throws Exception
	{
		ReadDataFromJSONFile jsonFileDataRead= new ReadDataFromJSONFile();
		jsonPath = jsonFileDataRead.getDataFromJsonFile();
		RestAssured.baseURI= jsonPath.getString("BaseURI");
		given().
		header("Content-Type" ,"application/json").  // OR 
		contentType(ContentType.JSON). 
		get(jsonPath.getString("GetReqeuestResourcePath")).
				then().
					statusCode(200).
					 body("[1].id", equalTo(233309));
				
		
		//System.out.println("Respose is : "+ response1.asPrettyString());
	}
}
