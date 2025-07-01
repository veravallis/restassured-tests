package SessionPOJO;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class serializationanddeserialization {

	@Test
	public void CreateJSONobjectFromEmployeeclassobject() throws JsonProcessingException
	{
		Employee emp1 = new Employee();
		emp1.setFirstname("Suresh");
		emp1.setLastname("Vera");
		emp1.setGender("Male");
		emp1.setAge(45);
		emp1.setSalary(45000);
		
	
	// convert employee class object to JSON object
		ObjectMapper objMapper = new ObjectMapper();
		
		String employeeJSON = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp1);
				
	    System.out.println(employeeJSON);	
	    
	  // Create request specification
	   RequestSpecification reqspe = RestAssured.given();
	    reqspe.baseUri("https://httpbin.org/post");
	    reqspe.contentType(ContentType.JSON);
	    reqspe.body(employeeJSON);
	    // post request
	   Response response = reqspe.post();
	   
	   response.prettyPrint();
	   //validate status code
	   Assert.assertEquals(response.statusCode(),200);
	   
	   //Convert JSON string (employeeJSON)to class object(Employee)
	   Employee emp2 = objMapper.readValue(employeeJSON,Employee.class);
	   
	   System.out.println(".....Convert JSON to Class Object:.....");
	   System.out.println("FirstName:" +emp2.getFirstname());
	   System.out.println("LastName:" +emp2.getLastname());
	   System.out.println("Gender:" +emp2.getGender());
	   System.out.println("Age:" +emp2.getAge());
	   System.out.println("Salary:" +emp2.getSalary());
	   
	    
	   
	}
}
