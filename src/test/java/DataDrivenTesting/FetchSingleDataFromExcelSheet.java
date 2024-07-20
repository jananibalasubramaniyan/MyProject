package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchSingleDataFromExcelSheet {

	public static void main(String[] args) throws Throwable {
		
		FileInputStream fis=new FileInputStream("C:\\Users\\Documents\\ExcelTestData.xlsx");
		
		Workbook book=WorkbookFactory.create(fis);
		
		Sheet sheet=book.getSheet("Sheet1");
		
		Row row=sheet.getRow(4);
				
		Cell cell=row.getCell(1);
		
		String ExcelData=cell.getStringCellValue();
		
		System.out.println(ExcelData);
		
		

	}

}
