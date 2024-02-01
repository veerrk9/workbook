package com.api;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;



public class PostmanBasicAuth 
{
	
	@Test(timeOut = 000)
	public void basicAuth() 
	{
		String response = given()
			.auth().basic("postman", "password")
		.when()
			.get("https://postman-echo.com/basic-auth")
		.then()
			.statusCode(200)
			.extract().response().asString();
		
		System.out.println(response);
		
	}
	
	
	@Test
	public void preemptiveAuth() 
	{
		String response = given()
			.auth().preemptive().basic("postman", "password")
		.when()
			.get("https://postman-echo.com/basic-auth")
		.then()
			.time(Matchers.lessThan(5000l))
			//.time(Matchers.lessThan(5l),TimeUnit.SECONDS)
			.extract().response().asString();
		
		System.out.println(response);
		
	}
	
	@Test
	public void digestAuth() 
	{
		String response = given()
			.auth().digest("postman", "password")
		.when()
			.get("https://postman-echo.com/basic-auth")
		.then()
			.time(Matchers.lessThan(5000l))
			//.time(Matchers.lessThan(5l),TimeUnit.SECONDS)
			.extract().response().asString();
		
		System.out.println(response);
		
	}

}
