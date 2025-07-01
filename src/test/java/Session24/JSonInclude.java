package Session24;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class JSonInclude {
	
	@Test
	public void EmployeDetails() throws JsonProcessingException
	{
	
	POJOIncludu Emp1 = new POJOIncludu();
	Emp1.setFirstName("Suresh");
	//Emp1.setLastName("Kumar");
	//Emp1.setAge(40);
	Emp1.setGender("Male");
	//Emp1.setIsMarried(true);
	Emp1.setSalary(450000.00);
	
	//Empty String
	String[] Hobbies = {} ;
	//String[] Hobbies = new String[2] ;
	//Hobbies[0] = "Reading";
	//Hobbies[1] = "Cricket"

	 Emp1.setHobbies(Hobbies);
	
	 //Empty String
	List<String> Degrees = new ArrayList<String>();
	//Degrees.add("MCA");
	//Degrees.add("PG");
	  Emp1.setDegrees(Degrees);
	
	  // Empty Map
	Map<String,String> FamilyMembers = new HashMap<>();
	//FamilyMembers.put("1", "Father");
	//FamilyMembers.put("2", "Mother");
	   Emp1.setFamilyMembers(FamilyMembers);
	
	
	       // Convert Class object to JSon object
	     ObjectMapper ObjMapper = new ObjectMapper();
	     String JSondata = ObjMapper.writerWithDefaultPrettyPrinter().writeValueAsString(Emp1);
	     
	     System.out.println(JSondata);
	     
	
	}

}
