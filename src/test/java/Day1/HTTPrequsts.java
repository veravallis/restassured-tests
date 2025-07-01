package Day1;


import org.json.JSONObject;
import org.testng.annotations.Test;

//import net.minidev.json.JSONObject;
//import org.json.simple.JSONObject;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;



public class HTTPrequsts {
	int id;
	// @Test (priority=1)
	void getUsers()
	
	{
		given()
		
		.when()
		  .get("https://reqres.in/api/users?page=2")
		  
		.then()
		  .statusCode(200)
		  .body("page", equalTo(2))
		  .log().all();
			}
	
	@Test(priority = 2)
    void createUser() {
        //HashMap<String, String> data = new HashMap<>();
		JSONObject request =new JSONObject();
        request.put("name", "suresh");
        request.put("job", "training");

        given()
            // 🔑 Uncomment and use a real API key if required by the endpoint:
            // .header("Authorization", "Bearer reqres-xyz123abc789") 
            .contentType("application/json")
            .body(request)
        .when()
            .post("https://reqres.in/api/users")
        .then()
            .log().all()
            .statusCode(201); // ✅ Expecting 'Created'
    }
	
	//@Test (priority=3, dependsOnMethods= ("createUser"))
	void updateUser()
	{
		HashMap data = new HashMap();
				data.put("name", "ravi");
				data.put("job","teacher");
				
				int id=2;
				
				given()
		        .contentType("application/json")
		        .body(data)
		    .when()
		        .put("https://reqres.in/api/users/" + id)
		    .then()
		        .log().all()
		        .statusCode(200); 
			
		
	}


}
	
	


