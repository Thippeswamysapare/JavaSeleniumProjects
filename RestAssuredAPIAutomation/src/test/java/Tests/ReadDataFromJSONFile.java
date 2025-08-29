package Tests;

import java.io.File;
import io.restassured.path.json.JsonPath;

public class ReadDataFromJSONFile {

public JsonPath jsonPath;
public JsonPath getDataFromJsonFile() throws Exception
{
		try {
            File file = new File("C:\\Users\\61086862\\eclipse-workspace\\RestAssuredAPIAutomation"
            		+ "\\src\\test\\java\\Utilities\\TestData.json");
            return new JsonPath(file);
        	} catch (Exception e) 
			{
            e.printStackTrace();
            return null; // Handle gracefully
        	}
}
}
