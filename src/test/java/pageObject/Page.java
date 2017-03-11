package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



	public class Page {
		
		private static WebElement element;

		
		// Add a new page link text
		public static WebElement Add_New_Page(WebDriver driver){
			element = driver.findElement(By.linkText("Add New Page"));
			return element;
		}
		
		
		// Page type for touch pages
		public static WebElement Page_Type(WebDriver driver){
			element = driver.findElement(By.id("touch_page_page_type"));
			return element;
		}
		
		
		
		// Page number for touch pages
		public static WebElement Page_Number(WebDriver driver){
			element = driver.findElement(By.id("touch_page_page_number"));
			return element;
		}
	
		
		
		// Page text for touch pages
		public static WebElement Page_Text(WebDriver driver){
			element = driver.findElement(By.id("page_text"));
			return element;
		}
		
		
		
		// Page Audio for touch pages
		public static WebElement Page_Audio(WebDriver driver){
			element = driver.findElement(By.id("page_audio"));
			return element;
		}
		

		
		// Page background music for touch pages
		public static WebElement Page_bg_Music(WebDriver driver){
			element = driver.findElement(By.id("background_music"));
			return element;
		}
		
		
		
		// Page back ground images for touch pages
		public static WebElement Page_bg_Image(WebDriver driver){
			element = driver.findElement(By.id("background_image"));
			return element;
		}
		
		
		
		
		// Page Image
		public static WebElement Page_Image(WebDriver driver){
			element = driver.findElement(By.id("page_image"));
			return element;
		}
		
			
		
		// Page preview option for touch pages
		public static WebElement Page_Preview(WebDriver driver){
			element = driver.findElement(By.id("touch_page_previewable"));
			return element;
		}
		
		
		// Create button to create a book
		public static WebElement Create_Page(WebDriver driver){
			element = driver.findElement(By.name("commit"));
			return element;
		}
		

		
 }
