package Organization;

import java.io.FileInputStream;
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

import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utitlity;
import Generic_Utility.WebDriver_Utility;
import Object_Repository.CreateOrganizationPage;
import Object_Repository.CreateProductPage;
import Object_Repository.VtigerHomePage;
import Object_Repository.VtigerLoginPage;
@Listeners(Generic_Utility.ListenerImplementation.class)
public class CreateOrganizationTest extends BaseClass{

	@Test//(groups = {"smokeTest","regressionTest"})
	//@Test(retryAnalyzer = Generic_Utilities.RetryImplementation.class)
	public void createOrganizationTest() throws Throwable {
  VtigerHomePage home = new VtigerHomePage(driver);
  home.clickOrganizationLink();
 
 Object_Repository.CreateOrganizationPage orgPage = new CreateOrganizationPage(driver);
  orgPage.clickOrgPlusSign();
 // Assert.assertEquals(false, true);
 
  int ranNum = jlib.getRandomNum();
  String organizationData = elib.readExcelDataUsingDataFormatter("Organization", 0, 0)+ranNum;
  String phoneNum = elib.readExcelDataUsingDataFormatter("Organization", 2, 1);
  String emailId = elib.readExcelDataUsingDataFormatter("Organization", 3, 1); 
  orgPage.orgData(organizationData, phoneNum, emailId);
//  Assert.fail();
 orgPage.clickOnSaveButton();
  Thread.sleep(2000);
}
}


