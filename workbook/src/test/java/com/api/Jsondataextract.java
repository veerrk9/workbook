package com.api;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class Jsondataextract 
{
	@Test
	public void test() 
	{
		String response = "[\r\n"
				+ "  {\r\n"
				+ "    \"id\": 9223372036854766000,\r\n"
				+ "    \"category\": {\r\n"
				+ "      \"id\": 82212339,\r\n"
				+ "      \"name\": \"sed nulla minim\"\r\n"
				+ "    },\r\n"
				+ "    \"name\": \"doggie\",\r\n"
				+ "    \"photoUrls\": [\r\n"
				+ "      \"veniam officia\",\r\n"
				+ "      \"amet Ut Excepteur irure\"\r\n"
				+ "    ],\r\n"
				+ "    \"tags\": [\r\n"
				+ "      {\r\n"
				+ "        \"id\": -64599653,\r\n"
				+ "        \"name\": \"nisi qui\"\r\n"
				+ "      },\r\n"
				+ "      {\r\n"
				+ "        \"id\": -20636986,\r\n"
				+ "        \"name\": \"et est\"\r\n"
				+ "      }\r\n"
				+ "    ],\r\n"
				+ "    \"status\": \"pending\"\r\n"
				+ "  },\r\n"
				+ "  {\r\n"
				+ "    \"id\": 9223372036854766000,\r\n"
				+ "    \"category\": {\r\n"
				+ "      \"id\": 82641878,\r\n"
				+ "      \"name\": \"dolor dolore nisi Duis\"\r\n"
				+ "    },\r\n"
				+ "    \"name\": \"doggie\",\r\n"
				+ "    \"photoUrls\": [\r\n"
				+ "      \"officia in in enim\",\r\n"
				+ "      \"eu sed\"\r\n"
				+ "    ],\r\n"
				+ "    \"tags\": [\r\n"
				+ "      {\r\n"
				+ "        \"id\": 83694122,\r\n"
				+ "        \"name\": \"esse sit in aute anim\"\r\n"
				+ "      },\r\n"
				+ "      {\r\n"
				+ "        \"id\": -91142734,\r\n"
				+ "        \"name\": \"sit deserunt mollit ea\"\r\n"
				+ "      }\r\n"
				+ "    ],\r\n"
				+ "    \"status\": \"pending\"\r\n"
				+ "  },\r\n"
				+ "  {\r\n"
				+ "    \"id\": 9223372036854766000,\r\n"
				+ "    \"category\": {\r\n"
				+ "      \"id\": 82212339,\r\n"
				+ "      \"name\": \"sed nulla minim\"\r\n"
				+ "    },\r\n"
				+ "    \"name\": \"doggie\",\r\n"
				+ "    \"photoUrls\": [\r\n"
				+ "      \"veniam officia\",\r\n"
				+ "      \"amet Ut Excepteur irure\"\r\n"
				+ "    ],\r\n"
				+ "    \"tags\": [\r\n"
				+ "      {\r\n"
				+ "        \"id\": -64599653,\r\n"
				+ "        \"name\": \"nisi qui\"\r\n"
				+ "      },\r\n"
				+ "      {\r\n"
				+ "        \"id\": -20636986,\r\n"
				+ "        \"name\": \"et est\"\r\n"
				+ "      }\r\n"
				+ "    ],\r\n"
				+ "    \"status\": \"pending\"\r\n"
				+ "  },\r\n"
				+ "  {\r\n"
				+ "    \"id\": 9223372036854766000,\r\n"
				+ "    \"category\": {\r\n"
				+ "      \"id\": 82641878,\r\n"
				+ "      \"name\": \"dolor dolore nisi Duis\"\r\n"
				+ "    },\r\n"
				+ "    \"name\": \"doggie\",\r\n"
				+ "    \"photoUrls\": [\r\n"
				+ "      \"officia in in enim\",\r\n"
				+ "      \"eu sed\"\r\n"
				+ "    ],\r\n"
				+ "    \"tags\": [\r\n"
				+ "      {\r\n"
				+ "        \"id\": 83694122,\r\n"
				+ "        \"name\": \"esse sit in aute anim\"\r\n"
				+ "      },\r\n"
				+ "      {\r\n"
				+ "        \"id\": -91142734,\r\n"
				+ "        \"name\": \"sit deserunt mollit ea\"\r\n"
				+ "      }\r\n"
				+ "    ],\r\n"
				+ "    \"status\": \"pending\"\r\n"
				+ "  }\r\n"
				+ "]";
		
		JsonPath path = new JsonPath(response);
		String id = path.getString("[0].id");
		int count = path.getInt("id.size()");
		//int count1 = path.getInt("[0].category.tags.size()");
		
		System.out.println(count);
		
		
		for(int i=0 ; i<= count-1 ; i++)
		{
			System.out.println(path.getInt("["+i+"].tags.size()"));
		}
	}

}
