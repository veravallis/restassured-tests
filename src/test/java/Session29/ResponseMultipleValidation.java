package Session29;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class ResponseMultipleValidation {
	
	    ResponseSpecification respe = null;
	    
	@BeforeClass
	public void CreateResponseSpec()
	{
		ResponseSpecBuilder respbuilder = new ResponseSpecBuilder();
		respbuilder.expectStatusCode(200);
		respbuilder.expectStatusLine("HTTP/1.1 200 OK");
		respbuilder.expectContentType(ContentType.JSON);
		respbuilder.expectResponseTime(Matchers.lessThan(3000L));
		
		respe = respbuilder.build();
	}
	
	@Test(enabled = false)
	public void Responsevalidation()
	{
	
	RequestSpecification reqspe = RestAssured.given();
	reqspe.baseUri("https://restful-booker.herokuapp.com/booking");
	reqspe.contentType(ContentType.JSON);
	Response response = reqspe.get();
	response.prettyPrint();
	
	}
	
	@Test
	public void GetAllBookingIDs()
	{
	
	RestAssured.given()
	 .baseUri("https://restful-booker.herokuapp.com/booking")
	 .when()
	    .get()
	 .then()
	    .statusCode(200)
	    .statusLine("HTTP/1.1 200 OK")
	    .contentType(ContentType.JSON)
	    .time(Matchers.lessThan(3000L));  
	    //.spec(respe);      // Validations call
	
	}
    
	@Test
	public void GetbookingName()
	{
	
	RestAssured.given()
	 .baseUri("https://restful-booker.herokuapp.com/booking?firstname=sally")
	 .when()
	    .get()
	 .then()
	   /* .statusCode(200)
	    .statusLine("HTTP/1.1 200 OK")
	    .contentType(ContentType.JSON)
	    .time(Matchers.lessThan(3000L)); */
	    .spec(respe);
	
	}
}
