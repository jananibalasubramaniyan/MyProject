package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class FetchingDataFromProperties_File {

	public static void main(String[] args) throws Throwable {
	
		FileInputStream fis=new FileInputStream("C:\\Users\\Documents\\PropertiesFile.properties.txt");
		
		Properties pro=new Properties();
		
		pro.load(fis);
		String URl=pro.getProperty("url");
		String USERNAME=pro.getProperty("username");
		String PASSWORD=pro.getProperty("password");
		
		WebDriver driver=new ChromeDriver();
		driver.get(URl);
		driver.findElement(By.name("user-name")).sendKeys(USERNAME);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
		driver.findElement(By.className("btn_action")).click();
		
		

	}

}
