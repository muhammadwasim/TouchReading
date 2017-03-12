package appModules;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageActions {
	
	
		// Open Specific Book to add pages in it:
		public static void openBookToAddPages (WebDriver driver) throws InterruptedException{
		List<WebElement> findBook = driver.findElements(By.xpath("/html/body/div[2]/div[1]/div/div[2]/div[2]/table/tbody/tr/td[2]/a"));
	    Thread.sleep(5000);
	        for(int i=0;i<findBook.size();i++){
	             if(findBook.get(i).getText().equals("All Types")){  
	        	 findBook.get(i).click();
	           	//break;
	            }
	        }
	        
		}
		
	
	
	
		//Touch Page Edit Action:
		public static void EditAction (WebDriver driver) throws InterruptedException{
	    
		List<WebElement> MatchText = driver.findElements(By.xpath("/html/body/div[3]/div/div/div[7]/table/tbody/tr/td[3]"));
	    List<WebElement> EditAction = driver.findElements(By.xpath("/html/body/div[3]/div/div/div[7]/table/tbody/tr/td[6]/a"));
	    Thread.sleep(5000);
            for(int i=0;i<MatchText.size();i++){
                 if(MatchText.get(i).getText().equals("A young monkey named Sari")){  
            	 EditAction.get(i).click();
               	//break;
                }
            }		    

		}
	
		//Touch Page Edit Action after page text is updated:
		public static void EditAction2 (WebDriver driver) throws InterruptedException{
	    
		List<WebElement> MatchText = driver.findElements(By.xpath("/html/body/div[3]/div/div/div[7]/table/tbody/tr/td[3]"));
	    List<WebElement> EditAction = driver.findElements(By.xpath("/html/body/div[3]/div/div/div[7]/table/tbody/tr/td[6]/a"));
	    Thread.sleep(5000);
            for(int i=0;i<MatchText.size();i++){
                 if(MatchText.get(i).getText().equals("Updated")){  
            	 EditAction.get(i).click();
               	//break;
                }
            }		    

		}
		
		
		
		// Find book from book list view
		public static void findBook(WebDriver driver) throws InterruptedException{
	    
		    List<WebElement> BookColumn = driver.findElements(By.xpath("/html/body/div[3]/div[1]/div/div[3]/table/tbody/tr/td[2]/a"));	    
            for(int i=0;i<BookColumn.size();i++){
	                    if(BookColumn.get(i).getText().equals("Scince Book")){  	  	                    
                	BookColumn.get(i).click();	
                	break;
                }
            }

	
		
	}
		

 /* NOTE: This is an Important loop
  * 
  *
  *
  *
 	    List<WebElement> column = driver.findElements(By.xpath("/html/body/div[3]/div[1]/div/div[3]/table/tbody/tr/td[2]/a"));
	    //System.out.println(column.size());
	                for(int i=0;i<column.size();i++){
	                    //System.out.println(column.get(i).getText());  
	                    // if u want to click on the specific mail then here u can pass it
	  	                    if(column.get(i).getText().equals("Scince Book")){  	  	                    
	                    	column.get(i).click();	                       
	                    }
	                }

*/

		
		
		
	
	
	

}
