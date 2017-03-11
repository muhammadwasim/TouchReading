package Web;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import appModules.Base;
import appModules.BookActions;
import appModules.LoginActions;
import pageObject.Book;



public class Sample {
	
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
	  }
	  
	  */
	  
	  // Test 1 (Smoke Test): Verify update link is working
	  @Test 
	  public void VerifyCancelDeleteAction() throws Exception {
		  	driver.get(Base.baseUrl + "/?_rdr");
	    	LoginActions.login_function(driver);
		    Thread.sleep(5000);
		    BookActions.deleteSpecificBook(driver);
		    Thread.sleep(5000);
		    driver.switchTo().alert().dismiss();
	   	  
	  }
	  
	  @Test 
	  public void VerifyZCancelConfrimAction() throws Exception {
		  driver.get(Base.baseUrl + "/?_rdr");
		    Thread.sleep(5000);
		    BookActions.deleteSpecificBook(driver);
		    Thread.sleep(5000);
		    driver.switchTo().alert().accept();
	   	  
	  }




}




/******
 * 
 * 
 * 
 * 
 * 
	  // Below is the Example of a test case with POM (page object model)
	  //@Test (dependsOnMethods = {"VerifyNewTouchBooklink"},alwaysRun = true)
	  public void CreateBookWithPositiveDataX() throws Exception {
	    driver.get("https://app.touchreading.pk/touch_books/new");
	    driver.findElement(By.id("cover_image")).clear();
	    driver.findElement(By.id("cover_image")).sendKeys("C:\\Users\\Arkhitech\\Downloads\\DemoData\\images11.jpg");
	    driver.findElement(By.id("author")).clear();
	    driver.findElement(By.id("author")).sendKeys("Arkhitech");
	    driver.findElement(By.id("highlighted_text")).clear();
	    driver.findElement(By.id("highlighted_text")).sendKeys("Apple");
	    driver.findElement(By.id("title")).clear();
	    driver.findElement(By.id("title")).sendKeys("Test Book 1");
	    driver.findElement(By.id("page_image")).clear();
	    driver.findElement(By.id("page_image")).sendKeys("C:\\Users\\Arkhitech\\Downloads\\TouchReadingSample\\banner 2.jpg");
	    driver.findElement(By.id("page_text")).clear();
	    driver.findElement(By.id("page_text")).sendKeys("This is a first page for Test Book");
	    driver.findElement(By.id("touch_book_touch_pages_attributes_0_previewable")).click();
	    driver.findElement(By.name("commit")).click();
	    Thread.sleep(10000);
	    driver.findElement(By.linkText("Back")).click();
	   	  
	  }


 * 
 * 
 * 
 * 
 * 
 * 
 * ******/

