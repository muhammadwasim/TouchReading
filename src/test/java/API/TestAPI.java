package API;


import static com.jayway.restassured.RestAssured.*;
import org.testng.annotations.Test;
import apiClasses.custPostClass;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;


public class TestAPI {
			
			@Test
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
		
		@Test
		public void two(){
		       	
			custPostClass AddCust = new custPostClass();
			AddCust.setId("5");
			AddCust.setTitle("The Conservitive");
			AddCust.setAuthor("Mark Sty");
			
			Response resp	= given().						
								//param("api_user[email]",email ).
								//param("api_user[token]",token ).
								when().contentType(ContentType.JSON).body(AddCust).						
								post("http://localhost:3000/posts");
								System.out.println("reposne:" + resp);
						//System.out.println(resp.getStatusCode());
						//System.out.println(resp.asString());
						//Assert.assertEquals(resp.getStatusCode(), 200);
	
						}
		
	



	}
