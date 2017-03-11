package Web;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import appModules.LoginActions;
import appModules.PageActions;



public class PageUpdateAndDelete {
	
	  private WebDriver driver;
	  private String baseUrl;	  
	  
	  @BeforeTest(alwaysRun = true)
	  public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver","E:\\LunaWorkSpace\\Selenium\\lib\\geckodriver.exe");
	    driver = new FirefoxDriver();
	    baseUrl = "https://app.touchreading.pk/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
	  
	  @AfterTest(alwaysRun = true)
	  public void tearDown() throws Exception {
	    driver.quit();	 
	  }
	  

	  @Test 
	  public void VerifyTouchPageEditAction() throws Exception {
	    driver.get(baseUrl + "/?_rdr");
	    LoginActions.login_function(driver);
	    driver.get(baseUrl + "/touch_books/chinese-culture");
	    PageActions.EditAction(driver);

	   	  }
	  
	  
	  @Test (dependsOnMethods = { "VerifyTouchPageEditAction" },alwaysRun = true)
	  public void UpdatePagePreview() throws Exception {
		    driver.get(baseUrl + "/touch_books/chinese-culture");
		    PageActions.EditAction(driver);
		    driver.findElement(By.id("touch_page_previewable")).click();
            driver.findElement(By.name("commit")).click();
	         
	     	}
	  
	  
	  @Test (dependsOnMethods = { "UpdatePagePreview" },alwaysRun = true)
	  public void UpdatePageImageAndPageText() throws Exception {
		    driver.get(baseUrl + "/touch_books/chinese-culture");
		    PageActions.EditAction(driver);
            driver.findElement(By.id("page_image")).sendKeys("C:\\Users\\Arkhitech\\Downloads\\TouchReadingSample\\Story1\\update.png");
            driver.findElement(By.id("page_text")).clear();
            driver.findElement(By.id("page_text")).sendKeys("Updated");
            driver.findElement(By.id("touch_page_previewable")).click();
            driver.findElement(By.name("commit")).click();
	         
	     	}
	  @Test (dependsOnMethods = { "UpdatePageImageAndPageText" },alwaysRun = true)
	  public void UpdatePageAudio() throws Exception {
		    driver.get(baseUrl + "/touch_books/chinese-culture");
		    PageActions.EditAction2(driver);

	     	}
	  @Test (dependsOnMethods = { "UpdatePageAudio" },alwaysRun = true)
	  public void VerifyValidationsOnEditPage() throws Exception {
		    driver.get(baseUrl + "/touch_books/chinese-culture");
		    PageActions.EditAction2(driver);
	        driver.findElement(By.id("page_text")).clear();
            driver.findElement(By.name("commit")).click();
            
	         
	     	}
	  @Test (dependsOnMethods = { "VerifyValidationsOnEditPage" },alwaysRun = true)
	  public void VerifyPageVideo() throws Exception {
		    driver.get(baseUrl + "/touch_books/chinese-culture");
		    PageActions.EditAction2(driver);
	        driver.findElement(By.id("page_text")).clear();
            driver.findElement(By.name("commit")).click();
            
	         
	     	}
	  	  

}