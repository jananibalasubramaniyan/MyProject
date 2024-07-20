package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class InsertSingleDataToExcelSheet {

	public static void main(String[] args) throws Throwable {
		
		FileInputStream fis=new FileInputStream("C:\\Users\\Documents\\ExcelTestData.xlsx");
		
		Workbook book=WorkbookFactory.create(fis);
		
		Sheet sheet=book.getSheet("Sheet1");
		
		Row row=sheet.createRow(3);
		
		Cell cell=row.createCell(3);
		
		cell.setCellValue("Bluetooth");
		
		FileOutputStream fos=new FileOutputStream("C:\\\\Users\\\\Documents\\\\ExcelTestData.xlsx");
		book.write(fos);
		book.close();

	}

}
