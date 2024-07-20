package Practice;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic_Utility.Excel_Utility;
import Generic_Utitlity.Java_Utitlity;

public class DataProviderEx3 {

	@Test(dataProvider ="getReadData")
	public void createOrganization(String orgNAme,String phnNum,String email) throws Throwable
	{
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.manage().window().maximize();
		driver.findElement(http://By.name("user_name")).sendKeys("admin");
		driver.findElement(http://By.name("user_password")).sendKeys("admin");
		driver.findElement(http://By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.cssSelector("[alt='Create Organization...']")).click();
		Java_Utitlity jlib = new Java_Utitlity();
		int ranNum = jlib.getRandomNum();
		driver.findElement(http://By.name("accountname")).sendKeys(orgNAme+ranNum);
		driver.findElement(http://By.id("phone")).sendKeys(phnNum);
		driver.findElement(http://By.id("email1")).sendKeys(email);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.linkText("Sign Out")).click();
		Thread.sleep(1000);
		driver.quit();
	}

@DataProvider
public Object[][] getReadData() throws Throwable
{
	
	Excel_Utility elib = new Excel_Utility();
	Object[][] values = elib.readDataUsingDataProvider("DataProvider");
	return values;
	
	
}
	
}
 