package Session21;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Session20.POJOEmployee;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;


public class POJOArrayWithSerialAndDeserialization {
	
	@Test
	public void EmployeeJSONArray() throws JsonProcessingException
	{
		POJOEmployee Emp1 = new POJOEmployee();
		Emp1.setFirstName("suresh");
		Emp1.setLastName("babu");
		Emp1.setAge(35);
		Emp1.setGender("Male");
		Emp1.setSalary(25000.00);
		
       POJOEmployee Emp2 = new POJOEmployee();
		Emp2.setFirstName("ravi");
		Emp2.setLastName("kumar");
		Emp2.setAge(37);
		Emp2.setGender("Male");
		Emp2.setSalary(35000.00);
		
       POJOEmployee Emp3 = new POJOEmployee();
		Emp3.setFirstName("Mighty");
		Emp3.setLastName("baby");
		Emp3.setAge(15);
		Emp3.setGender("Female");
		Emp3.setSalary(45000.00);
		
		//Create list of Employees
		
		List <POJOEmployee> ListEmp = new ArrayList<POJOEmployee>();
		ListEmp.add(Emp1);
		ListEmp.add(Emp2);
		ListEmp.add(Emp3);
		// Create Employee class object to JSON Array payload as String
		ObjectMapper EmpMapper = new ObjectMapper();
		String JSONArrayPayload = EmpMapper.writerWithDefaultPrettyPrinter().writeValueAsString(ListEmp);
		
		System.out.println(".....Print Array Employee data.....");
		System.out.println(JSONArrayPayload);
		
		// Post request
		RequestSpecification reqspe = RestAssured.given();
		reqspe.baseUri("https://httpbin.org/post");
		reqspe.contentType(ContentType.JSON);
		reqspe.body(JSONArrayPayload);
		
		Response response = reqspe.post();
		System.out.println(".....Post reqest.....");	
		response.prettyPrint();
		
		//Validation
		Assert.assertEquals(response.statusCode(), 200, "Post data");
		
		// Convert JSON Array object to Class object - Deserialization
		System.out.println(".....Print JSON to Class object.....");
		  ResponseBody RespBody = response.getBody();
		  JsonPath jsonpathview =  RespBody.jsonPath();
		  
		  List<POJOEmployee> Emplist  = jsonpathview.getList("json", POJOEmployee.class);
		  
		  for(POJOEmployee Emp :Emplist)
		  {
			  System.out.println(Emp.getFirstName());
		  }
		  
		  
	}

}
