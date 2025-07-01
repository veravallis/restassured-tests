package Session18;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class FileUploadinJSon {
	@Test (priority = 2)
	public void FileUpload()
	{
		File UploadFile = new File("C:\\Users\\Malini\\Desktop\\File upload testing.txt");
		
		RequestSpecification reqspe = RestAssured.given();
		reqspe.baseUri("https://httpbin.org/post");
		reqspe.multiPart(UploadFile);
		reqspe.contentType("multipart/form-data");
		
		Response response = reqspe.post();
		System.out.println("uploaded file is :" +response.asString());
		
	}

	@Test(priority = 1)
	public void ImageUpload()
	{
		File UploadImage = new File("C:\\Users\\Malini\\Desktop\\Test Image.png");
		
		RequestSpecification reqspe = RestAssured.given();
		reqspe.baseUri("https://httpbin.org/post");
		reqspe.multiPart(UploadImage);
		//reqspe.contentType(ContentType.JSON);
		
		System.out.println("............Image upload..............");
		Response response = reqspe.post();
		System.out.println("uploaded file is :" +response.asString());
		
	}
}
