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
import pageObject.SignUp;

	public class SignUpActions {
	
		public static WebDriver driver;
		public static void matchSearchResult (WebDriver driver) throws InterruptedException{
			
		    Thread.sleep(2000);
		    WebElement element = driver.findElement(By.xpath("/html/body/div[3]/div/div/h2"));
		    String strng = element.getText();
		    Assert.assertEquals("Search Results", strng);
		    	    	    
		}
		
		public static void PositiveSignUP (WebDriver driver) throws BiffException, IOException, InterruptedException {
			Workbook wBook = Workbook.getWorkbook(new File("src/test/resources/testData.xls"));
			Sheet sheet = wBook.getSheet("signUp");
			for (int i=1; i<sheet.getRows();i++){
			SignUp.username(driver).clear();
			SignUp.username(driver).sendKeys(sheet.getCell(0, i).getContents());
			SignUp.password(driver).clear();
			SignUp.password(driver).sendKeys(sheet.getCell(1, i).getContents());
			SignUp.confirmPassword(driver).clear();
			SignUp.confirmPassword(driver).sendKeys(sheet.getCell(2, i).getContents());
			
			SignUp.btnCommit(driver).click();
				
			}
	
		}
	
		
		
		   // Method to check email field validation 
			public static void emailFieldValidation(){
			WebElement email = driver.findElement(By.xpath("//*[@id=\"new_user\"]/div[1]/div/span"));
			String strng1 = email.getText();
			Assert.assertEquals("can't be blank", strng1);
		
			}
			
			
			//Method to check password field validation
			public static void passwordFieldValidation(){
			WebElement password = driver.findElement(By.xpath("//*[@id=\"new_user\"]/div[2]/div/span"));
			String strng2 = password.getText();
			Assert.assertEquals("can't be blank", strng2);
		
			}
			
			
			//Method to check Password length validation
			public static void passwordLengthValidation(){
				WebElement passwordLength = driver.findElement(By.xpath("//*[@id=\"new_user\"]/div[2]/div/span"));
				String strng3 = passwordLength.getText();
				Assert.assertEquals("is too short (minimum is 8 characters)", strng3);
			
				}
			
			
			//Method to check confirm passwork field validation
			public static void confirmPasswordFieldValidation(){
				WebElement confirmPassword = driver.findElement(By.xpath("//*[@id=\"new_user\"]/div[3]/div/span"));
				String strng4 = confirmPassword.getText();
				Assert.assertEquals("doesn't match Password", strng4);
			
				}
	
	}
