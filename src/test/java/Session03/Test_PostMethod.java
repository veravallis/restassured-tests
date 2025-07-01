package Session03;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import net.minidev.json.JSONObject;

public class Test_PostMethod {
	
	@Test
	public void test03()
	{
	
		JSONObject jsondata = new JSONObject();
        jsondata.put("name", "morpheus");
        jsondata.put("job", "leader");

        RestAssured
            .given()
                .baseUri("https://reqres.in/api/users")
                .contentType(ContentType.JSON)
                .body(jsondata.toJSONString())
            .when()
                .post()
            .then()
                .log().all()
                .statusCode(201);  // Only this works without auth
		  		
	}
}
