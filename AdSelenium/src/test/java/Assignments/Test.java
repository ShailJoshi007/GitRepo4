package Assignments;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Test {

	public static void main(String[] args) throws Throwable {
		String path = "D://DemoFile.xlsx";
		FileInputStream fis = new FileInputStream(path);
		Workbook book = WorkbookFactory.create(fis);
		
		Sheet sh = book.getSheet("Sheet1");
		int lastRow = sh.getLastRowNum();
		for(int i=0; i<=lastRow; i++){
		Row row = sh.getRow(i);
		Cell cell = row.createCell(2);

		cell.setCellValue("WriteintoExcel");

		}

		FileOutputStream fos = new FileOutputStream(path);
		book.write(fos);
		fos.close();
		}


}
