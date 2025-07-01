package Session17;

import java.util.Iterator;
import java.util.Map.Entry;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import groovy.util.logging.Log;

//import io.restassured.mapper.ObjectMapper;

public class JSONObjectUsingJacksonAPI {

	@Test
	public void CreateUserJacksonAPI()
	{
		//Create Object mapper class instance
		ObjectMapper CreateData = new ObjectMapper();

		//Create Object node i.e JSON node
		ObjectNode UserData = CreateData.createObjectNode();

		UserData.put("firstname", "jeevan");
		UserData.put("lastname", "babu");
		UserData.put("age", 30);
		UserData.put("Salary", 25000.00);
		UserData.put("IsMarried", false);

		ObjectNode skills = CreateData.createObjectNode();
		skills.put("Programming", "Java");
		skills.put("automation", "Rest Assured");

		UserData.set("TechSkills", skills);

		// Print UserData Json
		try {
			String UserDataAsString = CreateData.writerWithDefaultPrettyPrinter().writeValueAsString(UserData);
			System.out.println("User JSON Node :" +UserDataAsString);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Get name and details

		String Name = UserData.get("firstname").asText();
		System.out.println("First name is: " +Name);
		int Age = UserData.get("age").asInt();
		System.out.println("Age is: " +Age);
		String Techskill = UserData.get("TechSkills").get("automation").asText();
		System.out.println("Technical skill is: " +Techskill);  

		System.out.println("-----------Print all field names ------------");
		Iterator <String> FieldNames =  UserData.fieldNames();
		while (FieldNames.hasNext())
		{
			System.out.println(FieldNames.next());
		}
		System.out.println("-----------Print all field Values ------------");
		Iterator<JsonNode> FieldValues =  UserData.elements();
		while (FieldValues.hasNext())
		{
			System.out.println(FieldValues.next());
		}
		System.out.println("------------Print all Field Names with Values------------");

		Iterator<Entry<String, JsonNode>> NameValue = UserData.fields();
		while (NameValue.hasNext())
		{
			Entry<String, JsonNode> node = NameValue.next();

			System.out.println("Key : " +node.getKey() + ":" + "Value :" +node.getValue());
		}

		// Remove field from node
		String LNameremove = UserData.remove("lastname").asText();
		System.out.println("Removed Last name:" +LNameremove);
		
		//Update first name
		  UserData.put("firstname", "ramesh");
		String  FName = UserData.get("firstname").asText();
		System.out.println("First name :" +FName);
		// Update Tech skills
		skills.put("Programming", "C++");
		UserData.set("TechSkills", skills);
		
		
		System.out.println("...........After removed Last name.........."); 		
		// Print UserData Json
		try {
			String UserDataAsString = CreateData.writerWithDefaultPrettyPrinter().writeValueAsString(UserData);
			System.out.println("User JSON Node :" +UserDataAsString);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  		


	}
}
