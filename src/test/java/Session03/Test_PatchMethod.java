package Session03;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import net.minidev.json.JSONObject;

public class Test_PatchMethod {
	
	@Test
	public void test05()
	{
		JSONObject data = new JSONObject();
		data.put("name","raghu");
		data.put("job","leader");
		
		RestAssured.baseURI = "https://reqres.in/api/users/2";
		RestAssured.given()
		.header("Content-type","application/json")
		.contentType(ContentType.JSON)
		.body(data.toJSONString())
	.when().patch()
	.then().statusCode(200).log().all();
		
	}

}
