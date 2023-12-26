package org.restAssured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestTwo {
	
	public static void main(String[] args) {
		
		
		RestAssured.baseURI="https://reqres.in";
		
		//post
		
		  RequestSpecification reqresPost = RestAssured.given().contentType(ContentType.JSON).body("{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}\r\n"
				+ "");
		  	   
		   System.out.println(reqresPost.post("/api/users").prettyPrint());
		
		
		//get
		   
		   String getReqres = reqresPost.get("/api/usersapi/2").asString();
		   System.out.println(getReqres);
		   
		   
		//put
		   
		   RequestSpecification putReqres = RestAssured.given().contentType(ContentType.JSON).body("{\r\n"
		   		+ "    \"name\": \"morpheus\",\r\n"
		   		+ "    \"job\": \"abc resident\"\r\n"
		   		+ "}\r\n"
		   		+ "");
		   
		   System.out.println(putReqres.put("/api/usersapi/2").asString());
		 
		   
		  //delete
		   
		   RequestSpecification delReqres = RestAssured.given().contentType(ContentType.JSON).body("{\r\n"
		   		+ "\"id\" : \"\"\r\n"
		   		+ "}\r\n"
		   		+ "");
		   
		   Response delResP = delReqres.delete("/api/users/2");
		   String striRes = delResP.asString();
		   System.out.println(striRes);
		   System.out.println(delResP.statusCode());
		   
	}

}
