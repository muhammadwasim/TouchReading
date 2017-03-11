package pageObject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


	public class Book {
		
		private static WebElement element;
	

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//  OBJECTS/WebELEMENTS ON CREATE A NEW BOOK PAGE
//
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		
		//Cover Image for Book
		public static WebElement cover_image(WebDriver driver){
			element = driver.findElement(By.id("cover_image"));
			return element;
		}
		
		
		//Background image for Book
		public static WebElement book_bg_image(WebDriver driver){
			element = driver.findElement(By.id("background_image"));
			return element;
		}
		
		
		//Background music for Book
		public static WebElement book_bg_music(WebDriver driver){
			element = driver.findElement(By.id("background_music"));
			return element;
		}
		
		
		//Title for Book
		public static WebElement title(WebDriver driver){
			element = driver.findElement(By.id("title"));
			return element;
		}
		
		
		//Author for Book
		public static WebElement author(WebDriver driver){
			element = driver.findElement(By.id("author"));
			return element;
		}
		
		
		//highlighted_text for Book
		public static WebElement highlighted_text(WebDriver driver){
			element = driver.findElement(By.id("highlighted_text"));
			return element;
		}
	
		
		//touch_book_right_page_flip for Book
		public static WebElement book_flip(WebDriver driver){
			element = driver.findElement(By.id("touch_book_right_page_flip"));
			return element;
		}
		
		
		//Create button to create a book
		public static WebElement create_book(WebDriver driver){
			element = driver.findElement(By.name("commit"));
			return element;
		}
		
		
		//Back button
		public static WebElement Back(WebDriver driver){
			element = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[1]/a"));
			return element;
		}

		
		//Select category
		
		public static WebElement Category(WebDriver driver){
			element = driver.findElement(By.id("touch_book_category_ids"));
			return element;
		}
	

		
		
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//
		// OBJECTS / WebELEMENTS ON BOOK LIST VIEW/GRID PAGE
		//
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	
		
		
		//Book Title Path
		public static WebElement bookTitle(WebDriver driver){
			element = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[2]/div[2]/table/tbody/tr[1]/td[2]/a"));
			return element;
		}
	
		
		//Cover Image Path
		public static WebElement bookCoverImage(WebDriver driver){
			element = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[2]/div[2]/table/tbody/tr[1]/td[3]/a/img"));
			return element;
		}
	

		//Book Pages Path
		public static WebElement bookPages(WebDriver driver){
			element = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[2]/div[2]/table/tbody/tr[1]/td[7]/span/a"));
			return element;
		}
	
	
	
		//Book Edit Path
		public static WebElement bookEdit(WebDriver driver){
			element = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[2]/div[2]/table/tbody/tr[1]/td[6]/a[1]"));
			return element;
		}
	

		
		//Book Preview Path
		public static WebElement bookPreview(WebDriver driver){
			element = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[2]/div[2]/table/tbody/tr[1]/td[6]/a[2]"));
			return element;
		}
	

		
		//Book Delete Path
		public static WebElement bookDelete(WebDriver driver){
			element = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[2]/div[2]/table/tbody/tr[1]/td[6]/a[3]"));
			return element;
		}
	

		// Book Title Column Path
		public static WebElement titleColumn(WebDriver driver){
			element = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[2]/div[2]/table/tbody/tr/td[2]/a"));
			return element;
		}
		//List<WebElement> MatchText = driver.findElements(By.xpath("/html/body/div[3]/div/div/div[7]/table/tbody/tr/td[3]"));
	
		// Book Title Column Path
		public static WebElement titleColumn1(WebDriver driver){

			return element;
		}
		

		
		
		
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// OBJECTS / WebELEMENTS ON UPDATE BOOK PAGE
//
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


		
		
		
		//Update Book 
		public static WebElement updateBook(WebDriver driver){
			element = driver.findElement(By.name("commit"));
			return element;
		}
		
		
		//Back Button
		public static WebElement backBtn(WebDriver driver){
			element = driver.findElement(By.linkText("Back"));
			return element;
		}

	
		//Edit Button
		public static WebElement editBtn(WebDriver driver){
			element = driver.findElement(By.linkText("Edit"));
			return element;
		}

	
		
		
		
		
	}
