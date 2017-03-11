package appModules;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class BookActions {

	
			// Open Specific Book:
			public static void openSpecificBook (WebDriver driver) throws InterruptedException{
			    
			List<WebElement> findBook = driver.findElements(By.xpath("/html/body/div[2]/div[1]/div/div[2]/div[2]/table/tbody/tr/td[2]/a"));
		    Thread.sleep(5000);
		        for(int i=0;i<findBook.size();i++){
		             if(findBook.get(i).getText().equals("Science Book")){  
		        	 findBook.get(i).click();
		           	//break;
		            }
		        }
		        
			}
			
			
			
			
			
			//Touch Page Edit Action:
			public static void editSpecificBook (WebDriver driver) throws InterruptedException{
		    
			List<WebElement> findBook = driver.findElements(By.xpath("/html/body/div[2]/div[1]/div/div[2]/div[2]/table/tbody/tr/td[2]/a"));
		    List<WebElement> editAction = driver.findElements(By.xpath("/html/body/div[2]/div[1]/div/div[2]/div[2]/table/tbody/tr/td[6]/a[1]"));
		    Thread.sleep(5000);
		        for(int i=0;i<findBook.size();i++){
		             if(findBook.get(i).getText().equals("Science Book")){  
		        	 editAction.get(i).click();
		           	//break;
		            }
		        }		    
			
			}
			
			
			
			//Touch Page Edit Action:
			public static void deleteSpecificBook (WebDriver driver) throws InterruptedException{
		    
			List<WebElement> findBook = driver.findElements(By.xpath("/html/body/div[2]/div[1]/div/div[2]/div[2]/table/tbody/tr/td[2]/a"));
		    List<WebElement> deleteAction = driver.findElements(By.xpath("/html/body/div[2]/div[1]/div/div[2]/div[2]/table/tbody/tr/td[6]/span[3]/a"));
		    Thread.sleep(5000);
		        for(int i=0;i<findBook.size();i++){
		             if(findBook.get(i).getText().equals("Less Data Book")){  
		        	 deleteAction.get(i).click();
		           	 //break;
		            }
		        }		    
			
			}
			

}





/*
@Test (dependsOnMethods = {"OpenBookfromBookImgInListView"},alwaysRun = true)
public void VerifyPreviewOptionIsWorking() throws Exception {
  driver.get(Base.baseUrl + "/touch_books");
  Thread.sleep(5000);
//  driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[3]/table/tbody/tr[1]/td[2]/a/img")).click();
//  Thread.sleep(5000);
  List<WebElement> MatchTextColumn = driver.findElements(By.xpath("/html/body/div[4]/div[1]/div/div[3]/table/tbody/tr/td[6]/a"));
  List<WebElement> EditAction = driver.findElements(By.xpath("/html/body/div[4]/div[1]/div/div[3]/table/tbody/tr/td[6]/a"));
  System.out.println(MatchTextColumn.size());
  Thread.sleep(5000);
              for(int i=0;i<MatchTextColumn.size();i++){
                  System.out.println(MatchTextColumn.get(i).getText());
                  Thread.sleep(5000);
                  if(MatchTextColumn.get(i).getText().equals("Edit")){  // if u want to click on the specific mail then here u can pass it
              	//EditAction.get(i).click();
                  //column.get(i).click();
              	//break;
                  }
              }
 	  }
*/


