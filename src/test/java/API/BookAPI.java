package API;


import static com.jayway.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.jayway.restassured.response.Response;


public class BookAPI {
			
		private String email = "no-reply@arkhitech.com";
		private String token = "ewz1dt6ZnaqhF972jSd3";
		//Get all the published books
		@Test
		public void GetAllPublishedBooks(){
		       	
			Response resp	= given().						
								param("api_user[email]",email ).
								param("api_user[token]",token ).
								when().
								get("http://app.touchreading.pk/api/touch_books");
						System.out.println(resp.getStatusCode());
						System.out.println(resp.asString());
						Assert.assertEquals(resp.getStatusCode(), 200);
	
						}
	
		//Get pages in Urdu Qaeda books
		@Test
		public void GetBookPages(){
		       	
			Response resp	= given().						
								param("api_user[email]",email ).
								param("api_user[token]",token ).
								when().
								get("http://app.touchreading.pk/api/touch_books/59");
						System.out.println(resp.getStatusCode());
						System.out.println(resp.asString());
						Assert.assertEquals(resp.getStatusCode(), 200);
	
						}




	}
