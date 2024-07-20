package Campaign;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utitlity;
import Generic_Utility.WebDriver_Utility;
import Object_Repository.CreateCampaignPage;
import Object_Repository.CreateOrganizationPage;
import Object_Repository.CreateProductPage;
import Object_Repository.ValidationAndVerificationPage;
import Object_Repository.VtigerHomePage;
import Object_Repository.VtigerLoginPage;

//@Listeners(Generic_Utilities.ListernerImplementations.class)
public class CreateCampaignTest extends BaseClass {
//@Test(retryAnalyzer =Generic_Utilities.RetryAnalyserImp.class )
	
	@Test
	public void createCampaignsTest() throws Throwable {
       
		VtigerHomePage home = new VtigerHomePage(driver);
		home.clickMoreLink();
	//	http://Assert.fail();
		home.clickCampaignsLink();

		CreateCampaignPage campPage = new CreateCampaignPage(driver);
        campPage.clickOnPlusSign();
		Assert.assertEquals(false, true);
        int ranNum = jlib.getRandomNum();
        
        String campData = elib.getExcelDataUsingDataFormatter("Campaigns", 0, 0)+ranNum;
	    System.out.println(campData);
        campPage.enterCampaignName(campData);
	     campPage.clickOnSaveButton();

	    String actData = driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();
	    System.out.println(actData);
	    Thread.sleep(2000);
   //   Assert.assertEquals(actData, campData);
	   SoftAssert soft = new SoftAssert();
	//   soft.assertEquals(actData, campData);
	   
	   soft.assertAll();

}


}