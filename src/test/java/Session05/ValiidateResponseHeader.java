package Session05;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class ValiidateResponseHeader {
	
	@Test()
	public void header()
	{
		//Get request specification
		RequestSpecification reqspe = RestAssured.given();
		
		//Specify base URI
		reqspe.baseUri("https://reqres.in");
		reqspe.basePath("/api/users/2");
		//Create get request
		Response response = reqspe.get();
		
		// validate response in header for single header
		String content = response.header("Content-Type");
		System.out.println("Response as :" +content);
		
		// validate/read response in header for all headers
		
		Headers headerList = response.getHeaders();
		   //iterate all header list
		  for (Header header:headerList)
		  {
			  System.out.println("Key :" + header.getName() +  "Value :" + header.getValue());
		  }
		
		  //Validate header expected and actual results ex: content-type
		  
		  Assert.assertEquals(content, "application/json; charset=utf-8");
		
	}

	
}
