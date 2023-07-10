package Assignments;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TestDataWrite {

	public static void main(String[] args) throws Throwable {		
				//Step 1: Set the path
				//FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");
				FileInputStream fis = new FileInputStream("C:\\Users\\Hp\\Desktop\\TestData.xlsx");
				//Step 2: Open the workbook  in read mode
				Workbook book = WorkbookFactory.create(fis);
				//Step 3: get the control to the sheet
				Sheet sh = book.getSheet("Sheet2");
				//Step 4: get the control to the row
				Row row = sh.getRow(0);
				Cell cel = row.createCell(0);
				cel.setCellValue("Assignment1 Done");				
				//FileOutputStream fos = new FileOutputStream("./src/test/resources/TestData.xlsx");
				FileOutputStream fos = new FileOutputStream("C:\\Users\\Hp\\Desktop\\TestData.xlsx");
				book.write(fos);
				book.close();
	}
}
