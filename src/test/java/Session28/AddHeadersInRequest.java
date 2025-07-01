package Session28;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class AddHeadersInRequest {
	@Test
	public void headertest1()
	{
		RequestSpecification reqspe = RestAssured.given();
		
		//Add Headers
		reqspe.headers("header1","value1");   // Single header
		reqspe.log().headers();
	    //URL
		reqspe.baseUri("https://httpbin.org/get");
		// Get
		reqspe.get();
				
	}
	@Test
	public void headertest2()
	{
		
		HashMap<String, String> headermap = new HashMap();  //Multiple headers
		headermap.put("header2", "value2");
		headermap.put("header3", "value3");
		
		RequestSpecification reqspe = RestAssured.given();
		
		//Add Headers
		reqspe.headers(headermap);
		reqspe.log().headers();
	    //URL
		reqspe.baseUri("https://httpbin.org/get");
		// Get
		reqspe.get();
				
	}
	@Test
	public void headertest3()
	{
		
		Header headerrequest = new Header("header4","value4");
		
		RequestSpecification reqspe = RestAssured.given();
		
		//Add Headers
		reqspe.header(headerrequest);
		reqspe.log().headers();
	    //URL
		reqspe.baseUri("https://httpbin.org/get");
		// Get
		reqspe.get();
				
	}
	@Test
	public void headertest4()
	{
		
		Header hed1 = new Header("header5","value5");
		Header hed2 = new Header("header6","value6");
		Header hed3 = new Header("header7","value7");
		
		List<Header> Listheader = new ArrayList<Header>();
		Listheader.add(hed1);
		Listheader.add(hed2);
		Listheader.add(hed3);
		
		Headers header = new Headers(Listheader);
		
		RequestSpecification reqspe = RestAssured.given();
		
		//Add Headers
		reqspe.headers(header);
		reqspe.log().headers();
	    //URL
		reqspe.baseUri("https://httpbin.org/get");
		// Get
		Response  response = reqspe.get();
		
		//validation
		Assert.assertEquals(response.statusCode(), 200, "validation status");
	}

}
