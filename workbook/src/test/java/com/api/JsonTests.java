package com.api;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class JsonTests 
{
	
	@Test
	public void jsondata() 
	{
		String payload = "{\r\n"
				+ "\r\n"
				+ "\"dashboard\": {\r\n"
				+ "\r\n"
				+ "\"purchaseAmount\": 910,\r\n"
				+ "\r\n"
				+ "\"website\": \"rahulshettyacademy.com\"\r\n"
				+ "\r\n"
				+ "},\r\n"
				+ "\r\n"
				+ "\"courses\": [\r\n"
				+ "\r\n"
				+ "{\r\n"
				+ "\r\n"
				+ "\"title\": \"Selenium Python\",\r\n"
				+ "\r\n"
				+ "\"price\": 50,\r\n"
				+ "\r\n"
				+ "\"copies\": 6\r\n"
				+ "\r\n"
				+ "},\r\n"
				+ "\r\n"
				+ "{\r\n"
				+ "\r\n"
				+ "\"title\": \"Cypress\",\r\n"
				+ "\r\n"
				+ "\"price\": 40,\r\n"
				+ "\r\n"
				+ "\"copies\": 4\r\n"
				+ "\r\n"
				+ "},\r\n"
				+ "\r\n"
				+ "{\r\n"
				+ "\r\n"
				+ "\"title\": \"RPA\",\r\n"
				+ "\r\n"
				+ "\"price\": 45,\r\n"
				+ "\r\n"
				+ "\"copies\": 10\r\n"
				+ "\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "]\r\n"
				+ "\r\n"
				+ "}\r\n"
				+ "";
//		Test Cases
//		4. Print All course titles and their respective Prices
//
//		5. Print no of copies sold by RPA Course
//
//		6. Verify if Sum of all Course prices matches with Purchase Amount
		
		JsonPath path = new JsonPath(payload);
		
//		1. Print No of courses returned by API
		int numberOfCourses = path.getInt("courses.size()");
		System.out.println("No of courses returned by API is :- " + numberOfCourses);
		
//		2.Print Purchase Amount
		int purchaseAmount = path.getInt("dashboard.purchaseAmount");
		System.out.println("Purchase Amount is :- " + purchaseAmount);
		
//		3. Print Title of the first course
		String firstcourse = path.getString("courses[0].title");
		System.out.println("first course :- " + firstcourse);
	}

}
