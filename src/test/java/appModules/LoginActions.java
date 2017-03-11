package appModules;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import pageObject.LogIn;



public class LoginActions {
	
	
	public static void login_function (WebDriver driver) throws InterruptedException{
		
		    //LogIn.SigninLink(driver).click();
		    LogIn.username(driver).clear();
		    LogIn.username(driver).sendKeys("t09066292@gmail.com");
		    LogIn.password(driver).clear();
		    LogIn.password(driver).sendKeys("arkhitech");
		    LogIn.btnCommit(driver).click();
		    Thread.sleep(3000);
		}
		
		
		
		
		
		
	
}
