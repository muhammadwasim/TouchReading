package Web;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import appModules.Base;
import appModules.SignUpActions;
import pageObject.SignUp;

public class SignUpSuite {
	
	  private WebDriver driver;

	  
		  @BeforeTest(alwaysRun = true)
		  public void setUp() throws Exception {
			  Base.Gecko_Driver();
	     	  driver = new FirefoxDriver();
	     	  Base.getUrl();
		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  }
		  
		  
		  /*
		  @AfterTest(alwaysRun = true)
		  public void tearDown() throws Exception {
		      driver.quit();	 
		  }*/
		  
		  
		  // Test 1 (smoke test): Verify SignUp link is working
		  @Test
		  public void VerifySignUpLink() throws Exception {
	        driver.get(Base.baseUrl + "/?_rdr");
	        SignUp.signUpLink(driver).click();
		   	  
		  }
		  
	  
		  //Test 2: Verify user with user_role can be created
		  @Test (dependsOnMethods = { "VerifySignUpLink" },alwaysRun = true)
		  public void CreateUserAccount() throws Exception {
		    driver.get(Base.baseUrl + "/?_rdr");			
		    SignUp.signUpLink(driver).click();		   
		    SignUp.username(driver).clear();
		    SignUp.username(driver).sendKeys("t09066292+u1@gmail.com");
		    Thread.sleep(1000);
		    SignUp.password(driver).clear();
		    SignUp.password(driver).sendKeys("arkhitech");
		    Thread.sleep(1000);
		    SignUp.confirmPassword(driver).click();
		    SignUp.confirmPassword(driver).sendKeys("arkhitech");
		    Thread.sleep(1000);
		    SignUp.roleUser(driver).click();
		    SignUp.btnCommit(driver).click();	
		   	  
		  }
		  
		  
		  //Test 3: Verify user with Author_role can be created
		  @Test (dependsOnMethods = { "VerifySignUpLink" },alwaysRun = true)
		  public void CreateAuthorAccount() throws Exception {
		    driver.get(Base.baseUrl + "/?_rdr");
		    SignUp.signUpLink(driver).click();		   
		    SignUp.username(driver).clear();
		    SignUp.username(driver).sendKeys("t09066292+a1@gmail.com");
		    Thread.sleep(1000);
		    SignUp.password(driver).clear();
		    SignUp.password(driver).sendKeys("arkhitech");
		    Thread.sleep(1000);
		    SignUp.confirmPassword(driver).click();
		    SignUp.confirmPassword(driver).sendKeys("arkhitech");
		    Thread.sleep(1000);
		    SignUp.roleAuthor(driver).click();
		    SignUp.btnCommit(driver).click();	
		   	  
		  }
		  
		  
		  
		  //Test 4: Verify user with publisher_role can be created
		  @Test (dependsOnMethods = { "VerifySignUpLink" },alwaysRun = true)
		  public void CreatePublisherAccount() throws Exception {
		    driver.get(Base.baseUrl + "/?_rdr");
		    SignUp.signUpLink(driver).click();		   
		    SignUp.username(driver).clear();
		    SignUp.username(driver).sendKeys("t09066292+p1@gmail.com");
		    Thread.sleep(1000);
		    SignUp.password(driver).clear();
		    SignUp.password(driver).sendKeys("arkhitech");
		    Thread.sleep(1000);
		    SignUp.confirmPassword(driver).click();
		    SignUp.confirmPassword(driver).sendKeys("arkhitech");
		    Thread.sleep(1000);
		    SignUp.rolePublisher(driver).click();
		    SignUp.btnCommit(driver).click();	
		   	  
		  }
		  
		  
		  
		  //Test 5: Verify mandatory field validation
		  @Test (dependsOnMethods = { "VerifySignUpLink" },alwaysRun = true)
		  public void CreateSignUpWithEmptyFields() throws Exception {
			driver.get(Base.baseUrl + "/?_rdr");
			SignUp.btnCommit(driver).click();
	
	   	  }
	  
		  
		  //Test 6: Verify email field cannot be blank
		  @Test (dependsOnMethods = { "CreateSignUpWithEmptyFields" },alwaysRun = true)
		  public void VerifyEmailFieldCannotBeEmpty() throws Exception {
		    driver.get(Base.baseUrl + "/?_rdr");
		    SignUp.signUpLink(driver).click();		   		    
		    SignUp.password(driver).clear();
		    SignUp.password(driver).sendKeys("arkhitech");
		    Thread.sleep(1000);
		    SignUp.confirmPassword(driver).click();
		    SignUp.confirmPassword(driver).sendKeys("arkhitech");
		    Thread.sleep(1000);
		    SignUp.rolePublisher(driver).click();
		    SignUp.btnCommit(driver).click();
		    //SignUpActions.emailFieldValidation();
			WebElement email = driver.findElement(By.xpath("//*[@id=\"new_user\"]/div[1]/div/span"));
			String strng1 = email.getText();
			Assert.assertEquals("can't be blank", strng1);
		   	  
		  }
		  
		  
		  
		  //Test 7: Verify password filed cannot be empty
		  @Test (dependsOnMethods = { "CreateSignUpWithEmptyFields" },alwaysRun = true)
		  public void VerifyPasswordFieldCannotBeEmpty() throws Exception {
		    driver.get(Base.baseUrl + "/?_rdr");
		    SignUp.signUpLink(driver).click();		   
		    SignUp.username(driver).clear();
		    SignUp.username(driver).sendKeys("t09066292+p1@gmail.com");
		    Thread.sleep(1000);
		    SignUp.confirmPassword(driver).click();
		    SignUp.confirmPassword(driver).sendKeys("arkhitech");
		    Thread.sleep(1000);
		    SignUp.rolePublisher(driver).click();
		    SignUp.btnCommit(driver).click();
		    //SignUpActions.passwordFieldValidation();
			WebElement password = driver.findElement(By.xpath("//*[@id=\"new_user\"]/div[2]/div/span"));
			String strng2 = password.getText();
			Assert.assertEquals("can't be blank", strng2);
		   	  
		  }
		  
		  
		  
		  //Test 8: Verify password format
		  @Test (dependsOnMethods = { "CreateSignUpWithEmptyFields" },alwaysRun = true)
		  public void VerifyPasswordCharacterLength() throws Exception {
		    driver.get(Base.baseUrl + "/?_rdr");
		    SignUp.signUpLink(driver).click();		   
		    SignUp.username(driver).clear();
		    SignUp.username(driver).sendKeys("t09066292+p1@gmail.com");
		    Thread.sleep(1000);
		    SignUp.password(driver).clear();
		    SignUp.password(driver).sendKeys("1234");
		    Thread.sleep(1000);
		    SignUp.confirmPassword(driver).click();
		    SignUp.confirmPassword(driver).sendKeys("ark");
		    Thread.sleep(1000);
		    SignUp.rolePublisher(driver).click();
		    SignUp.btnCommit(driver).click();
			WebElement passwordLength = driver.findElement(By.xpath("//*[@id=\"new_user\"]/div[2]/div/span"));
			String strng3 = passwordLength.getText();
			Assert.assertEquals("is too short (minimum is 8 characters)", strng3);
		   	  
		  }
		  
		  
		  
		  //Test 9: Verify confirm password field validation is working
		  @Test (dependsOnMethods = { "VerifySignUpLink" },alwaysRun = true)
		  public void VerifyConfirmPasswordFieldValidation() throws Exception {
		    driver.get(Base.baseUrl + "/?_rdr");
		    SignUp.signUpLink(driver).click();		   
		    SignUp.username(driver).clear();
		    SignUp.username(driver).sendKeys("t09066292+p1@gmail.com");
		    Thread.sleep(1000);
		    SignUp.password(driver).clear();
		    SignUp.password(driver).sendKeys("1234");
		    Thread.sleep(1000);
		    SignUp.confirmPassword(driver).click();
		    SignUp.confirmPassword(driver).sendKeys("ark");
		    Thread.sleep(1000);
		    SignUp.rolePublisher(driver).click();
		    SignUp.btnCommit(driver).click();
			WebElement confirmPassword = driver.findElement(By.xpath("//*[@id=\"new_user\"]/div[3]/div/span"));
			String strng4 = confirmPassword.getText();
			Assert.assertEquals("doesn't match Password", strng4);
		
		   	  
		  }

		  
		  
         
}