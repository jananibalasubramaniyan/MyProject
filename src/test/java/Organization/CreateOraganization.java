package Organization;

import java.time.Duration;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.bidi.module.Browser;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Generic_Utility.Excel_Utility;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utitlity;
import Generic_Utility.WebDriver_Utility;
import Object_Repository.ValidationAndVerificationPage;
import Object_Repository.VtigerHomePage;
import Object_Repository.VtigerLoginPage;

public class CreateOraganization {

	public static void main(String[] args) throws Throwable {
		
		File_Utility flib=new File_Utility();
		WebDriver_Utility wlib=new WebDriver_Utility();
		Excel_Utility elib=new Excel_Utility();
		Java_Utitlity jlib=new Java_Utitlity();
		WebDriver driver;
		String BROWSER=flib.getKeyAndValuePair("browser");
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
		home.clickOrganizationLink();
	
		//CreateOrganizationPage orgPage = new CreateOrganizationPage(driver);
		//orgPage.clickPlusImg();
		
	/*	int ranNum = jlib.getRandomNum();
        String orgData = elib.getExcelDataUsingDataFormatter("Organization", 0, 0)+ranNum;
        String phoneNum = elib.getExcelDataUsingDataFormatter("Organization", 1, 0);
        String emailId = elib.getExcelDataUsingDataFormatter("Organization", 2, 0);
	    Object orgPage;
		orgPage.enterOrganizationData(orgData, phoneNum, emailId);
		orgPage.clickOnSaveButton();
	
		ValidationAndVerificationPage orgValid = new ValidationAndVerificationPage(driver);
		orgValid.orgValidation(driver, orgData);*/
		
		
		home.logOut(driver);

	}
	

}