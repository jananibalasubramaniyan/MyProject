package DataDrivenTesting;

import java.io.FileInputStream;
import java.text.Format;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataUsingDataFormatter {

	public static void main(String[] args) {
		
		FileInputStream fis=new FileInputStream("C:\\Users\\Documents\\ExcelTestData.xlsx");
		
		Workbook book=WorkbookFactory.create(fis);
		
		Sheet sheet=book.getSheet("Sheet1");
		
		Row row=sheet.getRow(1);
		
		Cell cell=row.getCell(1);
		
		DataFormatter formatter=new DataFormatter();
		String excelData=Format.formatCellValue(cell);
		System.out.println(excelData);

}
}
