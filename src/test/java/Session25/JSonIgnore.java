package Session25;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSonIgnore {
	
	@Test
	public void EmployeeIgnore() throws JsonProcessingException
	{
		POJOEmp Emp1 = new POJOEmp();
		Emp1.setFirstName("Suresh");
		Emp1.setLastName("kumar");
		Emp1.setAge(42);
		Emp1.setGender("Male");
		Emp1.setIsMarried(false);
		Emp1.setSalary(420000);
		Emp1.setFullName("Kumar babu");
		
		// Convert Object class to JSon object Serialization
		ObjectMapper ObjMapper = new ObjectMapper();
		String Employee = ObjMapper.writerWithDefaultPrettyPrinter().writeValueAsString(Emp1);
		System.out.println(Employee);  
		
		// Convert JSon Object to Class object DeSerialization
		
		POJOEmp Emp2 = ObjMapper.readValue(Employee, POJOEmp.class);
		System.out.println("DeSerialization Employee data");
		System.out.println("First Name:" +Emp2.getFirstName());
		System.out.println("Last Name:" +Emp2.getLastName());
		System.out.println("Age:" +Emp2.getAge());
		System.out.println("Salary:" +Emp2.getSalary());
		System.out.println("IsMarried:" +Emp2.getIsMarried()) ;
		System.out.println("Full Name :" +Emp2.getFullName());
		System.out.println("Gender is:" +Emp2.getGender());
		            
	} 

}
