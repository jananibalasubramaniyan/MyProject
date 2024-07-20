package DataDrivenTesting;

import java.io.FileInputStream;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchingDataFromExcelUsingMap {

		
		public static void main(String[] args) throws Throwable {
			
			FileInputStream fis = new FileInputStream("./src/test/resources/ExcelTestData7pm.xlsx");

	        //step2:- keep Excel_File in Read mode
			Workbook book = WorkbookFactory.create(fis);
	        Sheet sheet = book.getSheet("Sheet2");
	        int rows = sheet.getLastRowNum();//50
	        System.out.println(rows);
		
	       LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		
	       for(int i=0;i<=rows;i++)
			{
				String key = sheet.getRow(i).getCell(0).toString();
				String value = sheet.getRow(i).getCell(1).toString();
				map.put(key, value);
			}
			
			for(Entry<String, String> m:map.entrySet())
			{
				System.out.println(m.getKey()+" "+m.getValue());
			}
		}
	}

	}

}
