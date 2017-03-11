package Web;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.Dashboard;
import appModules.DashboardActions;
import appModules.LoginActions;


public class SearchSuite {
	
	  private WebDriver driver;
	  private String baseUrl;	  	  
	  
	  @BeforeTest(alwaysRun = true)
	  
	  public void setUp() throws Exception {
		  System.setProperty("webdriver.gecko.driver","E:\\LunaWorkSpace\\Selenium\\lib\\geckodriver.exe");
		  driver = new FirefoxDriver();
	      baseUrl = "https://app.touchreading.pk/";
	      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	      driver.get(baseUrl + "/?_rdr");
   	  }
	  	  
	  @AfterTest(alwaysRun = true)
	  public void tearDown() throws Exception {
	    driver.quit();	 
	  }
	  
	  @Test 
	  public void VerifySearchWithFullName() throws Exception {
	    //driver.get(baseUrl + "/?_rdr");
	    LoginActions.login_function(driver);
	    Thread.sleep(2000);
	    DashboardActions.searchAction(driver);
	    DashboardActions.matchSearchResult(driver);
	   	 
	  }
	  
	  
	  @Test (dependsOnMethods = {"VerifySearchWithFullName"},alwaysRun = true)
	  public void VerifySearchWithFirstName() throws Exception {
		driver.get(baseUrl + "/?_rdr");
		Dashboard.searchTextField(driver).sendKeys("Invisible");
	    Thread.sleep(2000);
	    Dashboard.searchTextField(driver).sendKeys(Keys.ENTER);	
	    DashboardActions.matchSearchResult(driver);
	   	  
	  }
	  
	  
	  @Test (dependsOnMethods = {"VerifySearchWithFirstName"},alwaysRun = true)
	  public void VerifySearchWithLastName() throws Exception {
		driver.get(baseUrl + "/?_rdr");
	    Dashboard.searchTextField(driver).sendKeys("Aligator");
	    Thread.sleep(2000);
	    Dashboard.searchTextField(driver).sendKeys(Keys.ENTER);
	    DashboardActions.matchSearchResult(driver);
	    	    
	   }
	  
	  @Test (dependsOnMethods = {"VerifySearchWithLastName"},alwaysRun = true)
	  public void CheckSearchResultWithEmptyField() throws Exception {
		driver.get(baseUrl + "/?_rdr");	
	    driver.findElement(By.id("query")).sendKeys("");
	    Thread.sleep(2000);
	    driver.findElement(By.id("query")).sendKeys(Keys.ENTER);
	    
	    	    
	   	  }
	  @Test (dependsOnMethods = {"VerifySearchWithFirstName"},alwaysRun = true)
	  public void VerifySearchWithWrongName() throws Exception {
		driver.get(baseUrl + "/?_rdr");
	    Dashboard.searchTextField(driver).sendKeys("I885458458488");
	    Thread.sleep(2000);
	    Dashboard.searchTextField(driver).sendKeys(Keys.ENTER);
	    Thread.sleep(2000);
	    WebElement element2 = driver.findElement(By.xpath("/html/body/div[3]/div/div/h3"));
	    String strng2 = element2.getText();
	    Assert.assertEquals("No record Found", strng2);
	    	    
	   	  }	

}