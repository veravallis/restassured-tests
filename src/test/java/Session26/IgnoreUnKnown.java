package Session26;

import org.testng.annotations.Test;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;


public class IgnoreUnKnown {

	@Test
	public void Empdata() throws JsonProcessingException
	{
		POJOIgnoreUknown Emp1 = new POJOIgnoreUknown();
		
	/*	Emp1.setFirstName("Raghu");
		Emp1.setLastName("kumar");
		Emp1.setAge(38);
		Emp1.setGender("Male");
		Emp1.setSalary(440000);
		Emp1.setMarried(true);
		Emp1.setFullName("Ram kumar"); */
		
		
		String Payload = 
				 "{ \"firstName\": \"Suresh\", \"lastName\": \"Babu\","
						+ " \"age\": 40, \"gender\": \"Male\", \"salary\": 40000.0,"
						+ " \"married\": true, "
						+ "\"fullName\": \"Suresh Babu\" }";
		// Serialization 
		ObjectMapper ObjMap = new ObjectMapper();
		
		// TO ignore unknown properties of POJO class
	     ObjMap.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		    /*String Data = ObjMap.writerWithDefaultPrettyPrinter().writeValueAsString(Emp1);
		    System.out.println(Data); */
		    
		//DeSerialization
		    
		    POJOIgnoreUknown Emp2 =   ObjMap.readValue(Payload,POJOIgnoreUknown.class);
		       System.out.println("First Name :" +Emp2.getFirstName());
		       System.out.println("Last Name :" +Emp2.getLastName());
		       System.out.println("Age:" +Emp2.getAge());
		       System.out.println("Gender is:" +Emp2.getGender());
		       System.out.println("Salary :" +Emp2.getSalary());
		       System.out.println("Is married:" +Emp2.getMarried());
		       
		    
		
	}
}
