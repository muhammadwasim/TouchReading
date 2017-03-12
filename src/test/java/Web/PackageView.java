package Web;
import java.util.List;
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

public class PackageView {
	
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
	  /*
	  @AfterTest(alwaysRun = true)
	  public void tearDown() throws Exception {
	    driver.quit();	 
	  }*/
	  
	  @Test 
	  public void VerifyPurchasePackageLinkIsWorking() throws Exception {
	    driver.get(baseUrl + "/?_rdr");
	    driver.findElement(By.linkText("Sign In")).click();
	    driver.findElement(By.id("user_email")).sendKeys("no-reply@arkhitech.com");
	    driver.findElement(By.id("user_password")).sendKeys("arkhitech");
	    driver.findElement(By.name("commit")).click();
	    Thread.sleep(10000);
	    //driver.findElement(By.linkText("New Touch book")).click();
	    //driver.findElement(By.linkText("Purchase Packages")).click();
	    //driver.findElement(By.linkText("Sign out")).click();
	   	  }

	  
	  @Test (dependsOnMethods = { "VerifyPurchasePackageLinkIsWorking" },alwaysRun = true)	  
	  public void VerifyEditPackageLinkIsWorking() throws Exception {
		driver.get("http://app.touchreading.pk/purchase_packages");
	    Thread.sleep(3000);
	    List<WebElement> MatchTextColumn = driver.findElements(By.xpath("/html/body/div[3]/div/div/div[3]/table/tbody/tr/td[2]"));
	    List<WebElement> EditAction = driver.findElements(By.xpath("/html/body/div[3]/div/div/div[3]/table/tbody/tr/td[10]/a"));
	    System.out.println(MatchTextColumn.size());
	    Thread.sleep(5000);
	                for(int i=0;i<MatchTextColumn.size();i++){
	                    System.out.println(MatchTextColumn.get(i).getText());
	                    Thread.sleep(5000);
	                    if(MatchTextColumn.get(i).getText().equals("Test Package 1")){  // if u want to click on the specific mail then here u can pass it
                    	EditAction.get(i).click();
	                    //column.get(i).click();
                    	//break;
	                    }
	                }
        Thread.sleep(3000);

	  }
	  @Test (dependsOnMethods = { "VerifyEditPackageLinkIsWorking" },alwaysRun = true)	  
	  public void VerifyMendatoryValidationInPackageUpdate() throws Exception {
		driver.get("http://app.touchreading.pk/purchase_packages");
	    Thread.sleep(3000);
	    List<WebElement> MatchTextColumn = driver.findElements(By.xpath("/html/body/div[3]/div/div/div[3]/table/tbody/tr/td[2]"));
	    List<WebElement> EditAction = driver.findElements(By.xpath("/html/body/div[3]/div/div/div[3]/table/tbody/tr/td[10]/a"));
	    System.out.println(MatchTextColumn.size());
	    Thread.sleep(5000);
	                for(int i=0;i<MatchTextColumn.size();i++){
	                    System.out.println(MatchTextColumn.get(i).getText());
	                    Thread.sleep(5000);
	                    if(MatchTextColumn.get(i).getText().equals("Test Package 1")){  // if u want to click on the specific mail then here u can pass it
                    	EditAction.get(i).click();
	                    //column.get(i).click();
                    	//break;
	                    }
	                }
        Thread.sleep(3000);
	    driver.findElement(By.id("purchase_package_title")).clear();
	  //Price Tier Dropdown
	    new Select(driver.findElement(By.id("purchase_package_price_tier_id"))).selectByVisibleText("1.99");
		Thread.sleep(2000);   
	    //Start Date Dropdown
	    new Select(driver.findElement(By.id("purchase_package_start_date_1i"))).selectByVisibleText("2016");
	    new Select(driver.findElement(By.id("purchase_package_start_date_2i"))).selectByVisibleText("October");
	    new Select(driver.findElement(By.id("purchase_package_start_date_3i"))).selectByVisibleText("1");
	    Thread.sleep(2000);
	    //End Date Dropdown
	    new Select(driver.findElement(By.id("purchase_package_end_date_1i"))).selectByVisibleText("2011");
	    new Select(driver.findElement(By.id("purchase_package_end_date_2i"))).selectByVisibleText("November");
	    new Select(driver.findElement(By.id("purchase_package_end_date_3i"))).selectByVisibleText("1");
	    Thread.sleep(2000);
	    driver.findElement(By.id("purchase_package_iap_product_identifier")).sendKeys("test_identifier.Book.Updated");
	    //Element(By.id("purchase_package_published")).click();
	    //driver.findElement(By.id("purchase_package_touch_book_ids_64")).click();
	    driver.findElement(By.name("commit")).click();
	    Thread.sleep(2000);
	  }
	  
	  @Test (dependsOnMethods = { "VerifyMendatoryValidationInPackageUpdate" },alwaysRun = true)	  
	  public void VerifyPackageFieldsAreUpdating() throws Exception {
		driver.get("http://app.touchreading.pk/purchase_packages");
	    Thread.sleep(3000);
	    List<WebElement> MatchTextColumn = driver.findElements(By.xpath("/html/body/div[3]/div/div/div[3]/table/tbody/tr/td[2]"));
	    List<WebElement> EditAction = driver.findElements(By.xpath("/html/body/div[3]/div/div/div[3]/table/tbody/tr/td[10]/a"));
	    System.out.println(MatchTextColumn.size());
	    Thread.sleep(5000);
	                for(int i=0;i<MatchTextColumn.size();i++){
	                    System.out.println(MatchTextColumn.get(i).getText());
	                    Thread.sleep(5000);
	                    if(MatchTextColumn.get(i).getText().equals("Test Package 1")){  // if u want to click on the specific mail then here u can pass it
                    	EditAction.get(i).click();
	                    //column.get(i).click();
                    	//break;
	                    }
	                }
        Thread.sleep(3000);
	    driver.findElement(By.id("purchase_package_title")).sendKeys("Test Package 1 Updated");
	  //Price Tier Dropdown
	    new Select(driver.findElement(By.id("purchase_package_price_tier_id"))).selectByVisibleText("1.99");
		Thread.sleep(2000);   
	    //Start Date Dropdown
	    new Select(driver.findElement(By.id("purchase_package_start_date_1i"))).selectByVisibleText("2016");
	    new Select(driver.findElement(By.id("purchase_package_start_date_2i"))).selectByVisibleText("October");
	    new Select(driver.findElement(By.id("purchase_package_start_date_3i"))).selectByVisibleText("1");
	    Thread.sleep(2000);
	    //End Date Dropdown
	    new Select(driver.findElement(By.id("purchase_package_end_date_1i"))).selectByVisibleText("2019");
	    new Select(driver.findElement(By.id("purchase_package_end_date_2i"))).selectByVisibleText("November");
	    new Select(driver.findElement(By.id("purchase_package_end_date_3i"))).selectByVisibleText("1");
	    Thread.sleep(2000);
	    driver.findElement(By.id("purchase_package_iap_product_identifier")).sendKeys("test_identifier.Book.Updated");
	    //Element(By.id("purchase_package_published")).click();
	    //driver.findElement(By.id("purchase_package_touch_book_ids_64")).click();
	    //driver.findElement(By.name("commit")).click();
	    Thread.sleep(2000);
	  }
	  
	 

	 

}