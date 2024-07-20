package Organization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.github.dockerjava.api.model.Driver;

public class CreateCampaignWithProduct {

	public static void main(String[] args) throws Throwable  {
		
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Products")).click();
		
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		
		Random ran=new Random();
		int ranNum=ran.nextInt(1000);
		
		FileInputStream fis1=new FileInputStream("C:\\Users\\Documents\\Orgproducttestcase.xlsx");
		
		Workbook book1=WorkbookFactory.create(fis1);
		
		Sheet sheet1=book1.getSheet("Product");
		
		Row row1=sheet1.getRow(0);
		
		Cell cell1=row1.getCell(0);
		
		String prdDaata=cell1.getStringCellValue()+ranNum;
		
		driver.findElement(By.name("productname")).sendKeys(prdDaata);
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		driver.findElement(By.linkText("More")).click();
		driver.findElement(By.name("Campaigns")).click();
		driver.findElement(By.cssSelector("[alt='Create Campaign...']")).click();
		
		FileInputStream fis=new FileInputStream("C:\\Users\\Documents\\Orgproducttestcase.xlsx");
		
		Workbook book=WorkbookFactory.create(fis);

		Sheet sheet=book.getSheet("Product");
		
		Row row=sheet.getRow(0);
		
		Cell cell=row.getCell(0);
		
		String camData=cell.getStringCellValue()+ranNum;
		
		driver.findElement(By.name("campaignname")).sendKeys(camData);
		
		driver.findElement(By.xpath("//img[@alt='Select']")).click();
		
		Set<String>wins=driver.getWindowHandles();
		
		Iterator<String>it=wins.iterator();
		
		while(it.hasNext())
		{
			String win=it.next();
			driver.switchTo().window(win);
			String currentTitle=driver.getTitle();
			
			if(currentTitle.contains("Products&action"))
			{
				break;
			}
		}
		
		driver.findElement(By.name("search_text")).sendKeys(prdDaata);
		
		driver.findElement(By.name("search")).click();
		
		driver.findElement(By.xpath("//a[text()="+prdDaata+"]")).click();
		
		
		
		/*driver.findElement(By.name("campaignname")).sendKeys("PaperWorks");
		driver.findElement(By.cssSelector("[src='themes/softed/images/select.gif']")).click();
		
		driver.findElement(By.id("1")).click();*/
		


	}

	
}
