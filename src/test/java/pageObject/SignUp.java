package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

	public class SignUp {
		
		private static WebElement element;
	
		// SignUp Link
		public static WebElement signUpLink(WebDriver driver){
			element = driver.findElement(By.linkText("sign up!"));
			return element;
		}
		
			
		//Username field
		public static WebElement username(WebDriver driver){
			element = driver.findElement(By.id("user_email"));
			return element;
		}
		
		//Password field
		public static WebElement password(WebDriver driver){
			element = driver.findElement(By.id("user_password"));
			return element;
		}
		
		//Confirm password Field
		public static WebElement confirmPassword(WebDriver driver){
			element = driver.findElement(By.id("user_password_confirmation"));
			return element;
		}
		
		//Submit Button
		public static WebElement btnCommit(WebDriver driver){
			element = driver.findElement(By.name("commit"));
			return element;
		}
		
		
		
		
		//User Role Radio Button
		public static WebElement roleUser(WebDriver driver){
			element = driver.findElement(By.id("user_role_user"));
			return element;
		}
		
		//Author Role Radio Button
		public static WebElement roleAuthor(WebDriver driver){
			element = driver.findElement(By.id("user_role_author"));
			return element;
		}
		
	
		//Publisher Role Radio Button
		public static WebElement rolePublisher(WebDriver driver){
			element = driver.findElement(By.id("user_role_publisher"));
			return element;
		}
		
		
		
	
	}
