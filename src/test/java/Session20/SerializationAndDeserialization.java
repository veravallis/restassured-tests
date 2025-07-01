package Session20;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

//import SessionPOJO.Employee;

public class SerializationAndDeserialization {
	
	@Test
	public void CreateUser() throws JsonProcessingException 
	{
		POJOEmployee Emp1 = new POJOEmployee();
		Emp1.setFirstName("Suresh");
		Emp1.setLastName("Kumar");
		Emp1.setGender("Male");
		Emp1.setAge(35);
		Emp1.setSalary(40000.00);
		
		//Convert Employee class object to JSON - Serialization
		ObjectMapper ObjMap = new ObjectMapper();
		
		String EmployeeJSN = ObjMap.writerWithDefaultPrettyPrinter().writeValueAsString(Emp1);
		
		System.out.println(EmployeeJSN);
		
		// Post method
		RequestSpecification reqspe = RestAssured.given();
		reqspe.baseUri("https://httpbin.org/post");
		reqspe.contentType(ContentType.JSON);
		reqspe.body(EmployeeJSN);
		//Post request
		Response response = reqspe.post();
		response.prettyPrint();   
		
		//Validation
		Assert.assertEquals(response.statusCode(), 200,"validate response");
		
		// Convert JSON object(Employee) to Class(POJOEmployee) - DeSerialization
		
		POJOEmployee Emp2 = ObjMap.readValue(EmployeeJSN, POJOEmployee.class);
		System.out.println("...........Print get...");
		System.out.println(Emp2.getFirstName());
		System.out.println(Emp2.getLastName());
		System.out.println(Emp2.getAge());
		System.out.println(Emp2.getGender());
		System.out.println(Emp2.getSalary());
		
		//System.out.println("Employee Get data:" +Emp2);  
	}
       
}
