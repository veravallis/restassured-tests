package Session11;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class Auth_OAuth2 {
	static String AccessToken;
	
	@Test
	public void GetAccessOAuth2()
	{
	    RequestSpecification reqspe = RestAssured.given();
	    //https://api-m.sandbox.paypal.com/v1/oauth2/token
	    
	    reqspe.baseUri("https://api-m.sandbox.paypal.com");
	    reqspe.basePath("/v1/oauth2/token");
	    
	    // Create object for Clientid and secrete id
	     String clientid = "AW_936lrIY_-WYyHGIrF6W7Orp1vOuLTKp0BgZK45PLPdh_3qUaJX4UpudD1uIwVM_cuBm7q2sfJCzdo";
	     String Secretkey = "EOImI7hwPJ241_8n2UDAPkX-qNyd5L3usybXzd25jK6Fh6SuLI6Q-4YkYOGg90dTJc3NNZUyMERfB-eI";
	     
	     //Basic Authorization
	    Response response = reqspe.auth().preemptive().basic(clientid, Secretkey).param("grant_type", "client_credentials").post();
	     
	    response.prettyPrint();
	    
	    System.out.println("Response code: " +response.statusCode());
	    System.out.println("response line :" +response.statusLine());
	    
	    //validation for response code
	    Assert.assertEquals(response.statusCode(), 200);
	    
	    //Get Access token from response body
	          AccessToken = response.getBody().path("access_token");
	          System.out.println("Access token as :" +AccessToken);
	    	    
	}
    @Test(dependsOnMethods="GetAccessOAuth2")
	public void ListInvoice()
	{
    	//https://api-m.sandbox.paypal.com/v1/invoicing/invoices?page=3&page_size=4&total_count_required=true
		RequestSpecification reqspe = RestAssured.given();
		reqspe.baseUri("https://api-m.sandbox.paypal.com");
		reqspe.basePath("/v1/invoicing/invoices");
		reqspe.auth().oauth2(AccessToken).queryParam("page", 3).queryParam("page_size", 4).queryParam("total_count_required", true);
		
		Response response = reqspe.get();
		
		System.out.println("........Invoice.........");
		response.prettyPrint();
		System.out.println("Response line :" +response.statusLine());
		System.out.println("Response code :" +response.statusCode());
	}
	
}
