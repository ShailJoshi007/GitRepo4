package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchingMultipleDataToExcel {

	public static void main(String[] args) throws Throwable {
		//Step 1: Set the path
		//FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");
		FileInputStream fis = new FileInputStream("C:\\Users\\Hp\\Desktop\\FlipkartDta.xlsx");
		//Step 2: Open the workbook  in read mode
		Workbook book = WorkbookFactory.create(fis);
		//Step 3: get the control to the sheet
		Sheet sh = book.getSheet("Sheet1");
		//Step 4: get the control to the row
		System.out.println(sh.getLastRowNum());
		
		for(int i=0;i<=sh.getLastRowNum();i++)
		{
		
			Row row = sh.getRow(i);
			for(int j=0;j<=row.getLastCellNum();j++)
			{
					Cell cel = row.getCell(j);
					DataFormatter format = new DataFormatter();
					String data = format.formatCellValue(cel);
					System.out.println(data);
			}
							
		}
	}
}
