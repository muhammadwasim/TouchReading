package Web;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PackageCreation {
	
	  private WebDriver driver;
	  private String baseUrl;	  //private boolean acceptNextAlert = true;8
	  //private StringBuffer verificationErrors = new StringBuffer();
	  
	  @BeforeTest(alwaysRun = true)
	  public void setUp() throws Exception {
	  System.setProperty("webdriver.gecko.driver","F:\\LunaWorkSpace\\TouchReading\\geckodriver.exe");
      driver = new FirefoxDriver();
	    baseUrl = "https://app.touchreading.pk/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
	  
	  @AfterTest(alwaysRun = true)
	  public void tearDown() throws Exception {
	    driver.quit();	 
	  }
	  
	  @Test 
	  public void VerifyPurchasePackageLinkIsWorking() throws Exception {
	    driver.get(baseUrl + "/?_rdr");
	    driver.findElement(By.linkText("Sign In")).click();
	    driver.findElement(By.id("user_email")).sendKeys("t09066292@gmail.com");
	    driver.findElement(By.id("user_password")).sendKeys("arkhitech");
	    driver.findElement(By.name("commit")).click();
	    Thread.sleep(10000);
	    //driver.findElement(By.linkText("New Touch book")).click();
	    //driver.findElement(By.linkText("Purchase Packages")).click();
	    //driver.findElement(By.linkText("Sign out")).click();
	   	  }

	  @Test (dependsOnMethods = {"VerifyPurchasePackageLinkIsWorking"},alwaysRun = true)
	  public void CreateNewPackage() throws Exception {
	    driver.get("http://app.touchreading.pk/purchase_packages/new");
	    Thread.sleep(3000);
	    driver.findElement(By.id("purchase_package_title")).sendKeys("Test Package 1");
	    Thread.sleep(2000);
	    //Price Tier Dropdown
	    new Select(driver.findElement(By.id("purchase_package_price_tier_id"))).selectByVisibleText("2.99");
		Thread.sleep(2000);   
	    //Start Date Dropdown
	    new Select(driver.findElement(By.id("purchase_package_start_date_1i"))).selectByVisibleText("2014");
	    new Select(driver.findElement(By.id("purchase_package_start_date_2i"))).selectByVisibleText("October");
	    new Select(driver.findElement(By.id("purchase_package_start_date_3i"))).selectByVisibleText("15");
	    Thread.sleep(2000);
	    //End Date Dropdown
	    new Select(driver.findElement(By.id("purchase_package_end_date_1i"))).selectByVisibleText("2018");
	    new Select(driver.findElement(By.id("purchase_package_end_date_2i"))).selectByVisibleText("November");
	    new Select(driver.findElement(By.id("purchase_package_end_date_3i"))).selectByVisibleText("20");
	    Thread.sleep(2000);
	    driver.findElement(By.id("purchase_package_iap_product_identifier")).sendKeys("test_identifier.Book");
	    //Element(By.id("purchase_package_published")).click();
	    driver.findElement(By.id("purchase_package_touch_book_ids_64")).click();
	    driver.findElement(By.name("commit")).click();
	    Thread.sleep(2000);
	  	}
	  
	  
	  
	  @Test (dependsOnMethods = {"CreateNewPackage"},alwaysRun = true)
	  public void VerifyNewPackageIsCreated() throws Exception {
		driver.get("http://app.touchreading.pk/purchase_packages");
	    Thread.sleep(3000);	    
	    }
	 	  
	  @Test (dependsOnMethods = {"VerifyNewPackageIsCreated"},alwaysRun = true)
	  public void VarifyValidationOnPackageTitle() throws Exception {
		driver.get("http://app.touchreading.pk/purchase_packages/new");
	    Thread.sleep(3000);
	    driver.findElement(By.name("commit")).click();
	    Thread.sleep(2000);
	    WebElement element = driver.findElement(By.xpath("/html/body/div[3]/div/div/form/div/div[1]/div/span"));
	    String strng = element.getText();
	    Assert.assertEquals("can't be blank: this is", strng);
	   }
	  
	  @Test (dependsOnMethods = { "VarifyValidationOnPackageTitle" },alwaysRun = true)
	  public void VarifyValidationOnPriceTier() throws Exception {
		driver.get("http://app.touchreading.pk/purchase_packages/new");
	    Thread.sleep(3000);
	    driver.findElement(By.name("commit")).click();
	    Thread.sleep(2000);
	    WebElement element = driver.findElement(By.xpath("/html/body/div[3]/div/div/form/div/div[2]/div/span"));
	    String strng2 = element.getText();
	    Assert.assertEquals("is not a number", strng2);
	 
	   }
	  
	  @Test (dependsOnMethods = { "VarifyValidationOnPackageTitle" },alwaysRun = true)
	  public void VarifyValidationEndDateCannotBeforeStartDate() throws Exception {
		driver.get("http://app.touchreading.pk/purchase_packages/new");
	    Thread.sleep(3000);
	    new Select(driver.findElement(By.id("purchase_package_end_date_1i"))).selectByVisibleText("2015");
	    Thread.sleep(2000);
	    driver.findElement(By.name("commit")).click();
	    Thread.sleep(2000);
	    WebElement element = driver.findElement(By.xpath("/html/body/div[3]/div/div/form/div/div[3]/div[2]/div/div/span"));
	    String strng3 = element.getText();
	    Assert.assertEquals("cannot be before the start date", strng3);
		    
	   }
	  
	  @Test (dependsOnMethods = {"VerifyPurchasePackageLinkIsWorking"},alwaysRun = true)
	  public void CreateAnotherPackage() throws Exception {
	    driver.get("http://app.touchreading.pk/purchase_packages/new");
	    Thread.sleep(3000);
	    driver.findElement(By.id("purchase_package_title")).sendKeys("Test Package 2");
	    Thread.sleep(2000);
	    //Price Tier Dropdown
	    new Select(driver.findElement(By.id("purchase_package_price_tier_id"))).selectByVisibleText("1.99");
		Thread.sleep(2000);   
	    //Start Date Dropdown
	    new Select(driver.findElement(By.id("purchase_package_start_date_1i"))).selectByVisibleText("2015");
	    new Select(driver.findElement(By.id("purchase_package_start_date_2i"))).selectByVisibleText("October");
	    new Select(driver.findElement(By.id("purchase_package_start_date_3i"))).selectByVisibleText("17");
	    Thread.sleep(2000);
	    //End Date Dropdown
	    new Select(driver.findElement(By.id("purchase_package_end_date_1i"))).selectByVisibleText("2018");
	    new Select(driver.findElement(By.id("purchase_package_end_date_2i"))).selectByVisibleText("June");
	    new Select(driver.findElement(By.id("purchase_package_end_date_3i"))).selectByVisibleText("22");
	    Thread.sleep(2000);
	    driver.findElement(By.id("purchase_package_iap_product_identifier")).sendKeys("test_identifier.Book2");
	    //Element(By.id("purchase_package_published")).click();
	    driver.findElement(By.id("purchase_package_touch_book_ids_64")).click();
	    driver.findElement(By.name("commit")).click();
	    Thread.sleep(2000);
	  	} 

	  

}