package Session16;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class UserwithJSONArray {

	@Test (enabled=false)
	public void CreateMultipleUsersWithJSONArray()
	{
		JSONObject User1 = new JSONObject();
		User1.put("firstname", "ravi");
		User1.put("lastname", "kumar");
		User1.put("age", 30);
		User1.put("salary", 30000.00);
		
		JSONObject User2 = new JSONObject();
		User2.put("firstname", "raju");
		User2.put("lastname", "babu");
		User2.put("age", 39);
		User2.put("salary", 310000.00);
		
		JSONObject User3 = new JSONObject();
		User3.put("firstname", "kapil");
		User3.put("lastname", "raju");
		User3.put("age", 37);
		User3.put("salary", 360000.00);
		// Add JSON Objects to JSON Array
		JSONArray UserData = new JSONArray();
		UserData.add(User1);
		UserData.add(User2);
		UserData.add(User3);
				
		RequestSpecification reqspe = RestAssured.given();
		reqspe.baseUri("https://reqres.in/api/users");
		reqspe.contentType(ContentType.JSON);
		reqspe.body(UserData);
		Response response = reqspe.post();
		response.prettyPrint();
		
	}
	
	@Test
	public void CreateJSONAraayusingList()
	{
		//JSONObject UserData1 = new JSONObject();
		HashMap<String,Object> UserData1 = new HashMap<String,Object>();  //Using List
		UserData1.put("firstname", "ravi");
		UserData1.put("lastname", "kumar");
		UserData1.put("age", 30);
		UserData1.put("salary", 30000.00);
		
		HashMap<String,Object> UserData2 = new HashMap<String,Object>();
		UserData2.put("firstname", "raju");
		UserData2.put("lastname", "kumar");
		UserData2.put("age", 30);
		UserData2.put("salary", 30000.00);
		
		HashMap<String,Object> UserData3 = new HashMap<String,Object>();
		UserData3.put("firstname", "prasad");
		UserData3.put("lastname", "kumar");
		UserData3.put("age", 30);
		UserData3.put("salary", 30000.00);
		
		//JSONArray UserData = new JSONArray();
		List<HashMap<String,Object>> ListData = new ArrayList<>();
		ListData.add(UserData1);
		ListData.add(UserData2);
		ListData.add(UserData3);
		
		RequestSpecification reqspe = RestAssured.given();
		reqspe.baseUri("https://reqres.in/api/users");
		reqspe.contentType(ContentType.JSON);
		reqspe.body(ListData);
		Response response = reqspe.post();
		response.prettyPrint();
		
		//Validation
		//Assert.assertEquals(response.statusCode(), 201,"Status code validation");
		
	}
}
