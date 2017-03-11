package appModules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class Base {
  
	
	 
	  public static String baseUrl;	  
	  public static String dashboardUrl;
	  public static String newBook;
	  public static WebDriver driver;
	  
	  // Get baseUrl
	  public static void getUrl (){
		  
		  baseUrl = "https://app.touchreading.pk/";
		  dashboardUrl = "https://app.touchreading.pk/";
		  newBook = "https://app.touchreading.pk/touch_books/new";
		  
	  }
	  
	  public static void SignUpUrl (){
		  
		  driver = new FirefoxDriver();
		  driver.get("https://app.touchreading.pk/users/sign_up");
		  
	  }
	  
	  
	  
	  //Get Gecko Driver to run test cases over 3.0.0 above. Otherwise Firefox / Selenium will not work
	  public static void Gecko_Driver (){
		
		  String geckodriver = System.getProperty("user.dir") + "\\geckodriver.exe";
		  System.setProperty("webdriver.gecko.driver",geckodriver);
		  
		  //System.setProperty("webdriver.gecko.driver","F:\\LunaWorkSpace\\TouchReading\\geckodriver.exe");
		  
	  }

	  
	
}


/*********
 * 
 * 
 * 
 * Previously    BEFORE TEST   :::::::::::::::::::
 * 
 * 	  @BeforeTest(alwaysRun = true)
	  public void setUp() throws Exception {
		  //System.setProperty("webdriver.gecko.driver","F:\\LunaWorkSpace\\TouchReading\\geckodriver.exe");
     	  Base.Gecko_Driver();
		  driver = new FirefoxDriver();
     	  Base.Set_Url();
     	  baseUrl = "https://app.touchreading.pk/"; 
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
	  
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * *******/
 