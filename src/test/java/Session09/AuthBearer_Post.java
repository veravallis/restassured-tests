package Session09;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AuthBearer_Post {
	
	@Test(enabled=false)
	public void BearerTokenPost()
	{
		// https://gorest.co.in/public/v2/users
		RequestSpecification reqspec = RestAssured.given();
		reqspec.baseUri("https://gorest.co.in");
		reqspec.basePath("/public/v2/users");
		
		JSONObject data = new JSONObject();
		data.put("name", "apisure011");
		data.put("gender", "male");
		data.put("email", "apisure011@yopmail.com");
		data.put("status", "Active");
		
		String AuthToken = "Bearer 6b3a773041f3d4a7b5781f1aeba6fe2bd277e00153e6c9cc48211c9fa01e65fd";
		reqspec.header("Authorization", AuthToken);
		reqspec.contentType(ContentType.JSON);
		reqspec.body(data.toString());
		
		Response response = reqspec.post();
		
		System.out.println ("Status line:" +response.statusLine());
		System.out.println("Status body:" +response.body().asString());
		
	}

	@Test
	public void Testpost()
	{
		RequestSpecification reqspe = RestAssured.given();
		  reqspe.baseUri("https://gorest.co.in");
		  reqspe.basePath("/public/v2/users");
		  
		  JSONObject data = new JSONObject();
				  data.put("name", "suresh03");
				  data.put("email", "suresh03@yopmail.com");
				  data.put("gender", "male");
				  data.put("status", "Active");
				  
				  String key = "Bearer 1473d302cedb7cb44d23517037fb44f04f16d4bb0980702723047a003cba8f05";
				  
				  reqspe.header("Authorization",key);
				  reqspe.contentType(ContentType.JSON);
				  reqspe.body(data.toString());
				  
				      Response response = reqspe.post();
				      
				      System.out.println("Response line:" +response.statusLine());
				      System.out.println("Response body:" +response.body().asString());
				      
				  
				  
	}
	
}
