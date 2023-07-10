package Practice;

import java.io.FileInputStream;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataFormatterEx {

	public static void main(String[] args) throws Throwable {
		//FileInputStream fis = new FileInputStream("./src/test/resources/TestDataWrite1.xlsx");
		FileInputStream fis = new FileInputStream("C:\\Users\\Hp\\Documents\\TestDataWrite1.xlsx");
		
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet("Sheet1");
		
		Row row = sh.getRow(0);
		Cell cel = row.getCell(0);
		
		DataFormatter format = new DataFormatter();
		String data = format.formatCellValue(cel);
		System.out.println("Data from Excel is:"+data);
	}

}
