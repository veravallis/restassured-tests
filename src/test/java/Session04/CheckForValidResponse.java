package Session04;


import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CheckForValidResponse {
	
	@Test (enabled=true)
	public void GetSingleUser()
	{
		//Specify base url
		RestAssured.baseURI = "https://reqres.in/api/users/2";
		
		//Get request specification of the request
		RequestSpecification ReqSpec = RestAssured.given();
		
		//Call Get method
		Response response = ReqSpec.get();
		
		//Get response code
		int statuscode = response.getStatusCode();
		
		//validate Actual status code with expected
		Assert.assertEquals(statuscode/*Actual*/, 200/*Expected*/,"Correct status code recived");
		
		// validate Actual Status line with expected
		
		String StatusLine = response.getStatusLine();
		Assert.assertEquals(StatusLine, "HTTP/1.1 200 OK","Correct status line received");
	}
	
	// Validate the response code and response line with "ValidatableResponse" variable
	@Test(enabled=false)
	public void GetuserValidatableResponse()
	{
		RestAssured.baseURI = "https://reqres.in/api/users/2";
		//Get request specification of the request
				RequestSpecification ReqSpec = RestAssured.given();
				
				//Call Get method
				Response response = ReqSpec.get();
		
				ValidatableResponse valresp = response.then();
				//Status code
				valresp.statusCode(200);
				valresp.statusLine("HTTP/1.1 200 OK");
				
	}
	
	// Validate the response code and response line in BDD format
	
	@Test
	public void Get_BDDStyle()
	{
		//RestAssured.baseURI = "https://reqres.in/api/users/2";
		
		RestAssured.given()
		
		.when()
		  .get("https://reqres.in/api/users/2")
		   
		
		.then().statusCode(200).statusLine("HTTP/1.1 200 OK");
	}

}
