package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



	public class Page {
		
		private static WebElement element;

		
		// Add new page 
		public static WebElement addNewPage(WebDriver driver){
			element = driver.findElement(By.linkText("Add New Page"));
			return element;
		}
		
		
		// Page type
		public static WebElement pageType(WebDriver driver){
			element = driver.findElement(By.id("touch_page_page_type"));
			return element;
		}
		
		
		
		// Page number
		public static WebElement pageNumber(WebDriver driver){
			element = driver.findElement(By.id("touch_page_page_number"));
			return element;
		}
	
		
		
		// Page text
		public static WebElement pageText(WebDriver driver){
			element = driver.findElement(By.id("page_text"));
			return element;
		}
		
		
		
		// Page Audio 
		public static WebElement pageAudio(WebDriver driver){
			element = driver.findElement(By.id("page_audio"));
			return element;
		}
		

		
		// Page background music
		public static WebElement pageBgMusic(WebDriver driver){
			element = driver.findElement(By.id("background_music"));
			return element;
		}
		
		
		
		// Page back ground
		public static WebElement pageBgImage(WebDriver driver){
			element = driver.findElement(By.id("background_image"));
			return element;
		}
		
		
		
		
		// Page Image
		public static WebElement pageImage(WebDriver driver){
			element = driver.findElement(By.id("page_image"));
			return element;
		}
		
			
		
		// Page preview 
		public static WebElement pagePreview(WebDriver driver){
			element = driver.findElement(By.id("touch_page_previewable"));
			return element;
		}
		
		
		// Create Page Button
		public static WebElement createPage(WebDriver driver){
			element = driver.findElement(By.name("commit"));
			return element;
		}
		

		
 }
