package Generic_Utility;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.mysql.jdbc.Driver;

import Object_Repository.VtigerHomePage;
import Object_Repository.VtigerLoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static TakesScreenshot sDriver;
	public WebDriver driver;
	public WebDriver sDriver1;
	public File_Utility flib = new File_Utility();
    public  WebDriver_Utility wlib = new WebDriver_Utility();
    public  Excel_Utility elib = new Excel_Utility();
    public Java_Utitlity jlib = new Java_Utitlity();
	
	@BeforeSuite
	public void BS() throws Throwable
	{
		//Step1:- Register/ load the mysql database
				Driver driverRef = new Driver();
				DriverManager.registerDriver(driverRef);
		System.out.println("DataBase Connection Open");
	}
	
	@BeforeTest
	public void BT()
	{
		System.out.println("parallel execution start");
	}
	
	@BeforeClass
	public void BC() throws Throwable
	{  
	 
		  String BROWSER=System.getProperty("browser");
	        System.out.println(BROWSER);
	        
	       // String BROWSER1 = flib.getKeyAndValuePair("browser");
	          if(BROWSER.equalsIgnoreCase("chrome"))
	          {
	        	  WebDriverManager.chromedriver().setup();
	        	  driver=new EdgeDriver();
    }
    else
    {
    if(BROWSER.equalsIgnoreCase("edge"))
   	 {
    	WebDriverManager.edgedriver().setup();
   		 driver=new EdgeDriver();
   	 }
  	 else
   	 {
   if(BROWSER.equalsIgnoreCase("firefox"))
   		{
	   WebDriverManager.firefoxdriver().setup();
   			driver=new FirefoxDriver();
   		}
   else
   		{
	   WebDriverManager.firefoxdriver().setup();
   			driver=new ChromeDriver();
   		}
   	 }
    }

		System.out.println("Browser Launched");
	}
	
	@BeforeMethod
	public void BM() throws Throwable
	{
		wlib.maximizingWindow(driver);
		wlib.implicity_Wait(driver);

		String URL = flib.getKeyAndValuePair("url");
		String USERNAME =flib.getKeyAndValuePair("username");
    	String PASSWORD = flib.getKeyAndValuePair("password");
		
		driver.get(URL);
		VtigerLoginPage login = new VtigerLoginPage(driver);
		login.loginToVitigerApp(USERNAME, PASSWORD);
		System.out.println("login to application");
	}
	
	@AfterMethod
	public void AM()
	{  VtigerHomePage home = new VtigerHomePage(driver);
		home.logOut(driver);
		System.out.println("logout from application");
	}
	@AfterClass
	public void AC()
	{
		driver.close();
		System.out.println("close the browser");
	}
	@AfterTest
	public void AT()
	{
		System.out.println("parallel execution done");
	}
	@AfterSuite
	public void AS() throws Throwable
	{
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_details","root" ,"root");
		conn.close();
		System.out.println("Data base closed");
	}
}