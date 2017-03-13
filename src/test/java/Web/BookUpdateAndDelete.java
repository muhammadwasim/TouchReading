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



public class BookUpdateAndDelete {
	
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
	  // EDIT BOOK TEST CASES
	  //
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	  

	  
	  // Test 1 (Smoke Test): Verify update link is working
	  @Test 
	  public void VerifyBookEditLink() throws Exception {
		  	driver.get(Base.getBaseUrl());
	    	LoginActions.login_function(driver);
		    Thread.sleep(5000);
		    BookActions.editSpecificBook(driver);
	   	  
	  }

	
	  
	  // Test 2 (Smoke Test):Verify update feature is working
	  @Test (dependsOnMethods = {"VerifyBookEditLink"},alwaysRun = true)
	  public void UpdateBookPositiveTest() throws Exception {
		  	driver.get(Base.getDashboardUrl());
		  	BookActions.editSpecificBook(driver);
		    //Book.cover_image(driver).clear();		    
		    //String image1 = System.getProperty("user.dir") + "\\src\\test\\resources\\TestData\\images\\images11.jpg";
		    //Book.cover_image(driver).sendKeys(image1);
		    new Select (Book.Category(driver)).selectByVisibleText("Kids");
		    Book.title(driver).clear();
		    Book.title(driver).sendKeys("Science Book");
		    Book.author(driver).clear();
		    Book.author(driver).sendKeys("Arkhitech");
		    Book.highlighted_text(driver).clear();
		    Book.highlighted_text(driver).sendKeys("Pakistan");
		    Book.updateBook(driver).click();	
		    Thread.sleep(5000);
	 
	  }

	  
	 
	  //Test 3: Update Entire Book
	  @Test (dependsOnMethods = {"UpdateBookPositiveTest"},alwaysRun = true)
	  public void UpdateEntireBook() throws Exception {
		    driver.get(Base.getDashboardUrl());
		    BookActions.openSpecificBook(driver);
		    Thread.sleep(2000);
			Book.editBtn(driver).click();
			Thread.sleep(2000);
			new Select (Book.Category(driver)).selectByVisibleText("Kids");
		  	Thread.sleep(2000);
		  	Book.title(driver).clear();
		    Book.title(driver).sendKeys("ScienceBook-");
		    Thread.sleep(2000);
		    Book.author(driver).clear();
		    Book.author(driver).sendKeys("Arkhitech-");
		    Thread.sleep(2000);
		    Book.highlighted_text(driver).clear();
		    Book.highlighted_text(driver).sendKeys("Pakistan-");
		    Book.book_flip(driver).click();
		    Book.book_bg_image(driver).clear();
		    Thread.sleep(2000);
		    Book.cover_image(driver).clear();
		    String image1 = System.getProperty("user.dir") + "\\src\\test\\resources\\TestData\\images\\images11.jpg";
		    Book.cover_image(driver).sendKeys(image1);
		    Thread.sleep(2000);
		    String image2 = System.getProperty("user.dir") + "\\src\\test\\resources\\TestData\\images\\logo2.png";
		    Book.cover_image(driver).sendKeys(image2);
		    Thread.sleep(2000);
		    Book.book_bg_music(driver).clear();
		    String audio1 = System.getProperty("user.dir") + "\\src\\test\\resources\\TestData\\audio\\2.mp3";
		    Book.book_bg_music(driver).sendKeys(audio1);
		    Book.updateBook(driver).click();
		    Thread.sleep(5000);
	    	  
	  }
	  

	  
	  //Test 4: Update book with any data. All the fields should empty
	  @Test (dependsOnMethods = {"UpdateEntireBook"},alwaysRun = true)
	  public void UpdateBookWithAllFieldEmpty() throws Exception {
		    driver.get(Base.getDashboardUrl());
		    BookActions.openSpecificBook(driver);
		    Thread.sleep(2000);
			Book.editBtn(driver).click();
			Thread.sleep(2000);
		    Book.cover_image(driver).clear();
		    Book.title(driver).clear();
		    Book.author(driver).clear();
		    Book.highlighted_text(driver).clear();
		    Book.book_flip(driver).click();
		    Book.book_bg_image(driver).clear();
		    Book.updateBook(driver).click();
		    Thread.sleep(5000);

	   
	   }
	  
	  
	  
	  //Test 5: Verify book title is a mandatory field on updating book
	  @Test (dependsOnMethods = {"UpdateBookWithAllFieldEmpty"},alwaysRun = true)
	  public void VerifyBookTitleIsMandatory() throws Exception {
		    Book.title(driver).clear();
		    Book.updateBook(driver).click();
		    Thread.sleep(5000);
	  }

	  
	  
	  //Test 6: Verify cover image is a mandatory filed on updating book 
	  @Test (dependsOnMethods = {"UpdateBookWithAllFieldEmpty"},alwaysRun = true)
	  public void VerifyCoverImageIsMandatory() throws Exception {
		    Book.cover_image(driver).clear();
		    Book.title(driver).clear();
		    Book.author(driver).clear();
		    Book.highlighted_text(driver).clear();
		    Book.book_flip(driver).click();
		    Book.book_bg_image(driver).clear();
		    Book.updateBook(driver).click();
		    Thread.sleep(5000);
	    	  
	  }

	  
	  
	  //Test 7: Verify highlighted text is a mandatory field on updating book
	  @Test (dependsOnMethods = {"UpdateBookWithAllFieldEmpty"},alwaysRun = true)
	  public void VerifyHighlightedTextIsMandatory() throws Exception {
		    Book.cover_image(driver).clear();
		    Book.title(driver).clear();
		    Book.author(driver).clear();
		    Book.highlighted_text(driver).clear();
		    Book.book_flip(driver).click();
		    Book.book_bg_image(driver).clear();
		    Book.updateBook(driver).click();
		    Thread.sleep(5000);
	  }
	 

	  
	  
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	  //
	  // DELETE BOOK TEST CASES
	  //
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	 

	  
	  
	  @Test (dependsOnMethods = {"VerifyHighlightedTextIsMandatory"},alwaysRun = true)
	  public void VerifyCancelDeleteAction() throws Exception {
		  	driver.get(Base.getBaseUrl());
		    Thread.sleep(5000);
		    BookActions.deleteSpecificBook(driver);
		    Thread.sleep(5000);
		    driver.switchTo().alert().dismiss();
	   	  
	  }
	  
	  
	  
	  
	  
	  @Test (dependsOnMethods = {"VerifyCancelDeleteAction"},alwaysRun = true)
	  public void VerifyConfrimDeleteAction() throws Exception {
		  	driver.get(Base.getBaseUrl());
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

