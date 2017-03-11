package Web;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DataDriven {

	public static void main(String[] args) throws InterruptedException, BiffException, IOException {
		// TODO Auto-generated method stub
		
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\MRCOM\\Downloads\\chromedriver_win32.chromedriver.exe");
		System.setProperty("webdriver.gecko.driver","F:\\LunaWorkSpace\\TouchReading\\geckodriver.exe");     	
		WebDriver driver = new FirefoxDriver ();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Workbook wBook = Workbook.getWorkbook(new File("E:\\LunaWorkSpace\\TouchReading\\data\\Book2.xls"));
		Workbook wBook = Workbook.getWorkbook(new File("src/test/resources/testData.xls"));
		Sheet sheet = wBook.getSheet("loginx");
		for (int i=3; i<sheet.getRows();i++){
		driver.get("http://app.touchreading.pk/users/sign_in");
		driver.findElement(By.id("user_email")).sendKeys(sheet.getCell(0, i).getContents());
		Thread.sleep(3000);
		driver.findElement(By.id("user_password")).sendKeys(sheet.getCell(1, i).getContents());
		Thread.sleep(3000);
		driver.findElement(By.name("commit")).click();

		}
		}

}
