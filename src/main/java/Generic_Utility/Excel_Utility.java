package Generic_Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {

	public String getExcelData(String sheetName,int RowNum,int CellNum) throws Throwable 
	
	{
		
			FileInputStream fes=new FileInputStream("C:\\Users\\Documents\\Orgproducttestcase.xlsx");
			
			Workbook book=WorkbookFactory.create(fes);
			
			Sheet sheet=book.getSheet(sheetName);
			
			Row row=sheet.getRow(RowNum);
			
			Cell cell=row.getCell(CellNum);
			
			String ExcelData=cell.getStringCellValue();
			
			return ExcelData;
		}

	public Object[][] readDataUsingDataProvider(String SheetName) throws Throwable
	{
		FileInputStream fis=new FileInputStream("");
		
		Workbook book=WorkbookFactory.create(fis);
		
		Sheet sheet=book.getSheet(SheetName);
		
		int lastRow=sheet.getLastRowNum()+1;
		
		short lastCell=sheet.getRow(0).getLastCellNum();
		
		Object[][] objArr=new Object[lastRow][lastCell];
		
		for(int i=0; i<lastRow; i++)
		{
			for(int j=0; j<lastCell; j++)
			{
				objArr[i][j]=sheet.getRow(i).getCell(j).toString();
			}
		}
		
	return objArr;
	}

	public int readExcelDataUsingDataFormatter(String string, int i, int j) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
		}

