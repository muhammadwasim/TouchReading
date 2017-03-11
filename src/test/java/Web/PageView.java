package Web;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import appModules.LoginActions;



public class PageView {
	
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
	  public void VerifyTouchPageCanBeViewed() throws Exception {
	    driver.get(baseUrl + "/?_rdr");
	    driver.findElement(By.linkText("Sign In")).click();
	    LoginActions.login_function(driver);
	    driver.get(baseUrl + "/touch_books/chinese-culture");
	   	  }

	  @Test (dependsOnMethods = { "VerifyTouchPageCanBeViewed" },alwaysRun = true)
	  public void VerifyTouchPageIsPresent() throws Exception {
		driver.get(baseUrl + "/touch_books/chinese-culture"); 
	    List<WebElement> MatchText = driver.findElements(By.xpath("/html/body/div[3]/div/div/div[7]/table/tbody/tr/td[3]"));
		Thread.sleep(3000);
                for(int i=0;i<MatchText.size();i++){
                    //System.out.println(MatchTextColumn.get(i).getText());
                    if(MatchText.get(i).getText().equals("A young monkey named Sari")){  
                      MatchText.get(i).click();
                    }
                }		    
	  	
	     	}

	  @Test (dependsOnMethods = { "VerifyTouchPageIsPresent" },alwaysRun = true)
	  public void VerifyPreviewCheckIsWorking() throws Exception {
			driver.get(baseUrl + "/touch_books/chinese-culture"); 
		    List<WebElement> MatchText = driver.findElements(By.xpath("/html/body/div[3]/div/div/div[7]/table/tbody/tr/td[3]"));
		    List<WebElement> PreviewAction = driver.findElements(By.xpath("/html/body/div[3]/div/div/div[7]/table/tbody/tr/td[4]/input"));
		    Thread.sleep(5000);
                for(int i=0;i<MatchText.size();i++){
                     if(MatchText.get(i).getText().equals("A young monkey named Sari")){  
                	 PreviewAction.get(i).click();
                   	//break;
                    }
                }		    
	  	
	     	}
	  @Test (dependsOnMethods = { "VerifyPreviewCheckIsWorking" },alwaysRun = true)
	  public void VerifyNumberOfPages() throws Exception {
			driver.get(baseUrl + "/touch_books/chinese-culture"); 
		    List<WebElement> MatchText = driver.findElements(By.xpath("/html/body/div[3]/div/div/div[7]/table/tbody/tr/td[3]"));
			Thread.sleep(3000);
			int length = MatchText.size();
			System.out.println(length);
				if (length == 1){
					System.out.println("Pass");
				} else
				{
					System.out.println("Fail");
				}

		  	
	     	}
	  
	  @Test (dependsOnMethods = { "VerifyPreviewCheckIsWorking" },alwaysRun = true)
	  public void VerifyPageWordslinkIsWorking() throws Exception {
			driver.get(baseUrl + "/touch_books/chinese-culture"); 
		    List<WebElement> MatchText = driver.findElements(By.xpath("/html/body/div[3]/div/div/div[7]/table/tbody/tr/td[3]"));
		    List<WebElement> PageWords = driver.findElements(By.xpath("/html/body/div[3]/div/div/div[7]/table/tbody/tr/td[7]/a"));
		    Thread.sleep(5000);
                for(int i=0;i<MatchText.size();i++){
                     if(MatchText.get(i).getText().equals("A young monkey named Sari")){  
                	 PageWords.get(i).click();
                   	//break;
                    }
                }		    
	  	
	     	}
	  

}