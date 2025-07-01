package Session30;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import java.io.File;

public class JSONSchemaValidation {
	
	@Test
	public void JSonSchemaValidation()
	{
		String EmpData = "{\r\n"
				+ "    \"username\" : \"admin\",\r\n"
				+ "    \"password\" : \"password123\"\r\n"
				+ "}";
		
	RestAssured
		.given()
		  .baseUri("https://restful-booker.herokuapp.com/auth")
		  .contentType(ContentType.JSON)
		  .body(EmpData)
		.when()
		  .post()
		.then()
		  .assertThat()
		  .statusCode(200)
		  .body("token", Matchers.notNullValue())
		  .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("Schema.json")); // file under Class path
	
		  // .body(JsonSchemaValidator.matchesJsonSchema(new File("C:\\Users\\Malini\\Desktop\\Schema.json"))); // File saved in desktop
		  
	}

}
