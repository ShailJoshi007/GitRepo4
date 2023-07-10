package Practice;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ReadExcelData {

	public static void main(String[] args) throws Throwable {
		
		//FileInputStream fis = new FileInputStream("src/test/resources/TestData.xlsx");
		FileInputStream fis = new FileInputStream("C:\\Users\\Hp\\Desktop\\TestData.xlsx");
		
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet("Sheet1");
		Row row = sh.getRow(1);
		Cell cel = row.getCell(1);
		String data = cel.getStringCellValue();
		System.out.println(data);
		
		
	}

}
