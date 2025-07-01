package Session03;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class Test_GetMethod {

	//@Test
	public void test01() {
		    
		Response response = get("https://reqres.in/api/users?page=2");
	     System.out.println("Response code:" +response.getStatusCode());
	     System.out.println("Response body:" +response.getBody().asString());
	     System.out.println("Response header:" +response.getHeader("Content-Type"));
	     System.out.println("Response time:" +response.getTime());
	     
	     //validate status code
	     //expected status code 200
	     
	     
	     int expstatuscode=200;
	     int actstatuscode = response.getStatusCode();
	     
	     Assert.assertEquals(expstatuscode,actstatuscode);
	     }
	
	@Test
	public void test02() {
		
		baseURI="https://reqres.in/api/users";
		
		given()
		.queryParam("page","2")
		
		.when()
		  .get()
		.then()
		  .statusCode(200)
		  .log().all();
		
	}
}
