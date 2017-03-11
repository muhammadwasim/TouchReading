package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

	public class ForgotPassword {

		private static WebElement element;

	
		// forgot password link element
		public static WebElement forgotPasswordLink(WebDriver driver){
			element = driver.findElement(By.linkText("Forgot password?"));
			//element = driver.findElement(By.xpath("//*[@id=\"new_user\"]/div[3]/div[2]/a"));
			return element;
		}
		
		
		
		// forgot password text password
		public static WebElement forgotPasswordField(WebDriver driver){
			element = driver.findElement(By.id("user_email"));
			return element;
		}

		// Rest Password button
		public static WebElement restPasswordBtn(WebDriver driver){
			element = driver.findElement(By.name("commit"));
			return element;
		}

	}
