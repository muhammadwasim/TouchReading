package Web;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import appModules.Base;
import appModules.LoginActions;
import pageObject.LogIn;

public class LoginSuite {
	
	  private WebDriver driver;
	  	  
	 
	  
	  @BeforeTest(alwaysRun = true)
	  public void setUp() throws Exception {
		  Base.Gecko_Driver();
     	  driver = new FirefoxDriver();
     	  Base.getUrl();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
	  
	  @AfterTest(alwaysRun = true)
	  public void tearDown() throws Exception {
	    driver.quit();	 
	  }
	  
	  @Test
	  public void VerifySignInLink() throws Exception {
	    driver.get(Base.baseUrl + "/?_rdr");
	    //LogIn.SigninLink(driver).click();
	   	  }
	  
	  @Test (dependsOnMethods = {"VerifySignInLink"},alwaysRun = true)
	  public void VerifyLoginWithEmptyFields() throws Exception {
	    driver.get(Base.baseUrl + "/?_rdr");
	    //LogIn.SigninLink(driver).click();
	    LogIn.btnCommit(driver).click();
	   	  }
	  
	  @Test (dependsOnMethods = {"VerifyLoginWithEmptyFields"},alwaysRun = true)
	  public void VerifyLoginWithIncorrectCredentials() throws Exception {
	    driver.get(Base.baseUrl + "/?_rdr");
	    //driver.findElement(By.linkText("Sign In")).click();
	    LogIn.username(driver).clear();
	    LogIn.username(driver).sendKeys("Apple");
	    LogIn.password(driver).clear();
	    LogIn.password(driver).sendKeys("Arkhitech");
	    LogIn.btnCommit(driver).click();
	   	  }
	  
	  @Test (dependsOnMethods = {"VerifyLoginWithEmptyFields"},alwaysRun = true)
	  public void VerifyLoginWithoutUsername() throws Exception {
	    driver.get(Base.baseUrl + "/?_rdr");
	    //LogIn.SigninLink(driver).click();
	    LogIn.password(driver).sendKeys("Arkhitech");
	    LogIn.btnCommit(driver).click();
	   	  }

	  
	  @Test (dependsOnMethods = {"VerifyLoginWithoutUsername"},alwaysRun = true)
	  public void VerifyLoginWithoutPassword() throws Exception {
	    driver.get(Base.baseUrl + "/?_rdr");
	    //LogIn.SigninLink(driver).click();
	    LogIn.username(driver).clear();
	    LogIn.username(driver).sendKeys("t09066292@gmail.com");
	    LogIn.btnCommit(driver).click();
	   	  }
	  
	  @Test (dependsOnMethods = { "VerifyLoginWithoutPassword" })
	  public void VerifyLinkDoNotHaveAnAccount() throws Exception {
	    driver.get(Base.baseUrl + "/?_rdr");
	    //LogIn.SigninLink(driver).click();
	    LogIn.DontHaveAccount(driver).click();
	    
	   	  }
	  
	  @Test (dependsOnMethods = { "VerifyLinkDoNotHaveAnAccount" },alwaysRun = true)
	  public void VerifyGooglePlus() throws Exception {
	    driver.get(Base.baseUrl + "/?_rdr");
	    //LogIn.SigninLink(driver).click();
	    driver.findElement(By.xpath("/html/body/div[2]/div/div/div[3]/div[4]/a/img")).click();
	    Thread.sleep(3000);
	   	  }
	  
	  @Test (dependsOnMethods = { "VerifyGooglePlus" }, alwaysRun = true)
	  public void VerifyFaceBookButton() throws Exception {
	    driver.get(Base.baseUrl + "/?_rdr");
	    //LogIn.SigninLink(driver).click();
	    driver.findElement(By.xpath("/html/body/div[2]/div/div/div[3]/div[3]/a/img")).click();
	    Thread.sleep(3000);
	    
	   	  }
	  @Test (dependsOnMethods = { "VerifyGooglePlus" }, alwaysRun = true)
	  public void VerifyLoginFeature() throws Exception {
		    driver.get(Base.baseUrl + "/?_rdr");
		    LoginActions.login_function(driver);
		    

	   	  }

}