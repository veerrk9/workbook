package com.api;

import static io.restassured.RestAssured.*;

import  org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;

public class SchemaValidator1 
{
	@Test
	public void test1() 
	{
		given().log().all()
			.baseUri("https://petstore.swagger.io/v2/pet/9223372036854775000")
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			
		.when()
			.get()
		.then()
			.log().all().statusCode(200)
			.body("id", Matchers.notNullValue())
			.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonschema.json"));
		
	}

}
