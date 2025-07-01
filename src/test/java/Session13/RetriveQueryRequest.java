package Session13;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;

public class RetriveQueryRequest {
	
	@Test
	public void CreateUser()
	{
		//Data create JSON
				JSONObject data = new JSONObject();
				data.put("name", "raju");
				data.put("job","teacher");
		
		// https://reqres.in/api/users
		RequestSpecification reqspe= RestAssured.given();
		reqspe.baseUri("https://reqres.in");
		reqspe.basePath("/api/users");
		reqspe.contentType(ContentType.JSON);
		reqspe.body(data.toJSONString());
		
		//Create User
        Response response = reqspe.post();
		System.out.println ("Status line:" +response.statusLine());
		System.out.println("Status body:" +response.body().asString());
		
		//Query details from request specification
		QueryableRequestSpecification speque = SpecificationQuerier.query(reqspe);
		
		//Get Base URI,Path and data
		System.out.println("Base URI :" +speque.getBaseUri());
		System.out.println("Base Path :" +speque.getBasePath());
		System.out.println("Data body details :" +speque.getBody());
		
		//Get request header information
		     Headers allheader = speque.getHeaders();
		     //System.out.println("Data body details :" +allheader);
		     for (Header h:allheader)
		     {
		    	 System.out.println("Header name:" +h.getName() + "Header value:" +h.getValue());
		     }
		         
		
	}

}
