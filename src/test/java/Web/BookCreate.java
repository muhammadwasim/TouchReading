package Web;



import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import appModules.Base;
import appModules.LoginActions;
import pageObject.Book;



public class BookCreate {
	
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
	  
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	  //
	  // CREATE BOOK TEST CASES
	  //
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  
	  
	  // Test 1 (Smoke Test): Verify the link is working
	  @Test 
	  public void VerifyNewTouchBooklink() throws Exception {
		  	driver.get(Base.getBaseUrl());
	    	LoginActions.login_function(driver);
		    Thread.sleep(10000);
		    driver.findElement(By.linkText("New Touch book")).click();
	   	  
	  }

	
	  
	  // Test 2 (Smoke Test):Verify Create book feature is working
	  @Test (dependsOnMethods = {"VerifyNewTouchBooklink"},alwaysRun = true)
	  public void CreateBookPositiveTest() throws Exception {
		  	driver.get(Base.getNewBookUrl());
		    Book.cover_image(driver).clear();		    
		    String image1 = System.getProperty("user.dir") + "\\src\\test\\resources\\TestData\\images\\images11.jpg";
		    Book.cover_image(driver).sendKeys(image1);
		    new Select (Book.Category(driver)).selectByVisibleText("Kids");
		    Book.title(driver).clear();
		    Book.title(driver).sendKeys("Science Book");
		    Book.author(driver).clear();
		    Book.author(driver).sendKeys("Arkhitech");
		    Book.highlighted_text(driver).clear();
		    Book.highlighted_text(driver).sendKeys("Pakistan");
		    Book.create_book(driver).click();	
		    Thread.sleep(10000);
	 
	  }
	  
	  
	  //Test 3: Create Book with least field filled
	  @Test (dependsOnMethods = {"VerifyNewTouchBooklink"},alwaysRun = true)
	  public void CreateBookWithLeasteFields() throws Exception {
		    driver.get(Base.getNewBookUrl());
		    Book.cover_image(driver).clear();		    
		    String image1 = System.getProperty("user.dir") + "\\src\\test\\resources\\TestData\\images\\images11.jpg";
		    Book.cover_image(driver).sendKeys(image1);
		    new Select (Book.Category(driver)).selectByVisibleText("Kids");
		    Book.title(driver).clear();
		    Book.title(driver).sendKeys("Less Data Book");
		    Book.author(driver).clear();
		    Book.author(driver).sendKeys("Arkhitech");
		    Book.highlighted_text(driver).clear();
		    Book.highlighted_text(driver).sendKeys("Pakistan");
		    Book.create_book(driver).click();	
		    Thread.sleep(10000);
	 
	  }

	  
	  
	  //Test 4: Create book with all the fields.
	  @Test (dependsOnMethods = {"VerifyNewTouchBooklink"},alwaysRun = true)
	  public void CreateBookWithAllFields() throws Exception {
		    driver.get(Base.getNewBookUrl());
		    Book.cover_image(driver).clear();
		    String image1 = System.getProperty("user.dir") + "\\src\\test\\resources\\TestData\\images\\images11.jpg";
		    Book.cover_image(driver).sendKeys(image1);
		    new Select (Book.Category(driver)).selectByVisibleText("Authors");
		    Book.title(driver).clear();
		    Book.title(driver).sendKeys("All Types");
		    Book.author(driver).clear();
		    Book.author(driver).sendKeys("Arkhitech");
		    Book.highlighted_text(driver).clear();
		    Book.highlighted_text(driver).sendKeys("Pakistan");
		    Book.book_flip(driver).click();
		    Book.book_bg_image(driver).clear();
		    String image2 = System.getProperty("user.dir") + "\\src\\test\\resources\\TestData\\images\\logo2.png";
		    Book.cover_image(driver).sendKeys(image2);
		    Book.book_bg_music(driver).clear();
		    String audio1 = System.getProperty("user.dir") + "\\src\\test\\resources\\TestData\\audio\\2.mp3";
		    Book.book_bg_music(driver).sendKeys(audio1);
		    Book.create_book(driver).click();
		    Thread.sleep(10000);
	    	  
	  }
	  

	  
	  //Test 4: Create book without any data. All the fields should empty
	  @Test (dependsOnMethods = {"VerifyNewTouchBooklink"},alwaysRun = true)
	  public void CreateBookWithoutData() throws Exception {
		    driver.get(Base.getNewBookUrl());
		    Book.create_book(driver).click();
	   
	   }
	  
	  
	  	  
	  //Test 5: Verify Book title is mandatory filed
	  @Test (dependsOnMethods = {"CreateBookWithAllFields"},alwaysRun = true)
	  public void CheckBookTitleIsMandatory() throws Exception {
		    driver.get(Base.getNewBookUrl());
		    Book.cover_image(driver).clear();
		    String image1 = System.getProperty("user.dir") + "\\src\\test\\resources\\TestData\\images\\banner4.png";
		    Book.cover_image(driver).sendKeys(image1);
		    new Select (Book.Category(driver)).selectByVisibleText("Authors");
		    Book.author(driver).clear();
		    Book.author(driver).sendKeys("Arkhitech");
		    Book.highlighted_text(driver).clear();
		    Book.highlighted_text(driver).sendKeys("Pakistan");
		    Book.book_flip(driver).click();
		    Book.book_bg_image(driver).clear();
		    String image2 = System.getProperty("user.dir") + "\\src\\test\\resources\\TestData\\images\\logo2.png";
		    Book.cover_image(driver).sendKeys(image2);
		    Book.book_bg_music(driver).clear();
		    String audio1 = System.getProperty("user.dir") + "\\src\\test\\resources\\TestData\\audio\\2.mp3";
		    Book.book_bg_music(driver).sendKeys(audio1);
		    Book.create_book(driver).click();
	    	  
	  }

	  
	  
	  //Test 6: Verify Book cover image is a mandatory filed
	  @Test (dependsOnMethods = {"CreateBookWithAllFields"},alwaysRun = true)
	  public void CheckCoverImageIsMandatory() throws Exception {
		  	driver.get(Base.getNewBookUrl());
		    new Select (Book.Category(driver)).selectByVisibleText("Authors");
		    Book.author(driver).clear();
		    Book.author(driver).sendKeys("Arkhitech");
		    Book.highlighted_text(driver).clear();
		    Book.highlighted_text(driver).sendKeys("Pakistan");
		    Book.book_flip(driver).click();
		    Book.book_bg_image(driver).clear();
		    String image2 = System.getProperty("user.dir") + "\\src\\test\\resources\\TestData\\images\\logo2.png";
		    Book.cover_image(driver).sendKeys(image2);
		    Book.book_bg_music(driver).clear();
		    String audio1 = System.getProperty("user.dir") + "\\src\\test\\resources\\TestData\\audio\\2.mp3";
		    Book.book_bg_music(driver).sendKeys(audio1);
		    Book.create_book(driver).click();
	    	  
	  }

	  
	  
	  //Test 7: Verify Book cover image is a mandatory filed
	  @Test (dependsOnMethods = {"CreateBookWithAllFields"},alwaysRun = true)
	  public void CheckHighlightedTextIsMandatory() throws Exception {
		    driver.get(Base.getNewBookUrl());
		    Book.cover_image(driver).clear();
		    String image1 = System.getProperty("user.dir") + "\\src\\test\\resources\\TestData\\images\\banner4.png";
		    Book.cover_image(driver).sendKeys(image1);
		    new Select (Book.Category(driver)).selectByVisibleText("Authors");
		    Book.author(driver).clear();
		    Book.author(driver).sendKeys("Arkhitech");
		    Book.book_flip(driver).click();
		    Book.book_bg_image(driver).clear();
		    String image2 = System.getProperty("user.dir") + "\\src\\test\\resources\\TestData\\images\\logo2.png";
		    Book.cover_image(driver).sendKeys(image2);
		    Book.book_bg_music(driver).clear();
		    String audio1 = System.getProperty("user.dir") + "\\src\\test\\resources\\TestData\\audio\\2.mp3";
		    Book.book_bg_music(driver).sendKeys(audio1);
		    Book.create_book(driver).click();
		    	  
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

