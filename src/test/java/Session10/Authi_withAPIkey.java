package Session10;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class Authi_withAPIkey {

	@Test
	public void AuthenticationAPI()
	{
		RequestSpecification reqspe = RestAssured.given();
		//https://openweathermap.org/current
		//https://api.openweathermap.org/data/2.5/weather?q={city name}&appid={API key}
		// Login and take API key
		
		reqspe.baseUri("https://api.openweathermap.org");
		reqspe.basePath("/data/2.5/weather");
		reqspe.queryParam("q", "delhi").queryParam("appid", "7482627000208f7b597e3b1939d5e7c7");
		
		Response response = reqspe.get();
		
		System.out.println("response status line :" +response.statusLine());
		System.out.println("Response body :" +response.body().asString());
		
		Assert.assertEquals(response.statusCode(), 200,"Status code validation");
	}
}
