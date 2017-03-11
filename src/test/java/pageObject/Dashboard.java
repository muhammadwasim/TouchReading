
package pageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * 
 * This class contains the elements for Dashboard page 
 * After login user navigates to this page
 *
 */


		public class Dashboard {
			
			private static WebElement element;
			
			//Search Text Field
			public static WebElement searchTextField(WebDriver driver){
				element = driver.findElement(By.id("query"));
				return element;
			}
			
			
			//Search Text Field
			
			public void baseUrl (){
				
			}
			
		}
