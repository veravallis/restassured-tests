package Session15;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class JSonObjectUsingJAVAMap {
	
	@Test(enabled=false)
	public void CreateData()
	{
		Map<String,String> AuthToken = new HashMap<String,String>();
		    AuthToken.put("username", "admin");
		    AuthToken.put("password", "password123");
		
		RequestSpecification reqspe = RestAssured.given();
		//https://restful-booker.herokuapp.com/auth
		 reqspe.baseUri("https://restful-booker.herokuapp.com/auth");
		 reqspe.contentType(ContentType.JSON);
		 reqspe.body(AuthToken);
		 Response response = reqspe.post();
		 
		 response.prettyPrint();  //Generated the token
		 
	}

	@Test
	public void UserCreation()
	{
		HashMap<String,Object> data = new HashMap<String,Object>();
		data.put("firstName", "Ravi");
		data.put("lastname", "kumar");
		data.put("age", 30);
		data.put("salary", 30000.00);
		data.put("IsMarried", true);
		
		ArrayList<String> Hobbies = new ArrayList<String>();
		Hobbies.add("Music");
		Hobbies.add("Sports");
		data.put("Hobbies", Hobbies);
		
		HashMap<String,String> TechSkills = new HashMap<String,String>();
		TechSkills.put("Programming", "Java");
		TechSkills.put("Automation", "Rest Assuered");
		
		data.put("TechSkills", TechSkills);
		
		RequestSpecification reqspe = RestAssured.given();
		reqspe.baseUri("https://reqres.in/api/users");
		reqspe.contentType(ContentType.JSON);
		Response response = reqspe.post();
		response.prettyPrint();
	
		//Assert.assertEquals(response.statusCode(), 201,"validation");
		
	}
	
}
