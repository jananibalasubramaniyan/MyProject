package Campaign;

import org.openqa.selenium.WebDriver;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v123.browser.Browser;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Generic_Utility.Excel_Utility;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utitlity;
import Generic_Utility.WebDriver_Utility;
import Object_Repository.CampWithPrdWindowSwitching;
import Object_Repository.CreateCampaignPage;
import Object_Repository.CreateProductPage;
import Object_Repository.VtigerHomePage;
import Object_Repository.VtigerLoginPage;

public class CreateCampaignWithProduct {


	public static void main(String[] args) throws Throwable {
		
		File_Utility flib = new File_Utility();	
        Java_Utitlity jlib = new  Java_Utitlity();
        Excel_Utility elib = new Excel_Utility();
        WebDriver_Utility wlib = new WebDriver_Utility();
        WebDriver driver;
        
        String BROWSER=System.getProperty("browser");
        System.out.println(BROWSER);
        
       // String BROWSER1 = flib.getKeyAndValuePair("browser");
          if(BROWSER.equalsIgnoreCase("chrome"))
          {
        	  WebDriverManager.chromedriver().setup();
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
	     
	    String prdData = elib.getExcelData("Product", 0, 0)+ ranNum;  
			         
	    prdPage.enterProductName(prdData);
	    prdPage.clickOnSaveButton();
	        
	    home.clickMoreLink();
	    home.clickCampaignsLink();
		
		CreateCampaignPage campPage = new CreateCampaignPage(driver);
		campPage.clickOnPlusSign();
	
		String campData = elib.getExcelData("Campaigns", 0, 0)+ranNum;
		campPage.enterCampaignName(prdData);

		CampWithPrdWindowSwitching Switching = new CampWithPrdWindowSwitching(driver);
		Switching.clickOnPrdPlusSign();
		
        wlib.windowHanling(driver, "Products&action");
	    
        Switching.enterPrdName(prdData);
        Switching.searchPrdName();
        
	//  driver.findElement(By.xpath("//a[text()='Bluetooth202']")).click();
	    
	 //   driver.findElement(By.xpath("//a[text()='"+prdData+"']")).click();
        Switching.prdDynamicElement(driver, prdData);
	
	    wlib.windowHanling(driver, "Campaigns&action");
	    
	    campPage.clickOnSaveButton();
			
		Thread.sleep(2000);
		home.logOut(driver);
		}



	}


