package Web;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObject.Book;
import appModules.Base;
import appModules.LoginActions;

public class BookView {
	
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

	  
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	  //
	  // View BOOK TEST CASES
	  //
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



	  // Test 1 (smoke): Verify that the link is working
	  @Test 
	  public void VerifyBookListViewPageIsAvailable() throws Exception {
		    driver.get(Base.baseUrl + "/?_rdr");
	    	LoginActions.login_function(driver);
	    
	   	  }

	  
	  
	  
	  // Test 2: Verify the user is able to open the book using Book Title link
	  @Test (dependsOnMethods = {"VerifyBookListViewPageIsAvailable"}, alwaysRun = true)
	  public void OpenBookOnClickingBookTitle() throws Exception {
		    driver.get(Base.baseUrl);
		    Thread.sleep(5000);
		    Book.bookTitle(driver).click();
		    Thread.sleep(5000);
		   	  
	  	 }
		 
	  
	  
	  // Test 3: Verify the use is able to open a book using Cover Image Link
	  @Test (dependsOnMethods = {"VerifyBookListViewPageIsAvailable"}, alwaysRun = true)
	  public void OpenBookOnClickingCoverImage() throws Exception {
		    driver.get(Base.baseUrl);
		    Thread.sleep(5000);
		    Book.bookCoverImage(driver).click();
		    Thread.sleep(5000);
		   	  
	  	 }
		 

	  	  
	  // Test 4: Verify pages link in book list view is working
	  @Test (dependsOnMethods = {"VerifyBookListViewPageIsAvailable"}, alwaysRun = true)
	  public void VerifyPagesLinkIsWorking() throws Exception {
		    driver.get(Base.baseUrl);
		    Thread.sleep(5000);
		    Book.bookPages(driver).click();
		    Thread.sleep(5000);
		   	  
	  	 }
		  
	
	  	  
	  // Test 5: Verify edit book link in book list view is working
	  @Test (dependsOnMethods = {"VerifyBookListViewPageIsAvailable"}, alwaysRun = true)
	  public void VerifyEditBookLinkIsWorking() throws Exception {
		    driver.get(Base.baseUrl);
		    Thread.sleep(5000);
		    Book.bookEdit(driver).click();
		    Thread.sleep(5000);
		   	  
	  	 }
		   
	  
	  
	  // Test 6: Verify Preview Book link in book list view is working
	  @Test (dependsOnMethods = {"VerifyBookListViewPageIsAvailable"}, alwaysRun = true)
	  public void VerifyPreviewBookLinkIsWorking() throws Exception {
		    driver.get(Base.baseUrl);
		    Thread.sleep(5000);
		    Book.bookPreview(driver).click();
		    Thread.sleep(5000);
		   	  
	  	 }
		 
	  	  
	  
	  
	  // Test 8: Verify Book Delete link is book list view is working
	  @Test (dependsOnMethods = {"VerifyBookListViewPageIsAvailable"}, alwaysRun = true)
	  public void VerifyDeleteBookLinkIsWorking() throws Exception {
		    driver.get(Base.baseUrl);
		    Thread.sleep(5000);
		    Book.bookPages(driver).click();
		    Thread.sleep(5000);
		   	  
	  	 }
	


}