package Session14;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;  // Validate the xml data


public class ValidateResponseXML {
	
	@Test
	public void PetDataJSON()
	{
		String JSONData = "{\r\n"
				+ "  \"id\": 0,\r\n"
				+ "  \"category\": {\r\n"
				+ "    \"id\": 0,\r\n"
				+ "    \"name\": \"string\"\r\n"
				+ "  },\r\n"
				+ "  \"name\": \"doggie\",\r\n"
				+ "  \"photoUrls\": [\r\n"
				+ "    \"string\"\r\n"
				+ "  ],\r\n"
				+ "  \"tags\": [\r\n"
				+ "    {\r\n"
				+ "      \"id\": 0,\r\n"
				+ "      \"name\": \"string\"\r\n"
				+ "    }\r\n"
				+ "  ],\r\n"
				+ "  \"status\": \"available\"\r\n"
				+ "}";
		
		RequestSpecification reqspe = RestAssured.given();
		
		//https://petstore.swagger.io/v2/pet
		reqspe.baseUri("https://petstore.swagger.io");
		reqspe.basePath("/v2/pet");
		reqspe.header("accept","application/json");
		reqspe.header("Content-Type","application/json");
		reqspe.body(JSONData);
		
		Response response = reqspe.post();
		response.prettyPrint();
		
		//get response body
		   ResponseBody respbody = response.getBody();
		         String body= respbody.asString();
		         System.out.println("Pet response body :" +body);
		// validate name in response body
		         Assert.assertEquals(body.contains("doggie"),true,"check the name");
	}

	@Test (enabled=false)
	public void PetDataXML()
	{
		String XMLData = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
				+ "<Pet>\r\n"
				+ "	<id>0</id>\r\n"
				+ "	<Category>\r\n"
				+ "		<id>0</id>\r\n"
				+ "		<name>string</name>\r\n"
				+ "	</Category>\r\n"
				+ "	<name>doggie</name>\r\n"
				+ "	<photoUrls>\r\n"
				+ "		<photoUrl>string</photoUrl>\r\n"
				+ "	</photoUrls>\r\n"
				+ "	<tags>\r\n"
				+ "		<Tag>\r\n"
				+ "			<id>0</id>\r\n"
				+ "			<name>string</name>\r\n"
				+ "		</Tag>\r\n"
				+ "	</tags>\r\n"
				+ "	<status>available</status>\r\n"
				+ "</Pet>";
		
		RequestSpecification reqspe = RestAssured.given();
		
		//https://petstore.swagger.io/v2/pet
		reqspe.baseUri("https://petstore.swagger.io");
		reqspe.basePath("/v2/pet");
		reqspe.header("accept","application/xml");
		reqspe.header("Content-Type","application/xml");
		reqspe.body(XMLData);
		
		Response response = reqspe.post();
		response.prettyPrint();
		
		//import org.hamcrest.Matchers;  -- Validate the xml data
		response.then().body("pet.name", Matchers.equalTo("doggie"));
	}

}
