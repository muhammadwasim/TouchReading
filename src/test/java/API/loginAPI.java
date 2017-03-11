package API;


import static com.jayway.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import apiClasses.custPostClass;
import apiClasses.loginPost;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;


public class loginAPI {
			
			//@Test
		public void One(){
		       	
			Response resp	= given().						
								//param("api_user[email]",email ).
								//param("api_user[token]",token ).
								when().
								get("http://localhost:3000/comments");
						System.out.println(resp.getStatusCode());
						System.out.println(resp.asString());
						//Assert.assertEquals(resp.getStatusCode(), 200);
	
						}
		
		//@Test
		public void two(){
		       	
			loginPost log = new loginPost();
			log.setUser_email("");
			log.setUser_password("");
			
			Response resp	= given().						
								//param("api_user[email]",email ).
								//param("api_user[token]",token ).
								when().contentType(ContentType.JSON).body(log).						
								post("http://localhost:3000/posts");
								System.out.println("reposne:" + resp);
						//System.out.println(resp.getStatusCode());
						//System.out.println(resp.asString());
						//Assert.assertEquals(resp.getStatusCode(), 200);
	
						}
		//@Test
		public void three(){
	
			Response resp	= 
					given().
				    param("api_user[email]", "saad.athar@arkhitech.com").
				    param("api_user[email]", "arkhitech").
				when().
				   post("http://www.ontrack.io/api/users/login.json");
			        System.out.println(resp.getStatusCode());
			        //Assert.assertEquals(resp.getStatusCode(), 201);

	
						}
	
		@Test
		public void four(){
	
			Response resp	=given().auth(). preemptive().basic("saad.athar@arkhitech.com", "arkhitech").
					
				when().
				    post("http://ontrack.io/api/users/login.json");
			        System.out.println(resp.getStatusCode());
			        //Assert.assertEquals(resp.getStatusCode(), 201);

	
						}
	



	}
