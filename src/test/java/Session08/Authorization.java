package Session08;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Authorization {
	
	@Test
	public void BasicAuth ()
	{
		
		RequestSpecification reqspec = RestAssured.given();
		
		reqspec.baseUri("https://postman-echo.com/");
		reqspec.basePath("/basic-auth");
		
		      //Response response = reqspec.auth().basic("postman", "password").get(); // Non Preemptive
		      Response response = reqspec.auth().preemptive().basic("postman", "password").get(); // Preemptive
		      
		      System.out.println("Authentication" + response.statusLine());
		
	}
	
	@Test
	public void DigestAuth()
	{
		RequestSpecification reqspec = RestAssured.given();
		 // https://httpbin.org/digest-auth/undefined/suresh/suresh 
		reqspec.baseUri("https://httpbin.org");
		reqspec.basePath("/digest-auth/undefined/suresh/suresh");
		
		 Response response = reqspec.auth().digest("suresh", "suresh").get();
		 
		 System.out.println("Digest response:" +response.statusLine());
		 System.out.println("Digest response:" +response.body().asString());
		 
	}

}
