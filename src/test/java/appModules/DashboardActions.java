package appModules;

import java.io.File;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import pageObject.Dashboard;

	public class DashboardActions {
	
		public static void matchSearchResult (WebDriver driver) throws InterruptedException{
			
		    Thread.sleep(2000);
		    WebElement element = driver.findElement(By.xpath("/html/body/div[3]/div/div/h2"));
		    String strng = element.getText();
		    Assert.assertEquals("Search Results", strng);
		    	    	    
		}
		
		
		// Data driven function picking data from testData.xls file and inserting in search field
		public static void searchAction (WebDriver driver) throws BiffException, IOException, InterruptedException {
			Workbook wBook = Workbook.getWorkbook(new File("src/test/resources/testData.xls"));
			Sheet sheet = wBook.getSheet("search");
			for (int i=1; i<sheet.getRows();i++){
				Dashboard.searchTextField(driver).clear();
				Thread.sleep(2000);
				Dashboard.searchTextField(driver).sendKeys(sheet.getCell(0, i).getContents());
			    Thread.sleep(2000);
			    Dashboard.searchTextField(driver).sendKeys(Keys.ENTER);
			    Thread.sleep(2000);
				
			}
		}
				
		
	}
