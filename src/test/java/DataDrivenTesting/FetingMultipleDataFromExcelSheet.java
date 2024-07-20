package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetingMultipleDataFromExcelSheet {

	public static void main(String[] args) throws Throwable {
		
		FileInputStream fis = new FileInputStream("./src/test/resources/ExcelTestData.xlsx");
		
		Workbook Book=WorkbookFactory.create(fis);
		
		Sheet sheet=Book.getSheet("Sheet1");
		
		int rowNum=sheet.getLastRowNum();
		System.out.println(rowNum);
		
		for(int i=0; i<rowNum; i++)
		{
			Row row=sheet.getRow(i);
			for(int j=0; j<row.getLastCellNum(); j++)
			{
				Cell cell=row.getCell(j);
				//String link=cell.getStringCellValue();
				//System.out.println(link);
				
				DataFormatter format=new DataFormatter();
				String link=format.formatCellValue(cell);
				System.out.println();
			}
			
		}

	}

}
