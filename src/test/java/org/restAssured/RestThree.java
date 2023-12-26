package org.restAssured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestThree {
	
	
	public static void main(String[] args) {
		
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		//post
		
		RequestSpecification postRS = RestAssured.given().contentType(ContentType.JSON).body("{\r\n"
				+ "  \"location\": {\r\n"
				+ "    \"lat\": -38.383494,\r\n"
				+ "    \"lng\": 33.427362\r\n"
				+ "  },\r\n"
				+ "  \"accuracy\": 50,\r\n"
				+ "  \"name\": \"Frontline house\",\r\n"
				+ "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
				+ "  \"address\": \"29, side layout, cohen 09\",\r\n"
				+ "  \"types\": [\r\n"
				+ "    \"shoe park\",\r\n"
				+ "    \"shop\"\r\n"
				+ "  ],\r\n"
				+ "  \"website\": \"http://google.com\",\r\n"
				+ "  \"language\": \"French-IN\"\r\n"
				+ "}\r\n"
				+ "");
		
		String postRespRS = postRS.post("/maps/api/place/add/json?key =qaclick123").prettyPrint();
		System.out.println(postRespRS);
		
		
		System.out.println("***************************");
		
		//get
		
		Response getResp = postRS.get("/maps/api/place/get/json?key=qaclick123&place_id=ff17ed7c963fd5ddcab85ff57a59deef");
		String getResRS = getResp.asString();
		System.out.println(getResRS);
		
		
		System.out.println("*****************************");
		
		//put
		
		RequestSpecification putRSR = RestAssured.given().contentType(ContentType.JSON).body("{\r\n"
				+ "\"place_id\":\"ff17ed7c963fd5ddcab85ff57a59deef\",\r\n"
				+ "\"address\":\"70 winter walk, USA\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}\r\n"
				+ "");
		
		String putRespRS = putRSR.put("/maps/api/place/update/json").prettyPrint();
		System.out.println(putRespRS);
		
	
		System.out.println("****************************");
		//delete
		
		RequestSpecification deleRS = RestAssured.given().contentType(ContentType.JSON).body("{\r\n"
				+ "    \"place_id\":\"ff17ed7c963fd5ddcab85ff57a59deef\"\r\n"
				+ "}\r\n"
				+ "");
		
		Response deletRespSS = deleRS.delete("/maps/api/place/delete/json");
		String in3 = deletRespSS.asString();
		System.out.println(in3);
		
		
		
		
		
		
		
		
		
		
		
		
		
	}	

}
