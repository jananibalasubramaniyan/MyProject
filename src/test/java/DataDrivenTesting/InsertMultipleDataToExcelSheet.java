package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InsertMultipleDataToExcelSheet {

	public static void main(String[] args) throws Throwable {
		
		FileInputStream fis = new FileInputStream("./src/test/resources/ExcelTestData.xlsx");
		
		Workbook Book=WorkbookFactory.create(fis);
		
		Sheet sheet=Book.getSheet("Sheet1");
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
		
		List<WebElement> allLinks=driver.findElements(By.xpath("//a"));
		
		for(int i=0; i<allLinks.size(); i++)
		{
			Row row=sheet.createRow(i);
			Cell cell=row.createCell(0);
			cell.setCellValue(allLinks.get(i).getAttribute("href"));
			
		}

		FileOutputStream fos=new FileOutputStream("./src/test/resources/ExcelTestData.xlsx");
		Book.write(fos);
		Book.close();	}

}
