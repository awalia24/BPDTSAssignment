package Assignment;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GETAssignment {
	
	String BaseURI="http://bpdts-test-app-v2.herokuapp.com/";
@Test(priority=1)
public void getCityDetails() {
		
		RestAssured.baseURI = BaseURI;
		String City="london";
		 RequestSpecification httpRequest = RestAssured.given();
		 Response response = httpRequest.get("city/london/users");
	
		 System.out.println("1.Request Endpoint url is :" +BaseURI+ "city/"+City+ "/users");
		 
		 String responsestring=response.getBody().asString();
		 System.out.println("Response body is: " +responsestring);
		 
		 int statusCode = response.getStatusCode();
		 System.out.println("Status code is: " +statusCode);
		 
		 Assert.assertEquals(statusCode , 200);
		 Headers allHeaders = response.headers();
		 for(Header header : allHeaders)
		 {
		 System.out.println("Header Response Key: " + header.getName() + " Value: " + header.getValue());
		 }
		 
	System.out.println("-------------------------------------");	}
@Test(priority=2)	
public void getInstructions() {
	
	RestAssured.baseURI = BaseURI;
	 RequestSpecification httpRequest = RestAssured.given();
	 Response response = httpRequest.get("instructions");
	 
	 System.out.println("2.Request Endpoint url is : " +BaseURI+ "instructions");

	 int statusCode = response.getStatusCode();
	 System.out.println("Status code is: " +statusCode);
	 Assert.assertEquals(statusCode , 200);
	 
	 String responsestring=response.getBody().asString();
	 System.out.println("Response body is: " +responsestring);
	 
	 Headers allHeaders = response.headers();
	 for(Header header : allHeaders)
	 {
	 System.out.println("Header Response Key: " + header.getName() + " Value: " + header.getValue());
	 }
	 System.out.println("-------------------------------------");
}
	@Test(priority=3)
	public void getUserDetails200() {
		int ID=1;
		RestAssured.baseURI = BaseURI;
		 RequestSpecification httpRequest = RestAssured.given();
		 Response response = httpRequest.get("user/500");
	
		 System.out.println("3.Request Endpoint url is : " +BaseURI+ "user/" +ID);
		 
		 String responsestring=response.getBody().asString();
		 System.out.println("Response body is: " +responsestring);
		 
		 int statusCode = response.getStatusCode();
		 System.out.println("Status code is: " +statusCode);
		 
		 Assert.assertEquals(statusCode , 200);
		 Headers allHeaders = response.headers();
		 for(Header header : allHeaders)
		 {
		 System.out.println("Header Response Key: " + header.getName() + " Value: " + header.getValue());
		 }
		 
	System.out.println("-------------------------------------");	} 
	@Test(priority=4)	 
	public void getUserDetails404() {
		int id=1001;
		RestAssured.baseURI = BaseURI;
		 RequestSpecification httpRequest = RestAssured.given();
		 Response response = httpRequest.get("user/"+id);
		 System.out.println("4.Request Endpoint url is : " +BaseURI+ "user/"+id);
		 
		 
		 String responsestring=response.getBody().asString();
		 System.out.println("Response body is: " +responsestring);
		 
		 int statusCode = response.getStatusCode();
		 System.out.println("Status code is: " +statusCode);
		 Assert.assertEquals(statusCode , 404);
		 
		 Headers allHeaders = response.headers();
		 for(Header header : allHeaders)
		 {
		 System.out.println("Header Response Key: " + header.getName() + " Value: " + header.getValue());
		 }
	}
	@Test(priority=5)
	public void getAllUsers() {

		RestAssured.baseURI = BaseURI;
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("users");
     	        System.out.println("5.Request Endpoint url is : " +BaseURI+ "users");
		int statusCode = response.getStatusCode();
		System.out.println("Status code is:" + statusCode);
		Assert.assertEquals(statusCode, 200);

		Headers allHeaders = response.headers();
		for (Header header : allHeaders) {
			System.out.println("Header Response Key: " + header.getName() + " Value: " + header.getValue());

		}

		String responsestring = response.getBody().asString();

		JsonPath js = new JsonPath(responsestring);
		int count = js.getInt("responsestring.size()");
		System.out.println("Array count is: " + count);
		Assert.assertEquals(count, 1000);

		//System.out.println("Response body is: " + responsestring);
		System.out.println("-------------------------------------");
	} 
		 
		 
	}



















	 
