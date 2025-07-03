package Day2;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import org.json.JSONObject;

public class sampletest {

    @Test 
    public void createUserTest() {
        // Base URI
        RestAssured.baseURI = "https://reqres.in";

        // Serialize Java object to JSON
        //User user = new User("John", "Tester");
           JSONObject user = new JSONObject();
            user.put("john", "Tester");

        // Send POST request with JSON body
            RequestSpecification reqspe = RestAssured.given();
        //Response response = given()
                reqspe.header("Content-Type", "application/json");
                reqspe.body(user); // <-- Serialization
                reqspe.when()
                .post("/api/users")
            .then()
                .statusCode(401)
                .extract().response();
/*
        // Deserialize JSON response to Java object
        
        //UserResponse userResponse = response.as(UserResponse.class);
        
        String respbody = response.getBody().asString();

        // Print the response
        System.out.println("Name: " + respbody.name);
        System.out.println("Job: " + userResponse.job);
        System.out.println("ID: " + userResponse.id);
        System.out.println("Created At: " + userResponse.createdAt);

        // Assertions (validation)
        assertEquals(userResponse.name, "John");
        assertEquals(userResponse.job, "Tester");   */
    }
}
