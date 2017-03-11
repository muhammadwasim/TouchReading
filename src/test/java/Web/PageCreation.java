package Web;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObject.Page;
import appModules.Base;
import appModules.LoginActions;
import appModules.PageActions;




public class PageCreation {
	
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
	  
	  
	  
	  
	  // Test 1 (smoke test): verify the 'Add New Page' link is working 
	  @Test 
	  public void VerifyCreatePageLinkIsWorking() throws Exception {
	    driver.get(Base.baseUrl + "/?_rdr");
		    LoginActions.login_function(driver);
		    Thread.sleep(2000);
			driver.get(Base.dashboardUrl);
		    Thread.sleep(3000);
		    PageActions.findBook(driver);
		    Thread.sleep(3000);
		    Page.Add_New_Page(driver).click();	    
	   	
	  }
	 
	  
	  
	  // Test 2 (smoke test): verify create new page feature is working 
	  @Test (dependsOnMethods = {"VerifyCreatePageLinkIsWorking"},alwaysRun = true)
	  public void CreatePageWithPositiveData() throws Exception {		  
		  driver.get(Base.dashboardUrl);
		    Thread.sleep(3000);
		    PageActions.findBook(driver);
		    Thread.sleep(3000);
		    Page.Add_New_Page(driver).click();
		    Page.Page_Number(driver).clear();
		    Page.Page_Number(driver).sendKeys("1");
		    Page.Page_Text(driver).clear();
		    Page.Page_Text(driver).sendKeys("Sample page for this book");
		    new Select (Page.Page_Type(driver)).selectByVisibleText("ONLY TEXT");
		    Page.Page_Preview(driver).click();
		    Page.Create_Page(driver).click();	    
	   	
	  }
	 
	  
	  
	  // Test3: Create page if all field are empty
	  @Test (dependsOnMethods = {"CreatePageWithPositiveData"},alwaysRun = true)
	  public void CreatePageWithEmptyData() throws Exception {
	    driver.get(Base.dashboardUrl);
		    Thread.sleep(5000);
		    PageActions.findBook(driver);
		    Page.Add_New_Page(driver).click();
		    Page.Create_Page(driver).click();	    
	   	
	  }
	 
	  
	  // Test 4: Create text only page type. It will not contain word audio and page audio. 
	  @Test (dependsOnMethods = {"CreatePageWithEmptyData"},alwaysRun = true)
	  public void CreateOnlyTextPageWithOnlyPageText() throws Exception {
	    driver.get(Base.dashboardUrl);
		    Thread.sleep(5000);
		    PageActions.findBook(driver);
		    Page.Add_New_Page(driver).click();		   
		    Page.Page_Number(driver).clear();
		    Page.Page_Number(driver).sendKeys("2");
		    Page.Page_Text(driver).clear();
		    Page.Page_Text(driver).sendKeys("This is a Only Text Page. It is without page audio and words audio");
		    new Select (Page.Page_Type(driver)).selectByVisibleText("ONLY TEXT");
		    Page.Page_Preview(driver).click();
		    Page.Create_Page(driver).click();
	   	
	  }
	
	  
	  
	  // Test 5: Create text only page type. This page will contain "page text and "page audio". Excluding word audio. 
	  @Test (dependsOnMethods = {"CreateOnlyTextPageWithOnlyPageText"},alwaysRun = true)
	  public void CreateOnlyTextPageIncludingPageAudio() throws Exception {
	    driver.get(Base.dashboardUrl);
	    	Thread.sleep(5000);
		    PageActions.findBook(driver);
		    Page.Add_New_Page(driver).click();
		    Page.Page_Number(driver).clear();
		    Page.Page_Number(driver).sendKeys("3");
		    Page.Page_Text(driver).clear();
		    Page.Page_Text(driver).sendKeys("Only Text Type: This page contains page text and page audio");
		    new Select (Page.Page_Type(driver)).selectByVisibleText("ONLY TEXT");
		    String audio1 = System.getProperty("user.dir") + "\\src\\test\\resources\\TestData\\audio\\TextPageOnly2.mp3";
		    Page.Page_Audio(driver).sendKeys(audio1);
		    Page.Page_Preview(driver).click();
		    Page.Create_Page(driver).click();
	   	
	  }
	  
	  
	  
	  // Test 6: Create ONLY TEXT page. This page will contain page text, page audio and words audio. 
	  @Test (dependsOnMethods = {"CreateOnlyTextPageIncludingPageAudio"},alwaysRun = true)
	  public void CreateOnlyTextPageWithPageAndWordAudio() throws Exception {
	    driver.get(Base.dashboardUrl);
		    Thread.sleep(5000);
		    PageActions.findBook(driver);
		    Page.Add_New_Page(driver).click();		    
		    Page.Page_Number(driver).clear();
		    Page.Page_Number(driver).sendKeys("4");
		    Page.Page_Text(driver).clear();
		    Page.Page_Text(driver).sendKeys("Text page with both page text and word audio");
		    new Select (Page.Page_Type(driver)).selectByVisibleText("ONLY TEXT");
		    String audio2 = System.getProperty("user.dir") + "\\src\\test\\resources\\TestData\\audio\\TextPageOnly3.mp3";
		    Page.Page_Audio(driver).sendKeys(audio2);
		    Page.Page_Preview(driver).click();
		    Page.Create_Page(driver).click();	    
	   	
	  }
	  
	  
	  
	  // Test 7: Create Audio Page 
	  @Test (dependsOnMethods = {"CreateOnlyTextPageIncludingPageAudio"},alwaysRun = true)
	  public void CreateAudioPage() throws Exception {
	    driver.get(Base.dashboardUrl);
		    Thread.sleep(5000);
		    PageActions.findBook(driver);
		    Page.Add_New_Page(driver).click();		    
		    Page.Page_Number(driver).clear();
		    Page.Page_Number(driver).sendKeys("4");
		    new Select (Page.Page_Type(driver)).selectByVisibleText("ONLY AUDIO");
		    String audio3 = System.getProperty("user.dir") + "\\src\\test\\resources\\TestData\\audio\\AudioPageOnly.mp3";
		    Page.Page_Audio(driver).sendKeys(audio3);
		    Page.Page_Preview(driver).click();
		    Page.Create_Page(driver).click();	    
	   	
	  }
	 
	  
	  
	  
	  // Test 8: Create ONLY IMAGE page. This page will not contain page audio 
	  @Test (dependsOnMethods = {"CreateAudioPage"},alwaysRun = true)
	  public void CreateOnlyImagePageWithoutAudio() throws Exception {
	    driver.get(Base.dashboardUrl);
		    Thread.sleep(5000);
		    PageActions.findBook(driver);
		    Page.Add_New_Page(driver).click();		    
		    Page.Page_Number(driver).clear();
		    Page.Page_Number(driver).sendKeys("4");
		    Page.Page_Text(driver).clear();
		    Page.Page_Text(driver).sendKeys("Text page with both page text and word audio");
		    new Select (Page.Page_Type(driver)).selectByVisibleText("ONLY IMAGE");
		    String image1 = System.getProperty("user.dir") + "\\src\\test\\resources\\TestData\\images\\banner3.png";
		    Page.Page_Image(driver).sendKeys(image1);
		    Page.Page_Preview(driver).click();
		    Page.Create_Page(driver).click();	    
	   	
	  }
	  
	  
	  
	  
	  // Test 9: Create ONLY IMAGE page. This page will contain Page Image + Page Audio 
	  @Test (dependsOnMethods = {"CreateAudioPage"},alwaysRun = true)
	  public void CreateOnlyImagePageWithPageAudio() throws Exception {
	    driver.get(Base.dashboardUrl);
		    Thread.sleep(5000);
		    PageActions.findBook(driver);
		    Page.Add_New_Page(driver).click();		    
		    Page.Page_Number(driver).clear();
		    Page.Page_Number(driver).sendKeys("4");
		    Page.Page_Text(driver).clear();
		    Page.Page_Text(driver).sendKeys("Text page with both page text and word audio");
		    new Select (Page.Page_Type(driver)).selectByVisibleText("ONLY IMAGE");
		    String image1 = System.getProperty("user.dir") + "\\src\\test\\resources\\TestData\\images\\banner3.png";
		    Page.Page_Image(driver).sendKeys(image1);
		    String audio = System.getProperty("user.dir") + "\\src\\test\\resources\\TestData\\audio\\2.mp3";
		    Page.Page_Image(driver).sendKeys(audio);
		    Page.Page_Preview(driver).click();
		    Page.Create_Page(driver).click();	    
	   	
	  }
	  
	  
	  
	  
	  
	  /*
	  @Test (dependsOnMethods = { "VerifyCreatePageLinkIsWorking" },alwaysRun = true)
	  public void VerifyElementOnCreatePage() throws Exception {
	    driver.get("https://staging.touchreading.pk/touch_books/new");
	      }
	  
	  @Test (dependsOnMethods = { "VerifyCreatePageLinkIsWorking" },alwaysRun = true)
	  public void CreateImageTypeBookPageWithPositiveValues() throws Exception {
	    driver.get(baseUrl + "/touch_books/chinese-culture");
	    driver.findElement(By.linkText("Edit")).click();
	    driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/form/div/div[2]/a")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.id("page_image")).clear();
	    driver.findElement(By.id("page_image")).sendKeys("C:\\Users\\Arkhitech\\Downloads\\TouchReadingSample\\Story1\\page1.jpg");
	    Thread.sleep(3000);
	    driver.findElement(By.id("page_text")).clear();
	    driver.findElement(By.id("page_text")).sendKeys("A young monkey named Sari.");
	    Thread.sleep(3000);
	    //driver.findElement(By.id("/html/body/div[3]/div/div/div[2]/form/div/div[2]/div/div/input[8]")).click();
	    driver.findElement(By.name("commit")).click();
	    Thread.sleep(10000);
	    driver.findElement(By.linkText("Back")).click();

	      }
	  
	  @Test (dependsOnMethods = { "VerifyCreatePageLinkIsWorking" },alwaysRun = true)
	  public void CreateImageTypeBookPageWithNegativeValues() throws Exception {
	    driver.get(baseUrl + "/touch_books/chinese-culture");
	    driver.findElement(By.linkText("Edit")).click();
	    driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/form/div/div[2]/a")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.id("page_image")).clear();
	    //driver.findElement(By.id("page_image")).sendKeys("C:\\Users\\Arkhitech\\Downloads\\TouchReadingSample\\Story1\\page1.jpg");
	    Thread.sleep(3000);
	    driver.findElement(By.id("page_text")).clear();
	    driver.findElement(By.id("page_text")).sendKeys("A young monkey named Sari.");
	    Thread.sleep(3000);
	    //driver.findElement(By.id("/html/body/div[3]/div/div/div[2]/form/div/div[2]/div/div/input[8]")).click();
	    driver.findElement(By.name("commit")).click();
	    Thread.sleep(10000);
	    driver.findElement(By.linkText("Back")).click();

	      }	  
	  
	  @Test (dependsOnMethods = { "VerifyCreatePageLinkIsWorking" },alwaysRun = true)
	  public void CreateVideoTypeBookPageWithPositiveValues() throws Exception {
	    driver.get(baseUrl + "/touch_books/chinese-culture");
	    driver.findElement(By.linkText("Edit")).click();
	    driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/form/div/div[2]/a")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.id("video_upload")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.id("video")).clear();
	    driver.findElement(By.id("video")).sendKeys("C:\\Users\\Arkhitech\\Downloads\\TouchReadingSample\\Story1\\Demo1.mp4");
	    Thread.sleep(3000);
	    driver.findElement(By.id("page_text")).clear();
	    driver.findElement(By.id("page_text")).sendKeys("A young monkey named Sari woke up one morning and knew there was trouble.");
	    Thread.sleep(3000);
	    //driver.findElement(By.id("/html/body/div[3]/div/div/div[2]/form/div/div[2]/div/div/input[8]")).click();
	    driver.findElement(By.name("commit")).click();
	    Thread.sleep(10000);
	    driver.findElement(By.linkText("Back")).click();
	      }
	  @Test (dependsOnMethods = { "VerifyCreatePageLinkIsWorking" },alwaysRun = true)
	  public void CreateVideoTypeBookPageWithNegativeValues() throws Exception {
		    driver.get(baseUrl + "/touch_books/chinese-culture");
		    driver.findElement(By.linkText("Edit")).click();
		    driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/form/div/div[2]/a")).click();
		    Thread.sleep(3000);
		    driver.findElement(By.id("video_upload")).click();
		    Thread.sleep(1000);
		    driver.findElement(By.id("video")).clear();
		    driver.findElement(By.id("video")).sendKeys("C:\\Users\\Arkhitech\\Downloads\\TouchReadingSample\\Story1\\Demo1.mp4");
		    Thread.sleep(3000);
		    driver.findElement(By.id("page_text")).clear();
		    //driver.findElement(By.id("page_text")).sendKeys("A young monkey named Sari woke up one morning and knew there was trouble.");
		    Thread.sleep(3000);
		    //driver.findElement(By.id("/html/body/div[3]/div/div/div[2]/form/div/div[2]/div/div/input[8]")).click();
		    driver.findElement(By.name("commit")).click();
		    Thread.sleep(10000);
		    driver.findElement(By.linkText("Back")).click();
	      }
	  /*
	  @Test (dependsOnMethods = { "VerifyCreatePageLinkIsWorking" },alwaysRun = true)
	  public void VerifyVideoSizeValidation() throws Exception {
	    driver.get("https://staging.touchreading.pk/touch_books/new");
	      }
	  @Test (dependsOnMethods = { "VerifyCreatePageLinkIsWorking" },alwaysRun = true)
	  public void VerifyImageSizeValidation() throws Exception {
	    driver.get("https://staging.touchreading.pk/touch_books/new");
	      }*/
	  
	  /*
	  @Test (dependsOnMethods = { "VerifyCreatePageLinkIsWorking" },alwaysRun = true)
	  public void VerifyMandatoryFieldValidationInViewPage() throws Exception {
	    driver.get("https://staging.touchreading.pk/touch_books/new");
	    driver.get(baseUrl + "/touch_books/chinese-culture");
	    driver.findElement(By.linkText("Edit")).click();
	    driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/form/div/div[2]/a")).click();
	    driver.findElement(By.name("commit")).click();

	      } */
	      
	      

}


