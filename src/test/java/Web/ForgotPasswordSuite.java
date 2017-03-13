package Web;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.ForgotPassword;
import pageObject.LogIn;
import pageObject.Page;
import appModules.Base;
import appModules.LoginActions;
import appModules.PageActions;




public class ForgotPasswordSuite {
	
	 private WebDriver driver;
	 	  
	  
	 
	  @BeforeTest(alwaysRun = true)
	  public void setUp() throws Exception {
     	  Base.Gecko_Driver();
		  driver = new FirefoxDriver();
     	  Base.getBaseUrl();    	
     	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
	  
	  
	  @AfterTest(alwaysRun = true)
	  public void tearDown() throws Exception {
	    driver.quit();	 
	  }
	  
	  
	  
	  
	  // Test 1 (smoke test): verify the 'Forgot password' link is working 
	  @Test 
	  public void VerifyForgotPasswordLinkIsWorking() throws Exception {
	    driver.get(Base.getBaseUrl());
	    ForgotPassword.forgotPasswordLink(driver).click();
	    Thread.sleep(5000);
	   	
	  }
	  
	  // Test 2 (smoke test): 
	  @Test (dependsOnMethods = {"VerifyForgotPasswordLinkIsWorking"},alwaysRun = true)
	  public void VerifyResetPasswordFeature() throws Exception {
		driver.get(Base.getBaseUrl());
	    ForgotPassword.forgotPasswordLink(driver).click();
	    ForgotPassword.forgotPasswordField(driver).sendKeys("t09066292+u1@gmail.com");
	    ForgotPassword.restPasswordBtn(driver).click();	    
	   	Thread.sleep(5000);
	  }
	 

	  // Test 3: Verify mandatory field validation
	  @Test (dependsOnMethods = {"VerifyResetPasswordFeature"},alwaysRun = true)
	  public void VerifyMandatoryFieldValidation() throws Exception {
		driver.get(Base.getBaseUrl());
	    ForgotPassword.forgotPasswordLink(driver).click();
	    ForgotPassword.restPasswordBtn(driver).click();	
	    Thread.sleep(5000);
	   	
	  }
	  
	  // Test 4: Verify user receives email and given link is working
	  @Test (dependsOnMethods = {"VerifyMandatoryFieldValidation"},alwaysRun = true)
	  public void VerifyEmailReceivesAndLinkWorks () throws Exception {
		driver.get(Base.getBaseUrl());
	    ForgotPassword.forgotPasswordLink(driver).click();
	    ForgotPassword.restPasswordBtn(driver).click();	
	    Thread.sleep(5000);
	   	
	  }
	  
	 


}