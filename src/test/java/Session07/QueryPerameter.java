package Session07;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class QueryPerameter {
	
	@Test
	public void TestQueryParameter()
	{
		// request specification
	 RequestSpecification reqspec = RestAssured.given();
	   reqspec.baseUri("https://reqres.in");
	   reqspec.basePath("/api/users");
	   reqspec.queryParam("page", 2);  // Query parameter and get all data in page 2
	   //reqspec.queryParam("page", 2).queryParam("id", 7);  // Get single data in page 2 (https://jsonpathfinder.com/)
	   
	   // Get request
	     Response response = reqspec.get();
	   // Read response body  
	        String respbody = response.getBody().asString();
	        	        
	   // Print response     
	        System.out.println("Response body :" + respbody);
	        
	    // Get JSON path view
	        
	        JsonPath name = response.jsonPath();
	    // Get name 
	             String firstname = name.get("data[0].first_name");
	             System.out.println("First name:" +firstname);
	             
	             Assert.assertEquals(firstname, "Michaelaaa", "First name validation");
	}

}
