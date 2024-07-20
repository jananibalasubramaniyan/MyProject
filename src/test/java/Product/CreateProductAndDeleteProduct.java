package Product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Generic_Utility.Excel_Utility;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utitlity;
import Generic_Utility.WebDriver_Utility;
import Object_Repository.CreateProductPage;
import Object_Repository.DeletePrd;
import Object_Repository.VtigerHomePage;
import Object_Repository.VtigerLoginPage;

public class CreateProductAndDeleteProduct {

	public static void main(String[] args) throws Throwable  {
		
		File_Utility flib = new File_Utility();
		WebDriver_Utility wlib = new WebDriver_Utility();
		Excel_Utility elib = new Excel_Utility();
		Java_Utitlity jlib = new Java_Utitlity();
				
		  WebDriver driver;
	       String BROWSER = flib.getKeyAndValuePair("browser");
	         if(BROWSER.equalsIgnoreCase("chrome"))
	         {
	        	 driver=new ChromeDriver();
	         }
	         else
	         {
	         if(BROWSER.equalsIgnoreCase("edge"))
	        	 {
	        		 driver=new EdgeDriver();
	        	 }
	       	 else
	        	 {
	        if(BROWSER.equalsIgnoreCase("firefox"))
	        		{
	        			driver=new FirefoxDriver();
	        		}
	        else
	        		{
	        			driver=new ChromeDriver();
	        		}
	        	 }
	         }
				wlib.maximizingWindow(driver);
				wlib.implicity_Wait(driver);
			
				String URL = flib.getKeyAndValuePair("url");
				String USERNAME =flib.getKeyAndValuePair("username");
		    	String PASSWORD = flib.getKeyAndValuePair("password");
		         driver.get(URL);
		VtigerLoginPage login = new VtigerLoginPage(driver);
		login.loginToVitigerApp(USERNAME, PASSWORD);
		
		VtigerHomePage home = new VtigerHomePage(driver);
		home.clickProductLink();
		
		CreateProductPage prdPage = new CreateProductPage(driver);
		prdPage.clickOnPlusSign();
     
        int ranNum = jlib.getRandomNum();
		
        String prdData = elib.getExcelData("Product", 0, 0)+ranNum;
        prdPage.enterProductName(prdData);
        prdPage.clickOnSaveButton();
		      
        home.clickProductLink();
    
        DeletePrd delete = new DeletePrd(driver);
        delete.selectPrdCheckBox(driver, prdData);
        //driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr//td//a[text()='Product Name']/../preceding-sibling::td/input[@type='checkbox']")).click();
        //driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr//td//a[text()='"+prdData+"']/../preceding-sibling::td/input[@type='checkbox']")).click();
        
        delete.clickOnDeleteButton();
       // wlib.alertAccept(driver);

        delete.ValidatePrdName(driver, prdData);
        Thread.sleep(1000);
	
         home.logOut(driver);

}
}
