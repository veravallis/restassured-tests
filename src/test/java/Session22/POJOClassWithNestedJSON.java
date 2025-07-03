package Session22;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class POJOClassWithNestedJSON {
	
	@Test(enabled=false)
	public void CreateUser() throws JsonProcessingException
	{
		POJOEmployeeData Emp1 = new POJOEmployeeData();  //1st POJO class
		Emp1.setFirstName("Suresh");
		Emp1.setLastName("Babu");
		Emp1.setAge(35);
		Emp1.setGender("Male");
		Emp1.setSalary(40000.00);
		
		POJOAddress Emp1Address = new POJOAddress(); // 2nd POJO Class of address
		Emp1Address.setStreate("Park Evanue");
		Emp1Address.setCity("Vijayawada");
		Emp1Address.setState("Andhra pradesh");
		Emp1Address.setPinCode(421005);
		
		Emp1.setAddress(Emp1Address);   // Call 2nd pojo address data into 1st Emp1
		// Convert class object to JSON object
		ObjectMapper objmapper = new ObjectMapper();
		String EmployeeData = objmapper.writerWithDefaultPrettyPrinter().writeValueAsString(Emp1);
		System.out.println(EmployeeData);
		
		// Create request specification
		RequestSpecification reqspe = RestAssured.given();
		reqspe.baseUri("https://httpbin.org/post");
		reqspe.contentType(ContentType.JSON);
		reqspe.body(EmployeeData);
		
		// Post request
		Response response = reqspe.post();
		System.out.println(".....Post request....");
		response.prettyPrint();
		
		
		
	}

}
