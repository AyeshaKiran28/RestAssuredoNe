package org.restAssured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestOne {

	public static void main(String[] args) {
		
		
		RestAssured.baseURI="https://www.c2ta.co.in";
		
		//post
		
		RequestSpecification post = RestAssured.given().contentType(ContentType.JSON).body("{\r\n"
				+ "\"title\": \"Project Manager\" ,\r\n"
				+ "\"body\": \"selenium\",\r\n"
				+ "\"author\": \"joshi\"\r\n"
				+ "}\r\n"
				+ "");
	
		Response response1 = post.post("/api/insert.php");
		String respost = response1.asString();
		System.out.println(respost);
		System.out.println(response1.statusCode());
		

		
		//get
		
		
		String resget = post.get("/api/read.php?id=1287").asString();
		System.out.println(resget);
		
		//put
		
		RequestSpecification getreq = RestAssured.given().contentType(ContentType.JSON).body("{\r\n"
				+ "        \"id\": \"1287\",\r\n"
				+ "        \"title\": \"Project Manager\",\r\n"
				+ "        \"body\": \"Automation\",\r\n"
				+ "        \"author\": \"ayesha\"\r\n"
				+ "    }\r\n"
				+ "");
		
		String putRes = getreq.put("/api/update.php").asString();
		System.out.println(putRes);
		
		
		String id1287 = getreq.get("/api/read.php?id=1287").asString();
		System.out.println(id1287);
		
		//delete
		
		RequestSpecification delReq = RestAssured.given().contentType(ContentType.JSON).body("{\r\n"
				+ "\"id\" : \"1290\"\r\n"
				+ "}\r\n"
				+ "");
		
		String delResp = delReq.delete("/api/delete.php").asString();
		System.out.println(delResp);
		
		
	}
	
	
}
