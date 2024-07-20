package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class InsertDataToExcelUsingMap {

	public static void main(String[] args) throws Throwable {
		
FileInputStream fis = new FileInputStream("./src/test/resources/ExcelTestData.xlsx");
		
		Workbook Book=WorkbookFactory.create(fis);
		
		Sheet sheet=Book.getSheet("Sheet1");
		
		LinkedHashMap<String, String> map=new LinkedHashMap<String, String>();
		map.put("10", "janani");
		map.put("20", "balu");
		map.put("30", "saravana");
		map.put("40", "karthi");
		
		int romNo=0;
		for(Entry<String,String>m :map.entrySet())	
		{
				Row row=sheet.createRow(romNo++);
				row.createCell(0).setCellValue((String)m.getKey());
				row.createCell(1).setCellValue((String)m.getValue());
		
		}
		FileOutputStream fos=new FileOutputStream("./src/test/resources/ExcelTestData.xlsx");
		Book.write(fos);
		Book.close();	
	
		
	}

}
