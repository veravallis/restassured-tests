package Session27;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class MockTestAPI {
	
	@Test
	public void MockTest()
	{
		//https://run.mocky.io/v3/0c54fa7c-2c47-44ae-8c23-ee8ddd74e4d6
		
	  // Create request specification
	  RequestSpecification reqspe = RestAssured.given();
	  // Get request URL
	 Response  response = reqspe.get("https://run.mocky.io/v3/5db26d62-86bc-40b2-b9ae-8cd9fad4e5c2");
	  // print response data
	   response.prettyPrint();
	   
	  // Validate response code
	   
	   Assert.assertEquals(response.statusCode(), 200, "validate response code");
	}
	
	//	How to convert JSON response object to POJO class object - Create POJO class with above response data
	
	@Test
	public void POJOTest()
	{
		//https://run.mocky.io/v3/0c54fa7c-2c47-44ae-8c23-ee8ddd74e4d6
		
	  // Create request specification
	  RequestSpecification reqspe = RestAssured.given();
	  // Get request URL
	   reqspe.baseUri("https://run.mocky.io/v3/7dd0a948-5c5c-45db-b1b4-5435b7d1122c");
	  
	   // Deserialization
	  POJOData Empdata =    reqspe.get().as(POJOData.class);
	  System.out.println("....Deserialization data.....");
	  
	   System.out.println("First name as :" +Empdata.getFirstName());
	   System.out.println("Last name :" +Empdata.getLastName());
	   System.out.println("Age : " +Empdata.getAge());
	   System.out.println("Salary :" +Empdata.getSalary());
	   System.out.println("Is married :" +Empdata.getMarried());
	   
	   // get hobbies
	    
	   System.out.println ("Hobbies :");
	   
	          String [] hobbies = Empdata.getHobbies();
	          for (int i=0;i<hobbies.length;i++)
	          {
	        	  System.out.println(hobbies[i]);
	          }
	   
		   
	   
	   
	  
	}

}
