package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

	public class LogIn {
		
		private static WebElement element;
		
		//SingIn link Path
		public static WebElement SigninLink(WebDriver driver){
			element = driver.findElement(By.linkText("Sign In"));
			return element;
		}
		
		
		//Username Field Path
		public static WebElement username(WebDriver driver){
			element = driver.findElement(By.id("user_email"));
			return element;
		}
		
		
		//Password Field Path
		public static WebElement password(WebDriver driver){
			element = driver.findElement(By.id("user_password"));
			return element;
		}
		
		
		//Commit button Path
		public static WebElement btnCommit(WebDriver driver){
			element = driver.findElement(By.name("commit"));
			return element;
		}
		
		
		//remember me button Path
		public static WebElement rememberMeCheck(WebDriver driver){
			element = driver.findElement(By.id("user_remember_me"));
			return element;
		}
	
		
		//Sign Up! link Path
		public static WebElement DontHaveAccount(WebDriver driver){
			element = driver.findElement(By.linkText("Don’t have an account? Sign Up!"));
			return element;
			
		}
	
	
	}
