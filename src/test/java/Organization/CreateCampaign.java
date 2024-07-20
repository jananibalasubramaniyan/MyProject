package Organization;

import java.io.FileInputStream;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Generic_Utility.Excel_Utility;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utitlity;
import Generic_Utility.WebDriver_Utility;
import Object_Repository.VtigerLoginPage;

public class CreateCampaign {

	public static void main(String[] args) throws Throwable {

	//	WebDriver driver=new ChromeDriver();
		File_Utility flib=new File_Utility();
		WebDriver_Utility wlib=new WebDriver_Utility();
		Java_Utitlity jlib=new Java_Utitlity();
		Excel_Utility elib=new Excel_Utility();
		
		WebDriver driver;
		String Browser=flib.getKeyAndValuePair("browser");
		if(Browser.equalsIgnoreCase("chrome"))
		{
			 driver=new ChromeDriver();
        }
        else
        {
        if(Browser.equalsIgnoreCase("edge"))
       	 {
       		 driver=new EdgeDriver();
       	 }
      	 else
       	 {
       if(Browser.equalsIgnoreCase("firefox"))
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
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		VtigerLoginPage login = new VtigerLoginPage(driver);
//		login.getUserTextField().sendKeys(USERNAME);
//        login.getPasswWordTextField().sendKeys(PASSWORD);
//        login.getLoginButton().click();
		
		
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
//		FileInputStream fis = new FileInputStream("./src/test/resources/PropertiesFileData.properties");
//		Properties pro = new Properties();
//		pro.load(fis);
//		String URL = pro.getProperty("url");
//		String USERNAME = pro.getProperty("username");
//		String PASSWORD = pro.getProperty("password");
		
		
	//	String URL = flib.getKeyAndValuePair("url");
	//	String USERNAME =flib.getKeyAndValuePair("username");
    //	String PASSWORD = flib.getKeyAndValuePair("password");
		
	
		
		driver.findElement(By.linkText("More")).click();
		driver.findElement(By.linkText("Campaigns")).click();
		
		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		
		Random ran = new Random();
		int ranNum = ran.nextInt(1000);
		
		
		int ranNum1 = jlib.getRandomNum();
		
//		//Step1:- Path Connection of the physical File
//		FileInputStream fes = new FileInputStream("C:\\Users\\Documents\\Orgproducttestcase.xlsx");
//
//		        //step2:- keep Excel_File in Read mode
//		         Workbook book = WorkbookFactory.create(fes);
//			
//		         //step3:- get control of the sheet
//		         Sheet sheet = book.getSheet("Campaigns");
//		         
//		         //step4:- get control of the Row
//		         Row row = sheet.getRow(0);
//		         
//		         //step5:- get control of the Cell
//		         Cell cell = row.getCell(0);
//		         
//		         String campData = cell.getStringCellValue()+ranNum;
		
		
		String campData = elib.getExcelData("Campaigns", 0, 0)+ranNum1;
		
		driver.findElement(By.name("campaignname")).sendKeys(campData);
		
         driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.linkText("Sign Out")).click();
		

	}

}
