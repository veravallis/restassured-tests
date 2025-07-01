package Session03;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import net.minidev.json.JSONObject;

public class Test_PutMethod {
	
	@Test
	public void test04()
	{
	    JSONObject data = new JSONObject();
	    
	    data.put("name", "morpheus");
	    data.put("job", "zion resident");
	    
	    RestAssured.baseURI = "https://reqres.in/api/users/2";
	    RestAssured.given()
	     .header("Content-type", "application/json")
	     .contentType(ContentType.JSON)
	     .body(data.toJSONString())
	     .when().put()
	     .then().statusCode(200).log().all();
	}

}
