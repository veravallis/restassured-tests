package Session06;




import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;


public class ValidateResponseBody {
	
	@Test
	public void GetrespBody()
	{
		//Get request specification
		RequestSpecification reqspec = RestAssured.given();
		
		//Specify Base URI and Path
		
		reqspec.baseUri("https://reqres.in");
		reqspec.basePath("/api/users?page=2");
		
		//Perform Get request
		        Response response = reqspec.get();
		// Read get response body
		        ResponseBody respbody = response.getBody();
		           String responsestring= respbody.asString();
		           System.out.println("response body:" +responsestring);
		        
		// validation - check the George in complete body present or not
		           Assert.assertEquals(responsestring.contains("Charles"),true,"Check for name");
		           
		// get and validate jsonpathview of response body
		           
		           JsonPath jsonpathview = respbody.jsonPath();
		 // get first name from "https://jsonpathfinder.com/" - x.data[4].first_name
		         String FirstName =  jsonpathview.get("data[4].first_name");
		         
		 // Validate first name
		         Assert.assertEquals(FirstName, "Charles", "Check the first name");
	}

}
